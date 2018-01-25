package com.xh.repair;

import java.io.File;
import java.util.List;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;

import com.xh.ifaces.ILoad;
import com.xh.string.StringUtil;
import com.xh.util.XmlPullParserUtil;

/**
 * @version 创建时间：2017-12-5 下午6:07:50 项目：repair 包名：com.xh.util 文件名：Load.java
 *          作者：lhl 说明:
 */

public class Load implements ILoad {

	private LoadApk loadApk;
	private LoadDex loadDex;

	public Resources appResources;
	public Theme appTheme;
	public AssetManager appAssetManager;
	public PackageInfo appPackageInfo;

	public Resources mResources;
	public Theme mTheme;
	public AssetManager mAssetManager;
	public PackageInfo mPackageInfo;
	public Load(Context context, File file) {
		// TODO Auto-generated constructor stub
		loadDex = new LoadDex(context, file);
		loadApk = new LoadApk(context, file);
		appResources = context.getResources();
		appTheme = context.getTheme();
		appAssetManager = context.getAssets();
		try {
			appPackageInfo = context.getPackageManager().getPackageInfo(
					context.getPackageName(),
					PackageManager.GET_ACTIVITIES | PackageManager.GET_SERVICES
							| PackageManager.GET_META_DATA|PackageManager.GET_PERMISSIONS|PackageManager.GET_SIGNATURES);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		loadApk.aList.add(new AMRP(appPackageInfo, appAssetManager,
				appResources));
	}

	public View getView(String name, Context context) {
		return XmlPullParserUtil
				.xmlPullParser2view(context, parserLayout(name));
	}

	public View getView(Resources resources, String packageName, String name,
			Context context) {
		return XmlPullParserUtil.xmlPullParser2view(context,
				parser(resources, name, "layout", packageName));
	}

	public View getView(int layoutId, Context context) {
		return XmlPullParserUtil.xmlPullParser2view(context,
				parserLayout(layoutId));
	}

	public View getView(Resources resources, int layoutId, Context context) {
		return XmlPullParserUtil.xmlPullParser2view(context,
				parser(resources, layoutId, "layout"));
	}

	public Animation getAnimation(String name, Context context) {
		return XmlPullParserUtil.xmlPullParser2animation(context,
				parserAnima(name));
	}

	public Animation getAnimation(Resources resources, String packageName,
			String name, Context context) {
		return XmlPullParserUtil.xmlPullParser2animation(context,
				parser(resources, name, "anim", packageName));
	}

	public Animation getAnimation(int animId, Context context) {
		return XmlPullParserUtil.xmlPullParser2animation(context,
				parserAnima(animId));
	}

	public Animation getAnimation(Resources resources, int layoutId,
			Context context) {
		return XmlPullParserUtil.xmlPullParser2animation(context,
				parser(resources, layoutId, "anim"));
	}

	public XmlResourceParser parserLayout(String name) {
		return parser(name, "layout");
	}

	public XmlResourceParser parserAnima(String name) {
		return parser(name, "anim");
	}

	public XmlResourceParser parserLayout(int id) {
		return parser(id, "layout");
	}

	public XmlResourceParser parserAnima(int id) {
		return parser(id, "anim");
	}

	private XmlResourceParser parser(String name, String type) {
		int id = -1;
		id = name2id(appResources, name, type, appPackageInfo.packageName);
		if (id <= 0) {
			List<AMRP> aList = loadApk.aList;
			if (aList != null && aList.size() > 0)
				for (int i = 0; i < aList.size(); i++) {
					AMRP a = aList.get(i);
					id = name2id(a.resources, name, type,
							a.packageInfo.packageName);
					if (id > 0) {
						mResources = a.resources;
						mTheme = a.mTheme;
						mTheme.setTo(appTheme);
						mAssetManager = a.assetManager;
						mPackageInfo = a.packageInfo;
						break;
					}
				}
		} else {
			mResources = appResources;
			mTheme = appTheme;
			mAssetManager = appAssetManager;
			mPackageInfo = appPackageInfo;
		}
		return parser(mResources, name, type, mPackageInfo.packageName);
	}

	private XmlResourceParser parser(int id, String type) {
		XmlResourceParser parser = parser(appResources, id, type);
		if (parser == null) {
			List<AMRP> aList = loadApk.aList;
			if (aList != null && aList.size() > 0)
				for (int i = 0; i < aList.size(); i++) {
					AMRP a = aList.get(i);
					parser = parser(a.resources, id, type);
					if (parser != null) {
						mResources = a.resources;
						mTheme = a.mTheme;
						mTheme.setTo(appTheme);
						mAssetManager = a.assetManager;
						mPackageInfo = a.packageInfo;
						break;
					}
				}

		} else {
			mResources = appResources;
			mTheme = appTheme;
			mAssetManager = appAssetManager;
			mPackageInfo = appPackageInfo;
		}
		return parser;
	}

	private XmlResourceParser parser(Resources resources, int id, String type) {
		try {
			if (type.equals("layout"))
				return resources.getLayout(id);
			return resources.getAnimation(id);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	private XmlResourceParser parser(Resources resources, String name,
			String type, String packageName) {
		int id = name2id(resources, name, type, packageName);
		return parser(resources, id, type);
	}

	public int style(String name) {
		return name2id(name, "style");
	}

	public int style(String name, Resources resources, String packageName) {
		return name2id(resources, packageName, "style", packageName);
	}

	public int dimen(String name) {
		return name2id(name, "dimen");
	}

	public int dimen(String name, Resources resources, String packageName) {
		return name2id(resources, packageName, "dimen", packageName);
	}

	public int color(String name) {
		return name2id(name, "color");
	}

	public int colorValue(String name) {
		return mResources.getColor(color(name));
	}

	public ColorStateList colorList(String name) {
		return mResources.getColorStateList(color(name));
	}

	public int colorValue(int colorId) {
		return mResources.getColor(colorId);
	}

	public ColorStateList colorList(int colorId) {
		return mResources.getColorStateList(colorId);
	}

	public int color(String name, Resources resources, String packageName) {
		return name2id(resources, packageName, "color", packageName);
	}

	public int colorValue(String name, Resources resources, String packageName) {
		return resources.getColor(color(name, resources, packageName));
	}

	public ColorStateList colorList(String name, Resources resources,
			String packageName) {
		return resources.getColorStateList(color(name, resources, packageName));
	}

	public int colorValue(int colorId, Resources resources) {
		return resources.getColor(colorId);
	}

	public ColorStateList colorList(int colorId, Resources resources) {
		return resources.getColorStateList(colorId);
	}

	public int anim(String name) {
		return name2id(name, "anim");
	}

	public int anim(String name, Resources resources, String packageName) {
		return name2id(resources, packageName, "anim", packageName);
	}

	public int raw(String name) {
		return name2id(name, "raw");
	}

	public int raw(String name, Resources resources, String packageName) {
		return name2id(resources, packageName, "raw", packageName);
	}

	public int attr(String name) {
		return name2id(name, "attr");
	}

	public int attr(String name, Resources resources, String packageName) {
		return name2id(resources, packageName, "attr", packageName);
	}

	public int string(String name) {
		return name2id(name, "string");
	}

	public String stringValue(String name) {
		return mResources.getString(string(name));
	}

	public String[] stringValues(String name) {
		return mResources.getStringArray(string(name));
	}

	public String stringValue(int stringId) {
		return mResources.getString(stringId);
	}

	public String[] stringValues(int stringId) {
		return mResources.getStringArray(stringId);
	}

	public int string(String name, Resources resources, String packageName) {
		return name2id(resources, packageName, "string", packageName);
	}

	public String stringValue(String name, Resources resources,
			String packageName) {
		return resources.getString(name2id(resources, packageName, "string",
				packageName));
	}

	public String[] stringValues(String name, Resources resources,
			String packageName) {
		return resources.getStringArray(name2id(resources, packageName,
				"string", packageName));
	}

	public String stringValue(int stringId, Resources resources) {
		return resources.getString(stringId);
	}

	public String[] stringValues(int stringId, Resources resources) {
		return resources.getStringArray(stringId);
	}

	public int id(String name) {
		return name2id(name, "id");
	}

	public int id(String name, Resources resources, String packageName) {
		return name2id(resources, packageName, "id", packageName);
	}

	public int drawable(String name) {
		return name2id(name, "drawable");
	}

	public Drawable drawableValue(String name) {
		return mResources.getDrawable(drawable(name));
	}

	public int drawable(String name, Resources resources, String packageName) {
		return name2id(resources, packageName, "drawable", packageName);
	}

	public Drawable drawableValue(int drawableId, Resources resources) {
		return resources.getDrawable(drawableId);
	}

	public Drawable drawableValue(String name, Resources resources,
			String packageName) {
		return resources.getDrawable(name2id(resources, packageName,
				"drawable", packageName));
	}

	public int layout(String name) {
		return name2id(name, "layout");
	}

	public int layout(String name, Resources resources, String packageName) {
		return name2id(resources, packageName, "layout", packageName);
	}

	public int name2id(String name, String type) {
		return mResources.getIdentifier(name, type, mPackageInfo.packageName);
	}

	public int name2id(Resources resources, String name, String type,
			String packageName) {
		return resources.getIdentifier(name, type, packageName);
	}

	public AMRP layoutId2amrp(int layoutId) {
		List<AMRP> amrps = loadApk.aList;
		for (int i = 0; i < amrps.size(); i++) {
			try {
				AMRP amrp = amrps.get(i);
				String name = amrp.resources.getResourceName(layoutId);
				if (!StringUtil.isEmpty(name))
					return amrp;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return null;
	}

	public AMRP layoutName2amrp(String layoutName) {
		List<AMRP> amrps = loadApk.aList;
		for (int i = 0; i < amrps.size(); i++) {
			try {
				AMRP amrp = amrps.get(i);
				int id = name2id(amrp.resources, layoutName, "layout",
						amrp.packageName);
				if (id > 0)
					return amrp;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return null;
	}

	public AMRP package2amrp(String packageName) {
		List<AMRP> amrps = loadApk.aList;
		AMRP p = new AMRP();
		p.packageName = packageName;
		int index = amrps.indexOf(p);
		if (index >= 0)
			return amrps.get(index);
		return null;
	}

	public Resources package2resources(String packageName) {
		AMRP p = package2amrp(packageName);
		return p == null ? null : p.resources;
	}

	public AssetManager package2assetManager(String packageName) {
		AMRP p = package2amrp(packageName);
		return p == null ? null : p.assetManager;
	}

	public PackageInfo package2packageInfo(String packageName) {
		AMRP p = package2amrp(packageName);
		return p == null ? null : p.packageInfo;
	}

	public Theme package2theme(String packageName) {
		AMRP p = package2amrp(packageName);
		return p == null ? null : p.mTheme;
	}
}
