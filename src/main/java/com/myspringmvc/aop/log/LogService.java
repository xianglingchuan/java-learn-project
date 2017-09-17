package com.myspringmvc.aop.log;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.myspringmvc.aop.bean.Product;
import com.myspringmvc.aop.security.AdminOnly;

@Service
//@Qualifier("LogService")
public class LogService implements Loggable {
	
	@Override
	@AdminOnly
	public void log(){
		System.out.println("log from LogService");
	}
	
	
	public void annoArg(Product product){
		System.out.println("execute log service annoArg");
	}

}
