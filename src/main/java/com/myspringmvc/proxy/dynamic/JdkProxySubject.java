package com.myspringmvc.proxy.dynamic;

import java.lang.reflect.Method;

import java.lang.reflect.InvocationHandler;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import com.myspringmvc.proxy.staticproxy.RealSubject;

public class JdkProxySubject implements InvocationHandler {

	
	private RealSubject realSubject;
	
	public JdkProxySubject(RealSubject realSubject){
	   this.realSubject = realSubject;	
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before...");
		Object result = null;
		
		try {
			result = method.invoke(realSubject, args);
		} catch (Exception e) {
			System.out.println("ex:"+e.getMessage());
			throw e;
		}finally {
			System.out.println("after...");
		}
		return result;
	}

}
