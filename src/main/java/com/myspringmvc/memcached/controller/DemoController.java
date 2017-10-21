package com.myspringmvc.memcached.controller;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myspringmvc.memcached.service.SpyMemcachedService;
//import com.myspringmvc.memcached.service.SpyMemcachedService;
import com.myspringmvc.memcached.utils.SpyMemcachedManagerUtil;

import net.spy.memcached.MemcachedClient;

@Controller
@RequestMapping("/memcached/demo")
public class DemoController {

//	@Autowired
//	private SpyMemcachedService spyMemcachedService;
	
	
	
//		public public SpyMemcachedService getSpyMemcachedService() {
//			
//			ApplicationContext app = new ClassPathXmlApplicationContext("classpath*:config/app-context-spymemcached.xml");
//			SpyMemcachedManagerUtil memcachedManager = (SpyMemcachedManagerUtil) app.getBean("memcachedManager");
//
//			System.out.println("set：" + memcachedManager.set("SpyMemcached", "test", 9000));
//			System.out.println("get：" + memcachedManager.get("SpyMemcached"));
//		}	
	
	
	
	
	@RequestMapping("test")
	public void test(){
//		ApplicationContext app = new ClassPathXmlApplicationContext("classpath*:config/app-context-spymemcached.xml");
//		SpyMemcachedManagerUtil memcachedManager = (SpyMemcachedManagerUtil) app.getBean("memcachedManager");
//		System.out.println("set：" + memcachedManager.set("SpyMemcached", "test", 9000));
//		System.out.println("get：" + memcachedManager.get("SpyMemcached"));	
		
		SpyMemcachedService spyMemcachedService = new SpyMemcachedService();
		spyMemcachedService.getDataSource();
		
		
		
	}
	
	

//	@RequestMapping("add")
//	public void add(HttpServletResponse response, HttpServletRequest request) {
//
//		try {
//			boolean flag = spyMemcachedService.add("key1", "add", 1000);
//
//			if (flag) {
//				this.responseText("add成功,key=key1,value=add", response);
//			} else {
//				this.responseText("add失败！", response);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	@RequestMapping("get")
//	public void get(HttpServletResponse response, HttpServletRequest request) {
//
//		try {
//			Object val = spyMemcachedService.get("key1");
//			this.responseText("get,key=key1,value=" + val, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	@RequestMapping("replace")
//	public void replace(HttpServletResponse response, HttpServletRequest request) {
//
//		try {
//			boolean flag = spyMemcachedService.replace("key1", "replace", 1000);
//			if (flag) {
//				this.responseText("replace成功,key=key1,value=replace", response);
//			} else {
//				this.responseText("replace失败！", response);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	@RequestMapping("set")
//	public void set(HttpServletResponse response, HttpServletRequest request) {
//
//		try {
//			boolean flag = spyMemcachedService.set("key1", "set", 1000);
//			if (flag) {
//				this.responseText("set成功,key=key1,value=set", response);
//			} else {
//				this.responseText("set失败！", response);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	/**
//	 * 响应字符串 用于ajax请求响应
//	 * 
//	 * @param str
//	 * @throws Exception
//	 */
//	public void responseText(String str, HttpServletResponse reponse) throws Exception {
//		reponse.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = reponse.getWriter();
//		out.write(str);
//		out.flush();
//		out.close();
//	}

}
