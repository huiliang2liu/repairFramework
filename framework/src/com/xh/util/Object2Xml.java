package com.xh.util;

import java.io.FileOutputStream;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Object2Xml {
	/**
	 * map转化为json格式
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static void map_2_xml(Map<String, Object> map, Node node,
			Document document) {
		if (map != null && map.size() > 0) {
			Set<Entry<String, Object>> set = map.entrySet();
			Iterator<Entry<String, Object>> iterator = set.iterator();
			while (iterator.hasNext()) {
				Entry<String, Object> entry = iterator.next();
				Element element = document.createElement(entry.getKey());
				Object object = entry.getValue();
				if (object instanceof Map)
					map_2_xml((Map<String, Object>) object, element, document);
				else if (object instanceof List)
					list_2_xml((List<Object>) object, element, document);
				else if (object instanceof String || object instanceof Float
						|| object instanceof Double
						|| object instanceof Integer || object instanceof Long
						|| object instanceof Boolean)
					element.setTextContent(object.toString());
				else
					object_2_xml(object, element, document);
				node.appendChild(element);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static void list_2_xml(List<Object> list, Node node,
			Document document) {
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Object object = list.get(i);
				Element element = document.createElement("list" + i);
				if (object instanceof Map)
					map_2_xml((Map<String, Object>) object, element, document);
				else if (object instanceof List)
					list_2_xml((List<Object>) object, element, document);
				else if (object instanceof String || object instanceof Float
						|| object instanceof Double
						|| object instanceof Integer || object instanceof Long
						|| object instanceof Boolean)
					element.setTextContent(object.toString());
				else
					object_2_xml(object, element, document);
				node.appendChild(element);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static void objects_2_xml(Object[] list, Node node,
			Document document) {
		if (list != null && list.length > 0) {
			for (int i = 0; i < list.length; i++) {
				Object object = list[i];
				Element element = document.createElement("list" + i);
				if (object instanceof Map)
					map_2_xml((Map<String, Object>) object, element, document);
				else if (object instanceof List)
					list_2_xml((List<Object>) object, element, document);
				else if (object instanceof String || object instanceof Float
						|| object instanceof Double
						|| object instanceof Integer || object instanceof Long
						|| object instanceof Boolean)
					element.setTextContent(object.toString());
				else
					object_2_xml(object, element, document);
				node.appendChild(element);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static String object_2_xml(Object object) {
		if (object == null)
			return "===";
		try {
			DocumentBuilder documentBuilder = DocumentBuilderFactory
					.newInstance().newDocumentBuilder();
			TransformerFactory transFactory = TransformerFactory.newInstance();// 取得TransformerFactory实例
			Transformer transformer = transFactory.newTransformer(); // 从transFactory获取Transformer实例
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); // 设置输出采用的编码方式
			transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // 是否自动添加额外的空白
			transformer
					.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no"); // 是否忽略XML声明
			Document document = documentBuilder.newDocument();
			if (object instanceof Map) {
				Element element = document.createElement("map");
				map_2_xml((Map<String, Object>) object, element, document);
				document.appendChild(element);
			} else if (object instanceof List) {
				Element element = document.createElement("list");
				list_2_xml((List<Object>) object, element, document);
				document.appendChild(element);
			} else if (object.getClass().getName().indexOf("[L") == 0) {
				Element element = document.createElement("list");
				objects_2_xml((Object[]) object, element, document);
				document.appendChild(element);
			} else {
				Class c = object.getClass();
				Field[] fields = c.getDeclaredFields();
				Element elementa = document.createElement(c.getName());
				if (fields != null && fields.length > 0) {
					for (int i = 0; i < fields.length; i++) {
						Field field = fields[i];
						field.setAccessible(true);
						if (field.getName().contains("this$"))
							continue;
						Element element = document.createElement(field
								.getName());
						Object object2 = field.get(object);
						if (object2 instanceof Map)
							map_2_xml((Map<String, Object>) object2, element,
									document);
						else if (object2 instanceof List)
							list_2_xml((List<Object>) object2, element,
									document);
						else if (object2 instanceof String
								|| object2 instanceof Float
								|| object2 instanceof Double
								|| object2 instanceof Integer
								|| object2 instanceof Long
								|| object2 instanceof Boolean)
							element.setTextContent(field.get(object).toString());
						else
							object_2_xml(object2, element, document);
						elementa.appendChild(element);
					}
					document.appendChild(elementa);
				}
			}
			Source source = new DOMSource(document); // 表明文档来源是doc
			StringWriter writer = new StringWriter();
			Result result = new StreamResult(writer);// 表明目标结果为writer
			transformer.transform(source, result); // 开始转换
			return writer.toString();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "";
	}

	private static void object_2_xml(Object object, Node node, Document document) {
		// TODO Auto-generated method stub
		try {
			if (object.getClass().getName().indexOf("[L") == 0) {
				objects_2_xml((Object[]) object, node, document);
				return;
			}
			Class c = object.getClass();
			Field[] fields = c.getDeclaredFields();
			if (fields != null && fields.length > 0) {
				for (int i = 0; i < fields.length; i++) {
					Field field = fields[i];
					field.setAccessible(true);
					if (field.getName().contains("this$"))
						continue;
					Element element = document.createElement(field.getName());
					Object object2 = field.get(object);
					if (object2 instanceof Map)
						map_2_xml((Map<String, Object>) object2, element,
								document);
					else if (object2 instanceof List)
						list_2_xml((List<Object>) object2, element, document);
					else if (object2 instanceof String
							|| object2 instanceof Float
							|| object2 instanceof Double
							|| object2 instanceof Integer
							|| object2 instanceof Long
							|| object2 instanceof Boolean)
						element.setTextContent(field.get(object).toString());
					else
						object_2_xml(object2, element, document);
					node.appendChild(element);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			// Map<String, Object> map=new HashMap<String, Object>();
			FileOutputStream fos = new FileOutputStream("G:/me/text.txt");
			long l = 100000l;
			for (long i = 0; i < l; i++) {
				String s = null;
				if (i == 0) {
					s = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><map_>";
				} else if (i == l - 1) {
					s = "</map_>";
				} else {
					s = "<list_9>list9</list_9>";
				}
				System.out.println(s);
				fos.write(s.getBytes());
			}
			fos.flush();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
