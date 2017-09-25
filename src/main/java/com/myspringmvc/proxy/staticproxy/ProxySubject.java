package com.myspringmvc.proxy.staticproxy;

public class ProxySubject implements ISubject {

	
	private RealSubject realSubject;
	
	
	public ProxySubject(RealSubject realSubject){
		this.realSubject = realSubject;
	}
	
	
	@Override
	public void request() {
		System.out.println("Before....");
		realSubject.request();
		System.out.println("After....");
	}


	@Override
	public void setName(String name) {
		System.out.println("Before....");
		realSubject.setName(name);
		System.out.println("After....");
		
	}


	@Override
	public String getName() {
		System.out.println("Before....");
		return realSubject.getName();
	}

}
