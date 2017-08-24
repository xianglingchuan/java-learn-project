package com.myspringmvc.listener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.SystemException;

import com.myspringmvc.listener.entity.OnlineUser;
import com.myspringmvc.listener.util.OnlineUserUtil;

@WebListener("this is a UserServletRequestListener")
public class UserServletRequestListener implements ServletRequestListener {

	
	private ArrayList<OnlineUser> onlineUsers; //在线用户
	
	
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
	    
		System.out.println("UserServletRequestListener******requestInitialized");	
		this.onlineUsers  = (ArrayList<OnlineUser>)sre.getServletContext().getAttribute("onlineUsers");
		if(this.onlineUsers==null){
	    	this.onlineUsers = new ArrayList<OnlineUser>();
	    }
	    
	    HttpServletRequest request =(HttpServletRequest)sre.getServletRequest();
	    String sessionId = request.getSession().getId();
	    //判断session是否存在
	    if(OnlineUserUtil.getUserBySession(onlineUsers,sessionId)==null){
	    	OnlineUser user = new OnlineUser();
	    	user.setSessionIdString(sessionId);
	    	user.setFirstTimeString(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(new Date()));
	    	user.setIpString(request.getLocalAddr());
	    	onlineUsers.add(user);
	    }
	    sre.getServletContext().setAttribute("onlineUsers", onlineUsers);
	}

}
