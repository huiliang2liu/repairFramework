package com.xh.base;

import java.lang.reflect.Method;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.xh.annotation.ViewAnnotationParse;
import com.xh.http.IHttpManager;
import com.xh.ifaces.IObjectDBHelper;
import com.xh.ifaces.IOkHttpManager;
import com.xh.ifaces.ISVGParser;
import com.xh.ifaces.IViewAnnotation;
import com.xh.image.IImageManager;
import com.xh.thread.IRunnableManager;
import com.xh.util.ViewAnnotationImpl;
import com.xh.util.XhPhoneInformation;

/**
 * @version 创建时间：2017-12-23 下午12:44:38 项目：repair 包名：com.xh.base
 *          文件名：BaseFragment.java 作者：lhl 说明:
 */

public class BaseFragment extends Fragment implements IViewAnnotation,
		OnClickListener {
	protected ViewAnnotationImpl viewAnnotationImpl;
	protected View view;
	protected XhBaseActivity baseActivity;
	protected IObjectDBHelper db;
	protected IRunnableManager manager;
	protected IHttpManager httpManager;
	protected IImageManager imageManager;
	protected XhPhoneInformation information;
	protected ISVGParser vectorParas;
	protected ISVGParser svgParser;
	protected IOkHttpManager okHttpManager;


	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		baseActivity = (XhBaseActivity) activity;
		this.db = baseActivity.db;
		this.manager = baseActivity.manager;
		this.httpManager = baseActivity.httpManager;
		this.imageManager = baseActivity.imageManager;
		information=baseActivity.information;
		vectorParas=baseActivity.vectorParas;
		svgParser=baseActivity.svgParser;
		okHttpManager=baseActivity.okHttpManager;
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if (view == null) {
			int resource = layoutId();
			if (resource <= 0) {
				String layoutName = layoutName();
				view = baseActivity.load.getView(layoutName, baseActivity);
			} else
				view = baseActivity.load.getView(resource, baseActivity);
		} else {
			ViewGroup viewGroup = (ViewGroup) view.getParent();
			if (viewGroup != null)
				viewGroup.removeView(view);
		}
		viewAnnotationImpl = new ViewAnnotationImpl(view, this);
		ViewAnnotationParse.parse(this, receiver());
		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View id2View(int viewId) {
		// TODO Auto-generated method stub
		return viewAnnotationImpl.id2View(viewId);
	}

	@Override
	public void bindClickMethod(View view, Method method) {
		// TODO Auto-generated method stub
		viewAnnotationImpl.bindClickMethod(view, method);
	}

	@Override
	public Object invoke(View view, Object receiver) {
		// TODO Auto-generated method stub
		return viewAnnotationImpl.invoke(view, receiver);
	}

	@Override
	public OnClickListener getOnClickListener() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		invoke(view, receiver());

	}

	protected Object receiver() {
		return this;
	}

	public String layoutName() {
		// TODO Auto-generated method stub
		return null;
	}

	public int layoutId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void startActivity(Intent intent, Bundle options) {
		// TODO Auto-generated method stub
		baseActivity.startActivity(intent, options);
	}

	@Override
	public void startActivity(Intent intent) {
		// TODO Auto-generated method stub
		baseActivity.startActivity(intent);
	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode,
			Bundle options) {
		// TODO Auto-generated method stub
		baseActivity.startActivityForResult(intent, requestCode, options);
	}
}
