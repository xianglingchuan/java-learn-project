package com.myspringmvc.tag2;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DisplayInfo extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = simpleDateFormat.format(new Date());
		JspWriter jspWriter =   getJspContext().getOut();
		jspWriter.write(dateStr);
		//super.doTag();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
