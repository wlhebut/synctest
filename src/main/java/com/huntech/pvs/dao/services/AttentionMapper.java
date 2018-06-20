package com.huntech.pvs.dao.services;

import com.huntech.pvs.model.services.Attention;
import com.huntech.pvs.model.services.AttentionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttentionMapper {
    int countByExample(AttentionExample example);

    int deleteByExample(AttentionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Attention record);

    int insertSelective(Attention record);

    List<Attention> selectByExample(AttentionExample example);

    Attention selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Attention record, @Param("example") AttentionExample example);

    int updateByExample(@Param("record") Attention record, @Param("example") AttentionExample example);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);
}