package com.xh.ifaces;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

/**
 * @version 创建时间：2018-1-2 上午10:54:35 项目：repair 包名：com.xh.ifaces
 *          文件名：IFatherView.java 作者：lhl 说明:
 */

public interface IFatherView {
	/**
	 * 
	 * lhl 2018-1-2 上午10:55:02 说明：添加view
	 * 
	 * @param view
	 *            void
	 */
	void addView(View view);

	/**
	 * 
	 * lhl 2018-1-2 上午10:55:25 说明：添加view
	 * 
	 * @param view
	 * @param layoutParams
	 *            void
	 */
	void addView(View view, LayoutParams layoutParams);

	/**
	 * 
	 * lhl 2018-1-2 上午10:57:57 说明：添加view
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
	 * lhl 2018-1-2 上午10:59:03 说明：添加到指定布局的底部
	 * 
	 * @param view
	 * @param referenceView
	 *            void
	 */
	void addViewBottom(View view, View referenceView);

	/**
	 * 
	 * lhl 2018-1-2 上午10:59:30 说明：添加到指定布局的顶部
	 * 
	 * @param view
	 * @param referenceView
	 *            void
	 */
	void addViewTop(View view, View referenceView);

	/**
	 * 
	 * lhl 2018-1-2 上午10:59:48 说明：添加到指定布局的右边
	 * 
	 * @param view
	 * @param referenceView
	 *            void
	 */
	void addViewRigth(View view, View referenceView);

	/**
	 * 
	 * lhl 2018-1-2 下午12:02:43 说明：添加到指定布局的右下角
	 * 
	 * @param view
	 * @param referenceView
	 *            void
	 */
	void addViewRigthBottom(View view, View referenceView);

	/**
	 * 
	 * lhl 2018-1-2 上午11:00:03 说明：添加到指定布局的左边
	 * 
	 * @param view
	 * @param referenceView
	 *            void
	 */
	void addViewLeft(View view, View referenceView);

	/**
	 * 
	 * lhl 2018-1-2 上午11:17:19 说明：移除控件
	 * 
	 * @param view
	 *            void
	 */
	void remove(View view);

	/**
	 * 
	 * lhl 2018-1-2 上午11:17:43 说明：清空 void
	 */
	void clean();
}
