package com.huntech.pvs.dao.services;

import com.huntech.pvs.core.feature.orm.mybatis.Page;
import com.huntech.pvs.model.services.Serv;
import com.huntech.pvs.model.services.ServExample;
import java.util.List;
import java.util.Map;

import com.huntech.pvs.view.services.DetailServView;
import com.huntech.pvs.view.services.ServView;
import org.apache.ibatis.annotations.Param;

public interface ServMapper {
    List<ServView> selectServsView(Page<ServView> servPage,Map<String, Object> params);
    List<ServView> selectAttentionServsView(Page<ServView> servPage,Map<String, Object> params);

    int countByExample(ServExample example);
    Integer selectServsViewCount(Map<String, Object> params);
    Integer selectPrimServsViewCount(Map<String, Object> params);
    DetailServView getDetailServsView(Map<String, Object> params);

    int deleteByExample(ServExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Serv record);

    int insertSelective(Serv record);

    List<Serv> selectByExample(ServExample example);
    List<Serv> selectByExampleAndPage(Page<Serv> servPage, ServExample example);

    Serv selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Serv record, @Param("example") ServExample example);

    int updateByExample(@Param("record") Serv record, @Param("example") ServExample example);

    int updateByPrimaryKeySelective(Serv record);

    int updateByPrimaryKey(Serv record);
}