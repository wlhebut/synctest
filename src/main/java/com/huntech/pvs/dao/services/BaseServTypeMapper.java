package com.huntech.pvs.dao.services;

import com.huntech.pvs.model.services.BaseServType;
import com.huntech.pvs.model.services.BaseServTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseServTypeMapper {
    int countByExample(BaseServTypeExample example);

    int deleteByExample(BaseServTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseServType record);

    int insertSelective(BaseServType record);

    List<BaseServType> selectByExample(BaseServTypeExample example);

    BaseServType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseServType record, @Param("example") BaseServTypeExample example);

    int updateByExample(@Param("record") BaseServType record, @Param("example") BaseServTypeExample example);

    int updateByPrimaryKeySelective(BaseServType record);

    int updateByPrimaryKey(BaseServType record);
}