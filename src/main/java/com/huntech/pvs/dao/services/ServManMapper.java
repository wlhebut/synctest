package com.huntech.pvs.dao.services;

import com.huntech.pvs.model.services.ServMan;
import com.huntech.pvs.model.services.ServManExample;
import java.util.List;
import java.util.Map;

import com.huntech.pvs.view.services.BaseServTypeView;
import org.apache.ibatis.annotations.Param;

public interface ServManMapper {
    int countByExample(ServManExample example);

    int deleteByExample(ServManExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ServMan record);

    int insertSelective(ServMan record);

    List<ServMan> selectByExample(ServManExample example);
    List<BaseServTypeView> selectCountByServType(Map<String,Object> params);

    ServMan selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ServMan record, @Param("example") ServManExample example);

    int updateByExample(@Param("record") ServMan record, @Param("example") ServManExample example);

    int updateByPrimaryKeySelective(ServMan record);

    int updateByPrimaryKey(ServMan record);
}