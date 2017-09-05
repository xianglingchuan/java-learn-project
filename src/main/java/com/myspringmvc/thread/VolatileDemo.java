package com.myspringmvc.thread;

import org.springframework.core.env.SystemEnvironmentPropertySource;

public class VolatileDemo {
	
	
	private int number = 0;
	
	public int getNumber(){
		return this.number;
	}
	
	
	public void increase(){
		
		//休眠一下就会出现计算出来的值不对
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		this.number ++;
	}
	
	
	
	

	public static void main(String[] args) {
		
		final VolatileDemo volatileDemo = new VolatileDemo();
		for(int i=0; i<500; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					volatileDemo.increase();					
				}
			}).start();
		}
		
		//如果还有子线程在运行，主线程就让出CPU资源
		//直到所有的子线程运行完了，主线程再继续往下执行
		while (Thread.activeCount()>1) {
			Thread.yield();
		}
		
		System.out.println("number:"+volatileDemo.getNumber());
	}

}
