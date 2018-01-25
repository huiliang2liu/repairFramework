package com.xh.plugin;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;

/**
 * @version ����ʱ�䣺2018-1-16 ����4:01:02 ��Ŀ��repair ������com.xh.plugin
 *          �ļ�����IPluginService.java ���ߣ�lhl ˵��:
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
