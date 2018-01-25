package com.xh.thread;

import java.util.concurrent.ThreadFactory;

import com.xh.util.XhLog;

/**
 * @version ����ʱ�䣺2017-11-15 ����2:47:21
 * ��Ŀ��TvBlackAD-eclipse
 * ������com.tvblack.tv.http
 * �ļ�����TVBThreadFactory.java
 * ���ߣ�lhl
 * ˵��:�̹߳���
 */

public class XhThreadFactory implements ThreadFactory {
	private final static String TAG=XhThreadFactory.class.getName();

	@Override
	public Thread newThread(Runnable arg0) {
		// TODO Auto-generated method stub
		Thread thread=new Thread(arg0, TAG+System.currentTimeMillis());
		thread.setPriority(Thread.MAX_PRIORITY);
		XhLog.e(TAG, "�������߳�");
		return thread;
	}

}
