package com.myspringmvc.aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

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


//@Component
//@Aspect
//public class AspectProduct implements ThrowsAdvice {
//
//	
//	public AspectProduct(){
//		System.out.println("初始化切面...AspectProduct");
//	}
//	
//	//前置通知
//	@Before(value="execution(* com.myspringmvc.aop.service.ProductService.*(..))")
//	public void doBefore(JoinPoint jp){
//		//JoinPoint取值示例
//		Object[] obj = jp.getArgs();
//		for(int i=0;i<obj.length;i++){
//			System.out.println("参数"+i+":"+obj[i]);
//		}
//		System.out.println("执行了前置通知");
//	}
//	
//	//后置通知
//	@After(value="execution(* com.myspringmvc.aop.service.ProductService.*(..))")
//	public void doAfter(){
//		System.out.println("执行了后置通知");
//	}
//	
//	//环绕通知
//	@Around(value="execution(* com.myspringmvc.aop.service.ProductService.*(..))")
//	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
//		Object retVal = pjp.proceed();
//		return retVal;
//	}
//	
//	//获取返回后通知
//	@AfterReturning(value="execution(* com.myspringmvc.aop.service.ProductService.*(..))",returning="retVal")
//	public void doAfterReturning(JoinPoint jp,String retVal){
//		System.out.println("后置返回值通知，获得参数："+retVal);
//	}
//	
//	//异常通知
//	@AfterThrowing(value="execution(* com.myspringmvc.aop.service.ProductService.*(..))",throwing="ex")
//	public void afterThrowing(Throwable ex){
//		System.out.println("抛出异常通知"+ex);
//	}	
//	
//}
