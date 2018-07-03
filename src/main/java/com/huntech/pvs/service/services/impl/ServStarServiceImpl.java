package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.dao.services.ServStarMapper;
import com.huntech.pvs.model.services.ServStar;
import com.huntech.pvs.model.services.ServStarExample;
import com.huntech.pvs.service.services.ServStarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServStarServiceImpl implements ServStarService {

    @Autowired
    private ServStarMapper servStarMapper;

    @Override
    public ServStar getServStarByServId(Long servId) {
        ServStarExample example = new ServStarExample();
        ServStarExample.Criteria criteria = example.createCriteria();
        criteria.andServIdEqualTo(servId);
        List<ServStar> servStars = servStarMapper.selectByExample(example);
        if(servStars!=null&&servStars.size()>0){
            ServStar servStar = servStars.get(0);
            return servStar;
        }
        return null;
    }

    @Override
    public int updateByPrimaryKey(ServStar servStar) {
        int i = servStarMapper.updateByPrimaryKey(servStar);
        return i;
    }

    @Override
    public int insertSelective(ServStar servStar) {
        return servStarMapper.insertSelective(servStar);
    }
}
