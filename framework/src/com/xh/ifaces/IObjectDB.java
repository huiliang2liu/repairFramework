package com.xh.ifaces;

import java.util.List;

import android.database.sqlite.SQLiteDatabase;

/**
 * @version ����ʱ�䣺2017-12-27 ����9:56:32 ��Ŀ��repair ������com.xh.ifaces
 *          �ļ�����IObjectDB.java ���ߣ�lhl ˵��:
 */

public interface IObjectDB extends IDB {
	/**
	 * 
	 * lhl 2017-12-26 ����3:35:32 ˵�����������
	 * 
	 * @param db
	 * @param tableName
	 *            void
	 */
	public void createTable(SQLiteDatabase db, String tableName, Class cl);

	/**
	 * 
	 * lhl 2017-12-27 ����9:57:00 ˵������������
	 * 
	 * @param db
	 * @param table
	 * @param object
	 * @return long
	 */
	public long insert(SQLiteDatabase db, String table, Object object);

	/**
	 * 
	 * lhl 2017-12-27 ����9:57:17 ˵����ɾ������
	 * 
	 * @param db
	 * @param table
	 * @param object
	 * @return int
	 */
	public int delete(SQLiteDatabase db, String table, Object object);

	/**
	 * 
	 * lhl 2017-12-27 ����9:57:30 ˵������������
	 * 
	 * @param db
	 * @param table
	 * @param newObject
	 * @param oldObject
	 * @return int
	 */
	public int update(SQLiteDatabase db, String table, Object newObject,
			Object oldObject);

	/**
	 * 
	 * lhl 2017-12-27 ����9:57:57 ˵������������ ��������� age<35 ��whereClause="age < ?"
	 * whereArgs=new String[]{"35"}
	 * 
	 * @param db
	 * @param table
	 * @param object
	 * @param whereClause
	 * @param whereArgs
	 * @return int
	 */
	public int update(SQLiteDatabase db, String table, Object object,
			String whereClause, String[] whereArgs);

	/**
	 * 
	 * lhl 2017-12-27 ����9:58:13 ˵������ѯ����
	 * 
	 * @param db
	 * @param table
	 * @param cl
	 * @return List<Object>
	 */
	public List<Object> selectObject(SQLiteDatabase db, String table, Class cl);

	/**
	 * 
	 * lhl 2017-12-27 ����9:58:33 ˵������ѯ����
	 * 
	 * @param db
	 * @param table
	 * @param names
	 * @param cl
	 * @return List<Object>
	 */
	public List<Object> selectObject(SQLiteDatabase db, String table,
			List<String> names, Class cl);

	/**
	 * 
	 * lhl 2017-12-27 ����9:59:04 ˵������ѯ����
	 * 
	 * @param db
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 * @param cl
	 * @return List<Object>
	 */
	public List<Object> selectObject(SQLiteDatabase db, String table,
			String whereClause, String[] whereArgs, Class cl);

	/**
	 * 
	 * lhl 2017-12-27 ����9:59:21 ˵������ѯ����
	 * 
	 * @param db
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 * @param names
	 * @param cl
	 * @return List<Object>
	 */
	public List<Object> selectObject(SQLiteDatabase db, String table,
			String whereClause, String[] whereArgs, List<String> names, Class cl);
}
