package com.myspringmvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstFilter  implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init------FirstFilter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("start---doFilter---FirstFilter");		
		//chain.doFilter(request, response);
		
		
		HttpServletRequest request2 = (HttpServletRequest)request;
		HttpServletResponse response2 =(HttpServletResponse)response;
		//在过滤中重新定向到main.jsp这里会出现死循环的状态
		//重定向
//		response2.sendRedirect(request2.getContextPath()+"/main.jsp");
		//转发
		//request2.getRequestDispatcher("main.jsp").forward(request2, response2);
		
		//request2.getRequestDispatcher("middle.jsp").forward(request2, response2);
		request2.getRequestDispatcher("middle.jsp").include(request2, response2);
		
		System.out.println("end---doFilter---FirstFilter");		
	}

	@Override
	public void destroy() {
		System.out.println("destroy------FirstFilter");
	}

	

}
