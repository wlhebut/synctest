package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.core.feature.orm.mybatis.Page;
import com.huntech.pvs.dao.services.MyBaseservTypeMapper;
import com.huntech.pvs.model.services.MyBaseservType;
import com.huntech.pvs.model.services.MyServs;
import com.huntech.pvs.service.services.MyBaseServTypeService;
import com.huntech.pvs.view.request.MyServsRequest;
import com.huntech.pvs.view.services.MyServViews;
import com.huntech.pvs.view.services.ServView;
import com.huntech.web.common.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyBaseServTypeServiceImpl implements MyBaseServTypeService {

    @Autowired
    private MyBaseservTypeMapper myBaseservTypeMapper;
    @Override
    public List<MyServs> selectAllServsByOpenid(MyServsRequest myServsRequest) {
        Map<String,Object> params=new HashMap<>();
        String openid = myServsRequest.getOpenid();
        params.put("openid",openid);
        params.put("state",1);
        List<MyServs> myServViews = myBaseservTypeMapper.selectMyServViews(params);
        return myServViews;
    }

    @Override
    public int updateByTypeId(MyBaseservType myServsRequest) {

        return  myBaseservTypeMapper.updateByPrimaryKeySelective(myServsRequest);
    }
}
