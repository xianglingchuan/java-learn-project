package com.myspringmvc.mytimer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class MyTimerTaskTwo extends TimerTask {

	private String name;

	//休眠时间秒数
	private long costTime;
	
	
	public MyTimerTaskTwo(String name,long costTime) {
		this.name = name;
		this.costTime = costTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(name+"Curren exec time is:"+simpleDateFormat.format(calendar.getTime()));
		
		try {
			Thread.sleep(costTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		calendar = Calendar.getInstance();
		System.out.println(name+"'s finish time is:"+simpleDateFormat.format(calendar.getTime()));
		
		throw new RuntimeException();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
