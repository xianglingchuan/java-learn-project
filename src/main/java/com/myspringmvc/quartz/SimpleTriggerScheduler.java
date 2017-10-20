package com.myspringmvc.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleTriggerScheduler {

	public static void main(String[] args) throws SchedulerException {

		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current time is:" + simpleDateFormat.format(date));

		// 创建一个JobDetail实例，将该实例与HelloJob Class绑定
		JobDetail jobDetail = JobBuilder.newJob(SimpleTriggerJob.class).withIdentity("myJob", "group1").build();

		// 创建一个Trigger实例，定义该job立即执行，并且每隔两秒钟重复执行一次，直到永远
		/*SimpleTrigger trigger = (SimpleTrigger)TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(2)
						.repeatForever())
				.build();
				*/
		
		date.setTime(date.getTime()+4000L);
		
		//例1,在距离当前时间4秒后执行且仅执行一次任务
//		SimpleTrigger trigger = (SimpleTrigger)TriggerBuilder
//				.newTrigger()
//				.withIdentity("myTrigger", "group1")
//				.startAt(date)
//				.build();
		
		//例2，在距离当前时间4秒后首次执行任务，之后每隔两秒钟重复执行一次任务
//		SimpleTrigger trigger = (SimpleTrigger)TriggerBuilder
//				.newTrigger()
//				.withIdentity("myTrigger", "group1")
//				.startAt(date)
//				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
//						.withIntervalInSeconds(2)
//						.withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY))
//				.build();
		

		Date endDate = new Date();
		endDate.setTime(endDate.getTime()+6000L);
		//例3，在距离当前时间4秒后首次执行任务，之后每隔两秒钟重复执行一次任务,一共执行4次任务。
		//直到距离当前时间6秒钟之前为止
		SimpleTrigger trigger = (SimpleTrigger)TriggerBuilder
		.newTrigger()
		.withIdentity("myTrigger", "group1")
		.startAt(date)
		.endAt(endDate)
		.withSchedule(SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(2)
				.withRepeatCount(4))
		.build();		
		
		
		// 创建Scheduler实例
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail, trigger);
	}

}
