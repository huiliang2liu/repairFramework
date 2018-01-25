package com.xh.util;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Object2Json {
	/**
	 * map转化为json格式
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String map_2_json(Map<String, Object> map) {
		StringBuffer sb = new StringBuffer("{");
		if (map != null && map.size() > 0) {
			Set<String> set = map.keySet();
			Iterator<String> iterator = set.iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				sb.append("\"").append(key).append("\":");
				Object object = map.get(key);
				if (object instanceof Map)
					sb.append(map_2_json((Map<String, Object>) object));
				else if (object instanceof List)
					sb.append(list_2_json((List<Object>) object));
				else if (object instanceof String)
					sb.append("\"").append(object).append("\"");
				else if (object instanceof Integer || object instanceof Long
						|| object instanceof Boolean || object instanceof Float
						|| object instanceof Double)
					sb.append(object);
				else
					sb.append(object_2_json(object));
				sb.append(",");
			}
		}
		sb.delete(sb.length() - 1, sb.length());
		sb.append("}");
		return sb.toString();
	}

	public static String list_2_json(List<Object> list) {
		StringBuffer sb = new StringBuffer("[");
		if (list != null && list.size() > 0) {
			for (Object object : list) {
				if (object instanceof Map)
					sb.append(map_2_json((Map<String, Object>) object));
				else if (object instanceof List)
					sb.append(list_2_json((List<Object>) object));
				else if (object instanceof String)
					sb.append("\"").append(object).append("\"");
				else if (object instanceof Integer || object instanceof Long
						|| object instanceof Boolean || object instanceof Float
						|| object instanceof Double)
					sb.append(object);
				else
					sb.append(object_2_json(object));
				sb.append(",");
			}
		}
		sb.delete(sb.length() - 1, sb.length());
		sb.append("]");
		return sb.toString();
	}

	public static String objects_2_json(Object[] list) {
		StringBuffer sb = new StringBuffer("[");
		if (list != null && list.length > 0) {
			for (Object object : list) {
				if (object instanceof Map)
					sb.append(map_2_json((Map<String, Object>) object));
				else if (object instanceof List)
					sb.append(list_2_json((List<Object>) object));
				else if (object instanceof String)
					sb.append("\"").append(object).append("\"");
				else if (object instanceof Integer || object instanceof Long
						|| object instanceof Boolean || object instanceof Float
						|| object instanceof Double)
					sb.append(object);
				else
					sb.append(object_2_json(object));
				sb.append(",");
			}
		}
		sb.delete(sb.length() - 1, sb.length());
		sb.append("]");
		return sb.toString();
	}

	public static String object_2_json(Object object) {
		if (object == null)
			return "";
		try {
			if (object instanceof Map)
				return map_2_json((Map<String, Object>) object);
			if (object instanceof List)
				return list_2_json((List<Object>) object);
			StringBuffer sb = new StringBuffer("{");
			Class c = object.getClass();
			Field[] fields = c.getDeclaredFields();
			if (fields != null && fields.length > 0) {
				for (int i = 0; i < fields.length; i++) {
					Field field = fields[i];
					field.setAccessible(true);
					if (field.getName().equals("this$0"))
						continue;
					sb.append("\"").append(field.getName()).append("\"")
							.append(":");
					Object object2 = field.get(object);
					if (object2 == null) {
						if (Map.class.isAssignableFrom(field.getType()))
							sb.append(map_2_json((Map<String, Object>) object2));
						else if (List.class.isAssignableFrom(field.getType()))
							sb.append(list_2_json((List<Object>) object2));
						else
							sb.append("\"null\"");
					} else if (object2 instanceof Map)
						sb.append(map_2_json((Map<String, Object>) object2));
					else if (object2 instanceof List)
						sb.append(list_2_json((List<Object>) object2));
					else if (object2 instanceof String
							) {
						sb.append("\"").append(object2).append("\"");
					} else if (object2 instanceof Integer
							|| object2 instanceof Long
							|| object2 instanceof Boolean|| object2 instanceof Float
							|| object2 instanceof Double)
						sb.append(object2);
					else if (object2.getClass().getName().indexOf("[L") == 0) {
						sb.append(objects_2_json((Object[]) object2));
					} else
						sb.append(object_2_json(object2));
					sb.append(",");
				}
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("}");
			return sb.toString();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
}
