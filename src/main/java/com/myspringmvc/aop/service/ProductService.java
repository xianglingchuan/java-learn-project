package com.myspringmvc.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.myspringmvc.aop.bean.Product;

@Service
public class ProductService {
	
	
	@Autowired
	private AuthService authService;
	
	
	public void insert(Product product){
		authService.checkAccess();
		System.out.println("insert product");
	}
	
	
	public void delete(Long id){
		System.out.println("delete");
		authService.checkAccess();
		System.out.println("delete product");
	}
	
	

}
