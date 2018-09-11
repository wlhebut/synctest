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
    public ServManGps getServManGps(String openid) {
        ServManGpsExample example = new ServManGpsExample();
        ServManGpsExample.Criteria criteria = example.createCriteria();
        criteria.andServManidEqualTo(openid);
        List<ServManGps> servManGps = servManGpsMapper.selectByExample(example);
        if(servManGps!=null&&servManGps.size()>0){
            return servManGps.get(0);
        }
        return null;
    }

    @Override
    public List<ServManGps> getServManGps(List<Object> ids) {
        List<String> longs=(List<String>)(List) ids;
        ServManGpsExample example = new ServManGpsExample();
        ServManGpsExample.Criteria criteria = example.createCriteria();
        criteria.andServManidIn(longs);
        List<ServManGps> servManGps = servManGpsMapper.selectByExample(example);
        return servManGps;
    }

    @Override
    public int saveServManGpa(ServManGps servManGps) {

        return servManGpsMapper.updateByPrimaryKeySelective(servManGps);
    }
}
