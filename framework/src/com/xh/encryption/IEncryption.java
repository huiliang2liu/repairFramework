package com.xh.encryption;

public interface IEncryption {
	static final String DES_CBC = "DES/CBC/PKCS5Padding";
	static final String DES = "DES";
	static final String AES = "AES";
	static final String AES_CBC = "AES/CBC/PKCS5Padding";
	static final String RSA = "RSA";

	/**
	 * 
	 * @param text
	 * @return ����
	 */
	String encryption(String text) throws Exception;
	
	/**
	 * 
	 * @param text
	 * @return ����
	 */
	String encryption(String text,String vector) throws Exception;

	/**
	 * 
	 * @param text
	 * @return ����
	 */
	byte[] encryption(byte[] text) throws Exception;
	/**
	 * 
	 * @param text
	 * @return ����
	 */
	byte[] encryption(byte[] text,byte[] vector) throws Exception;

	/**
	 * 
	 * @param text
	 * @return ����
	 */
	String decryption(String text) throws Exception;
	/**
	 * 
	 * @param text
	 * @return ����
	 */
	String decryption(String text,String vector) throws Exception;

	/**
	 * 
	 * @param text
	 * @return ����
	 */
	byte[] decryption(byte[] text) throws Exception;
	/**
	 * 
	 * @param text
	 * @return ����
	 */
	byte[] decryption(byte[] text,byte[] vector) throws Exception;

}
