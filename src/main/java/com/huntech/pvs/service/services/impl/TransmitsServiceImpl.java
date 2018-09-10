package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.dao.services.TransmitsMapper;
import com.huntech.pvs.model.services.Transmits;
import com.huntech.pvs.service.services.TransmitsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TransmitsServiceImpl implements TransmitsService {

    @Autowired
    private TransmitsMapper transmitsMapper;

    @Override
    public int insertSelective(Transmits transmits) {
        return transmitsMapper.insertSelective(transmits);
    }
}
