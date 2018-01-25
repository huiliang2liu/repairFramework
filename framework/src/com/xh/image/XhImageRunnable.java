package com.xh.image;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Comparator;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.xh.util.XhImageUtile;

/**
 * @version 创建时间：2017-11-20 下午12:59:30 项目：XhlackAD-eclipse
 *          包名：com.Xhlack.tv.image 文件名：XhImageRunnable.java 作者：lhl 说明: 图片加载
 */

public class XhImageRunnable implements Runnable {
	private final static String TAG = XhImageRunnable.class.getName();
	private XhImageCallback callback;
	private XhAware aware;
	private int readTimeOut = 5000;// 读取超时
	private int failureImage = 0;
	private int connectTime = 6000;// 连接超时

	public void setReadTimeOut(int readTimeOut) {
		this.readTimeOut = readTimeOut;
	}

	public void setConnectTime(int connectTime) {
		this.connectTime = connectTime;
	}

	public XhImageRunnable(XhImageCallback callback, XhAware aware,
			int failureImage) {
		// TODO Auto-generated constructor stub
		if (callback == null)
			throw new RuntimeException("callback is null");
		this.callback = callback;
		this.aware = aware;
		this.failureImage = failureImage;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		callback.start(aware);
		if (aware.getView() == null)
			return;
		Bitmap bitmap = cache();
		URL url = aware.getUrl();
		if (bitmap != null) {
			if (urlRelative(url, aware.getUrl())) {
				callback.setImage(aware, bitmap);
			}
			return;
		}
		synchronized (aware.getUrl().toString()) {
			try {
				URLConnection connection = url.openConnection();
				connection.setReadTimeout(readTimeOut);
				connection.setConnectTimeout(connectTime);
				InputStream is = connection.getInputStream();
				Bitmap bitmap2 = XhImageUtile.inputStream2Bitmap(
						aware.getHeight(), aware.getWidth(), is);
				if (urlRelative(url, aware.getUrl())) {
					callback.setImage(
							aware,
							XhImageUtile.zoom(aware.getHeight(),
									aware.getWidth(), bitmap2));
					if (aware.getSaveTime() > 0)
						try {
							save(bitmap2, connection.getContentLength());
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
				}
				if (aware.isBack())
					aware.awareManager.removeView(aware.getView());
				else
					aware.awareManager.removeImage((ImageView) aware.getView());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				callback.fail(aware);
			}
		}
	}

	/**
	 * 
	 * lhl 2017-11-20 下午6:33:36 说明：保存位图
	 * 
	 * @param bitmap
	 *            void
	 */
	private void save(Bitmap bitmap, int length) {
		synchronized (TAG) {
			isSave(length);
			for (int i = 0; i < 4; i++) {
				if (XhImageUtile.bitmap2File(bitmap, aware.getSavePath() + "/"
						+ sign(aware.getUrl().toString())))
					return;
			}
		}
	}

	/**
	 * 
	 * lhl 2017-11-23 下午12:22:17 说明：查看空间是否足够，如果不足就删除一些文件
	 * 
	 * @param size
	 *            使用空间 void
	 */
	@SuppressLint("NewApi")
	private void isSave(int size) {
		// TODO Auto-generated method stub
		File file = new File(aware.getSavePath());
		if (!file.exists())
			return;
		if (file.getFreeSpace() > size)
			return;
		File[] fs = file.listFiles();
		Arrays.sort(fs, new Comparator<File>() {

			@Override
			public int compare(File f1, File f2) {
				// TODO Auto-generated method stub
				long diff = f1.lastModified() - f2.lastModified();
				if (diff > 0) {
					return 1;
				} else if (diff == 0) {
					return 0;
				} else {
					return -1;
				}
			}
		});
		for (int i = 0; i < fs.length; i++) {
			File f = fs[i];
			size -= f.length();
			if (size <= 0)
				return;
		}
	}

	/**
	 * 
	 * lhl 2017-11-20 下午2:52:13 说明：检查缓存
	 * 
	 * @return Bitmap
	 */
	private Bitmap cache() {
		File file = new File(aware.getSavePath() + "/"
				+ sign(aware.getUrl().toString()));
		if (file.exists() && file.isFile()) {
			if ((System.currentTimeMillis() - file.lastModified()) < aware
					.getSaveTime()) {
				file.setLastModified(System.currentTimeMillis());
				return XhImageUtile.url(aware.getHeight(), aware.getWidth(), file.getAbsolutePath());
			} else
				file.delete();
		}
		return null;
	}

	/**
	 * 
	 * lhl 2017-11-20 下午6:34:04 说明：检测地址是否发生变化，主要用于列表滑动检测
	 * 
	 * @param url
	 * @param url2
	 * @return boolean
	 */
	private boolean urlRelative(URL url, URL url2) {
		return url.toString().equals(url2.toString());
	}

	/**
	 * 
	 * lhl 2017-11-20 下午6:34:31 说明：生成数字地址
	 * 
	 * @param string
	 * @return String
	 */
	public static String sign(String string) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(string.getBytes());
			byte[] buff = md.digest();
			int j = buff.length;
			char[] str = new char[j >> 1];
			for (int i = 0; i < str.length; i++) {
				byte bf = buff[i];
				str[i] = hexDigits[bf >>> 4 & 0x9];
			}
			return new String(str);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
