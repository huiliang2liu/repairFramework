package com.xh.encryption;

import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/**
 * 
 * ��˽Կ���ܹ�Կ����
 */
public class RSAPrivate extends AEncrytion {
	private byte[] publicKey;
	private byte[] privateKey;

	public RSAPrivate(com.xh.encryption.Key key) {
		// TODO Auto-generated constructor stub
		if (key == null)
			throw new RuntimeException("you key is null");
		if (key.getType() != com.xh.encryption.Key.TYPE_RSA)
			throw new RuntimeException("you type is wrong");
		publicKey = Base64.decode(key.getPublicKey(), 0);
		privateKey = Base64.decode(key.getPrivateKey(), 0);
	}

	@Override
	public byte[] encryption(byte[] text, byte[] vector) throws Exception {
		// TODO Auto-generated method stub
		// ȡ��˽Կ
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey);
		KeyFactory keyFactory = KeyFactory.getInstance(RSA);
		Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

		// �����ݼ���
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);

		return cipher.doFinal(text);
	}

	@Override
	public byte[] decryption(byte[] text, byte[] vector) throws Exception {
		// TODO Auto-generated method stub
		// ȡ�ù�Կ
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey);
		KeyFactory keyFactory = KeyFactory.getInstance(RSA);
		Key publicKey = keyFactory.generatePublic(x509KeySpec);

		// �����ݼ���
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		return cipher.doFinal(text);
	}

}
