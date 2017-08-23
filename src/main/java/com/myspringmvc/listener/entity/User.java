package com.myspringmvc.listener.entity;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class User implements HttpSessionBindingListener, HttpSessionActivationListener, Serializable {
	
	private String username;
	
	private String password;
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("User valueBound name:"+event.getName());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("User valueUnbound name:"+event.getName());
	}

	//纯化
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("User sessionWillPassivate source:"+se.getSource());
	}

	//活化
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("User sessionDidActivate source:"+se.getSource());
	}

}
