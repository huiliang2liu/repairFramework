package com.xh.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;

public class ManifestManage {
	static ManifestManage manifestManage;
	private PackageManager packageManager;
	public static enum Type {
		SERVICE, RECEIVER, ACTIVITY, APPLICATION
	}

	private Context context;

	public static ManifestManage init(Context context) {
		if (manifestManage == null)
			synchronized (ManifestManage.class.getName()) {
				if (manifestManage == null)
					manifestManage = new ManifestManage(context);
			}
		return manifestManage;
	}

	private ManifestManage(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
		packageManager = context.getPackageManager();
	}

	/**
	 * 获取包名
	 * 
	 * @return
	 */
	public String package_name() {
		return context.getPackageName();
	}

	/**
	 * 获取版本名称
	 * 
	 * @return
	 */
	public String version_name() {
		try {
			return packageManager.getPackageInfo(package_name(), 0).versionName;
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
		}
		return null;
	}

	/**
	 * 获取版本号
	 * 
	 * @return
	 */
	public int version_code() {
		try {
			return packageManager.getPackageInfo(package_name(), 0).versionCode;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

	/**
	 * 获取图标
	 * 
	 * @return
	 */
	public Drawable getAppIcon() {
		try {
			return packageManager.getApplicationInfo(package_name(), 0)
					.loadIcon(packageManager);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block

		}
		return null;
	}

	/**
	 * 获取程序的权限
	 */
	public String[] getAppPremission() {
		try {
			return packageManager.getPackageInfo(package_name(),
					PackageManager.GET_PERMISSIONS).requestedPermissions;

		} catch (NameNotFoundException e) {

		}
		return null;
	}

	/**
	 * 获取程序的签名
	 */
	public String getAppSignature() {
		try {
			return packageManager.getPackageInfo(package_name(),
					PackageManager.GET_SIGNATURES).signatures[0]
					.toCharsString();

		} catch (NameNotFoundException e) {
			e.printStackTrace();

		}
		return "";
	}

	/**
	 * 获取application 中的meta—data的值
	 * 
	 * @param meta_data
	 *            名称
	 * @return
	 */
	public String meta_data(String meta_data) {
		return meta_data(Type.APPLICATION, meta_data, null);
	}

	/**
	 * 获取meta-data的值
	 * 
	 * @param type
	 *            类型
	 * @param meta_data
	 *            名称
	 * @param class_name
	 *            类名
	 * @return
	 */
	public String meta_data(Type type, String meta_data, String class_name) {
		ComponentName cn = null;
		if (class_name != null)
			cn = new ComponentName(package_name(), class_name);
		String data = null;
		try {
			switch (type) {
			case APPLICATION:
				data = packageManager.getApplicationInfo(package_name(),
						PackageManager.GET_META_DATA).metaData
						.getString(meta_data);
				break;
			case ACTIVITY:
				data = packageManager.getActivityInfo(cn,
						PackageManager.GET_META_DATA).metaData
						.getString(meta_data);
				break;
			case RECEIVER:
				data = packageManager.getReceiverInfo(cn,
						PackageManager.GET_META_DATA).metaData
						.getString(meta_data);
				break;
			case SERVICE:
				data = packageManager.getServiceInfo(cn,
						PackageManager.GET_META_DATA).metaData
						.getString(meta_data);
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return data;
	}
}
