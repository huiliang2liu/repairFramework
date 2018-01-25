package com.xh.image;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.URL;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;

import com.xh.image.display.XhIDisplay;

/**
 * @version 创建时间：2017-11-20 上午11:56:31 项目：XhlackAD-eclipse
 *          包名：com.Xhlack.tv.image 文件名：Aware.java 作者：lhl 说明:图片处理器
 */

public abstract class XhAware {
	private WeakReference<View> reference;
	private URL url;
	protected Bitmap bitmap;
	private int width;
	private int height;
	private String savePath;
	private long saveTime;
	boolean back = true;
	protected XhIDisplay display;
	XhAwareManager awareManager;

	public XhAware(View view, URL url, int width, int height, String savePath,
			long savaTime) {
		reference = new WeakReference<View>(view);
		this.url = url;
		this.width = width;
		this.height = height;
		this.savePath = savePath;
		this.saveTime = savaTime;
	}

	public int getWidth() {
		if (width > 0)
			return width;
		return getViewWidth();
	}

	public int getHeight() {
		if (height > 0)
			return height;
		return getViewHeight();
	}

	private int getViewHeight() {
		// TODO Auto-generated method stub
		View view = reference.get();
		if (view != null) {
			int width = 0;
			width = view.getHeight();
			if (width < 0) {
				ViewGroup.LayoutParams params = view.getLayoutParams();
				if (params != null) {
					width = params.height;
					if (width < 0)
						width = getValue(view, "mMaxHeight");
				}
			}
			return width;
		}
		return 0;
	}

	public int getViewWidth() {
		// TODO Auto-generated method stub
		View view = reference.get();
		if (view != null) {
			int width = 0;
			width = view.getWidth();
			if (width < 0) {
				ViewGroup.LayoutParams params = view.getLayoutParams();
				if (params != null) {
					width = params.width;
					if (width < 0)
						width = getValue(view, "mMaxWidth");
				}
			}
			return width;
		}
		return 0;
	}

	private static int getValue(Object object, String fieldName) {
		int value = 0;
		try {
			Field field = object.getClass().getDeclaredField(fieldName);
			if (!field.isAccessible())
				field.setAccessible(true);
			int fieldValue = field.getInt(object);
			if (fieldValue > 0 && fieldValue < Integer.MAX_VALUE)
				value = fieldValue;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return value;
	}

	protected View getView() {
		return reference.get();
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public long getSaveTime() {
		return saveTime;
	}

	public void setSaveTime(long saveTime) {
		this.saveTime = saveTime;
	}

	public boolean isBack() {
		return back;
	}

	public void setBack(boolean back) {
		this.back = back;
	}

	public XhIDisplay getDisplay() {
		return display;
	}

	public void setDisplay(XhIDisplay display) {
		this.display = display;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setAwareManager(XhAwareManager awareManager) {
		this.awareManager = awareManager;
	}

	/**
	 * 
	 * lhl 2017-11-20 下午6:29:59 说明：设置位图
	 * 
	 * @param bitmap
	 *            void
	 */
	abstract void setViewBitmap(Bitmap bitmap);
}
