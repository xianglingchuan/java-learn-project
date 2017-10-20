package com.myspringmvc.mytimer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class DifferenceTestTwo {
	
	public static void main(String[] args) {
		//规定时间格式
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		
		
		//获取当前的时间
		Calendar calendar = Calendar.getInstance();
		System.out.println("Current time is:"+simpleDateFormat.format(calendar.getTime()));
		Timer timer = new Timer();
		System.out.println("Current time is:"+simpleDateFormat.format(calendar.getTime()));
		
		
		
//		timer.schedule(new TimerTask() {
//			@Override
//			public void run() {
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				//打印当前计划的执行时间
//				System.out.println("Schedule exec time is:"+simpleDateFormat.format(scheduledExecutionTime()));
//				System.out.println("Task is being executed!");
//			}
//		}, calendar.getTime(),2000);
		
		
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//打印当前计划的执行时间
				System.out.println("Schedule exec time is:"+simpleDateFormat.format(scheduledExecutionTime()));
				System.out.println("Task is being executed!");
			}
		}, calendar.getTime(),2000);		
		
			
		
		
	}

}
