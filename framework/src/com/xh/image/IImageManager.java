package com.xh.image;

import android.view.View;
import android.widget.ImageView;

import com.xh.image.display.XhIDisplay;

/**
 * @version ����ʱ�䣺2017-12-22 ����5:34:55
 * ��Ŀ��repair
 * ������com.xh.image
 * �ļ�����IImageManager.java
 * ���ߣ�lhl
 * ˵��:
 */

public interface IImageManager {
	/**
	 * 
	 * lhl 2017-11-20 ����4:13:41 ˵��������ͼƬ
	 * 
	 * @param view
	 *            ��ʾ����ͼ
	 * @param path
	 *            ͼƬ��ַ void
	 */
	public void loadImage(ImageView view, String path);

	/**
	 * 
	 * lhl 2017-11-20 ����4:14:21 ˵��������ͼƬ
	 * 
	 * @param view
	 *            ��ʾ����ͼ
	 * @param path
	 *            ͼƬ��ַ
	 * @param saveTime
	 *            ����ʱ�� void
	 */
	public void loadImage(ImageView view, String path, long saveTime);

	/**
	 * 
	 * lhl 2017-11-20 ����4:14:46 ˵��������ͼƬ���ؼ�
	 * 
	 * @param view
	 *            ��ʾ����ͼ
	 * @param path
	 *            ͼƬ��ַ
	 * @param saveTime
	 *            ����ʱ�� void
	 */
	public void loadImageFull(ImageView view, String path, long saveTime);

	/**
	 * 
	 * lhl 2017-11-20 ����4:15:23 ˵��������ͼƬ���ؼ�
	 * 
	 * @param view
	 *            ��ʾ����ͼ
	 * @param path
	 *            ͼƬ��ַ void
	 */
	public void loadImageFull(ImageView view, String path);

	/**
	 * 
	 * lhl 2017-11-20 ����4:15:45 ˵��������ͼƬ
	 * 
	 * @param view
	 *            ��ʾ����ͼ
	 * @param path
	 *            ͼƬ��ַ
	 * @param display
	 *            ������ void
	 */
	public void loadImage(ImageView view, String path, XhIDisplay display);

	/**
	 * 
	 * lhl 2017-11-20 ����4:16:11 ˵��������ͼƬ
	 * 
	 * @param view
	 *            ��ʾ����ͼ
	 * @param path
	 *            ͼƬ��ַ
	 * @param saveTime
	 *            ����ʱ��
	 * @param display
	 *            ������ void
	 */
	public void loadImage(ImageView view, String path, long saveTime,
			XhIDisplay display);

	/**
	 * 
	 * lhl 2017-11-20 ����4:16:11 ˵��������ͼƬ
	 * 
	 * @param view
	 *            ��ʾ����ͼ
	 * @param path
	 *            ͼƬ��ַ
	 * @param saveTime
	 *            ����ʱ��
	 * @param display
	 *            ������ void
	 */
	public void loadImage(ImageView view, String path, long saveTime,
			XhIDisplay display, XhImageListen listen);

	/**
	 * 
	 * lhl 2017-11-20 ����4:16:40 ˵��������ͼƬ
	 * 
	 * @param view
	 *            ��ʾ����ͼ
	 * @param path
	 *            ͼƬ��ַ
	 * @param startImage
	 *            ��������ʾ��ͼƬ
	 * @param failureImage
	 *            ����ʧ����ʾ��ͼƬ
	 * @param saveTime
	 *            ����ʱ��
	 * @param width
	 *            ͼƬ���
	 * @param height
	 *            ͼƬ�߶�
	 * @param display
	 *            ������ void
	 */
	public void loadImage(ImageView view, String path, int startImage,
			int failureImage, long saveTime, int width, int height,
			XhIDisplay display, XhImageListen listen);

	/**
	 * 
	 * lhl 2017-11-20 ����4:17:31 ˵���� ���ر���ͼƬ
	 * 
	 * @param view
	 *            ��ʾ����ͼ
	 * @param path
	 *            ͼƬ��ַ
	 * @param savaTime
	 *            ����ʱ�� void
	 */
	public void loadBackground(View view, String path, long savaTime);

	/**
	 * 
	 * lhl 2017-11-20 ����4:18:02 ˵�������ر���ͼƬ
	 * 
	 * @param view
	 *            ��ʾ����ͼ
	 * @param path
	 *            ͼƬ��ַ void
	 */
	public void loadBackground(View view, String path);

	/**
	 * 
	 * lhl 2017-11-20 ����4:18:19 ˵�������ر���ͼƬ���ؼ�
	 * 
	 * @param view
	 *            ��ʾ����ͼ
	 * @param path
	 *            ͼƬ��ַ
	 * @param savaTime
	 *            ����ʱ�� void
	 */
	public void loadBackgroundFull(View view, String path, long savaTime);

	/**
	 * 
	 * lhl 2017-11-20 ����4:18:39 ˵�������ر���ͼƬ���ؼ�
	 * 
	 * @param view
	 *            ��ʾ����ͼ
	 * @param path
	 *            ͼƬ��ַ void
	 */
	public void loadBackgroundFull(View view, String path) ;

	/**
	 * 
	 * lhl 2017-11-20 ����4:18:53 ˵�������ر���ͼƬ
	 * 
	 * @param view
	 *            ��ʾ����ͼ
	 * @param path
	 *            ͼƬ��ַ
	 * @param display
	 *            ������ void
	 */
	public void loadBackground(View view, String path, XhIDisplay display);

	/**
	 * 
	 * lhl 2017-11-20 ����4:19:20 ˵�������ر���ͼƬ
	 * 
	 * @param view
	 *            ��ʾ����ͼ
	 * @param path
	 *            ͼƬ��ַ
	 * @param saveTime
	 *            ����ʱ��
	 * @param display
	 *            ������ void
	 */
	public void loadBackground(View view, String path, long saveTime,
			XhIDisplay display);

	/**
	 * 
	 * lhl 2017-11-20 ����4:19:20 ˵�������ر���ͼƬ
	 * 
	 * @param view
	 *            ��ʾ����ͼ
	 * @param path
	 *            ͼƬ��ַ
	 * @param saveTime
	 *            ����ʱ��
	 * @param display
	 *            ������ void
	 */
	public void loadBackground(View view, String path, long saveTime,
			XhIDisplay display, XhImageListen listen);

	/**
	 * 
	 * lhl 2017-11-20 ����4:19:46 ˵�������ر���ͼƬ
	 * 
	 * @param view
	 *            ��ʾ����ͼ
	 * @param path
	 *            ͼƬ��ַ
	 * @param startImage
	 *            ��ʼ���ص�ͼƬ
	 * @param failureImage
	 *            ����ʧ�ܵ�ͼƬ
	 * @param saveTime
	 *            ����ʱ��
	 * @param width
	 *            ͼƬ���
	 * @param height
	 *            ͼƬ�߶�
	 * @param display
	 *            ������ void
	 */
	public void loadBackground(View view, String path, int startImage,
			int failureImage, long saveTime, int width, int height,
			XhIDisplay display, XhImageListen listen);
	public void setStartImage(int startImage);

	public void setFailureImage(int failureImage);
}
