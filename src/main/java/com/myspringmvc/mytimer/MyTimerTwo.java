package com.myspringmvc.mytimer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

import org.bouncycastle.util.Times;

public class MyTimerTwo {
	
	public static void main(String[] args) {
		
		Timer timer = new Timer();
		MyTimerTaskTwo timer1 = new MyTimerTaskTwo("No.1", 2000);
		MyTimerTaskTwo timer2= new MyTimerTaskTwo("No.2", 2000);
		
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("current time is:"+simpleDateFormat.format(calendar.getTime()));

		//timer.schedule(timer1, calendar.getTime());
		//timer.schedule(timer2, calendar.getTime());
		timer.scheduleAtFixedRate(timer1, calendar.getTime(), 2000);
		timer.scheduleAtFixedRate(timer2, calendar.getTime(), 2000);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
