package com.huntech.pvs.core.generic;

import com.huntech.pvs.core.feature.orm.mybatis.Page;

import java.util.List;

/**
 * GenericService的实现类, 其他的自定义 ServiceImpl, 继承自它,可以获得常用的增删查改操作,
 * 未实现的方法有 子类各自实现
 * <p/>
 * Model : 代表数据库中的表 映射的Java对象类型
 * PK :代表对象的主键类型
 *
 * @author deviceName
 * @since 2014年6月9日 下午6:14:06
 */
public abstract class GenericViewServiceImpl<Model, PK> implements GenericViewService<Model, PK> {

    /**
     * 定义成抽象方法,由子类实现,完成dao的注入
     *
     * @return GenericDao实现类
     */
    public abstract GenericViewDao<Model, PK> getViewDao();

    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return
     */
    public Model selectById(PK id) {
        return getViewDao().selectByPrimaryKey(id);
    }


    @Override
    public Model selectOne() {
        return null;
    }

    @Override
    public List<Model> selectList() {
        return null;
    }

    public List<Model> selectByExampleAndPage(Page<Model> page, Object object){

        return getViewDao().selectByExampleAndPage(page,object);
    }
}
