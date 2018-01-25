package com.xh.repairtest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.xh.annotation.ViewAnnotation;
import com.xh.base.BasePluginActivity;

public class MainActivity extends BasePluginActivity implements OnClickListener {
	private final static String TAG = MainActivity.class.getName();
	@ViewAnnotation(id = R.id.tiaozhuan)
	TextView textView;

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		return super.dispatchKeyEvent(event);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setTheme(android.R.style.Theme_Light_NoTitleBar);
		super.onCreate(savedInstanceState);
		try {
			textView.setText(stringValue(2131230720,
					package2resources("com.qpbox")));
			textView.setTextColor(colorValue(2131099651,
					package2resources("com.qpbox")));
			textView.setOnClickListener(this);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Log.e(TAG, "onCreate");
	}

	@Override
	protected String layoutName() {
		// TODO Auto-generated method stub
		return "test1";
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		startActivity(new Intent(getActivity(), MainActivity1.class));
	}

	@Override
	public void onStart() {
		Log.e(TAG, "onStart");
	}

	@Override
	public void onRestart() {
		Log.e(TAG, "onRestart");
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.e(TAG, "onActivityResult");
	}

	@Override
	public void onResume() {
		Log.e(TAG, "onResume");
	}

	@Override
	public void onPause() {
		Log.e(TAG, "onPause");
	}

	@Override
	public void onStop() {
		Log.e(TAG, "onStop");
	}

	@Override
	public void onDestroy() {
		Log.e(TAG, "onDestroy");
	}

	@Override
	protected String packageName() {
		// TODO Auto-generated method stub
		return "com.xh.repairtest";
	}

}
