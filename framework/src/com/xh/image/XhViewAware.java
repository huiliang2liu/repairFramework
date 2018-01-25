package com.xh.image;

import java.net.URL;

import android.graphics.Bitmap;
import android.view.View;

import com.xh.image.display.XhScreenDisplay;
import com.xh.util.XhImageUtile;
import com.xh.util.XhLog;

/**
 * @version 创建时间：2017-11-20 下午3:04:57 项目：XhlackAD-eclipse 包名：com.Xhlack.tv.image
 *          文件名：XhViewAware.java 作者：lhl 说明:普通视图处理器,用于背景处理
 */

public class XhViewAware extends XhAware {

	public XhViewAware(View view, URL url, int width, int height,
			String savePath, long savaTime) {
		super(view, url, width, height, savePath, savaTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	void setViewBitmap(Bitmap bitmap) {
		// TODO Auto-generated method stub
		View view = getView();
		if (view == null)
			return;
		if (display instanceof XhScreenDisplay) {
			XhScreenDisplay screenDisplay = (XhScreenDisplay) display;
			int height = getHeight();
			int width = getWidth();
			screenDisplay.setHeight(height);
			screenDisplay.setWidth(width);
			view.setBackground(XhImageUtile.bitmap2drawable(display
					.deal(screenDisplay.deal(bitmap))));
		} else
			view.setBackground(XhImageUtile.bitmap2drawable(display
					.deal(bitmap)));
	}

}
