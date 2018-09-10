package com.huntech.pvs.service.services;

import com.huntech.pvs.model.services.BaseServType;
import com.huntech.pvs.view.request.BaseServTypeRequest;

import java.util.List;

public interface BaseServTypeService {

    List<BaseServType> getBaseServType(BaseServType baseServType);

    BaseServType getBaseServTypeById(Long id);


    Integer updateByOpenId(BaseServTypeRequest baseServTypes);

    List<BaseServType> getBaseServTypeByOpenId(BaseServTypeRequest baseServType);

    List<BaseServType> getOtherBaseServTypeByOpenId(BaseServTypeRequest baseServType);

    List<BaseServType> getBaseServTypeAnon();

}
