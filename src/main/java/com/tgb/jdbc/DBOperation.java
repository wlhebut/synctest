package com.tgb.jdbc;

 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.tgb.entity.DB;

/**
 * 数据库操作工具类
 * 
 * @author zhangpeng
 */
public class DBOperation {
	
	/**
	 * 获取数据库链接
	 * @param bean DB 数据库连接参数
	 * @return Connection
	 * @throws Exception
	 */
	public static Connection getCon(DB bean) {
		try {
			if ("jdbc".equals(bean.getType())) {
				Class.forName(bean.getDriver()).newInstance();
				return DriverManager.getConnection(bean.getUrl(), bean.getUsername(), bean.getPassword());
			} else if ("jndi".equals(bean.getType())) {
				Context ic = new InitialContext();
				DataSource source = (DataSource) ic.lookup(bean.getJndiName());
				return source.getConnection();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * SQL 查询将查询结果直接放入ResultSet中
	 * @param sql SQL语句
	 * @param params 参数数组，若没有参数则为null
	 * @return 结果集
	 * @throws SQLException
	 */
	private static ResultSet executeQueryRS(Connection con, String sql, Object[] params) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = con.prepareStatement(sql);
//		System.out.println(sql);
		if (params != null)
			for (int i = 0; i < params.length; i++) {
				if (params[i].getClass().toString().equals("class java.util.Date")) {
					Date d = (Date) params[i];
					java.sql.Date sqlDate = new java.sql.Date(d.getTime());
					ps.setObject(i + 1, sqlDate);
					continue;
				}

				ps.setObject(i + 1, params[i]);
			}
		rs = ps.executeQuery();
		return rs;
	}

	/**
	 * 获取结果集，并将结果放在List中
	 * @param con 数据库链接对象
	 * @param sql SQL语句
	 * @param params 参数
	 * @return List 结果集
	 * @throws SQLException
	 */
	public static List<Map<String, Object>> excuteQuery(DB db, String sql, Object[] params) throws SQLException {
		Connection con = getCon(db);
		if (con == null){
			return null;
		}
		// 执行SQL获得结果集
		ResultSet rs = executeQueryRS(con, sql, params);
		ResultSetMetaData rsmd = null;
		Map<String, Object> map = null;
		// 结果集列数
		int columnCount = 0;
		rsmd = rs.getMetaData();
		// 获得结果集列数
		columnCount = rsmd.getColumnCount();
		// 创建List
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// 将ResultSet的结果保存到List中
		while (rs.next()) {
			map = new HashMap<String, Object>();
			for (int i = 1; i <= columnCount; i++) {
				if (rs.getObject(i) != null) {
					if (rs.getObject(i).getClass().toString().equals("class java.sql.Date")) {
						map.put(rsmd.getColumnLabel(i), rs.getTimestamp(i));
						continue;
					}
				}
				map.put(rsmd.getColumnLabel(i), rs.getObject(i));
			}
			list.add(map);
		}
		SQLMethod.ResultSetClose(rs, con);
		return list;
	}

	/**
	 * 更新数据库
	 * @param con 数据库链接对象
	 * @param sql SQL语句
	 * @param params 参数
	 * @return int 操作结果
	 * @throws SQLException
	 */
	public static int update(DB db, String sql, Object[] params) throws SQLException {
		Connection con = getCon(db);
		if (con == null)
			return -1;
		PreparedStatement ps = null;
		ps = con.prepareStatement(sql);
		if (params != null)
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i] == null ? "" : params[i]);
			}
		int type = ps.executeUpdate();
		SQLMethod.PreparedStatementClose(ps);
		return type;
	}
}
