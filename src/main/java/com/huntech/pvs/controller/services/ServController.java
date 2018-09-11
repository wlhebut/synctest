package com.huntech.pvs.controller.services;

import com.huntech.pvs.common.BaseController;
import com.huntech.pvs.core.feature.orm.mybatis.Page;
import com.huntech.pvs.dao.sys.WeiXinUserMapper;
import com.huntech.pvs.model.address.Address;
import com.huntech.pvs.model.services.SelfServ;
import com.huntech.pvs.model.services.Serv;
import com.huntech.pvs.model.services.ServMan;
import com.huntech.pvs.model.services.ServManGps;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.service.services.SelfServService;
import com.huntech.pvs.service.services.ServManGpsService;
import com.huntech.pvs.service.services.ServManService;
import com.huntech.pvs.service.services.ServService;
import com.huntech.pvs.service.sys.WeiXinUserService;
import com.huntech.pvs.view.request.DetailServRequest;
import com.huntech.pvs.view.request.OptServRequest;
import com.huntech.pvs.view.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
@Slf4j
@Controller
@RequestMapping("serv")
public class ServController extends BaseController {

    @Autowired
    private ServService servService;

    @Autowired
    private SelfServService selfServService;

    @Autowired
    private ServManService servManService;

    @Autowired
    private WeiXinUserService weiXinUserService;

    @Autowired
    private ServManGpsService servManGpsService;
/**
* @Description: find serv
* @Param: [servRequest]
* @return: java.util.Map<java.lang.String,java.lang.Object>
* @Author: Mr.Wang
* @Date: 2018/5/25
 *
 * zoom;
 * 1.默认为0,表示不根据位置查询服务
 * 2.设置为1
 *
*/
    @RequestMapping(value = "getBaseServ")
    @ResponseBody
    public Map<String, Object> getBaseServ(@RequestBody ServRequest servRequest) {
        try {
            Page<ServView> list = servService.getBaseServ( servRequest);
            resultMap.put("data",list);
            resultMap.put("dataCode","1");
            resultMap.put("dataDesc","ok");
            return resultMap;
        }catch (Exception e) {
            resultMap.put("dataCode","-1");
            resultMap.put("dataDesc","后台错误");
            e.printStackTrace();
            return resultMap;
        }
    }


    /**
    * @Description: get serv on map
    * @Param: [servRequest]
    * 	"state":"1",
    *   "servType":"0",
        "baseservTypeid":"4",
        "longitude":2.123213,
        "latitude":234.324222222,
        "zoom":15
    * @return: java.util.Map<java.lang.String,java.lang.Object>
    * @Author: Mr.Wang
    * @Date: 2018/5/25
    */
    @RequestMapping(value = "getBaseServOnMap")
    @ResponseBody
    public Map<String, Object> getBaseServOnMap(@RequestBody ServRequest servRequest) {
        Page<ServView> list = servService.getBaseServOnMap( servRequest);
        resultMap.put("data",list);
        return resultMap;
    }


    @RequestMapping(value = "releaseServ")
    @ResponseBody
    public Map<String, Object> releaseServ(@RequestBody ReleaseServRequest releaseServRequest, HttpServletRequest request) {
//        List<ServView> list = servService.getBaseServ( servRequest);

        if(releaseServRequest.getLongitude()==null||releaseServRequest.getLatitude()==null||"".equals(releaseServRequest.getOpenid())){
            resultMap.clear();
            resultMap.put("dataCode","-2");
            resultMap.put("dataDesc","经纬度参数：[longitude,latitude]");
            return resultMap;
        }
        String longitude = releaseServRequest.getLongitude();
        String latitude = releaseServRequest.getLatitude();

        //完善定位
        String openid = releaseServRequest.getOpenid();
        WeiXinUser weiXinUserByOpenId = weiXinUserService.getWeiXinUserByOpenId(openid);

        weiXinUserByOpenId.setLongitude(longitude);
        weiXinUserByOpenId.setLatitude(latitude);
        if(!"".equals(openid)&&openid!=null){
            weiXinUserService.updateWeiXinUserByOpenId(weiXinUserByOpenId);
        }


        System.out.println("发布私服：releaseServ:api当前请求经纬度为的经纬度为:[longitude,latitude]---["+longitude+","+latitude+"]");
        try {
            Integer integer = servService.releaseServ(releaseServRequest, request);
            resultMap.put("dataCode",1);
            if(integer==0){
                resultMap.put("dataCode",0);
                resultMap.put("dataDesc","每个用户只可以发布5条私服");
                log.info("微信用户：{}已经发布{}条私服！",releaseServRequest.getOpenid(),integer);
                return resultMap;
            }

        } catch (Exception e) {
            resultMap.put("dataCode",-1);
            e.printStackTrace();
        }
        return resultMap;
    }


