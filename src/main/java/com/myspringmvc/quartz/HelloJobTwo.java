package com.myspringmvc.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

public class HelloJobTwo implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current time is:" + simpleDateFormat.format(date));

	    Trigger trigger = context.getTrigger();
	    
		System.out.println("startTime is:"+simpleDateFormat.format(trigger.getStartTime()));
		System.out.println("endTime is:"+simpleDateFormat.format(trigger.getEndTime()));
		
		JobKey jobKey = trigger.getJobKey();
		System.out.println("jobName:"+jobKey.getName()+", jobGroup:"+jobKey.getGroup());
		
		

	}
}
