package com.myspringmvc.tag2;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SkipPageOrEvalPage extends SimpleTagSupport {

	
	@Override
	public void doTag() throws JspException, IOException {
		
		PageContext pageContext = (PageContext)getJspContext();
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		String referer = request.getHeader("referer");
		System.out.println("referer:"+referer);
		if(referer==null){
			throw new SkipPageException();
		}else{
			getJspBody().invoke(null);
		}
		//super.doTag();
	}
	
	
}
