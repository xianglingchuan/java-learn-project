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

public class HelloJob implements Job {

	private String message;
	private float floatJobValue;
	private double DoubleTriggerValue;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public float getFloatJobValue() {
		return floatJobValue;
	}

	public void setFloatJobValue(float floatJobValue) {
		this.floatJobValue = floatJobValue;
	}

	public double getDoubleTriggerValue() {
		return DoubleTriggerValue;
	}

	public void setDoubleTriggerValue(double doubleTriggerValue) {
		DoubleTriggerValue = doubleTriggerValue;
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current time is:" + simpleDateFormat.format(date));

		// 编写业务逻辑
		// System.out.println("Hello world!");

		JobKey jobKey = context.getJobDetail().getKey();
		System.out.println("My Job name and group are:" + jobKey.getName() + ":" + jobKey.getGroup());
		TriggerKey triggerKey = context.getTrigger().getKey();
		System.out.println("My Trigger name and group are:" + triggerKey.getName() + ":" + triggerKey.getGroup());

		/*
		 * JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		 * JobDataMap tDataMap = context.getTrigger().getJobDataMap(); String
		 * jobMessage = dataMap.getString("message"); float jobFloatJobValue =
		 * dataMap.getFloat("floatJobValue"); String trMessage =
		 * tDataMap.getString("message"); Double trDouble =
		 * tDataMap.getDouble("DoubleTriggerValue");
		 * 
		 * System.out.println("jobMessage is："+jobMessage);
		 * System.out.println("jobFloatJobValue is："+jobFloatJobValue);
		 * System.out.println("trMessage is："+trMessage);
		 * System.out.println("trDouble is："+trDouble);
		 */

		/*
		 * JobDataMap dataMap = context.getMergedJobDataMap(); String message =
		 * dataMap.getString("message"); float jobFloatJobValue =
		 * dataMap.getFloat("floatJobValue"); Double trDouble =
		 * dataMap.getDouble("DoubleTriggerValue");
		 * System.out.println("message is："+message);
		 * System.out.println("jobFloatJobValue is："+jobFloatJobValue);
		 * System.out.println("trDouble is："+trDouble);
		 */

		System.out.println("message is：" + message);
		System.out.println("floatJobValue is：" + floatJobValue);
		System.out.println("DoubleTriggerValue is：" + DoubleTriggerValue);

	}
}
