package com.huntech.pvs.service.sys;

import com.huntech.pvs.model.sys.WeiXinUser;

public interface WeiXinUserService {
   WeiXinUser  getWeiXinUserByOpenId(String openid);
   int  updateWeiXinUserByOpenId(WeiXinUser weiXinUser);
}
