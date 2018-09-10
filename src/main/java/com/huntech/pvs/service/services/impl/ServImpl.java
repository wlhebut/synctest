package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.common.redis.VCache;
import com.huntech.pvs.common.util.DownLoadUrl;
import com.huntech.pvs.common.util.JWT;
import com.huntech.pvs.common.util.MapUtils;
import com.huntech.pvs.core.feature.orm.mybatis.Page;
import com.huntech.pvs.dao.services.*;
import com.huntech.pvs.dao.sys.WeiXinUserMapper;
import com.huntech.pvs.model.services.*;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.model.sys.WeiXinUserExample;
import com.huntech.pvs.service.services.*;
import com.huntech.pvs.service.sys.WeiXinUserService;
import com.huntech.pvs.view.request.DetailServRequest;
import com.huntech.pvs.view.request.OptServRequest;
import com.huntech.pvs.view.services.*;
import com.huntech.web.common.ListUtils;
import com.huntech.web.common.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;
@Slf4j
@Service
@Transactional
public class ServImpl implements ServService {

//    private static final Logger log = Logger.getLogger(ServImpl.class);

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


    @Autowired
    private WeiXinUserService weiXinUserService;

    @Autowired
    private SatisService satisService;

    @Autowired
    private  TransmitsService transmitsService;

    /**
    * @Description:
    * @Param: [servRequest]
    * @return: com.huntech.pvs.core.feature.orm.mybatis.Page<com.huntech.pvs.view.services.ServView>
    * @Author: Mr.Wang
    * @Date: 2018/5/25
    */
    @Override
    public Page<ServView> getBaseServ(ServRequest servRequest) {//0,基本私服；1，私有私服

        Integer zoom = servRequest.getZoom();//1,3,10公里
        String openid="";
        //搜索结果跟请求人有关系
        openid = servRequest.getOpenid();

        Integer pageNo = servRequest.getPageNo();
        Integer pageSize = servRequest.getPageSize();
        Page<ServView> page = new Page<>(pageNo,pageSize);
        Map<String,Object> params=new HashMap<>();
        Byte states = new Byte("1");
        Long baseservTypeid = servRequest.getBaseservTypeid();
        Long servManid = servRequest.getServManid();

        if(null!=openid&&!"".equals(openid)){//有登陆

            if(null!=baseservTypeid&&baseservTypeid.equals(1L)){//关注
//            List<Long> attentionsByOpenId = attentionService.getAttentionsByOpenId(openid);
                params.put("openid",openid);
                List<ServView> servViews = servMapper.selectAttentionServsView(page,params);
                Integer totalCount=servMapper.selectAttentionServsViewCount(params);
                PageUtils.setPage(servViews, totalCount, pageSize, page);
                return page;
            }

            if(null!=baseservTypeid&&baseservTypeid.equals(2L)){//推荐
                params.put("openid",openid);
                List<ServView> servViews = servMapper.selectRecommendServsView(params);
                if(null==zoom||zoom==0){//全量搜索后台数据
                    Integer totalCount=servMapper.selectRecommendServsViewCount(params);
                    PageUtils.setPage(servViews, totalCount, pageSize, page);
                    return page;
                }else{
                    zoom=10;//默认搜索10公里范围数据
                    getDataByDistance(servRequest, zoom, servViews);
                    Integer totalCount=servMapper.selectServsViewCount(params);
                    PageUtils.setPage(servViews, totalCount, pageSize, page);
                    return page;
                }
            }

            if(baseservTypeid!=null){
                params.put("baseservTypeid",baseservTypeid);
            }
            if(openid!=null){
                params.put("openid",openid);
            }
            if(states!=null){
                params.put("state",states);
            }
            if(null==zoom||zoom==0){//没有定位
                List<ServView> list = servMapper.selectServsView(params);//获取所有数据
                Integer totalCount=15;
                Collections.sort(list);
                if(list!=null&&list.size()>15){
                    list = list.subList(0, 15);
                }

                PageUtils.setPage(list, totalCount, pageSize, page);
                return page;
            }else{
                List<ServView> list = servMapper.selectServsView(params);//获取所有数据
                getDataByDistance(servRequest, zoom, list);
                Integer totalCount=servMapper.selectServsViewCount(params);
                PageUtils.setPage(list, totalCount, pageSize, page);
                return page;
            }


        }else{//匿名登录
            if(null!=baseservTypeid&&baseservTypeid.equals(1L)){//关注
                List<ServView> servViews = new ArrayList<>();
                PageUtils.setPage(servViews, 0, pageSize, page);
                return page;
            }
            if(null!=baseservTypeid&&baseservTypeid.equals(2L)){//推荐
                if(openid!=null){
                    params.put("openid","");//匿名推荐
                }
                List<ServView> servViews = servMapper.selectRecommendServsView(params);
                if(null==zoom||zoom==0){//全量搜索后台数据,推荐全网优秀数据
                    Integer totalCount=servMapper.selectRecommendServsViewCount(params);
                    PageUtils.setPage(servViews, totalCount, pageSize, page);
                    return page;
                }else{
                    zoom=10;//默认搜索10公里范围数据
                    getDataByDistance(servRequest, zoom, servViews);
                    Integer totalCount=servMapper.selectServsViewCount(params);
                    PageUtils.setPage(servViews, totalCount, pageSize, page);
                    return page;
                }
            }
            if(baseservTypeid!=null){
                params.put("baseservTypeid",baseservTypeid);
            }
            if(states!=null){
                params.put("state",states);
            }
            List<ServView> list = servMapper.selectServsView(params);//获取所有数据

            if(null==zoom||zoom==0){
//                Integer totalCount=servMapper.selectServsViewCount(params);
                Integer totalCount=15;
                Collections.sort(list);
                if(list!=null&&list.size()>15){
                    list = list.subList(0, 15);
                }
                PageUtils.setPage(list, totalCount, pageSize, page);
                return page;
            }else{

                getDataByDistance(servRequest, zoom, list);
                Integer totalCount=servMapper.selectServsViewCount(params);
                PageUtils.setPage(list, totalCount, pageSize, page);
                return page;
            }

        }
    }

