package com.huntech.pvs.dao.sys;

import com.huntech.pvs.core.feature.orm.mybatis.Page;
import com.huntech.pvs.core.generic.GenericDao;
import com.huntech.pvs.dto.sys.User;
import com.huntech.pvs.dto.sys.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends GenericDao<User, Long> {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long sid);

    int insert(User record);

    int insertSelective(User record);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);



    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long sid);

    /**
     * 用户登录验证查询
     *
     * @param record
     * @return
     */
    User authentication(@Param("record") User record);

    /**
     * 分页条件查询
     *
     * @param page
     * @param example
     * @return
     */
    List<User> selectByExampleAndPage(Page<User> page, UserExample example);

    /**
     * 分页查询，按照用户名称
     *
     * */
    List<User> selectPageByName(Page<User> page, UserExample example);
}