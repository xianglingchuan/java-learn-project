package com.myspringmvc.aop.service.sub;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.myspringmvc.aop.service.ProductService;

@Service
@Qualifier("SubService")
public class SubService extends ProductService {

	public void demo(){
		System.out.println("execute sub service method");
	}
}
