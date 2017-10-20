package com.myspringmvc.aop.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myspringmvc.aop.demo.bean.User;
import com.myspringmvc.aop.demo.service.UserService;



@Controller
@RequestMapping("/user")
public class UserController{
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="save.do",params="method=user")
	public String user(User user,String uname,ModelMap modelMap){
		modelMap.addAttribute("newname", user.getUname());
		userService.add(user.getUname()); 
//		userService.delete();
		return "user/index";
	}
	
	
	@RequestMapping("index.do")
	public String index(ModelMap modelMap){
		return "user/index";
	}
	
	
	@RequestMapping("add.do")
	public String add(){
		
		userService.add("tom");
		return "user/index";
	}
	
	
	
	
	
	
	

}
