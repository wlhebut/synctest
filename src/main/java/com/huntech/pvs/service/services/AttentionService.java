package com.huntech.pvs.service.services;


import java.util.List;

//关注
public interface AttentionService {

    //    根据openid获取关注的私服

    List<Long> getAttentionsByOpenId(String openid);

}
