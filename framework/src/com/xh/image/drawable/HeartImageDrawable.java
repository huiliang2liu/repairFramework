package com.xh.image.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

public class HeartImageDrawable extends XHDrawable {
	private Path path;
	private float width = 0, height = 0;

	@Override
	protected void setBound() {
		// TODO Auto-generated method stub
		path = new Path();
		// 得到屏幕的长宽的�?��
		width = mBitmap.getWidth();
		height = mBitmap.getHeight();
		float px = mBitmap.getWidth() / 2;
		float py = mBitmap.getHeight() / 2;
		float rate = Math.min(width, height) / 34;
		// 路径的起始点
		path.moveTo(px, py - 5 * rate);
		// 根据心形函数画图
		for (double i = 0; i <= 2 * Math.PI; i += 0.001) {
			float x = (float) (16 * Math.sin(i) * Math.sin(i) * Math.sin(i));
			float y = (float) (13 * Math.cos(i) - 5 * Math.cos(2 * i) - 2
					* Math.cos(3 * i) - Math.cos(4 * i));
			x *= rate;
			y *= rate;
			x = px - x;
			y = py - y;
			path.lineTo(x, y);
		}
		// r = Math.min(width, height) * 3 / 10;
		// for (int i = 0; i < 3600; i++) {
		// double angle = i;
		// angle = Math.toRadians(angle);
		// float a = (float) (r * (1 - Math.sin(angle)));
		// float x = (float) (r - a * Math.cos(angle));
		// float y = (float) (r - a * Math.sin(angle));
		// if (i == 0)
		// path.moveTo(x + r / 3, y);
		// else
		// path.lineTo(x + r / 3, y);
		// }
		path.close();
	}

	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.drawPath(path, mPaint);
		super.draw(canvas);
	}
	@Override
	protected void onBoundsChange(Rect bounds) {
		// TODO Auto-generated method stub
		super.onBoundsChange(bounds);
		
		// Resize the original bitmap to fit the new bound
		Matrix shaderMatrix = new Matrix();
		RectF mBitmapRect = new RectF (0, 0, mBitmap.getWidth(), mBitmap.getHeight());
		shaderMatrix.setRectToRect(mBitmapRect, mBitmapRect, Matrix.ScaleToFit.FILL);
		bitmapShader.setLocalMatrix(shaderMatrix);
	}
}
