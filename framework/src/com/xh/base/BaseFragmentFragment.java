package com.xh.base;

import java.util.List;

import android.app.Activity;
import android.app.Fragment;

import com.xh.ifaces.IFragment;
import com.xh.util.AndroidFragmentImpl;

/**
 * @version ����ʱ�䣺2017-12-23 ����12:44:38 ��Ŀ��repair ������com.xh.base
 *          �ļ�����BaseFragment.java ���ߣ�lhl ˵��:
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
