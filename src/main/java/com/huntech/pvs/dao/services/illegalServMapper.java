package com.huntech.pvs.dao.services;

import com.huntech.pvs.model.services.illegalServ;
import com.huntech.pvs.model.services.illegalServExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface illegalServMapper {
    int countByExample(illegalServExample example);

    int deleteByExample(illegalServExample example);

    int deleteByPrimaryKey(Long id);

    int insert(illegalServ record);

    int insertSelective(illegalServ record);

    List<illegalServ> selectByExample(illegalServExample example);

    illegalServ selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") illegalServ record, @Param("example") illegalServExample example);

    int updateByExample(@Param("record") illegalServ record, @Param("example") illegalServExample example);

    int updateByPrimaryKeySelective(illegalServ record);

    int updateByPrimaryKey(illegalServ record);
}