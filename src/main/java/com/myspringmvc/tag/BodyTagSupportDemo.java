package com.myspringmvc.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

import javax.servlet.jsp.tagext.SimpleTag;


public class BodyTagSupportDemo extends BodyTagSupport {
	
	private BodyContent bodyContent;
	
	
	@Override
	public void setBodyContent(BodyContent b) {
		this.bodyContent = b;
	}
	
	@Override
	public int doEndTag() throws JspException {
		
		String content = bodyContent.getString();
		System.out.println(content);
		
		String newString = "www.sina.com";
		JspWriter jspWriter = bodyContent.getEnclosingWriter();
		try {
			jspWriter.write(newString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}
