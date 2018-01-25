package com.xh.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * @version 创建时间：2017-12-15 上午10:10:17 项目：repairText 包名：com.xh.view
 *          文件名：ViewText.java 作者：lhl 说明:
 */

public class ViewText extends LinearLayout {
	private final static String TAG=ViewText.class.getName();
	private ViewDragHelper helper;
	private View mMenuView;
	private View mMainView;
	private int mWidth;
	private int marginLeft;

	public ViewText(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}

	public ViewText(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
	}

	@SuppressLint("NewApi")
	public ViewText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init();
	}

	@Override
	protected void onFinishInflate() {
		// TODO Auto-generated method stub
		super.onFinishInflate();
		mMainView = getChildAt(0);
		mMenuView = getChildAt(1);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		mWidth = mMenuView.getMeasuredWidth();

		marginLeft = ((MarginLayoutParams) mMenuView.getLayoutParams()).leftMargin;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		return helper.shouldInterceptTouchEvent(ev);
	}

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		helper.processTouchEvent(event);
		return true;
	}

	private void init() {
		// TODO Auto-generated method stub
		helper = ViewDragHelper.create(this, new ViewDragHelper.Callback() {

			@Override
			public boolean tryCaptureView(View arg0, int arg1) {
				// TODO Auto-generated method stub
				return mMenuView == arg0;
			}

			@SuppressLint("NewApi")
			@Override
			public void onViewPositionChanged(View changedView, int left,
					int top, int dx, int dy) {
				// TODO Auto-generated method stub
				mMainView.setAlpha(left * 1.0f / marginLeft);
				super.onViewPositionChanged(changedView, left, top, dx, dy);
			}

			@Override
			public int clampViewPositionVertical(View child, int top, int dy) {
				// TODO Auto-generated method stub
				return super.clampViewPositionVertical(child, top, dy);
			}

			@Override
			public int clampViewPositionHorizontal(View child, int left, int dx) {
				// TODO Auto-generated method stub
				return left;
			}

			@Override
			public void onViewReleased(View releasedChild, float xvel,
					float yvel) {
				// TODO Auto-generated method stub
				// super.onViewReleased(releasedChild, xvel, yvel);
				if (mMenuView.getLeft() < 500 || mMenuView.getRight() > 130) {
					if (mMenuView.getRight() < mWidth)
						helper.smoothSlideViewTo(mMenuView, -mWidth + 50, 0);
					else
						helper.smoothSlideViewTo(mMenuView, 0, 0);
					ViewCompat.postInvalidateOnAnimation(ViewText.this);
				} else {
					helper.smoothSlideViewTo(mMenuView, mWidth, 0);
					ViewCompat.postInvalidateOnAnimation(ViewText.this);
				}
			}

		});
	}

	@Override
	public void computeScroll() {
		// TODO Auto-generated method stub
		if (helper.continueSettling(true))
			ViewCompat.postInvalidateOnAnimation(this);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		if (mMenuView.getRight() < mWidth) {
			mMainView.setBackgroundColor(Color.alpha((int) (mMenuView
					.getRight() * 1.0f / mWidth * Integer.valueOf("ff", 16))));
		} else {
			mMainView
					.setBackgroundColor(Color.alpha(Integer.valueOf("ff", 16)));
		}
	}
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		Log.e(TAG, "view dispatchKeyEvent");
		return super.dispatchKeyEvent(event);
	}
}
