package com.huntech.pvs.dao.services;

import com.huntech.pvs.model.services.Satis;
import com.huntech.pvs.model.services.SatisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SatisMapper {
    int countByExample(SatisExample example);

    int deleteByExample(SatisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Satis record);

    int insertSelective(Satis record);

    List<Satis> selectByExample(SatisExample example);

    Satis selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Satis record, @Param("example") SatisExample example);

    int updateByExample(@Param("record") Satis record, @Param("example") SatisExample example);

    int updateByPrimaryKeySelective(Satis record);

    int updateByPrimaryKey(Satis record);
}