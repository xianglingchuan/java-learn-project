package com.myspringmvc.quartz.login;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class FirstScheduledJob extends QuartzJobBean {

	private AnotherBean anotherBean;

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {

		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
		System.out.println("FirstScheduledJob Executes."+simpleDateFormat.format(date));
		this.anotherBean.printAnotherMessage();
	}

	public AnotherBean getAnotherBean() {
		return anotherBean;
	}

	public void setAnotherBean(AnotherBean anotherBean) {
		this.anotherBean = anotherBean;
	}

}
