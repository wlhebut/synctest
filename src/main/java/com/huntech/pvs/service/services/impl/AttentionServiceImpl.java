package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.dao.services.AttentionMapper;
import com.huntech.pvs.model.services.Attention;
import com.huntech.pvs.model.services.AttentionExample;
import com.huntech.pvs.service.services.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @Description:关注
* @Param:
* @return:
* @Author: Mr.Wang
* @Date: 2018/6/18
*/
@Service
public class AttentionServiceImpl implements AttentionService {

    @Autowired
    private AttentionMapper  attentionMapper;
    @Override
    public List<Long> getAttentionsByOpenId(String openid) {
        AttentionExample example = new AttentionExample();
        AttentionExample.Criteria criteria = example.createCriteria();
        if(openid!=null&&!openid.equals("")){
            criteria.andOpenidEqualTo(openid);
        }
        ArrayList<Long> longs = new ArrayList<>();
        List<Attention> attentions = attentionMapper.selectByExample(example);
        for (Attention attention : attentions) {
            longs.add(attention.getServid());
        }
        return longs;
    }

    @Override
    public Integer getAttentionCount(Attention attention) {
        AttentionExample example = new AttentionExample();
        AttentionExample.Criteria criteria = example.createCriteria();
        if(null!=attention.getOpenid()&&!attention.getOpenid().equals("")){
            criteria.andOpenidEqualTo(attention.getOpenid());
        }

        if(attention.getServid()!=null){
            criteria.andServidEqualTo(attention.getServid());
        }
        int i = attentionMapper.countByExample(example);
        return i;
    }

    @Override
    public Integer insert(Attention attention) {
        int i = attentionMapper.insertSelective(attention);
        return i;
    }
}
