package com.xh.image;

import java.net.URL;

import android.graphics.Bitmap;
import android.view.View;

import com.xh.image.display.XhScreenDisplay;
import com.xh.util.XhImageUtile;
import com.xh.util.XhLog;

/**
 * @version ����ʱ�䣺2017-11-20 ����3:04:57 ��Ŀ��XhlackAD-eclipse ������com.Xhlack.tv.image
 *          �ļ�����XhViewAware.java ���ߣ�lhl ˵��:��ͨ��ͼ������,���ڱ�������
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
