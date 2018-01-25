package com.xh.save;

import java.util.List;

import com.xh.util.XhLog;

/**
 * @version ����ʱ�䣺2017-12-25 ����3:21:11 ��Ŀ��repair ������com.xh.save �ļ�����DBEnt.java
 *          ���ߣ�lhl ˵��:
 */

public class DBTableEntity {
	// public String name;// �ֶ���
	// public String type;// ����
	// public int lon = 20;// ���� �涨���λ��
	// public String embellish="";// ����
	// public int significant = 20;// �涨С�����Ҳ�����λ��
	String string;
	public String key;
	public Object value;

	private DBTableEntity() {
		// TODO Auto-generated constructor stub
	}

	public DBTableEntity(String key, Object value) {
		// TODO Auto-generated constructor stub
		this.key = key;
		this.value = value;
	}

	public static DBTableEntity integer(String name) {
		DBTableEntity entity = new DBTableEntity();
		StringBuffer sb = new StringBuffer("").append(name).append(" ")
				.append(DBContants.INTEGER).append(" ");
		entity.string = sb.toString();
		return entity;
	}

	public static DBTableEntity integer(String name, String embellish) {
		DBTableEntity entity = new DBTableEntity();
		StringBuffer sb = new StringBuffer("").append(name).append(" ")
				.append(DBContants.INTEGER).append(" ").append(embellish)
				.append(" ");
		entity.string = sb.toString();
		return entity;
	}

	public static DBTableEntity integer(String name, List<String> embellishs) {
		DBTableEntity entity = new DBTableEntity();
		StringBuffer sb = new StringBuffer("").append(name).append(" ")
				.append(DBContants.INTEGER).append(" ");
		for (int i = 0; i < embellishs.size(); i++) {
			sb.append(embellishs.get(i)).append(" ");
		}
		entity.string = sb.toString();
		return entity;
	}

	public static DBTableEntity string(String name, String maxLen) {
		DBTableEntity entity = new DBTableEntity();
		StringBuffer sb = new StringBuffer("").append(name).append(" ")
				.append(DBContants.VARCHAR.replace("size", maxLen)).append(" ");
		entity.string = sb.toString();
		return entity;
	}

	public static DBTableEntity string(String name, String maxLen,
			String embellish) {
		DBTableEntity entity = new DBTableEntity();
		StringBuffer sb = new StringBuffer("").append(name).append(" ")
				.append(DBContants.VARCHAR.replace("size", maxLen)).append(" ")
				.append(embellish).append(" ");
		entity.string = sb.toString();
		return entity;
	}

	public static DBTableEntity string(String name, String maxLen,
			List<String> embellishs) {
		DBTableEntity entity = new DBTableEntity();
		StringBuffer sb = new StringBuffer("").append(name).append(" ")
				.append(DBContants.VARCHAR.replace("size", maxLen)).append(" ");
		for (int i = 0; i < embellishs.size(); i++) {
			sb.append(embellishs.get(i)).append(" ");
		}
		entity.string = sb.toString();
		return entity;
	}

	public static DBTableEntity doubl(String name, String size, String d) {
		DBTableEntity entity = new DBTableEntity();
		StringBuffer sb = new StringBuffer("")
				.append(name)
				.append(" ")
				.append(DBContants.DECIMAL.replace("size", size)
						.replace("b", d)).append(" ");
		entity.string = sb.toString();
		return entity;
	}

	public static DBTableEntity doubl(String name, String size, String d,
			String embellish) {
		DBTableEntity entity = new DBTableEntity();
		StringBuffer sb = new StringBuffer("")
				.append(name)
				.append(" ")
				.append(DBContants.DECIMAL.replace("size", size)
						.replace("b", d)).append(" ").append(embellish)
				.append(" ");
		entity.string = sb.toString();
		return entity;
	}

	public static DBTableEntity doubl(String name, String size, String d,
			List<String> embellishs) {
		DBTableEntity entity = new DBTableEntity();
		StringBuffer sb = new StringBuffer("")
				.append(name)
				.append(" ")
				.append(DBContants.DECIMAL.replace("size", size)
						.replace("b", d)).append(" ");
		for (int i = 0; i < embellishs.size(); i++) {
			sb.append(embellishs.get(i)).append(" ");
		}
		entity.string = sb.toString();
		return entity;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		XhLog.e(string);
		return string;
	}
}
