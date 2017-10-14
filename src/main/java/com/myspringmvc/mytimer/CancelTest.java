package com.myspringmvc.mytimer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

import org.apache.tomcat.jni.Time;

public class CancelTest {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		//创建Timer实例
		Timer timer = new Timer();
		//创建TimerTask实例
		MyTimerTask task1 = new MyTimerTask("task1");
		MyTimerTask task2 = new MyTimerTask("task2");
		//获取当前的执行时间并打印
		Date startTime = new Date();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("start time is :"+sFormat.format(startTime));
		//task1首次执行是距离现在时间3秒后执行，之后隔2秒执行一次
		//task2首次执行是距离现在时间1秒后执行，之后隔2秒执行一次
		timer.schedule(task1, 3000,2000);
		timer.schedule(task2, 3000,2000);
		
		//休眠5秒
		Thread.sleep(5000);
		
		
		//获取当前执行时间并打印
		Date cancelTime = new Date();
		System.out.println("cancel time is:"+sFormat.format(cancelTime));
		
		//取消所有任务
		timer.cancel();
		System.out.println("Tasks all canceled!");
		
	}

}









