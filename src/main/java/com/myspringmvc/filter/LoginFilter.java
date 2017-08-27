package com.myspringmvc.filter;

import java.io.IOException;
import java.net.NetPermission;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class LoginFilter implements Filter {

	private FilterConfig config;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		config = filterConfig;
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		//request.setCharacterEncoding("UTF-8");
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpSession session = httpServletRequest.getSession();
		String username = (String)session.getAttribute("username");
		System.out.println("******username*****:"+username);
		
		
		//String username2 = httpServletRequest.getParameter("username");
		
		String noLoginPaths = config.getInitParameter("noLoginPaths");
		String[] paths = noLoginPaths.split(";");
		if(paths!=null){
			for(int i=0; i<paths.length; i++){
				if(paths[i]==null || paths[i].equals("")){
					continue;
				}				
				if(httpServletRequest.getRequestURL().indexOf(paths[i])!=-1){
					chain.doFilter(httpServletRequest, response);
					return;
				}
			}
		}
		
		if(username!=null){
			chain.doFilter(request, response);
		}else{
			httpServletResponse.sendRedirect(request.getServletContext().getContextPath()+"/filter/login.jsp");
			//request.getServletContext().getContextPath()
		}		
	}

	@Override
	public void destroy() {
		
	}

	
}
