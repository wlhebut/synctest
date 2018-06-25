package com.huntech.pvs.service.services;

import com.huntech.pvs.model.services.ServMan;
import com.huntech.pvs.view.request.AddressRequest;
import com.huntech.pvs.view.request.ServManRequest;
import com.huntech.pvs.view.services.BaseServTypeView;
import com.huntech.pvs.view.services.ServManView;

import java.util.List;

public interface ServManService {

    ServMan getServMan(String openid);
    ServMan getServManByPriKey(Long id);
    List<ServManView> getServMan(ServManRequest servManRequest);
    List<ServMan> getServMan(List<Object> ids);

    int updateByPriKey(ServMan man);
//    List<BaseServTypeView> getBaseServTypeView(AddressRequest addressRequest);

}
