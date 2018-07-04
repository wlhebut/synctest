package com.huntech.pvs.service.services;

import com.huntech.pvs.model.services.MyServs;
import com.huntech.pvs.view.request.MyServsDelRequest;
import com.huntech.pvs.view.request.MyServsRequest;

public interface MyServsService {
    int insertMyServs(MyServsRequest myServs);
    int deleteMyServs(MyServsDelRequest myServs);
    MyServs getMyServById(Long id);
    int updateMyServById(MyServs myServs);

}
