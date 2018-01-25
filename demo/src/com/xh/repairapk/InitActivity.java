package com.xh.repairapk;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Arrays;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.xh.encryption.EncryptionFactory;
import com.xh.encryption.IEncryption;
import com.xh.reflect.MethodManager;

/**
 * @version 创建时间：2018-1-12 下午5:54:07 项目：repairText 包名：com.xh.repairapk
 *          文件名：InitActivity.java 作者：lhl 说明:
 */

public class InitActivity extends Activity {
	MyApplication application;
	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			startActivity(new Intent(application, MainActivity.class));
			finish();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity12);
		application = (MyApplication) getApplication();

		new Thread() {
			@SuppressLint("NewApi")
			public void run() {
				AssetManager assetManager = getAssets();
				try {
					InputStream is = assetManager.open("classes1");
					File s = application.sdkOrApkSavePath();
					FileOutputStream fileOutputStream = new FileOutputStream(
							new File(s, "classes1.dex"));
					IEncryption encryption = EncryptionFactory
							.getDES(EncryptionFactory
									.CreateDESKey("liuhuiliang"));
					int readLen = -1;
					byte[] buff = new byte[1024 * 1024];
					byte[] by = null;
					while ((readLen = is.read(buff)) > 0) {
						if (by == null) {
							by = Arrays.copyOf(buff, readLen);
						} else {
							by = Arrays.copyOf(by, by.length + readLen);
							System.arraycopy(buff, 0, by, by.length - readLen,
									readLen);
						}
					}
					fileOutputStream.write(encryption.decryption(by));
					fileOutputStream.flush();
					fileOutputStream.close();
					is.close();

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();

				}
				application.load();
				handler.sendEmptyMessage(0);
				try {
					Class cl = Class.forName("com.example.jni.Ceshi");
					Method method = MethodManager.method(cl, "log",
							new Class[] { String.class });
					MethodManager.invoke(method, null, new Object[] { "你好" });
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			};
		}.start();
	}
}
