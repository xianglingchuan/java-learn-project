package com.myspringmvc.security;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;



public class LearnBase64 {

	private static String src="learn security base64";
	
	
	public static void main(String[] args) {

		jdkBase64();
		commonsCodesBase64();
		bouncyCastleBase64();
	}
	
	public static void jdkBase64(){
		
		try {
			BASE64Encoder encodeObject = new BASE64Encoder();
			String encode = encodeObject.encode(src.getBytes());
			System.out.println("encode:"+encode);
			
			BASE64Decoder decoderObject = new BASE64Decoder();
			byte[] bytes = decoderObject.decodeBuffer(encode);
			
			System.out.println("decode:"+new String(bytes));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void commonsCodesBase64(){
		byte[] bytes = Base64.encodeBase64(src.getBytes());
		System.out.println("encode:"+new String(bytes));
		
		byte[] bytes2 = Base64.decodeBase64(bytes);
		System.out.println("decode:"+new String(bytes2));
	}
	
	public static void bouncyCastleBase64(){
		byte[] bytes =  org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
		System.out.println("encode:"+new String(bytes));
		
		byte[] bytes2 =  org.bouncycastle.util.encoders.Base64.decode(bytes);
		System.out.println("decode:"+new String(bytes2));
		
	}

}












