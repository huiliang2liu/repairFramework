package com.xh.encryption;

import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DES extends AEncrytion {
	private byte[] key;
	private SecretKey securekey;
	private Exception exception;

	public DES(Key key) {
		// TODO Auto-generated constructor stub
		if (key == null)
			throw new RuntimeException("you key is null");
		this.key = key.getPublicKey().getBytes();
		try {
			// ����һ��DESKeySpec����
			DESKeySpec desKey = new DESKeySpec(this.key);
			// ����һ���ܳ׹���
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
			// ��DESKeySpec����ת����SecretKey����
			securekey = keyFactory.generateSecret(desKey);
		} catch (Exception e) {
			// TODO: handle exception
			exception = e;
		}
	}

	@Override
	public byte[] encryption(byte[] text, byte[] vector) throws Exception {
		// TODO Auto-generated method stub
		if (exception != null)
			throw exception;
		if (vector == null)
			vector = key;
		if (vector.length != 8) {
			vector = Arrays.copyOf(vector, 8);
		}
		// Cipher����ʵ����ɼ��ܲ���
		Cipher cipher = Cipher.getInstance(DES_CBC);
		// ���ܳ׳�ʼ��Cipher����
		cipher.init(Cipher.ENCRYPT_MODE, securekey, new IvParameterSpec(vector));
		// ���ڣ���ȡ���ݲ�����
		// ��ʽִ�м��ܲ���
		return cipher.doFinal(text);
	}

	@Override
	public byte[] decryption(byte[] text, byte[] vector) throws Exception {
		// TODO Auto-generated method stub
		if (exception != null)
			throw exception;
		if (vector == null)
			vector = key;
		if (vector.length != 8) {
			vector = Arrays.copyOf(vector, 8);
		}
		Cipher cipher = Cipher.getInstance(DES_CBC);
		// ���ܳ׳�ʼ��Cipher����
		cipher.init(Cipher.DECRYPT_MODE, securekey, new IvParameterSpec(vector));
		// ������ʼ���ܲ���
		return cipher.doFinal(text);
	}
}
