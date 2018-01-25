package com.xh.image;

import java.net.URL;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.xh.image.display.XhScreenDisplay;

/**
 * @version ����ʱ�䣺2017-11-20 ����12:15:46 ��Ŀ��XhlackAD-eclipse
 *          ������com.Xhlack.tv.image �ļ�����ImageAware.java ���ߣ�lhl ˵��:ImageViewͼƬ������
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
