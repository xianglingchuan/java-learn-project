package com.myspringmvc.thread.tickets;

public class TicketsRunnable {
	
	
	public static void main(String[] args) {
		MyRunnable mRunnable = new MyRunnable();
		
		Thread th1 = new Thread(mRunnable,"窗口1");
		Thread th2 = new Thread(mRunnable,"窗口2");
		Thread th3 = new Thread(mRunnable,"窗口3");
		
		th1.start();
		th2.start();
		th3.start();
		
		
	}

}
