package com.myspringmvc.aop.config;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
//public class AspectTestController {
//	
//	public AspectTestController(){
//		System.out.println("初始化切面...AspectTestController");
//	}
//	
//	
//	/**
//	 * 定义一个切入点
//	 */
//	@Pointcut("execution(* com.myspringmvc.aop.controller.*Controller.*Auth(..))")
//	private void pointCutMethod() {
//		System.out.println("初始化切面类");
//	}
//
//	/**
//	 * 声明前置通知
//	 */
//	@Before("pointCutMethod()")
//	public void doBefore() {
//		System.out.println("前置通知");
//	}
//
//	/**
//	 * 声明后置通知
//	 * 
//	 * @param result
//	 */
//	@AfterReturning(pointcut = "pointCutMethod()", returning = "result")
//	public void doAfterReturning(String result) {
//		System.out.println("后置通知");
//		System.out.println("---" + result + "---");
//	}
//
//	/**
//	 * 声明例外通知
//	 */
//	@AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
//	public void doAfterThrowing(Exception e) {
//		System.out.println("例外通知");
//		System.out.println(e.getMessage());
//	}
//
//	/**
//	 * 声明最终通知
//	 */
//	@After("pointCutMethod()")
//	public void doAfter() {
//		System.out.println("最终通知");
//	}	
//}
