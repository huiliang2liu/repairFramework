package com.xh.image;

import java.io.File;

import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

import com.xh.image.core.DisplayImageOptions;
import com.xh.image.core.ImageLoader;
import com.xh.image.core.assist.ImageScaleType;
import com.xh.image.core.display.CircleDisplayer;
import com.xh.image.core.display.HeartDisplayer;
import com.xh.image.core.display.PolygonDisplayer;
import com.xh.image.core.display.RoundedBitmapDisplayer;
import com.xh.image.core.display.SimpleBitmapDisplayer;
import com.xh.image.core.display.SimpleWidthBitmapDisplayer;
import com.xh.image.core.display.StarDisplayer;
import com.xh.util.XhImageUtile;

public class LoadImageManage {
	private static int showImageOnLoading = -1;// 加载中
	private static int showImageForEmptyUri = -1;// 路径错误
	private static int showImageOnFail = -1;// 加载失败
	private static DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder()
			.imageScaleType(ImageScaleType.IN_SAMPLE_INT)
			.bitmapConfig(Bitmap.Config.RGB_565).cacheInMemory(false) // 设置下载的图片是否缓存在内存中
			.cacheOnDisk(true);

	private LoadImageManage() {
		// TODO Auto-generated constructor stub
	}

	public static void setShowImageOnLoading(int showImageOnLoading) {
		LoadImageManage.showImageOnLoading = showImageOnLoading;
	}

	public static void setShowImageForEmptyUri(int showImageForEmptyUri) {
		LoadImageManage.showImageForEmptyUri = showImageForEmptyUri;
	}

	public static void setShowImageOnFail(int showImageOnFail) {
		LoadImageManage.showImageOnFail = showImageOnFail;
	}

	public static void setBuilder(DisplayImageOptions.Builder builder) {
		LoadImageManage.builder = builder;
	}

	/**
	 * 加载图片
	 * 
	 * @param src
	 *            资源id
	 * @param imageView
	 *            显示控件
	 */
	public static void src(int src, ImageView imageView) {
		LayoutParams lParams = imageView.getLayoutParams();
		int heigth = lParams.height;
		int width = lParams.width;
		Bitmap bitmap = XhImageUtile.src(heigth, width, src,
				imageView.getContext());
		imageView.setImageBitmap(bitmap);
	}

	/**
	 * 加载图片
	 * 
	 * @param bitmap
	 * @param imageView
	 */
	public static void bitmap(Bitmap bitmap, ImageView imageView) {
		imageView.setImageBitmap(bitmap);
	}

	/**
	 * 加载图片
	 * 
	 * @param file
	 *            图片文件
	 * @param imageView
	 *            显示控件
	 */
	public static void file(File file, ImageView imageView) {
		LayoutParams lParams = imageView.getLayoutParams();
		int heigth = lParams.height;
		int width = lParams.width;
		Bitmap bitmap = XhImageUtile.url(heigth, width, file.getPath());
		imageView.setImageBitmap(bitmap);
	}

	/**
	 * 加载图片
	 * 
	 * @param file
	 *            图片文件所在的地址
	 * @param imageView
	 *            显示控件
	 */
	public static void file(String file, ImageView imageView) {
		LayoutParams lParams = imageView.getLayoutParams();
		int heigth = lParams.height;
		int width = lParams.width;
		Bitmap bitmap = XhImageUtile.url(heigth, width, file);
		imageView.setImageBitmap(bitmap);
	}

