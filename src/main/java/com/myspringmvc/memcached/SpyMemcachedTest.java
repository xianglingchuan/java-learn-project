package com.myspringmvc.memcached;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myspringmvc.memcached.utils.SpyMemcachedManagerUtil;

public class SpyMemcachedTest {

	public static void main(String[] args) {

		ApplicationContext app = new ClassPathXmlApplicationContext("classpath*:config/app-context-spymemcached.xml");
		SpyMemcachedManagerUtil memcachedManager = (SpyMemcachedManagerUtil) app.getBean("memcachedManager");

		System.out.println("set：" + memcachedManager.set("SpyMemcached", "test", 9000));
		System.out.println("get：" + memcachedManager.get("SpyMemcached"));

	}
}
