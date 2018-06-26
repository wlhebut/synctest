package com.huntech.pvs.dao.services;

import com.huntech.pvs.model.services.DisServ;
import com.huntech.pvs.model.services.DisServExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DisServMapper {
    int countByExample(DisServExample example);

    int deleteByExample(DisServExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DisServ record);

    int insertSelective(DisServ record);

    List<DisServ> selectByExample(DisServExample example);

    DisServ selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DisServ record, @Param("example") DisServExample example);

    int updateByExample(@Param("record") DisServ record, @Param("example") DisServExample example);

    int updateByPrimaryKeySelective(DisServ record);

    int updateByPrimaryKey(DisServ record);
}