	/**
	 * 加载图片
	 * 
	 * @param path
	 *            图片网络地址
	 * @param imageView
	 *            显示控件
	 */
	public static void url(String path, ImageView imageView) {
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(new SimpleBitmapDisplayer()));
	}

	/**
	 * 加载图片
	 * 
	 * @param path
	 *            图片网络地址
	 * @param imageView
	 *            显示控件
	 */
	public static void url_width(String path, ImageView imageView) {
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(
						new SimpleWidthBitmapDisplayer()));
	}

	/**
	 * 加载图片
	 * 
	 * @param path
	 *            图片网络地址
	 * @param imageView
	 *            显示控件
	 * @param showImageOnLoading
	 *            加载中显示的图片
	 * @param showImageForEmptyUri
	 *            网络地址错误显示的图片
	 * @param showImageOnFail
	 *            加载失败显示的图片
	 */
	public static void url(String path, ImageView imageView,
			int showImageOnLoading, int showImageForEmptyUri,
			int showImageOnFail) {
		// TODO Auto-generated method stub
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(new SimpleBitmapDisplayer()));
	}

	/**
	 * 加载图片
	 * 
	 * @param path
	 *            图片网络地址
	 * @param imageView
	 *            显示控件
	 * @param round
	 *            圆角
	 */
	public static void url_round(String path, ImageView imageView, int round) {
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(
						new RoundedBitmapDisplayer(round)));
	}

	/**
	 * 加载图片
	 * 
	 * @param path
	 *            图片网络地址
	 * @param imageView
	 *            显示控件
	 * @param showImageOnLoading
	 *            加载中显示的图片
	 * @param showImageForEmptyUri
	 *            网络地址错误显示的图片
	 * @param showImageOnFail
	 *            加载失败显示的图片
	 * @param round
	 *            圆角
	 */
	public static void url_round(String path, ImageView imageView,
			int showImageOnLoading, int showImageForEmptyUri,
			int showImageOnFail, int round) {
		// TODO Auto-generated method stub
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(new CircleDisplayer()));
	}

	/**
	 * 加载图片
	 * 
	 * @param path
	 *            图片网络地址
	 * @param imageView
	 *            显示控件
	 */
	public static void url_heart(String path, ImageView imageView) {
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(new HeartDisplayer()));
	}

	/**
	 * 加载图片
	 * 
	 * @param path
	 *            图片网络地址
	 * @param imageView
	 *            显示控件
	 * @param showImageOnLoading
	 *            加载中显示的图片
	 * @param showImageForEmptyUri
	 *            网络地址错误显示的图片
	 * @param showImageOnFail
	 *            加载失败显示的图片
	 */
	public static void url_heart(String path, ImageView imageView,
			int showImageOnLoading, int showImageForEmptyUri,
			int showImageOnFail) {
		// TODO Auto-generated method stub
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(new HeartDisplayer()));
	}

	/**
	 * 加载图片
	 * 
	 * @param path
	 *            图片网络地址
	 * @param imageView
	 *            显示控件
	 */
	public static void url_circle(String path, ImageView imageView) {
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(new CircleDisplayer()));
	}

	/**
	 * 加载图片
	 * 
	 * @param path
	 *            图片网络地址
	 * @param imageView
	 *            显示控件
	 */
	public static void url_circle(String path, ImageView imageView, boolean zoom) {
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(
						new CircleDisplayer().set_zoom(zoom)));
	}

	/**
	 * 加载图片
	 * 
	 * @param path
	 *            图片网络地址
	 * @param imageView
	 *            显示控件
	 * @param showImageOnLoading
	 *            加载中显示的图片
	 * @param showImageForEmptyUri
	 *            网络地址错误显示的图片
	 * @param showImageOnFail
	 *            加载失败显示的图片
	 */
	public static void url_circle(String path, ImageView imageView,
			int showImageOnLoading, int showImageForEmptyUri,
			int showImageOnFail) {
		// TODO Auto-generated method stub
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(new CircleDisplayer()));
	}

	/**
	 * 加载图片
	 * 
	 * @param path
	 *            图片网络地址
	 * @param imageView
	 *            显示控件
	 * @param edges
	 *            圆角
	 */
	public static void url_polygon(String path, ImageView imageView, int edges) {
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(new PolygonDisplayer(edges)));
	}

	/**
	 * 加载图片
	 * 
	 * @param path
	 *            图片网络地址
	 * @param imageView
	 *            显示控件
	 * @param showImageOnLoading
	 *            加载中显示的图片
	 * @param showImageForEmptyUri
	 *            网络地址错误显示的图片
	 * @param showImageOnFail
	 *            加载失败显示的图片
	 * @param edges
	 *            圆角
	 */
	public static void url_polygon(String path, ImageView imageView,
			int showImageOnLoading, int showImageForEmptyUri,
			int showImageOnFail, int edges) {
		// TODO Auto-generated method stub
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(new PolygonDisplayer(edges)));
	}

	/**
	 * 加载图片
	 * 
	 * @param path
	 *            图片网络地址
	 * @param imageView
	 *            显示控件
	 */
	public static void url_star(String path, ImageView imageView) {
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(new StarDisplayer()));
	}

	/**
	 * 加载图片
	 * 
	 * @param path
	 *            图片网络地址
	 * @param imageView
	 *            显示控件
	 * @param showImageOnLoading
	 *            加载中显示的图片
	 * @param showImageForEmptyUri
	 *            网络地址错误显示的图片
	 * @param showImageOnFail
	 *            加载失败显示的图片
	 */
	public static void url_star(String path, ImageView imageView,
			int showImageOnLoading, int showImageForEmptyUri,
			int showImageOnFail) {
		// TODO Auto-generated method stub
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(new StarDisplayer()));
	}

	public static void load(String path, ImageView imageView,
			DisplayImageOptions.Builder builder) {
		ImageLoader.getInstance().displayImage(
				path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).build());
	}

	public static DisplayImageOptions.Builder builder(int showImageOnLoading,
			int showImageForEmptyUri, int showImageOnFail) {
		if (showImageOnLoading != -1)
			builder.showImageOnLoading(showImageOnFail);
		if (showImageForEmptyUri != -1)
			builder.showImageForEmptyUri(showImageForEmptyUri);
		if (showImageOnFail != -1)
			builder.showImageOnFail(showImageOnFail);
		return builder;
	}
}
