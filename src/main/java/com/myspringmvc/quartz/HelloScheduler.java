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

public class HelloScheduler {

	public static void main(String[] args) throws SchedulerException {
		// 创建一个JobDetail实例，将该实例与HelloJob Class绑定
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
				.withIdentity("myJob", "group1")
				.usingJobData("message", "hello myJob1")
				.usingJobData("floatJobValue", 3.14F)
				.build();
		System.out.println("jobDetail's name:"+jobDetail.getKey().getName());
		System.out.println("jobDetail's group:"+jobDetail.getKey().getGroup());
		System.out.println("jobDetail's jobClass:"+jobDetail.getJobClass().getName());
		

		// 创建一个Trigger实例，定义该job立即执行，并且每隔两秒钟重复执行一次，直到永远
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("myTrigger", "group1")
				//.usingJobData("message", "hello myTrigger1")
				.usingJobData("DoubleTriggerValue",2.0D)
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
				.build();
	    
		//创建Scheduler实例
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		scheduler.start();
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current time is:"+simpleDateFormat.format(date));
		
		scheduler.scheduleJob(jobDetail, trigger);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
