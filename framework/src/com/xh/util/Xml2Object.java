package com.xh.util;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.xh.paras.NodeTree;
import com.xh.paras.Paras;
import com.xh.paras.ParasFactory;
import com.xh.reflect.ClassManager;
import com.xh.reflect.FieldManager;

/**
 * @version 创建时间：2017-12-21 下午4:21:34 项目：repair 包名：com.xh.util
 *          文件名：Xml2Object.java 作者：lhl 说明:
 */

public class Xml2Object {
	public static Object xml2object(Class cl, InputStream xml) {
		Paras paras = ParasFactory.sax();
		Object object = null;
		try {
			object = ClassManager.new_object(cl);
			List<NodeTree> nodeTrees = paras.paras(xml);
			if (nodeTrees == null || nodeTrees.size() == 0)
				return object;
			if (nodeTrees.size() > 0) {
				for (int i = 0; i < nodeTrees.size(); i++) {
					NodeTree nodeTree = nodeTrees.get(i);
					Field field = FieldManager.field(cl, nodeTree.getName());
					Class fieldClass = field.getType();
					Object object2 = null;
					if (nodeTree.hasChildNodeTrees()) {
						if (fieldClass.getName().indexOf("[L") == 0) {
							object2 = ojects(nodeTree.getChildNodeTrees(),
									fieldClass);
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
								object2 = list(nodeTree.getChildNodeTrees(),
										genericClazz);
							}
						}
					} else {
						object2 = object(nodeTree.getValue(), fieldClass);
					}
					field.set(object, object2);
				}
				return object;
			} else {
				NodeTree nodeTree = nodeTrees.get(0);
				return object(nodeTree, cl);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static List list(List<NodeTree> nodeTrees, Class cl) {
		List list = new ArrayList<>();
		for (NodeTree nodeTree : nodeTrees) {
			if (nodeTree.hasChildNodeTrees())
				list.add(object(nodeTree, cl));
			else {
				String value = nodeTree.getValue();
				list.add(object(value, cl));
			}
		}
		return list;
	}

	private static Object[] ojects(List<NodeTree> nodeTrees, Class cl) {
		Object[] list = new Object[nodeTrees.size()];
		for (int i = 0; i < list.length; i++) {
			NodeTree nodeTree = nodeTrees.get(i);
			if (nodeTree.hasChildNodeTrees())
				list[i] = object(nodeTree, cl);
			else if (nodeTree.getValue() != null) {
				String value = nodeTree.getValue();
				list[i] = object(value, cl);
			}
		}
		return list;
	}

	private static Object object(NodeTree nodeTree, Class cl) {
		try {
			Object object = ClassManager.new_object(cl);
			List<NodeTree> nodeTrees = nodeTree.getChildNodeTrees();
			if (nodeTrees == null || nodeTrees.size() <= 0)
				return null;
			for (NodeTree nodeTree2 : nodeTrees) {
				Field field = FieldManager.field(cl, nodeTree2.getName());
				Object value = null;
				Class fieldClass = field.getType();
				if (nodeTree2.hasChildNodeTrees()) {
					if (fieldClass.getName().indexOf("[L") == 0) {
						value = ojects(nodeTree2.getChildNodeTrees(),
								fieldClass);
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
							value = list(nodeTree2.getChildNodeTrees(),
									genericClazz);
						}
					}
				} else {
					value = object(nodeTree2.getValue(), fieldClass);
				}
				field.set(object, value);
			}
			Map<String, String> map = nodeTree.getAttributes();
			if (map != null && map.size() > 0) {
				Iterator<Entry<String, String>> iterator = map.entrySet()
						.iterator();
				while (iterator.hasNext()) {
					Entry<String, String> entry = iterator.next();
					Field field = FieldManager.field(cl, entry.getKey());
					field.set(object, entry.getValue());
				}
			}
			return object;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static Object object(String value, Class cl) {
		Object object = null;
		if (ClassManager.is_boolean(cl))
			object = Boolean.valueOf(value);
		else if (ClassManager.is_char(cl))
			object = value.charAt(0);
		else if (ClassManager.is_float(cl))
			object = Float.valueOf(value);
		else if (ClassManager.is_integer(cl))
			object = Integer.valueOf(value);
		return object;
	}
}
