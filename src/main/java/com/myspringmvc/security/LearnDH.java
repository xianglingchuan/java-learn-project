package com.myspringmvc.security;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

import org.apache.commons.codec.binary.Base64;

public class LearnDH {
	
	public static String src = "this a security DH";
	
	
	public static void main(String[] args) {
		jdkDH();
	}
	
	
	
	public static void jdkDH(){
		
		try {
			//1、初始化发送方密钥
			KeyPairGenerator senderKeyPairGenerator = KeyPairGenerator.getInstance("DH");
			senderKeyPairGenerator.initialize(512);
			KeyPair senderKyePair = senderKeyPairGenerator.generateKeyPair();
			byte[] senderPublicKeyEnc = senderKyePair.getPublic().getEncoded(); //发送方公钥，发送给接收方(网络文件等)
			
			//2、初始化接收方密钥
			KeyFactory receiverKeyFactory = KeyFactory.getInstance("DH");
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(senderPublicKeyEnc);
			PublicKey receiverPublicKey = receiverKeyFactory.generatePublic(x509EncodedKeySpec);
			DHParameterSpec dhParameterSpec = ((DHPublicKey)receiverPublicKey).getParams();
			KeyPairGenerator receiverKeyPairGenerator = KeyPairGenerator.getInstance("DH");
			receiverKeyPairGenerator.initialize(dhParameterSpec);
			KeyPair receiverKeypair = receiverKeyPairGenerator.generateKeyPair();
			
			PrivateKey receiverPrivateKey = receiverKeypair.getPrivate();
			byte[] receiverPublicKeyEnc = receiverKeypair.getPublic().getEncoded();
			
			//3、密钥构建
			KeyAgreement receiverKeyAgreement = KeyAgreement.getInstance("DH");
			receiverKeyAgreement.init(receiverPrivateKey);
			receiverKeyAgreement.doPhase(receiverPublicKey, true);
			SecretKey receiverSecretKey = receiverKeyAgreement.generateSecret("DES");
			
			KeyFactory senderKeyFactory = KeyFactory.getInstance("DH");
			x509EncodedKeySpec =  new X509EncodedKeySpec(receiverPublicKeyEnc);
			PublicKey senderPublicKey = senderKeyFactory.generatePublic(x509EncodedKeySpec);
			KeyAgreement senderKeyAgreement = KeyAgreement.getInstance("DH");
			senderKeyAgreement.init(senderKyePair.getPrivate());
			senderKeyAgreement.doPhase(senderPublicKey, true);			
			SecretKey senderDesKey = senderKeyAgreement.generateSecret("DES");
			if(Objects.equals(senderDesKey, senderDesKey)){
				System.out.println("双方密钥相同!");
			}
			
			//4、加密
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, senderDesKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdk dh eccrypt:"+Base64.encodeBase64String(result));
			
			//5、解密
			cipher.init(Cipher.DECRYPT_MODE, senderDesKey);
			result = cipher.doFinal(result);
			System.out.println("jdk dh decrypt:"+new String(result));
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
























