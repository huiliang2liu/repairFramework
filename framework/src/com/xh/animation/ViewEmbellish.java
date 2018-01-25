package com.xh.animation;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

/**
 * @version 创建时间：2017-12-18 上午11:00:22 项目：repair 包名：com.xh.animation
 *          文件名：ViewEmbellish.java 作者：lhl 说明:
 */

public class ViewEmbellish {
	private View view;
	private LayoutParams params;

	public ViewEmbellish(View view) {
		// TODO Auto-generated constructor stub
		if (view == null)
			throw new RuntimeException("you view is null");
		this.view = view;
		params = view.getLayoutParams();
		if (params == null)
			throw new RuntimeException("this view no params");
	}

	public int getWidth() {
		return view.getWidth();
	}

	public void setWidth(int width) {
		params.width = width;
		view.requestLayout();
	}

	public int getHeight() {
		return view.getHeight();
	}

	public void setHeight(int height) {
		params.height = height;
		view.requestLayout();
	}

	public float getX() {
		return view.getX();
	}

	public void setX(float x) {
		view.setX(x);
	}

	public float getY() {
		return view.getY();
	}

	public void setY(float y) {
		view.setY(y);
	}

	public float getAlpha() {
		return view.getAlpha();
	}

	public void setAlpha(float alpha) {
		view.setAlpha(alpha);
	}

	public float getTranslationY() {
		return view.getTranslationY();
	}

	public void setTranslationY(float translationY) {
		view.setTranslationY(translationY);
	}

	public float getTranslationX() {
		return view.getTranslationX();
	}

	public void setTranslationX(float translationX) {
		view.setTranslationX(translationX);
	}

	public float getScaleX() {
		return view.getScaleX();
	}

	public void setScaleX(float scaleX) {
		view.setScaleX(scaleX);
	}

	public float getScaleY() {
		return view.getScaleY();
	}

	public void setScaleY(float scaleY) {
		view.setScaleY(scaleY);
	}

	public void setBackgroundColor(int color) {
		System.out.println(color);
		view.setBackgroundColor(color);
	}

	public float getRotationX() {
		return view.getRotationX();
	}

	public void setRotationX(float rotationX) {
		view.setRotationX(rotationX);
	}

	public float getRotationY() {
		return view.getRotationY();
	}

	public void setRotationY(float rotationY) {
		view.setRotationY(rotationY);
	}

	public float getRotation() {
		return view.getRotation();
	}

	public void setRotation(float rotation) {
		view.setRotation(rotation);
	}
}
