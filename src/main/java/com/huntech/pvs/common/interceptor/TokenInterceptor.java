package com.huntech.pvs.common.interceptor;


import com.alibaba.fastjson.JSONObject;
import com.huntech.pvs.common.ResponseData;
import com.huntech.pvs.common.redis.VCache;
import com.huntech.pvs.common.util.JWT;
import com.huntech.pvs.common.util.SpringContextUtil;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.service.sys.impl.WeiXinUserServiceImpl;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;

public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*String token ;
        token=request.getHeader("token");
        System.out.println("tokeninterceptor--token:"+token);

        //获取所有的头部参数

        Enumeration<String> headerNames=request.getHeaderNames();

        for(Enumeration<String> e=headerNames;e.hasMoreElements();){

            String thisName= e.nextElement();

            String thisValue=request.getHeader(thisName);

            System.out.println("header的key:"+thisName+"--------------header的value:"+thisValue);

        }



        WeiXinUserServiceImpl bean = SpringContextUtil.getBean("weiXinUserServiceImpl", WeiXinUserServiceImpl.class);

        response.setCharacterEncoding("utf-8");


        System.out.println("当前用户请求头为:"+token);

        String requestURI = request.getRequestURI();
        Enumeration<String> em = request.getParameterNames();

        System.out.println("current request meth:"+requestURI);
       *//* boolean b = em.hasMoreElements();
        if(b){
            String name =  em.nextElement();
            String value = request.getParameter(name);
            System.out.println("form表单请求的参数名称:"+name+"请求的参数值："+value);
        }


        BufferedReader br = request.getReader();
        String str, wholeStr = "";
        while((str = br.readLine()) != null){
            wholeStr += str;
        }
        System.out.println("body--Json中请求的参数名称:"+wholeStr);*//*

        ResponseData responseData = ResponseData.ok();
        //token不存在
        if(null != token) {
            String openid_new = JWT.unsign(token, String.class);
//            String openid = (String) request.getSession().getAttribute("openid");
            String openid = "";
            if(null != openid_new) {
                WeiXinUser weiXinUser = VCache.get(openid_new, WeiXinUser.class);


                if(weiXinUser==null){//数据库获取
                    weiXinUser = bean.getWeiXinUserByOpenId(openid_new);
//                    VCache.setCache(1,openid,weiXinUser,1000*60*60*24*2);
                    if(weiXinUser!=null){
                        VCache.setCache(1,openid,weiXinUser,1000*60);
                    }else{
                        //获取用户信息登陆
                        responseData = ResponseData.login();
                        responseMessage(response, response.getWriter(), responseData);
                        return false;
                    }
                }
                assert weiXinUser!=null;
                String nickName = weiXinUser.getNickName();
                Byte gender = weiXinUser.getGender();
                String avatarUrl = weiXinUser.getAvatarUrl();
                //判断数据库的参数
                if(nickName==null||gender==null||avatarUrl==null||"".equals(nickName)||"".equals(avatarUrl)){

                    weiXinUser = bean.getWeiXinUserByOpenId(openid_new);
                    VCache.setCache(1,openid,weiXinUser,1000*60*60*24*2);
                    nickName = weiXinUser.getNickName();
                    gender = weiXinUser.getGender();
                    avatarUrl = weiXinUser.getAvatarUrl();
//                    if(openid==null||nickName==null||gender==null||avatarUrl==null||"".equals(nickName)||"".equals(avatarUrl)){
//                        responseData = ResponseData.reLogin();
//                        responseMessage(response, response.getWriter(), responseData);
//                        return false;
//                    }

                }
                //判断数据库的位置
                *//*String longitude = weiXinUser.getLongitude();
                String latitude = weiXinUser.getLatitude();
                if(longitude==null||"".equals(longitude)||latitude==null||"".equals(latitude)){
                    weiXinUser = bean.getWeiXinUserByOpenId(openid_new);
                    VCache.setCache(1,openid,weiXinUser,1000*60*60*24*2);
                    longitude = weiXinUser.getLongitude();
                    latitude = weiXinUser.getLatitude();
                    if(longitude==null||"".equals(longitude)||latitude==null||"".equals(latitude)){
                        responseData = ResponseData.position();
                        responseMessage(response, response.getWriter(), responseData);
                        return false;
                    }
                }*//*


                if(weiXinUser!=null){
                    openid= weiXinUser.getOpenId();
                }
                //解密token后的loginId与用户传来的loginId不一致，一般都是token过期
                System.out.println("小程序传过来的openid_new："+openid_new);
                System.out.println("redis中的openid："+ (weiXinUser != null ? weiXinUser.getOpenId() : null));
                if(!openid_new.equals("")&&openid.equals(openid_new)) {
                    System.out.println("小程序当前登录用户以前登录过："+openid_new);
                    return true;
                }else{
                    responseData = ResponseData.forbidden();
                    responseMessage(response, response.getWriter(), responseData);
                    return false;
                }
            }else{
                responseData = ResponseData.forbidden();
                responseMessage(response, response.getWriter(), responseData);
                return false;
            }
        }else{
            responseData = ResponseData.forbidden();
            responseMessage(response, response.getWriter(), responseData);
            return false;
        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
    //请求不通过，返回错误信息给客户端
    private void responseMessage(HttpServletResponse response, PrintWriter out, ResponseData responseData) {
//        responseData = ResponseData.forbidden();
        response.setContentType("application/json; charset=utf-8");
        String json = JSONObject.toJSONString(responseData);
        out.print(json);
        out.flush();
        out.close();
    }
}
