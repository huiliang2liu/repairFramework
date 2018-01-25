package com.xh.ifaces;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import org.xml.sax.InputSource;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * @version ����ʱ�䣺2018-1-9 ����5:48:49 ��Ŀ��repair ������com.xh.svg �ļ�����ISVGParser.java
 *          ���ߣ�lhl ˵��:
 */

public interface ISVGParser {
	/**
	 * 
	 * lhl 2018-1-9 ����5:50:17 ˵������������ת��Ϊ
	 * 
	 * @param is
	 * @return
	 * @throws Exception
	 *             ISVG
	 */
	public ISVG paras(InputStream is) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:50:57 ˵������������ת��Ϊdrawable
	 * 
	 * @param is
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(InputStream is) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:51:47 ˵������������ת��Ϊdrawable
	 * 
	 * @param is
	 * @param view
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(InputStream is, View view) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:51:59 ˵������������ת��Ϊdrawable
	 * 
	 * @param is
	 * @param width
	 * @param heigth
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(InputStream is, int width, int heigth)
			throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:52:14 ˵�������ļ�ת��ΪISVG
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 *             ISVG
	 */
	public ISVG paras(File file) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:52:43 ˵�������ļ�ת��Ϊdrawable
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(File file) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:53:08 ˵�������ļ�ת��Ϊdrawable
	 * 
	 * @param file
	 * @param view
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(File file, View view) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:53:19 ˵�������ļ�ת��Ϊdrawable
	 * 
	 * @param file
	 * @param width
	 * @param heigth
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(File file, int width, int heigth) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:53:44 ˵������uriת��ΪISVG
	 * 
	 * @param uri
	 * @return
	 * @throws Exception
	 *             ISVG
	 */
	public ISVG paras(String uri) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:54:12 ˵������uriת��Ϊdrawable
	 * 
	 * @param uri
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(String uri) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:54:30 ˵������uriת��Ϊdrawable
	 * 
	 * @param uri
	 * @param view
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(String uri, View view) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:54:41 ˵������uriת��Ϊdrawable
	 * 
	 * @param uri
	 * @param width
	 * @param heigth
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(String uri, int width, int heigth)
			throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:55:05 ˵������urlת��ΪISVG
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 *             ISVG
	 */
	public ISVG paras(URL url) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:55:21 ˵������urlת��Ϊdrawable
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(URL url) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:55:34 ˵������urlת��Ϊdrawable
	 * 
	 * @param url
	 * @param view
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(URL url, View view) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:55:41 ˵������urlת��Ϊdrawable
	 * 
	 * @param url
	 * @param width
	 * @param heigth
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(URL url, int width, int heigth) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:56:14 ˵������InputSourceת��ΪISVG
	 * 
	 * @param is
	 * @return
	 * @throws Exception
	 *             ISVG
	 */
	public ISVG paras(InputSource is) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:56:32 ˵������InputSourceת��Ϊdrawable
	 * 
	 * @param is
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(InputSource is) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:56:45 ˵������InputSourceת��Ϊdrawable
	 * 
	 * @param is
	 * @param view
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(InputSource is, View view) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:56:56 ˵������InputSourceת��Ϊdrawable
	 * 
	 * @param is
	 * @param width
	 * @param heigth
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(InputSource is, int width, int heigth)
			throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:57:09 ˵������resourcesת��ΪISVG
	 * 
	 * @param resources
	 * @param resId
	 * @return
	 * @throws Exception
	 *             VectorEntity
	 */
	public ISVG paras(Resources resources, int resId) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:57:43 ˵������resourcesת��Ϊdrawable
	 * 
	 * @param resources
	 * @param resId
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(Resources resources, int resId) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:57:54 ˵������resourcesת��Ϊdrawable
	 * 
	 * @param resources
	 * @param resId
	 * @param view
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(Resources resources, int resId, View view)
			throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:58:04 ˵������resourcesת��Ϊdrawable
	 * 
	 * @param resources
	 * @param resId
	 * @param width
	 * @param heigth
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(Resources resources, int resId, int width,
			int heigth) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����5:59:31 ˵������assets�ļ�ת��ΪISVG
	 * 
	 * @param manager
	 * @param string
	 * @return
	 * @throws Exception
	 *             ISVG
	 */
	public ISVG paras(AssetManager manager, String string) throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����6:00:16 ˵������assets�ļ�ת��Ϊdrawable
	 * 
	 * @param string
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(AssetManager manager, String string)
			throws Exception;

	/**
	 * 
	 * lhl 2018-1-9 ����6:00:44 ˵������assets�ļ�ת��Ϊdrawable
	 * 
	 * @param string
	 * @param view
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(AssetManager manager, String string, View view)
			throws Exception;

	/**
	 * 
	 * lhl 2018-1-11 ����6:11:30 ˵����
	 * 
	 * @param manager
	 * @param string
	 * @param width
	 * @param heigth
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawable(AssetManager manager, String string, int width,
			int heigth) throws Exception;

	/**
	 * 
	 * lhl 2018-1-11 ����6:11:41 ˵�������ַ���ת��Ϊ
	 * 
	 * @param pathString
	 *            path�ַ�����ʽ
	 * @return
	 * @throws Exception
	 *             ISVG
	 */
	public ISVG parasString(String pathString) throws Exception;

	/**
	 * 
	 * lhl 2018-1-11 ����6:12:43 ˵�������ַ���ת��Ϊ
	 * 
	 * @param pathString
	 *            path�ַ�����ʽ
	 * @param string
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawableString(String string) throws Exception;

	/**
	 * 
	 * lhl 2018-1-11 ����6:13:04 ˵�������ַ���ת��Ϊ
	 * 
	 * @param pathString
	 *            path�ַ�����ʽ
	 * @param string
	 * @param view
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawableString(String string, View view) throws Exception;

	/**
	 * 
	 * lhl 2018-1-11 ����6:13:17 ˵�������ַ���ת��Ϊ
	 * 
	 * @param pathString
	 *            path�ַ�����ʽ
	 * @param string
	 * @param width
	 * @param heigth
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawableString(String string, int width, int heigth)
			throws Exception;
	/**
	 * 
	 * lhl 2018-1-11 ����6:11:41 ˵�������ַ���ת��Ϊ
	 * 
	 * @param pathString
	 *            path�ַ�����ʽ
	 * @return
	 * @throws Exception
	 *             ISVG
	 */
	public ISVG parasStringVector(String pathString) throws Exception;

	/**
	 * 
	 * lhl 2018-1-11 ����6:12:43 ˵�������ַ���ת��Ϊ
	 * 
	 * @param pathString
	 *            path�ַ�����ʽ
	 * @param string
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawableStringVector(String string) throws Exception;

	/**
	 * 
	 * lhl 2018-1-11 ����6:13:04 ˵�������ַ���ת��Ϊ
	 * 
	 * @param pathString
	 *            path�ַ�����ʽ
	 * @param string
	 * @param view
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawableStringVector(String string, View view) throws Exception;

	/**
	 * 
	 * lhl 2018-1-11 ����6:13:17 ˵�������ַ���ת��Ϊ
	 * 
	 * @param pathString
	 *            path�ַ�����ʽ
	 * @param string
	 * @param width
	 * @param heigth
	 * @return
	 * @throws Exception
	 *             Drawable
	 */
	public Drawable drawableStringVector(String string, int width, int heigth)
			throws Exception;
}
