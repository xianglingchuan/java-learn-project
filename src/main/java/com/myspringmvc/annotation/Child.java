package com.myspringmvc.annotation;

@MyDescription("I am Child class annotation")
public class Child implements Person {

	@MyDescription("I am Child method annotaton")
	public String name(){
		return null;
	}
	
	@MyDescription("I am Child method annotaton")
	public String author(){
		return null;
	}
	
	
}
