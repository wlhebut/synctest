package com.huntech.pvs.service.services;

import com.huntech.pvs.model.services.MyBaseservType;
import com.huntech.pvs.view.request.MyServsRequest;
import com.huntech.pvs.view.services.MyServViews;

import java.util.List;

public interface MyBaseServTypeService {

    List<MyServViews> selectAllServsByOpenid(MyServsRequest myServsRequest);

    int updateByTypeId(MyBaseservType myServsRequest);
}
