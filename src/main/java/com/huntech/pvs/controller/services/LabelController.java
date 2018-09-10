package com.huntech.pvs.controller.services;


import com.huntech.pvs.common.BaseController;
import com.huntech.pvs.service.services.LabelService;
import com.huntech.pvs.view.request.LabelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("label")
public class LabelController extends BaseController{


    @Autowired
    private LabelService labelService;

    /**
     * @Description:
     * 返回参数：
     * 1：插入成功
     * 0：您已经插入，只可以插入一次
     * 2：不能给自己插入评价
     * -1：系统错误
     * -2：参数不足
     * -3：请重新登录
     * @Param: []
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.Wang
     * @Date: 2018/7/2
     */
    @RequestMapping("insertLabel")
    @ResponseBody
    public Map<String, Object> insertLabel(@RequestBody LabelRequest labelRequest){
        Integer integer=1;
        String openid = labelRequest.getOpenid();
        Long id = labelRequest.getId();
        String labelContent = labelRequest.getLabelContent();
        if(openid==null||id==null||labelContent==null||"".equals(labelContent)){
            resultMap.put("dataDesc","缺少openid|id|labelContent参数");
            resultMap.put("dataCode",-2);
        }
        try {
             integer = labelService.insertLabel(labelRequest);
             resultMap.put("dataCode",integer);
             if(integer==1){
                 resultMap.put("dataDesc","插入成功");
             }else if(integer==0){
                 resultMap.put("dataDesc","对于同一个服务，最多评价三次！");
             }else if(integer==2){
                 resultMap.put("dataDesc","不能给自己插入评价");
             }else if(integer==-3){
                 resultMap.put("dataDesc","请重新登录,权限不够");
             }else{
                 resultMap.put("dataDesc","wrong");
             }
             return resultMap;
        } catch (Exception e) {
            integer=-1;
            resultMap.put("dataCode",integer);
            resultMap.put("dataDesc","系统错误");
            e.printStackTrace();
            return resultMap;
        }


    }
}
