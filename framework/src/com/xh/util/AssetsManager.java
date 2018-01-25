package com.xh.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

/**
 * @Author Zheng Haibo
 * @Mail mochuan.zhb@alibaba-inc.com
 * @Company Alibaba Group
 * @PersonalWebsite http://www.mobctrl.net
 * @version $Id: AssetsManager.java, v 0.1 2015年12月11日 下午4:41:10 mochuan.zhb Exp
 *          $
 * @Description
 */
public class AssetsManager {

	public static final String TAG = "AssetsApkLoader";

	// 从assets复制出去的apk的目标目录
	public static final String APK_DIR = "third";

	/**
	 * 将资源文件中的apk文件拷贝到私有目录中
	 * 
	 * @param context
	 */
	public static void copyAllAssetsApk(Context context, File dex) {

		AssetManager assetManager = context.getAssets();
		long startTime = System.currentTimeMillis();
		try {
			if (!dex.exists())
				dex.mkdir();
			String[] fileNames = assetManager.list("");
			for (String fileName : fileNames) {
				if (!fileName.endsWith(".apk") && !fileName.endsWith(".dex")) {
					XhLog.e(TAG, fileName);
					continue;
				}
				InputStream in = null;
				OutputStream out = null;
				in = assetManager.open(fileName);
				File f = new File(dex, fileName);
				if (f.exists() && f.length() == in.available()) {
					Log.e(TAG, fileName + "no change");
					return;
				}
				XhLog.e(TAG, fileName + " chaneged");
				out = new FileOutputStream(f);
				byte[] buffer = new byte[2048];
				int read;
				while ((read = in.read(buffer)) != -1) {
					out.write(buffer, 0, read);
				}
				in.close();
				in = null;
				out.flush();
				out.close();
				out = null;
				XhLog.e(TAG, fileName + " copy over");
			}
			XhLog.e(TAG, "###copyAssets time = "
					+ (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			XhLog.e(TAG, "出错了啊");
			e.printStackTrace();
		}

	}
}
