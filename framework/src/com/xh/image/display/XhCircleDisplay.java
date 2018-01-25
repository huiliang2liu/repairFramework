package com.xh.image.display;

import com.xh.util.XhImageUtile;

import android.graphics.Bitmap;

/**
 * @version 创建时间：2017-11-21 上午10:30:13
 * 项目：XhlackAD-eclipse
 * 包名：com.Xhlack.tv.image.display
 * 文件名：XhCircleDisplay.java
 * 作者：lhl
 * 说明:圆行图片适配器
 */

public class XhCircleDisplay extends XhScreenDisplay {
	public XhCircleDisplay(XhImageType type) {
		// TODO Auto-generated constructor stub
		super(type);
	}
	public XhCircleDisplay() {
		// TODO Auto-generated constructor stub
		super();
	}
	@Override
	protected Bitmap draw(Bitmap bitmap) {
		// TODO Auto-generated method stub
		return XhImageUtile.circle_bitmap(bitmap);
	}

}
