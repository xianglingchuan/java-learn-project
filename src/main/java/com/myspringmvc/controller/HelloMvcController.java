package com.myspringmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.omg.CORBA.SystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myspringmvc.entity.User;

@Controller
@RequestMapping("/hello")
public class HelloMvcController {
     
	@RequestMapping("mvc")
	public ModelAndView helloMvc(){
		System.out.println("hello MVC");
		ModelAndView mView = new ModelAndView();
		mView.addObject("username", "Jake");
		List<User> userList = this.createUserData();
		System.out.println("userList:"+userList.size());
		mView.addObject("userList", this.createUserData());
		return mView;
	}
	
	
	private List<User> createUserData(){
		List<User> users = new ArrayList<User>();
		for(int i=1; i<10; i++){
			User tempObject = new User();
			tempObject.setId(i);
			tempObject.setName("tom("+i+")");
			tempObject.setBirthday(new Date());
			users.add(tempObject);
		}
		return users;
	}
	
	
}
