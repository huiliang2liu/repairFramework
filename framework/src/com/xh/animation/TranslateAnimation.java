package com.xh.animation;

import android.view.animation.Transformation;

/**
 * @version 创建时间：2017-11-16 下午6:09:50 项目：TvBlackAD-eclipse
 *          包名：com.tvblack.tv.animation 文件名：TVBTranslateAnimation.java 作者：lhl
 *          说明:位置变化动画
 */

public class TranslateAnimation extends XhAnimation {
	private float mFromXDelta = 0;
	private float mToXDelta = 0;
	private float mFromYDelta = 0;
	private float mToYDelta = 0;

	public float getmFromXDelta() {
		return mFromXDelta;
	}

	public void setmFromXDelta(float mFromXDelta) {
		this.mFromXDelta = mFromXDelta;
	}

	public float getmToXDelta() {
		return mToXDelta;
	}

	public void setmToXDelta(float mToXDelta) {
		this.mToXDelta = mToXDelta;
	}

	public float getmFromYDelta() {
		return mFromYDelta;
	}

	public void setmFromYDelta(float mFromYDelta) {
		this.mFromYDelta = mFromYDelta;
	}

	public float getmToYDelta() {
		return mToYDelta;
	}

	public void setmToYDelta(float mToYDelta) {
		this.mToYDelta = mToYDelta;
	}

	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		// TODO Auto-generated method stub
		float dx = mFromXDelta;
		float dy = mFromYDelta;
		if (mFromXDelta != mToXDelta)
			dx = mFromXDelta + (mToXDelta - mFromXDelta) * interpolatedTime;
		if (mFromYDelta != mToYDelta)
			dy = mFromYDelta + (mToYDelta - mFromYDelta) * interpolatedTime;
		t.getMatrix().setTranslate(dx, dy);
	}
}
