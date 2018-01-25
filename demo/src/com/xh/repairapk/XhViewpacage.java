package com.xh.repairapk;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xh.annotation.ViewAnnotation;
import com.xh.base.BasePluginV4Activity;
import com.xh.base.BaseV4Fragment;
import com.xh.http.XhHttpLoadListenString;
import com.xh.util.XhLog;

/**
 * @version 创建时间：2017-12-23 下午5:52:31 项目：repairText 包名：com.xh.repairapk
 *          文件名：XhViewpacage.java 作者：lhl 说明:
 */

public class XhViewpacage extends BasePluginV4Activity {
	int color1 = Color.argb(0xff, 0xdd, 0x53, 0x47);
	int color2 = Color.argb(0xff, 0x1e, 0xa1, 0x61);
	@ViewAnnotation(id = R.id.view_pager)
	ViewPager view_pager;
	@ViewAnnotation(id = R.id.text_view1, clickMethodName = "textView1")
	TextView text_view1;

	@ViewAnnotation(id = R.id.text_view2)
	TextView text_view2;

	@ViewAnnotation(id = R.id.text_view3)
	TextView text_view3;
	@ViewAnnotation(id = R.id.text_view4)
	TextView text_view4;

	@Override
	protected String layoutName() {
		// TODO Auto-generated method stub
		return "view_page";
	}

	@Override
	protected ViewPager viewPager() {
		// TODO Auto-generated method stub
		return view_pager;
	}

	@Override
	public void setbutt(int odleTable, int newTable) {
		// TODO Auto-generated method stub
		TextView old = view(odleTable);
		TextView newd = view(newTable);
		old.setTextColor(color2);
		newd.setTextColor(color1);
		super.setbutt(odleTable, newTable);
	}

	private TextView view(int id) {
		switch (id) {
		case 0:
			return text_view1;

		case 1:
			return text_view2;
		case 2:
			return text_view3;
		case 3:
			return text_view4;
		}
		return null;
	}

	@Override
	protected List<? extends Fragment> fragments() {
		// TODO Auto-generated method stub
		List<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(new MyFragment().setColor(Color.RED));
		fragments.add(new MyFragment().setColor(Color.WHITE));
		fragments.add(new MyFragment().setColor(Color.YELLOW));
		fragments.add(new MyFragment().setColor(Color.GREEN));
		return fragments;
	}

	private class MyFragment extends BaseV4Fragment {
		private int color = Color.RED;

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreateView(inflater, container, savedInstanceState);
			view.setBackgroundColor(color);
			return view;
		}

		@Override
		public String layoutName() {
			// TODO Auto-generated method stub
			return "activity12";
		}

		protected MyFragment setColor(int color) {
			this.color = color;
			return this;
		}
	}

	private void textView1() {
		httpManager.string("http://bbs.csdn.net/topics/390337449?page=1",
				new XhHttpLoadListenString() {

					@Override
					public void starting() {
						// TODO Auto-generated method stub
						XhLog.e("starting");
					}

					@Override
					public void loadDeafalt(String deafalt) {
						// TODO Auto-generated method stub
						XhLog.e(deafalt);
					}

					@Override
					public void loaded(String string) {
						// TODO Auto-generated method stub
						XhLog.e(string);
					}
				});
	}
}
