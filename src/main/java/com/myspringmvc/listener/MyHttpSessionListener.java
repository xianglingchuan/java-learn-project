package com.myspringmvc.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

	
    private int userNumber;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		userNumber ++;
		se.getSession().getServletContext().setAttribute("userNumber", userNumber);
		System.out.println("******sessionCreated******");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		userNumber --;
		se.getSession().getServletContext().setAttribute("userNumber", userNumber);		
		System.out.println("******sessionDestroyed******");

	}

}
