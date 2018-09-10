package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.dao.services.SatisMapper;
import com.huntech.pvs.model.services.Satis;
import com.huntech.pvs.model.services.SatisExample;
import com.huntech.pvs.service.services.SatisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SatisServiceImpl implements SatisService {

    @Autowired
    private SatisMapper satisMapper;
    @Override
    public void updateSatis(Satis satis) {
        satisMapper.updateByPrimaryKeySelective(satis);
    }

    @Override
    public Satis getSatisByServId(Long servId) {
        SatisExample satisExample = new SatisExample();
        SatisExample.Criteria criteria = satisExample.createCriteria();
        criteria.andSeridEqualTo(servId);
        List<Satis> satis = satisMapper.selectByExample(satisExample);
        if(satis!=null&&satis.size()>0){
            return satis.get(0);
        }

        return null;
    }
}
