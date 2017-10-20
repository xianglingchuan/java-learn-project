package com.myspringmvc.quartz.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/quartz")
public class LoginController {

	
	@RequestMapping("/login")
    public String lgoin(){
        System.out.println("hello world");
        return "quartz/login";
    }
	
	//@RequestMapping(value = { "/submitLogin" }, method = {RequestMethod.POST }, produces = "text/html;charset=UTF-8")
	@RequestMapping("/submitLogin")
	@ResponseBody
	//@RequestMapping(value = "/submitLogin", method = RequestMethod.POST,produces = "text/html;charset=UTF-8") 
    public String submitLogin( @RequestParam(value = "username", required = false)String username,  
            @RequestParam(value = "password", required = false)String password  ){
		
		System.out.println("username:"+username+", password:"+password);
		
		return "Hello "+username+",Your password is: "+password;  
    }	
	
}