    @RequestMapping(value = "updateReleaseServ")
    @ResponseBody
    public Map<String, Object> updateReleaseServ(@RequestBody ReleaseServRequest releaseServRequest) {
//        List<ServView> list = servService.getBaseServ( servRequest);
        if(releaseServRequest.getId()==null){
            resultMap.put("dataCode",-2);
            resultMap.put("dataDesc","缺少参数id");
            return resultMap;
        }
        try {
            Integer integer = servService.updateReleaseServ(releaseServRequest);
            resultMap.put("dataCode",integer);
            resultMap.put("dataDesc","修改成功!");
        } catch (Exception e) {
            resultMap.put("dataCode",-1);
            resultMap.put("dataDesc","系统错误");
            e.printStackTrace();
        }
        return resultMap;
    }
    @RequestMapping(value = "insertSelfAddServ")
    @ResponseBody
    public Map<String, Object> insertSelfAddServ(@RequestBody SelfAddServRequest selfAddServRequest, HttpServletRequest request) {
//        List<ServView> list = servService.getBaseServ( servRequest);
        Integer integer;
        try {
            integer = selfServService.insertSelfAddServ( selfAddServRequest,request);
            resultMap.put("data",integer);
            resultMap.put("dataCode","1");
        } catch (Exception e) {
            resultMap.put("dataCode","-1");
            e.printStackTrace();
        }
        return resultMap;
    }
    @RequestMapping(value = "getSelfServ")
    @ResponseBody
    public Map<String, Object> getSelfServ(HttpServletRequest request) {
        List<SelfServ> selfServs;
        try {
            selfServs = selfServService.getSelfServs(request);
            resultMap.put("data",selfServs);
            resultMap.put("dataCode","1");
        } catch (Exception e) {
            resultMap.put("dataCode","-1");
            e.printStackTrace();
        }
        return resultMap;
    }
    @RequestMapping(value = "delReleaseServ")
    @ResponseBody
    public Map<String, Object> delReleaseServ(@RequestBody ServRequest request) {
        Integer integer;
        Long id = request.getId();
        if(id==null){
            resultMap.put("dataCode","-2");
            resultMap.put("dataDesc","缺少id参数");
            return resultMap;
        }
        try {
            Integer integer1 = servService.deleteServ(request);
            resultMap.put("dataCode",integer1);
            if(integer1==0){
                resultMap.put("dataDesc","删除失败");
            }else{
                resultMap.put("dataDesc","删除成功");
            }
        } catch (Exception e) {
            resultMap.put("dataCode","-1");
            resultMap.put("dataDesc","系统错误");
            e.printStackTrace();
        }
        return resultMap;
    }
    @RequestMapping(value = "getReleaseServs")
    @ResponseBody
    public Map<String, Object> getReleaseServs(@RequestBody ServRequest servRequest,HttpServletRequest request) {
//        List<ServView> list = servService.getBaseServ( servRequest);
        try {
            Page<ServView> releaseServs = servService.getReleaseServs(servRequest,request);
            if(releaseServs!=null){
                resultMap.clear();
                resultMap.put("data",releaseServs);
                resultMap.put("dataCode",1);
            }else{
                resultMap.clear();
                resultMap.put("data",releaseServs);
                resultMap.put("dataCode",-1);
            }

        } catch (Exception e) {
            resultMap.clear();
            resultMap.put("dataCode",-1);
            e.printStackTrace();
        }
        return resultMap;
    }


