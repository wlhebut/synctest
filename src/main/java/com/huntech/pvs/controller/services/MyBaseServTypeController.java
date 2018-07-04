package com.huntech.pvs.controller.services;

import com.huntech.pvs.common.BaseController;
import com.huntech.pvs.model.services.MyBaseservType;
import com.huntech.pvs.service.services.MyBaseServTypeService;
import com.huntech.pvs.view.request.MyServsRequest;
import com.huntech.pvs.view.services.MyServViews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("myBaseType")
public class MyBaseServTypeController extends BaseController {

    @Autowired
    private MyBaseServTypeService myBaseServTypeService;

    @RequestMapping(value = "getMyServs")
    @ResponseBody
    public Map<String, Object> getMyServs(@RequestBody MyServsRequest myServsRequest) {

        String openid = myServsRequest.getOpenid();
        if("".equals(openid)||null==openid){
            resultMap.put("dataDesc","参数不足");
            resultMap.put("dataCode","-2");
        }
        try {
            List<MyServViews> myServViews = myBaseServTypeService.selectAllServsByOpenid(myServsRequest);
            resultMap.put("data",myServViews);
            resultMap.put("dataCode","1");
        } catch (Exception e) {
            resultMap.put("dataCode","-1");
            resultMap.put("dataDesc","系统错误");
            e.printStackTrace();
        }
        return resultMap;
    }

    @RequestMapping(value = "updateMyServsType")
    @ResponseBody
    public Map<String, Object> updateMyServsType(@RequestBody MyBaseservType myServsRequest) {

        String openid = myServsRequest.getOpenid();
        if("".equals(openid)||null==openid||myServsRequest.getMyServType().equals("")){
            resultMap.put("dataDesc","参数不足");
            resultMap.put("dataCode","-2");
        }
        try {
            myBaseServTypeService.updateByTypeId(myServsRequest);
            resultMap.put("dataCode","1");
        } catch (Exception e) {
            resultMap.put("dataCode","-1");
            resultMap.put("dataDesc","系统错误");
            e.printStackTrace();
        }
        return resultMap;
    }
}
