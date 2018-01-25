package com.xh.repairapk;

import com.xh.plugin.PluginService;
import com.xh.util.XhLog;

/**
 * @version 创建时间：2018-1-16 下午6:40:15 项目：repairText 包名：com.xh.repairapk
 *          文件名：MyService.java 作者：lhl 说明:
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
