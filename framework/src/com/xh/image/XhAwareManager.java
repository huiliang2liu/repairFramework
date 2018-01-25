package com.xh.image;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import android.view.View;
import android.widget.ImageView;

/**
 * @version ����ʱ�䣺2017-11-20 ����11:57:30 ��Ŀ��XhlackAD-eclipse
 *          ������com.Xhlack.tv.image �ļ�����AwareManager.java ���ߣ�lhl ˵��:ͼƬ����������
 */

public class XhAwareManager {
	private Map<Integer, XhImageAware> imageAware;
	private Map<Integer, XhViewAware> viewAware;

	public XhAwareManager() {
		// TODO Auto-generated constructor stub
		imageAware = new HashMap<Integer, XhImageAware>();
		viewAware = new HashMap<Integer, XhViewAware>();
	}

	/**
	 * 
	 * lhl 2017-11-20 ����3:09:06 ˵�������
	 * 
	 * @param view
	 * @param aware
	 *            void
	 */
	synchronized void addView(View view, XhViewAware aware) {
		viewAware.put(viewId(view), aware);
	}

	/**
	 * 
	 * lhl 2017-11-20 ����3:09:58 ˵�������
	 * 
	 * @param imageView
	 * @param aware
	 *            void
	 */
	synchronized void addImageView(ImageView imageView, XhImageAware aware) {
		imageAware.put(viewId(imageView), aware);
	}

	/**
	 * 
	 * lhl 2017-11-20 ����3:10:44 ˵����ɾ��
	 * 
	 * @param view
	 *            void
	 */
	synchronized void removeView(View view) {
		if (viewAware.containsKey(view))
			viewAware.remove(view);
	}

	/**
	 * 
	 * lhl 2017-11-20 ����3:16:22 ˵����ɾ��
	 * 
	 * @param imageView
	 *            void
	 */
	synchronized void removeImage(ImageView imageView) {
		if (imageAware.containsKey(imageView))
			imageAware.remove(imageView);
	}

	/**
	 * 
	 * lhl 2017-11-20 ����3:16:27 ˵��������
	 * 
	 * @param view
	 * @param url
	 * @param width
	 * @param height
	 * @param path
	 * @param saveTime
	 * @return XhAware
	 */
	synchronized XhAware selectView(View view, URL url, int width, int height,
			String path, long saveTime) {
		if (viewAware.containsKey(view))
			return viewAware.get(view);
		return new XhViewAware(view, url, width, height, path, saveTime);
	}

	/**
	 * 
	 * lhl 2017-11-20 ����3:16:37 ˵��������
	 * 
	 * @param imageView
	 * @param url
	 * @param width
	 * @param height
	 * @param path
	 * @param saveTime
	 * @return XhAware
	 */
	synchronized XhAware selectImage(ImageView imageView, URL url, int width,
			int height, String path, long saveTime) {
		if (imageAware.containsKey(imageView))
			return imageAware.get(imageView);
		return new XhImageAware(imageView, url, width, height, path, saveTime);
	}
/**
 * 
 * lhl
 * 2017-11-20 ����6:31:28
 * ˵������ͼת��Ϊid
 * @param view
 * @return int
 */
	private int viewId(View view) {
		int id = view.getId();
		if (id <= 0)
			return view.hashCode();
		return id;
	}
}
