package com.huntech.pvs.dao.services;

import com.huntech.pvs.model.services.SelfServ;
import com.huntech.pvs.model.services.SelfServExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SelfServMapper {
    int countByExample(SelfServExample example);

    int deleteByExample(SelfServExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SelfServ record);

    int insertSelective(SelfServ record);

    List<SelfServ> selectByExample(SelfServExample example);

    SelfServ selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SelfServ record, @Param("example") SelfServExample example);

    int updateByExample(@Param("record") SelfServ record, @Param("example") SelfServExample example);

    int updateByPrimaryKeySelective(SelfServ record);

    int updateByPrimaryKey(SelfServ record);
}