package com.huntech.pvs.dao.services;

import com.huntech.pvs.model.services.MyServs;
import com.huntech.pvs.model.services.MyServsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyServsMapper {
    int countByExample(MyServsExample example);

    int deleteByExample(MyServsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MyServs record);

    int insertSelective(MyServs record);

    List<MyServs> selectByExample(MyServsExample example);

    MyServs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MyServs record, @Param("example") MyServsExample example);

    int updateByExample(@Param("record") MyServs record, @Param("example") MyServsExample example);

    int updateByPrimaryKeySelective(MyServs record);

    int updateByPrimaryKey(MyServs record);
}