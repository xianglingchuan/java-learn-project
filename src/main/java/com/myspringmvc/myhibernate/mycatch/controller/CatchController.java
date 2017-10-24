package com.myspringmvc.myhibernate.mycatch.controller;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myspringmvc.myhibernate.mycatch.entity.Teacher;
import com.myspringmvc.myhibernate.mycatch.util.HibernateUtil;

@Controller
public class CatchController {

	@RequestMapping("/catch/hello")
    public String hello(){
        System.out.println("hello world");
        
//        Session session = HibernateUtil.getSession();
//		Teacher teacher = (Teacher)session.get(Teacher.class, 1);
//		System.out.println("teacher:"+teacher.toString());        
        
        
        return "success";
    }	
	
}
