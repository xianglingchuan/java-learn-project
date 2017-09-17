package com.myspringmvc.aop.demo.dao;
import org.springframework.stereotype.Repository;

import com.myspringmvc.aop.demo.bean.User;





@Repository
public class UserDao {
	public void add(User u){
		System.out.println("UserDao.add()");
	}
}
