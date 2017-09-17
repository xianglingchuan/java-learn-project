//package com.myspringmvc.listener;
//
//
//import javax.servlet.annotation.WebListener;
//import javax.servlet.http.HttpSessionEvent;
//import javax.servlet.http.HttpSessionListener;
//
//
//
//@WebListener
//public class UserHttpSessionListener implements HttpSessionListener {
//
//	private int userNumber;
//	
//	@Override
//	public void sessionCreated(HttpSessionEvent se) {
//		System.out.println("******UserHttpSessionListener sessionCreated******userNumber:"+userNumber);
//		//userNumber++;
//		//se.getSession().getServletContext().setAttribute("userNumber", userNumber);
//
//	}
//
//	@Override
//	public void sessionDestroyed(HttpSessionEvent se) {
//		System.out.println("******UserHttpSessionListener sessionDestroyed******userNumber:"+userNumber);
//		//userNumber--;
//		//se.getSession().getServletContext().setAttribute("userNumber", userNumber);
//		
//		
////		ArrayList<OnlineUser> userList = null;
////		userList = (ArrayList<OnlineUser>)se.getSession().getServletContext().getAttribute("onlineUsers");
////		
////		if(OnlineUserUtil.getUserBySession(userList, se.getSession().getId())!=null){
////			userList.remove(OnlineUserUtil.getUserBySession(userList, se.getSession().getId()));
////		}				
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//}
