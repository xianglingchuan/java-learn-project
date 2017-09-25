package com.myspringmvc.proxy.transactiondemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	
	@RequestMapping("/app/index.do")
    public String hello(){
        System.out.println("hello world");
        return "success";
    }
	
}
