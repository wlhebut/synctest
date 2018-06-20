package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.common.redis.VCache;
import com.huntech.pvs.common.util.JWT;
import com.huntech.pvs.core.feature.orm.mybatis.Page;
import com.huntech.pvs.dao.services.SelfServMapper;
import com.huntech.pvs.model.services.BaseServType;
import com.huntech.pvs.model.services.SelfServ;
import com.huntech.pvs.model.services.SelfServExample;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.service.services.BaseServTypeService;
import com.huntech.pvs.service.services.SelfServService;
import com.huntech.pvs.view.services.SelfAddServRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class SelfServImpl implements SelfServService {


    @Autowired
    private SelfServMapper selfServMapper;
    @Autowired
    private BaseServTypeService baseServTypeService;

    @Override
    public List<SelfServ> getSelfServs(HttpServletRequest request) {
        String token = request.getHeader("token");
        String openid = JWT.unsign(token, String.class);
        SelfServExample selfServExample = new SelfServExample();
        SelfServExample.Criteria criteria = selfServExample.createCriteria();
        criteria.andOpenidEqualTo(openid);
        List<SelfServ> selfServs = selfServMapper.selectByExample(selfServExample);
        for (SelfServ selfServ : selfServs) {
            Byte servtype = selfServ.getServtype();
            if(servtype==0){
                Long baseServtypeid = selfServ.getBaseServtypeid();
                BaseServType baseServType = baseServTypeService.getBaseServTypeById(baseServtypeid);
                selfServ.setSelfServ(baseServType.getTname());
            }
        }
        return selfServs;
    }

    @Override
    public Integer insertSelfAddServ(SelfAddServRequest selfAddServRequest, HttpServletRequest request) {
        String token = request.getHeader("token");
        String openid = JWT.unsign(token, String.class);

        Byte servType = selfAddServRequest.getServType();
        SelfServ serv = new SelfServ();
        if(servType!=null&&servType==0){//基本私服

            serv.setBaseServtypeid(selfAddServRequest.getBaseServTypeid());
            serv.setServtype(selfAddServRequest.getServType());
            serv.setSname(selfAddServRequest.getSname());
            serv.setStel(selfAddServRequest.getStel());

        }else{//s添加数据库中不存在的服务类型
            serv.setServtype(selfAddServRequest.getServType());//1
            serv.setSname(selfAddServRequest.getSname());
            serv.setStel(selfAddServRequest.getStel());
            serv.setSelfServ(selfAddServRequest.getSelfServ());
        }
        serv.setOpenid(openid);
        List<SelfServ> selfServs = this.getSelfServs(request);
        int i;
        if(selfServs!=null&&selfServs.size()<20){
             i = selfServMapper.insertSelective(serv);
        }else{
            i=0;//超过20个私服就不如许！
        }
        return i;
    }
}
