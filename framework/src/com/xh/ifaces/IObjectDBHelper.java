package com.xh.ifaces;

import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;

import com.xh.save.DBTableEntity;

/**
 * @version ����ʱ�䣺2017-12-27 ����10:31:30 ��Ŀ��repair ������com.xh.ifaces �ļ�����a.java
 *          ���ߣ�lhl ˵��:
 */

public interface IObjectDBHelper {
	/**
	 * 
	 * lhl 2017-12-27 ����10:35:52 ˵�����h��
	 * 
	 * @param tableName
	 *            void
	 */
	public void deleteTable(String tableName);

	/**
	 * 
	 * lhl 2017-12-27 ����10:36:02 ˵�������
	 * 
	 * @param tableName
	 *            void
	 */
	public void clear(String tableName);

	/**
	 * 
	 * lhl 2017-12-27 ����10:36:14 ˵��������
	 * 
	 * @param tableName
	 * @param entities
	 *            void
	 */
	public void createTable(String tableName, List<DBTableEntity> entities);

	/**
	 * 
	 * lhl 2017-12-27 ����10:36:50 ˵��������
	 * 
	 * @param tableName
	 * @param cl
	 *            void
	 */
	public void createTable(String tableName, Class cl);

	/**
	 * 
	 * lhl 2017-12-27 ����10:37:00 ˵��������
	 * 
	 * @param table
	 * @param values
	 * @return long
	 */
	public long insert(String table, ContentValues values);

	/**
	 * 
	 * lhl 2017-12-27 ����10:37:17 ˵��������
	 * 
	 * @param table
	 * @param object
	 * @return long
	 */
	public long insert(String table, Object object);

	/**
	 * 
	 * lhl 2017-12-27 ����10:37:29 ˵����ɾ��
	 * 
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 * @return int
	 */
	public int delete(String table, String whereClause, String[] whereArgs);

	/**
	 * 
	 * lhl 2017-12-27 ����10:37:45 ˵����ɾ��
	 * 
	 * @param table
	 * @param object
	 * @return int
	 */
	public int delete(String table, Object object);

	/**
	 * 
	 * lhl 2017-12-27 ����10:37:55 ˵��������
	 * 
	 * @param db
	 * @param table
	 * @param values
	 * @param whereClause
	 * @param whereArgs
	 * @return int
	 */
	public int update( String table, ContentValues values,
			String whereClause, String[] whereArgs);

	/**
	 * 
	 * lhl 2017-12-27 ����10:38:16 ˵��������
	 * 
	 * @param table
	 * @param newObject
	 * @param oldObject
	 * @return int
	 */
	public int update(String table, Object newObject, Object oldObject);

	/**
	 * 
	 * lhl 2017-12-27 ����10:38:24 ˵��������
	 * 
	 * @param table
	 * @param object
	 * @param whereClause
	 * @param whereArgs
	 * @return int
	 */
	public int update(String table, Object object, String whereClause,
			String[] whereArgs);

	/**
	 * 
	 * lhl 2017-12-27 ����10:38:37 ˵��������
	 * 
	 * @param table
	 * @return Cursor
	 */
	public Cursor select(String table);

	/**
	 * 
	 * lhl 2017-12-27 ����10:38:44 ˵��������
	 * 
	 * @param db
	 * @param table
	 * @param names
	 * @return Cursor
	 */
	public Cursor select( String table, List<String> names);

	/**
	 * 
	 * lhl 2017-12-27 ����10:38:49 ˵��������
	 * 
	 * @param db
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 * @return Cursor
	 */
	public Cursor select(String table, String whereClause,
			String[] whereArgs);

	/**
	 * 
	 * lhl 2017-12-27 ����10:38:53 ˵��������
	 * 
	 * @param db
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 * @param names
	 * @return Cursor
	 */
	public Cursor select( String table, String whereClause,
			String[] whereArgs, List<String> names);

	/**
	 * 
	 * lhl 2017-12-27 ����10:39:08 ˵��������
	 * 
	 * @param table
	 * @param cl
	 * @return List<Object>
	 */
	public List<Object> selectObject(String table, Class cl);

	/**
	 * 
	 * lhl 2017-12-27 ����10:39:12 ˵��������
	 * 
	 * @param table
	 * @param names
	 * @param cl
	 * @return List<Object>
	 */
	public List<Object> selectObject(String table, List<String> names, Class cl);

	/**
	 * 
	 * lhl 2017-12-27 ����10:39:16 ˵��������
	 * 
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 * @param cl
	 * @return List<Object>
	 */
	public List<Object> selectObject(String table, String whereClause,
			String[] whereArgs, Class cl);

	/**
	 * 
	 * lhl 2017-12-27 ����10:39:20 ˵��������
	 * 
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 * @param names
	 * @param cl
	 * @return List<Object>
	 */
	public List<Object> selectObject(String table, String whereClause,
			String[] whereArgs, List<String> names, Class cl);
	/**
	 * 
	 * lhl
	 * 2017-12-27 ����5:46:45
	 * ˵���� �ر�
	 * void
	 */
	public void close();
}
