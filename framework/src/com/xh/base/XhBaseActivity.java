package com.xh.base;

import java.lang.reflect.Method;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.xh.annotation.ViewAnnotationParse;
import com.xh.http.IHttpManager;
import com.xh.ifaces.IFatherView;
import com.xh.ifaces.IObjectDBHelper;
import com.xh.ifaces.IOkHttpManager;
import com.xh.ifaces.ISVGParser;
import com.xh.ifaces.IViewAnnotation;
import com.xh.image.IImageManager;
import com.xh.plugin.PluginService;
import com.xh.repair.AMRP;
import com.xh.repair.Load;
import com.xh.string.StringUtil;
import com.xh.svg.SVGParser;
import com.xh.svg.vector.VectorParas;
import com.xh.thread.IRunnableManager;
import com.xh.util.Constants;
import com.xh.util.ViewAnnotationImpl;
import com.xh.util.XhLog;
import com.xh.util.XhPhoneInformation;

/**
 * @version ����ʱ�䣺2017-12-6 ����6:43:40 ��Ŀ��repair ������com.xh.base
 *          �ļ�����BaseActivity.java ���ߣ�lhl ˵��:
 */

public abstract class XhBaseActivity extends FragmentActivity implements
		IViewAnnotation, OnClickListener, IRunnableManager, IFatherView {
	private final static String TAG = XhBaseActivity.class.getName();
	private Resources mResources;
	private AssetManager mAssetManager;
	private Theme mTheme;
	protected View view;
	protected Load load;
	protected ViewAnnotationImpl viewAnnotationImpl;
	private Object receiver;
	protected BaseApplication application;
	protected IRunnableManager manager;
	protected IHttpManager httpManager;
	protected IImageManager imageManager;
	private String packageName;
	protected IObjectDBHelper db;
	protected FrameLayout fatherView;
	private FatherViewImpl fatherViewImpl;
	protected XhPhoneInformation information;
	protected ISVGParser vectorParas;
	protected ISVGParser svgParser;
	protected IOkHttpManager okHttpManager;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		packageName = packageName();
		application = (BaseApplication) getApplication();
		load = application.load;
		manager = application.getManager();
		httpManager = application.getHttpManager();
		imageManager = application.getImageManager();
		db = application.getDb();
		fatherView = (FrameLayout) findViewById(android.R.id.content);
		if (layout() > 0)
			setContentView(layout());
		else if (!StringUtil.isEmpty(layoutName()))
			setContentView(layoutName());
		fatherViewImpl = new FatherViewImpl(fatherView);
		information = XhPhoneInformation.initialize(this);
		vectorParas = VectorParas.init(information);
		svgParser = SVGParser.init(information);
		okHttpManager=application.okhttp;
	}

	@Override
	public void setContentView(int layoutResID) {
		// TODO Auto-generated method stub
		AMRP amrp = null;
		if (packageName != null && !packageName.isEmpty()) {
			amrp = load.package2amrp(packageName);

		} else {
			amrp = load.layoutId2amrp(layoutResID);
		}
		if (amrp == null)
			throw new RuntimeException("you package error");
		mResources = amrp.resources;
		mAssetManager = amrp.assetManager;
		mTheme = amrp.mTheme;
		mTheme.setTo(super.getTheme());
		packageName = amrp.packageName;
		view = load.getView(mResources, layoutResID, this);
		if (view == null)
			throw new RuntimeException("you view is not find");
		receiver = receiver();
		if (receiver == null)
			receiver = this;
		viewAnnotationImpl = new ViewAnnotationImpl(view, this);
		setContentView(view);
		ViewAnnotationParse.parse(getViewAnnotation(), receiver);
	}

	@Override
	public void setContentView(View view) {
		// TODO Auto-generated method stub
		// fatherView.addView(view);
		super.setContentView(view);
	}

	/**
	 * 
	 * lhl 2017-12-13 ����4:21:45 ˵��������id
	 * 
	 * @param layoutId
	 *            void
	 */
	public void setContentView(String layoutName) {
		AMRP amrp = null;
		if (packageName != null && !packageName.isEmpty()) {
			amrp = load.package2amrp(packageName);

		} else {
			amrp = load.layoutName2amrp(layoutName);
		}
		if (amrp == null)
			throw new RuntimeException("you package error");
		mResources = amrp.resources;
		mAssetManager = amrp.assetManager;
		mTheme = amrp.mTheme;
		mTheme.setTo(super.getTheme());
		packageName = amrp.packageName;
		view = load.getView(mResources, packageName, layoutName, this);
		if (view == null)
			throw new RuntimeException("you view is not find");
		receiver = receiver();
		if (receiver == null)
			receiver = this;
		viewAnnotationImpl = new ViewAnnotationImpl(view, this);
		setContentView(view);
		ViewAnnotationParse.parse(getViewAnnotation(), receiver);
	}

	public IViewAnnotation getViewAnnotation() {
		return this;
	}

	@Override
	public Resources getResources() {
		// TODO Auto-generated method stub
		return mResources == null ? super.getResources() : mResources;
	}

	@Override
	public AssetManager getAssets() {
		// TODO Auto-generated method stub
		return mAssetManager == null ? super.getAssets() : mAssetManager;
	}

	@Override
	public Theme getTheme() {
		// TODO Auto-generated method stub
		if (mTheme == null) {
			return super.getTheme();
		}
		return mTheme;
	}

	protected String packageName() {
		return null;
	}

	@Override
	public View id2View(int viewId) {
		// TODO Auto-generated method stub
		return viewAnnotationImpl.id2View(viewId);
	}

	@Override
	public void bindClickMethod(View view, Method method) {
		// TODO Auto-generated method stub
		viewAnnotationImpl.bindClickMethod(view, method);
	}

	@Override
	public Object invoke(View view, Object receiver) {
		// TODO Auto-generated method stub
		return viewAnnotationImpl.invoke(view, receiver);
	}

	public Object invoke(View view) {
		// TODO Auto-generated method stub
		return viewAnnotationImpl.invoke(view, receiver);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		XhLog.e(TAG, "onClick");
		invoke(arg0);
	}

	@Override
	public OnClickListener getOnClickListener() {
		// TODO Auto-generated method stub
		return viewAnnotationImpl.getOnClickListener();
	}

	protected Object receiver() {
		return null;
	}

	@Override
	public void submit(Runnable command) {
		// TODO Auto-generated method stub
		manager.submit(command);
	}

	@Override
	public void submit(Runnable command, long delay) {
		// TODO Auto-generated method stub
		manager.submit(command, delay);
	}

	@Override
	public void submit(Runnable command, long initialDelay, long period) {
		// TODO Auto-generated method stub
		manager.submit(command, initialDelay, period);
	}

	@Override
	public void submit(List<Runnable> commands) {
		// TODO Auto-generated method stub
		manager.submit(commands);
	}

	@Override
	public void remove(Runnable command) {
		// TODO Auto-generated method stub
		manager.remove(command);
	}

	@Override
	public void remove(List<Runnable> commands) {
		// TODO Auto-generated method stub
		manager.remove(commands);
	}

	@Override
	public List<Runnable> shutdownNow() {
		// TODO Auto-generated method stub
		return manager.shutdownNow();
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		manager.shutdown();
	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode,
			Bundle options) {
		// TODO Auto-generated method stub
		BaseApplication app = (BaseApplication) getApplication();
		ComponentName component = intent.getComponent();
		String BPA = component.getClassName();
		try {
			Class cl = Class.forName(BPA);
			if (!BasePluginActivity.class.isAssignableFrom(cl)) {
				super.startActivityForResult(intent, requestCode, options);
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		ComponentName componen1 = new ComponentName(component.getPackageName(),
				app.activityName());
		intent.setComponent(componen1);
		intent.putExtra(Constants.CLASS_NAME, BPA);
		super.startActivityForResult(intent, requestCode, options);
		int enterAnim = enterAnim();
		int exitAnim = exitAnim();
		if (Integer.valueOf(android.os.Build.VERSION.SDK) > 5 && enterAnim > 0
				&& exitAnim > 0)
			overridePendingTransition(enterAnim, exitAnim);
	}

	/**
	 * 
	 * lhl 2017-12-28 ����5:15:14 ˵�������붯��
	 * 
	 * @return int
	 */
	protected int enterAnim() {
		return -1;
	}

	/**
	 * 
	 * lhl 2017-12-28 ����5:15:56 ˵�����˳�����
	 * 
	 * @return int
	 */
	protected int exitAnim() {
		return -1;
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		int color = color();
		setColor(color);
	}

	/**
	 * 
	 * lhl 2017-12-28 ����5:03:18 ˵������ȡ״̬����ɫ
	 * 
	 * @return int
	 */
	protected int color() {
		return Color.BLACK;
	}

	/** * ����״̬����ɫ * * @param activity ��Ҫ���õ�activity * @param color ״̬����ɫֵ */
	@SuppressLint("NewApi")
	private void setColor(int color) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			// ����״̬��͸��
			this.getWindow().addFlags(
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			// ����һ��״̬����С�ľ���
			View statusView = createStatusView(color);
			// ��� statusView ��������
			ViewGroup decorView = (ViewGroup) this.getWindow().getDecorView();
			decorView.addView(statusView);
			// ���ø����ֵĲ���
			ViewGroup rootView = (ViewGroup) ((ViewGroup) this
					.findViewById(android.R.id.content)).getChildAt(0);
			rootView.setFitsSystemWindows(true);
			rootView.setClipToPadding(true);
		}
	}

	/**
	 * * ����һ����״̬����С��ͬ�ľ����� * * @param activity ��Ҫ���õ�activity * @param color
	 * ״̬����ɫֵ * @return ״̬��������
	 */
	private View createStatusView(int color) {
		// ���״̬���߶�
		int resourceId = getResources().getIdentifier("status_bar_height",
				"dimen", "android");
		int statusBarHeight = getResources().getDimensionPixelSize(resourceId);
		// ����һ����״̬��һ���ߵľ���
		View statusView = new View(this);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT, statusBarHeight);
		statusView.setLayoutParams(params);
		statusView.setBackgroundColor(color);
		return statusView;
	}

	/**
	 * 
	 * lhl 2017-12-29 ����5:10:56 ˵���������ļ���
	 * 
	 * @return String
	 */
	protected String layoutName() {
		return "";
	}

	/**
	 * 
	 * lhl 2017-12-29 ����5:10:45 ˵��������id
	 * 
	 * @return int
	 */
	protected int layout() {
		return -1;
	}

	/**
	 * 
	 * lhl 2017-12-28 ����11:51:04 ˵��������ʱ�ص� void
	 */
	protected void noNetwork() {

	}

	/**
	 * 
	 * lhl 2017-12-28 ����11:51:19 ˵��������ʱ�ص� void
	 */
	protected void network() {

	}

	@Override
	public void addView(View view) {
		// TODO Auto-generated method stub
		fatherViewImpl.addView(view);
	}

	@Override
	public void addView(View view, LayoutParams layoutParams) {
		// TODO Auto-generated method stub
		fatherViewImpl.addView(view, layoutParams);
	}

	@Override
	public void addView(View view, int left, int top, int right, int bottom) {
		// TODO Auto-generated method stub
		fatherViewImpl.addView(view, left, top, right, bottom);
	}

	@Override
	public void addViewBottom(View view, View referenceView) {
		// TODO Auto-generated method stub
		fatherViewImpl.addViewBottom(view, referenceView);
	}

	@Override
	public void addViewTop(View view, View referenceView) {
		// TODO Auto-generated method stub
		fatherViewImpl.addViewTop(view, referenceView);
	}

	@Override
	public void addViewRigth(View view, View referenceView) {
		// TODO Auto-generated method stub
		fatherViewImpl.addViewRigth(view, referenceView);
	}

	@Override
	public void addViewLeft(View view, View referenceView) {
		// TODO Auto-generated method stub
		fatherViewImpl.addViewLeft(view, referenceView);
	}

	@Override
	public void remove(View view) {
		// TODO Auto-generated method stub
		fatherViewImpl.remove(view);
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		fatherViewImpl.clean();
	}

	@Override
	public void addViewRigthBottom(View view, View referenceView) {
		// TODO Auto-generated method stub
		fatherViewImpl.addViewRigthBottom(view, referenceView);
	}

	@Override
	public ComponentName startService(Intent intent) {
		// TODO Auto-generated method stub
		BaseApplication app = (BaseApplication) getApplication();
		ComponentName component = intent.getComponent();
		String BPA = component.getClassName();
		try {
			Class cl = Class.forName(BPA);
			if (!PluginService.class.isAssignableFrom(cl)) {
				return super.startService(intent);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		ComponentName componen1 = new ComponentName(component.getPackageName(),
				app.serviceName());
		intent.setComponent(componen1);
		intent.putExtra(Constants.CLASS_NAME, BPA);
		return super.startService(intent);
	}

	@Override
	public boolean bindService(Intent intent, ServiceConnection conn, int flags) {
		// TODO Auto-generated method stub
		BaseApplication app = (BaseApplication) getApplication();
		ComponentName component = intent.getComponent();
		String BPA = component.getClassName();
		try {
			Class cl = Class.forName(BPA);
			if (!PluginService.class.isAssignableFrom(cl)) {
				return super.bindService(intent,conn,flags);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		ComponentName componen1 = new ComponentName(component.getPackageName(),
				app.serviceName());
		intent.setComponent(componen1);
		intent.putExtra(Constants.CLASS_NAME, BPA);
		return super.bindService(intent,conn,flags);
	}

	@Override
	public boolean stopService(Intent intent) {
		// TODO Auto-generated method stub
		BaseApplication app = (BaseApplication) getApplication();
		ComponentName component = intent.getComponent();
		String BPA = component.getClassName();
		try {
			Class cl = Class.forName(BPA);
			if (!PluginService.class.isAssignableFrom(cl)) {
				return super.stopService(intent);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		ComponentName componen1 = new ComponentName(component.getPackageName(),
				app.serviceName());
		intent.setComponent(componen1);
		intent.putExtra(Constants.CLASS_NAME, BPA);
		return super.stopService(intent);
	}
}
