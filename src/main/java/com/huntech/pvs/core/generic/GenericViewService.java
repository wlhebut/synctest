package com.huntech.pvs.core.generic;

import com.huntech.pvs.core.feature.orm.mybatis.Page;

import java.util.List;

/**
 * 所有自定义Service的顶级接口,封装常用的增删查改操作
 * <p/>
 * Model : 代表数据库中的表 映射的Java对象类型
 * PK :代表对象的主键类型
 *
 * @author CCL
 * @since 2014年6月9日 下午6:14:06
 */
public interface GenericViewService<Model, PK> {

    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return model 对象
     */
    Model selectById(PK id);


    /**
     * 查询单个对象
     *
     * @return 对象
     */
    Model selectOne();


    /**
     * 查询多个对象
     *
     * @return 对象集合
     */
    List<Model> selectList();


    /**
     * 分页查询
     * @param page
     * @param object
     * @return
     */
    List<Model> selectByExampleAndPage(Page<Model> page, Object object);

}
