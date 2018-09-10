package com.huntech.pvs.controller.services;

import com.huntech.pvs.common.BaseController;
import com.huntech.pvs.model.services.MyServs;
import com.huntech.pvs.service.services.MyServsService;
import com.huntech.pvs.view.request.MyServsDelRequest;
import com.huntech.pvs.view.request.MyServsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
@RequestMapping("myServ")
public class MyServsController extends BaseController{

    @Autowired
     private MyServsService myServsService;

    @RequestMapping("insertMyServs")
    @ResponseBody
    public Map<String, Object> insertMyServs(@RequestBody MyServsRequest myServs){

        if(myServs.getOpenid()==null||"".equals(myServs.getOpenid())){
            resultMap.put("dataDesc","缺少id|openid参数");
            resultMap.put("dataCode",-2);
            return resultMap;
        }
        try {
            myServsService.insertMyServs(myServs);
            resultMap.put("dataDesc","插入成功");
            resultMap.put("dataCode",1);
        } catch (Exception e) {
            resultMap.put("dataDesc","系统错误！");
            resultMap.put("dataCode",-1);
            e.printStackTrace();
        }
        return resultMap;
    }
    @RequestMapping("deleteMyServs")
    @ResponseBody
    public Map<String, Object> deleteMyServs(@RequestBody MyServsDelRequest myServs){
        if(myServs.getId()==null){
            resultMap.put("dataDesc","缺少id参数");
            resultMap.put("dataCode",-2);
            return resultMap;
        }
        try {
            myServsService.deleteMyServs(myServs);
            resultMap.put("dataDesc","删除成功");
            resultMap.put("dataCode",1);
        } catch (Exception e) {
            resultMap.put("dataDesc","系统错误！");
            resultMap.put("dataCode",-1);
            e.printStackTrace();
        }
        return resultMap;
    }
    @RequestMapping("getMyServById")
    @ResponseBody
    public Map<String, Object> getMyServById(@RequestBody MyServsRequest myServs){
        if(myServs.getId()==null||myServs.getOpenid()==null||"".equals(myServs.getOpenid())){
            resultMap.put("dataDesc","缺少openid|id参数");
            resultMap.put("dataCode",-2);
            return resultMap;
        }

        try {
            MyServs myServ = myServsService.getMyServById(myServs.getId());
            resultMap.put("data",myServ);
            resultMap.put("dataDesc","返回成功");
            resultMap.put("dataCode",1);
        } catch (Exception e) {
            resultMap.put("dataDesc","系统错误！");
            resultMap.put("dataCode",-1);
            e.printStackTrace();
        }
        return resultMap;
    }
    @RequestMapping("updateMyServById")
    @ResponseBody
    public Map<String, Object> updateMyServById(@RequestBody MyServs myServs){
        if(myServs.getId()==null||myServs.getOpenid()==null||"".equals(myServs.getOpenid())){
            resultMap.put("dataDesc","缺少id|openid参数");
            resultMap.put("dataCode",-2);
            return resultMap;
        }
        try {
            myServsService.updateMyServById(myServs);
            resultMap.put("dataDesc","更新成功");
            resultMap.put("dataCode",1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }
}
