package com.xh.util;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.xh.ifaces.IFragment;
import com.xh.ifaces.IViewPagerFragment;

/**
 * @version ����ʱ�䣺2017-12-23 ����12:19:23 ��Ŀ��repair ������com.xh.util
 *          �ļ�����ViewPagerFragmentImpl.java ���ߣ�lhl ˵��:
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
	 * ��ǰ��������
	 * 
	 * @return
	 */
	public void setOffscreenPageLimit(int offscreenPageLimit) {
		if (viewPager != null)
			viewPager.setOffscreenPageLimit(offscreenPageLimit);// ����Ԥ����
	}

	/**
	 * �����Ƿ���Ի���
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
