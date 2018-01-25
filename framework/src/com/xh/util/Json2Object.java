package com.xh.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.xh.reflect.ClassManager;

public class Json2Object {
	public static Object string2object(Class c, String string) {
		try {
			return JSONObject2Object(c, new JSONObject(string));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static Object JSONObject2Object(Class c, JSONObject jo) {
		try {
			if (c == null || jo == null || jo.length() == 0)
				return null;
			Object t = ClassManager.new_object(c);
			Field[] fields = c.getDeclaredFields();
			if (fields != null || fields.length > 0) {
				for (Field field : fields) {
					if (!field.isAccessible())
						field.setAccessible(true);
					if (is_final(field.getModifiers()))
						continue;
					Object object = get_key(jo, field.getName());
					if (object == null)
						continue;
					if (object instanceof JSONObject) {
						field.set(
								t,
								JSONObject2Object(field.getType(),
										(JSONObject) object));
					} else if (object instanceof JSONArray) {
						String typeClassName = field.getType().getName();
						Object object2 = null;
						JSONArray ja = (JSONArray) object;
						if (c.getName().indexOf("[L") == 0) {
							object2 = jSONArray2objects(
									Class.forName(c.getName().substring(2,
											c.getName().length())), ja);
						} else {
							Type genericType = field.getGenericType();
							if (genericType == null)
								continue;
							// 如果是泛型参数的类型
							if (genericType instanceof ParameterizedType) {
								ParameterizedType pt = (ParameterizedType) genericType;
								// 得到泛型里的class类型对象
								Class<?> genericClazz = (Class<?>) pt
										.getActualTypeArguments()[0];
								object2 = jSONArray2list(genericClazz, ja);
							}
						}

						field.set(t, object2);
					} else {
						Class fieldClass = field.getType();
						if (ClassManager.is_float(fieldClass))
							object = Float.valueOf(object.toString());
						field.set(t, object);
					}
				}
			}
			return t;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static List jSONArray2list(Class c, JSONArray ja) {
		if (c == null || ja == null || ja.length() == 0)
			return null;
		ArrayList list = new ArrayList();
		for (int i = 0; i < ja.length(); i++) {
			Object object;
			try {
				object = ja.get(i);
				if (object instanceof JSONObject)
					list.add(JSONObject2Object(c, (JSONObject) object));
				else
					list.add(object);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public static Object[] jSONArray2objects(Class c, JSONArray ja) {
		if (c == null || ja == null || ja.length() == 0)
			return null;
		Object[] list = new Object[ja.length()];
		for (int i = 0; i < ja.length(); i++) {
			Object object;
			try {
				object = ja.get(i);
				if (object instanceof JSONObject)
					list[i] = JSONObject2Object(c, (JSONObject) object);
				else
					list[i] = object;
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public static Object get_key(JSONObject jo, String key) {
		try {
			return jo.get(key);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 是否被static修饰
	 * 
	 * @param modifiers
	 * @return
	 */
	public static boolean is_final(int modifiers) {
		return Modifier.isFinal(modifiers);
	}

	/**
	 * 判断是否为boolean类型
	 * 
	 * @param cl
	 * @return
	 */
	public static boolean is_boolean(Class cl) {
		return Boolean.class.isAssignableFrom(cl)
				|| boolean.class.isAssignableFrom(cl);
	}

	/**
	 * 判断整型
	 * 
	 * @param cl
	 * @return
	 */
	public static boolean is_integer(Class cl) {
		return Byte.class.isAssignableFrom(cl)
				|| byte.class.isAssignableFrom(cl)
				|| Short.class.isAssignableFrom(cl)
				|| short.class.isAssignableFrom(cl)
				|| Integer.class.isAssignableFrom(cl)
				|| int.class.isAssignableFrom(cl)
				|| Long.class.isAssignableFrom(cl)
				|| long.class.isAssignableFrom(cl);
	}

	/**
	 * 判断浮点型
	 * 
	 * @param cl
	 * @return
	 */
	public static boolean is_float(Class cl) {
		return Float.class.isAssignableFrom(cl)
				|| float.class.isAssignableFrom(cl)
				|| Double.class.isAssignableFrom(cl)
				|| double.class.isAssignableFrom(cl);
	}

	/**
	 * 判断是是否为字符
	 * 
	 * @param cl
	 * @return
	 */
	public static boolean is_char(Class cl) {
		return Character.class.isAssignableFrom(cl)
				|| char.class.isAssignableFrom(cl);
	}
}
