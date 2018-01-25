package com.xh.image.display;

import android.graphics.Bitmap;

import com.xh.util.XhImageUtile;

/**
 * @version ����ʱ�䣺2017-11-21 ����11:35:02
 * ��Ŀ��XhlackAD-eclipse
 * ������com.Xhlack.tv.image.display
 * �ļ�����XhRoundDisplay.java
 * ���ߣ�lhl
 * ˵��: Բ��ͼƬ������
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
