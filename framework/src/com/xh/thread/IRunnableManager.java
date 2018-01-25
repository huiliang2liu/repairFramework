package com.xh.thread;

import java.util.List;

/**
 * @version 创建时间：2017-12-20 下午2:41:34
 * 项目：repair
 * 包名：com.xh.ifaces
 * 文件名：IRunnableManager.java
 * 作者：lhl
 * 说明:
 */

public interface IRunnableManager {
	/**
	 * 
	 * lhl 2017-11-15 下午2:58:41 说明：提交任务
	 * 
	 * @param command
	 *            任务 void
	 */
	public void submit(Runnable command);

	/**
	 * 
	 * lhl 2017-11-15 下午3:01:37 说明：延迟提交任务
	 * 
	 * @param command
	 *            任务
	 * @param delay
	 *            延迟时间单位为毫秒 void
	 */
	public void submit(Runnable command, long delay);

	/**
	 * 
	 * lhl 2017-11-15 下午3:03:45 说明：延迟周期性执行任务
	 * 
	 * @param command
	 *            任务
	 * @param initialDelay
	 *            延迟时间
	 * @param period
	 *            周期 void
	 */
	public void submit(Runnable command, long initialDelay, long period);

	/**
	 * 
	 * lhl 2017-11-15 下午3:07:17 说明：提交任务
	 * 
	 * @param commands
	 *            任务列表 void
	 */
	public void submit(List<Runnable> commands);

	/**
	 * 移除任务 lhl 2017-11-15 下午3:08:42 说明：
	 * 
	 * @param command
	 *            void
	 */
	public void remove(Runnable command);
	/**
	 * 
	 * lhl
	 * 2017-12-20 下午2:51:36
	 * 说明：移除任务
	 * @param commands void
	 */
	public void remove(List<Runnable> commands);

	/**
	 * 
	 * lhl 2017-11-15 下午3:12:04 说明：停止执行任务包括在执行的任务
	 * 
	 * @return List<Runnable> 被停止的任务
	 */
	public List<Runnable> shutdownNow();

	/**
	 * 
	 * lhl 2017-11-15 下午3:14:14 说明：停止执行任务，正在执行的不会被停止，只是不接收任务 void
	 */
	public void shutdown();
}
