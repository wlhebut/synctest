package com.huntech.pvs.service.services;

import com.huntech.pvs.model.services.ServMan;
import com.huntech.pvs.view.request.AddressRequest;
import com.huntech.pvs.view.request.ServManRequest;
import com.huntech.pvs.view.services.BaseServTypeView;
import com.huntech.pvs.view.services.ServManView;

import java.util.List;

public interface ServManService {

    List<ServMan> getServMan();
    List<ServManView> getServMan(ServManRequest servManRequest);
    List<ServMan> getServMan(List<Object> ids);
    List<BaseServTypeView> getBaseServTypeView(AddressRequest addressRequest);

}
