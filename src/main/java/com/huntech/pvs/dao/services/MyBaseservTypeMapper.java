package com.huntech.pvs.dao.services;

import com.huntech.pvs.core.feature.orm.mybatis.Page;
import com.huntech.pvs.model.services.MyBaseservType;
import com.huntech.pvs.model.services.MyBaseservTypeExample;
import java.util.List;
import java.util.Map;

import com.huntech.pvs.model.services.MyServs;
import com.huntech.pvs.view.services.MyServViews;
import com.huntech.pvs.view.services.ServView;
import org.apache.ibatis.annotations.Param;

public interface MyBaseservTypeMapper {
    int countByExample(MyBaseservTypeExample example);

    int deleteByExample(MyBaseservTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MyBaseservType record);

    int insertSelective(MyBaseservType record);

    List<MyBaseservType> selectByExample(MyBaseservTypeExample example);
    List<MyServs> selectMyServViews(Map<String, Object> params);

    MyBaseservType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MyBaseservType record, @Param("example") MyBaseservTypeExample example);

    int updateByExample(@Param("record") MyBaseservType record, @Param("example") MyBaseservTypeExample example);

    int updateByPrimaryKeySelective(MyBaseservType record);

    int updateByPrimaryKey(MyBaseservType record);
}