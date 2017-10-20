package com.myspringmvc.proxy.staticproxy;

public class RealSubject implements ISubject {

	
	private String name;
	
	@Override
	public void request() {
		System.out.println("execution RealSubject request");
	}

	@Override
	public void setName(String name) {
		System.out.println("execution RealSubject setName:"+name);
		this.name = name;
		
	}

	@Override
	public String getName() {
		System.out.println("execution RealSubject getName");
		return name;
		
	}

	
	
	
}
