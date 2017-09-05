package com.myspringmvc.thread;

public class SynchronizedDemo {

	
	//共享变量
	private boolean isRead = false; //是否可读
	private int result = 0;
	private int number = 1;
	
	//写操作
	public synchronized void write(){
		isRead = true;
		
		//如果无法实现演示效果可以直接在这里休眠一下
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		number = 4;
	}
	
	//读操作
	public synchronized void read(){
		if(isRead){
			//如果无法实现演示效果可以直接在这里休眠一下
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			result = number * 3;
		}
		System.out.println("result的值为:"+result);
	}
	
	public class WriteReadThread extends Thread{
		
		//根据构造方法传入的flag参数，确定线程执行读操作还是写操作
		private boolean flag;
		
		public WriteReadThread(boolean flag){
			this.flag = flag;
		}
		
		@Override 
		public void run(){
			if(this.flag){
				write();
			}else{
				read();
			}
		}
	}
	
	
	public static void main(String[] args) {
		SynchronizedDemo demo = new SynchronizedDemo();
		demo .new WriteReadThread(true).start();
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		demo .new WriteReadThread(false).start();
	}

}
