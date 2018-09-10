package com.huntech.pvs.service.sys.impl;

import com.huntech.pvs.common.util.MapUtils;
import com.huntech.pvs.dao.sys.WeiXinUserMapper;
import com.huntech.pvs.model.address.Address;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.model.sys.WeiXinUserExample;
import com.huntech.pvs.service.address.AddressService;
import com.huntech.pvs.service.sys.WeiXinUserService;
import com.huntech.pvs.view.services.ServRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WeiXinUserServiceImpl implements WeiXinUserService {

    @Autowired
    private WeiXinUserMapper weiXinUserMapper;

    @Autowired
    private AddressService addressService;
    @Override
    public WeiXinUser getWeiXinUserByOpenId(String openid) {

        WeiXinUserExample example = new WeiXinUserExample();
        WeiXinUserExample.Criteria criteria = example.createCriteria();
        if(openid!=null){
            criteria.andOpenIdEqualTo(openid);
        }
        List<WeiXinUser> weiXinUsers = weiXinUserMapper.selectByExample(example);
        if(weiXinUsers!=null&&weiXinUsers.size()>0){
            WeiXinUser weiXinUser = weiXinUsers.get(0);
            return weiXinUser;
        }
        return null;
    }

    @Override
    public int updateWeiXinUserByOpenId(WeiXinUser weiXinUser) {
        if(weiXinUser!=null){
            String openid=weiXinUser.getOpenId();
            WeiXinUserExample example = new WeiXinUserExample();
            WeiXinUserExample.Criteria criteria = example.createCriteria();
            if(openid!=null){
                criteria.andOpenIdEqualTo(openid);
            }
            int i = weiXinUserMapper.updateByExampleSelective(weiXinUser,example);
            return i;
        }
        return  -1;
    }

    /**
    * @Description: 从当前位置列表中获取所有可能的位置，计算出最近的位置作为可能的地址。
    * @Param: [servRequest]
    * @return: java.util.Map<java.lang.String,com.huntech.pvs.model.address.Address>
    * @Author: Mr.Wang
    * @Date: 2018/7/6
    */
    @Override
    public Map<String, Address>  posChanged(ServRequest servRequest) {

        Map<String, Address> resAddress = new HashMap<>();
//        WeiXinUser weiXinUser = this.getWeiXinUserByOpenId(servRequest.getOpenid());
        List<Address> addressList = addressService.getAddress(servRequest.getOpenid());
        if(addressList!=null&&addressList.size()>0){
            for (Address address : addressList) {
                Double cLatitudeD = null;
                Double cLongitudeD = null;
                String cLatitude = address.getLatitude();
                String cLongitude = address.getLongitude();
                if(cLatitude!=null&&cLongitude!=null&&!"".equals(cLatitude)&&!"".equals(cLongitude)){
                    cLatitudeD =Double.valueOf(cLatitude);
                    cLongitudeD=Double.valueOf(cLongitude);
                }else{
                   continue;
                }
                Double latitude1;
                Double longitude1;
                if(servRequest.getLatitude()!=null&&servRequest.getLongitude()!=null){
                     latitude1 = Double.valueOf(servRequest.getLatitude());//现在请求的位置。
                     longitude1 = Double.valueOf(servRequest.getLongitude());
                }else{
                    resAddress.put("reqAddr",null);
                    return resAddress;
                }
                if(cLatitudeD!=null&&cLongitudeD!=null){
                    double v = MapUtils.GetDistance(cLatitudeD, cLongitudeD, latitude1, longitude1);
                    if(v < 200d){
                        resAddress.put("reqAddr",address);
                        return resAddress;
                    }
                }
            }
        }else{
            resAddress.put("reqAddr",null);
        }
        resAddress.put("reqAddr",null);
        return resAddress;
    }

    @Override
    public WeiXinUser getWeiXinSerByServId(Long servManId) {

        WeiXinUserExample example = new WeiXinUserExample();
        WeiXinUserExample.Criteria criteria = example.createCriteria();
        criteria.andServManidEqualTo(servManId);
        List<WeiXinUser> weiXinUser = weiXinUserMapper.selectByExample(example);
        if(weiXinUser!=null&&weiXinUser.size()>0){
            return weiXinUser.get(0);
        }
        return null;
    }
}
