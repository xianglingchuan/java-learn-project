package com.myspringmvc.proxy;

import com.myspringmvc.proxy.staticproxy.ProxySubject;
import com.myspringmvc.proxy.staticproxy.RealSubject;

public class SubjectApplication {
	
	public static void main(String[] args) {
		
		ProxySubject proxySubject = new ProxySubject(new RealSubject());
		proxySubject.request();
		System.out.println("");
		proxySubject.setName("staticProxy");
		System.out.println("");
		proxySubject.getName();
		
	}

}
