package com.xh.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.xmlpull.v1.XmlPullParser;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * @version 创建时间：2017-11-30 上午10:20:16 项目：JS 包名：com.xh.res.parse
 *          文件名：XmlPullParserUtil.java 作者：lhl 说明:创建XmlPullParser
 */

public class XmlPullParserUtil {
	private final static String TAG = XmlPullParserUtil.class.getName();

	public static XmlResourceParser apk2PullParser(ZipInputStream zis,
			String filrName) {
		XmlResourceParser rp = null;
		try {
			ZipEntry zipEntry = null;
			while ((zipEntry = zis.getNextEntry()) != null) {
				String name = zipEntry.getName();
				if (name.contains(filrName))
					break;
				zis.closeEntry();
			}
			rp = is2PullParser(zis);
			if (zipEntry != null)
				zis.closeEntry();
			zis.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rp;
	}

	public static XmlResourceParser is2PullParser(InputStream is) {
		XmlResourceParser rp = null;
		if (is == null)
			throw new RuntimeException("inputStream is null");
		try {
			rp = bytes2PullParser(is2byte(is));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			is.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rp;
	}

	public static XmlResourceParser bytes2PullParser(byte[] buff) {
		XmlResourceParser rp = null;
		try {
			Class xmlBlock = Class.forName("android.content.res.XmlBlock");
			Constructor constructors = xmlBlock
					.getDeclaredConstructor(byte[].class);
			if (!constructors.isAccessible())
				constructors.setAccessible(true);
			Object object = constructors.newInstance(buff);
			Method newParser = xmlBlock.getMethod("newParser");
			Method close = xmlBlock.getMethod("close");
			rp = (XmlResourceParser) newParser.invoke(object);
			close.invoke(object);
			// 441 block.close();
			// 442 return rp;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rp;
	}

	/**
	 * 
	 * lhl 2017-11-15 下午5:35:43 说明：将数据流转化为字节数组并且关闭输入流
	 * 
	 * @param is
	 * @return byte[]
	 */
	public static byte[] is2byte(InputStream is) {
		if (is == null)
			return null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte[] buffer = new byte[1024];
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			baos.flush();
			byte[] arr = baos.toByteArray();
			baos.close();
			is.close();
			return arr;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * lhl 2017-11-30 上午10:30:02 说明：将xml文件转为XmlPullParser,解析失败返回null
	 * 
	 * @param context
	 * @param fileName
	 * @return XmlPullParser
	 */
	public static XmlResourceParser xml2xmlPullParser(Context context,
			String fileName) {
		try {
			return context.getAssets().openXmlResourceParser(fileName);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	/**
	 * 
	 * lhl 2017-11-30 上午10:33:02 说明：将xmlPullParser转为View对象
	 * 
	 * @param context
	 * @param xmlPullParser
	 * @return View
	 */
	public static View xmlPullParser2view(Context context,
			XmlResourceParser xmlPullParser) {
		View view = LayoutInflater.from(context).inflate(xmlPullParser, null);
		xmlPullParser.close();
		return view;
	}

	/**
	 * 
	 * lhl 2017-11-30 上午10:35:22 说明：将xml文件转化为布局
	 * 
	 * @param context
	 * @param fileName
	 * @return View
	 */
	public static View xml2view(Context context, String fileName) {
		return xmlPullParser2view(context, xml2xmlPullParser(context, fileName));
	}

	/**
	 * 
	 * lhl 2017-11-30 上午10:40:57 说明：将XmlPullParser转化为Animation
	 * 
	 * @param context
	 * @param xmlPullParser
	 * @return Animation
	 */
	public static Animation xmlPullParser2animation(Context context,
			XmlResourceParser xmlPullParser) {
		Class c = AnimationUtils.class;
		Class parameterTypes[] = { Context.class, XmlPullParser.class };
		try {
			Method method = c.getDeclaredMethod("createAnimationFromXml",
					parameterTypes);
			method.setAccessible(true);
			Object args[] = { context, xmlPullParser };
			Animation animation = (Animation) method.invoke(null, args);
			xmlPullParser.close();
			return animation;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	/**
	 * 
	 * lhl 2017-11-30 上午10:42:16 说明：将xml文件转化为animation
	 * 
	 * @param context
	 * @param fileName
	 * @return Animation
	 */
	public static Animation xml2animation(Context context, String fileName) {
		return xmlPullParser2animation(context,
				xml2xmlPullParser(context, fileName));
	}

	/**
	 * 
	 * lhl 2017-11-30 上午11:00:48 说明：将xmlPullParser转为Drawable
	 * 
	 * @param context
	 * @param xmlPullParser
	 * @return Drawable
	 */
	public static Drawable xmlPullParser2drawable(Context context,
			XmlResourceParser xmlPullParser) {
		try {
			Drawable drawable = Drawable.createFromXml(context.getResources(),
					xmlPullParser);
			xmlPullParser.close();
			return drawable;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	/**
	 * 
	 * lhl 2017-11-30 上午11:10:27 说明：xml转为Drawable
	 * 
	 * @param context
	 * @param fileName
	 * @return Drawable
	 */
	public static Drawable xml2drawable(Context context, String fileName) {
		return xmlPullParser2drawable(context,
				xml2xmlPullParser(context, fileName));
	}

	/**
	 * 
	 * lhl 2017-11-30 上午11:09:35 说明：将xmlPullParser转为ColorStateList
	 * 
	 * @param context
	 * @param xmlPullParser
	 * @return ColorStateList
	 */
	public static ColorStateList xmlPullParser2colorStateList(Context context,
			XmlResourceParser xmlPullParser) {
		try {
			ColorStateList csl = ColorStateList.createFromXml(
					context.getResources(), xmlPullParser);
			xmlPullParser.close();
			return csl;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}

	}

	/**
	 * 
	 * lhl 2017-11-30 上午11:10:50 说明：xml转为ColorStateList
	 * 
	 * @param context
	 * @param fileName
	 * @return ColorStateList
	 */
	public static ColorStateList xml2colorStateList(Context context,
			String fileName) {
		return xmlPullParser2colorStateList(context,
				xml2xmlPullParser(context, fileName));
	}

	/**
	 * 
	 * lhl 2017-11-30 下午12:09:41 说明：
	 * 
	 * @param string
	 * @return ColorStateList
	 */
	public static ColorStateList string2colorStateList(String string) {
		int color;
		switch (string.length()) {
		case 3: {
			int r = Integer.valueOf(string.substring(0, 1), 16);
			int g = Integer.valueOf(string.substring(1, 2), 16);
			int b = Integer.valueOf(string.substring(2, 3), 16);
			color = Color.rgb(255 * r >> 4, 255 * g >> 4, 255 * b >> 4);
		}
			break;
		case 4: {
			int a = Integer.valueOf(string.substring(0, 1), 16);
			int r = Integer.valueOf(string.substring(1, 2), 16);
			int g = Integer.valueOf(string.substring(2, 3), 16);
			int b = Integer.valueOf(string.substring(3, 4), 16);
			color = Color.argb(255 * a >> 4, 255 * r >> 4, 255 * g >> 4,
					255 * b >> 4);
		}
			break;
		case 6: {
			int r = Integer.valueOf(string.substring(0, 2), 16);
			int g = Integer.valueOf(string.substring(2, 4), 16);
			int b = Integer.valueOf(string.substring(4, 6), 16);
			color = Color.rgb(r, g, b);
		}
			break;
		case 8: {
			int a = Integer.valueOf(string.substring(0, 2), 16);
			int r = Integer.valueOf(string.substring(2, 4), 16);
			int g = Integer.valueOf(string.substring(4, 6), 16);
			int b = Integer.valueOf(string.substring(6, 8), 16);
			color = Color.argb(a, r, g, b);
		}
			break;
		default:
			throw new RuntimeException("没有这个颜色");
		}
		return ColorStateList.valueOf(color);
	}
}
