package com.xh.image.core.display;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

import com.xh.image.core.assist.LoadedFrom;
import com.xh.image.core.imageaware.ImageAware;
import com.xh.util.XhImageUtile;

public class Displayer extends RoundedBitmapDisplayer {
	private boolean zoom = false;

	public Displayer(int cornerRadiusPixels) {
		super(cornerRadiusPixels);
	}

	// ��ʾλͼ
	@Override
	public void display(Bitmap bitmap, ImageAware imageAware,
			LoadedFrom loadedFrom) {
		imageAware.setImageDrawable(new CircleDrawable(zoom ? XhImageUtile
				.zoom1(imageAware.getHeight(), imageAware.getWidth(), bitmap)
				: bitmap, margin));
	}

	public Displayer set_zoom(boolean zoom) {
		this.zoom = zoom;
		return this;
	}

	public static class CircleDrawable extends Drawable {
		private final int margin;
		private final RectF mRect = new RectF();
		private final BitmapShader bitmapShader;
		private final Paint paint;
		private RectF mBitmapRect;

		public CircleDrawable(Bitmap bitmap, int margin) {
			this.margin = 0;
			// ������ɫ��
			bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP,
					Shader.TileMode.CLAMP);
			mBitmapRect = new RectF(margin, margin, bitmap.getWidth() - margin,
					bitmap.getHeight() - margin);
			// ���û���
			paint = new Paint();
			paint.setAntiAlias(true);
			paint.setShader(bitmapShader);
		}

		// ��Բ������ԭ����λͼ
		@Override
		protected void onBoundsChange(Rect bounds) {
			super.onBoundsChange(bounds);
			mRect.set(margin, margin, bounds.width() - margin, bounds.height()
					- margin);

			// ����λͼ�����øþ���ת��ӳ��Դ���κ�Ŀ�ľ���
			Matrix shaderMatrix = new Matrix();
			shaderMatrix.setRectToRect(mBitmapRect, mRect,
					Matrix.ScaleToFit.FILL);
			// ������ɫ������
			bitmapShader.setLocalMatrix(shaderMatrix);
		}

		// ������߽磨ͨ�����õ�setBounds��
		@Override
		public void draw(Canvas canvas) {
			canvas.drawRoundRect(mRect, mRect.width() / 2, mRect.height() / 2,
					paint);
		}

		/**
		 * ���ش˻��ƶ���Ĳ�͸����/͸���� �����ص�ֵ�ǳ���ĸ�ʽ������PixelFormat֮һ��δ֪����͸����͸����͸��
		 * */
		@Override
		public int getOpacity() {
			// ��͸��
			return PixelFormat.TRANSLUCENT;
		}

		// ����͸����
		@Override
		public void setAlpha(int alpha) {
			paint.setAlpha(alpha);
		}

		// ��ɫ�˹�Ƭ��ͨ������setColorFilter��
		@Override
		public void setColorFilter(ColorFilter cf) {
			paint.setColorFilter(cf);
		}
	}
}
