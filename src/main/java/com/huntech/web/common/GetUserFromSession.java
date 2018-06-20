package com.huntech.web.common;

import com.huntech.pvs.dto.sys.User;
import com.huntech.pvs.model.sys.SysInformation;
import com.huntech.pvs.view.sys.UserView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * session 获取用户信息
 * Created by lida on 16/11/25.
 */
public class GetUserFromSession {

    public static UserView getLoginUserInfo(HttpServletRequest request) {
        UserView user = (request.getSession().getAttribute("userInfo") != null) ? (UserView) request.getSession().getAttribute("userInfo") : null;
        return user;
    }

    public static String getLoginUserName(HttpServletRequest request) {
        UserView user = (request.getSession().getAttribute("userInfo") != null) ? (UserView) request.getSession().getAttribute("userInfo") : null;
        String userName = (user == null) ? "system" : user.getName();
        return userName;
    }

    public static Long getLoginUserSid(HttpServletRequest request) {
        UserView user = (request.getSession().getAttribute("userInfo") != null) ? (UserView) request.getSession().getAttribute("userInfo") : null;
        Long userSid = (user == null) ? 0 : user.getSid();
        return userSid;
    }

    public static String getRemoteUrl(HttpServletRequest request) {
        String remoteUrl = "";//远程url
        List<SysInformation> sysInformationList = (List<SysInformation>) request.getSession().getAttribute("sysInformationList");
        if(null != sysInformationList && sysInformationList.size() > 0){
            for (SysInformation sysInformation : sysInformationList) {
                if("remoteurl".equals(sysInformation.getInfoSign())){
                    remoteUrl = sysInformation.getInfoValue();
                }
            }
        }
        return remoteUrl;
    }

    public static String getSysLevel(HttpServletRequest request) {
        String sysLevel = "";//系统级别
        List<SysInformation> sysInformationList = (List<SysInformation>) request.getSession().getAttribute("sysInformationList");
        if(null != sysInformationList && sysInformationList.size() > 0){
            for (SysInformation sysInformation : sysInformationList) {
                if("systemlevel".equals(sysInformation.getInfoSign())){
                    sysLevel = sysInformation.getInfoValue();
                }
            }
        }
        return sysLevel;
    }

    public static String getNativeip(HttpServletRequest request) {
        String nativeIp = "";//本地IP
        List<SysInformation> sysInformationList = (List<SysInformation>) request.getSession().getAttribute("sysInformationList");
        if(null != sysInformationList && sysInformationList.size() > 0){
            for (SysInformation sysInformation : sysInformationList) {
                if("nativeip".equals(sysInformation.getInfoSign())){
                    nativeIp = sysInformation.getInfoValue();
                }
            }
        }
        return nativeIp;
    }

}


//GetUserFromSession.getLoginUserInfo(request);
//GetUserFromSession.getLoginUserName(request);
//GetUserFromSession.getLoginUserSid(request);