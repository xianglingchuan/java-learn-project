//package com.myspringmvc.aop.config;
//
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
///*
////匹配任何公共方法
//@Pointcut("execution(public * com.aop.service.*.*(..))")
//
////匹配com.aop包及子包下Service类中无参数方法
//@Pointcut("execution(* com.aop..*Service.*())")
//
////匹配com.aop包及子包下Service类中的任何只有一个能数的方法
//@Pointcut("execution(* com.aop..*Service.*(*))")
//
////匹配com.aop包及子包下任何类的方法
//@Pointcut("execution(* com.aop..*.*(..))")
//
////匹配异常
//execution(public * com.aop.service.*.*(..) throws java.lang.IllegalAccessException)
//  
// 
//  
//  
// */
//@Aspect
//@Component
//public class ExecutionAspectConfig {
//
//	
//	public ExecutionAspectConfig(){
//		System.out.println("初始化切面...ExecutionAspectConfig");
//	}
//	
//	
//	//@Pointcut("execution(public * com.myspringmvc.aop.service..*Service.*(..) throws java.lang.IllegalAccessException)")
////	@Pointcut("execution(public * com.myspringmvc.aop.service..*Service.*(..))")
////	public void matchCondition(){}
////	
////	@Before("matchCondition()")
////	public void before(){
////		System.out.println("before ExecutionAspectConfig....");
////	}
//	
//	@Pointcut("execution(* com.myspringmvc.aop.service.ProductService.findById(..))")
//	//@Pointcut("execution(* com.myspringmvc.aop.controller.*Controller.*Auth(..))")
//	public void matchCondition() {
//		System.out.println("初始化切面类 matchCondition");
//	}
//	
//	
//	/**
//	 * 声明前置通知
//	 */
//	@Before("matchCondition()")
//	public void doBefore() {
//		System.out.println("前置通知");
//	}
//
//	/**
//	 * 声明后置通知
//	 * 
//	 * @param result
//	 */
//	@AfterReturning(pointcut = "matchCondition()", returning = "result")
//	public void doAfterReturning(String result) {
//		System.out.println("后置通知");
//		System.out.println("---" + result + "---");
//	}
//
//	/**
//	 * 声明例外通知
//	 */
//	@AfterThrowing(pointcut = "matchCondition()", throwing = "e")
//	public void doAfterThrowing(Exception e) {
//		System.out.println("例外通知");
//		System.out.println(e.getMessage());
//	}
//
//	/**
//	 * 声明最终通知
//	 */
//	@After("matchCondition()")
//	public void doAfter() {
//		System.out.println("最终通知");
//	}	
//	
//
////	@Before("matchCondition()")
////	public void before() {
////		System.out.println("###before================");
////	}	
//	
//}
