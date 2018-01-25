package com.xh.image.display;

import android.graphics.Bitmap;

/**
 * @version ����ʱ�䣺2017-11-21 ����11:05:14
 * ��Ŀ��XhlackAD-eclipse
 * ������com.Xhlack.tv.image.display
 * �ļ�����XhPolygonDisplay.java
 * ���ߣ�lhl
 * ˵��: ������������� Ĭ���������
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
