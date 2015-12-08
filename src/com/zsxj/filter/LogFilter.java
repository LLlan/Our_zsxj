package com.zsxj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 讲页面日志记录下来
 */
@WebFilter("/*")
public class LogFilter implements Filter {

   
	@Override
	public void destroy() {
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//System.out.println(date + "--" + ip +"---"+req.getRequestURL());
		/*req.getContextPath();
		req.getRequestURI();
		req.getServletContext();
		req.getQueryString();*/
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
