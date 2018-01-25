package com.xh.image;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import android.view.View;
import android.widget.ImageView;

/**
 * @version 创建时间：2017-11-20 上午11:57:30 项目：XhlackAD-eclipse
 *          包名：com.Xhlack.tv.image 文件名：AwareManager.java 作者：lhl 说明:图片处理器管理
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
	 * lhl 2017-11-20 下午3:09:06 说明：添加
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
	 * lhl 2017-11-20 下午3:09:58 说明：添加
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
	 * lhl 2017-11-20 下午3:10:44 说明：删除
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
	 * lhl 2017-11-20 下午3:16:22 说明：删除
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
	 * lhl 2017-11-20 下午3:16:27 说明：查找
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
	 * lhl 2017-11-20 下午3:16:37 说明：查找
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
 * 2017-11-20 下午6:31:28
 * 说明：视图转化为id
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