    private void getDataByDistance(ServRequest servRequest, Integer zoom, List<ServView> list) {
        if(list!=null&&list.size()>0){
            Double latitude = Double.valueOf(servRequest.getLatitude());//当前用户的
            Double longitude = Double.valueOf(servRequest.getLongitude());
//            for (ServView servView : list) {
            Iterator<ServView> it = list.iterator();
            while(it.hasNext()){
                ServView next = it.next();
                if(servRequest.getLatitude()!=null&&next.getLongitude()!=null){
                    Double latitude1 =  Double.valueOf(next.getLatitude());//服务人员的。
                    Double longitude1 =  Double.valueOf(next.getLongitude());
//                    插入经纬度

                    System.out.println("开始计算：--------------");
                    System.out.println("Impl：getBaseServ:api当前请求经纬度为的经纬度为:[longitude,latitude]---["+longitude+","+latitude+"]");
                    System.out.println("getBaseServ:api服务人员的经纬度为:[longitude,latitude]---["+longitude1+","+latitude1+"]");

                    if(latitude1 !=null&& longitude1 !=null){
                        //计算两个经纬度的距离
                        double v = MapUtils.GetDistance(latitude, longitude, latitude1, longitude1)/1000;
                        if(v>zoom){
                            it.remove();
                            continue;
                        }
                        next.setDistance(v);//千米(单位)
                        System.out.println("两个经纬度计算结果：--------------"+(v)+"千米");
                    }
                }
                System.out.println("输出的列表视图："+next);
            }
        }
    }

