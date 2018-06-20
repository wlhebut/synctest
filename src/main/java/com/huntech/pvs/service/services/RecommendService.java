package com.huntech.pvs.service.services;

import java.util.List;

public interface RecommendService {

//    根据openid获取推荐的私服
List<Long> getRecommendsByOpenId(String openid);
}
