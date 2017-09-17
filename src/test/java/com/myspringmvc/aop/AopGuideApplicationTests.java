package com.myspringmvc.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myspringmvc.aop.security.CurrentUserHolder;
import com.myspringmvc.aop.service.ProductService;


@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml","classpath*:/mvc-dispatcher-servlet.xml"})  
public class AopGuideApplicationTests {
	
	
	@Autowired
	private ProductService productService;
	
	//@Test(expected = Exception.class)
	@Test
	public void annoInsertTest(){
		CurrentUserHolder.set("admin");
		System.out.println("productService:"+productService);
		ProductService productService = new ProductService();
		System.out.println("productService:"+productService);
		productService.delete(1L);
	}
	
	//@Test(expected = Exception.class)
//	@Test
//	public void adminInsertTest(){
//		CurrentUserHolder.set("admi1");
//		productService.delete(1L);
//	}
	

}














