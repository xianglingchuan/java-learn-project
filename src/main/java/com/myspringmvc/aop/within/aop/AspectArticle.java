package com.myspringmvc.aop.within.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
   //匹配ProductService类里头的所有方法
   @Pointcut("within(com.service.ProductService)")
   public void matchType(){}

   //匹配com.service包及子包下所有类的方法
   @Pointcut("within(com.service..*)")
   public void matchPackage(){} 
 */


@Component
@Aspect
public class AspectArticle {
	
	public AspectArticle(){
		System.out.println("初始化切面...AspectArticle");
	}
	
	//@Pointcut("within(com.myspringmvc.aop.within.service.ArticleService)")
	@Pointcut("within(com.myspringmvc.aop.within.service..*)")
	public void matchType(){
		
	}
	
	@Before("matchType()")
	public void doBefore(JoinPoint jp){
		//JoinPoint取值示例
		Object[] obj = jp.getArgs();
		for(int i=0;i<obj.length;i++){
			System.out.println("参数"+i+":"+obj[i]);
		}
		System.out.println("执行了前置通知");
	}
	
	//后置通知
	@After("matchType()")
	public void doAfter(){
		System.out.println("执行了后置通知");
	}
	
	
}
