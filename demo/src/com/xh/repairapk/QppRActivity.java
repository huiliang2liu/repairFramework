package com.xh.repairapk;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

import com.xh.base.BasePluginActivity;

/**
 * @version 创建时间：2017-12-29 下午5:09:41 项目：repairText 包名：com.xh.repairapk
 *          文件名：QppRActivity.java 作者：lhl 说明:
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
