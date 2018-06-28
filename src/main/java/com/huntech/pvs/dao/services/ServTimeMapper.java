package com.huntech.pvs.dao.services;

import com.huntech.pvs.model.services.ServTime;
import com.huntech.pvs.model.services.ServTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServTimeMapper {
    int countByExample(ServTimeExample example);

    int deleteByExample(ServTimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServTime record);

    int insertSelective(ServTime record);

    List<ServTime> selectByExample(ServTimeExample example);

    ServTime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ServTime record, @Param("example") ServTimeExample example);

    int updateByExample(@Param("record") ServTime record, @Param("example") ServTimeExample example);

    int updateByPrimaryKeySelective(ServTime record);

    int updateByPrimaryKey(ServTime record);
}