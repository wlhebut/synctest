package com.huntech.pvs.dao.services;

import com.huntech.pvs.model.services.SelfBaseServType;
import com.huntech.pvs.model.services.SelfBaseServTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SelfBaseServTypeMapper {
    int countByExample(SelfBaseServTypeExample example);

    int deleteByExample(SelfBaseServTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SelfBaseServType record);

    int insertSelective(SelfBaseServType record);

    List<SelfBaseServType> selectByExample(SelfBaseServTypeExample example);

    SelfBaseServType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SelfBaseServType record, @Param("example") SelfBaseServTypeExample example);

    int updateByExample(@Param("record") SelfBaseServType record, @Param("example") SelfBaseServTypeExample example);

    int updateByPrimaryKeySelective(SelfBaseServType record);

    int updateByPrimaryKey(SelfBaseServType record);
}