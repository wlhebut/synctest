package com.huntech.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReqRespFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println(" >>>>>>>>>>>>>>>> ReqRespFilter 销毁中....");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filter)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest)req;
		
		String path = httpReq.getServletPath().toLowerCase();
		if (path.endsWith(".js") || path.endsWith(".css") || path.endsWith(".jpg") || 
				path.endsWith(".png") || path.endsWith(".gif")){
			filter.doFilter(req, resp);
			return;
		}
		
		long beginTime = System.currentTimeMillis();
		filter.doFilter(req, resp);
		long endTime = System.currentTimeMillis();
		
		HttpServletResponse httpResp = (HttpServletResponse)resp;
		System.out.println(new InnerParam(httpReq, httpResp, endTime - beginTime).toString());
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println(" .............. ReqRespFilter 初始化....");
	}

	public static class InnerParam {
		
		private StringBuffer msg = new StringBuffer();
		
		InnerParam(HttpServletRequest httpReq, HttpServletResponse httpResp, long time){
			httpReq.setAttribute("currentTimeMillis", String.valueOf(System.currentTimeMillis()));
			msg.append("\n\r");
			msg.append("Request >>> getContextPath = " + httpReq.getContextPath()).append("\n");
			msg.append("Request >>> getServletPath = " + httpReq.getServletPath()).append("\n");
			msg.append("Request >>> getPathInfo = " + httpReq.getPathInfo()).append("\n");
			
			msg.append("Response >>> getBufferSize = "+httpResp.getBufferSize()).append("\n");
			msg.append("Response >>> getStatus = "+httpResp.getStatus()).append("\n");
			
			msg.append("【耗时】 "+time+" 毫秒").append("\n");
		}
		
		public String toString(){
			return msg.toString();
		}
	}
}
