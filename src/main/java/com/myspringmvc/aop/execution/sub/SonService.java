package com.myspringmvc.aop.execution.sub;

import org.springframework.stereotype.Component;

import com.myspringmvc.aop.execution.ParserService;

@Component
public class SonService extends ParserService {

	public void demo() {
		System.out.println("execute sub service method");
	}
}
