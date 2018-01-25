package com.xh.repairtest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.xh.base.BasePluginActivity;

public class MainActivity1 extends BasePluginActivity implements
		OnClickListener {
	private final static String TAG = MainActivity1.class.getName();


	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView("test2");
		findViewById(R.id.tiaozhuan).setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		startActivity(new Intent(getActivity(), MainActivity2.class));
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
