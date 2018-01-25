package com.xh.image.display;

import com.xh.util.XhImageUtile;

import android.graphics.Bitmap;

/**
 * @version 创建时间：2017-11-21 上午10:45:52
 * 项目：XhlackAD-eclipse
 * 包名：com.Xhlack.tv.image.display
 * 文件名：XhHeartDisplay.java
 * 作者：lhl
 * 说明: 心形图片适配器
 */

public class XhHeartDisplay extends XhScreenDisplay {
	public XhHeartDisplay(XhImageType type) {
		// TODO Auto-generated constructor stub
		super(type);
	}
	public XhHeartDisplay() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected Bitmap draw(Bitmap bitmap) {
		// TODO Auto-generated method stub
		return XhImageUtile.heart_bitmap(bitmap);
	}

}
