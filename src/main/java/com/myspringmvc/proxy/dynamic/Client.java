package com.myspringmvc.proxy.dynamic;

import java.lang.reflect.Proxy;


import com.myspringmvc.proxy.staticproxy.ISubject;
import com.myspringmvc.proxy.staticproxy.RealSubject;

public class Client {
	
	public static void main(String[] args) {
		
		//查看动态生成的代理类字切码文件
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		
		
		
		//动态代理使用方法
	  ISubject iSubject = (ISubject)Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{ISubject.class}, 
				new JdkProxySubject(new RealSubject()));
	  iSubject.request();
	  System.out.println("");
	  iSubject.setName("dynamicProxy");
	  System.out.println("");
	  iSubject.getName();
	}

}