    @RequestMapping(value ="getReleaseServById")
    @ResponseBody
    public Map<String, Object> getReleaseServById(@RequestBody ServRequest servRequest) {
//        List<ServView> list = servService.getBaseServ( servRequest);
        if(servRequest.getId()==null){
            resultMap.put("dataCode",-2);
            resultMap.put("dataDesc","缺少id参数");
            return resultMap;
        }
        try {
            DetailServView serv= servService.getServById(servRequest);
            if(serv!=null){
                resultMap.put("data",serv);
                resultMap.put("dataCode",1);
                resultMap.put("dataDesc","OK");
                return resultMap;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("dataCode",-1);
            return resultMap;
        }
        return resultMap ;
    }

    @RequestMapping(value = "getDetailBaseServ")
    @ResponseBody
    public Map<String, Object> getDetailBaseServ(@RequestBody DetailServRequest detailServRequest) {

        if(detailServRequest!=null&&detailServRequest.getId()!=null){
            try {
                DetailServView detailServView = servService.getDetailServViewById(detailServRequest);
                resultMap.put("data",detailServView);
                resultMap.put("dataCode","1");
                return resultMap;
            } catch (Exception e) {
                resultMap.put("dataCode","-1");
                e.printStackTrace();
                return  resultMap;
            }
        }else{
            resultMap.put("dataCode","-2");//参数不全
            resultMap.put("dataDesc","缺少id参数");//参数不全
        }
        return resultMap;
    }

    /**
    * @Description:
     *
     * 输入参数	servid	必填项	对应列表id
                disserv		 （喜欢：1，不喜欢0）
                attention		红心（关注：1，不关注0 ）
                illegal		违法内容 illegal  （违法：1，不违法0）
                classification		（分类错误1，没错误0）
                openid		用户的openid

     *
    * @Param: [detailServRequest]
    * @return: java.util.Map<java.lang.String,java.lang.Object>
    * @Author: Mr.Wang
    * @Date: 2018/6/22
    */
    @RequestMapping(value = "optBaseServByUser")
    @ResponseBody
    public Map<String, Object> optBaseServByUser(@RequestBody OptServRequest optServRequest) {
        try {
            servService.optBaseServByUser(optServRequest);
            resultMap.put("dataCode","1");
        } catch (Exception e) {
            resultMap.put("dataCode","0");
            e.printStackTrace();
        }
        return resultMap;
    }

/**
* @Description: 转发
* @Param: [optServRequest]
* @return: java.util.Map<java.lang.String,java.lang.Object>
* @Author: Mr.Wang
* @Date: 2018/9/3
*/
    @RequestMapping(value = "transmits")
    @ResponseBody
    public Map<String, Object> transmits(@RequestBody OptServRequest optServRequest) {
        try {
            servService.transmits(optServRequest);
            resultMap.put("dataCode","1");
        } catch (Exception e) {
            resultMap.put("dataCode","0");
            e.printStackTrace();
        }
        return resultMap;
    }

    //	用于获取发送信息时的头像，使用流
    @RequestMapping("/head/{servManid}")
    public void gethead(@PathVariable("servManid")Long servManid, HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String realurl=request.getServletContext().getRealPath("/");
        /*log.info("request.getServletContext().getRealPath{}",realurl);
        Serv serv = servService.selectByPrimaryKey(servManid);
        Long servManidReal = null;
        WeiXinUser weiXinSerByServId =null;*/
        WeiXinUser weiXinSerByServId =null;
        if(servManid!=null){
            weiXinSerByServId = weiXinUserService.getWeiXinSerByServId(servManid);
        }

        if(servManid!=null&&weiXinSerByServId.getOpenId()!=null){
            String url=realurl+File.separator+"images"+File.separator+weiXinSerByServId.getOpenId();
            logger.info("log:reuest-->url:{}"+url);
            System.out.println(url);
            String png=".png";
            String jpg=".jpg";
            String jpeg=".jpeg";
            InputStream inputStream;
            if(new File(url+png).exists()){
                inputStream=new FileInputStream(url+png);
            }else if(new File(url+jpg).exists()){
                inputStream=new FileInputStream(url+jpg);
            }else if(new File(url+jpeg).exists()){
                inputStream=new FileInputStream(url+jpeg);
            }else{
                url=realurl+File.separator+"images"+File.separator+"default.png";
                inputStream=new FileInputStream(url);
            }


            ServletOutputStream outputStream=response.getOutputStream();
            response.setContentType("image/jpeg; charset=UTF-8");
            byte[] buffer=new byte[1024];
            int i;
            while((i=inputStream.read(buffer))!=-1)
            {
                outputStream.write(buffer, 0, i);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }
    }
}
