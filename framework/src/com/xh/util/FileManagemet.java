package com.xh.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;

public class FileManagemet {
	private final static String TAG = FileManagemet.class.getName();

	/**
	 * ɾ���ļ�
	 * 
	 * @param file
	 * @return
	 */
	@SuppressLint("NewApi")
	public static boolean delete_file(String file) {
		if (file == null || file.isEmpty())
			return false;
		return delete_file(new File(file));
	}

	/**
	 * ɾ���ļ�
	 * 
	 * @param file
	 * @return
	 */
	public static boolean delete_file(File file) {
		if (file == null || !file.exists())
			return false;
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (file != null && file.length() > 0) {
				for (File file2 : files) {
					delete_file(file2);
				}
			}
			file.delete();
		} else
			file.delete();
		return true;
	}

	/**
	 * �����ļ�
	 * 
	 * @param file
	 * @param end
	 * @return
	 */
	@SuppressLint("NewApi")
	public static List<String> select(String file, String end) {
		if (file == null || file.isEmpty())
			return null;
		return select(new File(file), end);
	}

	/**
	 * �����ļ�
	 * 
	 * @param file
	 * @param end
	 * @return
	 */
	@SuppressLint("NewApi")
	public static List<String> select(File file, String end) {
		if (file == null || !file.exists())
			return null;
		if (end == null || end.isEmpty())
			return null;
		List<String> list = new ArrayList<String>();
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (files != null && files.length > 0)
				for (File file2 : files) {
					list.addAll(select(file2, end));
				}
		} else if (file.getName().endsWith(end))
			list.add(file.getAbsolutePath());
		return list;
	}

	/**
	 * �����ļ�
	 * 
	 * @param end
	 * @return
	 */
	@SuppressLint("NewApi")
	public static List<String> select(String end) {
		return select(new File(Environment.getExternalStorageDirectory()
				+ File.separator), end);
	}

	@SuppressLint("NewApi")
	public static Intent open_file(String file) {
		if (file == null || file.isEmpty())
			return null;
		return open_file(new File(file));
	}

	/**
	 * ���ļ�
	 * 
	 * @param filePath
	 * @return
	 */
	@SuppressLint("DefaultLocale")
	public static Intent open_file(File file) {
		if (file == null || !file.exists())
			return null;
		/* ȡ����չ�� */
		String end = file
				.getName()
				.substring(file.getName().lastIndexOf(".") + 1,
						file.getName().length()).toLowerCase();
		String filePath = file.getAbsolutePath();
		/* ����չ�������;���MimeType */
		if (end.equals("m4a") || end.equals("mp3") || end.equals("mid")
				|| end.equals("xmf") || end.equals("ogg") || end.equals("wav")) {
			return getAudioFileIntent(filePath);
		} else if (end.equals("3gp") || end.equals("mp4")) {
			return getAudioFileIntent(filePath);
		} else if (end.equals("jpg") || end.equals("gif") || end.equals("png")
				|| end.equals("jpeg") || end.equals("bmp")) {
			return getImageFileIntent(filePath);
		} else if (end.equals("apk")) {
			return getApkFileIntent(filePath);
		} else if (end.equals("ppt")) {
			return getPptFileIntent(filePath);
		} else if (end.equals("xls")) {
			return getExcelFileIntent(filePath);
		} else if (end.equals("doc")) {
			return getWordFileIntent(filePath);
		} else if (end.equals("pdf")) {
			return getPdfFileIntent(filePath);
		} else if (end.equals("chm")) {
			return getChmFileIntent(filePath);
		} else if (end.equals("txt")) {
			return getTextFileIntent(filePath, false);
		} else {
			return getAllIntent(filePath);
		}
	}

	public static Intent getAllIntent(String param) {

		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(android.content.Intent.ACTION_VIEW);
		Uri uri = Uri.fromFile(new File(param));
		intent.setDataAndType(uri, "*/*");
		return intent;
	}

	// Android��ȡһ�����ڴ�APK�ļ���intent
	public static Intent getApkFileIntent(String param) {

		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(android.content.Intent.ACTION_VIEW);
		Uri uri = Uri.fromFile(new File(param));
		intent.setDataAndType(uri, "application/vnd.android.package-archive");
		return intent;
	}

	// Android��ȡһ�����ڴ�VIDEO�ļ���intent
	public static Intent getVideoFileIntent(String param) {

		Intent intent = new Intent("android.intent.action.VIEW");
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra("oneshot", 0);
		intent.putExtra("configchange", 0);
		Uri uri = Uri.fromFile(new File(param));
		intent.setDataAndType(uri, "video/*");
		return intent;
	}

	// Android��ȡһ�����ڴ�AUDIO�ļ���intent
	public static Intent getAudioFileIntent(String param) {

		Intent intent = new Intent("android.intent.action.VIEW");
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra("oneshot", 0);
		intent.putExtra("configchange", 0);
		Uri uri = Uri.fromFile(new File(param));
		intent.setDataAndType(uri, "audio/*");
		return intent;
	}

	// Android��ȡһ�����ڴ�Html�ļ���intent
	public static Intent getHtmlFileIntent(String param) {

		Uri uri = Uri.parse(param).buildUpon()
				.encodedAuthority("com.android.htmlfileprovider")
				.scheme("content").encodedPath(param).build();
		Intent intent = new Intent("android.intent.action.VIEW");
		intent.setDataAndType(uri, "text/html");
		return intent;
	}

	// Android��ȡһ�����ڴ�ͼƬ�ļ���intent
	public static Intent getImageFileIntent(String param) {

		Intent intent = new Intent("android.intent.action.VIEW");
		intent.addCategory("android.intent.category.DEFAULT");
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(new File(param));
		intent.setDataAndType(uri, "image/*");
		return intent;
	}

	// Android��ȡһ�����ڴ�PPT�ļ���intent
	public static Intent getPptFileIntent(String param) {

		Intent intent = new Intent("android.intent.action.VIEW");
		intent.addCategory("android.intent.category.DEFAULT");
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(new File(param));
		intent.setDataAndType(uri, "application/vnd.ms-powerpoint");
		return intent;
	}

	// Android��ȡһ�����ڴ�Excel�ļ���intent
	public static Intent getExcelFileIntent(String param) {

		Intent intent = new Intent("android.intent.action.VIEW");
		intent.addCategory("android.intent.category.DEFAULT");
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(new File(param));
		intent.setDataAndType(uri, "application/vnd.ms-excel");
		return intent;
	}

	// Android��ȡһ�����ڴ�Word�ļ���intent
	public static Intent getWordFileIntent(String param) {

		Intent intent = new Intent("android.intent.action.VIEW");
		intent.addCategory("android.intent.category.DEFAULT");
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(new File(param));
		intent.setDataAndType(uri, "application/msword");
		return intent;
	}

	// Android��ȡһ�����ڴ�CHM�ļ���intent
	public static Intent getChmFileIntent(String param) {

		Intent intent = new Intent("android.intent.action.VIEW");
		intent.addCategory("android.intent.category.DEFAULT");
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(new File(param));
		intent.setDataAndType(uri, "application/x-chm");
		return intent;
	}

	// Android��ȡһ�����ڴ��ı��ļ���intent
	public static Intent getTextFileIntent(String param, boolean paramBoolean) {

		Intent intent = new Intent("android.intent.action.VIEW");
		intent.addCategory("android.intent.category.DEFAULT");
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		if (paramBoolean) {
			Uri uri1 = Uri.parse(param);
			intent.setDataAndType(uri1, "text/plain");
		} else {
			Uri uri2 = Uri.fromFile(new File(param));
			intent.setDataAndType(uri2, "text/plain");
		}
		return intent;
	}

	// Android��ȡһ�����ڴ�PDF�ļ���intent
	public static Intent getPdfFileIntent(String param) {

		Intent intent = new Intent("android.intent.action.VIEW");
		intent.addCategory("android.intent.category.DEFAULT");
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(new File(param));
		intent.setDataAndType(uri, "application/pdf");
		return intent;
	}

	/**
	 * ��ȡ�����Ƿ�Ӧ��
	 * 
	 * @param context
	 * @return
	 */
	public static Map<String, Apk> select_three_apk(Context context) {
		Map<String, Map<String, Apk>> map = select_run_apk(context);
		return map == null ? null : map.get("three");
	}

	public static Map<String, Apk> select_sdc_apk(Context context) {
		Map<String, Map<String, Apk>> map = select_run_apk(context);
		return map == null ? null : map.get("sdc");
	}

	/**
	 * ��ȡϵͳӦ��
	 * 
	 * @param context
	 * @return
	 */
	public static Map<String, Apk> select_sys_apk(Context context) {
		Map<String, Map<String, Apk>> map = select_run_apk(context);
		return map == null ? null : map.get("system");
	}

	/**
	 * ��ȡ����Ӧ��
	 * 
	 * @param context
	 * @return
	 */
	public static Map<String, Apk> select_all_apk(Context context) {
		Map<String, Map<String, Apk>> map = select_run_apk(context);
		if (map == null)
			return null;
		Map<String, Apk> apks = map.get("three");
		if (apks == null)
			apks = map.get("system");
		else
			apks.putAll(map.get("system"));
		return apks;
	}

	private static Map<String, Map<String, Apk>> select_run_apk(Context context) {
		if (context == null)
			return null;
		PackageManager pm = context.getPackageManager();
		List<ApplicationInfo> listAppcations = pm
				.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
		Collections.sort(listAppcations,
				new ApplicationInfo.DisplayNameComparator(pm));// ����
		Map<String, Map<String, Apk>> map = new HashMap<String, Map<String, Apk>>();
		for (ApplicationInfo app : listAppcations) {
			if ((app.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
				Map<String, Apk> apks = map.get("system");
				Apk apk = apk(app, pm);
				if (apks == null) {
					apks = new HashMap<String, FileManagemet.Apk>();
					apks.put(apk.getPackage_name(), apk);
					map.put("system", apks);
				} else
					apks.put(apk.getPackage_name(), apk);
			}
			if ((app.flags & ApplicationInfo.FLAG_SYSTEM) <= 0) {
				Map<String, Apk> apks = map.get("three");
				Apk apk = apk(app, pm);
				if (apks == null) {
					apks = new HashMap<String, FileManagemet.Apk>();
					apks.put(apk.getPackage_name(), apk);
					map.put("three", apks);
				} else
					apks.put(apk.getPackage_name(), apk);
			}
			if ((app.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) != 0) {
				Map<String, Apk> apks = map.get("three");
				Apk apk = apk(app, pm);
				if (apks == null) {
					apks = new HashMap<String, FileManagemet.Apk>();
					apks.put(apk.getPackage_name(), apk);
					map.put("three", apks);
				} else
					apks.put(apk.getPackage_name(), apk);
				Map<String, Apk> sdk = map.get("sdc");
				if (sdk == null) {
					sdk = new HashMap<String, FileManagemet.Apk>();
					sdk.put(apk.getPackage_name(), apk);
					map.put("sdc", sdk);
				} else
					sdk.put(apk.getPackage_name(), apk);
			}
		}
		return map;
	}

	private static Apk apk(ApplicationInfo app, PackageManager pm) {
		// TODO Auto-generated method stub
		Apk apk = new Apk();
		apk.setName(app.loadLabel(pm).toString());
		apk.setPackage_name(app.packageName);
		apk.setIco(app.loadIcon(pm));
		try {
			PackageInfo info = pm.getPackageInfo(app.packageName, 0);
			apk.setVersionCode(info.versionCode);
			apk.setVersionName(info.versionName);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return apk;
	}

	/**
	 * ����װ��·��ת��λapk
	 * 
	 * @param file
	 * @param context
	 * @return
	 */
	@SuppressLint("NewApi")
	public static Apk apk_file(String file, Context context) {
		if (file == null || file.isEmpty() || !file.endsWith(".apk"))
			return null;
		Apk apk = new Apk();
		PackageManager pm = context.getPackageManager();
		PackageInfo packageInfo = pm.getPackageArchiveInfo(file,
				PackageManager.GET_ACTIVITIES);
		if (packageInfo != null) {
			apk.setPath(file);
			apk.setVersionName(packageInfo.versionName);
			apk.setVersionCode(packageInfo.versionCode);
			apk.setPackage_name(packageInfo.packageName);
			ApplicationInfo app = packageInfo.applicationInfo;
			if (app != null) {
				apk.setName(app.loadLabel(pm).toString());
				apk.setIco(app.loadIcon(pm));
			}
		}
		return apk;
	}

	/**
	 * �����ļ�
	 * 
	 * @param file_name
	 *            ��Ҫ���ݵ��ļ�
	 * @param backup_file_path
	 *            �����ļ����ڵ��ļ���
	 * @param backup_file_name
	 *            �����ļ����ļ���
	 * @throws Exception
	 */
	@SuppressLint("NewApi")
	public static void backup(String file_name, String backup_file_path,
			String backup_file_name) throws Exception {
		if (file_name == null || file_name.isEmpty())
			throw new RuntimeException("file name is null or empty");
		if (backup_file_path == null || backup_file_path.isEmpty())
			throw new RuntimeException("backup file path is null or empty");
		if (backup_file_name == null || backup_file_name.isEmpty())
			throw new RuntimeException("backup file name is null or empty");
		File file = new File(file_name);
		File backup_file_path_f = new File(backup_file_path);
		if (!backup_file_path_f.exists())
			synchronized (TAG) {
				if (!backup_file_path_f.exists())
					backup_file_path_f.mkdirs();
			}
		if (!file.exists())
			throw new RuntimeException("file is not exists");
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(backup_file_path + "/"
				+ backup_file_name);
		int len = -1;
		byte[] buff = new byte[1024];
		while ((len = fis.read(buff)) > 0) {
			fos.write(buff, 0, len);
		}
		fos.flush();
		fos.close();
		fis.close();
	}

	/**
	 * �������� ��ǰ�����ݱ����
	 * 
	 * @param file_path
	 *            �����������ڵ�Ŀ¼
	 * @param file_name
	 *            �����ļ����ļ���
	 * @param content
	 *            ��Ҫ���������
	 * @throws Exception
	 */
	@SuppressLint("NewApi")
	public static void save(String file_path, String file_name, byte[] content)
			throws Exception {
		if (file_path == null || file_path.isEmpty())
			throw new RuntimeException("file path is null or empty");
		if (file_name == null || file_name.isEmpty())
			throw new RuntimeException("file name is null or empty");
		if (content == null || content.length == 0)
			throw new RuntimeException("content is null or content length=0");
		File file = new File(file_path);
		if (!file.exists())
			file.mkdirs();
		XhLog.e(TAG, file_path+"/"+file_name);
		FileOutputStream fos = new FileOutputStream(file_path + "/" + file_name);
		fos.write(content);
		fos.flush();
		fos.close();
	}

	/**
	 * 
	 * �������� ��ǰ�����ݱ����
	 * 
	 * @param file_path
	 *            �����������ڵ�Ŀ¼
	 * @param file_name
	 *            �����ļ����ļ���
	 * @param content
	 *            ��Ҫ���������
	 * @param charsetName
	 *            ���ֱ���
	 * @throws Exception
	 */
	public static void save(String file_path, String file_name, String content,
			String charsetName) throws Exception {
		save(file_path, file_name, content.getBytes(charsetName));
	}

	/**
	 * ׷������
	 * 
	 * @param file_path
	 *            �����������ڵ�Ŀ¼
	 * @param file_name
	 *            �����ļ����ļ���
	 * @param content
	 *            ��Ҫ���������
	 * @throws Exception
	 */
	@SuppressLint("NewApi")
	public static void add_save(String file_path, String file_name,
			byte[] content) throws Exception {
		if (file_path == null || file_path.isEmpty())
			throw new RuntimeException("file path is null or empty");
		if (file_name == null || file_name.isEmpty())
			throw new RuntimeException("file name is null or empty");
		if (content == null || content.length == 0)
			throw new RuntimeException("content is null or content length=0");
		File file = new File(file_path);
		if (!file.exists())
			file.mkdirs();
		FileOutputStream fos = new FileOutputStream(
				file_path + "/" + file_name, true);
		fos.write(content);
		fos.flush();
		fos.close();
	}

	/**
	 * 
	 * ׷������
	 * 
	 * @param file_path
	 *            �����������ڵ�Ŀ¼
	 * @param file_name
	 *            �����ļ����ļ���
	 * @param content
	 *            ��Ҫ���������
	 * @param charsetName
	 *            ���ֱ���
	 * @throws Exception
	 */
	public static void add_save(String file_path, String file_name,
			String content, String charsetName) throws Exception {
		add_save(file_path, file_name, content.getBytes(charsetName));
	}

	/**
	 * ��������
	 * 
	 * @param file_path
	 *            �����������ڵ�Ŀ¼
	 * @param file_name
	 *            �����ļ����ļ���
	 * @param content
	 *            ��Ҫ���������
	 * @param stat_index
	 *            ���뿪ʼλ��
	 * @param len
	 *            ���볤��
	 * @throws Exception
	 */
	@SuppressLint("NewApi")
	public static void insert_save(String file_path, String file_name,
			byte[] content, int stat_index, int len) throws Exception {
		if (file_path == null || file_path.isEmpty())
			throw new RuntimeException("file path is null or empty");
		if (file_name == null || file_name.isEmpty())
			throw new RuntimeException("file name is null or empty");
		if (len <= 0)
			throw new RuntimeException("len<=0");
		if (content == null || content.length == 0)
			throw new RuntimeException("content is null or content length=0");
		File file = new File(file_path);
		if (!file.exists())
			file.mkdirs();
		File m_file = new File(file_path + "/" + file_name);
		RandomAccessFile raf = new RandomAccessFile(m_file, "rw");
		int content_len = content.length;
		if (len > content_len)
			len = content_len;
		byte b[] = new byte[len];
		System.arraycopy(content, 0, b, 0, len);
		long file_len = raf.length();
		if (m_file.exists()) {
			raf.seek(stat_index);
			if (file_len > stat_index) {
				byte[] buff = StreamManage
						.inputStream2byte(new FileInputStream(m_file));
				raf.write(b);
				raf.write(buff, stat_index - 1, buff.length);

			} else {
				raf.seek(stat_index);
				raf.write(b);
			}
		} else
			raf.write(b);
	}

	/**
	 * ��������
	 * 
	 * @param file_path
	 *            �����������ڵ�Ŀ¼
	 * @param file_name
	 *            �����ļ����ļ���
	 * @param content
	 *            ��Ҫ���������
	 * @param charsetName
	 *            ���ֱ���
	 * @param stat_index
	 *            ���뿪ʼλ��
	 * @param len
	 *            ���볤��
	 * @throws Exception
	 */
	public static void insert_save(String file_path, String file_name,
			String content, String charsetName, int stat_index, int len)
			throws Exception {
		insert_save(file_path, file_name, content.getBytes(charsetName),
				stat_index, len);
	}

	/**
	 * ��������
	 * 
	 * @param file_path
	 *            �����������ڵ�Ŀ¼
	 * @param file_name
	 *            �����ļ����ļ���
	 * @param content
	 *            ��Ҫ���������
	 * @param stat_index
	 *            ���뿪ʼλ��
	 * @param len
	 *            ���³���
	 * @throws Exception
	 */
	@SuppressLint("NewApi")
	public static void uodate_save(String file_path, String file_name,
			byte[] content, int stat_index, int len) throws Exception {
		if (file_path == null || file_path.isEmpty())
			throw new RuntimeException("file path is null or empty");
		if (file_name == null || file_name.isEmpty())
			throw new RuntimeException("file name is null or empty");
		if (len <= 0)
			throw new RuntimeException("len<=0");
		if (content == null || content.length == 0)
			throw new RuntimeException("content is null or content length=0");
		File file = new File(file_path);
		if (!file.exists())
			file.mkdirs();
		File m_file = new File(file_path + "/" + file_name);
		RandomAccessFile raf = new RandomAccessFile(m_file, "rw");
		int content_len = content.length;
		if (len > content_len)
			len = content_len;
		byte b[] = new byte[len];
		System.arraycopy(content, 0, b, 0, len);
		raf.seek(stat_index);
		raf.write(b);
		raf.close();
	}

	/**
	 * ��������
	 * 
	 * @param file_path
	 *            �����������ڵ�Ŀ¼
	 * @param file_name
	 *            �����ļ����ļ���
	 * @param content
	 *            ��Ҫ���������
	 * @param charsetName
	 *            ���ֱ���
	 * @param stat_index
	 *            ���뿪ʼλ��
	 * @param len
	 *            ���³���
	 * @throws Exception
	 */
	public static void uodate_save(String file_path, String file_name,
			String content, String charsetName, int stat_index, int len)
			throws Exception {
		uodate_save(file_path, file_name, content.getBytes(charsetName),
				stat_index, len);
	}

	/**
	 * ɾ���ļ�
	 * 
	 * @param path
	 * @return
	 */
	public static boolean deleteAllFilesOfDir(File path) {
		System.out.println(path.getPath());
		if (!path.exists())
			return false;
		if (path.isFile()) {
			path.delete();
			return true;
		}
		File[] files = path.listFiles();
		for (int i = 0; i < files.length; i++) {
			deleteAllFilesOfDir(files[i]);
		}
		path.delete();
		return true;
	}

	/**
	 * ���Ҷ�Ӧ��׺���ļ�
	 * 
	 * @param file_path
	 *            �ļ����ڵ�·��
	 * @param end_with
	 *            �ļ��ĺ�׺
	 * @return
	 */
	@SuppressLint("NewApi")
	public static List<File> select_file(String file_path, String end_with) {
		if (file_path == null || file_path.isEmpty())
			throw new RuntimeException("file_path null or empty");
		if (end_with == null || end_with.isEmpty())
			throw new RuntimeException("file_path null or empty");
		File file = new File(file_path);
		if (!file.exists())
			return null;
		List<File> files = new ArrayList<File>();
		if (file.isDirectory()) {
			File[] f = file.listFiles();
			for (int i = 0; i < f.length; i++) {
				files.addAll(select_file(f[i].getAbsolutePath(), end_with));
			}
		} else {
			if (file_path.endsWith(end_with))
				files.add(file);
		}
		return files;
	}

	/**
	 * ���ļ�ת��Ϊ������
	 * 
	 * @param file
	 *            �ļ�·��������·����
	 * @return
	 * @throws Exception
	 */
	public static InputStream file2InputStream(String file) throws Exception {
		if (!isFile(file))
			throw new RuntimeException(
					"file is directory or not exists or null or empty");
		return new FileInputStream(file);
	}

	/**
	 * �Ƿ�Ϊ�ļ�
	 * 
	 * @param file
	 * @return
	 */
	public static boolean isFile(File file) {
		if (file == null || !file.exists() || file.isDirectory())
			return false;
		return true;
	}

	/**
	 * �Ƿ�Ϊ�ļ�
	 * 
	 * @param file
	 * @return
	 */
	public static boolean isFile(String file) {
		if (file == null || file.isEmpty())
			return false;
		return isFile(new File(file));
	}

	/**
	 * SDCard/Android/data/���Ӧ�õİ���/files/ Ŀ¼��һ���һЩ��ʱ�䱣������� ����->Ӧ��->Ӧ����������� �������
	 * xh 2017-3-13 ����9:46:25
	 * 
	 * @param context
	 * @param file_name
	 * @return
	 */
	public static File getExternalFilesDir(Context context) {
		return context.getExternalFilesDir(null);
	}

	/**
	 * /mnt/sdcard/Android/data/com.my
	 * 
	 * .app/files/test xh 2017-3-13 ����10:03:38
	 * 
	 * @param context
	 * @param file_name
	 * @return
	 */
	public static File getExternalFilesDir(Context context, String file_name) {
		return context.getExternalFilesDir(file_name);
	}

	/**
	 * SDCard/Android/data/���Ӧ�ð���/cache/Ŀ¼��һ������ʱ�������� ����->Ӧ��->Ӧ����������� ������� xh
	 * 2017-3-13 ����9:47:59
	 * 
	 * @param context
	 * @return
	 */
	public static File getExternalCacheDir(Context context) {
		return context.getExternalCacheDir();
	}

	/**
	 * ǰ�߻�ȡ���ľ��� /sdcard/Android/data/<application package>/cache ���·���������߻�ȡ������
	 * /data/data/<application package>/cache ���·�� xh 2017-3-13 ����9:49:36
	 * 
	 * @param context
	 * @return
	 */
	public static String getDiskCacheDir(Context context) {
		String cachePath = null;
		if (Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())
				|| !Environment.isExternalStorageRemovable()) {
			cachePath = context.getExternalCacheDir().getPath();
		} else {
			cachePath = context.getCacheDir().getPath();
		}
		return cachePath;
	}

	/**
	 * ��ȡdataĿ¼ xh 2017-3-13 ����9:52:32
	 * 
	 * @return
	 */
	public static File data() {
		return Environment.getDataDirectory();
	}

	/**
	 * ��ȡcacheĿ¼ xh 2017-3-13 ����9:53:20
	 * 
	 * @return
	 */
	public static File cache() {
		return Environment.getDownloadCacheDirectory();
	}

	/**
	 * ��ȡmnt/sdcardĿ¼ xh 2017-3-13 ����9:54:05
	 * 
	 * @return
	 */
	public static File mnt_sdcard() {
		return Environment.getExternalStorageDirectory();
	}

	/**
	 * ��ȡmnt/sdcard/name�ļ� xh 2017-3-13 ����9:55:29
	 * 
	 * @param name
	 * @return
	 */
	public static File mnt_sdcard(String name) {
		return Environment.getExternalStoragePublicDirectory(name);
	}

	/**
	 * system xh 2017-3-13 ����9:56:29
	 * 
	 * @return
	 */
	public static File system() {
		return Environment.getRootDirectory();
	}

	/**
	 * /data/app/com.my
	 * 
	 * .app-1.apk xh 2017-3-13 ����9:57:28
	 * 
	 * @param context
	 * @return
	 */
	public static String getPackageCodePath(Context context) {
		return context.getPackageCodePath();
	}

	/**
	 * /data/app/com.my
	 * 
	 * .app-1.apk xh 2017-3-13 ����9:58:18
	 * 
	 * @param context
	 * @return
	 */
	public static String getPackageResourcePath(Context context) {
		return context.getPackageResourcePath();
	}

	/**
	 * /data/data/com.my
	 * 
	 * .app/cache xh 2017-3-13 ����9:59:24
	 * 
	 * @param context
	 * @return
	 */
	public static File getCacheDir(Context context) {
		return context.getCacheDir();
	}

	/**
	 * /data/data/com.my
	 * 
	 * .app/databases/test xh 2017-3-13 ����10:00:11
	 * 
	 * @param context
	 * @param file_name
	 * @return
	 */
	public static File getDatabasePath(Context context, String file_name) {
		return context.getDatabasePath(file_name);
	}

	/**
	 * /data/data/com.my
	 * 
	 * .app/app_test xh 2017-3-13 ����10:01:37
	 * 
	 * @param context
	 * @param file_name
	 * @return
	 */
	public static File getDir(Context context, String file_name) {
		return context.getDir(file_name, Context.MODE_PRIVATE);
	}

	/**
	 * /data/data/com.my
	 * 
	 * .app/files xh 2017-3-13 ����10:04:51
	 * 
	 * @param context
	 * @return
	 */
	public static File getFilesDir(Context context) {
		return context.getFilesDir();
	}

	/**
	 * 
	 * lhl 2017-12-25 ����10:03:27 ˵�����Ƿ�װ��sdcard
	 * 
	 * @return boolean
	 */
	public static boolean sdcardIs() {
		return Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED);
	}

	/**
	 * fileת��λurl xh 2017-3-13 ����10:07:24
	 * 
	 * @param file
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static URL file2url(File file) {
		try {
			return file2uri(file).toURL();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * fileת��λuri xh 2017-3-13 ����10:07:56
	 * 
	 * @param file
	 * @return
	 */
	public static URI file2uri(File file) {
		return file.toURI();
	}

	/**
	 * urlת��λuri xh 2017-3-13 ����10:10:23
	 * 
	 * @param url
	 * @return
	 */
	public static URI url2uri(URL url) {
		try {
			return url.toURI();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * urlת��λfile xh 2017-3-13 ����10:10:55
	 * 
	 * @param url
	 * @return
	 */
	public static File url2file(URL url) {
		URI uri = url2uri(url);
		if (uri == null)
			return null;
		return new File(uri);
	}

	@SuppressLint("NewApi")
	public static class Apk implements Serializable {
		/**
	 * 
	 */
		private static final long serialVersionUID = -8979339748599574778L;
		String package_name;// ����
		String name;// Ӧ����
		Drawable ico;// Ӧ��ͼ��
		int versionCode;// �汾��
		String versionName;// �汾
		String path;// ����·��

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public String getPackage_name() {
			return package_name;
		}

		public void setPackage_name(String package_name) {
			this.package_name = package_name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Drawable getIco() {
			return ico;
		}

		public void setIco(Drawable ico) {
			this.ico = ico;
		}

		public int getVersionCode() {
			return versionCode;
		}

		public void setVersionCode(int versionCode) {
			this.versionCode = versionCode;
		}

		public String getVersionName() {
			return versionName;
		}

		public void setVersionName(String versionName) {
			this.versionName = versionName;
		}

	}
}
