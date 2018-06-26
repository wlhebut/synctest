package com.huntech.pvs.dao.services;

import com.huntech.pvs.model.services.ServOrder;
import com.huntech.pvs.model.services.ServOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServOrderMapper {
    int countByExample(ServOrderExample example);

    int deleteByExample(ServOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ServOrder record);

    int insertSelective(ServOrder record);

    List<ServOrder> selectByExample(ServOrderExample example);

    ServOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ServOrder record, @Param("example") ServOrderExample example);

    int updateByExample(@Param("record") ServOrder record, @Param("example") ServOrderExample example);

    int updateByPrimaryKeySelective(ServOrder record);

    int updateByPrimaryKey(ServOrder record);
}