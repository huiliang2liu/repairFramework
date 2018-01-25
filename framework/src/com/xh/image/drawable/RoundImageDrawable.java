package com.xh.image.drawable;

import android.graphics.Canvas;
import android.graphics.RectF;

/**
 * 圆角图形
 * 
 */
public class RoundImageDrawable extends XHDrawable {
	private RectF rectF;
	private int round;

	public RoundImageDrawable(int round) {
		this.round=round;
	}

	@Override
	protected void setBound() {
		// TODO Auto-generated method stub
		rectF = new RectF(0, 0, mBitmap.getWidth(), mBitmap.getHeight());
	}

	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.drawRoundRect(rectF, round, round, mPaint);
		super.draw(canvas);
	}

}
