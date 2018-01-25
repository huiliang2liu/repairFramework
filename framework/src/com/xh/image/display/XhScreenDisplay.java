package com.xh.image.display;

import android.graphics.Bitmap;

import com.xh.util.XhImageUtile;

/**
 * @version ����ʱ�䣺2017-11-20 ����12:24:54
 * ��Ŀ��XhlackAD-eclipse
 * ������com.Xhlack.tv.image.display
 * �ļ�����XhScreenDisplay.java
 * ���ߣ�lhl
 * ˵��: ��ͼ����������Ҫ��Ϊ����λͼ���ؼ�
 */

public abstract class XhScreenDisplay implements XhIDisplay {
   protected XhImageType type=XhImageType.UP_LEFT;
   private int width;
   private int height;
   
   public XhScreenDisplay(XhImageType type) {
	// TODO Auto-generated constructor stub
	   this.type=type;
}
   public XhScreenDisplay() {
	// TODO Auto-generated constructor stub
}
	@Override
	public Bitmap deal(Bitmap bitmap) {
		// TODO Auto-generated method stub
		if(bitmap==null)
			throw new RuntimeException("bitmap is null");
		int widthB=bitmap.getWidth();
		int heightB=bitmap.getHeight();
		int startX=0;
		int startY=0;
		Bitmap mBitmap=null;
		if(type==XhImageType.UP_LEFT)
			mBitmap=XhImageUtile.load_figure(bitmap, startX, startY, width, height);
		else if(type==XhImageType.UP_RIGHT)
			mBitmap=XhImageUtile.load_figure(bitmap, widthB-widthB, startY, width, height);
		else if(type==XhImageType.UP_MIDDLE)
			mBitmap=XhImageUtile.load_figure(bitmap, (widthB-width)>>1, startY, width, height);
		else if(type==XhImageType.MIDDLE_LEFT)
			mBitmap=XhImageUtile.load_figure(bitmap, startX, (heightB-height)>>1, width, height);
		else if(type==XhImageType.MIDDLE_MIDDLE)
			mBitmap=XhImageUtile.load_figure(bitmap, (widthB-width)>>1, (heightB-height)>>1, width, height);
		else if(type==XhImageType.MIDDLE_RIGHT)
			mBitmap=XhImageUtile.load_figure(bitmap, widthB-width, (heightB-height)>>1, width, height);
		else if(type==XhImageType.DOWN_LEFT)
			mBitmap=XhImageUtile.load_figure(bitmap, startX, heightB-height, width, height);
		else if(type==XhImageType.DOWN_MIDDLE)
			mBitmap=XhImageUtile.load_figure(bitmap, (widthB-width)>>1, heightB-height, width, height);
		else if(type==XhImageType.DOWN_RIGHT)
			mBitmap=XhImageUtile.load_figure(bitmap, widthB-width, heightB-height, width, height);
		return draw(mBitmap);
	}
	
   public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * 
	 * lhl
	 * 2017-11-21 ����10:44:41
	 * ˵��������ͼƬ
	 * @param bitmap
	 * @return Bitmap
	 */
protected abstract  Bitmap draw(Bitmap bitmap);
}
