package com.xh.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.xh.reflect.ClassManager;
import com.xh.reflect.FieldManager;

import android.database.Cursor;
import android.os.Bundle;

/**
 * @version ����ʱ�䣺2017-12-26 ����12:59:37 ��Ŀ��repair ������com.xh.util
 *          �ļ�����Cursor2Object.java ���ߣ�lhl ˵��:
 */

public class Cursor2Object {
	public static List<Object> cursor2Object(Cursor cursor, Class cl) {
		List<Object> objects = new ArrayList<>();
		try {
			Field[] fields = FieldManager.fields(cl);
			if (fields == null || fields.length == 0)
				return objects;
			while (cursor.moveToNext()) {
				Object object = ClassManager.new_object(cl);
				for (int i = 0; i < fields.length; i++) {
					Field field = fields[i];
					if (ClassManager
							.is_integer(FieldManager.field_class(field))) {
						int value = cursor.getInt(cursor
								.getColumnIndex(FieldManager.name(field)));
						FieldManager.set_field(object, field, value);
					} else if (ClassManager.is_float(FieldManager
							.field_class(field))) {
						float value = cursor.getFloat(cursor
								.getColumnIndex(FieldManager.name(field)));
						FieldManager.set_field(object, field, value);
					} else {
						FieldManager.set_field(object, field, cursor
								.getString(cursor.getColumnIndex(FieldManager
										.name(field))));
					}
				}
				objects.add(object);
			}
			cursor.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return objects;
	}
}
