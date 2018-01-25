package com.xh.base;

import java.lang.reflect.Method;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.FrameLayout;

import com.xh.http.IHttpManager;
import com.xh.ifaces.IFatherView;
import com.xh.ifaces.ILoad;
import com.xh.ifaces.IObjectDBHelper;
import com.xh.ifaces.IOkHttpManager;
import com.xh.ifaces.ISVGParser;
import com.xh.ifaces.IViewAnnotation;
import com.xh.image.IImageManager;
import com.xh.plugin.PluginActivity;
import com.xh.thread.IRunnableManager;
import com.xh.util.XhPhoneInformation;

/**
 * @version 创建时间：2017-12-8 上午11:26:12 项目：repair 包名：com.example.repair
 *          文件名：TestActivity.java 作者：lhl 说明:
 */

@SuppressLint("NewApi")
public abstract class BasePluginActivity extends PluginActivity implements
		ILoad, IViewAnnotation, OnClickListener, IRunnableManager, IFatherView {
	private BaseProxyActivity iProxy;
	private IViewAnnotation viewAnnotationImpl;
	private Object receiver;
	protected IRunnableManager manager;
	protected IHttpManager httpManager;
	protected IImageManager imageManager;
	protected IObjectDBHelper db;
	protected FrameLayout fatherView;
	protected XhPhoneInformation information;
	protected ISVGParser vectorParas;
	protected ISVGParser svgParser;
	protected IOkHttpManager okHttpManager;

	@Override
	public void createActivity() {
		// TODO Auto-generated method stub
		super.createActivity();
		iProxy = (BaseProxyActivity) activity;
		manager = (IRunnableManager) activity;
		httpManager = iProxy.httpManager;
		imageManager = iProxy.imageManager;
		viewAnnotationImpl = iProxy;
		db = iProxy.db;
		information = iProxy.information;
		vectorParas = iProxy.vectorParas;
		svgParser = iProxy.svgParser;
		okHttpManager = iProxy.okHttpManager;
	}

	@Override
	public void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);

	}

	public IViewAnnotation getViewAnnotation() {
		return this;
	}

	public View getView(String name, Context context) {
		// TODO Auto-generated method stub
		return iProxy.getView(name, context);
	}

	@Override
	public View getView(Resources resources, String packageName, String name,
			Context context) {
		// TODO Auto-generated method stub
		return iProxy.getView(resources, packageName, name, context);
	}

	@Override
	public View getView(int layoutId, Context context) {
		// TODO Auto-generated method stub
		return iProxy.getView(layoutId, context);
	}

	@Override
	public View getView(Resources resources, int layoutId, Context context) {
		// TODO Auto-generated method stub
		return iProxy.getView(resources, layoutId, context);
	}

	@Override
	public Animation getAnimation(String name, Context context) {
		// TODO Auto-generated method stub
		return iProxy.getAnimation(name, context);
	}

	@Override
	public Animation getAnimation(Resources resources, String packageName,
			String name, Context context) {
		// TODO Auto-generated method stub
		return iProxy.getAnimation(resources, packageName, name, context);
	}

	@Override
	public int style(String name) {
		// TODO Auto-generated method stub
		return iProxy.style(name);
	}

	@Override
	public int style(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return iProxy.style(name, resources, packageName);
	}

	@Override
	public int dimen(String name) {
		// TODO Auto-generated method stub
		return iProxy.dimen(name);
	}

	@Override
	public int dimen(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return iProxy.dimen(name, resources, packageName);
	}

	@Override
	public int color(String name) {
		// TODO Auto-generated method stub
		return iProxy.color(name);
	}

	@Override
	public int colorValue(String name) {
		// TODO Auto-generated method stub
		return iProxy.colorValue(name);
	}

	@Override
	public ColorStateList colorList(String name) {
		// TODO Auto-generated method stub
		return iProxy.colorList(name);
	}

	@Override
	public int colorValue(int colorId) {
		// TODO Auto-generated method stub
		return iProxy.colorValue(colorId);
	}

	@Override
	public ColorStateList colorList(int colorId) {
		// TODO Auto-generated method stub
		return iProxy.colorList(colorId);
	}

	@Override
	public int color(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return iProxy.color(name, resources, packageName);
	}

	@Override
	public int colorValue(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return iProxy.colorValue(name, resources, packageName);
	}

	@Override
	public ColorStateList colorList(String name, Resources resources,
			String packageName) {
		// TODO Auto-generated method stub
		return iProxy.colorList(name, resources, packageName);
	}

	@Override
	public int colorValue(int colorId, Resources resources) {
		// TODO Auto-generated method stub
		return iProxy.colorValue(colorId, resources);
	}

	@Override
	public ColorStateList colorList(int colorId, Resources resources) {
		// TODO Auto-generated method stub
		return iProxy.colorList(colorId, resources);
	}

	@Override
	public int anim(String name) {
		// TODO Auto-generated method stub
		return iProxy.anim(name);
	}

	@Override
	public int anim(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return iProxy.anim(name, resources, packageName);
	}

	@Override
	public int raw(String name) {
		// TODO Auto-generated method stub
		return iProxy.raw(name);
	}

	@Override
	public int raw(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return iProxy.raw(name, resources, packageName);
	}

	@Override
	public int attr(String name) {
		// TODO Auto-generated method stub
		return iProxy.attr(name);
	}

	@Override
	public int attr(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return iProxy.attr(name, resources, packageName);
	}

	@Override
	public int string(String name) {
		// TODO Auto-generated method stub
		return iProxy.string(name);
	}

	@Override
	public String stringValue(String name) {
		// TODO Auto-generated method stub
		return iProxy.stringValue(name);
	}

	@Override
	public String[] stringValues(String name) {
		// TODO Auto-generated method stub
		return iProxy.stringValues(name);
	}

	@Override
	public String stringValue(int stringId) {
		// TODO Auto-generated method stub
		return iProxy.stringValue(stringId);
	}

	@Override
	public String[] stringValues(int stringId) {
		// TODO Auto-generated method stub
		return iProxy.stringValues(stringId);
	}

	@Override
	public int string(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return iProxy.string(name, resources, packageName);
	}

	@Override
	public String stringValue(String name, Resources resources,
			String packageName) {
		// TODO Auto-generated method stub
		return iProxy.stringValue(name, resources, packageName);
	}

	@Override
	public String[] stringValues(String name, Resources resources,
			String packageName) {
		// TODO Auto-generated method stub
		return iProxy.stringValues(name, resources, packageName);
	}

	@Override
	public String stringValue(int stringId, Resources resources) {
		// TODO Auto-generated method stub
		return iProxy.stringValue(stringId, resources);
	}

	@Override
	public String[] stringValues(int stringId, Resources resources) {
		// TODO Auto-generated method stub
		return iProxy.stringValues(stringId, resources);
	}

	@Override
	public int id(String name) {
		// TODO Auto-generated method stub
		return iProxy.id(name);
	}

	@Override
	public int id(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return iProxy.id(name, resources, packageName);
	}

	@Override
	public int drawable(String name) {
		// TODO Auto-generated method stub
		return iProxy.drawable(name);
	}

	@Override
	public Drawable drawableValue(String name) {
		// TODO Auto-generated method stub
		return iProxy.drawableValue(name);
	}

	@Override
	public int drawable(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return iProxy.drawable(name, resources, packageName);
	}

	@Override
	public Drawable drawableValue(int drawableId, Resources resources) {
		// TODO Auto-generated method stub
		return iProxy.drawableValue(drawableId, resources);
	}

	@Override
	public Drawable drawableValue(String name, Resources resources,
			String packageName) {
		// TODO Auto-generated method stub
		return iProxy.drawableValue(name, resources, packageName);
	}

	@Override
	public int layout(String name) {
		// TODO Auto-generated method stub
		return iProxy.layout(name);
	}

	@Override
	public int layout(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return iProxy.layout(name, resources, packageName);
	}

	@Override
	public int name2id(String name, String type) {
		// TODO Auto-generated method stub
		return iProxy.name2id(name, type);
	}

	@Override
	public int name2id(Resources resources, String name, String type,
			String packageName) {
		// TODO Auto-generated method stub
		return iProxy.name2id(resources, name, type, packageName);
	}

	@Override
	public Resources package2resources(String packageName) {
		// TODO Auto-generated method stub
		return iProxy.package2resources(packageName);
	}

	@Override
	public AssetManager package2assetManager(String packageName) {
		// TODO Auto-generated method stub
		return iProxy.package2assetManager(packageName);
	}

	@Override
	public PackageInfo package2packageInfo(String packageName) {
		// TODO Auto-generated method stub
		return iProxy.package2packageInfo(packageName);
	}

	@Override
	public Theme package2theme(String packageName) {
		// TODO Auto-generated method stub
		return iProxy.package2theme(packageName);
	}

	@Override
	public Animation getAnimation(int animId, Context context) {
		// TODO Auto-generated method stub
		return iProxy.getAnimation(animId, context);
	}

	@Override
	public Animation getAnimation(Resources resources, int animId,
			Context context) {
		// TODO Auto-generated method stub
		return iProxy.getAnimation(resources, animId, context);
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
		invoke(arg0);
	}

	@Override
	public OnClickListener getOnClickListener() {
		// TODO Auto-generated method stub
		return viewAnnotationImpl.getOnClickListener();
	}

	protected Object receiver() {
		return this;
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

	protected String packageName() {
		return null;
	}

	/**
	 * 
	 * lhl 2017-12-29 下午5:11:25 说明：布局文件名
	 * 
	 * @return String
	 */
	protected String layoutName() {
		return "";
	}

	/**
	 * 
	 * lhl 2017-12-29 下午5:11:22 说明：布局文件id
	 * 
	 * @return int
	 */
	protected int layout() {
		return -1;
	}

	/**
	 * 
	 * lhl 2017-12-28 上午11:51:04 说明：断网时回调 void
	 */
	protected void noNetwork() {

	}

	/**
	 * 
	 * lhl 2017-12-28 上午11:51:19 说明：来网时回调 void
	 */
	protected void network() {

	}

	/**
	 * 
	 * lhl 2017-12-28 下午5:03:48 说明：获取状态栏颜色
	 * 
	 * @return int
	 */
	protected int color() {
		return Color.BLACK;
	}

	/**
	 * 
	 * lhl 2017-12-28 下午5:15:14 说明：进入动画
	 * 
	 * @return int
	 */
	protected int enterAnim() {
		return -1;
	}

	/**
	 * 
	 * lhl 2017-12-28 下午5:15:56 说明：退出动画
	 * 
	 * @return int
	 */
	protected int exitAnim() {
		return -1;
	}

	@Override
	public void addView(View view) {
		// TODO Auto-generated method stub
		iProxy.addView(view);
	}

	@Override
	public void addView(View view,
			android.view.ViewGroup.LayoutParams layoutParams) {
		// TODO Auto-generated method stub
		iProxy.addView(view, layoutParams);
	}

	@Override
	public void addView(View view, int left, int top, int right, int bottom) {
		// TODO Auto-generated method stub
		iProxy.addView(view, left, top, right, bottom);
	}

	@Override
	public void addViewBottom(View view, View referenceView) {
		// TODO Auto-generated method stub
		iProxy.addViewBottom(view, referenceView);
	}

	@Override
	public void addViewTop(View view, View referenceView) {
		// TODO Auto-generated method stub
		iProxy.addViewTop(view, referenceView);
	}

	@Override
	public void addViewRigth(View view, View referenceView) {
		// TODO Auto-generated method stub
		iProxy.addViewRigth(view, referenceView);
	}

	@Override
	public void addViewLeft(View view, View referenceView) {
		// TODO Auto-generated method stub
		iProxy.addViewLeft(view, referenceView);
	}

	@Override
	public void remove(View view) {
		// TODO Auto-generated method stub
		iProxy.remove(view);
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		iProxy.clean();
	}

	@Override
	public void addViewRigthBottom(View view, View referenceView) {
		// TODO Auto-generated method stub
		iProxy.addViewRigthBottom(view, referenceView);
	}

	public void setContentView(String layoutName) {
		iProxy.setContentView(layoutName);
	}
}
