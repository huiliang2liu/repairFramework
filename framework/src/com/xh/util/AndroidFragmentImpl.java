package com.xh.util;

import java.util.List;

import com.xh.ifaces.IFragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * @version 创建时间：2017-12-23 下午12:02:50 项目：repair 包名：com.xh.ifaces
 *          文件名：AndroidFragmentImpl.java 作者：lhl 说明:
 */

public final class AndroidFragmentImpl implements IFragment {
	private FragmentManager fragmentManager;
	private int table = 0;
	private List<?extends Fragment> fragments;

	public AndroidFragmentImpl(FragmentManager fragmentManager,List<? extends Fragment> fragments,int groupId) {
		// TODO Auto-generated constructor stub
		this.fragmentManager = fragmentManager;
		this.fragments = fragments;
		if (fragments != null) {
			FragmentTransaction transaction = fragmentManager
					.beginTransaction();
			for (Fragment baseAndroidFragment : fragments) {
				transaction.add(groupId, baseAndroidFragment);
			}
			transaction.commit();
		}
	}

	@Override
	public void setTable(int table) {
		// TODO Auto-generated method stub
		if (fragments == null || fragments.size() == 0)
			return;
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		if (table >0) {
			Fragment baseFragmentTab = fragments.get(table);
			transaction.hide(baseFragmentTab);
			baseFragmentTab.onPause();
		}
		if (fragments.size() > table) {
			this.table = table;
			Fragment baseFragmentTab = fragments.get(table);
			transaction.show(baseFragmentTab);
			if (isSave())
				transaction.addToBackStack(null);
			transaction.commit();
			baseFragmentTab.onResume();
		}
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		setTable(table);
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		if (table != -1) {
			Fragment baseFragmentTab = fragments.get(table);
			transaction.hide(baseFragmentTab);
			baseFragmentTab.onPause();
			transaction.commit();
		}
	}

	protected boolean isSave() {
		// TODO Auto-generated method stub
		return false;
	}
}
