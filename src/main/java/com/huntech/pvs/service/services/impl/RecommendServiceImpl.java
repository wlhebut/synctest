package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.dao.services.RecommendMapper;
import com.huntech.pvs.model.services.Attention;
import com.huntech.pvs.model.services.Recommend;
import com.huntech.pvs.model.services.RecommendExample;
import com.huntech.pvs.service.services.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//推荐
@Service
public class RecommendServiceImpl implements RecommendService {
    @Autowired
    private RecommendMapper recommendMapper;

    @Override
    public List<Long> getRecommendsByOpenId(String openid) {

        RecommendExample recommendExample = new RecommendExample();
        RecommendExample.Criteria criteria = recommendExample.createCriteria();
        if(openid!=null&&!openid.equals("")){
            criteria.andOpenidEqualTo(openid);
        }
        ArrayList<Long> longs = new ArrayList<>();
        List<Recommend> recommends = recommendMapper.selectByExample(recommendExample);
        for (Recommend recommend : recommends) {
            longs.add(recommend.getServid());
        }
        return longs;
    }
}
