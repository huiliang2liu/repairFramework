package com.xh.encryption;

public  interface ISign {
	/**
	 * ǩ��
	 * @param text
	 * @return
	 */
public abstract String sign (String text) throws Exception;
/**
 * ǩ��
 * @param text
 * @return
 */
public abstract byte[] sign(byte[] text) throws Exception;
/**
 * ��֤
 * @param text
 * @param signText
 * @return
 */
public abstract boolean verify(String text, String signText)throws Exception;
/**
 * ��֤
 * @param text
 * @param signText
 * @return
 */
public abstract boolean verify(byte[] text,byte[] signText)throws Exception;
}
