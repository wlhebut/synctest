package com.huntech.pvs.controller.services;

import com.huntech.pvs.common.BaseController;
import com.huntech.pvs.core.feature.orm.mybatis.Page;
import com.huntech.pvs.model.services.SelfServ;
import com.huntech.pvs.model.services.Serv;
import com.huntech.pvs.service.services.SelfServService;
import com.huntech.pvs.service.services.ServService;
import com.huntech.pvs.view.request.DetailServRequest;
import com.huntech.pvs.view.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("serv")
public class ServController extends BaseController {

    @Autowired
    private ServService servService;

    @Autowired
    private SelfServService selfServService;
/**
* @Description: find serv
* @Param: [servRequest]
* @return: java.util.Map<java.lang.String,java.lang.Object>
* @Author: Mr.Wang
* @Date: 2018/5/25
*/
    @RequestMapping(value = "getBaseServ")
    @ResponseBody
    public Map<String, Object> getBaseServ(@RequestBody ServRequest servRequest) {
        Page<ServView> list = servService.getBaseServ( servRequest);
        resultMap.put("data",list);
        return resultMap;
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

    @RequestMapping(value = "getAllBaseServ")
    @ResponseBody
    public Map<String, Object> getAllBaseServ(ServRequest servRequest) {
//        List<ServView> list = servService.getBaseServ( servRequest);
        Page<Serv> list = servService.selectByExampleAndPage( servRequest);
        resultMap.put("data",list);
        return resultMap;
    }
    @RequestMapping(value = "releaseServ")
    @ResponseBody
    public Map<String, Object> releaseServ(@RequestBody ReleaseServRequest releaseServRequest, HttpServletRequest request) {
//        List<ServView> list = servService.getBaseServ( servRequest);
        Integer integer = servService.releaseServ( releaseServRequest,request);
        resultMap.put("data",integer);
        resultMap.put("erroCode",integer);
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
            resultMap.put("erroCode","1");
        } catch (Exception e) {
            resultMap.put("erroCode","-1");
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
            resultMap.put("erroCode","1");
        } catch (Exception e) {
            resultMap.put("erroCode","-1");
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
            resultMap.put("data",releaseServs);
            resultMap.put("erroCode",1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resultMap.put("erroCode",0);
        }

        return resultMap;
    }

    @RequestMapping(value = "getDetailBaseServ")
    @ResponseBody
    public Map<String, Object> getDetailBaseServ(@RequestBody DetailServRequest detailServRequest) {

        try {
            DetailServView detailServView = servService.getDetailServViewById(detailServRequest);
            resultMap.put("data",detailServView);
            resultMap.put("erroCode","1");
        } catch (Exception e) {
            resultMap.put("erroCode","-1");
            e.printStackTrace();
        }
        return resultMap;
    }

}
