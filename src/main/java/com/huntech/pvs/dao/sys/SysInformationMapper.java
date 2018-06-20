package com.huntech.pvs.dao.sys;

import com.huntech.pvs.core.feature.orm.mybatis.Page;
import com.huntech.pvs.core.generic.GenericDao;
import com.huntech.pvs.model.sys.SysInformation;
import com.huntech.pvs.model.sys.SysInformationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysInformationMapper extends GenericDao<SysInformation,Long> {
    int countByExample(SysInformationExample example);

    int deleteByExample(SysInformationExample example);

    int deleteByPrimaryKey(Long sid);

    int insert(SysInformation record);

    int insertSelective(SysInformation record);

    List<SysInformation> selectByExample(SysInformationExample example);

    SysInformation selectByPrimaryKey(Long sid);

    int updateByExampleSelective(@Param("record") SysInformation record, @Param("example") SysInformationExample example);

    int updateByExample(@Param("record") SysInformation record, @Param("example") SysInformationExample example);

    int updateByPrimaryKeySelective(SysInformation record);

    int updateByPrimaryKey(SysInformation record);

    List<SysInformation> selectByExampleByPage(Page<SysInformation> page, SysInformationExample example);
}