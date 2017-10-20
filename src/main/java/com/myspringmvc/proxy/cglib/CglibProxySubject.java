package com.myspringmvc.proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;


public class CglibProxySubject implements MethodInterceptor  {

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		
		Object result = null;
		System.out.println("before....");
		
		try {
			result = methodProxy.invokeSuper(obj, args);
		} catch (Exception e) {
			System.out.println("ex:"+e.getMessage());
			throw e;
		}finally {
			System.out.println("after....");
		}
		return result;
	}

}
