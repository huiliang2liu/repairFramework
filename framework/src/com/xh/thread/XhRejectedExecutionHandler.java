package com.xh.thread;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @version 创建时间：2017-11-15 下午2:45:44
 * 项目：TvBlackAD-eclipse
 * 包名：com.tvblack.tv.http
 * 文件名：TVBRejectedExecutionHandler.java
 * 作者：lhl
 * 说明: 执行被阻塞时处理
 */

public class XhRejectedExecutionHandler implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable arg0, ThreadPoolExecutor arg1) {
		// TODO Auto-generated method stub
		arg1.execute(arg0);
	}

}