    @Override
    public Page<ServView> getBaseServAnon(ServRequest servRequest) {
        Long baseservTypeid = servRequest.getBaseservTypeid();
        Integer pageNo = servRequest.getPageNo();
        Integer pageSize = servRequest.getPageSize();
        Page<ServView> page = new Page<>(pageNo,pageSize);

        Map<String,Object> params=new HashMap<>();
        if(null!=baseservTypeid&&baseservTypeid.equals(1L)){//关注
            List<ServView> servViews = servMapper.selectAttentionServsView(page,params);
            Integer totalCount=servMapper.selectAttentionServsViewCount(params);
            PageUtils.setPage(servViews, totalCount, pageSize, page);
            return page;
        }else if(null!=baseservTypeid&&baseservTypeid.equals(2L)){//推荐
            List<ServView> servViews = servMapper.selectRecommendServsView(page,params);
            Integer totalCount=servMapper.selectRecommendServsViewCount(params);
            PageUtils.setPage(servViews, totalCount, pageSize, page);
            return page;
        }
        if(baseservTypeid!=null){
            params.put("baseservTypeid",baseservTypeid);
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
        Integer releaseServCount = this.getReleaseServCount(releaseServRequest.getOpenid());

        String token = request.getHeader("token");
//        String openid = JWT.unsign(token, String.class);
        String openid =releaseServRequest.getOpenid();
        if(openid==null||openid.equals("")){
            openid=releaseServRequest.getOpenid();
        }
        Long id = null;
//        WeiXinUser weiXinUser = VCache.get(openid, WeiXinUser.class);
        WeiXinUser weiXinUser = null;
        String avatarUrl = null;
        String maxPublishNum="5";
        Long servManid =null;

        weiXinUser = weiXinUserService.getWeiXinUserByOpenId(openid);
        if(weiXinUser!=null){
            id=weiXinUser.getId();//serv_manid
            if(weiXinUser.getUserInfo()!=null){
                maxPublishNum = weiXinUser.getUserInfo();//可以发布的最大数量
            }

        }

        Integer maxReleaseCountValue=Integer.parseInt(maxPublishNum);
        if(releaseServCount!=null){
            if(releaseServCount>maxReleaseCountValue){
                return 0;
            }
            if(releaseServCount==0){
                if(weiXinUser!=null){
                    servManid = weiXinUser.getServManid();
                }
                if(null==servManid){
                    insertServMan(openid, weiXinUser);
                }
            }
        }else{
            //发布私服前，获取当前登录用户的信息，新增servman到服务器。
            if(weiXinUser!=null){
                servManid = weiXinUser.getServManid();
            }
            if(null==servManid){
                insertServMan(openid, weiXinUser);
            }
        }
//        id = weiXinUser.getId();//serv_manid




        //发布私服前下载用户头像到服务器
        if(weiXinUser!=null){
            avatarUrl = weiXinUser.getAvatarUrl();
        }

        if(avatarUrl!=null){
            String realurl=request.getServletContext().getRealPath("/");
            String path=realurl+"images"+ File.separator;
            log.info("上传文件的路径为：{}",path);
            DownLoadUrl.getImageByUrl(avatarUrl,path,openid+".png");
            ServMan servMan = new ServMan();
            servMan.setSpic(openid);
            servMan.setId(servManid);
            servManMapper.updateByPrimaryKeySelective(servMan);
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
            serv.setServManid(weiXinUser.getServManid());
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
            satis.setCollections(0);
            satis.setThumbs(0);
            satis.setTransmits(0);
            satisMapper.insert(satis);
        }else {
            //个性化私服
        }

        return insert;
    }
    @Override
    public void insertServMan(String openid, WeiXinUser weiXinUser) {
        ServMan servMan = new ServMan();
        String nickName="";
        String gender="";
        String latitude="";
        String longitude="";
        if(weiXinUser!=null){
            nickName=weiXinUser.getNickName()==null?"":weiXinUser.getNickName();
            gender=weiXinUser.getGender()==null?"":weiXinUser.getGender().toString();
            latitude=weiXinUser.getLatitude()==null?"":weiXinUser.getLatitude();
            longitude=weiXinUser.getLongitude()==null?"":weiXinUser.getLongitude();
        }
        servMan.setSname(nickName);
        servMan.setSsex(gender);
        servMan.setEnable("1");

        ServManGps servManGps = new ServManGps();
        servManGps.setLatitude(latitude);
        servManGps.setLongitude(longitude);

        servManGpsMapper.insertSelective(servManGps);
        log.info("插入autoid");
        Long autoId = servManGps.getId();
        log.info("autoid",autoId);
        servMan.setServManGpsid(autoId);
        servMan.setSpic(openid);
        servMan.setStel(weiXinUser==null?"":weiXinUser.getUserTel());
        servMan.setIdentityCard(weiXinUser==null?"":weiXinUser.getUnionId());
        servMan.setServAddress(weiXinUser==null?"":weiXinUser.getCompanyAddress());
        servManMapper.insertSelective(servMan);

        Long servManIdOuto = servMan.getId();
        servManGps.setServManid(servManIdOuto);
        servManGpsMapper.updateByPrimaryKey(servManGps);

        WeiXinUser weiXinUser1 = new WeiXinUser();
        weiXinUser1.setOpenId(openid);
        weiXinUser1.setServManid(servManIdOuto);
        weiXinUserService.updateWeiXinUserByOpenId(weiXinUser1);
    }

    @Override
    public Page<ServView> getReleaseServs(ServRequest servRequest,HttpServletRequest request) {
        String token = request.getHeader("token");
//        String openid = JWT.unsign(token, String.class);

        String openid = servRequest.getOpenid();
        Integer pageNo = servRequest.getPageNo();
        Integer pageSize = servRequest.getPageSize();
        Page<ServView> page = new Page<>(pageNo,pageSize);
        Integer totalCount=0;
        List<ServView> servViews =new ArrayList<>();
        if(openid!=null&&!"".equals(openid)){
            WeiXinUser weiXinUserByOpenId = weiXinUserService.getWeiXinUserByOpenId(openid);

            assert weiXinUserByOpenId != null;
            Long id = weiXinUserByOpenId.getServManid();//serv_manid
            if(null==id){
                PageUtils.setPage(servViews, totalCount, pageSize, page);
                return page;
            }
            servRequest.setServManid(id);
            log.info("获取微信用户openid:{},服务人员serv_manid:{}",openid,id);

            Map<String,Object> params=new HashMap<>();
            Long servManid = servRequest.getServManid();
            params.put("servManid",servManid);
            params.put("state",1);
            servViews = servMapper.selectReleaseServsView(page,params);
             totalCount=servMapper.selectReleaseServsViewCount(params);
            PageUtils.setPage(servViews, totalCount, pageSize, page);
            return page;
        }else{
            PageUtils.setPage(servViews, totalCount, pageSize, page);
            return page;
        }

    }

    /**
    * @Description: 查询所有已经发布的私服数量
    * @Param: [openid]
    * @return: java.lang.Integer
    * @Author: Mr.Wang
    * @Date: 2018/7/2
    */
    public Integer getReleaseServCount(String openid){
        Map<String,Object> params=new HashMap<>();
        /*WeiXinUser weiXinUser = VCache.get(openid, WeiXinUser.class);
        if(weiXinUser==null){
            weiXinUser=weiXinUserService.getWeiXinUserByOpenId(openid);
            VCache.setCache(1,openid,weiXinUser,1000*60*60*24*30);
        }*/
        WeiXinUser weiXinUser=weiXinUserService.getWeiXinUserByOpenId(openid);
        Long servManid = weiXinUser.getServManid();
        if(null==servManid){
            return null;
        }
        params.put("servManid",servManid);
        log.info("getReleaseServCount:servManid:{}",servManid);
//        params.put("state",1);
        Integer totalCount=servMapper.selectReleaseServsViewCount(params);
        log.info("getReleaseServCount:微信用户{}已经发布了{}条数据服务",openid,totalCount);
        return totalCount;
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
            detailServsView.setDistance(v/1000);
        }

        List<Label> labelsByServId = labelService.getLabelsByServId(Long.valueOf(id));//评价

        detailServsView.setServLabels(labelsByServId);
        Integer attentionCount = attentionService.getAttentionCount(new Attention(openid, Long.valueOf(id)));
        detailServsView.setAttention(attentionCount);//是否关注

        Integer totalAttentionCount = attentionService.getAttentionCount(new Attention(null, Long.valueOf(id)));

        detailServsView.setTotalAttentions(totalAttentionCount);//总关注次数

//        Long servContentid = detailServsView.getServContentid();



        //服务内容
        ServContent servContent = new ServContent();
            servContent.setServid(id);
            List<ServContent> servContents = servContentService.getServContentByServId(servContent);//条目
            detailServsView.setServContents(servContents);
        return detailServsView;
    }

