package com.xh.adapterView;

import java.util.ArrayList;
import java.util.List;

import com.xh.animation.TranslateAnimation;
import com.xh.animation.XhAnimation;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

/**
 * @version 创建时间：2017-12-15 下午4:32:22 项目：repair 包名：com.xh.adapterView.adapter
 *          文件名：BaseAdapter.java 作者：lhl 说明:
 */

public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {
	private List<T> objects;

	public BaseAdapter(AdapterView adapterView) {
		// TODO Auto-generated constructor stub
		objects = new ArrayList<T>();
		adapterView.setAdapter(this);
	}

	public void addItem(T t) {
		if (t == null)
			return;
		objects.add(t);
		notifyDataSetChanged();
	}

	public void addItem(List<T> ts) {
		if (ts == null || ts.size() <= 0)
			return;
		objects.addAll(ts);
		notifyDataSetChanged();
	}

	public void remove(T t) {
		if (t == null)
			return;
		if (objects.remove(t))
			notifyDataSetChanged();
	}

	public void remove(List<T> ts) {
		if (ts == null || ts.size() <= 0)
			return;
		if (objects.removeAll(ts))
			notifyDataSetChanged();
	}

	public void clean() {
		objects.clear();
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return objects.size();
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		return super.getItemViewType(position);
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return super.getViewTypeCount();
	}

	@Override
	public T getItem(int arg0) {
		// TODO Auto-generated method stub
		return objects.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return getItem(arg0).hashCode();
	}

	@Override
	public View getView(int position, View converView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		int itemType = getItemViewType(position);
		if (converView == null)
			converView = getView(itemType);
		if (converView == null)
			return null;
		BaseTag<T> baseTag = (BaseTag<T>) converView.getTag();
		if (baseTag == null)
			baseTag = getViewHolder(itemType);
		baseTag.setView(converView);
		baseTag.setContext(objects.get(position));
		XhAnimation animation = getAnimation(position);
		if (animation != null)
			animation.start(converView);
		return converView;
	}

	public abstract BaseTag<T> getViewHolder(int itemType);

	public abstract View getView(int itemType);

	public XhAnimation getAnimation(int position) {
		TranslateAnimation animation = new TranslateAnimation();
		animation.setmFromXDelta(position % 2 == 0 ? -1000 : 1000);
		// animation.setmFromYDelta(-10000);
		return animation;
	}
}
