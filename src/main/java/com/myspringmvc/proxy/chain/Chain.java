package com.myspringmvc.proxy.chain;

import java.util.List;

public class Chain {
	
	private List<ChainHandler> handlers;
	
	private Integer index = 0;
	
	public Chain(List<ChainHandler> handlers){
		this.handlers = handlers;
	}
	
	public void proceed(){
		
		if(index >= handlers.size()){
			return;
		}else{
			handlers.get(index++).execute(this);
		}
		
		
	}
	
	
	
	
	
	
	

}
