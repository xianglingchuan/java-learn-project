package com.myspringmvc.security;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class LearnAES {
	
	public static String str = "a security AES";
	
	
	public static void main(String[] args) {
		jdkAES();
		bcAES();
	}
	
	
	public static void jdkAES(){
		
		//生成KEY
		try {
			
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] keyBytes = secretKey.getEncoded();
			
			//KEY转换
			Key key = new SecretKeySpec(keyBytes, "AES");
			
			//加密
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(str.getBytes());
			System.out.println("jdk AES encrypt:"+Base64.encodeBase64String(result));
			
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, key);
			result = cipher.doFinal(result);
			System.out.println("jdk AES decrypt:"+new String(result));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void bcAES(){
		//生成KEY
		try {
			Security.addProvider(new BouncyCastleProvider());	
			
			
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES","BC");
			keyGenerator.init(128);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] keyBytes = secretKey.getEncoded();
			
			//KEY转换
			Key key = new SecretKeySpec(keyBytes, "AES");
			
			//加密
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(str.getBytes());
			System.out.println("jdk bcAES encrypt:"+Base64.encodeBase64String(result));
			
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, key);
			result = cipher.doFinal(result);
			System.out.println("jdk bcAES decrypt:"+new String(result));
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}

}

















