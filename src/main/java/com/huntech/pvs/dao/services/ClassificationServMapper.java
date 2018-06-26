package com.huntech.pvs.dao.services;

import com.huntech.pvs.model.services.ClassificationServ;
import com.huntech.pvs.model.services.ClassificationServExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassificationServMapper {
    int countByExample(ClassificationServExample example);

    int deleteByExample(ClassificationServExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClassificationServ record);

    int insertSelective(ClassificationServ record);

    List<ClassificationServ> selectByExample(ClassificationServExample example);

    ClassificationServ selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ClassificationServ record, @Param("example") ClassificationServExample example);

    int updateByExample(@Param("record") ClassificationServ record, @Param("example") ClassificationServExample example);

    int updateByPrimaryKeySelective(ClassificationServ record);

    int updateByPrimaryKey(ClassificationServ record);
}