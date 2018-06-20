package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.dao.services.ServManGpsMapper;
import com.huntech.pvs.model.services.ServManGps;
import com.huntech.pvs.model.services.ServManGpsExample;
import com.huntech.pvs.service.services.ServManGpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServManGpsServiceImpl implements ServManGpsService {
    @Autowired
    private ServManGpsMapper servManGpsMapper;
    @Override
    public List<ServManGps> getServManGps() {
        return null;
    }

    @Override
    public List<ServManGps> getServManGps(List<Object> ids) {
        List<Long> longs=(List<Long>)(List) ids;
        ServManGpsExample example = new ServManGpsExample();
        ServManGpsExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(longs);
        List<ServManGps> servManGps = servManGpsMapper.selectByExample(example);
        return servManGps;
    }
}
