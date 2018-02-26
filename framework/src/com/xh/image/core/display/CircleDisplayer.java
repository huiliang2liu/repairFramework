package com.xh.image.core.display;

import android.graphics.Bitmap;

import com.xh.image.core.assist.LoadedFrom;
import com.xh.image.core.imageaware.ImageAware;
import com.xh.image.drawable.CircleImageDrawable;
import com.xh.image.drawable.XHDrawable;
import com.xh.util.XhImageUtile;

public class CircleDisplayer extends BitmapDisplayer {
	// ÏÔÊ¾Î»Í¼
	@Override
	public void display(Bitmap bitmap, ImageAware imageAware,
			LoadedFrom loadedFrom) {
		XHDrawable drawable = new CircleImageDrawable();
		if (is_zoom()) {
			int heigth = bitmap.getHeight();
			int width = bitmap.getWidth();
			int start_x, start_y, end_x, end_y;
			if (heigth > width) {
				start_x = 0;
				end_x = width;
				start_y = (heigth - width) >> 1;
				end_y = width + start_y;
			} else {
				start_x = (width - heigth) >> 1;
				end_x = start_x + heigth;
				start_y = 0;
				end_y = heigth;
			}
			drawable.setBitmap(XhImageUtile.zoom(imageAware.getHeight(),
					imageAware.getWidth(), bitmap));
		} else
			drawable.setBitmap(bitmap);
		imageAware.setImageDrawable(drawable);
	}

}
