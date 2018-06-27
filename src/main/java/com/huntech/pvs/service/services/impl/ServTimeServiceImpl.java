package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.dao.services.ServTimeMapper;
import com.huntech.pvs.model.services.ServTime;
import com.huntech.pvs.service.services.ServTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServTimeServiceImpl implements ServTimeService {
    @Autowired
    private ServTimeMapper servTimeMapper;
    @Override
    public List<ServTime> getAllServTime() {
        List<ServTime> servTimes = servTimeMapper.selectByExample(null);
        return servTimes;
    }
}
