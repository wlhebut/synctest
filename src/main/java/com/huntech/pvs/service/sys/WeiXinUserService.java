package com.huntech.pvs.service.sys;

import com.huntech.pvs.model.address.Address;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.view.services.ServRequest;

import java.util.Map;

public interface WeiXinUserService {
   WeiXinUser  getWeiXinUserByOpenId(String openid);
   int  updateWeiXinUserByOpenId(WeiXinUser weiXinUser);

   Map<String, Address> posChanged(ServRequest servRequest);

   WeiXinUser getWeiXinSerByServId(Long servManId);
}
