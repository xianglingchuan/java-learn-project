package com.myspringmvc.thread.tickets;

public class TicketsThread {
	
	public static void main(String[] args) {
		MyThread m1 = new MyThread("窗口1");
		MyThread m2 = new MyThread("窗口2");
		MyThread m3 = new MyThread("窗口3");
		
		m1.start();
		m2.start();
		m3.start();
		
	}

}
