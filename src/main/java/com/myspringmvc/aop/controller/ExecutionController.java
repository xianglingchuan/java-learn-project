package com.myspringmvc.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myspringmvc.aop.execution.ParserService;
import com.myspringmvc.aop.execution.sub.SonService;

@Controller
@RequestMapping("/execution")
public class ExecutionController {

	@Autowired
	private ParserService parserService;

	@Autowired
	private SonService sonService;

	@RequestMapping("index.do")
	public void index() {
		System.out.println("###begin test###");
		
		System.out.println("");
		System.out.println("");
		parserService.findById(1L);
		System.out.println("");
		System.out.println("");
		
		System.out.println("");
		System.out.println("");
		parserService.findByTwoArgs(1L, "hello");
		System.out.println("");
		System.out.println("");
		
		System.out.println("");
		System.out.println("");
		parserService.getName();
		System.out.println("");
		System.out.println("");
		
		System.out.println("");
		System.out.println("");
		sonService.demo();
		System.out.println("");
		System.out.println("");
		
		
//		try {
//			sonService.exDemo();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
	}

}
