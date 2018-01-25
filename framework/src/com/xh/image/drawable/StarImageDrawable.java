package com.xh.image.drawable;

import android.graphics.Canvas;
import android.graphics.Path;

public class StarImageDrawable extends XHDrawable {
	private Path path;
	private float r = 0, width = 0, height = 0;

	@Override
	protected void setBound() {
		// TODO Auto-generated method stub
		path = new Path();
		width = mBitmap.getWidth();
		height = mBitmap.getHeight();
		r = Math.min(width, height) / 2;
		path.moveTo(width / 2, 0);
		for (int i = 1; i < 10; i++) {
			float[] xy = getXy(i);
			path.lineTo(xy[0], xy[1]);
		}
		path.close();

	}

	private float[] getXy(int i) {
		// TODO Auto-generated method stub
		float[] xy = new float[2];
		double angle = i * 36 + 90;
		double length = 0;
		if (i % 2 == 0)
			length = r;
		else
			length = r * 0.618f;
		if (angle < 180) {
			angle = Math.toRadians(180 - angle);
			xy[0] = (float) (r + length * Math.cos(angle));
			xy[1] = (float) (r - length * Math.sin(angle));
		} else if (angle < 270) {
			angle = Math.toRadians(angle - 180);
			xy[0] = (float) (r + length * Math.cos(angle));
			xy[1] = (float) (r + length * Math.sin(angle));
		} else if (angle < 360) {
			angle = Math.toRadians(360 - angle);
			xy[1] = (float) (r + length * Math.sin(angle));
			xy[0] = (float) (r - length * Math.cos(angle));
		} else {
			angle = Math.toRadians(angle - 360);
			xy[1] = (float) (r - length * Math.sin(angle));
			xy[0] = (float) (r - length * Math.cos(angle));
		}
		return xy;
	}

	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.drawPath(path, mPaint);
		super.draw(canvas);
	}

}
