package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.dao.services.ServContentMapper;
import com.huntech.pvs.model.services.ServContent;
import com.huntech.pvs.model.services.ServContentExample;
import com.huntech.pvs.service.services.ServContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServContentServiceImpl implements ServContentService {

    @Autowired
    private ServContentMapper servContentMapper;
    @Override
    public List<ServContent> getServContentByServId(ServContent servContent) {
        Integer servid = servContent.getServid();
        ServContentExample servContentExample = new ServContentExample();
        ServContentExample.Criteria criteria = servContentExample.createCriteria();
        criteria.andServidEqualTo(servid);
        List<ServContent> servContents = servContentMapper.selectByExample(servContentExample);
        return  servContents;

    }
}
