package com.xh.image;

import java.net.URL;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;

import com.xh.encryption.MD5;
import com.xh.image.display.XhFullSpaceDisplay;
import com.xh.image.display.XhIDisplay;
import com.xh.image.display.XhOriginalDisplay;
import com.xh.thread.IRunnableManager;
import com.xh.util.XhImageUtile;
import com.xh.util.XhLog;

/**
 * @version 创建时间：2017-11-20 下午3:33:00 项目：XhlackAD-eclipse 包名：com.Xhlack.tv.image
 *          文件名：XhImageLoad.java 作者：lhl 说明: 图片加载器
 */

public class XhImageLoadImpl implements IImageManager {
	private int cacheHeight = -1;
	private int cacheWidth = -1;
	private String defaultSavePath;
	private long defaultSaveTime = Long.MAX_VALUE;
	private int startImage;
	private int failureImage;
	private XhAwareManager awareManager;
	private XhIDisplay display;
	private IRunnableManager manager;
	private Context context;

	@Override
	public void setStartImage(int startImage) {
		this.startImage = startImage;
	}

	@Override
	public void setFailureImage(int failureImage) {
		this.failureImage = failureImage;
	}

	public XhImageLoadImpl(IRunnableManager manager, Context context) {
		// TODO Auto-generated constructor stub
		awareManager = new XhAwareManager();
		this.manager = manager;
		display = new XhOriginalDisplay();
		this.context = context;
		defaultSavePath = context.getDir(
				MD5.String2MD5Method16(context.getPackageName()),
				Context.MODE_PRIVATE).toString();
	}

	@Override
	public void loadImage(ImageView view, String path) {
		loadImage(view, path, display);
	}

	@Override
	public void loadImage(ImageView view, String path, long saveTime) {
		loadImage(view, path, saveTime, display);
	}

	@Override
	public void loadImageFull(ImageView view, String path, long saveTime) {
		loadImage(view, path, saveTime, new XhFullSpaceDisplay());
	}

	@Override
	public void loadImageFull(ImageView view, String path) {
		loadImage(view, path, new XhFullSpaceDisplay());
	}

	@Override
	public void loadImage(ImageView view, String path, XhIDisplay display) {
		loadImage(view, path, defaultSaveTime, display);
	}

	@Override
	public void loadImage(ImageView view, String path, long saveTime,
			XhIDisplay display) {
		// TODO Auto-generated method stub
		loadImage(view, path, saveTime, display, null);
	}

	@Override
	public void loadImage(ImageView view, String path, long saveTime,
			XhIDisplay display, XhImageListen listen) {
		// TODO Auto-generated method stub
		loadImage(view, path, startImage, failureImage, saveTime, cacheWidth,
				cacheHeight, display, listen);
	}

	@Override
	public void loadImage(ImageView view, String path, int startImage,
			int failureImage, long saveTime, int width, int height,
			XhIDisplay display, XhImageListen listen) {
		// TODO Auto-generated method stub
		if (view == null) {
			XhLog.e("view is null");
			return;
		}
		if (display == null)
			display = this.display;
		try {
			URL url = new URL(path);
			XhAware aware = awareManager.selectImage(view, url, width, height,
					path, saveTime);
			aware.setDisplay(display);
			submitAware(aware, url, startImage, failureImage, listen);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void loadBackground(View view, String path, long savaTime) {
		loadBackground(view, path, savaTime, display);
	}

	@Override
	public void loadBackground(View view, String path) {
		loadBackground(view, path, display);
	}

	@Override
	public void loadBackgroundFull(View view, String path, long savaTime) {
		loadBackground(view, path, savaTime, new XhFullSpaceDisplay());
	}

	@Override
	public void loadBackgroundFull(View view, String path) {
		loadBackground(view, path, new XhFullSpaceDisplay());
	}

	@Override
	public void loadBackground(View view, String path, XhIDisplay display) {
		// TODO Auto-generated method stub
		loadBackground(view, path, defaultSaveTime, display);
	}

	@Override
	public void loadBackground(View view, String path, long saveTime,
			XhIDisplay display) {
		// TODO Auto-generated method stub
		loadBackground(view, path, saveTime, display, null);
	}

	@Override
	public void loadBackground(View view, String path, long saveTime,
			XhIDisplay display, XhImageListen listen) {
		// TODO Auto-generated method stub
		loadBackground(view, path, startImage, failureImage, saveTime,
				cacheWidth, cacheHeight, display, listen);
	}

	@Override
	public void loadBackground(View view, String path, int startImage,
			int failureImage, long saveTime, int width, int height,
			XhIDisplay display, XhImageListen listen) {
		// TODO Auto-generated method stub
		if (view == null)
			return;
		if (display == null)
			display = this.display;
		try {
			URL url = new URL(path);
			XhAware aware = awareManager.selectView(view, url, width, height,
					path, saveTime);
			aware.setDisplay(display);
			submitAware(aware, url, startImage, failureImage, listen);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 
	 * lhl 2017-11-20 下午6:32:59 说明：提交位图处理器
	 * 
	 * @param aware
	 * @param url
	 * @param src
	 *            void
	 */
	private void submitAware(XhAware aware, URL url, int start, int src,
			XhImageListen listen) {
		// TODO Auto-generated method stub
		XhImageCallback callback = new XhImageCallback(listen);
		if (startImage > 0)
			callback.setImage(aware, XhImageUtile.src(startImage, context));
		if (url == null) {
			if (src > 0)
				callback.setImage(aware, XhImageUtile.src(src, context));
		} else {
			aware.setSavePath(defaultSavePath);
			aware.setAwareManager(awareManager);
			XhImageRunnable runnable = new XhImageRunnable(callback, aware, src);
			submit(runnable);
		}
	}

	/**
	 * 
	 * lhl 2017-11-20 下午6:33:21 说明：提交位图处理器
	 * 
	 * @param runnable
	 *            void
	 */
	private void submit(XhImageRunnable runnable) {
		// TODO Auto-generated method stub
		if (Looper.myLooper() == Looper.getMainLooper())
			manager.submit(runnable);
		else
			runnable.run();
	}
}
