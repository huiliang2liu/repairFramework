package com.xh.thread;

import android.os.Handler;
import android.os.Looper;

/**
 * @version ����ʱ�䣺2017-12-15 ����6:13:26 ��Ŀ��repair ������com.xh.thread
 *          �ļ�����HxHandler.java ���ߣ�lhl ˵��:
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
