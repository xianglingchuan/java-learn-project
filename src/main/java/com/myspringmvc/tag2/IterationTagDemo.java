package com.myspringmvc.tag2;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IterationTagDemo extends SimpleTagSupport {
	
	
	private String[] items;
	
	private String name;
	
	
	
	
	public String[] getItems() {
		return items;
	}




	public void setItems(String[] items) {
		this.items = items;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	@Override
	public void doTag() throws JspException, IOException {
        if(items!=null && items.length>=1){
        	PageContext pageContext =(PageContext) getJspContext();
        	for(int i=0; i<items.length; i++){
        		pageContext.setAttribute("name", items[i]);
        		getJspBody().invoke(null);
        	}
        }		
	}

}
