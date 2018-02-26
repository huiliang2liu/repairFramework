package com.xh.image.core.display;

import android.graphics.Bitmap;

import com.xh.image.core.assist.LoadedFrom;
import com.xh.image.core.imageaware.ImageAware;
import com.xh.image.drawable.PolygonImageDrawable;
import com.xh.util.XhImageUtile;

public class PolygonDisplayer extends BitmapDisplayer {
	private int edges = 5;

	public PolygonDisplayer(int edges) {
		// TODO Auto-generated constructor stub
		this.edges = edges;
	}

	@Override
	public void display(Bitmap bitmap, ImageAware imageAware,
			LoadedFrom loadedFrom) {
		// TODO Auto-generated method stub
		PolygonImageDrawable drawable = new PolygonImageDrawable(edges);
		if (is_zoom())
			drawable.setBitmap(XhImageUtile.zoom1(imageAware.getHeight(),
					imageAware.getWidth(), bitmap));
		else
			drawable.setBitmap(bitmap);
		imageAware.setImageDrawable(drawable);
	}

}
