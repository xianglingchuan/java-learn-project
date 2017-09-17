package com.myspringmvc.aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("BookAuth")
	public void BooKAuth() {
		System.out.println("###begin BookAuth###");
	}		
	
}
