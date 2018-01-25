package com.xh.thread;

import android.os.Handler;
import android.os.Looper;

/**
 * @version 创建时间：2017-12-15 下午6:13:26 项目：repair 包名：com.xh.thread
 *          文件名：HxHandler.java 作者：lhl 说明:
 */

public class XhHandler extends Handler {
	public XhHandler(Callback callback) {
		// TODO Auto-generated constructor stub
		super(Looper.getMainLooper(), callback);
	}

	public XhHandler() {
		// TODO Auto-generated constructor stub
		super(Looper.getMainLooper());
	}
}
