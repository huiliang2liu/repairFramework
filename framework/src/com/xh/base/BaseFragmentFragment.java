package com.xh.base;

import java.util.List;

import android.app.Activity;
import android.app.Fragment;

import com.xh.ifaces.IFragment;
import com.xh.util.AndroidFragmentImpl;

/**
 * @version 创建时间：2017-12-23 下午12:44:38 项目：repair 包名：com.xh.base
 *          文件名：BaseFragment.java 作者：lhl 说明:
 */

public abstract class BaseFragmentFragment extends BaseFragment implements
		IFragment {
	private IFragment fragment;

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		fragment = new AndroidFragmentImpl(getChildFragmentManager(),
				getFragments(), groupId());
	}

	protected abstract List<? extends Fragment> getFragments();

	protected abstract int groupId();

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		fragment.onResume();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		fragment.onPause();
	}

	@Override
	public void setTable(int table) {
		// TODO Auto-generated method stub
		fragment.setTable(table);
	}

}
