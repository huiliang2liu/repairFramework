package com.xh.repairapk;

import com.xh.plugin.PluginService;
import com.xh.util.XhLog;

/**
 * @version ����ʱ�䣺2018-1-16 ����6:40:15 ��Ŀ��repairText ������com.xh.repairapk
 *          �ļ�����MyService.java ���ߣ�lhl ˵��:
 */

public class MyService extends PluginService {
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		XhLog.e("MyService", "onCreate");
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		XhLog.e("MyService", "onDestroy");
	}
}
