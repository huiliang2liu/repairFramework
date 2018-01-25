package com.xh.image.display;

import android.graphics.Bitmap;

import com.xh.util.XhImageUtile;

/**
 * @version 创建时间：2017-11-21 上午11:38:18
 * 项目：XhlackAD-eclipse
 * 包名：com.Xhlack.tv.image.display
 * 文件名：XhStarDisplay.java
 * 作者：lhl
 * 说明: 星形
 */

public class XhStarDisplay extends XhScreenDisplay {
	public XhStarDisplay(XhImageType type) {
		// TODO Auto-generated constructor stub
		super(type);
	}
	public XhStarDisplay() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected Bitmap draw(Bitmap bitmap) {
		// TODO Auto-generated method stub
		return XhImageUtile.star_bitmap(bitmap);
	}

}
