package com.xh.repairtest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.xh.base.BasePluginActivity;

public class MainActivity2 extends BasePluginActivity {
	private final static String TAG = MainActivity2.class.getName();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView("test3");
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
}
