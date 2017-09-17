package com.myspringmvc.tag2;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ModifyBodyContent extends SimpleTagSupport {
	
	
	@Override
	public void doTag() throws JspException, IOException {
		
		StringWriter stringWriter = new StringWriter();
		JspFragment jspFragment = getJspBody();
		jspFragment.invoke(stringWriter);
		
		String content = stringWriter.toString();
		content = "www.baidu.com";
		
		PageContext pageContext = (PageContext)getJspContext();
		pageContext.getOut().write(content);
	}

}
