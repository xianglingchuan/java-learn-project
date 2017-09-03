package com.myspringmvc.security;

import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Learn3DES {

	public static String str = "a security 3DES";
	
	public static void main(String[] args) {
		jdk3DES();
		bc3DES();

	}

	
	public static void jdk3DES(){
		
		try {
			
			//生成KEY
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
			//keyGenerator.init(168);
			//另外一种写法
			keyGenerator.init(new SecureRandom());
			
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();
			
			
			//KEY转换
			DESedeKeySpec desKeySpec = new DESedeKeySpec(bytesKey);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
			Key converSecreKey = factory.generateSecret(desKeySpec);
			
			//加密
			Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, converSecreKey);
			byte[] result = cipher.doFinal(str.getBytes());
			System.out.println("jdk 3des encrypt:"+Hex.encodeHexString(result));
			
			
			//解密:
			cipher.init(Cipher.DECRYPT_MODE, converSecreKey);
			result = cipher.doFinal(result);
			System.out.println("jdk 3des decrypt:"+new String(result));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	
	public static void bc3DES(){
		try {
			
			Security.addProvider(new BouncyCastleProvider());			
			
			//生成KEY
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede","BC");
			keyGenerator.getProvider();
			
			keyGenerator.init(168);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();
			
			
			//KEY转换
			DESedeKeySpec desKeySpec = new DESedeKeySpec(bytesKey);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
			Key converSecreKey = factory.generateSecret(desKeySpec);
			
			//加密
			Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, converSecreKey);
			byte[] result = cipher.doFinal(str.getBytes());
			System.out.println("jdk bc3des encrypt:"+Hex.encodeHexString(result));
			
			
			//解密:
			cipher.init(Cipher.DECRYPT_MODE, converSecreKey);
			result = cipher.doFinal(result);
			System.out.println("jdk bc3des decrypt:"+new String(result));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
