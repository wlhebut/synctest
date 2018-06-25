package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.dao.services.ServOrderMapper;
import com.huntech.pvs.model.services.ServOrder;
import com.huntech.pvs.model.services.ServOrderExample;
import com.huntech.pvs.service.services.ServOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServOrderServiceImpl implements ServOrderService{

    @Autowired
    private ServOrderMapper servOrderMapper;
    @Override
    public List<ServOrder> getServOrders(ServOrder servOrder) {
        ServOrderExample servOrderExample = new ServOrderExample();
        ServOrderExample.Criteria criteria = servOrderExample.createCriteria();
        if(servOrder.getOpenid()!=null){
            criteria.andOpenidEqualTo(servOrder.getOpenid());
        }
        List<ServOrder> servOrders = servOrderMapper.selectByExample(servOrderExample);
        return servOrders;
    }

    @Override
    public int delServOrder(Long serOrderId) {
        int i = servOrderMapper.deleteByPrimaryKey(serOrderId);
        return i;
    }

    @Override
    public int insertServOrder(ServOrder servOrder) {
        int i = servOrderMapper.insertSelective(servOrder);

        return i;
    }
}
