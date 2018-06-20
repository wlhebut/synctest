package com.huntech.pvs.dao.services;

import com.huntech.pvs.model.services.ServContent;
import com.huntech.pvs.model.services.ServContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServContentMapper {
    int countByExample(ServContentExample example);

    int deleteByExample(ServContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ServContent record);

    int insertSelective(ServContent record);

    List<ServContent> selectByExample(ServContentExample example);

    ServContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ServContent record, @Param("example") ServContentExample example);

    int updateByExample(@Param("record") ServContent record, @Param("example") ServContentExample example);

    int updateByPrimaryKeySelective(ServContent record);

    int updateByPrimaryKey(ServContent record);
}