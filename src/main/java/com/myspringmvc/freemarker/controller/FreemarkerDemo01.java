package com.myspringmvc.freemarker.controller;





import java.util.Date;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/freemarker")
public class FreemarkerDemo01 {

	
	@RequestMapping("demo01")
	public ModelAndView helloMvc(){
		ModelAndView mView = new ModelAndView();
		mView.addObject("intVar", 10);
		mView.addObject("longVar", 100000l);
		mView.addObject("booleanVar",true);
		mView.addObject("stringVar", "spring boot");
		mView.addObject("doubleVar", 3.1415);
		mView.addObject("sqldateVar", new java.sql.Date(new Date().getTime()));
		mView.addObject("utildateVar", new java.sql.Date(new Date().getTime()));
		mView.addObject("nullVar", null);
		//mView.addObject("nullVar", "100");
		return mView;
	}
	
}
