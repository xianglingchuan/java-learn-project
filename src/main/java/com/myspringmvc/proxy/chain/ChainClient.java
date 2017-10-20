package com.myspringmvc.proxy.chain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

public class ChainClient {

	static class ChainClientA extends ChainHandler {

		@Override
		protected void handlerProcess() {
			System.out.println("execute ChainClient a");
		}
	}
	
	
	static class ChainClientB extends ChainHandler {

		@Override
		protected void handlerProcess() {
			System.out.println("execute ChainClient b");
		}
	}	
	
	
	
	static class ChainClientC extends ChainHandler {

		@Override
		protected void handlerProcess() {
			System.out.println("execute ChainClient c");
		}
	}	
	
	
	public static void main(String[] args) {
		List<ChainHandler> handlers = Arrays.asList(
				new ChainClientA(),
				new ChainClientB(),
				new ChainClientC()
				);
		Chain chain = new Chain(handlers);
		chain.proceed();
	}
	
	

}
