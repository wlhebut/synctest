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

        WeiXinUser weiXinUser = new WeiXinUser();
        weiXinUser.setOpenId("123456");
        weiXinUser.setCity("beijing");
        VCache.setCache(0,"test:1",weiXinUser,1);
        VCache.setCache(0,"test:10",weiXinUser,10);
        VCache.setCache(0,"test:100",weiXinUser,100);
        VCache.setCache(0,"test:1000",weiXinUser,1000);







        String token ;
        token=request.getHeader("token");
        ResponseData responseData = ResponseData.ok();



        //token不存在
        if(null != token) {
            String openid_new = JWT.unsign(token, String.class);
            String openid = (String) request.getSession().getAttribute("openid");
            //解密token后的loginId与用户传来的loginId不一致，一般都是token过期
            System.out.println("小程序传过来的token："+openid_new);
            System.out.println("session中的token："+openid);

            if(null != openid_new) {
                if(!openid_new.equals("")) {
                    System.out.println("小程序传过来的认证通过token："+openid_new);
                    return true;
                }
                else{
                    responseData = ResponseData.forbidden();
                    responseMessage(response, response.getWriter(), responseData);
                    return false;
                }
            }
            else
            {
                responseData = ResponseData.forbidden();
                responseMessage(response, response.getWriter(), responseData);
                return false;
            }
        }
        else
        {
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
