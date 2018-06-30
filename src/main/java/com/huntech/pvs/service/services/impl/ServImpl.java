package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.common.redis.VCache;
import com.huntech.pvs.common.util.JWT;
import com.huntech.pvs.common.util.MapUtils;
import com.huntech.pvs.core.feature.orm.mybatis.Page;
import com.huntech.pvs.dao.services.*;
import com.huntech.pvs.dao.sys.WeiXinUserMapper;
import com.huntech.pvs.model.services.*;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.model.sys.WeiXinUserExample;
import com.huntech.pvs.service.services.*;
import com.huntech.pvs.view.request.DetailServRequest;
import com.huntech.pvs.view.request.OptServRequest;
import com.huntech.pvs.view.services.*;
import com.huntech.web.common.ListUtils;
import com.huntech.web.common.PageUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class ServImpl implements ServService {

    private static final Logger log = Logger.getLogger(ServImpl.class);

    @Autowired
    private WeiXinUserMapper weiXinUserMapper;

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
    private RecommendService recommendService;

    @Autowired
    private LabelService labelService;

    @Autowired
    private DisServMapper disServMapper;

    @Autowired
    private AttentionService attentionService;

    @Autowired
    private illegalServMapper illegalServMapper;

    @Autowired
    private ClassificationServMapper classificationServMapper;


    @Autowired
    private  SatisMapper satisMapper;


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
        if(null!=baseservTypeid&&baseservTypeid.equals(1L)){//关注
//            List<Long> attentionsByOpenId = attentionService.getAttentionsByOpenId(openid);
            params.put("openid",openid);
            List<ServView> servViews = servMapper.selectAttentionServsView(page,params);
            Integer totalCount=servMapper.selectAttentionServsViewCount(params);
            PageUtils.setPage(servViews, totalCount, pageSize, page);
            return page;
        }else if(null!=baseservTypeid&&baseservTypeid.equals(2L)){//推荐
//            List<Long> recommendsByOpenId = recommendService.getRecommendsByOpenId(openid);
            params.put("openid",openid);
            List<ServView> servViews = servMapper.selectRecommendServsView(page,params);
            Integer totalCount=servMapper.selectRecommendServsViewCount(params);
            PageUtils.setPage(servViews, totalCount, pageSize, page);
            return page;
        }

        if(baseservTypeid!=null){
            params.put("baseservTypeid",baseservTypeid);
        }
        if(openid!=null){
            params.put("openid",openid);
        }
        /*if(servManid!=null){
            params.put("servManid",servManid);
        }*/



        List<ServView> list = servMapper.selectServsView(page,params);

        if(servRequest.getLatitude()!=null&&servRequest.getLongitude()!=null&&list!=null&&list.size()>0){
            Double latitude = Double.valueOf(servRequest.getLatitude());
            Double longitude = Double.valueOf(servRequest.getLongitude());
            for (ServView servView : list) {
                if(servRequest.getLatitude()!=null&&servView.getLongitude()!=null){
                    Double latitude1 =  Double.valueOf(servRequest.getLatitude());
                    Double longitude1 =  Double.valueOf(servView.getLongitude());
                    if(latitude1 !=null&& longitude1 !=null){
                        //计算两个经纬度的距离
                        double v = MapUtils.GetDistance(latitude, longitude, latitude1, longitude1);
                        servView.setDistance(v/1000);//千米(单位)
                    }
                }
            }
        }else{
                System.out.println("需要开启位置权限");
            }





        Integer totalCount=servMapper.selectServsViewCount(params);
        PageUtils.setPage(list, totalCount, pageSize, page);
        return page;
    }

    @Override
    public List<Serv> selectByExample(ServRequest servRequest) {
        List<Serv> servs = servMapper.selectByExample(null);
        return servs;
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
        if(openid==null||openid.equals("")){
            openid=releaseServRequest.getOpenid();
        }
        Long id = null;
        WeiXinUser weiXinUser = VCache.get(openid, WeiXinUser.class);
        if(null==weiXinUser){
            WeiXinUserExample example = new WeiXinUserExample();
            WeiXinUserExample.Criteria criteria = example.createCriteria();
            criteria.andOpenIdEqualTo(openid);
            List<WeiXinUser> weiXinUsers = weiXinUserMapper.selectByExample(example);
            if(weiXinUsers!=null&&weiXinUsers.size()>0){
                id=weiXinUsers.get(0).getId();
            }
        }else{
             id = weiXinUser.getId();//serv_manid
        }
        Serv serv = new Serv();
        int insert = 0;
        if(releaseServRequest.getServType()==0L){
            serv.setServName(releaseServRequest.getServName());
            serv.setBaseservTypeid(releaseServRequest.getBaseServTypeid());
            serv.setServManid(id);
//            serv.setSelfservTypeid(0L);//个性化私服为0L
            serv.setServType("0");
            serv.setState((byte)1);
            serv.setServNote(releaseServRequest.getServNote());
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
            //insert 默认的满意度
            Satis satis = new Satis();
//            satis.setId(autoId.intValue());
            satis.setErversatis(5);
            satis.setSerid(autoId);
            satisMapper.insert(satis);


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
        assert weiXinUser != null;
        Long id = weiXinUser.getServManid();//serv_manid

        servRequest.setServManid(id);
//        Page<ServView> baseServ = this.getBaseServ(servRequest);
        Integer pageNo = servRequest.getPageNo();
        Integer pageSize = servRequest.getPageSize();
        Page<ServView> page = new Page<>(pageNo,pageSize);
        Map<String,Object> params=new HashMap<>();
        Long servManid = servRequest.getServManid();
        params.put("servManid",servManid);
        List<ServView> servViews = servMapper.selectReleaseServsView(page,params);
        Integer totalCount=servMapper.selectReleaseServsViewCount(params);
        PageUtils.setPage(servViews, totalCount, pageSize, page);
        return page;
    }

    @Override
    public Integer insertSelfAddServ(SelfAddServRequest selfAddServRequest, HttpServletRequest request) {
        Integer integer = selfServService.insertSelfAddServ(selfAddServRequest, request);
        return integer;
    }

    @Override
    public DetailServView getDetailServViewById(DetailServRequest detailServRequest) {
        Integer id = detailServRequest.getId();

        String openid = detailServRequest.getOpenid();
        Double longitude = null;
        Double latitude = null;

        if(detailServRequest.getLongitude()!=null){
             longitude = Double.valueOf(detailServRequest.getLongitude());
        }
        if(detailServRequest.getLatitude()!=null){
             latitude = Double.valueOf(detailServRequest.getLatitude());
        }


        Map<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("id",id);
        DetailServView detailServsView = servMapper.getDetailServsView(objectObjectHashMap);
        Double latitude1 =Double.valueOf(detailServsView.getLatitude()) ;
        Double longitude1 = Double.valueOf(detailServsView.getLongitude());
        if(longitude!=null&&latitude!=null&&longitude1!=null&&latitude1!=null){//计算两个经纬度之间的距离。
            double v = MapUtils.GetDistance(latitude, longitude, latitude1, longitude1);
            detailServsView.setDistance(v);
        }

        List<Label> labelsByServId = labelService.getLabelsByServId(Long.valueOf(id));//评价

        detailServsView.setServLabels(labelsByServId);
        Integer attentionCount = attentionService.getAttentionCount(new Attention(openid, Long.valueOf(id)));
        detailServsView.setAttention(attentionCount);//是否关注

        Integer totalAttentionCount = attentionService.getAttentionCount(new Attention(null, Long.valueOf(id)));

        detailServsView.setTotalAttentions(totalAttentionCount);//总关注次数

        Long servContentid = detailServsView.getServContentid();

        ServContent servContent = new ServContent();
        if(servContentid!=null){
            servContent.setServid(new Integer(String.valueOf(servContentid)));
            List<ServContent> servContents = servContentService.getServContentByServId(servContent);//条目
            detailServsView.setServContents(servContents);
        }
        return detailServsView;
    }

    @Override
    public void optBaseServByUser(OptServRequest optServRequest) {
        /*
        输入参数	servid	必填项	对应列表id
        disserv		 （喜欢：1，不喜欢0）
        attention		红心（关注：1，不关注0 ）
        illegal		违法内容 illegal  （违法：1，不违法0）
        classification		（分类错误1，没错误0）
        openid		用户的openid
        */

        Long servid = optServRequest.getServid();

        Integer disserv = optServRequest.getDisserv();
        Integer attention = optServRequest.getAttention();
        Integer illegal = optServRequest.getIllegal();
        Integer classification = optServRequest.getClassification();

        String openid = optServRequest.getOpenid();
        Serv serv = servMapper.selectByPrimaryKey(servid);
        if(disserv!=null&&disserv.equals(0)&&serv.getServManid()!=null&&openid!=null){//
            log.debug(openid+"用户**** 不喜欢  **** : " + servid+"disserv私服");
            DisServExample example = new DisServExample();
            DisServExample.Criteria criteria = example.createCriteria();
            criteria.andOpenidEqualTo(openid);
            criteria.andServManidEqualTo(serv.getServManid());

            List<DisServ> disServs = disServMapper.selectByExample(example);
            if(disServs!=null&&disServs.size()>0){
                DisServ disServ = disServs.get(0);
                if(new Byte("0").equals(disServ.getState())){
                    disServ.setState(new Byte("1"));
                    disServMapper.updateByPrimaryKey(disServ);
                }
            }else{
                disServMapper.insertSelective(new DisServ(openid,serv.getServManid(),Byte.valueOf("1")));
            }
        }

        if(attention!=null&&attention.equals(1)){
            log.debug(openid+"用户**** attention **** : " + servid+"私服");
            Integer attentionCount = attentionService.getAttentionCount(new Attention(openid,servid));
            if(attentionCount>0){

            }else{
                attentionService.insert(new Attention(openid, servid));
            }
        }
        if(illegal!=null&&illegal.equals(1)){
            log.debug("**** illegal **** : " + servid);
            illegalServExample example = new illegalServExample();
            illegalServExample.Criteria criteria = example.createCriteria();
            criteria.andOpenidEqualTo(openid);
            criteria.andServManidEqualTo(servid);
            List<illegalServ> illegalServs = illegalServMapper.selectByExample(example);
            if(null!=illegalServs&&illegalServs.size()>0){
                illegalServ illegalServ = illegalServs.get(0);
                if(Objects.equals(((byte) 0), illegalServ.getState())){
                    illegalServ.setState((byte) 1);
                    illegalServMapper.updateByPrimaryKey(illegalServ);
                }
            }else{
                illegalServMapper.insert(new illegalServ(openid, servid,new Byte("1")));
            }
        }
        if(classification!=null&&classification.equals(1)){
            log.debug("**** classification wrong **** : " + servid);
            ClassificationServExample example = new ClassificationServExample();
            ClassificationServExample.Criteria criteria = example.createCriteria();
            criteria.andOpenidEqualTo(openid);
            criteria.andServManidEqualTo(servid);
            List<ClassificationServ> classificationServs = classificationServMapper.selectByExample(example);
            if(classificationServs!=null&&classificationServs.size()>0){
                ClassificationServ classificationServ = classificationServs.get(0);
                classificationServ.setState((byte)1);
                classificationServMapper.updateByPrimaryKey(classificationServ);
            }else{
                classificationServMapper.insert(new ClassificationServ(openid, servid,new Byte("1")));
            }
        }
    }
}
