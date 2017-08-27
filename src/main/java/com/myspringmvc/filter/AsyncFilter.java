package com.myspringmvc.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.tomcat.jni.Thread;

/**
 * Servlet3.0样式
 * 
 * */
@WebFilter(filterName="AsynFilter",value={"/AsyncServlet"},dispatcherTypes={DispatcherType.REQUEST,DispatcherType.ASYNC},asyncSupported=true)
public class AsyncFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("start.....AsyncFilter");
		chain.doFilter(request, response);
		System.out.println("start.....AsyncFilter");
		
	}

	@Override
	public void destroy() {
		
	}

}
