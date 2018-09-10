package com.huntech.pvs.controller.address;

import com.huntech.pvs.common.BaseController;
import com.huntech.pvs.model.address.Address;
import com.huntech.pvs.model.address.AddressCity;
import com.huntech.pvs.model.address.AddressProvince;
import com.huntech.pvs.model.address.AddressTown;
import com.huntech.pvs.service.address.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
@Slf4j
@Controller
@RequestMapping("address")
public class AddressController extends BaseController {


    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "getProvince")
    @ResponseBody
    public Map<String, Object> getProvince(String code) {
        List<AddressProvince> addressProvinces = addressService.getProvince(code);
        resultMap.put("data",addressProvinces);
        return resultMap;
    }

    @RequestMapping(value = "getCity")
    @ResponseBody
    public Map<String, Object> getCity(String code) {
        List<AddressCity> addressCities = addressService.getCity(code);
        resultMap.put("data",addressCities);
        return resultMap;
    }

    @RequestMapping(value = "getTown")
    @ResponseBody
    public Map<String, Object> getTown(String code) {
        List<AddressTown> addressTowns = addressService.getTown(code);
        resultMap.put("data",addressTowns);
        return resultMap;
    }

    /**
    * @Description: 用户点击位置页面，获取当前位置后，提交当前的经纬度给后台。
    * @Param: [address]
    * @return: java.util.Map<java.lang.String,java.lang.Object>
    * @Author: Mr.Wang
    * @Date: 2018/7/6
    */
    @RequestMapping(value = "updateAddress")
    @ResponseBody
    public Map<String, Object> updateAddress(@RequestBody Address address) {
        System.out.println("保存当前的经纬度到后台："+"["+address.getLongitude()+","+address.getLatitude()+"]");
        String openid=address.getOpenid();
        if(openid==null||openid.equals("")){
            resultMap.put("dataCode",-2);
            resultMap.put("dataDesc","需要openid");
            return resultMap;
        }
        try {
            addressService.updateAddress(address);
            resultMap.put("dataCode",1);
            resultMap.put("dataDesc","修改成功");
        } catch (Exception e) {
            resultMap.put("dataCode",-1);
            resultMap.put("dataDesc","系统错误");
            e.printStackTrace();
        }
        return resultMap;
    }
}
