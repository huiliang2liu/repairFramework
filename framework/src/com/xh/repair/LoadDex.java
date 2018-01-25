package com.xh.repair;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

import android.content.Context;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

/**
 * @version ����ʱ�䣺2017-12-5 ����2:31:39 ��Ŀ��TvBlackAD-eclipse
 *          ������com.tvblack.tv.utils �ļ�����TVBLoadDex.java ���ߣ�lhl ˵��: ����dex�ļ�
 */

class LoadDex {

	public LoadDex(Context context, File filesDex) {
		// TODO Auto-generated constructor stub
		try {
			loadDex(context, filesDex);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void loadDex(Context context, File filesDex) {
		if (context == null)
			return;
		try {
			File[] files = filesDex.listFiles(new FilenameFilter() {

				@Override
				public boolean accept(File dir, String filename) {
					// TODO Auto-generated method stub
					return filename.endsWith(".dex");
				}
			});
			doDexInject(context, filesDex, files);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void doDexInject(Context context, File filesDex,
			File[] loadDex) {
		if (loadDex == null || loadDex.length <= 0)
			return;
		for (File file : loadDex) {
			System.out.println(file.getAbsolutePath());
		}
		String opt = filesDex.getAbsolutePath() + File.separator + "opt_dex";
		File opt_file = new File(opt);
		if (!opt_file.exists())
			opt_file.mkdirs();
		try {
			for (File file : loadDex) {
				DexClassLoader classLoader = new DexClassLoader(
						file.getAbsolutePath(), opt_file.getAbsolutePath(),
						null, context.getClassLoader());
				inject(classLoader, context);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void inject(DexClassLoader classLoader, Context context) {
		try {
			PathClassLoader pathClassLoader = (PathClassLoader) context
					.getClassLoader();
			Object dexElements = combineArray(
					getDexElements(getPathList(pathClassLoader)),
					getDexElements(getPathList(classLoader)));
			Object pathList = getPathList(pathClassLoader);
			setField(pathList, pathList.getClass(), "dexElements", dexElements);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * lhl 2017-12-5 ����2:43:51 ˵������ȡ����·���б�
	 * 
	 * @param baseDexClassLoader
	 * @return Object
	 */
	private static Object getPathList(Object baseDexClassLoader) {
		try {
			return getField(baseDexClassLoader,
					Class.forName("dalvik.system.BaseDexClassLoader"),
					"pathList");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * lhl 2017-12-5 ����2:41:49 ˵������ȡdex�б�
	 * 
	 * @param object
	 * @return Object
	 */
	private static Object getDexElements(Object object) {
		try {
			return getField(object, object.getClass(), "dexElements");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * lhl 2017-12-5 ����2:40:15 ˵������ȡ�ֶε�ֵ
	 * 
	 * @param object
	 * @param cl
	 * @param filedName
	 * @return Object
	 */
	private static Object getField(Object object, Class cl, String filedName) {
		try {
			Field field = cl.getDeclaredField(filedName);
			if (!field.isAccessible())
				field.setAccessible(true);
			return field.get(object);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * lhl 2017-12-5 ����2:37:57 ˵���������ֶ�ֵ
	 * 
	 * @param object
	 * @param cl
	 * @param fieldName
	 * @param value
	 *            void
	 */
	private static void setField(Object object, Class cl, String fieldName,
			Object value) {
		try {
			Field field = cl.getDeclaredField(fieldName);
			if (!field.isAccessible())
				field.setAccessible(true);
			field.set(object, value);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * lhl 2017-12-5 ����2:35:54 ˵�����ϲ�����
	 * 
	 * @param arrayLhs
	 * @param arrayRhs
	 * @return Object
	 */
	private static Object combineArray(Object arrayLhs, Object arrayRhs) {
		Class localClass = arrayLhs.getClass().getComponentType();
		int i = Array.getLength(arrayLhs);
		int j = i + Array.getLength(arrayRhs);
		Object result = Array.newInstance(localClass, j);
		for (int k = 0; k < j; k++) {
			if (k < i)
				Array.set(result, k, Array.get(arrayLhs, k));
			else
				Array.set(result, k, Array.get(arrayRhs, k - i));
		}
		return result;
	}
}
