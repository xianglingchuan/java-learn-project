package com.myspringmvc.tag2;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DisplayOrSkipBody extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
        
		PageContext pageContext = (PageContext)getJspContext();
		String name = pageContext.getRequest().getParameter("name");
		if(name!=null && name.equals("learn")){
			getJspBody().invoke(null);
		}
		super.doTag();
	}
	
	
}
