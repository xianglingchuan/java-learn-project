package com.myspringmvc.proxy.chain;

public  class Client {
	
	static class HandlerA extends Handler{
		@Override
		protected void handleProcess() {
			System.out.println("execute Handler a");			
		}
	}
	
	
	static class HandlerB extends Handler{
		@Override
		protected void handleProcess() {
			//System.out.println("sucessor.name====="+this.getSucessor().getClass().getName());
			System.out.println("execute Handler b");			
		}
	}	
	
	
	static class HandlerC extends Handler{
		@Override
		protected void handleProcess() {
			System.out.println("execute Handler c");			
		}
	}	
	
	
	public static void main(String[] args) {
		HandlerA handlerA = new HandlerA();
		HandlerB handlerB = new HandlerB();
		HandlerC handlerC = new HandlerC();
		
		handlerA.setSucessor(handlerB);
		handlerB.setSucessor(handlerC);
		
		handlerA.execute();
		
	}
	

}
