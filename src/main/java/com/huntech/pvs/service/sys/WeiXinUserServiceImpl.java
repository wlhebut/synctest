package com.huntech.pvs.service.sys;

import com.huntech.pvs.common.util.MapUtils;
import com.huntech.pvs.dao.sys.WeiXinUserMapper;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.model.sys.WeiXinUserExample;
import com.huntech.pvs.view.services.ServRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeiXinUserServiceImpl implements WeiXinUserService {

    @Autowired
    private WeiXinUserMapper weiXinUserMapper;
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

    @Override
    public boolean posChanged(ServRequest servRequest) {

        WeiXinUser weiXinUserByOpenId = this.getWeiXinUserByOpenId(servRequest.getOpenid());
        Double latitude = Double.valueOf(weiXinUserByOpenId.getLatitude());//历史的位置
        Double longitude = Double.valueOf(weiXinUserByOpenId.getLongitude());

        Double latitude1 = Double.valueOf(servRequest.getLatitude());//现在请求的位置。
        Double longitude1 = Double.valueOf(servRequest.getLongitude());
        double v = MapUtils.GetDistance(latitude, longitude, latitude1, longitude1);
        return !(v > 200d);
    }
}
