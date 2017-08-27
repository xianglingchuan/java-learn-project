package com.myspringmvc.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


public class SkipPageOrEvalPageTag extends TagSupport {

	
	@Override
	public int doEndTag() throws JspException {
		
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		
		//是从那个页面过来的内容
		String referer = request.getHeader("referer");
		String url = "http://"+request.getServerName();
		if(referer!=null && referer.startsWith(url)){
			return EVAL_PAGE;
		}else{
			try {
				pageContext.getOut().print("不能访问界面内容,不是多本站内部跳转的");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return SKIP_PAGE;
		}
		//return super.doEndTag();
	}
	
	
}
