package com.huntech.pvs.dao.services;

import com.huntech.pvs.model.services.ServStar;
import com.huntech.pvs.model.services.ServStarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServStarMapper {
    int countByExample(ServStarExample example);

    int deleteByExample(ServStarExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ServStar record);

    int insertSelective(ServStar record);

    List<ServStar> selectByExample(ServStarExample example);

    ServStar selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ServStar record, @Param("example") ServStarExample example);

    int updateByExample(@Param("record") ServStar record, @Param("example") ServStarExample example);

    int updateByPrimaryKeySelective(ServStar record);

    int updateByPrimaryKey(ServStar record);
}