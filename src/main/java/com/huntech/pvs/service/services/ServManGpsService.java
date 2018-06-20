package com.huntech.pvs.service.services;

import com.huntech.pvs.model.services.ServManGps;

import java.util.List;

public interface ServManGpsService {

    List<ServManGps> getServManGps();
    List<ServManGps> getServManGps(List<Object> ids);


}
