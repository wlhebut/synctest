package com.huntech.pvs.service.sys;

import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.view.services.ServRequest;

public interface WeiXinUserService {
   WeiXinUser  getWeiXinUserByOpenId(String openid);
   int  updateWeiXinUserByOpenId(WeiXinUser weiXinUser);

   boolean posChanged(ServRequest servRequest);
}
