package com.xh.image.display;

import android.graphics.Bitmap;

import com.xh.util.XhImageUtile;

/**
 * @version ����ʱ�䣺2017-11-21 ����11:38:18
 * ��Ŀ��XhlackAD-eclipse
 * ������com.Xhlack.tv.image.display
 * �ļ�����XhStarDisplay.java
 * ���ߣ�lhl
 * ˵��: ����
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
