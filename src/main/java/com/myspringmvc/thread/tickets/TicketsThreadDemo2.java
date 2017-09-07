package com.myspringmvc.thread.tickets;


public class TicketsThreadDemo2 {
	
	private volatile int ticketsCount = 5; // 一共有多少张票

	
	public TicketsThreadDemo2() {
		
	}
	
	
	public void Sell(String name){
		while(ticketsCount > 0){
			ticketsCount = ticketsCount-1;
			System.out.println(name + "买了一张票,当前还余" + ticketsCount + "张票");
		}
	}
	
	
	public class SellThread extends Thread{
		
		private String name; // 窗口的名称，也就是线程的名称
		
		public SellThread(String name){
			this.name = name;
		}
		
		
		@Override 
		public void run(){
			Sell(name);
		}
	}	
	
	public static void main(String[] args) {
		TicketsThreadDemo2 demo = new TicketsThreadDemo2();
		demo.new SellThread("窗口1").start();
		demo.new SellThread("窗口2").start();
		demo.new SellThread("窗口3").start();
	}

}
