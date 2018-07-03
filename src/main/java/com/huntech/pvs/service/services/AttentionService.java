package com.huntech.pvs.service.services;


import com.huntech.pvs.model.services.Attention;

import java.util.List;

//关注
public interface AttentionService {

    //    根据openid获取关注的私服

    List<Long> getAttentionsByOpenId(String openid);

    Integer getAttentionCount(Attention attention);


    Integer insert(Attention attention);
    Integer update(Attention attention);
    Integer delete(Attention attention);
}
