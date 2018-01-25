package com.xh.image.drawable;

import android.graphics.Canvas;
import android.graphics.RectF;

/**
 * 原始的图�?
 * 
 */
public class OriginalImageDrawable extends XHDrawable {
	private RectF rect;

	@Override
	protected void setBound() {
		// TODO Auto-generated method stub
		rect = new RectF(0, 0, mBitmap.getWidth(), mBitmap.getHeight());
	}

	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.drawRect(rect, mPaint);
		super.draw(canvas);
	}
}
