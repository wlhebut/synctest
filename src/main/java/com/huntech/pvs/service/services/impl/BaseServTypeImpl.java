package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.dao.services.BaseServTypeMapper;
import com.huntech.pvs.dao.services.SelfBaseServTypeMapper;
import com.huntech.pvs.model.services.BaseServType;
import com.huntech.pvs.model.services.BaseServTypeExample;
import com.huntech.pvs.model.services.SelfBaseServType;
import com.huntech.pvs.model.services.SelfBaseServTypeExample;
import com.huntech.pvs.service.services.BaseServTypeService;
import com.huntech.pvs.service.services.SelfServTypeService;
import com.huntech.pvs.view.request.BaseServTypeRequest;
import com.huntech.pvs.view.services.BaseServTypeView;
import org.apache.poi.util.SystemOutLogger;
import org.apache.taglibs.standard.lang.jstl.NullLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BaseServTypeImpl implements BaseServTypeService {

    @Autowired
    private BaseServTypeMapper baseServTypeMapper;

    @Autowired
    private SelfBaseServTypeMapper selfBaseServTypeMapper;

    @Autowired
    private SelfServTypeService selfServTypeService;
    /**
    * @Description: getServType
    * @Param: [baseServType]
    * @return: java.util.List<com.huntech.pvs.model.services.BaseServType>
    * @Author: Mr.Wang
    * @Date: 2018/5/25
    */
    @Override
    public List<BaseServType> getBaseServType(BaseServType baseServType) {
        Byte state=baseServType.getState();//状态
        Byte lawful = baseServType.getLawful();//是否合法
        Byte servType = baseServType.getServType();//0:baseServ  1:selfServ
        BaseServTypeExample example = new BaseServTypeExample();
        BaseServTypeExample.Criteria criteria = example.createCriteria();

        if(lawful!=null){
            criteria.andLawfulEqualTo(lawful);
        }

        if(state!= null){
            criteria.andServTypeEqualTo(state);
        }
        if(state!=null){
            criteria.andStateEqualTo(state);
        }
        if(servType!=null){
            criteria.andStateEqualTo(state);
        }

        List<BaseServType> list = baseServTypeMapper.selectByExample(example);

        return list;
    }

    @Override
    public BaseServType getBaseServTypeById(Long id) {
        BaseServType baseServType = null;
        if(id!=null){
             baseServType = baseServTypeMapper.selectByPrimaryKey(id.intValue());
        }
        return baseServType;
    }

    @Override
    public Integer updateByOpenId(BaseServTypeRequest baseServTypes) {

        String ids = baseServTypes.getIds();
        ArrayList<Integer> objects = new ArrayList<>();
        if(ids!=null&&ids.contains(",")){
            String[]  split = ids.split(",");
            if(split.length>0){
                for (String s : split) {
                    objects.add(new Integer(s));
                }
                SelfBaseServTypeExample selfBaseServTypeExample = new SelfBaseServTypeExample();
                SelfBaseServTypeExample.Criteria criteria = selfBaseServTypeExample.createCriteria();

                criteria.andBaseServTypeidIn(objects);

                SelfBaseServType selfBaseServType = new SelfBaseServType();
                selfBaseServType.setState(new Byte("1"));

                selfBaseServTypeMapper.updateByExampleSelective(selfBaseServType,selfBaseServTypeExample);

                SelfBaseServTypeExample selfBaseServTypeExample2 = new SelfBaseServTypeExample();
                SelfBaseServTypeExample.Criteria criteria2 = selfBaseServTypeExample2.createCriteria();
                criteria2.andBaseServTypeidNotIn(objects);
                SelfBaseServType selfBaseServType2 = new SelfBaseServType();
                selfBaseServType2.setState(new Byte("0"));
                selfBaseServTypeMapper.updateByExampleSelective(selfBaseServType2,selfBaseServTypeExample2);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public List<BaseServType> getBaseServTypeByOpenId(BaseServTypeRequest baseServType) {
        List<BaseServType> list;
        String openid = baseServType.getOpenid();
        if(openid!=null&&!"".equals(openid)){
            SelfBaseServTypeExample selfBaseServTypeExample = new SelfBaseServTypeExample();
            SelfBaseServTypeExample.Criteria criteria = selfBaseServTypeExample.createCriteria();
            criteria.andOpenidEqualTo(openid);
            criteria.andStateEqualTo(new Byte("1"));
            List<SelfBaseServType> selfBaseServTypes = selfBaseServTypeMapper.selectByExample(selfBaseServTypeExample);

            ArrayList<Integer> integers = new ArrayList<>();
            if(selfBaseServTypes!=null&&selfBaseServTypes.size()>0){
                for (SelfBaseServType selfBaseServType : selfBaseServTypes) {
                    integers.add(selfBaseServType.getBaseServTypeid());
                }
            }
            BaseServTypeExample example = new BaseServTypeExample();
            BaseServTypeExample.Criteria criteria1 = example.createCriteria();
            if(integers.size()>0){
                criteria1.andIdIn(integers);
            }else{
                selfServTypeService.insertAllType(openid);
            }
            list = baseServTypeMapper.selectByExample(example);
            for (BaseServType servType : list) {

                System.out.println("1查询的私服分类："+servType.getTname());
            }
        }else{
            list = baseServTypeMapper.selectByExample(null);
            for (BaseServType servType : list) {
                System.out.println("22查询的私服分类："+servType.getTname());
            }

        }
        return list;
    }

    @Override
    public List<BaseServType> getOtherBaseServTypeByOpenId(BaseServTypeRequest baseServType) {
        //获取所有私服
        //当前用户的私服
        List<BaseServType> list;
        String openid = baseServType.getOpenid();
        if(openid!=null&&!"".equals(openid)){
            SelfBaseServTypeExample selfBaseServTypeExample = new SelfBaseServTypeExample();
            SelfBaseServTypeExample.Criteria criteria = selfBaseServTypeExample.createCriteria();
            criteria.andOpenidEqualTo(openid);
            criteria.andStateEqualTo(new Byte("0"));
            List<SelfBaseServType> selfBaseServTypes = selfBaseServTypeMapper.selectByExample(selfBaseServTypeExample);

            ArrayList<Integer> integers = new ArrayList<>();
            if(selfBaseServTypes!=null&&selfBaseServTypes.size()>0){
                for (SelfBaseServType selfBaseServType : selfBaseServTypes) {
                    integers.add(selfBaseServType.getBaseServTypeid());
                }
            }
            BaseServTypeExample example = new BaseServTypeExample();
            BaseServTypeExample.Criteria criteria1 = example.createCriteria();
            if((integers.size() ==0)){
                integers.add(-1);
                criteria1.andIdIn(integers);
            }else{
                criteria1.andIdIn(integers);
            }
            list = baseServTypeMapper.selectByExample(example);
            for (BaseServType servType : list) {

                System.out.println("1查询的私服分类："+servType.getTname());
            }
        }else{
            list = baseServTypeMapper.selectByExample(null);
            for (BaseServType servType : list) {
                System.out.println("22查询的私服分类："+servType.getTname());
            }

        }
        return list;
        //方法二
        /*if(baseServType.getOpenid()!=null&&!baseServType.getOpenid().equals("")){
            Map<String, Object> map = new HashMap<>();
            map.put("openid",baseServType.getOpenid());
            List<BaseServType> otherBaseServTypeByOpenId = baseServTypeMapper.getOtherBaseServTypeByOpenId(map);
            return otherBaseServTypeByOpenId;
        }*/
//        return null;
    }
}
