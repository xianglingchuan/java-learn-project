package com.myspringmvc.freemarker.controller;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import freemarker.template.SimpleSequence;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class SortMethod implements TemplateMethodModelEx
{

	@Override
	public Object exec(List arguments) throws TemplateModelException {
		
		
		//获取第一个参数
	    SimpleSequence arg0 = (SimpleSequence) arguments.get(0);
	    List<BigDecimal> list = arg0.toList();
	    
	    Collections.sort(list,new Comparator<BigDecimal>(){

			@Override
			public int compare(BigDecimal o1, BigDecimal o2) {
				return o1.intValue() - o2.intValue();
			}	    	
	    });		
		return list;
	}

}
