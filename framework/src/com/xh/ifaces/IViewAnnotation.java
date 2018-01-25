package com.xh.ifaces;

import java.lang.reflect.Method;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * @version ����ʱ�䣺2017-12-15 ����3:46:07 ��Ŀ��repair ������com.xh.ifaces
 *          �ļ�����IViewAnnotation.java ���ߣ�lhl ˵��:
 */

public interface IViewAnnotation {
	View id2View(int viewId);

	void bindClickMethod(View view, Method method);

	Object invoke(View view, Object receiver);

	OnClickListener getOnClickListener();
}
