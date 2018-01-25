package com.xh.adapterView;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * @version 创建时间：2017-12-23 下午3:56:30 项目：repair 包名：com.xh.adapterView
 *          文件名：FragmentAdapter.java 作者：lhl 说明:
 */

public class FragmentAdapter extends FragmentPagerAdapter {
	private List<?extends Fragment> fragments;

	public FragmentAdapter(FragmentManager fm, List<?extends Fragment> fragments2) {
		// TODO Auto-generated constructor stub
		super(fm);
		this.fragments = fragments2;
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return fragments.get(arg0);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return fragments == null ? 0 : fragments.size();
	}

}
