package com.huntech.pvs.service.services;

import com.huntech.pvs.model.services.ServManGps;

import java.util.List;

public interface ServManGpsService {

    ServManGps getServManGps(Long serManId);
    List<ServManGps> getServManGps(List<Object> ids);

    int saveServManGpa(ServManGps servManGps);


}
