package com.myspringmvc.aop.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.myspringmvc.aop.security.CurrentUserHolder;

@Component
public class AuthService {
	
	
	public void checkAccess(){
		String user = CurrentUserHolder.get();
		System.out.println("user==="+user);
		if(!"admin".equals(user)){
			throw new RuntimeException("operation not allow");
		}		
	}
}
