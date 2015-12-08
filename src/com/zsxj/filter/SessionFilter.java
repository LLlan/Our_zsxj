package com.zsxj.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

/**
 * 检查用户是否登录
 */
//@WebFilter("/base/*")
public class SessionFilter implements Filter 
{

	private String sessionKey;
	private String redireurl;

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//判断是否为空
		if(StringUtils.isBlank(sessionKey)){
			chain.doFilter(request, response);
			return ;
		}
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		//获得当前的页面路径
		String servletpath = req.getServletPath();
		//判断是否是登录页面
		if(servletpath.equals(redireurl)){
			chain.doFilter(request, response);
			return ;
		}
		
		HttpSession session = req.getSession();
		Object object = session.getAttribute(sessionKey);
		if(object == null){
			//主要重定向时要加项目路径
			String contextpath = req.getContextPath();
			res.sendRedirect(contextpath + redireurl);
		}else{
			chain.doFilter(request, response);//继续监控
		}
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		sessionKey = fConfig.getInitParameter("sessionKey");
		redireurl = fConfig.getInitParameter("redireUrl");
	}

}
