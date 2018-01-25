package com.xh.image.display;

import android.graphics.Bitmap;

/**
 * @version 创建时间：2017-11-21 上午11:05:14
 * 项目：XhlackAD-eclipse
 * 包名：com.Xhlack.tv.image.display
 * 文件名：XhPolygonDisplay.java
 * 作者：lhl
 * 说明: 正多边形适配器 默认是五边形
 */

public class XhPolygonDisplay extends XhScreenDisplay {
	private int variable=5;
	public XhPolygonDisplay(XhImageType type,int variable) {
		// TODO Auto-generated constructor stub
		super(type);
		this.variable=variable<3?5:variable;
	}
	public XhPolygonDisplay(int variable) {
		// TODO Auto-generated constructor stub
		this.variable=variable<3?5:variable;
	}
	public XhPolygonDisplay() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected Bitmap draw(Bitmap bitmap) {
		// TODO Auto-generated method stub
		return com.xh.util.XhImageUtile.polygon_bitmap(bitmap, variable);
	}

}
