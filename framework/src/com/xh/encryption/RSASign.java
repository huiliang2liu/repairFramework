package com.xh.encryption;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSASign implements ISign {
	private byte[] publicKey;
	private byte[] privateKey;
	public RSASign(com.xh.encryption.Key key) {
		// TODO Auto-generated constructor stub
		if(key==null)
			throw new RuntimeException("you key is null");
		if(key.getType()!=com.xh.encryption.Key.TYPE_RSA)
			throw new RuntimeException("you type is wrong");
		publicKey=Base64.decode(key.getPublicKey(), 0);
		privateKey=Base64.decode(key.getPrivateKey(), 0);
	}

	@Override
	public String sign(String text) throws Exception{
		// TODO Auto-generated method stub
		return Base64.encodeToString(sign(text.getBytes()), 0);
	}

	@Override
	public byte[] sign(byte[] text) throws Exception{
		// TODO Auto-generated method stub
        // ����PKCS8EncodedKeySpec����
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey);
		// KEY_ALGORITHM ָ���ļ����㷨
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		// ȡ˽Կ�׶���
		PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
		// ��˽Կ����Ϣ��������ǩ��
		Signature signature = Signature.getInstance("MD5withRSA");
		signature.initSign(priKey);
		signature.update(text);

		return signature.sign();
	}

	@Override
	public boolean verify(String text, String signText) throws Exception{
		// TODO Auto-generated method stub
		return verify(text.getBytes(), Base64.decode(signText, 0));
	}

	@Override
	public boolean verify(byte[] text, byte[] signText) throws Exception{
		// TODO Auto-generated method stub
		// ����X509EncodedKeySpec����
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey);

		// KEY_ALGORITHM ָ���ļ����㷨
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");

		// ȡ��Կ�׶���
		PublicKey pubKey = keyFactory.generatePublic(keySpec);

		Signature signature = Signature.getInstance("MD5withRSA");
		signature.initVerify(pubKey);
		signature.update(text);

		// ��֤ǩ���Ƿ�����
		return signature.verify(signText);
	}

}
