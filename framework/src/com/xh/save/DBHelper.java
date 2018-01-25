package com.xh.save;

import java.util.List;

/**
 * @version ����ʱ�䣺2017-12-26 ����10:59:56 ��Ŀ��repair ������com.xh.save
 *          �ļ�����DBHelper.java ���ߣ�lhl ˵��:
 */

public class DBHelper {
	/**
	 * 
	 * lhl 2017-12-26 ����11:00:26 ˵�����������ݿ�
	 * 
	 * @param dbName
	 *            ���ݿ���
	 * @return String sql���
	 */
	public static String createDb(String dbName) {
		return DBContants.CREATE_DATABASE.replace("dbName", dbName);
	}

	/**
	 * 
	 * lhl 2017-12-26 ����11:03:58 ˵����������
	 * 
	 * @param tableName
	 * @param entities
	 * @return String
	 */
	public static String createTable(String tableName,
			List<DBTableEntity> entities) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < entities.size(); i++) {
			sb.append(entities.get(i).toString()).append(",");
		}
		return DBContants.CREATE_TABLE.replace("tableName", tableName).replace(
				"fields", sb.substring(0, sb.length()-2));
	}

	/**
	 * ɾ�����
	 * 
	 * @param name
	 */
	public static String dropTable(String name) {
		return DBContants.DROP_TABLE.replace("tableName", name);
	}

	/**
	 * ���һ��
	 * 
	 * @param tableName
	 * @param fieldName
	 */
	public static String alterAdd(String tableName, DBTableEntity entity) {
		return DBContants.ADD_COLUMN.replace("tableName", tableName).replace(
				"column type", entity.toString());
	}

	/**
	 * ɾ��һ��ɾ��һ��
	 * 
	 * @param tableName
	 * @param fieldName
	 */
	public static String alterDrop(String tableName, String fieldName) {
		return DBContants.DROP_COLUMN.replace("tableName", tableName).replace(
				"columname", fieldName);
	}

	/**
	 * ���һ��
	 * 
	 * @param tableName
	 * @param key
	 * @param value
	 */
	public static String insert(String tableName, List<DBTableEntity> entities) {
		StringBuffer keys = new StringBuffer();
		StringBuffer values = new StringBuffer();
		for (int i = 0; i < entities.size(); i++) {
			DBTableEntity entity = entities.get(i);
			keys.append(entity.key).append(",");
			Object value = entity.value;
			if (value instanceof String)
				values.append("/'").append(entity.value).append("/',");
			else
				values.append(entity.value).append(",");
		}
		return DBContants.INSERT_INTO.replace("tableName", tableName)
				.replace("keys", keys.substring(0, keys.length() - 1))
				.replace("values", values.substring(0, values.length() - 1));
	}

	/**
	 * ���һ��
	 * 
	 * @param tableName
	 * @param key
	 * @param value
	 */
	public static String insertA(String tableName, List<Object> entities) {
		StringBuffer values = new StringBuffer(
				"INSERT INTO tableName VALUES (values)");
		for (int i = 0; i < entities.size(); i++) {
			Object value = entities.get(i);
			if (value instanceof String)
				values.append("/'").append(value).append("/',");
			else
				values.append(value).append(",");
		}
		String s = values.substring(0, values.length() - 1);
		return s.replace("tableName", tableName);
	}

	/**
	 * ����һ��
	 * 
	 * @param tableName
	 * @param upDateKey
	 * @param upDateValue
	 * @param upDateConditionsKey
	 * @param upDateConditionsValue
	 */
	public static String upDateAnd(String tableName, List<String> upDateKey,
			List<Object> upDateValue, List<String> upDateConditionsKey,
			List<Object> upDateConditionsValue) {
		String sql = "UPDATE " + tableName + " SET ";
		int len = upDateKey.size() > upDateValue.size() ? upDateValue.size()
				: upDateKey.size();
		if (len > 0)
			sql += upDateKey.get(0) + "=" + upDateValue.get(0);
		else
			return "";
		for (int i = 1; i < len; i++) {
			sql += ", " + upDateKey.get(i) + "=" + upDateValue.get(i);
		}
		int conditionsLen = upDateConditionsKey.size() > upDateConditionsValue
				.size() ? upDateConditionsValue.size() : upDateConditionsKey
				.size();
		if (conditionsLen > 0)
			sql += "WHERE " + upDateConditionsKey.get(0) + "="
					+ upDateConditionsValue.get(0);
		else
			return "";
		for (int i = 1; i < conditionsLen; i++) {
			sql += " AND " + upDateConditionsKey.get(i) + "="
					+ upDateConditionsValue.get(i);
		}
		return sql;
	}

	/**
	 * ����һ��
	 * 
	 * @param tableName
	 * @param upDateKey
	 * @param upDateValue
	 * @param upDateConditionsKey
	 * @param upDateConditionsValue
	 */
	public static String upDateOr(String tableName, List<String> upDateKey,
			List<Object> upDateValue, List<String> upDateConditionsKey,
			List<Object> upDateConditionsValue) {
		String sql = "UPDATE " + tableName + " SET ";
		int len = upDateKey.size() > upDateValue.size() ? upDateValue.size()
				: upDateKey.size();
		if (len > 0)
			sql += upDateKey.get(0) + "=" + upDateValue.get(0);
		else
			return "";
		for (int i = 1; i < len; i++) {
			sql += ", " + upDateKey.get(i) + "=" + upDateValue.get(i);
		}
		int conditionsLen = upDateConditionsKey.size() > upDateConditionsValue
				.size() ? upDateConditionsValue.size() : upDateConditionsKey
				.size();
		if (conditionsLen > 0)
			sql += "WHERE " + upDateConditionsKey.get(0) + "="
					+ upDateConditionsValue.get(0);
		else
			return "";
		for (int i = 1; i < conditionsLen; i++) {
			sql += " OR " + upDateConditionsKey.get(i) + "="
					+ upDateConditionsValue.get(i);
		}
		return sql;
	}

	/**
	 * ɾ��һ��
	 * 
	 * @param key
	 * @param value
	 */
	public static String deleteAnd(String tableName, List<String> key,
			List<Object> value) {
		String sql = "DELETE FROM " + tableName + " WHERE ";
		int len = key.size() > value.size() ? value.size() : key.size();
		if (len > 0) {
			sql += key.get(0) + "=" + value.get(0);
		} else
			return "";
		for (int i = 1; i < len; i++) {
			sql += "AND " + key.get(i) + "=" + value.get(i);
		}
		return sql;
	}

	/**
	 * ɾ��һ��
	 * 
	 * @param tableName
	 * @param key
	 * @param value
	 */
	public static String deleteOr(String tableName, List<String> key,
			List<Object> value) {
		String sql = "DELETE FROM " + tableName + " WHERE ";
		int len = key.size() > value.size() ? value.size() : key.size();
		if (len > 0) {
			sql += key.get(0) + "=" + value.get(0);
		} else
			return "";
		for (int i = 1; i < len; i++) {
			sql += "OR " + key.get(i) + "=" + value.get(i);
		}
		return sql;
	}

	/**
	 * ��ձ��
	 */
	public static String empty(String tableName) {
		return "DELETE FROM " + tableName;
	}
}
