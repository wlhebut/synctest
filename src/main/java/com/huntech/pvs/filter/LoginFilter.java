package com.huntech.pvs.filter;


import redis.clients.jedis.Jedis;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse)response;
        HttpServletRequest req = (HttpServletRequest)request;
//        HttpSession session = req.getSession();

        String jsessionid = req.getHeader("JSESSIONID");
//连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        jedis.auth("123456");
//        String openid = jedis.get(jsessionid);
        String openid = jedis.get("name");
//        String openid = (String)session.getAttribute(jsessionid);
        String uri = req.getRequestURI();

        if(openid==null&&!uri.contains("login")){//没有用户,或者登陆api不过滤
            //判断用户是否是选择跳到登录界面
            if(!uri.contains("rest")){
                chain.doFilter(request, response);
            }else{
                resp.sendRedirect(req.getContextPath()+"/rest/weixin/login");
            }
        }else{//有用户
            chain.doFilter(request, response);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
