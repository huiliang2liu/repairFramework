package com.xh.image.display;

import android.graphics.Bitmap;

import com.xh.util.XhImageUtile;

/**
 * @version 创建时间：2017-11-21 上午11:35:02
 * 项目：XhlackAD-eclipse
 * 包名：com.Xhlack.tv.image.display
 * 文件名：XhRoundDisplay.java
 * 作者：lhl
 * 说明: 圆角图片适配器
 */

public class XhRoundDisplay implements XhIDisplay {
	private float roundPx=20;
	public XhRoundDisplay(float roundPx) {
		// TODO Auto-generated constructor stub
		this.roundPx=roundPx>0?roundPx:20;
	}
	public XhRoundDisplay() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Bitmap deal(Bitmap bitmap) {
		// TODO Auto-generated method stub
		return XhImageUtile.rounded_bitmap(bitmap, roundPx);
	}


}
