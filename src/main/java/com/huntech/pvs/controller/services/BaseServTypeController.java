package com.huntech.pvs.controller.services;

import com.huntech.pvs.common.BaseController;
import com.huntech.pvs.model.address.AddressProvince;
import com.huntech.pvs.model.services.BaseServType;
import com.huntech.pvs.service.services.BaseServTypeService;
import com.huntech.pvs.view.request.BaseServTypeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("baseServType")
public class BaseServTypeController extends BaseController {

    @Autowired
    private BaseServTypeService baseServTypeService;

    /**
    * @Description:
    * @Param: [baseServType]
    * @return: java.util.Map<java.lang.String,java.lang.Object>
    * @Author: Mr.Wang
    * @Date: 2018/5/25
    */
    @RequestMapping(value = "getBaseServType")
    @ResponseBody
    public Map<String, Object> getBaseServType(@RequestBody BaseServType baseServType) {
        List<BaseServType> list = baseServTypeService.getBaseServType( baseServType);
        resultMap.put("data",list);
        return resultMap;
    }
    @RequestMapping(value = "getBaseServTypeByOpenId")
    @ResponseBody
    public Map<String, Object> getBaseServTypeByOpenId(@RequestBody BaseServTypeRequest baseServType) {
        List<BaseServType> list = baseServTypeService.getBaseServTypeByOpenId( baseServType);
        resultMap.put("data",list);
        return resultMap;
    }
    @RequestMapping(value = "updateBaseServTypeByOpenId")
    @ResponseBody
    public Map<String, Object> updateBaseServTypeByOpenId(@RequestBody BaseServTypeRequest baseServTypes) {
        Integer integer = baseServTypeService.updateByOpenId(baseServTypes);
        resultMap.put("erroCode","1");
        return resultMap;
    }

}
