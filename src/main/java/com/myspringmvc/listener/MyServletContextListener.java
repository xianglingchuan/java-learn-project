package com.myspringmvc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		
		String contextConfigLocation = sce.getServletContext().getInitParameter("contextConfigLocation");
		String initParam = sce.getServletContext().getInitParameter("initParam");
		System.out.println("******contextInitialized******");
		System.out.println("contextConfigLocation:"+contextConfigLocation);
		System.out.println("initParam:"+initParam);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("******contextDestroyed******");
		
	}

}
