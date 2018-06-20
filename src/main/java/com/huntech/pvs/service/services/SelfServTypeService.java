package com.huntech.pvs.service.services;

import com.huntech.pvs.model.services.BaseServType;
import com.huntech.pvs.model.services.SelfBaseServType;

import java.util.List;

public interface SelfServTypeService {

//    List<BaseServType> selectByServTypeByOpenId(String openid);

    Integer insertAllType(String openid);
}
