package com.myspringmvc.tag2;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.jasper.tagplugins.jstl.core.Choose;

public class OtherWiseTag extends SimpleTagSupport {
	
	
	
	@Override
	public void doTag() throws JspException, IOException {
		ChooseTag chooseTag = (ChooseTag)getParent();
		if(!chooseTag.isFlag()){
			getJspBody().invoke(null);
		}
	}

}
