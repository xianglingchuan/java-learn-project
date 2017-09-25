package com.myspringmvc.aop.within.service;

import org.springframework.stereotype.Service;

@Service
public class ArticleService {

	
	public void add(String title){
		System.out.println("add title:"+title);
	}
	
	public String getTitle(){
		return "hello java";
	}
	
	
}