    @Override
    public Serv selectByPrimaryKey(Long id) {

        Serv serv = servMapper.selectByPrimaryKey(id);
        return serv;
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

        System.out.println("servid"+servid);
        System.out.println("disserv"+disserv);
        System.out.println("attention"+attention);
        System.out.println("illegal"+illegal);
        System.out.println("classification"+classification);
        System.out.println("openid"+openid);

        if(null==servid){
            servid=optServRequest.getId();
        }
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

        if(attention!=null){
            log.debug(openid+"用户**** attention **** : " + servid+"私服");
            if(attention==0){
                Integer attentionCount = attentionService.getAttentionCount(new Attention(openid,servid));
                if(attentionCount>0){
                    attentionService.delete(new Attention(openid,servid));
                    //对应的关注tbl_satis 减少一个
                    Satis satisByServId = satisService.getSatisByServId(servid);
                    satisByServId.setCollections(satisByServId.getCollections()-1);
                    satisByServId.setErversatis(satisByServId.getErversatis()-1);
                    satisService.updateSatis(satisByServId);
                }
            }else{
                attentionService.insert(new Attention(openid, servid));
                //对应的关注增加一个
                Satis satisByServId = satisService.getSatisByServId(servid);
                satisByServId.setCollections(satisByServId.getCollections()+1);
                satisByServId.setErversatis(satisByServId.getErversatis()+1);
                satisService.updateSatis(satisByServId);
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


    @Override
    public Integer deleteServ(ServRequest request){
        int i = 0;
            Serv serv = new Serv();
            serv.setId(request.getId());
            serv.setState((byte) 0);
            i = servMapper.updateByPrimaryKeySelective(serv);
        return i;
    }

    @Override
    public DetailServView getServById(ServRequest servRequest) {

        try {
            Serv serv = servMapper.selectByPrimaryKey(servRequest.getId());
            DetailServView detailServView = new DetailServView();
            detailServView.setId(serv.getId());
            detailServView.setServName(serv.getServName());
            detailServView.setServTimeid(serv.getServTimeid());
            detailServView.setBaseservTypeid(serv.getBaseservTypeid());
            detailServView.setServNote(serv.getServNote());
            ServContent servContent = new ServContent();
            servContent.setServid(new Integer(serv.getId().toString()));
            List<ServContent> servContentByServId = servContentService.getServContentByServId(servContent);

            detailServView.setServContents(servContentByServId);
            return detailServView;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer updateReleaseServ(ReleaseServRequest releaseServRequest) {
        try {
            Long id = releaseServRequest.getId();
            Long baseServTypeid = releaseServRequest.getBaseServTypeid();//服务类型
            List<ServContent> servContents = releaseServRequest.getServContents();//服务内容
            Long servTimeId = releaseServRequest.getServTimeId();//私服时间
            String servNote = releaseServRequest.getServNote();//个性化服务内容
            String servName = releaseServRequest.getServName();
            Serv serv = new Serv();
            serv.setId(id);
            serv.setBaseservTypeid(baseServTypeid);
            serv.setServTimeid(servTimeId.intValue());
            serv.setServNote(servNote);
            serv.setServName(servName);
            servMapper.updateByPrimaryKeySelective(serv);

            //更新服务内容
            for (ServContent servContent : servContents) {
                servContentMapper.updateByPrimaryKeySelective(servContent);
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public void transmits(OptServRequest optServRequest) {
        //转发：增加数量信息
        if(optServRequest!=null&&optServRequest.getServid()!=null){
            Satis satisByServId = satisService.getSatisByServId(optServRequest.getServid());
            satisByServId.setTransmits(satisByServId.getTransmits()+1);
            satisByServId.setErversatis(satisByServId.getErversatis()+1);
            satisService.updateSatis(satisByServId);
        }
       //转发：插入转发表。
        if(optServRequest!=null&&optServRequest.getOpenid()!=null&&optServRequest.getServid()!=null){
            Transmits transmits = new Transmits();
            transmits.setOpenid(optServRequest.getOpenid());
            transmits.setServid(optServRequest.getServid());
            transmitsService.insertSelective(transmits);
        }

    }
}
