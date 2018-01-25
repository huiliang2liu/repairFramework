package com.xh.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.xh.util.Constants;

/**
 * @version 创建时间：2017-11-15 下午2:24:43 项目：TvBlackAD-eclipse
 *          包名：com.tvblack.tv.http 文件名：TVBThreadPoolExecutor.java 作者：lhl 线程池管理
 *          说明:
 */

public class XhThreadPoolExecutor implements IRunnableManager {
	private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<Runnable>(
			128);
	private static final int CPU_COUNT = Runtime.getRuntime()
			.availableProcessors();
	private static final int CPRE_POOL_SIZE = CPU_COUNT + 1;
	private static final int MAXINUM_POOL_XIZE = (CPU_COUNT << 1) + 1;
	private ThreadPoolExecutor threadPoolExecutor;
	private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
	private static final long KEEP_ALIVE_TIME = 10 * Constants.SECOND;
	private boolean isShutdown = false;

	/**
	 * 
	 * 2017-11-15 下午2:37:42 lhl
	 */
	public XhThreadPoolExecutor() {
		// TODO Auto-generated constructor stub
		this(CPRE_POOL_SIZE);
	}

	/**
	 * 
	 * 2017-11-15 下午2:37:42 lhl
	 * 
	 * @param keepAliveTime
	 *            当线程数大于核心时，此为终止多余的空线程等待任务的最长时间
	 */
	public XhThreadPoolExecutor(long keepAliveTime) {
		// TODO Auto-generated constructor stub
		this(CPRE_POOL_SIZE, MAXINUM_POOL_XIZE, keepAliveTime);
	}

	/**
	 * 
	 * 2017-11-15 下午2:37:42 lhl
	 * 
	 * @param corePoolSize
	 *            池中所保存的线程数，包括空线程
	 */
	public XhThreadPoolExecutor(int corePoolSize) {
		// TODO Auto-generated constructor stub
		this(corePoolSize, MAXINUM_POOL_XIZE);
	}

	/**
	 * 
	 * 2017-11-15 下午2:37:42 lhl
	 * 
	 * @param corePoolSize
	 *            池中所保存的线程数，包括空线程
	 * @param keepAliveTime
	 *            当线程数大于核心时，此为终止多余的空线程等待任务的最长时间
	 */
	public XhThreadPoolExecutor(int corePoolSize, long keepAliveTime) {
		// TODO Auto-generated constructor stub
		this(corePoolSize, MAXINUM_POOL_XIZE, keepAliveTime);
	}

	/**
	 * 
	 * 2017-11-15 下午2:37:42 lhl
	 * 
	 * @param corePoolSize
	 *            池中所保存的线程数，包括空线程
	 * @param maximumPoolSize
	 *            池中允许的最大线程数
	 */
	public XhThreadPoolExecutor(int corePoolSize, int maximumPoolSize) {
		// TODO Auto-generated constructor stub
		this(corePoolSize, maximumPoolSize, KEEP_ALIVE_TIME);
	}

