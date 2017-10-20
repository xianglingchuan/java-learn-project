package com.myspringmvc.aop.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.myspringmvc.aop.demo.bean.User;
import com.myspringmvc.aop.demo.dao.UserDao;



@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public String add(String uname){
		System.out.println("UserService.add()");
		User u = new User();
		u.setUname(uname);
		userDao.add(u);
//		throw new NullPointerException();
		return "Service����ֵ";
	}
	
	public void delete(){
		throw new NullPointerException();
	}
}
