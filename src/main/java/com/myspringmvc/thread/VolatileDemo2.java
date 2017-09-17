package com.myspringmvc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileDemo2 {
	
	
	private Lock lock = new ReentrantLock();
	
	
	private int number = 0;
	
	public int getNumber(){
		return this.number;
	}
	
	
	public void increase(){
		
		//休眠一下就会出现计算出来的值不对
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		lock.lock();
		try{
			this.number ++;
		}finally {
			lock.unlock();
		}
		
		
	}
	
	
	
	

	public static void main(String[] args) {
		
		final VolatileDemo2 volatileDemo = new VolatileDemo2();
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
