package com.myspringmvc.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
   //匹配任何以find开头而且只有一个Long参数的方法
   @Pointcut("execution(* *..find*(Long))")
   public void argsDemo1(){}


   //匹配任何只有一个Long参数的方法
   @Pointcut("args(Lng)")
   public void argsDemo2(){}

   //匹配任何以find开头的而且每一个参数为Long型的方法
   @Pointcut("execution(* *..find(Long,..)")

   //匹配第一个参数为Long型的方法
   @Pointcut("args(Long,..)")
   public void argsDemo4(){}  

 * */
@Aspect
@Component
public class AspectArgs {

	public AspectArgs(){
		System.out.println("初始化切面...AspectArgs");
	}
	
	
	@Pointcut("args(Long) && within(com.myspringmvc.aop.service.*)")
	public void matchArgs(){}
	
	@Before("matchArgs()")
	public void before(){
		System.out.println("AspectArgs...before");
	}
	
	
	
	
	
	
	
}
