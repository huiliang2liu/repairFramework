package com.xh.base;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;

import com.xh.http.IHttpManager;
import com.xh.http.OkHttpManagerImpl;
import com.xh.http.XhHttpManagerImpl;
import com.xh.ifaces.IObjectDBHelper;
import com.xh.ifaces.IOkHttpManager;
import com.xh.image.IImageManager;
import com.xh.image.XhImageLoadImpl;
import com.xh.image.cache.disc.impl.UnlimitedDiskCache;
import com.xh.image.core.DisplayImageOptions;
import com.xh.image.core.ImageLoader;
import com.xh.image.core.ImageLoaderConfiguration;
import com.xh.image.core.assist.ImageScaleType;
import com.xh.proxy.ProxyService;
import com.xh.proxy.XhProxyActivity;
import com.xh.recevier.SmsRecevier;
import com.xh.repair.Load;
import com.xh.save.DBObjectHelper;
import com.xh.string.StringUtil;
import com.xh.thread.IRunnableManager;
import com.xh.thread.XhThreadPoolExecutor;
import com.xh.util.ApkUtil;
import com.xh.util.AssetsManager;
import com.xh.util.FileManagemet;
import com.xh.util.NetworkManagement;
import com.xh.util.Util;
import com.xh.util.XhExceptionHandler;
import com.xh.util.XhLog;

/**
 * @version 创建时间：2017-12-6 下午6:51:52 项目：repair 包名：com.xh.base
 *          文件名：BaseApplication.java 作者：lhl 说明:
 */

