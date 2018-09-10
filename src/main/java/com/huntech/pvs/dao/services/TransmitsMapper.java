package com.huntech.pvs.dao.services;

import com.huntech.pvs.model.services.Transmits;
import com.huntech.pvs.model.services.TransmitsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransmitsMapper {
    int countByExample(TransmitsExample example);

    int deleteByExample(TransmitsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Transmits record);

    int insertSelective(Transmits record);

    List<Transmits> selectByExample(TransmitsExample example);

    Transmits selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Transmits record, @Param("example") TransmitsExample example);

    int updateByExample(@Param("record") Transmits record, @Param("example") TransmitsExample example);

    int updateByPrimaryKeySelective(Transmits record);

    int updateByPrimaryKey(Transmits record);
}