package com.xh.thread;

import java.util.concurrent.ThreadFactory;

import com.xh.util.XhLog;

/**
 * @version 创建时间：2017-11-15 下午2:47:21
 * 项目：TvBlackAD-eclipse
 * 包名：com.tvblack.tv.http
 * 文件名：TVBThreadFactory.java
 * 作者：lhl
 * 说明:线程工厂
 */

public class XhThreadFactory implements ThreadFactory {
	private final static String TAG=XhThreadFactory.class.getName();

	@Override
	public Thread newThread(Runnable arg0) {
		// TODO Auto-generated method stub
		Thread thread=new Thread(arg0, TAG+System.currentTimeMillis());
		thread.setPriority(Thread.MAX_PRIORITY);
		XhLog.e(TAG, "创建了线程");
		return thread;
	}

}
