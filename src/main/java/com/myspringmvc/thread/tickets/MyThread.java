package com.myspringmvc.thread.tickets;

import java.util.jar.Attributes.Name;

public class MyThread extends Thread {

	private int ticketsCount = 5; // 一共有多少张票

	private String name; // 窗口的名称，也就是线程的名称

	public MyThread(String name) {
		super();
		this.name = name;
	}

	@Override
	synchronized public void run() {
		while(ticketsCount > 0) {
			ticketsCount--;
			System.out.println(name + "买了一张票,当前还余" + ticketsCount + "张票");
		}
	}

}
