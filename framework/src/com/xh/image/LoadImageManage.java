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
	private static int showImageOnLoading = -1;// ������
	private static int showImageForEmptyUri = -1;// ·������
	private static int showImageOnFail = -1;// ����ʧ��
	private static DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder()
			.imageScaleType(ImageScaleType.IN_SAMPLE_INT)
			.bitmapConfig(Bitmap.Config.RGB_565).cacheInMemory(false) // �������ص�ͼƬ�Ƿ񻺴����ڴ���
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
	 * ����ͼƬ
	 * 
	 * @param src
	 *            ��Դid
	 * @param imageView
	 *            ��ʾ�ؼ�
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
	 * ����ͼƬ
	 * 
	 * @param bitmap
	 * @param imageView
	 */
	public static void bitmap(Bitmap bitmap, ImageView imageView) {
		imageView.setImageBitmap(bitmap);
	}

	/**
	 * ����ͼƬ
	 * 
	 * @param file
	 *            ͼƬ�ļ�
	 * @param imageView
	 *            ��ʾ�ؼ�
	 */
	public static void file(File file, ImageView imageView) {
		LayoutParams lParams = imageView.getLayoutParams();
		int heigth = lParams.height;
		int width = lParams.width;
		Bitmap bitmap = XhImageUtile.url(heigth, width, file.getPath());
		imageView.setImageBitmap(bitmap);
	}

	/**
	 * ����ͼƬ
	 * 
	 * @param file
	 *            ͼƬ�ļ����ڵĵ�ַ
	 * @param imageView
	 *            ��ʾ�ؼ�
	 */
	public static void file(String file, ImageView imageView) {
		LayoutParams lParams = imageView.getLayoutParams();
		int heigth = lParams.height;
		int width = lParams.width;
		Bitmap bitmap = XhImageUtile.url(heigth, width, file);
		imageView.setImageBitmap(bitmap);
	}

	/**
	 * ����ͼƬ
	 * 
	 * @param path
	 *            ͼƬ�����ַ
	 * @param imageView
	 *            ��ʾ�ؼ�
	 */
	public static void url(String path, ImageView imageView) {
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(new SimpleBitmapDisplayer()));
	}

	/**
	 * ����ͼƬ
	 * 
	 * @param path
	 *            ͼƬ�����ַ
	 * @param imageView
	 *            ��ʾ�ؼ�
	 */
	public static void url_width(String path, ImageView imageView) {
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(
						new SimpleWidthBitmapDisplayer()));
	}

	/**
	 * ����ͼƬ
	 * 
	 * @param path
	 *            ͼƬ�����ַ
	 * @param imageView
	 *            ��ʾ�ؼ�
	 * @param showImageOnLoading
	 *            ��������ʾ��ͼƬ
	 * @param showImageForEmptyUri
	 *            �����ַ������ʾ��ͼƬ
	 * @param showImageOnFail
	 *            ����ʧ����ʾ��ͼƬ
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
	 * ����ͼƬ
	 * 
	 * @param path
	 *            ͼƬ�����ַ
	 * @param imageView
	 *            ��ʾ�ؼ�
	 * @param round
	 *            Բ��
	 */
	public static void url_round(String path, ImageView imageView, int round) {
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(
						new RoundedBitmapDisplayer(round)));
	}

	/**
	 * ����ͼƬ
	 * 
	 * @param path
	 *            ͼƬ�����ַ
	 * @param imageView
	 *            ��ʾ�ؼ�
	 * @param showImageOnLoading
	 *            ��������ʾ��ͼƬ
	 * @param showImageForEmptyUri
	 *            �����ַ������ʾ��ͼƬ
	 * @param showImageOnFail
	 *            ����ʧ����ʾ��ͼƬ
	 * @param round
	 *            Բ��
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
	 * ����ͼƬ
	 * 
	 * @param path
	 *            ͼƬ�����ַ
	 * @param imageView
	 *            ��ʾ�ؼ�
	 */
	public static void url_heart(String path, ImageView imageView) {
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(new HeartDisplayer()));
	}

	/**
	 * ����ͼƬ
	 * 
	 * @param path
	 *            ͼƬ�����ַ
	 * @param imageView
	 *            ��ʾ�ؼ�
	 * @param showImageOnLoading
	 *            ��������ʾ��ͼƬ
	 * @param showImageForEmptyUri
	 *            �����ַ������ʾ��ͼƬ
	 * @param showImageOnFail
	 *            ����ʧ����ʾ��ͼƬ
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
	 * ����ͼƬ
	 * 
	 * @param path
	 *            ͼƬ�����ַ
	 * @param imageView
	 *            ��ʾ�ؼ�
	 */
	public static void url_circle(String path, ImageView imageView) {
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(new CircleDisplayer()));
	}

	/**
	 * ����ͼƬ
	 * 
	 * @param path
	 *            ͼƬ�����ַ
	 * @param imageView
	 *            ��ʾ�ؼ�
	 */
	public static void url_circle(String path, ImageView imageView, boolean zoom) {
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(
						new CircleDisplayer().set_zoom(zoom)));
	}

	/**
	 * ����ͼƬ
	 * 
	 * @param path
	 *            ͼƬ�����ַ
	 * @param imageView
	 *            ��ʾ�ؼ�
	 * @param showImageOnLoading
	 *            ��������ʾ��ͼƬ
	 * @param showImageForEmptyUri
	 *            �����ַ������ʾ��ͼƬ
	 * @param showImageOnFail
	 *            ����ʧ����ʾ��ͼƬ
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
	 * ����ͼƬ
	 * 
	 * @param path
	 *            ͼƬ�����ַ
	 * @param imageView
	 *            ��ʾ�ؼ�
	 * @param edges
	 *            Բ��
	 */
	public static void url_polygon(String path, ImageView imageView, int edges) {
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(new PolygonDisplayer(edges)));
	}

	/**
	 * ����ͼƬ
	 * 
	 * @param path
	 *            ͼƬ�����ַ
	 * @param imageView
	 *            ��ʾ�ؼ�
	 * @param showImageOnLoading
	 *            ��������ʾ��ͼƬ
	 * @param showImageForEmptyUri
	 *            �����ַ������ʾ��ͼƬ
	 * @param showImageOnFail
	 *            ����ʧ����ʾ��ͼƬ
	 * @param edges
	 *            Բ��
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
	 * ����ͼƬ
	 * 
	 * @param path
	 *            ͼƬ�����ַ
	 * @param imageView
	 *            ��ʾ�ؼ�
	 */
	public static void url_star(String path, ImageView imageView) {
		load(path,
				imageView,
				builder(showImageOnLoading, showImageForEmptyUri,
						showImageOnFail).displayer(new StarDisplayer()));
	}

	/**
	 * ����ͼƬ
	 * 
	 * @param path
	 *            ͼƬ�����ַ
	 * @param imageView
	 *            ��ʾ�ؼ�
	 * @param showImageOnLoading
	 *            ��������ʾ��ͼƬ
	 * @param showImageForEmptyUri
	 *            �����ַ������ʾ��ͼƬ
	 * @param showImageOnFail
	 *            ����ʧ����ʾ��ͼƬ
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
