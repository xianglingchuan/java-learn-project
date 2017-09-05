package com.myspringmvc.thread.tickets;


public class MyRunnable implements Runnable {

	private int ticketsCount = 5; // 一共有多少张票
	
	
	@Override
	public void run() {
		while(ticketsCount > 0) {
			ticketsCount--;
			System.out.println(Thread.currentThread().getName() + "卖了1张票,剩余票数为:"+ticketsCount);
		}
	}

}
