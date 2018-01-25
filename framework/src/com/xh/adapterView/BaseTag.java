package com.xh.adapterView;

import java.lang.reflect.Method;

import android.view.View;
import android.view.View.OnClickListener;

import com.xh.annotation.ViewAnnotationParse;
import com.xh.ifaces.IViewAnnotation;
import com.xh.util.ViewAnnotationImpl;

/**
 * @version 创建时间：2017-12-15 下午4:32:36 项目：repair 包名：com.xh.adapterView.adapter
 *          文件名：BaseTag.java 作者：lhl 说明:
 */

public abstract class BaseTag<T> implements IViewAnnotation, OnClickListener {
	private Object receiver;
	private View view;
	private IViewAnnotation iViewAnnotation;

	public void setView(View view) {
		// TODO Auto-generated constructor stub
		this.view = view;
		receiver = receiver();
		if (receiver == null)
			receiver = this;
		iViewAnnotation = new ViewAnnotationImpl(view, this);
		ViewAnnotationParse.parse(this, receiver);
	}

	protected Object receiver() {
		return null;
	}

	@Override
	public View id2View(int viewId) {
		// TODO Auto-generated method stub
		return iViewAnnotation.id2View(viewId);
	}

	@Override
	public void bindClickMethod(View view, Method method) {
		// TODO Auto-generated method stub
		iViewAnnotation.bindClickMethod(view, method);
	}

	@Override
	public Object invoke(View view, Object receiver) {
		// TODO Auto-generated method stub
		return iViewAnnotation.invoke(view, receiver);
	}

	public Object invoke(View view) {
		// TODO Auto-generated method stub
		return invoke(view, receiver);
	}

	@Override
	public OnClickListener getOnClickListener() {
		// TODO Auto-generated method stub
		return iViewAnnotation.getOnClickListener();
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		invoke(arg0);
	}

	public abstract void setContext(T t);
}
