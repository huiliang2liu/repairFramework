package com.xh.repairapk;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

import com.xh.base.BasePluginActivity;

/**
 * @version ����ʱ�䣺2017-12-29 ����5:09:41 ��Ŀ��repairText ������com.xh.repairapk
 *          �ļ�����QppRActivity.java ���ߣ�lhl ˵��:
 */

public class QppRActivity extends BasePluginActivity {
	// @Override
	// protected String layoutName() {
	// // TODO Auto-generated method stub
	// return "near_god_baidumap";
	// }
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}

	@Override
	protected int layout() {
		// TODO Auto-generated method stub
		return 2130903091;
	}

	@Override
	protected int color() {
		// TODO Auto-generated method stub
		return Color.BLACK;
	}

	@Override
	protected String packageName() {
		// TODO Auto-generated method stub
		return "com.qpbox";
	}
}
