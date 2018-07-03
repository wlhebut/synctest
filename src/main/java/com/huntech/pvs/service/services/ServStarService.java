package com.huntech.pvs.service.services;

import com.huntech.pvs.model.services.ServStar;

public interface ServStarService {
    ServStar getServStarByServId(Long servId);
    int updateByPrimaryKey(ServStar servStar);

    int insertSelective(ServStar servStar);
}
