package com.huntech.pvs.core.generic;

import com.huntech.pvs.core.feature.orm.mybatis.Page;

import java.util.List;

/**
 * 所有自定义Dao的顶级接口, 封装常用的增删查改操作,
 * 可以通过Mybatis Generator Maven 插件自动生成Dao,
 * 也可以手动编码,然后继承GenericDao 即可.
 * <p/>
 * Model : 代表数据库中的表 映射的Java对象类型
 * PK :代表对象的主键类型
 *
 * @author deviceName
 * @since 2014年6月9日 下午6:14:06
 */
public interface GenericViewDao<Model, PK> {

    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return
     */
    Model selectByPrimaryKey(PK id);

    List<Model> selectByExampleAndPage(Page<Model> page, Object object);
}
