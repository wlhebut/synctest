package com.huntech.pvs.service.address.impl;

import com.huntech.pvs.common.redis.VCache;
import com.huntech.pvs.common.util.StringUtils;
import com.huntech.pvs.dao.address.AddressCityMapper;
import com.huntech.pvs.dao.address.AddressProvinceMapper;
import com.huntech.pvs.dao.address.AddressTownMapper;
import com.huntech.pvs.model.address.*;
import com.huntech.pvs.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressProvinceMapper addressProvinceMapper;

    @Autowired
    private AddressCityMapper addressCityMapper;

    @Autowired
    private AddressTownMapper addressTownMapper;

    static VCache cache;
    final static String PROVINCE =  "province";
    final static String CITY =  "city";
    final static String TOWN =  "town";



    @Override
    public List<AddressProvince> getProvince(String code) {
        AddressProvinceExample addressProvinceExample = new AddressProvinceExample();
         List<AddressProvince> list = cache.get(PROVINCE, List.class);
        if(StringUtils.isBlank(list)){
            list = addressProvinceMapper.selectByExample(addressProvinceExample);
            cache.setVByList(PROVINCE,list);
        }

        return list;
    }
    @Override
    public List<AddressCity> getCity(String provinceCode) {
        AddressCityExample example = new AddressCityExample();
        AddressCityExample.Criteria criteria = example.createCriteria();
        criteria.andProvinceCodeEqualTo(provinceCode);
        List<AddressCity> list = addressCityMapper.selectByExample(example);
        return list;
    }
    @Override
    public List<AddressTown> getTown(String cityCode)
    {
        AddressTownExample example = new AddressTownExample();
        AddressTownExample.Criteria criteria = example.createCriteria();
        criteria.andCityCodeEqualTo(cityCode);
        List<AddressTown> list = addressTownMapper.selectByExample(example);
        return list;
    }

}