public class BaseApplication extends Application implements
		ActivityLifecycleCallbacks {
	private final static String TAG = BaseApplication.class.getName();
	public Load load;
	private IRunnableManager manager;
	private IHttpManager httpManager;
	private XhExceptionHandler handler;
	protected IImageManager imageManager;
	private IObjectDBHelper dbHelper;
	private NetworkChange networkChange;
	protected XhBaseActivity baseActivity;
	private String savePath;
	protected IOkHttpManager okhttp;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		checkSign();
		checkSHA1();
		AssetsManager.copyAllAssetsApk(this, sdkOrApkSavePath());
		init();
		List<String> actions = new ArrayList<String>();
		actions.add("android.net.conn.CONNECTIVITY_CHANGE");
		Util.register_broadcast(this, networkChange, actions);
		// 拦截短信
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
		intentFilter.setPriority(1000);
		SmsRecevier smsRecevier = new SmsRecevier();
		registerReceiver(smsRecevier, intentFilter);
		imageLoaderInitialize();
		XhLog.e(TAG, "初始化完成");
	}

	/**
	 * 初始化图片加载器
	 */
	private void imageLoaderInitialize() {
		// TODO Auto-generated method stub
		File cacheDir = new File(Environment.getExternalStorageDirectory()
				.getAbsolutePath() + "/" + getPackageName() + "/img");
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.imageScaleType(ImageScaleType.IN_SAMPLE_INT)
				.bitmapConfig(Bitmap.Config.RGB_565)// 防止内存溢出的，图片太多就这这个。还有其他设置
				.cacheInMemory(false) // 设置下载的图片是否缓存在内存中
				.cacheOnDisk(true) // 设置下载的图片是否缓存在SD卡中
				.build();

		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				this).threadPriority(Thread.NORM_PRIORITY - 2)
				.memoryCacheExtraOptions(600, 600)
				.diskCacheExtraOptions(600, 600, null)
				.defaultDisplayImageOptions(options) // 上面的options对象，一些属性配置
				.diskCache(new UnlimitedDiskCache(cacheDir))// 自定义缓存路径
				.build();
		ImageLoader.getInstance().init(config); // 初始化
	}

	private void init() {
		// TODO Auto-generated method stub
		File file;
		boolean wes = false;
		XhLog.setTAG(getPackageName());
		try {
			if (FileManagemet.sdcardIs()) {
				XhLog.e(TAG, "安装了sdcard");
				ApplicationInfo applicationInfo = this.getPackageManager()
						.getApplicationInfo(getPackageName(),
								PackageManager.GET_PERMISSIONS);
				PackageManager pm = getPackageManager();
				String packageName = getPackageName();
				wes = PackageManager.PERMISSION_GRANTED == pm.checkPermission(
						"android.permission.WRITE_EXTERNAL_STORAGE",
						packageName);
				if (wes) {
					XhLog.e(TAG, "sdcard 有操作权限");
					file = FileManagemet.mnt_sdcard(getPackageName());
				} else {
					file = FileManagemet.getFilesDir(this);
				}
			} else
				file = FileManagemet.getFilesDir(this);
		} catch (Exception e) {
			// TODO: handle exception
			file = FileManagemet.getFilesDir(this);
		}
		savePath = file.getAbsolutePath();
		handler = new XhExceptionHandler(errorFile());
		Thread.setDefaultUncaughtExceptionHandler(handler);
		XhLog.e(TAG, "文件保存路径是" + savePath + "  是否为公有：" + (wes ? "公有" : "私有"));
		// context.getDir(APK_DIR, Context.MODE_PRIVATE)
		manager = new XhThreadPoolExecutor();

		httpManager = new XhHttpManagerImpl(manager);
		httpManager.stream("");
		httpManager.stream("");
		imageManager = new XhImageLoadImpl(manager, this);
		dbHelper = new DBObjectHelper(this);
		String error = handler.error();
		if (error != null) {
			XhLog.e(TAG, "错误日志上报");
			Map<String, Object> params = new HashMap<String, Object>();
			params.put(errorKey(), error);
			httpManager.stringPost(errorPath(), params);
		}
		registerActivityLifecycleCallbacks(this);
		networkChange = new NetworkChange();
		okhttp = OkHttpManagerImpl.init(this);
		// load();
	}

	/**
	 * 
	 * lhl 2018-1-12 下午5:55:40 说明：加载外挂包，最好在子线程，耗时操作 void
	 */
	public void load() {
		// TODO Auto-generated method stub
		load = new Load(BaseApplication.this, sdkOrApkSavePath());
	}

	/**
	 * 
	 * lhl 2018-1-12 下午5:49:31 说明：补丁包保存位置
	 * 
	 * @return Field
	 */
	public File sdkOrApkSavePath() {
		return getDir(AssetsManager.APK_DIR, Context.MODE_PRIVATE);
	}

	/**
	 * 
	 * lhl 2018-1-3 上午10:04:59 说明： 校验SHA1 void
	 */
	private void checkSHA1() {
		// TODO Auto-generated method stub
		String SHA1 = pairSHA1();
		if (!StringUtil.isEmpty(SHA1)) {
			String packageSHA1 = ApkUtil.sHA1(this);
			if (SHA1.equals(packageSHA1)) {
				XhLog.e(TAG, "SHA1相同，通过");
			} else {
				XhLog.e(TAG, "SHA1不相同，没通过");
				Process.killProcess(Process.myPid());
				System.exit(0);
			}
		}
	}

	/**
	 * 
	 * lhl 2018-1-3 上午10:04:30 说明：校验签名 void
	 */
	private void checkSign() {
		// TODO Auto-generated method stub
		String sign = pairSign();
		if (!StringUtil.isEmpty(sign)) {
			String packageSign = ApkUtil.getSign(this);
			if (sign.equals(packageSign))
				XhLog.e(TAG, "签名相同通过");
			else {
				XhLog.e(TAG, "签名不相同，没通过");
				Process.killProcess(Process.myPid());
				System.exit(0);
			}
		}
	}

	public IImageManager getImageManager() {
		return imageManager;
	}

	public IRunnableManager getManager() {
		return manager;
	}

	public IHttpManager getHttpManager() {
		return httpManager;
	}

	public IObjectDBHelper getDb() {
		return dbHelper;
	}

	/**
	 * 
	 * lhl 2017-12-22 下午3:26:39 说明：代理类
	 * 
	 * @return String
	 */
	protected String activityName() {
		return XhProxyActivity.class.getName();
	}

	/**
	 * 
	 * lhl 2017-12-22 下午3:26:39 说明：代理类
	 * 
	 * @return String
	 */
	protected String serviceName() {
		return ProxyService.class.getName();
	}

	/**
	 * 
	 * lhl 2017-12-22 下午4:05:01 说明：错误日志报错地址
	 * 
	 * @return String
	 */
	protected String errorFile() {
		return savePath;
	}

	/**
	 * 
	 * lhl 2017-12-22 下午4:05:20 说明：错误日志上报地址
	 * 
	 * @return String
	 */
	protected String errorPath() {
		return "";
	}

	/**
	 * 
	 * lhl 2017-12-22 下午4:07:53 说明：错误日志所对应的键
	 * 
	 * @return String
	 */
	protected String errorKey() {
		return "";
	}

	@Override
	public void onTerminate() {
		// 程序终止的时候执行
		XhLog.d(TAG, "onTerminate");
		dbHelper.close();
		okhttp.destory();
		Util.un_register_broadcast(this, networkChange);
		super.onTerminate();
	}

	@Override
	public void onLowMemory() {
		// 低内存的时候执行
		XhLog.d(TAG, "onLowMemory");
		super.onLowMemory();
	}

	@Override
	public void onTrimMemory(int level) {
		// 程序在内存清理的时候执行
		XhLog.d(TAG, "onTrimMemory");
		super.onTrimMemory(level);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		XhLog.d(TAG, "onConfigurationChanged");
		super.onConfigurationChanged(newConfig);
	}

	private class NetworkChange extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			if (!NetworkManagement.isNetworkAvailable(context)) {
				if (baseActivity != null)
					baseActivity.noNetwork();
			} else {
				if (baseActivity != null)
					baseActivity.network();
			}
		}

	}

	@Override
	public void onActivityCreated(Activity arg0, Bundle arg1) {
		// TODO Auto-generated method stub
		if (arg0 instanceof XhBaseActivity)
			baseActivity = (XhBaseActivity) arg0;
	}

	@Override
	public void onActivityDestroyed(Activity arg0) {
		// TODO Auto-generated method stub
		if (arg0 == baseActivity)
			baseActivity = null;
	}

	@Override
	public void onActivityPaused(Activity arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onActivityResumed(Activity arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onActivitySaveInstanceState(Activity arg0, Bundle arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onActivityStarted(Activity arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onActivityStopped(Activity arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * lhl 2018-1-3 上午9:55:01 说明：对比的签名，如果不为空则对比签名
	 * 
	 * @return String
	 */
	protected String pairSign() {
		return null;
	}

	/**
	 * 
	 * lhl 2018-1-3 上午9:59:14 说明：对比SHA1,如果不为空则对比SHA1
	 * 
	 * @return String
	 */
	protected String pairSHA1() {
		return null;
	}

	/**
	 * 
	 * lhl 2018-1-3 上午10:02:18 说明：获取保存数据根目录
	 * 
	 * @return String
	 */
	public String getSavePath() {
		return savePath;
	}

}
