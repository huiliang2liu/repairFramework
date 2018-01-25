package com.xh.base;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import com.xh.animation.ViewEmbellish;
import com.xh.animation.XhObjectAnimator;
import com.xh.ifaces.IFatherView;
import com.xh.util.XhLog;

/**
 * @version 创建时间：2018-1-2 上午11:01:24 项目：repair 包名：com.xh.util
 *          文件名：FatherViewImpl.java 作者：lhl 说明:
 */

final class FatherViewImpl implements IFatherView {
	private final static String TAG = "FatherViewImpl";
	private ViewGroup viewGroup;
	// private XhObjectAnimator animatorW;
	// private XhObjectAnimator animatorH;
	private final static int TIME = 300;
	AnimatorSet set;

	public FatherViewImpl(ViewGroup viewGroup) {
		// TODO Auto-generated constructor stub
		this.viewGroup = viewGroup;
		set = new AnimatorSet();
	}

	@Override
	public void addView(View view) {
		// TODO Auto-generated method stub
		viewGroup.addView(view);
		addAnimation(view);
	}

	@Override
	public void addView(View view, LayoutParams layoutParams) {
		// TODO Auto-generated method stub
		viewGroup.addView(view, layoutParams);
		addAnimation(view);
	}

	@Override
	public void addView(View view, int left, int top, int right, int bottom) {
		// TODO Auto-generated method stub
		LayoutParams params = view.getLayoutParams();
		if (params == null)
			return;
		android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(
				params);
		layoutParams.setMargins(left, top, right, bottom);
		viewGroup.addView(view, layoutParams);
		addAnimation(view);
	}

	@Override
	public void addViewBottom(View view, View referenceView) {
		// TODO Auto-generated method stub
		LayoutParams params = view.getLayoutParams();
		if (params == null)
			return;
		android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(
				params);
		layoutParams.leftMargin = referenceView.getLeft();
		layoutParams.topMargin = referenceView.getBottom();
		viewGroup.addView(view, layoutParams);
		addAnimation(view);
	}

	@Override
	public void addViewTop(View view, View referenceView) {
		// TODO Auto-generated method stub
		LayoutParams params = view.getLayoutParams();
		if (params == null)
			return;
		android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(
				params);
		layoutParams.leftMargin = referenceView.getLeft();
		layoutParams.topMargin = referenceView.getTop() - layoutParams.height;
		viewGroup.addView(view, layoutParams);
		addAnimation(view);
	}

	@Override
	public void addViewRigth(View view, View referenceView) {
		// TODO Auto-generated method stub
		LayoutParams params = view.getLayoutParams();
		if (params == null)
			return;
		android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(
				params);
		layoutParams.leftMargin = referenceView.getRight();
		layoutParams.topMargin = referenceView.getTop();
		viewGroup.addView(view, layoutParams);
		addAnimation(view);
	}

	@Override
	public void addViewRigthBottom(View view, View referenceView) {
		// TODO Auto-generated method stub
		LayoutParams params = view.getLayoutParams();
		if (params == null)
			return;
		android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(
				params);
		layoutParams.leftMargin = referenceView.getRight() - params.width;
		layoutParams.topMargin = referenceView.getBottom();
		viewGroup.addView(view, layoutParams);
		addAnimation(view);
	}

	@Override
	public void addViewLeft(View view, View referenceView) {
		// TODO Auto-generated method stub
		LayoutParams params = view.getLayoutParams();
		if (params == null)
			return;
		android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(
				params);
		layoutParams.leftMargin = referenceView.getLeft() - layoutParams.width;
		layoutParams.topMargin = referenceView.getTop();
		viewGroup.addView(view, layoutParams);
		addAnimation(view);
	}

	@Override
	public void remove(View view) {
		// TODO Auto-generated method stub
		try {
			viewGroup.removeView(view);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		viewGroup.removeAllViews();
	}

	private void addAnimation(View view) {
		LayoutParams params = view.getLayoutParams();
		if (params == null)
			return;
		int width = params.width;
		ViewEmbellish embellish = new ViewEmbellish(view);
		ObjectAnimator animatorW = XhObjectAnimator.width(embellish, 0, width,
				TIME);
		ObjectAnimator animatorH = XhObjectAnimator.height(embellish, 0, width,
				TIME);
		ObjectAnimator animatorA = XhObjectAnimator
				.alpha(embellish, 0, 1, TIME);
		set.play(animatorH).with(animatorW).with(animatorA);
		set.setDuration(TIME);
		set.start();
	}

}
