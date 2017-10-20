package com.myspringmvc.mytimer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

public class Executor {
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		//获取当前的时间
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current time is:"+simpleDateFormat.format(calendar.getTime()));
		
		DancingRobot dancingRobot = new DancingRobot();
		WaterRobot waterRobot = new WaterRobot(timer);
		
		timer.schedule(dancingRobot, calendar.getTime(),2000);
		timer.scheduleAtFixedRate(waterRobot, calendar.getTime(), 1000);
		
	}

}
