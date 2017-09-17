package com.myspringmvc.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
//匹配任何公共方法
@Pointcut("execution(public * com.aop.service.*.*(..))")

//匹配com.aop包及子包下Service类中无参数方法
@Pointcut("execution(* com.aop..*Service.*())")

//匹配com.aop包及子包下Service类中的任何只有一个能数的方法
@Pointcut("execution(* com.aop..*Service.*(*))")

//匹配com.aop包及子包下任何类的方法
@Pointcut("execution(* com.aop..*.*(..))")

//匹配异常
execution(public * com.aop.service.*.*(..) throws java.lang.IllegalAccessException)
  
 
  
  
 */
@Aspect
@Component
public class ExecutionAspectConfig {

	//@Pointcut("execution(public * com.myspringmvc.aop.service..*Service.*(..) throws java.lang.IllegalAccessException)")
//	@Pointcut("execution(public * com.myspringmvc.aop.service..*Service.*(..))")
//	public void matchCondition(){}
//	
//	@Before("matchCondition()")
//	public void before(){
//		System.out.println("before ExecutionAspectConfig....");
//	}
	
	
	
}
