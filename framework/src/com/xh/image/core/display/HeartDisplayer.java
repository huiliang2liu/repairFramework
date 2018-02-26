package com.xh.image.core.display;

import android.graphics.Bitmap;

import com.xh.image.core.assist.LoadedFrom;
import com.xh.image.core.imageaware.ImageAware;
import com.xh.image.drawable.HeartImageDrawable;
import com.xh.image.drawable.XHDrawable;
import com.xh.util.XhImageUtile;

public class HeartDisplayer extends BitmapDisplayer {

	@Override
	public void display(Bitmap bitmap, ImageAware imageAware,
			LoadedFrom loadedFrom) {
		// TODO Auto-generated method stub
		XHDrawable drawable = new HeartImageDrawable();
		if (is_zoom()) {
			int heigth = imageAware.getHeight();
			int width = imageAware.getWidth();
			drawable.setBitmap(XhImageUtile.zoom1(heigth, width, bitmap));
		} else
			drawable.setBitmap(bitmap);
		imageAware.setImageDrawable(drawable);
	}


}
