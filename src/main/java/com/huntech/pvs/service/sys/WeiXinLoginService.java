package com.huntech.pvs.service.sys;

import com.huntech.pvs.model.sys.WeiXinLoginRequest;
import com.huntech.pvs.model.sys.WeiXinUser;

import javax.servlet.http.HttpServletRequest;

public interface WeiXinLoginService {
    String HasUser(WeiXinLoginRequest weiXinLoginRequest);
    int insertUser(WeiXinLoginRequest weiXinLoginRequest);

    WeiXinUser getWeinXinUser(HttpServletRequest request);


    void insertInToRedis(String openid);

    Integer updateWeiXinUser(WeiXinUser user);
}
