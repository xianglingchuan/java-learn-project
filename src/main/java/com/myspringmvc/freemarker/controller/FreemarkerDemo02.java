package com.myspringmvc.freemarker.controller;





import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myspringmvc.entity.User;


@Controller
@RequestMapping("/freemarker")
public class FreemarkerDemo02 {

	
	@RequestMapping("demo02")
	public ModelAndView helloMvc(){
		ModelAndView mView = new ModelAndView();
		
		User user = new User();
		user.setName("tom");
		user.setDescription("<span style='color:blue'>我是程序员，我需要加班工作。</span>");
		
		mView.addObject("user", user);
		
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("php");
		list.add("python");
		mView.addObject("mylist", list);
		
		Map<String, String> map = new HashMap<String,String>();
		map.put("java", "Hello java");
		map.put("php", "Hello php");
		map.put("python", "Hello python");
		mView.addObject("map", map);
		
		
		
		return mView;
	}
	
}
