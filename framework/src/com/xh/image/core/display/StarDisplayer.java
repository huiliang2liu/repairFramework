package com.xh.image.core.display;

import android.graphics.Bitmap;

import com.xh.image.core.assist.LoadedFrom;
import com.xh.image.core.imageaware.ImageAware;
import com.xh.image.drawable.StarImageDrawable;
import com.xh.image.drawable.XHDrawable;
import com.xh.util.XhImageUtile;

public class StarDisplayer extends BitmapDisplayer {

	@Override
	public void display(Bitmap bitmap, ImageAware imageAware,
			LoadedFrom loadedFrom) {
		// TODO Auto-generated method stub
		XHDrawable drawable = new StarImageDrawable();
		if (is_zoom())
			drawable.setBitmap(XhImageUtile.zoom1(imageAware.getHeight(),
					imageAware.getWidth(), bitmap));
		else
			drawable.setBitmap(bitmap);
		imageAware.setImageDrawable(drawable);
	}

}
