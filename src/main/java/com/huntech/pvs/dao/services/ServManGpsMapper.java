package com.huntech.pvs.dao.services;

import com.huntech.pvs.model.services.ServManGps;
import com.huntech.pvs.model.services.ServManGpsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServManGpsMapper {
    int countByExample(ServManGpsExample example);

    int deleteByExample(ServManGpsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ServManGps record);

    int insertSelective(ServManGps record);

    List<ServManGps> selectByExample(ServManGpsExample example);

    ServManGps selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ServManGps record, @Param("example") ServManGpsExample example);

    int updateByExample(@Param("record") ServManGps record, @Param("example") ServManGpsExample example);

    int updateByPrimaryKeySelective(ServManGps record);

    int updateByPrimaryKey(ServManGps record);
}