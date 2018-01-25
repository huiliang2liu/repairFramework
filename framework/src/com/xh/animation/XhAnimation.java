package com.xh.animation;

import android.view.View;
import android.view.animation.Animation;

/**
 * @version ����ʱ�䣺2017-11-16 ����5:59:00 ��Ŀ��TvBlackAD-eclipse
 *          ������com.tvblack.tv.animation �ļ�����TVBAnimation.java ���ߣ�lhl ˵��:����
 */

public class XhAnimation extends Animation {
	private boolean isFillAfter = true;
	private int time = 300;

	/**
	 * 
	 * lhl 2017-11-16 ����6:01:57 ˵������ʼ����
	 * 
	 * @param view
	 *            void
	 */
	public void start(View view) {
		if (view == null)
			return;
		this.setFillAfter(isFillAfter);
		this.setDuration(time);
		view.startAnimation(this);
	}

	public boolean isFillAfter() {
		return isFillAfter;
	}

	public void setFillAfter(boolean isFillAfter) {
		this.isFillAfter = isFillAfter;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		if (time <= 0)
			time = 700;
		this.time = time;
	}

}
