package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.dao.services.MyBaseservTypeMapper;
import com.huntech.pvs.dao.services.MyServsMapper;
import com.huntech.pvs.model.services.MyBaseservType;
import com.huntech.pvs.model.services.MyServs;
import com.huntech.pvs.model.services.MyServsExample;
import com.huntech.pvs.service.services.MyServsService;
import com.huntech.pvs.view.request.MyServsDelRequest;
import com.huntech.pvs.view.request.MyServsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyServsServiceImpl implements MyServsService {

    @Autowired
    private MyServsMapper myServsMapper;
    @Autowired
    private MyBaseservTypeMapper myBaseservTypeMapper;
    @Override
    public int insertMyServs(MyServsRequest myServsRequest) {
        String newMyServType = myServsRequest.getNewMyServType();
        Long id = myServsRequest.getId();
        if(id.equals((long) -1)){//新增加的分类
            MyBaseservType myBaseservType = new MyBaseservType();
            myBaseservType.setMyServType(newMyServType);
            myBaseservType.setOpenid(myServsRequest.getOpenid());
            myBaseservTypeMapper.insertSelective(myBaseservType);
             id = myBaseservType.getId();
        }
        MyServs myServs = new MyServs();
        myServs.setMyBaseservTypeid(id);
        myServs.setLatitude(myServsRequest.getLatitude());
        myServs.setLongitude(myServsRequest.getLongitude());
        myServs.setOpenid(myServsRequest.getOpenid());
        myServs.setServAddress(myServsRequest.getServAddress());
        myServs.setServName(myServsRequest.getServName());
        myServs.setServNote(myServsRequest.getServNote());
        myServs.setServTel(myServsRequest.getServTel());
        return myServsMapper.insertSelective(myServs);
    }

    @Override
    public int deleteMyServs(MyServsDelRequest myServs) {

        Long id = myServs.getId();//删除私服员

        Long myBaseservTypeid = myServs.getMyBaseservTypeid();//删除私服分类
        if(id!=null){
            MyServs myServs1 = new MyServs();
            myServs1.setId(id);
            myServs1.setState((byte)0);
            return myServsMapper.updateByPrimaryKeySelective(myServs1);
        }
        if(myBaseservTypeid!=null){
            MyServs myServs1 = new MyServs();
            myServs1.setMyBaseservTypeid(myBaseservTypeid);
            myServs1.setState((byte)0);
            MyServsExample example = new MyServsExample();
            MyServsExample.Criteria criteria = example.createCriteria();
            criteria.andMyBaseservTypeidEqualTo(myBaseservTypeid);
            criteria.andStateEqualTo((byte)1);
            myServsMapper.updateByExampleSelective(myServs1,example);

            MyBaseservType myBaseservType = new MyBaseservType();
            myBaseservType.setId(myBaseservTypeid);
            myBaseservType.setState((byte)0);
            return myBaseservTypeMapper.updateByPrimaryKeySelective(myBaseservType);
        }
        return 0;//
    }

    @Override
    public MyServs getMyServById(Long id) {
        return myServsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateMyServById(MyServs myServs) {
        return myServsMapper.updateByPrimaryKeySelective(myServs);
    }
}
