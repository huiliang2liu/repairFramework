package com.xh.image.display;

import com.xh.util.XhImageUtile;

import android.graphics.Bitmap;

/**
 * @version ����ʱ�䣺2017-11-21 ����10:45:52
 * ��Ŀ��XhlackAD-eclipse
 * ������com.Xhlack.tv.image.display
 * �ļ�����XhHeartDisplay.java
 * ���ߣ�lhl
 * ˵��: ����ͼƬ������
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
