package com.myspringmvc.security;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Hex;


public class LearnECDSA {
	
	private static String src="a learn security ECDSA";
	
	public static void main(String[] args) {
		jdkECDSA();
	}
	
	
	public static void jdkECDSA(){
		
		try {
			//1、初始化密钥
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
			keyPairGenerator.initialize(256);
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			ECPublicKey dsaPublicKey = (ECPublicKey)keyPair.getPublic();
			ECPrivateKey dsaPrivateKey =(ECPrivateKey)keyPair.getPrivate();
			
			//2、执行签名
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(dsaPrivateKey.getEncoded());
			KeyFactory keyFactory = KeyFactory.getInstance("EC");
			PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
			Signature signature = Signature.getInstance("SHA1withECDSA");
			signature.initSign(privateKey);
			signature.update(src.getBytes());
			byte[] result = signature.sign();
			System.out.println("jdk ecdsa sign:"+Hex.encodeHexString(result));
			
			//3、验证签名
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(dsaPublicKey.getEncoded());
		    keyFactory = KeyFactory.getInstance("EC");
		    PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		    signature = Signature.getInstance("SHA1withECDSA");
		    signature.initVerify(publicKey);
		    signature.update(src.getBytes());
		    boolean bool = signature.verify(result);
		    System.out.println("jdk ecdsa verify:"+bool);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}	
}
