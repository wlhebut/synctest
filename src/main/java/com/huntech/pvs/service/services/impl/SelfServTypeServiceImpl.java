package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.dao.services.BaseServTypeMapper;
import com.huntech.pvs.dao.services.SelfBaseServTypeMapper;
import com.huntech.pvs.model.services.BaseServType;
import com.huntech.pvs.model.services.SelfBaseServType;
import com.huntech.pvs.model.services.SelfBaseServTypeExample;
import com.huntech.pvs.service.services.BaseServTypeService;
import com.huntech.pvs.service.services.SelfServTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SelfServTypeServiceImpl implements SelfServTypeService {

    @Autowired
    private SelfBaseServTypeMapper selfBaseServTypeMapper;
    @Autowired
    private BaseServTypeMapper baseServTypeMapper;

    @Autowired
    BaseServTypeService baseServTypeService;
   /* @Override
    public List<BaseServType> selectByServTypeByOpenId(String openid) {
        SelfBaseServTypeExample selfBaseServTypeExample = new SelfBaseServTypeExample();
        SelfBaseServTypeExample.Criteria criteria = selfBaseServTypeExample.createCriteria();
        criteria.andOpenidEqualTo(openid);
        List<SelfBaseServType> selfBaseServTypes = selfBaseServTypeMapper.selectByExample(selfBaseServTypeExample);

        ArrayList<Integer> objects = new ArrayList<>();
        if(selfBaseServTypes!=null&&selfBaseServTypes.size()>0){
            for (SelfBaseServType selfBaseServType : selfBaseServTypes) {
                Integer baseServTypeid = selfBaseServType.getBaseServTypeid();
                objects.add(baseServTypeid);
            }
        }
        baseServTypeService.

        return selfBaseServTypes;
    }*/

    @Override
    public Integer insertAllType(String openid) {
        try {
            List<BaseServType> list = baseServTypeMapper.selectByExample(null);
            for (BaseServType baseServType : list) {
                SelfBaseServType selfBaseServType = new SelfBaseServType();
                selfBaseServType.setState(new Byte("1"));
                selfBaseServType.setBaseServTypeid(baseServType.getId());
                selfBaseServType.setOpenid(openid);
                selfBaseServTypeMapper.insertSelective(selfBaseServType);
            }
            return 1;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<SelfBaseServType> selectAll(String openid) {

        SelfBaseServTypeExample example = new SelfBaseServTypeExample();
        SelfBaseServTypeExample.Criteria criteria = example.createCriteria();
        criteria.andOpenidEqualTo(openid);
        List<SelfBaseServType> selfBaseServTypes = selfBaseServTypeMapper.selectByExample(example);
        return selfBaseServTypes;
    }
}
