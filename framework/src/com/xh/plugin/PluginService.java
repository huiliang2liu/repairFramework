package com.xh.plugin;

import android.app.Application;
import android.app.Service;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;

/**
 * @version 创建时间：2018-1-16 下午4:05:02 项目：repair 包名：com.xh.plugin
 *          文件名：PluginService.java 作者：lhl 说明:
 */

public class PluginService extends PluginWrapperImpl implements IPluginService {
	private Service service;

	@Override
	public final Application getApplication() {
		// TODO Auto-generated method stub
		return service.getApplication();
	}

	@Override
	public final void stopSelf() {
		// TODO Auto-generated method stub
		service.stopSelf();
	}

	@Override
	public final void stopSelf(int startId) {
		// TODO Auto-generated method stub
		service.stopSelf(startId);
	}

	@Override
	public final boolean stopSelfResult(int startId) {
		// TODO Auto-generated method stub
		return service.stopSelfResult(startId);
	}

	@Override
	public final void setForeground(boolean isForeground) {
		// TODO Auto-generated method stub
		service.stopForeground(isForeground);
	}

	@Override
	public final void onCreate(Service service) {
		// TODO Auto-generated method stub
		this.service = service;
		ContextWrapper wrapper = service;
		onCreate(wrapper);
		onCreate();
	}

	@Override
	public void onTaskRemoved(Intent rootIntent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub

	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onRebind(Intent intent) {
		// TODO Auto-generated method stub

	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void onTrimMemory(int level) {
		// TODO Auto-generated method stub

	}
}
