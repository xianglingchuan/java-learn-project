package com.myspringmvc.listener.entity;

import java.awt.print.PrinterAbortException;

public class OnlineUser {
	
	private String sessionIdString;
	
	private String ipString;
	
	private String firstTimeString;

	public String getSessionIdString() {
		return sessionIdString;
	}

	public void setSessionIdString(String sessionIdString) {
		this.sessionIdString = sessionIdString;
	}

	public String getIpString() {
		return ipString;
	}

	public void setIpString(String ipString) {
		this.ipString = ipString;
	}

	public String getFirstTimeString() {
		return firstTimeString;
	}

	public void setFirstTimeString(String firstTimeString) {
		this.firstTimeString = firstTimeString;
	}

	@Override
	public String toString() {
		return "OnlineUser [sessionIdString=" + sessionIdString + ", ipString=" + ipString + ", firstTimeString="
				+ firstTimeString + "]";
	}
	
	

}
