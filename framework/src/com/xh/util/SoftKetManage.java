package com.xh.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;

public class SoftKetManage {
	/**
	 * ������ʾ�����أ�û����ʾ�򵯳�
	 * 
	 * @param context
	 */
	public static void hidden(Context context) {
		InputMethodManager imm = (InputMethodManager) context
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
	}

	/**
	 * ������Ƿ���ʾ xh 2017-3-8 ����12:57:37
	 * 
	 * @param activity
	 * @return
	 */
	public static boolean isSoftShowing(Activity activity) {
		// ��ȡ��ǰ��Ļ���ݵĸ߶�
		int screenHeight = activity.getWindow().getDecorView().getHeight();
		// ��ȡView�ɼ������bottom
		Rect rect = new Rect();
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);

		return screenHeight - rect.bottom != 0;
	}

	/**
	 * �ײ����ⰴ�����ĸ߶�
	 * 
	 * @return
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	public static int getSoftButtonsBarHeight(Activity activity) {
		DisplayMetrics metrics = new DisplayMetrics();
		// ���������ȡ���ܲ�����ʵ��Ļ�ĸ߶�
		activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int usableHeight = metrics.heightPixels;
		// ��ȡ��ǰ��Ļ����ʵ�߶�
		activity.getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
		int realHeight = metrics.heightPixels;
		if (realHeight > usableHeight) {
			return realHeight - usableHeight;
		} else {
			return 0;
		}
	}
}
