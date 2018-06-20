package com.huntech.pvs.controller.address;

import com.huntech.pvs.common.BaseController;
import com.huntech.pvs.model.address.AddressCity;
import com.huntech.pvs.model.address.AddressProvince;
import com.huntech.pvs.model.address.AddressTown;
import com.huntech.pvs.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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
}
