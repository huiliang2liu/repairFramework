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
 * @version ����ʱ�䣺2017-11-15 ����2:24:43 ��Ŀ��TvBlackAD-eclipse
 *          ������com.tvblack.tv.http �ļ�����TVBThreadPoolExecutor.java ���ߣ�lhl �̳߳ع���
 *          ˵��:
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
	 * 2017-11-15 ����2:37:42 lhl
	 */
	public XhThreadPoolExecutor() {
		// TODO Auto-generated constructor stub
		this(CPRE_POOL_SIZE);
	}

	/**
	 * 
	 * 2017-11-15 ����2:37:42 lhl
	 * 
	 * @param keepAliveTime
	 *            ���߳������ں���ʱ����Ϊ��ֹ����Ŀ��̵߳ȴ�������ʱ��
	 */
	public XhThreadPoolExecutor(long keepAliveTime) {
		// TODO Auto-generated constructor stub
		this(CPRE_POOL_SIZE, MAXINUM_POOL_XIZE, keepAliveTime);
	}

	/**
	 * 
	 * 2017-11-15 ����2:37:42 lhl
	 * 
	 * @param corePoolSize
	 *            ������������߳������������߳�
	 */
	public XhThreadPoolExecutor(int corePoolSize) {
		// TODO Auto-generated constructor stub
		this(corePoolSize, MAXINUM_POOL_XIZE);
	}

	/**
	 * 
	 * 2017-11-15 ����2:37:42 lhl
	 * 
	 * @param corePoolSize
	 *            ������������߳������������߳�
	 * @param keepAliveTime
	 *            ���߳������ں���ʱ����Ϊ��ֹ����Ŀ��̵߳ȴ�������ʱ��
	 */
	public XhThreadPoolExecutor(int corePoolSize, long keepAliveTime) {
		// TODO Auto-generated constructor stub
		this(corePoolSize, MAXINUM_POOL_XIZE, keepAliveTime);
	}

	/**
	 * 
	 * 2017-11-15 ����2:37:42 lhl
	 * 
	 * @param corePoolSize
	 *            ������������߳������������߳�
	 * @param maximumPoolSize
	 *            �������������߳���
	 */
	public XhThreadPoolExecutor(int corePoolSize, int maximumPoolSize) {
		// TODO Auto-generated constructor stub
		this(corePoolSize, maximumPoolSize, KEEP_ALIVE_TIME);
	}

	/**
	 * 
	 * 2017-11-15 ����2:37:42 lhl
	 * 
	 * @param corePoolSize
	 *            ������������߳������������߳�
	 * @param maximumPoolSize
	 *            �������������߳���
	 * @param keepAliveTime
	 *            ���߳������ں���ʱ����Ϊ��ֹ����Ŀ��̵߳ȴ�������ʱ��
	 */
	public XhThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime) {
		// TODO Auto-generated constructor stub
		this(corePoolSize, maximumPoolSize, keepAliveTime, WORK_QUEUE);
	}

	/**
	 * 
	 * 2017-11-15 ����2:37:42 lhl
	 * 
	 * @param corePoolSize
	 *            ������������߳������������߳�
	 * @param maximumPoolSize
	 *            �������������߳���
	 * @param keepAliveTime
	 *            ���߳������ں���ʱ����Ϊ��ֹ����Ŀ��̵߳ȴ�������ʱ��
	 * @param unit
	 *            ������ʱ�䵥λ
	 */
	public XhThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit) {
		// TODO Auto-generated constructor stub
		this(corePoolSize, maximumPoolSize, keepAliveTime, unit, WORK_QUEUE);
	}

	/**
	 * 
	 * 2017-11-15 ����2:37:42 lhl
	 * 
	 * @param corePoolSize
	 *            ������������߳������������߳�
	 * @param maximumPoolSize
	 *            �������������߳���
	 * @param keepAliveTime
	 *            ���߳������ں���ʱ����Ϊ��ֹ����Ŀ��̵߳ȴ�������ʱ��
	 * @param workQueue
	 *            ִ��ǰ���ڱ�������Ķ��� �˶��н�������execute�����ύ��Runnable����
	 */
	public XhThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, BlockingQueue<Runnable> workQueue) {
		// TODO Auto-generated constructor stub
		this(corePoolSize, maximumPoolSize, keepAliveTime,
				TimeUnit.MILLISECONDS, workQueue, new XhThreadFactory());
	}

	/**
	 * 
	 * 2017-11-15 ����2:37:42 lhl
	 * 
	 * @param corePoolSize
	 *            ������������߳������������߳�
	 * @param maximumPoolSize
	 *            �������������߳���
	 * @param keepAliveTime
	 *            ���߳������ں���ʱ����Ϊ��ֹ����Ŀ��̵߳ȴ�������ʱ��
	 * @param unit
	 *            ������ʱ�䵥λ
	 * @param workQueue
	 *            ִ��ǰ���ڱ�������Ķ��� �˶��н�������execute�����ύ��Runnable����
	 */
	public XhThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		// TODO Auto-generated constructor stub
		this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
				new XhThreadFactory());
	}

	/**
	 * 
	 * 2017-11-15 ����2:37:42 lhl
	 * 
	 * @param corePoolSize
	 *            ������������߳������������߳�
	 * @param maximumPoolSize
	 *            �������������߳���
	 * @param keepAliveTime
	 *            ���߳������ں���ʱ����Ϊ��ֹ����Ŀ��̵߳ȴ�������ʱ��
	 * @param unit
	 *            ������ʱ�䵥λ
	 * @param workQueue
	 *            ִ��ǰ���ڱ�������Ķ��� �˶��н�������execute�����ύ��Runnable����
	 * @param threadFactory
	 *            ִ�г��򴴽����߳�ʱʹ�õĹ���
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
	 * 2017-11-15 ����2:37:42 lhl
	 * 
	 * @param corePoolSize
	 *            ������������߳������������߳�
	 * @param maximumPoolSize
	 *            �������������߳���
	 * @param keepAliveTime
	 *            ���߳������ں���ʱ����Ϊ��ֹ����Ŀ��̵߳ȴ�������ʱ��
	 * @param unit
	 *            ������ʱ�䵥λ
	 * @param workQueue
	 *            ִ��ǰ���ڱ�������Ķ��� �˶��н�������execute�����ύ��Runnable����
	 * @param threadFactory
	 *            ִ�г��򴴽����߳�ʱʹ�õĹ���
	 * @param handler
	 *            ���ڳ����̷߳�Χ�Ͷ���������ʹִ�б�����ʱ��ʹ�õĴ������
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
