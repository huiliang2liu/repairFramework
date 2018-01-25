package com.xh.encryption;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;


public class CreatKey {
	RSAPublicKey publicKey;
	RSAPrivateKey privateKey;
	public CreatKey() throws Exception{
		// TODO Auto-generated constructor stub
		KeyPairGenerator keyPairGen = KeyPairGenerator
		.getInstance("RSA");
keyPairGen.initialize(1024);

KeyPair keyPair = keyPairGen.generateKeyPair();

// ��Կ
 publicKey = (RSAPublicKey) keyPair.getPublic();

// ˽Կ
 privateKey = (RSAPrivateKey) keyPair.getPrivate();
	}
	/**
	 * ȡ��˽Կ
	 * 
	 * @return
	 * @throws Exception
	 */
	public  String getPrivateKeyString()
			throws Exception {
		return Base64.encodeToString(getPrivateKeyByte(), 0);
	}
	/**
	 * ȡ��˽Կ
	 * @return
	 * @throws Exception
	 */
	public byte[] getPrivateKeyByte()throws Exception{
		return privateKey.getEncoded();
	}

	/**
	 * ȡ�ù�Կ
	 * 
	 * @return
	 * @throws Exception
	 */
	public  String getPublicKeyString()
			throws Exception {
		return Base64.encodeToString(getPublicKeybyte(), 0);
	}
	/**
	 * ȡ�ù�Կ
	 * @return
	 * @throws Exception
	 */
	public byte[] getPublicKeybyte() throws Exception{
		return publicKey.getEncoded();
	}
}
