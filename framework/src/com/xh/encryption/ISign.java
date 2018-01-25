package com.xh.encryption;

public  interface ISign {
	/**
	 * 签名
	 * @param text
	 * @return
	 */
public abstract String sign (String text) throws Exception;
/**
 * 签名
 * @param text
 * @return
 */
public abstract byte[] sign(byte[] text) throws Exception;
/**
 * 验证
 * @param text
 * @param signText
 * @return
 */
public abstract boolean verify(String text, String signText)throws Exception;
/**
 * 验证
 * @param text
 * @param signText
 * @return
 */
public abstract boolean verify(byte[] text,byte[] signText)throws Exception;
}
