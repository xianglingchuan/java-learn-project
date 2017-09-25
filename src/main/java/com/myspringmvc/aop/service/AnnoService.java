package com.myspringmvc.aop.service;

import org.springframework.stereotype.Service;

import com.myspringmvc.aop.security.AdminOnly;
import com.myspringmvc.aop.security.NeedSecured;
import com.myspringmvc.aop.security.NeedSecuredClass;

@NeedSecured
@Service
public class AnnoService {
	
	
	@AdminOnly
	public void getFuite(){
		System.out.println("execute getFuite...");
	}
	
	@AdminOnly
	public void setName(String name){
		System.out.println("execute setName...name:"+name);
	}
	
	public void getName(){
		System.out.println("execute getName...");
	}
	

}
