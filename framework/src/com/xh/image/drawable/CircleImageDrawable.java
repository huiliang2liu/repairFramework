package com.xh.image.drawable;

import android.graphics.Canvas;

public class CircleImageDrawable extends XHDrawable {
	private float cx = 0, cy = 0, r = 0;

	@Override
	protected void setBound() {
		// TODO Auto-generated method stub
		cx = mBitmap.getWidth();
		cy = mBitmap.getHeight();
		r = Math.min(cx, cy) / 2;
	}

	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.drawCircle(cx / 2, cy / 2, r, mPaint);
		super.draw(canvas);
	}
}
