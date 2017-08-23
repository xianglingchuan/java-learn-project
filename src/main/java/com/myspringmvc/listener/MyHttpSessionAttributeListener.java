package com.myspringmvc.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("****HttpSession****attributeAdded name="+se.getName());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("****HttpSession****attributeRemoved name="+se.getName());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("****HttpSession****attributeReplaced name="+se.getName());
	}

}
