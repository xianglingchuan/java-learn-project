package com.myspringmvc.proxy.cglib;

import org.springframework.aop.framework.DefaultAopProxyFactory;
import org.springframework.cglib.proxy.Enhancer;

import com.myspringmvc.proxy.staticproxy.ISubject;
import com.myspringmvc.proxy.staticproxy.RealSubject;

public class Client {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(RealSubject.class);
		enhancer.setCallback(new CglibProxySubject());
		ISubject iSubject = (ISubject) enhancer.create();
		iSubject.request();
		System.out.println("");
		iSubject.setName("jack");
		System.out.println("");
		iSubject.getName();
	}

}
