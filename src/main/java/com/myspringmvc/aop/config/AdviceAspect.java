package com.myspringmvc.aop.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdviceAspect {

	@Pointcut("execution(public * com.myspringmvc.aop.service.AdviceService.*(..))")
	public void adviceCondition() {
		
	}

	// 前置
	@Before("adviceCondition()")
	public void doBefore() {
		System.out.println("******前置通知");
	}

	// 后置
	@After("adviceCondition()")
	public void doAfter() {
		System.out.println("******后置通知");
	}

	// 环通知
	@Around("adviceCondition()")
	public Object AfterThrowing(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("******before");
		try {
			Object result = pjp.proceed(pjp.getArgs());
			System.out.println("******return");
			return result;
		} catch (Throwable throwable) {
			System.out.println("*****ex");
			throw throwable;
		} finally {
			System.out.println("******after");
		}
	}

	@AfterReturning("adviceCondition()")
	public void afterReturning() {
		System.out.println("******afterReturning");
	}

	@AfterThrowing(pointcut = "adviceCondition()", throwing = "e")
	public void afterThrowing() {
		System.out.println("******afterThrowing");
	}

	


}
