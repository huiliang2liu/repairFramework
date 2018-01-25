package com.xh.plugin;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;

/**
 * @version 创建时间：2018-1-16 下午4:01:02 项目：repair 包名：com.xh.plugin
 *          文件名：IPluginService.java 作者：lhl 说明:
 */

public interface IPluginService {
	public Application getApplication();

	public void onCreate();

	public void onCreate(Service service);

	public void onStart(Intent intent, int startId);

	public void onDestroy();

	public void onConfigurationChanged(Configuration newConfig);

	public void onLowMemory();

	public IBinder onBind(Intent intent);

	public boolean onUnbind(Intent intent);

	public void onRebind(Intent intent);

	public void stopSelf();

	public void stopSelf(int startId);

	public boolean stopSelfResult(int startId);

	public void setForeground(boolean isForeground);
    public void onTaskRemoved(Intent rootIntent); 
    public int onStartCommand(Intent intent, int flags, int startId);
    public void onTrimMemory(int level) ;
}
