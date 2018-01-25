package com.xh.base;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.xh.adapterView.FragmentAdapter;
import com.xh.base.BasePluginActivity;
import com.xh.ifaces.IFragment;
import com.xh.ifaces.IViewPagerFragment;
import com.xh.util.ViewPagerFragmentImpl;

/**
 * @version 创建时间：2017-12-23 下午4:28:14 项目：repair 包名：com.xh.base
 *          文件名：BasePluginV4Activity.java 作者：lhl 说明:
 */

public abstract class BasePluginV4Activity extends BasePluginActivity implements
		IFragment, IViewPagerFragment {
	private IFragment iFragment;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		iFragment = new ViewPagerFragmentImpl(fragments(), viewPager(),
				adapter(), this);
	}

	protected FragmentPagerAdapter adapter() {
		return new FragmentAdapter(getSupportFragmentManager(), fragments());
	}

	protected abstract ViewPager viewPager();

	protected abstract List<? extends Fragment> fragments();

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		iFragment.onResume();
		super.onResume();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		iFragment.onPause();
		super.onPause();
	}

	@Override
	public void setbutt(int odleTable, int newTable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTable(int table) {
		// TODO Auto-generated method stub
		iFragment.setTable(table);
	}

}
