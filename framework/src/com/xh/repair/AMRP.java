package com.xh.repair;

import com.xh.base.BaseApplication;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.widget.Toast;

/**
 * @version ����ʱ�䣺2017-12-14 ����11:14:35 ��Ŀ��repair ������com.xh.util �ļ�����AMRP.java
 *          ���ߣ�lhl ˵��:
 */

public class AMRP {
	public AMRP(PackageInfo packageInfo, AssetManager assetManager,
			Resources resources) {
		// TODO Auto-generated constructor stub
		if (packageInfo != null)
			packageName = packageInfo.packageName;
		this.assetManager = assetManager;
		this.resources = resources;
		this.packageInfo = packageInfo;
		mTheme = resources.newTheme();
		// Finals���������Լ����ּ���XML�����쳣BUG
		try {
			mTheme.applyStyle(packageInfo.applicationInfo.theme, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AMRP() {
		// TODO Auto-generated constructor stub
	}

	public Theme mTheme;
	public PackageInfo packageInfo;
	public String packageName = "";
	public AssetManager assetManager;
	public Resources resources;

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if (o == null || !o.getClass().getName().equals(AMRP.class.getName()))
			return false;
		AMRP a = (AMRP) o;
		return a.packageName.equals(packageName);
	}
}
