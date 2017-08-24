package com.myspringmvc.listener.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.myspringmvc.listener.entity.OnlineUser;

public class OnlineUserUtil {
	
	
	
	public static OnlineUser getUserBySession(ArrayList<OnlineUser> users,String sessionId){		
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getSessionIdString().equals(sessionId)){
				return users.get(i);
			}
		}
		return null;
	}
	


}
