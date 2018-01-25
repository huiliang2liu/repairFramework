package com.xh.util;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.xh.ifaces.IFragment;
import com.xh.ifaces.IViewPagerFragment;

/**
 * @version 创建时间：2017-12-23 下午12:19:23 项目：repair 包名：com.xh.util
 *          文件名：ViewPagerFragmentImpl.java 作者：lhl 说明:
 */

public final class ViewPagerFragmentImpl implements IFragment,
		OnPageChangeListener {
	private List<? extends Fragment> fragments;
	private ViewPager viewPager;
	private int table = 0;
	private IViewPagerFragment viewPagerFragment;

	public ViewPagerFragmentImpl(List<? extends Fragment> fragments,
			ViewPager viewPager, FragmentPagerAdapter adapter) {
		this(fragments, viewPager, adapter, null);
	}

	public ViewPagerFragmentImpl(List<? extends Fragment> fragments,
			ViewPager viewPager, FragmentPagerAdapter adapter,
			IViewPagerFragment viewPagerFragment) {
		// TODO Auto-generated constructor stub
		this.fragments = fragments;
		this.viewPager = viewPager;
		this.viewPagerFragment = viewPagerFragment;
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(this);
		if (viewPager instanceof com.xh.view.ViewPager) {
			com.xh.view.ViewPager v = (com.xh.view.ViewPager) viewPager;
			v.setScanScroll(!isTable());
		}
		viewPager.setCurrentItem(table);
	}

	@Override
	public void setTable(int table) {
		// TODO Auto-generated method stub
		this.table = table;
		viewPager.setCurrentItem(table);
	}

	/**
	 * 提前加载数量
	 * 
	 * @return
	 */
	public void setOffscreenPageLimit(int offscreenPageLimit) {
		if (viewPager != null)
			viewPager.setOffscreenPageLimit(offscreenPageLimit);// 设置预加载
	}

	/**
	 * 设置是否可以滑动
	 * 
	 * @return
	 */
	public boolean isTable() {
		return false;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		if (fragments == null)
			return;
		viewPager.setCurrentItem(table);
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		if (fragments == null)
			return;
		fragments.get(table).onPause();
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		if (fragments == null)
			return;
		fragments.get(table).onPause();
		int odlTable = table;
		table = arg0;
		fragments.get(table).onResume();
		if (viewPagerFragment != null)
			viewPagerFragment.setbutt(odlTable, table);
	}

}
