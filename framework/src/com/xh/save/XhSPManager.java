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
 * @version ����ʱ�䣺2017-12-25 ����10:06:30 ��Ŀ��repair ������com.xh.util
 *          �ļ�����XhSPManager.java ���ߣ�lhl ˵��:
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
	 * lhl 2017-12-25 ����10:18:45 ˵������ȡbooleanֵ
	 * 
	 * @param keyName
	 *            ��������
	 * @param def
	 *            Ĭ��ֵ
	 * @return boolean
	 */
	public boolean getBoolean(String keyName, boolean def) {
		return sp.getBoolean(keyName, def);
	}

	/**
	 * 
	 * lhl 2017-12-25 ����10:18:45 ˵������ȡbooleanֵ Ĭ��Ϊfalse
	 * 
	 * @param keyName
	 *            ��������
	 * @return boolean
	 */
	public boolean getBoolean(String keyName) {
		return getBoolean(keyName, false);
	}

	/**
	 * 
	 * lhl 2017-12-25 ����10:20:30 ˵������ȡfloatֵ
	 * 
	 * @param keyName
	 *            ����
	 * @param def
	 *            Ĭ��ֵ
	 * @return float
	 */
	public float getFloat(String keyName, float def) {
		return sp.getFloat(keyName, def);
	}

	/**
	 * 
	 * lhl 2017-12-25 ����10:20:30 ˵������ȡfloatֵ Ĭ��Ϊ-1.0f
	 * 
	 * @param keyName
	 *            ����
	 * @return float
	 */
	public float getFloat(String keyName) {
		return getFloat(keyName, -1.0f);
	}

	/**
	 * 
	 * lhl 2017-12-25 ����10:33:37 ˵������ȡintֵ
	 * 
	 * @param keyName
	 *            ����
	 * @param def
	 *            Ĭ��ֵ
	 * @return int
	 */
	public int getInt(String keyName) {
		return getInt(keyName, -1);
	}

	/**
	 * 
	 * lhl 2017-12-25 ����10:33:37 ˵������ȡintֵ Ĭ��Ϊ-1
	 * 
	 * @param keyName
	 *            ����
	 * @return int
	 */
	public int getInt(String keyName, int def) {
		return getInt(keyName, def);
	}

	/**
	 * 
	 * lhl 2017-12-25 ����10:35:34 ˵������ȡlongֵ
	 * 
	 * @param keyName
	 *            ����
	 * @param def
	 *            Ĭ��ֵ
	 * @return long
	 */
	public long getLong(String keyName, long def) {
		return sp.getLong(keyName, def);
	}

	/**
	 * 
	 * lhl 2017-12-25 ����10:35:34 ˵������ȡlongֵĬ��Ϊ-1
	 * 
	 * @param keyName
	 *            ����
	 * @return long
	 */
	public long getLong(String keyName) {
		return sp.getLong(keyName, -1);
	}

	/**
	 * 
	 * lhl 2017-12-25 ����10:37:44 ˵������ȡstringֵ
	 * 
	 * @param keyName
	 *            ����
	 * @param def
	 *            Ĭ��ֵ
	 * @return String
	 */
	public String getString(String keyName, String def) {
		return sp.getString(keyName, def);
	}

	/**
	 * 
	 * lhl 2017-12-25 ����10:37:44 ˵������ȡstringֵ Ĭ��ֵΪ����
	 * 
	 * @param keyName
	 *            ����
	 * @return String
	 */
	public String getString(String keyName) {
		return getString(keyName, "");
	}

	/**
	 * 
	 * lhl 2017-12-25 ����10:39:00 ˵������ȡsetֵ
	 * 
	 * @param keyName
	 *            ����
	 * @param def
	 *            Ĭ��ֵ
	 * @return Set<String>
	 */
	public Set<String> getStringSet(String keyName, Set<String> def) {
		return sp.getStringSet(keyName, def);
	}

	/**
	 * 
	 * lhl 2017-12-25 ����10:39:00 ˵������ȡsetֵ Ĭ��Ϊnull
	 * 
	 * @param keyName
	 *            ����
	 * @return Set<String>
	 */
	public Set<String> getStringSet(String keyName) {
		return sp.getStringSet(keyName, null);
	}

	/**
	 * 
	 * lhl 2017-12-25 ����10:18:45 ˵������������
	 * 
	 * @param keyName
	 *            ��������
	 * @param value
	 *            ֵ
	 */
	public void save(String keyName, boolean value) {
		Editor editor = sp.edit();
		editor.putBoolean(keyName, value);
		editor.commit();
	}
	

	/**
	 * 
	 * lhl 2017-12-25 ����10:18:45 ˵������������
	 * 
	 * @param keyName
	 *            ��������
	 * @param value
	 *            ֵ
	 */
	public void save(String keyName, float value) {
		Editor editor = sp.edit();
		editor.putFloat(keyName, value);
		editor.commit();
	}

	/**
	 * 
	 * lhl 2017-12-25 ����10:18:45 ˵������������
	 * 
	 * @param keyName
	 *            ��������
	 * @param value
	 *            ֵ
	 */
	public void save(String keyName, int value) {
		Editor editor = sp.edit();
		editor.putInt(keyName, value);
		editor.commit();
	}

	/**
	 * 
	 * lhl 2017-12-25 ����10:18:45 ˵������������
	 * 
	 * @param keyName
	 *            ��������
	 * @param value
	 *            ֵ
	 */
	public void save(String keyName, long value) {
		Editor editor = sp.edit();
		editor.putLong(keyName, value);
		editor.commit();
	}

	/**
	 * 
	 * lhl 2017-12-25 ����10:18:45 ˵������������
	 * 
	 * @param keyName
	 *            ��������
	 * @param value
	 *            ֵ
	 */
	public void save(String keyName, String value) {
		Editor editor = sp.edit();
		editor.putString(keyName, value);
		editor.commit();
	}

	/**
	 * 
	 * lhl 2017-12-25 ����10:18:45 ˵������������
	 * 
	 * @param keyName
	 *            ��������
	 * @param value
	 *            ֵ
	 */
	public void save(String keyName, Set<String> value) {
		Editor editor = sp.edit();
		editor.putStringSet(keyName, value);
		editor.commit();
	}
	/**
	 * 
	 * lhl
	 * 2017-12-25 ����12:01:33
	 * ˵����ɾ��
	 * @param key void
	 */
	public void remove(String key){
		Editor editor = sp.edit();
		editor.remove(key);
		editor.commit();
	}

	/**
	 * 
	 * lhl 2017-12-25 ����10:18:45 ˵������������
	 * 
	 * @param keyName
	 *            ��������
	 * @param value
	 *            ֵ
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
	 * lhl 2017-12-25 ����10:06:59 ˵�����޸�sp�ı���·��
	 * 
	 * @param context
	 * @param filePath
	 * @return boolean
	 */
	public static boolean savePreToSDcard(Context context, String filePath) {
		try {
			// ��ȡContextWrapper�����е�mBase�������ñ���������ContextImpl����
			Field field = ContextWrapper.class.getDeclaredField("mBase");
			field.setAccessible(true);
			Object obj = field.get(context);
			// ��ȡContextImpl��mPreferencesDir�������ñ��������������ļ��ı���·��
			field = obj.getClass().getDeclaredField("mPreferencesDir");
			field.setAccessible(true);
			// �����Զ���·��
			File file = new File(filePath);
			// �޸�mPreferencesDir������ֵ
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
	 * lhl 2017-12-25 ����10:12:28 ˵������ȡsp
	 * 
	 * @param textName
	 * @param context
	 * @return SharedPreferences
	 */
	public static SharedPreferences get(String textName, Context context) {
		return context.getSharedPreferences(textName, Context.MODE_PRIVATE);
	}
}
