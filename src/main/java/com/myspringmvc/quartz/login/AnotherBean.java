package com.myspringmvc.quartz.login;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("anotherBean")
public class AnotherBean {

	public void printAnotherMessage() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("I am AnotherBean."+simpleDateFormat.format(date));
	}

}
