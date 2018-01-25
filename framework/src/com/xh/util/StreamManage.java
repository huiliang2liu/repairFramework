package com.xh.util;

import android.annotation.SuppressLint;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.xh.string.StringUtil;

/**
 * 
 * ����������
 */
public class StreamManage {
	public static String UTF8 = "UTF-8";

	/**
	 * ��������ת��Ϊbyte����
	 * 
	 * @param is
	 * @return
	 */
	public static byte[] inputStream2byte(InputStream is) {
		try {
			// TODO Auto-generated method stub
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int len = 0;
			byte[] buffer = new byte[1024];
			while ((len = is.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
			bos.flush();
			byte[] arr = bos.toByteArray();
			bos.close();
			is.close();
			return arr;
		} catch (Exception e) {
			// TODO: handle exception
			return e.getMessage().getBytes();
		}
	}

	/**
	 * ��������ת��Ϊ String
	 * 
	 * @param is
	 * @return
	 * @throws Exception
	 */
	@SuppressLint("NewApi")
	public static String inputStream2String(InputStream is, String charsetName) {
		try {
			if (StringUtil.isEmpty(charsetName))
				return new String(inputStream2byte(is), UTF8);
			return new String(inputStream2byte(is), charsetName);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}

	/**
	 * ���ֽ�ת��Ϊ������
	 * 
	 * @param buff
	 * @return
	 */
	public static InputStream bytes2InputStream(byte[] buff) {
		return new ByteArrayInputStream(buff);
	}

	/**
	 * ��String ת��Ϊ������
	 * 
	 * @param string
	 * @return
	 * @throws Exception
	 */
	@SuppressLint("NewApi")
	public static InputStream string2InputStream(String string,
			String charsetName) {
		try {
			if (StringUtil.isEmpty(charsetName))
				return new ByteArrayInputStream(string.getBytes(UTF8));
			return new ByteArrayInputStream(string.getBytes(charsetName));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	/**
	 * ��������ת��Ϊ�ļ�
	 * 
	 * @param is
	 *            ������
	 * @param file_path
	 *            �ļ�����λ��
	 * @param file_name
	 *            �ļ���
	 * @return
	 * @throws Exception
	 */
	@SuppressLint("NewApi")
	public static File inputStream2File(InputStream is, String file_path,
			String file_name) {
		if (file_path == null || file_path.isEmpty())
			throw new RuntimeException("file_path is null or empty");
		if (file_name == null || file_name.isEmpty())
			throw new RuntimeException("file_name is null or empty");
		File path = new File(file_path);
		if (!path.exists())
			path.mkdirs();
		File file = new File(file_path + "/" + file_name);
		try {
			FileOutputStream fos = new FileOutputStream(file_path + "/"
					+ file_name);
			int len = -1;
			byte b[] = new byte[1024];
			while ((len = is.read(b)) > 0) {
				fos.write(b, 0, len);
			}
			fos.flush();
			fos.close();
			is.close();
			return file;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	/**
	 * ���ļ�ת��Ϊ������
	 * 
	 * @param file
	 *            �ļ�·��������·����
	 * @return
	 * @throws Exception
	 */
	public static InputStream file2InputStream(File file) {
		if (!FileManagemet.isFile(file))
			throw new RuntimeException(
					"file is null or not exists or directory");
		try {
			return new FileInputStream(file);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
