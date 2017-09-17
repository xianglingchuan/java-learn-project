package com.myspringmvc.aop;

import com.myspringmvc.aop.service.ProductService;

public class Test {
	
	public static void main(String[] args) {
		
		ProductService service = new ProductService();
		service.delete(1L);
		
	}

}
