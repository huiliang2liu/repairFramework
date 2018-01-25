package com.xh.base;

import java.util.List;

import android.app.Fragment;
import android.os.Bundle;

import com.xh.base.BasePluginActivity;
import com.xh.ifaces.IFragment;
import com.xh.util.AndroidFragmentImpl;

/**
 * @version 创建时间：2017-12-23 下午4:25:14 项目：repair 包名：com.xh.base
 *          文件名：BasePluginFragmentActivity.java 作者：lhl 说明:
 */

public abstract class BasePluginFragmentActivity extends BasePluginActivity
		implements IFragment {
	private IFragment iFragment;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		iFragment = new AndroidFragmentImpl(getFragmentManager(), fragments(),
				groupId());
	}

	protected abstract int groupId();

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
	public void setTable(int table) {
		// TODO Auto-generated method stub
		iFragment.setTable(table);
	}

}
