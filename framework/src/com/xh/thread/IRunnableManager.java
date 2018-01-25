package com.xh.thread;

import java.util.List;

/**
 * @version ����ʱ�䣺2017-12-20 ����2:41:34
 * ��Ŀ��repair
 * ������com.xh.ifaces
 * �ļ�����IRunnableManager.java
 * ���ߣ�lhl
 * ˵��:
 */

public interface IRunnableManager {
	/**
	 * 
	 * lhl 2017-11-15 ����2:58:41 ˵�����ύ����
	 * 
	 * @param command
	 *            ���� void
	 */
	public void submit(Runnable command);

	/**
	 * 
	 * lhl 2017-11-15 ����3:01:37 ˵�����ӳ��ύ����
	 * 
	 * @param command
	 *            ����
	 * @param delay
	 *            �ӳ�ʱ�䵥λΪ���� void
	 */
	public void submit(Runnable command, long delay);

	/**
	 * 
	 * lhl 2017-11-15 ����3:03:45 ˵�����ӳ�������ִ������
	 * 
	 * @param command
	 *            ����
	 * @param initialDelay
	 *            �ӳ�ʱ��
	 * @param period
	 *            ���� void
	 */
	public void submit(Runnable command, long initialDelay, long period);

	/**
	 * 
	 * lhl 2017-11-15 ����3:07:17 ˵�����ύ����
	 * 
	 * @param commands
	 *            �����б� void
	 */
	public void submit(List<Runnable> commands);

	/**
	 * �Ƴ����� lhl 2017-11-15 ����3:08:42 ˵����
	 * 
	 * @param command
	 *            void
	 */
	public void remove(Runnable command);
	/**
	 * 
	 * lhl
	 * 2017-12-20 ����2:51:36
	 * ˵�����Ƴ�����
	 * @param commands void
	 */
	public void remove(List<Runnable> commands);

	/**
	 * 
	 * lhl 2017-11-15 ����3:12:04 ˵����ִֹͣ�����������ִ�е�����
	 * 
	 * @return List<Runnable> ��ֹͣ������
	 */
	public List<Runnable> shutdownNow();

	/**
	 * 
	 * lhl 2017-11-15 ����3:14:14 ˵����ִֹͣ����������ִ�еĲ��ᱻֹͣ��ֻ�ǲ��������� void
	 */
	public void shutdown();
}
