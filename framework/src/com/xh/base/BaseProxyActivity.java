package com.xh.base;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Animation;

import com.xh.ifaces.ILoad;
import com.xh.ifaces.IViewAnnotation;
import com.xh.util.Constants;

/**
 * @version 创建时间：2017-12-8 上午10:49:59 项目：repair 包名：com.xh.base
 *          文件名：BaseProxyActivity.java 作者：lhl 说明:
 */

public class BaseProxyActivity extends XhBaseActivity implements ILoad {
	private final static String TAG = BaseProxyActivity.class.getName();
	private BasePluginActivity iPlugin;

	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.Theme_Light_NoTitleBar);
		try {
			String className = getIntent().getStringExtra(Constants.CLASS_NAME);
			iPlugin = (BasePluginActivity) Class.forName(className)
					.newInstance();
			iPlugin.onCreate(this);
		} catch (Exception e) {
			// TODO: handle exception

		}
		super.onCreate(savedInstanceState);
		if (iPlugin != null) {
			iPlugin.onCreate(savedInstanceState);
		}
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		if (iPlugin != null && iPlugin.onCreateOptionsMenu(menu))
			return iPlugin.onCreateOptionsMenu(menu);
		return super.onCreateOptionsMenu(menu);

	}

	@Override
	public View getView(String name, Context context) {
		// TODO Auto-generated method stub
		return load.getView(name, context);
	}

	@Override
	public View getView(Resources resources, String packageName, String name,
			Context context) {
		// TODO Auto-generated method stub
		return load.getView(resources, packageName, name, context);
	}

	@Override
	public View getView(int layoutId, Context context) {
		// TODO Auto-generated method stub
		return load.getView(layoutId, context);
	}

	@Override
	public View getView(Resources resources, int layoutId, Context context) {
		// TODO Auto-generated method stub
		return load.getView(resources, layoutId, context);
	}

	@Override
	public Animation getAnimation(String name, Context context) {
		// TODO Auto-generated method stub
		return load.getAnimation(name, context);
	}

	@Override
	public Animation getAnimation(Resources resources, String packageName,
			String name, Context context) {
		// TODO Auto-generated method stub
		return load.getAnimation(resources, packageName, name, context);
	}

	@Override
	public int style(String name) {
		// TODO Auto-generated method stub
		return load.style(name);
	}

	@Override
	public int style(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return load.style(name, resources, packageName);
	}

	@Override
	public int dimen(String name) {
		// TODO Auto-generated method stub
		return load.dimen(name);
	}

	@Override
	public int dimen(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return load.dimen(name, resources, packageName);
	}

	@Override
	public int color(String name) {
		// TODO Auto-generated method stub
		return load.color(name);
	}

	@Override
	public int colorValue(String name) {
		// TODO Auto-generated method stub
		return load.colorValue(name);
	}

	@Override
	public ColorStateList colorList(String name) {
		// TODO Auto-generated method stub
		return load.colorList(name);
	}

	@Override
	public int colorValue(int colorId) {
		// TODO Auto-generated method stub
		return load.colorValue(colorId);
	}

	@Override
	public ColorStateList colorList(int colorId) {
		// TODO Auto-generated method stub
		return load.colorList(colorId);
	}

	@Override
	public int color(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return load.color(name, resources, packageName);
	}

	@Override
	public int colorValue(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return load.colorValue(name, resources, packageName);
	}

	@Override
	public ColorStateList colorList(String name, Resources resources,
			String packageName) {
		// TODO Auto-generated method stub
		return load.colorList(name, resources, packageName);
	}

	@Override
	public int colorValue(int colorId, Resources resources) {
		// TODO Auto-generated method stub
		return load.colorValue(colorId, resources);
	}

	@Override
	public ColorStateList colorList(int colorId, Resources resources) {
		// TODO Auto-generated method stub
		return load.colorList(colorId, resources);
	}

	@Override
	public int anim(String name) {
		// TODO Auto-generated method stub
		return load.anim(name);
	}

	@Override
	public int anim(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return load.anim(name, resources, packageName);
	}

	@Override
	public int raw(String name) {
		// TODO Auto-generated method stub
		return load.raw(name);
	}

	@Override
	public int raw(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return load.raw(name, resources, packageName);
	}

	@Override
	public int attr(String name) {
		// TODO Auto-generated method stub
		return load.attr(name);
	}

	@Override
	public int attr(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return load.attr(name, resources, packageName);
	}

	@Override
	public int string(String name) {
		// TODO Auto-generated method stub
		return load.string(name);
	}

	@Override
	public String stringValue(String name) {
		// TODO Auto-generated method stub
		return load.stringValue(name);
	}

	@Override
	public String[] stringValues(String name) {
		// TODO Auto-generated method stub
		return load.stringValues(name);
	}

	@Override
	public String stringValue(int stringId) {
		// TODO Auto-generated method stub
		return load.stringValue(stringId);
	}

	@Override
	public String[] stringValues(int stringId) {
		// TODO Auto-generated method stub
		return load.stringValues(stringId);
	}

	@Override
	public int string(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return load.string(name, resources, packageName);
	}

	@Override
	public String stringValue(String name, Resources resources,
			String packageName) {
		// TODO Auto-generated method stub
		return load.stringValue(name, resources, packageName);
	}

	@Override
	public String[] stringValues(String name, Resources resources,
			String packageName) {
		// TODO Auto-generated method stub
		return load.stringValues(name, resources, packageName);
	}

	@Override
	public String stringValue(int stringId, Resources resources) {
		// TODO Auto-generated method stub
		return load.stringValue(stringId, resources);
	}

	@Override
	public String[] stringValues(int stringId, Resources resources) {
		// TODO Auto-generated method stub
		return load.stringValues(stringId, resources);
	}

	@Override
	public int id(String name) {
		// TODO Auto-generated method stub
		return load.id(name);
	}

	@Override
	public int id(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return load.id(name, resources, packageName);
	}

	@Override
	public int drawable(String name) {
		// TODO Auto-generated method stub
		return load.drawable(name);
	}

	@Override
	public Drawable drawableValue(String name) {
		// TODO Auto-generated method stub
		return load.drawableValue(name);
	}

	@Override
	public int drawable(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return load.drawable(name, resources, packageName);
	}

	@Override
	public Drawable drawableValue(int drawableId, Resources resources) {
		// TODO Auto-generated method stub
		return load.drawableValue(drawableId, resources);
	}

	@Override
	public Drawable drawableValue(String name, Resources resources,
			String packageName) {
		// TODO Auto-generated method stub
		return load.drawableValue(name, resources, packageName);
	}

	@Override
	public int layout(String name) {
		// TODO Auto-generated method stub
		return load.layout(name);
	}

	@Override
	public int layout(String name, Resources resources, String packageName) {
		// TODO Auto-generated method stub
		return load.layout(name, resources, packageName);
	}

	@Override
	public int name2id(String name, String type) {
		// TODO Auto-generated method stub
		return load.name2id(name, type);
	}

	@Override
	public int name2id(Resources resources, String name, String type,
			String packageName) {
		// TODO Auto-generated method stub
		return load.name2id(resources, name, type, packageName);
	}

	@Override
	public Resources package2resources(String packageName) {
		// TODO Auto-generated method stub
		return load.package2resources(packageName);
	}

	@Override
	public AssetManager package2assetManager(String packageName) {
		// TODO Auto-generated method stub
		return load.package2assetManager(packageName);
	}

	@Override
	public PackageInfo package2packageInfo(String packageName) {
		// TODO Auto-generated method stub
		return load.package2packageInfo(packageName);
	}

	@Override
	public Theme package2theme(String packageName) {
		// TODO Auto-generated method stub
		return load.package2theme(packageName);
	}

	@Override
	public Animation getAnimation(int animId, Context context) {
		// TODO Auto-generated method stub
		return load.getAnimation(animId, context);
	}

	@Override
	public Animation getAnimation(Resources resources, int animId,
			Context context) {
		// TODO Auto-generated method stub
		return load.getAnimation(resources, animId, context);
	}

	@Override
	public boolean onCreatePanelMenu(int arg0, Menu arg1) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onCreatePanelMenu(arg0, arg1);
		return super.onCreatePanelMenu(arg0, arg1);
	}

	@Override
	public View onCreatePanelView(int featureId) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onCreatePanelView(featureId);
		return super.onCreatePanelView(featureId);
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onMenuOpened(featureId, menu);
		return super.onMenuOpened(featureId, menu);
	}

	@Override
	public boolean onPreparePanel(int arg0, View arg1, Menu arg2) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onPreparePanel(arg0, arg1, arg2);
		return super.onPreparePanel(arg0, arg1, arg2);
	}

	@Override
	public boolean onSearchRequested() {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onSearchRequested();
		return super.onSearchRequested();
	}

	@Override
	public ActionMode onWindowStartingActionMode(Callback callback) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onWindowStartingActionMode(callback);
		return super.onWindowStartingActionMode(callback);
	}

	@Override
	public void closeContextMenu() {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.closeContextMenu();
		super.closeContextMenu();
	}

	@Override
	public void closeOptionsMenu() {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.closeOptionsMenu();
		super.closeOptionsMenu();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onConfigurationChanged(newConfig);
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onContextItemSelected(item);
		return super.onContextItemSelected(item);
	}

	@Override
	public void onContextMenuClosed(Menu menu) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onContextMenuClosed(menu);
		super.onContextMenuClosed(menu);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onCreateContextMenu(menu, v, menuInfo);
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public void openContextMenu(View view) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.openContextMenu(view);
		super.openContextMenu(view);
	}

	@Override
	public void openOptionsMenu() {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.openOptionsMenu();
		super.openOptionsMenu();
	}

	@Override
	protected Object receiver() {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			return iPlugin.receiver();
		return super.receiver();
	}

	@Override
	public IViewAnnotation getViewAnnotation() {
		if (iPlugin != null)
			return iPlugin.getViewAnnotation();
		return super.getViewAnnotation();
	}

	@Override
	protected String packageName() {
		// TODO Auto-generated method stub
		if (iPlugin != null) {
			return iPlugin.packageName();
		}
		return super.packageName();
	}

	@Override
	protected void noNetwork() {
		// TODO Auto-generated method stub
		if (iPlugin != null) {
			iPlugin.noNetwork();
		}
		super.noNetwork();
	}

	@Override
	protected void network() {
		// TODO Auto-generated method stub
		if (iPlugin != null) {
			iPlugin.network();
		}
		super.network();
	}

	@Override
	protected int color() {
		// TODO Auto-generated method stub
		if (iPlugin != null) {
			return iPlugin.color();
		}
		return super.color();
	}

	@Override
	protected int exitAnim() {
		// TODO Auto-generated method stub
		if (iPlugin != null) {
			return iPlugin.color();
		}
		return super.exitAnim();
	}

	@Override
	protected int enterAnim() {
		// TODO Auto-generated method stub
		if (iPlugin != null) {
			return iPlugin.enterAnim();
		}
		return super.enterAnim();
	}

	@Override
	protected int layout() {
		// TODO Auto-generated method stub
		if (iPlugin != null) {
			return iPlugin.layout();
		}
		return super.layout();
	}

	@Override
	protected String layoutName() {
		// TODO Auto-generated method stub
		if (iPlugin != null) {
			return iPlugin.layoutName();
		}
		return super.layoutName();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (iPlugin != null)
			iPlugin.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onBackPressed();
		else
			super.onBackPressed();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		if (iPlugin != null)
			iPlugin.onStart();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		if (iPlugin != null)
			iPlugin.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if (iPlugin != null)
			iPlugin.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if (iPlugin != null)
			iPlugin.onPause();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		if (iPlugin != null)
			iPlugin.onStop();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (iPlugin != null)
			iPlugin.onDestroy();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		if (iPlugin != null)
			iPlugin.onSaveInstanceState(outState);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
		if (iPlugin != null)
			iPlugin.onNewIntent(intent);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		if (iPlugin != null)
			iPlugin.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onTouchEvent(event);
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onKeyUp(keyCode, event);
		return super.onKeyUp(keyCode, event);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onKeyDown(keyCode, event);
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onLowMemory();
		super.onLowMemory();
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onMenuItemSelected(featureId, item);
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public void onPanelClosed(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onPanelClosed(featureId, menu);
		super.onPanelClosed(featureId, menu);
	}

	@Override
	protected void onPostResume() {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onPostResume();
		super.onPostResume();
	}

	@Override
	public boolean dispatchGenericMotionEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.dispatchGenericMotionEvent(ev);
		return super.dispatchGenericMotionEvent(ev);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.dispatchKeyEvent(event);
		return super.dispatchKeyEvent(event);
	}

	@Override
	public boolean dispatchKeyShortcutEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.dispatchKeyShortcutEvent(event);
		return super.dispatchKeyShortcutEvent(event);
	}

	@Override
	public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.dispatchPopulateAccessibilityEvent(event);
		return super.dispatchPopulateAccessibilityEvent(event);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.dispatchTouchEvent(ev);
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public boolean dispatchTrackballEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.dispatchTrackballEvent(ev);
		return super.dispatchTrackballEvent(ev);
	}

	@Override
	public void onAttachedToWindow() {
		// TODO Auto-generated method stub
		super.onAttachedToWindow();
		if (iPlugin != null)
			iPlugin.onAttachedToWindow();
	}

	@Override
	public void onContentChanged() {
		// TODO Auto-generated method stub
		super.onContentChanged();
		if (iPlugin != null)
			iPlugin.onContentChanged();
	}

	@Override
	public void onDetachedFromWindow() {
		// TODO Auto-generated method stub
		super.onDetachedFromWindow();
		if (iPlugin != null)
			iPlugin.onDetachedFromWindow();
	}

	@Override
	public boolean onGenericMotionEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onGenericMotionEvent(event);
		return super.onGenericMotionEvent(event);
	}

	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onKeyLongPress(keyCode, event);
		return super.onKeyLongPress(keyCode, event);
	}

	@Override
	public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onKeyMultiple(keyCode, repeatCount, event);
		return super.onKeyMultiple(keyCode, repeatCount, event);
	}

	@Override
	public boolean onKeyShortcut(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onKeyShortcut(keyCode, event);
		return super.onKeyShortcut(keyCode, event);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onOptionsItemSelected(item);
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		// TODO Auto-generated method stub
		super.onOptionsMenuClosed(menu);
		if (iPlugin != null)
			iPlugin.onOptionsMenuClosed(menu);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		if (iPlugin != null)
			iPlugin.onPostCreate(savedInstanceState);
	}

	@Override
	protected void onTitleChanged(CharSequence title, int color) {
		// TODO Auto-generated method stub
		super.onTitleChanged(title, color);
		if (iPlugin != null)
			iPlugin.onTitleChanged(title, color);
	}

	@Override
	public boolean onTrackballEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if (iPlugin != null)
			iPlugin.onTrackballEvent(event);
		return super.onTrackballEvent(event);
	}

	@Override
	public void onTrimMemory(int level) {
		// TODO Auto-generated method stub
		super.onTrimMemory(level);
		if (iPlugin != null)
			iPlugin.onTrimMemory(level);
	}

	@Override
	public void onWindowAttributesChanged(LayoutParams params) {
		// TODO Auto-generated method stub
		super.onWindowAttributesChanged(params);
		if (iPlugin != null)
			iPlugin.onWindowAttributesChanged(params);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		if (iPlugin != null)
			iPlugin.onWindowFocusChanged(hasFocus);
	}
}
