package com.myspringmvc.mytimer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

	private String name;

	//统计当前执行的次数
	private Integer count = 0;
	
	
	public MyTimerTask(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		
		if(count < 3){
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println("Curren exec time is:"+simpleDateFormat.format(calendar.getTime()));
			System.out.println("Current exec name is:"+name);
			count ++;			
		}else{
			cancel();
			System.out.println("MyTimerTask cancel!");
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
