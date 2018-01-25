package com.xh.save;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.xh.ifaces.IObjectDB;
import com.xh.reflect.ClassManager;
import com.xh.reflect.FieldManager;
import com.xh.util.Cursor2Object;
import com.xh.util.XhLog;

/**
 * @version 创建时间：2017-12-26 下午3:20:11 项目：repair 包名：com.xh.save
 *          文件名：DBObjectImpl.java 作者：lhl 说明:
 */

public class DBObjectImpl extends DBImpl implements IObjectDB {

	public DBObjectImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createTable(SQLiteDatabase db, String tableName, Class cl) {
		// TODO Auto-generated method stub
		Field[] fields = FieldManager.fields(cl);
		List<DBTableEntity> entities = new ArrayList<DBTableEntity>();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String name = FieldManager.name(field);
			if (ClassManager.is_integer(FieldManager.field_class(field))) {
				entities.add(DBTableEntity.integer(name));
			} else if (ClassManager.is_float(FieldManager.field_class(field))) {
				entities.add(DBTableEntity.doubl(name, "100", "20"));
			} else {
				entities.add(DBTableEntity.string(name, "" + Integer.MAX_VALUE));
			}
		}
		createTable(db, tableName, entities);
	}

	@Override
	public long insert(SQLiteDatabase db, String table, Object object) {
		// TODO Auto-generated method stub
		Class cl = object.getClass();
		Field[] fields = FieldManager.fields(cl);
		ContentValues values = new ContentValues();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			XhLog.e(FieldManager.get_field(object, field).toString());
			if (ClassManager.is_integer(FieldManager.field_class(field))) {
				values.put(FieldManager.name(field), Integer
						.valueOf(FieldManager.get_field(object, field)
								.toString()));
			} else if (ClassManager.is_float(FieldManager.field_class(field))) {
				values.put(FieldManager.name(field), Double
						.valueOf(FieldManager.get_field(object, field)
								.toString()));
			} else {
				values.put(FieldManager.name(field),
						(String) FieldManager.get_field(object, field));
			}
		}
		return insert(db, table, values);
	}

	@Override
	public int delete(SQLiteDatabase db, String table, Object object) {
		// TODO Auto-generated method stub
		Field[] fields = FieldManager.fields(object.getClass());
		StringBuffer sb = new StringBuffer();
		String[] whereArgs = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			sb.append(FieldManager.name(field)).append("=?").append("and ");
			whereArgs[i] = FieldManager.get_field(object, field).toString();
		}
		return delete(db, table, sb.substring(0, sb.length() - 4), whereArgs);
	}

	@Override
	public int update(SQLiteDatabase db, String table, Object newObject,
			Object oldObject) {
		Field[] fields = FieldManager.fields(newObject.getClass());
		StringBuffer sb = new StringBuffer();
		String[] whereArgs = new String[fields.length];
		ContentValues values = new ContentValues();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			sb.append(FieldManager.name(field)).append("=?").append("and ");
			whereArgs[i] = FieldManager.get_field(oldObject, field).toString();
			if (ClassManager.is_integer(FieldManager.field_class(field))) {
				values.put(FieldManager.name(field),
						(int) FieldManager.get_field(newObject, field));
			} else if (ClassManager.is_float(FieldManager.field_class(field))) {
				values.put(FieldManager.name(field),
						(double) FieldManager.get_field(newObject, field));
			} else {
				values.put(FieldManager.name(field),
						(String) FieldManager.get_field(newObject, field));
			}
		}
		// TODO Auto-generated method stub
		return update(db, table, values, sb.substring(0, sb.length() - 4),
				whereArgs);
	}

	@Override
	public int update(SQLiteDatabase db, String table, Object object,
			String whereClause, String[] whereArgs) {
		// TODO Auto-generated method stub
		Field[] fields = FieldManager.fields(object.getClass());
		ContentValues values = new ContentValues();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			if (ClassManager.is_integer(FieldManager.field_class(field))) {
				values.put(FieldManager.name(field),
						(int) FieldManager.get_field(object, field));
			} else if (ClassManager.is_float(FieldManager.field_class(field))) {
				values.put(FieldManager.name(field),
						(double) FieldManager.get_field(object, field));
			} else {
				values.put(FieldManager.name(field),
						(String) FieldManager.get_field(object, field));
			}
		}
		return update(db, table, values, whereClause, whereArgs);
	}

	@Override
	public List<Object> selectObject(SQLiteDatabase db, String table, Class cl) {
		// TODO Auto-generated method stub
		return Cursor2Object.cursor2Object(select(db, table), cl);
	}

	@Override
	public List<Object> selectObject(SQLiteDatabase db, String table,
			List<String> names, Class cl) {
		return Cursor2Object.cursor2Object(select(db, table, names), cl);
	}

	@Override
	public List<Object> selectObject(SQLiteDatabase db, String table,
			String whereClause, String[] whereArgs, Class cl) {
		// TODO Auto-generated method stub
		return Cursor2Object.cursor2Object(
				select(db, table, whereClause, whereArgs), cl);
	}

	@Override
	public List<Object> selectObject(SQLiteDatabase db, String table,
			String whereClause, String[] whereArgs, List<String> names, Class cl) {
		// TODO Auto-generated method stub
		return Cursor2Object.cursor2Object(
				select(db, table, whereClause, whereArgs, names), cl);
	}
}
