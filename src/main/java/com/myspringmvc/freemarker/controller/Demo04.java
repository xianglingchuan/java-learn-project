package com.myspringmvc.freemarker.controller;





import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myspringmvc.entity.User;


@Controller
@RequestMapping("/freemarker")
public class Demo04 {

	
	@RequestMapping("demo04")
	public ModelAndView helloMvc(){
		ModelAndView mView = new ModelAndView();
		mView.addObject("sort_int", new SortMethod());
		return mView;
	}
	
}
