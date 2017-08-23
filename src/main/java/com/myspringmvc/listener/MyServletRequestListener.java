package com.myspringmvc.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("******requestDestroyed******");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		String name = sre.getServletRequest().getParameter("name");
		
		System.out.println("******requestInitialized******name:"+name);
	}

}
