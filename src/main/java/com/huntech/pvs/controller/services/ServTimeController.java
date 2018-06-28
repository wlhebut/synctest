package com.huntech.pvs.controller.services;

import com.huntech.pvs.common.BaseController;
import com.huntech.pvs.model.services.ServTime;
import com.huntech.pvs.service.services.ServTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("servTime")
public class ServTimeController extends BaseController {

    @Autowired
    private ServTimeService servTimeService;

    @RequestMapping("getAll")
    @ResponseBody
    public Map<String, Object> getAll(){
        try {
            List<ServTime> allServTime = servTimeService.getAllServTime();
            resultMap.put("data",allServTime);
            resultMap.put("dataCode",1);
            return resultMap;
        } catch (Exception e) {
            resultMap.put("dataCode",-1);
            e.printStackTrace();
        }
        return  resultMap;


    }
}
