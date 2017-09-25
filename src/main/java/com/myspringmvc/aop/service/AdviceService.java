package com.myspringmvc.aop.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class AdviceService {

	public void getFuite() {
		System.out.println("execute getFuite...");
	}

	public void setName(String name) {
		System.out.println("execute setName...name:" + name);
	}

	public void getName() {
		System.out.println("execute getName...");
	}
	
	
	public void getAge() {
		throw new RuntimeException("Rutime Exception");
	}	

}
