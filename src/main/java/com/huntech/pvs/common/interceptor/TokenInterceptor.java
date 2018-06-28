package com.huntech.pvs.common.interceptor;


import com.alibaba.fastjson.JSONObject;
import com.huntech.pvs.common.ResponseData;
import com.huntech.pvs.common.redis.VCache;
import com.huntech.pvs.common.util.JWT;
import com.huntech.pvs.model.sys.WeiXinUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        String token ;
        token=request.getHeader("token");
        System.out.println("当前用户请求头为:"+token);
        ResponseData responseData = ResponseData.ok();
        //token不存在
        if(null != token) {
            String openid_new = JWT.unsign(token, String.class);
//            String openid = (String) request.getSession().getAttribute("openid");
            String openid = "";

            WeiXinUser weiXinUser1 = VCache.get(openid_new, WeiXinUser.class);

            if(weiXinUser1!=null){
                openid= weiXinUser1.getOpenId();
            }
            //解密token后的loginId与用户传来的loginId不一致，一般都是token过期
            System.out.println("小程序传过来的openid_new："+openid_new);
            System.out.println("redis中的openid："+ (weiXinUser1 != null ? weiXinUser1.getOpenId() : null));

            if(null != openid_new) {
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
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
    //请求不通过，返回错误信息给客户端
    private void responseMessage(HttpServletResponse response, PrintWriter out, ResponseData responseData) {
        responseData = ResponseData.forbidden();
        response.setContentType("application/json; charset=utf-8");
        String json = JSONObject.toJSONString(responseData);
        out.print(json);
        out.flush();
        out.close();
    }
}
