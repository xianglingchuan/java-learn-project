package com.myspringmvc.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
  //匹配方法标注有AdminOnly的注解的方法
  @Pointcut("@annotation(com.learn.demo.AdminOnly)")
  public void nnoDemo(){}

  //匹配标注有Beta的类底下的方法，要求的annotation的RetentionPolicy级别的CLASS
  @Pointcut("@within(com.google.common.annotations.Beta)")
  public void annoWithinDemo(){}

  //匹配标注有Repository的类底下的方法，要求的annotation的RetentionPolicy级别为RUNTIME
  @Pointcut("@target(org.springframework.stereotype.Repository)")
  public void annoTargetDemo(){}

  //匹配传入的参数类标注有Repository注解的方法
  @Pointcut("@args(org.springfreamwork.stereotype.Repository)")
  public void annoArgsDemo(){} 

 * */
@Aspect
@Component
public class AspectAnno {

	public AspectAnno(){
		System.out.println("初始化切面...AspectAnno");
	}
	
	
	//@Pointcut("@annotation(com.myspringmvc.aop.security.AdminOnly)") //ok
	//@Pointcut("@within(com.myspringmvc.aop.security.NeedSecured)") //ok
	//@Pointcut("@target(com.myspringmvc.aop.security.NeedSecured)") //ok
	@Pointcut("@args(com.myspringmvc.aop.security.NeedSecured)") 
	public void matchAnno(){}
	
	
	@Before("matchAnno()")
	public void before(){
		System.out.println("AspectAnno...before");
	}
	
	
	
	
	
	
	
}
