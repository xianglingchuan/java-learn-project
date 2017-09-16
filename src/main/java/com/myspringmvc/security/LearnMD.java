package com.myspringmvc.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class LearnMD {
	
	public static String src="a learn security md";
	
	
	public static void main(String[] args) {
		jdkMD5();
		jdkMD2();
		bcMD5();
		bcMD4();
		ccMD5();
		ccMD2();
	}
	
	public static void jdkMD5(){
		try {
			MessageDigest mDigest = MessageDigest.getInstance("MD5");
			byte[] md5Bytes = mDigest.digest(src.getBytes());
			System.out.println("JDK MD5:"+Hex.encodeHexString(md5Bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}		
	}
	
	public static void jdkMD2(){
		try {
			MessageDigest mDigest = MessageDigest.getInstance("MD2");
			byte[] md5Bytes = mDigest.digest(src.getBytes());
			System.out.println("JDK MD2:"+Hex.encodeHexString(md5Bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}		
	}
	
	
	public static void bcMD5(){
//		Digest digest = new MD5Digest();
//		digest.update(src.getBytes(),0,src.getBytes().length);
//		byte[] md5Bytes = new byte[digest.getDigestSize()];
//		digest.doFinal(md5Bytes, 0);
//		System.out.println("BC MD5:"+org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes));
		
		try {
			Security.addProvider(new BouncyCastleProvider());
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] md5Bytes = md.digest(src.getBytes());
			System.out.println("BC MD5:"+Hex.encodeHexString(md5Bytes));			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void bcMD4(){
//		Digest digest = new MD4Digest();
//		digest.update(src.getBytes(),0,src.getBytes().length);
//		byte[] md4Bytes = new byte[digest.getDigestSize()];
//		digest.doFinal(md4Bytes, 0);
//		System.out.println("BC MD4:"+org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes));
		
		try {
			Security.addProvider(new BouncyCastleProvider());
			MessageDigest md = MessageDigest.getInstance("MD4");
			byte[] md5Bytes = md.digest(src.getBytes());
			System.out.println("BC MD4:"+Hex.encodeHexString(md5Bytes));			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void ccMD5(){
		System.out.println("CC MD5:"+DigestUtils.md5Hex(src.getBytes()));
	}
	
	
	public static void ccMD2(){
		System.out.println("CC MD2:"+DigestUtils.md2Hex(src.getBytes()));
	}
	
	
	
	
	
	
	
	
	
	

}
