package com.myspringmvc.aop.within.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myspringmvc.aop.within.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	
	@Autowired
	private ArticleService articleService;
	
	
	@RequestMapping("index.do")
	public void index(){
		
		
		articleService.add("tom");
		articleService.getTitle();
		
		
	}
	
	
}
