package com.myspringmvc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener("This a servlet3.0 listener 3.0")
public class MyServlet3ContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("******MyServlet3ContextListener***** contextInitialized "+sce.getSource());

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("******MyServlet3ContextListener***** contextDestroyed"+sce.getSource());
	}
}
