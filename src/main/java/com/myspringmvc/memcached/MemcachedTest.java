//package com.myspringmvc.memcached;
//
//
//import java.util.Date;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.danga.MemCached.MemCachedClient;
//import com.myspringmvc.memcached.utils.MemcachedUtils;
//
//public class MemcachedTest {
//	
//	public static void main(String[] args) {
//	
////		System.out.println();
////		
////		boolean setResult = MemcachedUtils.set("aa", "bb", new Date(1000 * 600));
////		System.out.println("setResult=="+setResult);  
//		
//		//Object obj = MemcachedUtils.get("aa");  
//		//System.out.println("***************************");  
//		//System.out.println(obj.toString()); 
//		
//		
//        ApplicationContext atx = new ClassPathXmlApplicationContext("classpath*:config/spring-memcache.xml");
//        MemCachedClient memCachedClient = (MemCachedClient) atx.getBean("memcachedClient");
//        
//        memCachedClient.set("name", "han");
//        System.out.println(memCachedClient.get("name"));        
//		
//		
//	}
//
//}
