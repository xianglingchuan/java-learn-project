package com.myspringmvc.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myspringmvc.aop.service.ProductService;



@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping("index.do")
	public void index() {
		productService.getName();
		System.out.println("productService:"+productService);		
	}		
	
}