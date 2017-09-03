package com.myspringmvc.security;

import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class LearnPBE {
	
	public static String str = "a security PBE";
	
	public static void main(String[] args) {
		
		jdkPBE();
		bcPBE();
	}
	
	
	public static void jdkPBE(){
		
		try {
			
			Security.addProvider(new BouncyCastleProvider());	
			
			//初始化盐
			SecureRandom random = new SecureRandom();
			byte[] salt = random.generateSeed(8);
			
			//口令与密钥
			String password = "learn";
			PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHMD5andDES","BC");
			Key key = factory.generateSecret(pbeKeySpec);
			
			//加密
			PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt,100);
			Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES","BC");
			cipher.init(Cipher.ENCRYPT_MODE, key,pbeParameterSpec);
			byte[] result = cipher.doFinal(str.getBytes());
			System.out.println("bc pbe encrypt:"+org.apache.commons.codec.binary.Base64.encodeBase64String(result));
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, key,pbeParameterSpec);
			result = cipher.doFinal(result);
			System.out.println("bc pbe decrypt:"+new String(result));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	
	public static void bcPBE(){
		
		try {
			//初始化盐
			SecureRandom random = new SecureRandom();
			byte[] salt = random.generateSeed(8);
			
			//口令与密钥
			String password = "learn";
			PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHMD5andDES");
			Key key = factory.generateSecret(pbeKeySpec);
			
			//加密
			PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt,100);
			Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
			cipher.init(Cipher.ENCRYPT_MODE, key,pbeParameterSpec);
			byte[] result = cipher.doFinal(str.getBytes());
			System.out.println("jdk pbe encrypt:"+org.apache.commons.codec.binary.Base64.encodeBase64String(result));
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, key,pbeParameterSpec);
			result = cipher.doFinal(result);
			System.out.println("jdk pbe decrypt:"+new String(result));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
}
