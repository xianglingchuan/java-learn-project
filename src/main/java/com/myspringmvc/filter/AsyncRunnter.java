package com.myspringmvc.filter;

import java.util.Date;

import javax.servlet.AsyncContext;

/**
 * 
 * Servlet3.0支持的过滤器异步请求
 * 
 * 测试使用的异步线程类
 * 
 * */
public class AsyncRunnter implements Runnable {

	
	private AsyncContext content;
	
	public AsyncRunnter(){
		//this.content = content;
	}
	
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000*10);
			System.out.println("业务执行完成时间:"+new Date());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}











