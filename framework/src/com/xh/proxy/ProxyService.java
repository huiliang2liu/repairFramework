package com.xh.proxy;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.IBinder;

import com.xh.plugin.IPluginService;
import com.xh.reflect.ClassManager;
import com.xh.util.Constants;

/**
 * @version ����ʱ�䣺2018-1-16 ����4:21:11 ��Ŀ��repair ������com.xh.proxy
 *          �ļ�����ProxyService.java ���ߣ�lhl ˵��:
 */

public class ProxyService extends Service {
	private IPluginService pluginService;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		// �ж��Ƿ���ڲ��Service��������ڣ��򲻽���Service����Ĺ��칤��
		if (pluginService == null) {
			init(intent);
		}
		return pluginService.onBind(intent);
	}

	private void init(Intent intent) {
		try {
			Class cl = Class.forName(intent
					.getStringExtra(Constants.CLASS_NAME));
			pluginService = (IPluginService) ClassManager.new_object(cl);
			pluginService.onCreate(this);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	// @Override
	// public void onStart(Intent intent, int startId) {
	// // TODO Auto-generated method stub
	// super.onStart(intent, startId);
	// Log.d(TAG, TAG + " onStart");
	//
	// }

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		// �ж��Ƿ���ڲ��Service��������ڣ��򲻽���Service����Ĺ��칤��
		if (pluginService == null) {
			init(intent);
		}
		super.onStartCommand(intent, flags, startId);
		return pluginService.onStartCommand(intent, flags, startId);
		// return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		pluginService.onDestroy();
		super.onDestroy();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		pluginService.onConfigurationChanged(newConfig);
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		pluginService.onLowMemory();
		super.onLowMemory();
	}

	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	@Override
	public void onTrimMemory(int level) {
		// TODO Auto-generated method stub
		pluginService.onTrimMemory(level);
		super.onTrimMemory(level);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		super.onUnbind(intent);
		return pluginService.onUnbind(intent);
	}

	@Override
	public void onRebind(Intent intent) {
		// TODO Auto-generated method stub
		pluginService.onRebind(intent);
		super.onRebind(intent);
	}

	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	@Override
	public void onTaskRemoved(Intent rootIntent) {
		// TODO Auto-generated method stub
		pluginService.onTaskRemoved(rootIntent);
		super.onTaskRemoved(rootIntent);
	}

}
