package com.myspringmvc.thread.tickets;

import java.util.Scanner;

public class DaemonDemo {
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+"--开始用户线程执行.");
		
		
		DaemonRunnable daemonRunnable = new DaemonRunnable();
		Thread thread = new Thread(daemonRunnable);
		thread.setDaemon(true);
		thread.start();
		
		Scanner scanner = new Scanner(System.in);
		scanner.next();
		
		System.out.println(Thread.currentThread().getName()+"--结束用户线程执行.");
	}

}
