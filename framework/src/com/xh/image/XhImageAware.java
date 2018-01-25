package com.xh.image;

import java.net.URL;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.xh.image.display.XhScreenDisplay;

/**
 * @version 创建时间：2017-11-20 下午12:15:46 项目：XhlackAD-eclipse
 *          包名：com.Xhlack.tv.image 文件名：ImageAware.java 作者：lhl 说明:ImageView图片加载器
 */

public class XhImageAware extends XhAware {

	public XhImageAware(ImageView view, URL url, int width, int height,
			String savePath, long savaTime) {
		super(view, url, width, height, savePath, savaTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	void setViewBitmap(Bitmap bitmap) {
		// TODO Auto-generated method stub
		ImageView imageView = (ImageView) getView();
		if (imageView == null)
			return;
		if (display instanceof XhScreenDisplay) {
			XhScreenDisplay screenDisplay = (XhScreenDisplay) display;
			screenDisplay.setHeight(getHeight());
			screenDisplay.setWidth(getWidth());
		}
		imageView.setImageBitmap(display.deal(bitmap));
	}

}
