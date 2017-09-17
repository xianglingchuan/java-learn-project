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

@Component
@Aspect
public class AspectTestController {
	
	public AspectTestController(){
		System.out.println("初始化切面...AspectTestController");
	}
	
	
	/**
	 * 定义一个切入点
	 */
	@Pointcut("execution(* com.myspringmvc.aop.controller.*Controller.*Auth(..))")
	private void pointCutMethod() {
		System.out.println("初始化切面类");
	}

	/**
	 * 声明前置通知
	 */
	@Before("pointCutMethod()")
	public void doBefore() {
		System.out.println("前置通知");
	}

	/**
	 * 声明后置通知
	 * 
	 * @param result
	 */
	@AfterReturning(pointcut = "pointCutMethod()", returning = "result")
	public void doAfterReturning(String result) {
		System.out.println("后置通知");
		System.out.println("---" + result + "---");
	}

	/**
	 * 声明例外通知
	 */
	@AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
	public void doAfterThrowing(Exception e) {
		System.out.println("例外通知");
		System.out.println(e.getMessage());
	}

	/**
	 * 声明最终通知
	 */
	@After("pointCutMethod()")
	public void doAfter() {
		System.out.println("最终通知");
	}	
	
	
	
//	//前置通知
//	@Before(value="execution(* com.sxt.service.UserService.add*(..))")
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
//	@After(value="execution(* com.sxt.service.UserService.add*(..))")
//	public void doAfter(){
//		System.out.println("执行了后置通知");
//	}
//	
//	//环绕通知
//	@Around(value="execution(* com.sxt.service.UserService.add*(..))")
//	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
//		Object retVal = pjp.proceed();
//		return retVal;
//	}
//	
//	//获取返回后通知
//	@AfterReturning(value="execution(* com.sxt.service.UserService.add*(..))",returning="retVal")
//	public void doAfterReturning(JoinPoint jp,String retVal){
//		System.out.println("后置返回值通知，获得参数："+retVal);
//	}
//	
//	//异常通知
//	@AfterThrowing(value="execution(* com.sxt.service.UserService.delete*(..))",throwing="ex")
//	public void afterThrowing(Throwable ex){
//		System.out.println("抛出异常通知"+ex);
//	}
}
