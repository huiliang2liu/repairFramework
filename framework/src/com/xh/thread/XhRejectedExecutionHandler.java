package com.xh.thread;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @version ����ʱ�䣺2017-11-15 ����2:45:44
 * ��Ŀ��TvBlackAD-eclipse
 * ������com.tvblack.tv.http
 * �ļ�����TVBRejectedExecutionHandler.java
 * ���ߣ�lhl
 * ˵��: ִ�б�����ʱ����
 */

public class XhRejectedExecutionHandler implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable arg0, ThreadPoolExecutor arg1) {
		// TODO Auto-generated method stub
		arg1.execute(arg0);
	}

}
