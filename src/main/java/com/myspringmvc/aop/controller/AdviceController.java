package com.myspringmvc.aop.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myspringmvc.aop.service.AdviceService;

import net.spy.memcached.MemcachedClient;


@Controller
@RequestMapping("/advice")
public class AdviceController {

	@Autowired
	private AdviceService adviceService;

	@RequestMapping("index.do")
	public void index() {

		// adviceService.getFuite();
		// adviceService.getName();
		// adviceService.getAge();
		adviceService.getFuite();

		adviceService.setName("tom");
	}

}
