package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.common.redis.VCache;
import com.huntech.pvs.common.util.JWT;
import com.huntech.pvs.core.feature.orm.mybatis.Page;
import com.huntech.pvs.dao.services.*;
import com.huntech.pvs.model.services.*;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.service.services.*;
import com.huntech.pvs.view.request.DetailServRequest;
import com.huntech.pvs.view.services.*;
import com.huntech.web.common.ListUtils;
import com.huntech.web.common.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServImpl implements ServService {


    @Autowired
    private BaseServTypeMapper baseServTypeMapper;

    @Autowired
    private ServMapper servMapper;

    @Autowired
    private  ServContentMapper servContentMapper;
    @Autowired
    private ServManGpsMapper servManGpsMapper;
    @Autowired
    private ServManMapper servManMapper;

    @Autowired
    private ServManGpsService servManService;

    @Autowired
    private SelfServService selfServService;

    @Autowired
    private ServContentService servContentService;


    @Autowired
    private AttentionService attentionService;

    @Autowired
    private RecommendService recommendService;
    /**
    * @Description:
    * @Param: [servRequest]
    * @return: com.huntech.pvs.core.feature.orm.mybatis.Page<com.huntech.pvs.view.services.ServView>
    * @Author: Mr.Wang
    * @Date: 2018/5/25
    */
    @Override
    public Page<ServView> getBaseServ(ServRequest servRequest) {//0,基本私服；1，私有私服
        Integer pageNo = servRequest.getPageNo();
        Integer pageSize = servRequest.getPageSize();
        Page<ServView> page = new Page<>(pageNo,pageSize);

        //搜索结果跟请求人有关系
        String openid = servRequest.getOpenid();



        Map<String,Object> params=new HashMap<>();
        Long servType=servRequest.getServType();
        Byte states = servRequest.getState();
        Long baseservTypeid = servRequest.getBaseservTypeid();
        Long servManid = servRequest.getServManid();
        if(baseservTypeid.equals(1L)){//关注
            List<Long> attentionsByOpenId = attentionService.getAttentionsByOpenId(openid);
            params.put("list",attentionsByOpenId);
            List<ServView> servViews = servMapper.selectAttentionServsView(page,params);
            Integer totalCount=servMapper.selectPrimServsViewCount(params);
            PageUtils.setPage(servViews, totalCount, pageSize, page);
            return page;
        }else if(baseservTypeid.equals(2L)){//推荐
            List<Long> recommendsByOpenId = recommendService.getRecommendsByOpenId(openid);
            params.put("list",recommendsByOpenId);
            List<ServView> servViews = servMapper.selectAttentionServsView(page,params);
            Integer totalCount=servMapper.selectPrimServsViewCount(params);
            PageUtils.setPage(servViews, totalCount, pageSize, page);
            return page;
        }



        if(servType!=null){
            params.put("servType",servType);
        }
        if(states!=null){
            params.put("states",states);
        }
        if(baseservTypeid!=null){
            params.put("baseservTypeid",baseservTypeid);
        }
        if(servManid!=null){
            params.put("servManid",servManid);
        }



        List<ServView> list = servMapper.selectServsView(page,params);
        Integer totalCount=servMapper.selectServsViewCount(params);
        PageUtils.setPage(list, totalCount, pageSize, page);
        return page;
    }

    @Override
    public List<Serv> selectByExample(ServRequest servRequest) {
        List<Serv> servs = servMapper.selectByExample(null);
        return servs;
    }

    /**
    * @Description:  分页查找
    * @Param: [servRequest]
    * @return: com.huntech.pvs.core.feature.orm.mybatis.Page<com.huntech.pvs.model.services.Serv>
    * @Author: Mr.Wang
    * @Date: 2018/5/25
    */
    @Override
    public Page<Serv> selectByExampleAndPage(ServRequest servRequest) {
        Integer pageNo = servRequest.getPageNo();
        Integer pageSize = servRequest.getPageSize();
        Page<Serv> page = new Page<>(pageNo,pageSize);
        Long servManid = servRequest.getServManid();
        ServExample servExample = new ServExample();
        ServExample.Criteria criteria = servExample.createCriteria();
        if(servManid!=null){
            criteria.andServManidEqualTo(servManid);
        }
        List<Serv> list = servMapper.selectByExampleAndPage(page, servExample);
        int totalCount=servMapper.countByExample(null);
        PageUtils.setPage(list, totalCount, pageSize, page);
        return page;
    }

    @Override
    public Page<ServView> getBaseServOnMap(ServRequest servRequest) {
        Page<ServView> baseServ = this.getBaseServ(servRequest);
        List<ServView> result = baseServ.getResult();
        List<Object> servManid = ListUtils.findObject(result, "servManid");
        List<ServManGps> servMan = servManService.getServManGps(servManid);
        HashMap<Long, ServManGps> servManMap = new HashMap<>();

        for (ServManGps servManGps : servMan) {
            servManMap.put(servManGps.getServManid(),servManGps);
        }
        for (ServView servView : result) {
            ServManGps servManGps = servManMap.get(servView.getServManid());
            servView.setLongitude(servManGps==null?"":servManGps.getLongitude());
            servView.setLatitude(servManGps==null?"":servManGps.getLatitude());
        }
        return baseServ;
    }

    /**
    * @Description: 发布私服
    * @Param: [releaseServRequest]
    * @return: java.lang.Integer
    * @Author: Mr.Wang
    * @Date: 2018/5/27
    */
    @Override
    public Integer releaseServ(ReleaseServRequest releaseServRequest, HttpServletRequest request) {
        String token = request.getHeader("token");
        String openid = JWT.unsign(token, String.class);
        WeiXinUser weiXinUser = VCache.get(openid, WeiXinUser.class);
        Long id = weiXinUser.getId();//serv_manid
        Serv serv = new Serv();
        int insert = 0;
        if(releaseServRequest.getServType()==0L){
            serv.setBaseservTypeid(releaseServRequest.getBaseServTypeid());
            serv.setServManid(id);
            serv.setSelfservTypeid(0L);//个性化私服为0L
            serv.setServType("0");
            serv.setState((byte)1);
            serv.setServTimeid(releaseServRequest.getServTimeId().intValue());
             insert = servMapper.insert(serv);
            Long autoId = serv.getId();
            List<ServContent> servContents = releaseServRequest.getServContents();
            if(servContents!=null&&servContents.size()>0){
                for (ServContent servContent : servContents) {
                    servContent.setServid(autoId.intValue());
                    servContentMapper.insertSelective(servContent);
                }
            }
        }else {
            //个性化私服
        }

        return insert;
    }

    @Override
    public Page<ServView> getReleaseServs(ServRequest servRequest,HttpServletRequest request) {
        String token = request.getHeader("token");
        String openid = JWT.unsign(token, String.class);
        WeiXinUser weiXinUser = VCache.get(openid, WeiXinUser.class);
        Long id = weiXinUser.getId();//serv_manid

        servRequest.setServManid(id);
        Page<ServView> baseServ = this.getBaseServ(servRequest);
        return baseServ;
    }

    @Override
    public Integer insertSelfAddServ(SelfAddServRequest selfAddServRequest, HttpServletRequest request) {
        Integer integer = selfServService.insertSelfAddServ(selfAddServRequest, request);
        return integer;
    }

    @Override
    public DetailServView getDetailServViewById(DetailServRequest detailServRequest) {
        Integer id = detailServRequest.getId();

        String longitude = detailServRequest.getLongitude();
        String latitude = detailServRequest.getLatitude();
        Map<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("id",id);
        DetailServView detailServsView = servMapper.getDetailServsView(objectObjectHashMap);
        String latitude1 = detailServsView.getLatitude();
        String longitude1 = detailServsView.getLongitude();
        if(longitude!=null&&latitude!=null&&longitude1!=null&&latitude1!=null){//计算两个经纬度之间的距离。
            detailServsView.setDistance(100D);
        }
        Long servContentid = detailServsView.getServContentid();

        ServContent servContent = new ServContent();
        servContent.setServid(new Integer(String.valueOf(servContentid)));
        List<ServContent> servContents = servContentService.getServContentByServId(servContent);
        detailServsView.setServContents(servContents);

        return detailServsView;
    }
}
