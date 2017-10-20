package com.myspringmvc.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.myspringmvc.aop.bean.Product;
import com.myspringmvc.aop.log.Loggable;
import com.myspringmvc.aop.security.AdminOnly;

@Service
@Qualifier("ProductService")
public class ProductService implements Loggable {

	@Override
	public void log() {
		System.out.println("log from product service");
		
	}
	
    public String getName(){
        System.out.println("execute get name");
        return "product service";
    }

    public void exDemo() throws IllegalAccessException{
        System.out.println("execute ex demo");
        throw new IllegalAccessException("TEST");
    }

    public void findById(Long id){
        System.out.println("execute find by id");
    }

    public void findByTwoArgs(Long id,String name){
        System.out.println("execute find by id and name");
    }	
    
    
    public void setAnnoService(AnnoService annoService){
    	System.out.println("execute setAnnoService");
    }
    
    
	
//	@Autowired
//	private AuthService authService;
//	
//	
//	@AdminOnly
//	public void insert(Product product){
//		//authService.checkAccess();
//		System.out.println("insert product");
//	}
//	
//	@AdminOnly
//	public void delete(Long id){
//		//authService.checkAccess();
//		System.out.println("delete product");
//	}
//	
	

}
