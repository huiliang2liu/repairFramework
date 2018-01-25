package com.xh.base;

import java.util.List;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.xh.adapterView.FragmentAdapter;
import com.xh.ifaces.IFragment;
import com.xh.ifaces.IViewPagerFragment;
import com.xh.util.ViewPagerFragmentImpl;

/**
 * @version ����ʱ�䣺2017-12-23 ����12:44:38 ��Ŀ��repair ������com.xh.base
 *          �ļ�����BaseFragment.java ���ߣ�lhl ˵��:
 */

public abstract class BaseFragmentV4 extends BaseFragment implements
		IViewPagerFragment, IFragment {
	private IFragment fragment;

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		fragment = new ViewPagerFragmentImpl(getFragments(), viewPager(),
				adapter(), this);
	}

	protected abstract List<? extends Fragment> getFragments();

	protected abstract ViewPager viewPager();

	protected FragmentPagerAdapter adapter() {
		return new FragmentAdapter(baseActivity.getSupportFragmentManager(),
				getFragments());
	}

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
	public void setbutt(int odleTable, int newTable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTable(int table) {
		// TODO Auto-generated method stub
		fragment.setTable(table);
	}

}
