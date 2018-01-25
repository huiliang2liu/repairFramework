package com.xh.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.net.Uri;
import android.util.DisplayMetrics;

/**
 * @version ����ʱ�䣺2018-1-3 ����9:41:58 ��Ŀ��repair ������com.xh.util �ļ�����ApkUtil.java
 *          ���ߣ�lhl ˵��:
 */

public class ApkUtil {
	/**
	 * 
	 * lhl 2018-1-3 ����9:42:57 ˵������ȡapkǩ��
	 * 
	 * @param apkPath
	 * @return String
	 */
	public static String showUninstallAPKSignatures(String apkPath) {
		String PATH_PackageParser = "android.content.pm.PackageParser";
		try {
			// apk�����ļ�·��
			// ����һ��Package ������, �����ص�
			// ���캯���Ĳ���ֻ��һ��, apk�ļ���·��
			// PackageParser packageParser = new PackageParser(apkPath);
			Class pkgParserCls = Class.forName(PATH_PackageParser);
			Class[] typeArgs = new Class[1];
			typeArgs[0] = String.class;
			Constructor pkgParserCt = pkgParserCls.getConstructor(typeArgs);
			Object[] valueArgs = new Object[1];
			valueArgs[0] = apkPath;
			Object pkgParser = pkgParserCt.newInstance(valueArgs);
			// ���������ʾ�йص�, �����漰��һЩ������ʾ�ȵ�, ����ʹ��Ĭ�ϵ����
			DisplayMetrics metrics = new DisplayMetrics();
			metrics.setToDefaults();
			// PackageParser.Package mPkgInfo = packageParser.parsePackage(new
			// File(apkPath), apkPath,
			// metrics, 0);
			typeArgs = new Class[4];
			typeArgs[0] = File.class;
			typeArgs[1] = String.class;
			typeArgs[2] = DisplayMetrics.class;
			typeArgs[3] = Integer.TYPE;
			Method pkgParser_parsePackageMtd = pkgParserCls.getDeclaredMethod(
					"parsePackage", typeArgs);
			valueArgs = new Object[4];
			valueArgs[0] = new File(apkPath);
			valueArgs[1] = apkPath;
			valueArgs[2] = metrics;
			valueArgs[3] = PackageManager.GET_SIGNATURES;
			Object pkgParserPkg = pkgParser_parsePackageMtd.invoke(pkgParser,
					valueArgs);

			typeArgs = new Class[2];
			typeArgs[0] = pkgParserPkg.getClass();
			typeArgs[1] = Integer.TYPE;
			Method pkgParser_collectCertificatesMtd = pkgParserCls
					.getDeclaredMethod("collectCertificates", typeArgs);
			valueArgs = new Object[2];
			valueArgs[0] = pkgParserPkg;
			valueArgs[1] = PackageManager.GET_SIGNATURES;
			pkgParser_collectCertificatesMtd.invoke(pkgParser, valueArgs);
			// Ӧ�ó�����Ϣ��, ���������, ������Щ����, ����û����
			Field packageInfoFld = pkgParserPkg.getClass().getDeclaredField(
					"mSignatures");
			Signature[] info = (Signature[]) packageInfoFld.get(pkgParserPkg);
			return info[0].toCharsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��ȡapp SHA1
	 * 
	 * @param context
	 * @return
	 */
	public static String sHA1(Context context) {
		try {
			PackageInfo info = context.getPackageManager().getPackageInfo(
					context.getPackageName(), PackageManager.GET_SIGNATURES);
			byte[] cert = info.signatures[0].toByteArray();
			MessageDigest md = MessageDigest.getInstance("SHA1");
			byte[] publicKey = md.digest(cert);
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < publicKey.length; i++) {
				String appendString = Integer.toHexString(0xFF & publicKey[i])
						.toUpperCase(Locale.US);
				if (appendString.length() == 1)
					hexString.append("0");
				hexString.append(appendString);
				hexString.append(":");
			}
			String result = hexString.toString();
			return result.substring(0, result.length() - 1);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * lhl 2018-1-3 ����9:46:36 ˵������ȡǩ��
	 * 
	 * @param context
	 * @return String
	 */
	public static String getSign(Context context) {
		return getSign(context, context.getPackageName());
	}

	/**
	 * 
	 * lhl 2018-1-3 ����9:50:12 ˵������ȡָ��������ǩ��
	 * 
	 * @param context
	 * @param packageName
	 * @return String
	 */
	public static String getSign(Context context, String packageName) {
		try {
			PackageInfo packageInfo = context.getPackageManager()
					.getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
			return packageInfo.signatures[0].toCharsString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 
	 * lhl 2018-1-3 ����9:51:46 ˵����
	 * 
	 * @param sign
	 * @return Map<String,String>
	 */
	public Map<String, String> parseSignature(String sign) {
		try {
			CertificateFactory certFactory = CertificateFactory
					.getInstance("X.509");
			X509Certificate cert = (X509Certificate) certFactory
					.generateCertificate(new ByteArrayInputStream(sign
							.getBytes()));
			String pubKey = cert.getPublicKey().toString();
			String signNumber = cert.getSerialNumber().toString();
			Map<String, String> map = new HashMap<String, String>();
			map.put("signName", cert.getSigAlgName());
			map.put("pubKey", pubKey);
			map.put("signNumber", signNumber);
			map.put("subjectDN", cert.getSubjectDN().toString());
		} catch (CertificateException e) {
			e.printStackTrace();
		}
		return null;
	}
	/** ��װһ��apk�ļ� */
    public static void install(Context context, File uriFile) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(uriFile), "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /** ж��һ��app */
    public static void uninstall(Context context, String packageName) {
        //ͨ������İ�������URI
        Uri packageURI = Uri.parse("package:" + packageName);
        //����Intent��ͼ
        Intent intent = new Intent(Intent.ACTION_DELETE, packageURI);
        //ִ��ж�س���
        context.startActivity(intent);
    }

    /** ����ֻ����Ƿ�װ��ָ������� */
    public static boolean isAvailable(Context context, String packageName) {
        // ��ȡpackagemanager
        final PackageManager packageManager = context.getPackageManager();
        // ��ȡ�����Ѱ�װ����İ���Ϣ
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
        // ���ڴ洢�����Ѱ�װ����İ���
        List<String> packageNames = new ArrayList<>();
        // ��pinfo�н���������һȡ����ѹ��pName list��
        if (packageInfos != null) {
            for (int i = 0; i < packageInfos.size(); i++) {
                String packName = packageInfos.get(i).packageName;
                packageNames.add(packName);
            }
        }
        // �ж�packageNames���Ƿ���Ŀ�����İ�������TRUE��û��FALSE
        return packageNames.contains(packageName);
    }

    /** ����ֻ����Ƿ�װ��ָ������� */
    public static boolean isAvailable(Context context, File file) {
        return isAvailable(context, getPackageName(context, file.getAbsolutePath()));
    }

    /** �����ļ�·����ȡ���� */
    public static String getPackageName(Context context, String filePath) {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo info = packageManager.getPackageArchiveInfo(filePath, PackageManager.GET_ACTIVITIES);
        if (info != null) {
            ApplicationInfo appInfo = info.applicationInfo;
            return appInfo.packageName;  //�õ���װ������
        }
        return null;
    }

    /** ��apk�л�ȡ�汾��Ϣ */
    public static String getChannelFromApk(Context context, String channelPrefix) {
        //��apk���л�ȡ
        ApplicationInfo appinfo = context.getApplicationInfo();
        String sourceDir = appinfo.sourceDir;
        //Ĭ�Ϸ���meta-inf/� ������Ҫ��ƴ��һ��
        String key = "META-INF/" + channelPrefix;
        String ret = "";
        ZipFile zipfile = null;
        try {
            zipfile = new ZipFile(sourceDir);
            Enumeration<?> entries = zipfile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = ((ZipEntry) entries.nextElement());
                String entryName = entry.getName();
                if (entryName.startsWith(key)) {
                    ret = entryName;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (zipfile != null) {
                try {
                    zipfile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String[] split = ret.split(channelPrefix);
        String channel = "";
        if (split.length >= 2) {
            channel = ret.substring(key.length());
        }
        return channel;
    }
}
