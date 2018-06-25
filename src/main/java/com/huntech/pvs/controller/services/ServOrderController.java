package com.huntech.pvs.controller.services;


import com.huntech.pvs.common.BaseController;
import com.huntech.pvs.model.services.ServOrder;
import com.huntech.pvs.service.services.ServOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("servOrder")
public class ServOrderController extends BaseController {

    @Autowired
    private ServOrderService servOrderService;


    @RequestMapping(value = "getServOrder")
    @ResponseBody
    public Map<String, Object> getServOrder(@RequestBody  ServOrder servOrder){
        List<ServOrder> list = null;
        try {
            list = servOrderService.getServOrders(servOrder);
            resultMap.put("data",list);
            resultMap.put("dataCode","1");
        } catch (Exception e) {
            resultMap.put("dataCode","0");
            e.printStackTrace();
        }
        return resultMap;
    }


    @RequestMapping(value = "delServOrder")
    @ResponseBody
    public Map<String, Object> delServOrder(@RequestBody  ServOrder servOrder){
        try {
            servOrderService.delServOrder(servOrder.getId());
            resultMap.put("dataCode","1");
        } catch (Exception e) {
            resultMap.put("dataCode","0");
            e.printStackTrace();
        }
        return resultMap;
    }

    @RequestMapping(value = "insertServOrder")
    @ResponseBody
    public Map<String, Object> insertServOrder(@RequestBody  ServOrder servOrder){
        try {
            servOrderService.insertServOrder(servOrder);
            resultMap.put("dataCode","1");
        } catch (Exception e) {
            resultMap.put("dataCode","0");
            e.printStackTrace();
        }
        return resultMap;
    }





}
