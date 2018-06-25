package com.huntech.pvs.controller.services;

import com.huntech.pvs.common.BaseController;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.service.sys.WeiXinUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("weiXinUser")
public class WeinXinUserController extends BaseController{

    @Autowired
    private WeiXinUserService weiXinUserService;

    @RequestMapping("getWeiXinUser")
    @ResponseBody
    public Map<String, Object> getWeiXinUser(@RequestBody WeiXinUser weiXinUser){
        if(weiXinUser!=null&&weiXinUser.getOpenId()!=null){
            WeiXinUser weiXinUserByOpenId = weiXinUserService.getWeiXinUserByOpenId(weiXinUser.getOpenId());
            resultMap.put("data",weiXinUserByOpenId);
            resultMap.put("dataCode",1);
            return resultMap;
        }else{
            resultMap.put("dataCode",-1);
            return  resultMap;
        }
    }
    @RequestMapping("update")
    @ResponseBody
    public Map<String, Object> updateWeiXinUser(@RequestBody WeiXinUser weiXinUser){
        if(weiXinUser!=null&&weiXinUser.getOpenId()!=null){
            int i = weiXinUserService.updateWeiXinUserByOpenId(weiXinUser);
            resultMap.put("dataCode",i);
            return resultMap;
        }else{
            resultMap.put("dataCode",-1);
            return  resultMap;
        }
    }




}
