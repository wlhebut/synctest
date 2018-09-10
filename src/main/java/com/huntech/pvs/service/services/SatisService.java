package com.huntech.pvs.service.services;

import com.huntech.pvs.model.services.Satis;

import java.util.List;

public interface SatisService {

    void updateSatis(Satis satis);

    Satis  getSatisByServId(Long servId);

//    List<Satis> getAllServ();
}
