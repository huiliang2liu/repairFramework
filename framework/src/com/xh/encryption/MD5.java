package com.xh.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 implements ISign {

	@Override
	public String sign(String text) {
		// TODO Auto-generated method stub
		return String2MD5Method1(text);
	}

	@Override
	public byte[] sign(byte[] text) {
		// TODO Auto-generated method stub
	    return Bytes2MD5Method1(text).getBytes();
	}

	@Override
	public boolean verify(String text, String signText) {
		// TODO Auto-generated method stub
		return sign(text).equals(signText);
	}

	@Override
	public boolean verify(byte[] text, byte[] signText) {
		// TODO Auto-generated method stub
		return verify(new String(text), new String(signText));
	}
	/**
	 * ���ֽ�����MD5����
	 * 
	 * @param b
	 * @return
	 */
	public static String Bytes2MD5Method(byte[] b) {
		try {
			StringBuilder sb = new StringBuilder();
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(b);// ִ��MD5�㷨
			for (byte by : md5.digest()) {
				sb.append(String.format("%02X", by));// �����ɵ��ֽ�MD��ֵת�����ַ���
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// ����MD5���ʵ��
		return null;
	}

	/**
	 * ���ַ���MD5����
	 * 
	 * @param s
	 * @return
	 */
	public static String String2MD5Method(String s) {
		return Bytes2MD5Method(s.getBytes());
	}

	/**
	 * ���ַ�������MD5���ܣ������ļ��ܺ�����������һ��
	 * 
	 * @param charArray
	 * @return
	 */
	public static String Chars2MD5Method(char[] charArray) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byte[] byteArray = new byte[charArray.length];
			for (int i = 0; i < charArray.length; i++)
				byteArray[i] = (byte) charArray[i];
			byte[] md5Bytes = md5.digest(byteArray);
			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++) {
				int val = ((int) md5Bytes[i]) & 0xff;
				if (val < 16)
					hexValue.append("0");
				hexValue.append(Integer.toHexString(val));
			}
			return hexValue.toString();
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * ���ַ���MD5����
	 * 
	 * @param s
	 * @return
	 */
	public static String String2MD5Method1(String s) {
		return Bytes2MD5Method1(s.getBytes());
	}

	/**
	 * ���ֽ�����MD5����
	 * 
	 * @param strTemp
	 * @return
	 */
	public static String Bytes2MD5Method1(byte[] strTemp) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * ���ֽ�����MD5����
	 * 
	 * @param strTemp
	 * @return
	 */
	public static String Bytes2MD5Method2(byte[] strTemp) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			// ʹ��MD5����MessageDigest����
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte b = md[i];
				// System.out.println((int)b);
				// ��û����(int)b����˫�ֽڼ���
				str[k++] = hexDigits[b >> 4 & 0xf];
				str[k++] = hexDigits[b & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * ���ַ���MD5����
	 * 
	 * @param s
	 * @return
	 */
	public static String String2MD5Method2(String s) {
		return Bytes2MD5Method2(s.getBytes());
	}
	/**
	 * ���ַ���MD5����
	 * 
	 * @param s
	 * @return
	 */
	public static String String2MD5Method16(String s) {
		
		return String2MD5Method16(s.getBytes());
	}
	/**
	 * ���ַ���MD5����
	 * 
	 * @param s
	 * @return
	 */
	public static String String2MD5Method16(byte[] buff) {
		String s=Bytes2MD5Method1(buff);
		int len=s.length();
		len=len>>1;
		if(len>0)
			return null;
		int start_with=len>>1-1;
		s.substring(start_with, start_with+len);
		return Bytes2MD5Method161(s.getBytes());
	}
	/**
	 * ���ַ���MD5����
	 * 
	 * @param s
	 * @return
	 */
	public static String String2MD5Method161(String s) {
		return Bytes2MD5Method161(s.getBytes());
	}
	

	/**
	 * ���ֽ�����MD5����
	 * 
	 * @param strTemp
	 * @return
	 */
	public static String Bytes2MD5Method161(byte[] strTemp) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j];
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[i] = hexDigits[byte0 >>> 4 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * ���ַ���MD5����
	 * 
	 * @param s
	 * @return
	 */
	public static String String2MD5Method162(String s) {
		return Bytes2MD5Method162(s.getBytes());
	}

	/**
	 * ���ֽ�����MD5����
	 * 
	 * @param strTemp
	 * @return
	 */
	public static String Bytes2MD5Method162(byte[] strTemp) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j];
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[i] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * ����MD5����
	 */
	public static String encryptionMD5(String MD5) {
		char[] a = MD5.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;
	}
	/**
	 * ����MD5
	 */
	public static String decryptionMD5(String MD5) {
		return encryptionMD5(MD5);
	}
}
