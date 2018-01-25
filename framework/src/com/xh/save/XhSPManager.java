package com.xh.save;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * @version 创建时间：2017-12-25 上午10:06:30 项目：repair 包名：com.xh.util
 *          文件名：XhSPManager.java 作者：lhl 说明:
 */

public class XhSPManager {
	private SharedPreferences sp;

	public XhSPManager(SharedPreferences sp) {
		// TODO Auto-generated constructor stub
		this.sp = sp;
	}

	public XhSPManager(Context context) {
		this(get(context.getPackageName().replaceAll(".", "_"), context));
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:18:45 说明：获取boolean值
	 * 
	 * @param keyName
	 *            键的名字
	 * @param def
	 *            默认值
	 * @return boolean
	 */
	public boolean getBoolean(String keyName, boolean def) {
		return sp.getBoolean(keyName, def);
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:18:45 说明：获取boolean值 默认为false
	 * 
	 * @param keyName
	 *            键的名字
	 * @return boolean
	 */
	public boolean getBoolean(String keyName) {
		return getBoolean(keyName, false);
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:20:30 说明：获取float值
	 * 
	 * @param keyName
	 *            键名
	 * @param def
	 *            默认值
	 * @return float
	 */
	public float getFloat(String keyName, float def) {
		return sp.getFloat(keyName, def);
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:20:30 说明：获取float值 默认为-1.0f
	 * 
	 * @param keyName
	 *            键名
	 * @return float
	 */
	public float getFloat(String keyName) {
		return getFloat(keyName, -1.0f);
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:33:37 说明：获取int值
	 * 
	 * @param keyName
	 *            键名
	 * @param def
	 *            默认值
	 * @return int
	 */
	public int getInt(String keyName) {
		return getInt(keyName, -1);
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:33:37 说明：获取int值 默认为-1
	 * 
	 * @param keyName
	 *            键名
	 * @return int
	 */
	public int getInt(String keyName, int def) {
		return getInt(keyName, def);
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:35:34 说明：获取long值
	 * 
	 * @param keyName
	 *            键名
	 * @param def
	 *            默认值
	 * @return long
	 */
	public long getLong(String keyName, long def) {
		return sp.getLong(keyName, def);
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:35:34 说明：获取long值默认为-1
	 * 
	 * @param keyName
	 *            键名
	 * @return long
	 */
	public long getLong(String keyName) {
		return sp.getLong(keyName, -1);
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:37:44 说明：获取string值
	 * 
	 * @param keyName
	 *            键名
	 * @param def
	 *            默认值
	 * @return String
	 */
	public String getString(String keyName, String def) {
		return sp.getString(keyName, def);
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:37:44 说明：获取string值 默认值为“”
	 * 
	 * @param keyName
	 *            键名
	 * @return String
	 */
	public String getString(String keyName) {
		return getString(keyName, "");
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:39:00 说明：获取set值
	 * 
	 * @param keyName
	 *            键名
	 * @param def
	 *            默认值
	 * @return Set<String>
	 */
	public Set<String> getStringSet(String keyName, Set<String> def) {
		return sp.getStringSet(keyName, def);
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:39:00 说明：获取set值 默认为null
	 * 
	 * @param keyName
	 *            键名
	 * @return Set<String>
	 */
	public Set<String> getStringSet(String keyName) {
		return sp.getStringSet(keyName, null);
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:18:45 说明：保存数据
	 * 
	 * @param keyName
	 *            键的名字
	 * @param value
	 *            值
	 */
	public void save(String keyName, boolean value) {
		Editor editor = sp.edit();
		editor.putBoolean(keyName, value);
		editor.commit();
	}
	

	/**
	 * 
	 * lhl 2017-12-25 上午10:18:45 说明：保存数据
	 * 
	 * @param keyName
	 *            键的名字
	 * @param value
	 *            值
	 */
	public void save(String keyName, float value) {
		Editor editor = sp.edit();
		editor.putFloat(keyName, value);
		editor.commit();
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:18:45 说明：保存数据
	 * 
	 * @param keyName
	 *            键的名字
	 * @param value
	 *            值
	 */
	public void save(String keyName, int value) {
		Editor editor = sp.edit();
		editor.putInt(keyName, value);
		editor.commit();
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:18:45 说明：保存数据
	 * 
	 * @param keyName
	 *            键的名字
	 * @param value
	 *            值
	 */
	public void save(String keyName, long value) {
		Editor editor = sp.edit();
		editor.putLong(keyName, value);
		editor.commit();
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:18:45 说明：保存数据
	 * 
	 * @param keyName
	 *            键的名字
	 * @param value
	 *            值
	 */
	public void save(String keyName, String value) {
		Editor editor = sp.edit();
		editor.putString(keyName, value);
		editor.commit();
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:18:45 说明：保存数据
	 * 
	 * @param keyName
	 *            键的名字
	 * @param value
	 *            值
	 */
	public void save(String keyName, Set<String> value) {
		Editor editor = sp.edit();
		editor.putStringSet(keyName, value);
		editor.commit();
	}
	/**
	 * 
	 * lhl
	 * 2017-12-25 下午12:01:33
	 * 说明：删除
	 * @param key void
	 */
	public void remove(String key){
		Editor editor = sp.edit();
		editor.remove(key);
		editor.commit();
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:18:45 说明：保存数据
	 * 
	 * @param keyName
	 *            键的名字
	 * @param value
	 *            值
	 */
	public void save(Map<String, Object> maps) {
		Editor editor = sp.edit();
		Set<Entry<String, Object>> entrys = maps.entrySet();
		Iterator<Entry<String, Object>> iterator = entrys.iterator();
		while (iterator.hasNext()) {
			Entry<String, Object> entry = iterator.next();
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value instanceof Boolean)
				editor.putBoolean(key, (boolean) value);
			else if (value instanceof Float)
				editor.putFloat(key, (float) value);
			else if (value instanceof Integer)
				editor.putInt(key, (int) value);
			else if (value instanceof Long)
				editor.putLong(key, (long) value);
			else if (value instanceof String)
				editor.putString(key, (String) value);
			else
				editor.putStringSet(key, (Set<String>) value);
		}
		editor.commit();
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:06:59 说明：修改sp的保存路径
	 * 
	 * @param context
	 * @param filePath
	 * @return boolean
	 */
	public static boolean savePreToSDcard(Context context, String filePath) {
		try {
			// 获取ContextWrapper对象中的mBase变量。该变量保存了ContextImpl对象
			Field field = ContextWrapper.class.getDeclaredField("mBase");
			field.setAccessible(true);
			Object obj = field.get(context);
			// 获取ContextImpl。mPreferencesDir变量，该变量保存了数据文件的保存路径
			field = obj.getClass().getDeclaredField("mPreferencesDir");
			field.setAccessible(true);
			// 创建自定义路径
			File file = new File(filePath);
			// 修改mPreferencesDir变量的值
			field.set(obj, file);
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * lhl 2017-12-25 上午10:12:28 说明：获取sp
	 * 
	 * @param textName
	 * @param context
	 * @return SharedPreferences
	 */
	public static SharedPreferences get(String textName, Context context) {
		return context.getSharedPreferences(textName, Context.MODE_PRIVATE);
	}
}
