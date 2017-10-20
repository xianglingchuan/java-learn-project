package com.myspringmvc.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class HelloSchedulerTwo {

	public static void main(String[] args) throws SchedulerException {
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current time is:"+simpleDateFormat.format(date));		
		
		// 创建一个JobDetail实例，将该实例与HelloJob Class绑定
		JobDetail jobDetail = JobBuilder.newJob(HelloJobTwo.class)
				.withIdentity("myJob", "group1")
				.build();
		
		//获取距离当前时间3秒以后的时间
		date.setTime(date.getTime()+3000);
		
		//获取距离当前时间6秒之后的时间
		Date endDate = new Date();
		endDate.setTime(endDate.getTime()+6000);
		
		// 创建一个Trigger实例，定义该job立即执行，并且每隔两秒钟重复执行一次，直到永远
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("myTrigger", "group1")
				.startAt(date)
				.endAt(endDate)
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
				.build();
	    
		//创建Scheduler实例
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail, trigger);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
