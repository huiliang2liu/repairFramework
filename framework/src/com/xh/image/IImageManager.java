package com.xh.image;

import android.view.View;
import android.widget.ImageView;

import com.xh.image.display.XhIDisplay;

/**
 * @version 创建时间：2017-12-22 下午5:34:55
 * 项目：repair
 * 包名：com.xh.image
 * 文件名：IImageManager.java
 * 作者：lhl
 * 说明:
 */

public interface IImageManager {
	/**
	 * 
	 * lhl 2017-11-20 下午4:13:41 说明：加载图片
	 * 
	 * @param view
	 *            显示的视图
	 * @param path
	 *            图片地址 void
	 */
	public void loadImage(ImageView view, String path);

	/**
	 * 
	 * lhl 2017-11-20 下午4:14:21 说明：加载图片
	 * 
	 * @param view
	 *            显示的视图
	 * @param path
	 *            图片地址
	 * @param saveTime
	 *            缓存时间 void
	 */
	public void loadImage(ImageView view, String path, long saveTime);

	/**
	 * 
	 * lhl 2017-11-20 下午4:14:46 说明：加载图片满控件
	 * 
	 * @param view
	 *            显示的视图
	 * @param path
	 *            图片地址
	 * @param saveTime
	 *            缓存时间 void
	 */
	public void loadImageFull(ImageView view, String path, long saveTime);

	/**
	 * 
	 * lhl 2017-11-20 下午4:15:23 说明：加载图片满控件
	 * 
	 * @param view
	 *            显示的视图
	 * @param path
	 *            图片地址 void
	 */
	public void loadImageFull(ImageView view, String path);

	/**
	 * 
	 * lhl 2017-11-20 下午4:15:45 说明：加载图片
	 * 
	 * @param view
	 *            显示的视图
	 * @param path
	 *            图片地址
	 * @param display
	 *            适配器 void
	 */
	public void loadImage(ImageView view, String path, XhIDisplay display);

	/**
	 * 
	 * lhl 2017-11-20 下午4:16:11 说明：加载图片
	 * 
	 * @param view
	 *            显示的视图
	 * @param path
	 *            图片地址
	 * @param saveTime
	 *            缓存时间
	 * @param display
	 *            适配器 void
	 */
	public void loadImage(ImageView view, String path, long saveTime,
			XhIDisplay display);

	/**
	 * 
	 * lhl 2017-11-20 下午4:16:11 说明：加载图片
	 * 
	 * @param view
	 *            显示的视图
	 * @param path
	 *            图片地址
	 * @param saveTime
	 *            缓存时间
	 * @param display
	 *            适配器 void
	 */
	public void loadImage(ImageView view, String path, long saveTime,
			XhIDisplay display, XhImageListen listen);

	/**
	 * 
	 * lhl 2017-11-20 下午4:16:40 说明：加载图片
	 * 
	 * @param view
	 *            显示的视图
	 * @param path
	 *            图片地址
	 * @param startImage
	 *            加载中显示的图片
	 * @param failureImage
	 *            加载失败显示的图片
	 * @param saveTime
	 *            缓存时间
	 * @param width
	 *            图片宽度
	 * @param height
	 *            图片高度
	 * @param display
	 *            适配器 void
	 */
	public void loadImage(ImageView view, String path, int startImage,
			int failureImage, long saveTime, int width, int height,
			XhIDisplay display, XhImageListen listen);

	/**
	 * 
	 * lhl 2017-11-20 下午4:17:31 说明： 加载背景图片
	 * 
	 * @param view
	 *            显示的视图
	 * @param path
	 *            图片地址
	 * @param savaTime
	 *            缓存时间 void
	 */
	public void loadBackground(View view, String path, long savaTime);

	/**
	 * 
	 * lhl 2017-11-20 下午4:18:02 说明：加载背景图片
	 * 
	 * @param view
	 *            显示的视图
	 * @param path
	 *            图片地址 void
	 */
	public void loadBackground(View view, String path);

	/**
	 * 
	 * lhl 2017-11-20 下午4:18:19 说明：加载背景图片满控件
	 * 
	 * @param view
	 *            显示的视图
	 * @param path
	 *            图片地址
	 * @param savaTime
	 *            缓存时间 void
	 */
	public void loadBackgroundFull(View view, String path, long savaTime);

	/**
	 * 
	 * lhl 2017-11-20 下午4:18:39 说明：加载背景图片满控件
	 * 
	 * @param view
	 *            显示的视图
	 * @param path
	 *            图片地址 void
	 */
	public void loadBackgroundFull(View view, String path) ;

	/**
	 * 
	 * lhl 2017-11-20 下午4:18:53 说明：加载背景图片
	 * 
	 * @param view
	 *            显示的视图
	 * @param path
	 *            图片地址
	 * @param display
	 *            适配器 void
	 */
	public void loadBackground(View view, String path, XhIDisplay display);

	/**
	 * 
	 * lhl 2017-11-20 下午4:19:20 说明：加载背景图片
	 * 
	 * @param view
	 *            显示的视图
	 * @param path
	 *            图片地址
	 * @param saveTime
	 *            缓存时间
	 * @param display
	 *            适配器 void
	 */
	public void loadBackground(View view, String path, long saveTime,
			XhIDisplay display);

	/**
	 * 
	 * lhl 2017-11-20 下午4:19:20 说明：加载背景图片
	 * 
	 * @param view
	 *            显示的视图
	 * @param path
	 *            图片地址
	 * @param saveTime
	 *            缓存时间
	 * @param display
	 *            适配器 void
	 */
	public void loadBackground(View view, String path, long saveTime,
			XhIDisplay display, XhImageListen listen);

	/**
	 * 
	 * lhl 2017-11-20 下午4:19:46 说明：加载背景图片
	 * 
	 * @param view
	 *            显示的视图
	 * @param path
	 *            图片地址
	 * @param startImage
	 *            开始加载的图片
	 * @param failureImage
	 *            加载失败的图片
	 * @param saveTime
	 *            缓存时间
	 * @param width
	 *            图片宽度
	 * @param height
	 *            图片高度
	 * @param display
	 *            适配器 void
	 */
	public void loadBackground(View view, String path, int startImage,
			int failureImage, long saveTime, int width, int height,
			XhIDisplay display, XhImageListen listen);
	public void setStartImage(int startImage);

	public void setFailureImage(int failureImage);
}
