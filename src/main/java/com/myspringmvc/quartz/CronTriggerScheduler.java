package com.myspringmvc.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
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

public class CronTriggerScheduler {

	public static void main(String[] args) throws SchedulerException, InterruptedException {

		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current time is:" + simpleDateFormat.format(date));

		// 创建一个JobDetail实例，将该实例与HelloJob Class绑定
		JobDetail jobDetail = JobBuilder.newJob(CronTriggerJob.class).withIdentity("myJob", "group1").build();

		//1、每秒执行一次任务
		CronTrigger trigger = (CronTrigger)TriggerBuilder
			.newTrigger()
			.withIdentity("myTrigger", "group1")
			.withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
			.build();		
		
		//2、2017年内每天13点15分01秒触发一次
		// 1 15 13 ? * * 2017
//		CronTrigger trigger = (CronTrigger)TriggerBuilder
//		.newTrigger()
//		.withIdentity("myTrigger", "group1")
//		.withSchedule(CronScheduleBuilder.cronSchedule("1 15 13 ? * * 2017"))
//		.build();		
		
		//3、每天的14点整至14点59分月55秒，以及18点整至18点59分55秒，每5秒钟触发一次
		// 0/5 * 13,18 * * ? 
//		CronTrigger trigger = (CronTrigger)TriggerBuilder
//		.newTrigger()
//		.withIdentity("myTrigger", "group1")
//		.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * 13,18 * * ?"))
//		.build();		
		
		//4、每月周一至周五的10点15分01秒触发一次
		//0 15 10 * * MON-FRI
//		CronTrigger trigger = (CronTrigger)TriggerBuilder
//		.newTrigger()
//		.withIdentity("myTrigger", "group1")
//		.withSchedule(CronScheduleBuilder.cronSchedule("0 15 10 ? * MON-FRI"))
//		.build();			
		
		//5、每月最后一天10点15分触发一次
		//0 15 10 L * ? *
//		CronTrigger trigger = (CronTrigger)TriggerBuilder
//		.newTrigger()
//		.withIdentity("myTrigger", "group1")
//		.withSchedule(CronScheduleBuilder.cronSchedule("0 15 10 L * ? *"))
//		.build();			
		
		//6、每月第四个周一的10点15分触发一次
		//0 15 10 ? * MON#4 ?
		//这里用1#4运行不成功，用MON#4运行成功
//		CronTrigger trigger = (CronTrigger)TriggerBuilder
//		.newTrigger()
//		.withIdentity("myTrigger", "group1")
//		.withSchedule(CronScheduleBuilder.cronSchedule("1 15 10 ? * MON#4"))
//		.build();	
		
		
		
		
		// 创建Scheduler实例
//		SchedulerFactory factory = new StdSchedulerFactory();
//		Scheduler scheduler = factory.getScheduler();
//		scheduler.start();
//		//返回即将要执行的下一次任务时间
//		Date nextDate = scheduler.scheduleJob(jobDetail, trigger);
//		System.out.println("scheduled time is:"+simpleDateFormat.format(nextDate));
		
		//Scheduler执行两秒后挂起
//		Thread.sleep(2000L);
//		//scheduler.standby();
//		scheduler.shutdown();
//		//Scheduler在挂起3秒后在重新执行
//		Thread.sleep(3000L);
//		scheduler.start();
		
		//void shutdown(true)表示等待所有正在执行的job执行完毕之后，再关闭scheduler
		//void shutdown(false)即shutdown()表示直接关闭scheduler
		//Thread.sleep(2000L);
		//scheduler.shutdown(false);
	    //System.out.println("scheduler is shutdown?"+scheduler.isShutdown());
		
		
		
	}

}
