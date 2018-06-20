package com.huntech.pvs.dao.sys;

import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.model.sys.WeiXinUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeiXinUserMapper {
    int countByExample(WeiXinUserExample example);

    int deleteByExample(WeiXinUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WeiXinUser record);

    int insertSelective(WeiXinUser record);

    List<WeiXinUser> selectByExample(WeiXinUserExample example);

    WeiXinUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WeiXinUser record, @Param("example") WeiXinUserExample example);

    int updateByExample(@Param("record") WeiXinUser record, @Param("example") WeiXinUserExample example);

    int updateByPrimaryKeySelective(WeiXinUser record);

    int updateByPrimaryKey(WeiXinUser record);
}