	/**
	 * 
	 * 2017-11-15 下午2:37:42 lhl
	 * 
	 * @param corePoolSize
	 *            池中所保存的线程数，包括空线程
	 * @param maximumPoolSize
	 *            池中允许的最大线程数
	 * @param keepAliveTime
	 *            当线程数大于核心时，此为终止多余的空线程等待任务的最长时间
	 */
	public XhThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime) {
		// TODO Auto-generated constructor stub
		this(corePoolSize, maximumPoolSize, keepAliveTime, WORK_QUEUE);
	}

	/**
	 * 
	 * 2017-11-15 下午2:37:42 lhl
	 * 
	 * @param corePoolSize
	 *            池中所保存的线程数，包括空线程
	 * @param maximumPoolSize
	 *            池中允许的最大线程数
	 * @param keepAliveTime
	 *            当线程数大于核心时，此为终止多余的空线程等待任务的最长时间
	 * @param unit
	 *            参数的时间单位
	 */
	public XhThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit) {
		// TODO Auto-generated constructor stub
		this(corePoolSize, maximumPoolSize, keepAliveTime, unit, WORK_QUEUE);
	}

	/**
	 * 
	 * 2017-11-15 下午2:37:42 lhl
	 * 
	 * @param corePoolSize
	 *            池中所保存的线程数，包括空线程
	 * @param maximumPoolSize
	 *            池中允许的最大线程数
	 * @param keepAliveTime
	 *            当线程数大于核心时，此为终止多余的空线程等待任务的最长时间
	 * @param workQueue
	 *            执行前用于保持任务的队列 此队列仅保持由execute方法提交的Runnable任务
	 */
	public XhThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, BlockingQueue<Runnable> workQueue) {
		// TODO Auto-generated constructor stub
		this(corePoolSize, maximumPoolSize, keepAliveTime,
				TimeUnit.MILLISECONDS, workQueue, new XhThreadFactory());
	}

	/**
	 * 
	 * 2017-11-15 下午2:37:42 lhl
	 * 
	 * @param corePoolSize
	 *            池中所保存的线程数，包括空线程
	 * @param maximumPoolSize
	 *            池中允许的最大线程数
	 * @param keepAliveTime
	 *            当线程数大于核心时，此为终止多余的空线程等待任务的最长时间
	 * @param unit
	 *            参数的时间单位
	 * @param workQueue
	 *            执行前用于保持任务的队列 此队列仅保持由execute方法提交的Runnable任务
	 */
	public XhThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		// TODO Auto-generated constructor stub
		this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
				new XhThreadFactory());
	}

	/**
	 * 
	 * 2017-11-15 下午2:37:42 lhl
	 * 
	 * @param corePoolSize
	 *            池中所保存的线程数，包括空线程
	 * @param maximumPoolSize
	 *            池中允许的最大线程数
	 * @param keepAliveTime
	 *            当线程数大于核心时，此为终止多余的空线程等待任务的最长时间
	 * @param unit
	 *            参数的时间单位
	 * @param workQueue
	 *            执行前用于保持任务的队列 此队列仅保持由execute方法提交的Runnable任务
	 * @param threadFactory
	 *            执行程序创建新线程时使用的工厂
	 */
	public XhThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
		// TODO Auto-generated constructor stub
		this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
				threadFactory, new XhRejectedExecutionHandler());
	}

	/**
	 * 
	 * 2017-11-15 下午2:37:42 lhl
	 * 
	 * @param corePoolSize
	 *            池中所保存的线程数，包括空线程
	 * @param maximumPoolSize
	 *            池中允许的最大线程数
	 * @param keepAliveTime
	 *            当线程数大于核心时，此为终止多余的空线程等待任务的最长时间
	 * @param unit
	 *            参数的时间单位
	 * @param workQueue
	 *            执行前用于保持任务的队列 此队列仅保持由execute方法提交的Runnable任务
	 * @param threadFactory
	 *            执行程序创建新线程时使用的工厂
	 * @param handler
	 *            由于超出线程范围和队列容量而使执行被阻塞时所使用的处理程序
	 */
	public XhThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory,
			RejectedExecutionHandler handler) {
		// TODO Auto-generated constructor stub
		threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,
				maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory,
				handler);
		scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(
				corePoolSize, threadFactory, handler);
	}

	@Override
	public void submit(Runnable command) {
		if (command != null && !isShutdown)
			threadPoolExecutor.execute(command);
	}

	@Override
	public void submit(Runnable command, long delay) {
		if (command != null && !isShutdown)
			scheduledThreadPoolExecutor.schedule(command, delay,
					TimeUnit.MILLISECONDS);
	}

	@Override
	public void submit(Runnable command, long initialDelay, long period) {
		if (command != null && !isShutdown)
			scheduledThreadPoolExecutor.scheduleAtFixedRate(command,
					initialDelay, period, TimeUnit.MILLISECONDS);
	}

	@Override
	public void submit(List<Runnable> commands) {
		if (commands != null && commands.size() > 0 && !isShutdown)
			for (Runnable command : commands) {
				submit(command);
			}
	}

	@Override
	public void remove(Runnable command) {
		if (!threadPoolExecutor.remove(command))
			scheduledThreadPoolExecutor.remove(command);
	}

	@Override
	public List<Runnable> shutdownNow() {
		isShutdown = true;
		List<Runnable> runnables = new ArrayList<Runnable>();
		List<Runnable> tpe = threadPoolExecutor.shutdownNow();
		if (tpe != null && tpe.size() > 0)
			runnables.addAll(tpe);
		List<Runnable> stpe = scheduledThreadPoolExecutor.shutdownNow();
		if (stpe != null && stpe.size() > 0)
			runnables.addAll(stpe);
		return runnables;
	}

	@Override
	public void shutdown() {
		isShutdown = true;
		if (!threadPoolExecutor.isShutdown())
			threadPoolExecutor.shutdown();
		if (!scheduledThreadPoolExecutor.isShutdown())
			scheduledThreadPoolExecutor.shutdown();
	}

	@Override
	public void remove(List<Runnable> commands) {
		// TODO Auto-generated method stub
		if (commands == null || commands.size() <= 0)
			return;
		for (int i = 0; i < commands.size(); i++) {
			remove(commands.get(i));
		}
	}
}
