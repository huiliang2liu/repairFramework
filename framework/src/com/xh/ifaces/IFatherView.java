package com.xh.ifaces;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

/**
 * @version ����ʱ�䣺2018-1-2 ����10:54:35 ��Ŀ��repair ������com.xh.ifaces
 *          �ļ�����IFatherView.java ���ߣ�lhl ˵��:
 */

public interface IFatherView {
	/**
	 * 
	 * lhl 2018-1-2 ����10:55:02 ˵�������view
	 * 
	 * @param view
	 *            void
	 */
	void addView(View view);

	/**
	 * 
	 * lhl 2018-1-2 ����10:55:25 ˵�������view
	 * 
	 * @param view
	 * @param layoutParams
	 *            void
	 */
	void addView(View view, LayoutParams layoutParams);

	/**
	 * 
	 * lhl 2018-1-2 ����10:57:57 ˵�������view
	 * 
	 * @param view
	 * @param left
	 * @param top
	 * @param right
	 * @param bottom
	 *            void
	 */
	void addView(View view, int left, int top, int right, int bottom);

	/**
	 * 
	 * lhl 2018-1-2 ����10:59:03 ˵������ӵ�ָ�����ֵĵײ�
	 * 
	 * @param view
	 * @param referenceView
	 *            void
	 */
	void addViewBottom(View view, View referenceView);

	/**
	 * 
	 * lhl 2018-1-2 ����10:59:30 ˵������ӵ�ָ�����ֵĶ���
	 * 
	 * @param view
	 * @param referenceView
	 *            void
	 */
	void addViewTop(View view, View referenceView);

	/**
	 * 
	 * lhl 2018-1-2 ����10:59:48 ˵������ӵ�ָ�����ֵ��ұ�
	 * 
	 * @param view
	 * @param referenceView
	 *            void
	 */
	void addViewRigth(View view, View referenceView);

	/**
	 * 
	 * lhl 2018-1-2 ����12:02:43 ˵������ӵ�ָ�����ֵ����½�
	 * 
	 * @param view
	 * @param referenceView
	 *            void
	 */
	void addViewRigthBottom(View view, View referenceView);

	/**
	 * 
	 * lhl 2018-1-2 ����11:00:03 ˵������ӵ�ָ�����ֵ����
	 * 
	 * @param view
	 * @param referenceView
	 *            void
	 */
	void addViewLeft(View view, View referenceView);

	/**
	 * 
	 * lhl 2018-1-2 ����11:17:19 ˵�����Ƴ��ؼ�
	 * 
	 * @param view
	 *            void
	 */
	void remove(View view);

	/**
	 * 
	 * lhl 2018-1-2 ����11:17:43 ˵������� void
	 */
	void clean();
}
