package com.xh.image.display;

import com.xh.util.XhImageUtile;

import android.graphics.Bitmap;

/**
 * @version ����ʱ�䣺2017-11-21 ����10:30:13
 * ��Ŀ��XhlackAD-eclipse
 * ������com.Xhlack.tv.image.display
 * �ļ�����XhCircleDisplay.java
 * ���ߣ�lhl
 * ˵��:Բ��ͼƬ������
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
