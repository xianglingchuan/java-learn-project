package com.myspringmvc.security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
public class LearnHmac {
	
	
	public static String src = "a security Hmac";
	
	public static void main(String[] args) {
		jdkHmacMD5();
		bcHmacMD5();
	}
	
	public static void jdkHmacMD5(){
		try {
			//初始化KeyGneeraator
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
			//生产密钥
			SecretKey secretKey = keyGenerator.generateKey();
			//byte[] key = secretKey.getEncoded(); //获取密钥
			byte[] key = Hex.decodeHex(new char[]{'a','a','a','a','a','a','a','a','a','a'});
			
			
			//还原密钥
			SecretKey restoreSecretKey = new SecretKeySpec(key, "HmacMD5");
			//实例化MAC
			Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());
			//初始化MAC
			mac.init(restoreSecretKey);
			byte[] hmacMD5Bytes = mac.doFinal(src.getBytes());
			System.out.println("jdk HmacMD5:"+Hex.encodeHexString(hmacMD5Bytes));
		} catch (NoSuchAlgorithmException | InvalidKeyException | DecoderException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void bcHmacMD5(){
		HMac hMac = new HMac(new MD5Digest());
		hMac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode("aaaaaaaaaa")));
		//hMac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode(src)));
		hMac.update(src.getBytes(),0,src.getBytes().length);
		
		//执行摘要
		byte[] hmacMD5Bytes = new byte[hMac.getMacSize()];
		hMac.doFinal(hmacMD5Bytes, 0);
		System.out.println("bc hmacMD5:"+org.bouncycastle.util.encoders.Hex.toHexString(hmacMD5Bytes));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
