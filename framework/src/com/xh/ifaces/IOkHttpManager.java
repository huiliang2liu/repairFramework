package com.xh.ifaces;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.graphics.Bitmap;

import com.xh.http.RequestMethod;
import com.xh.http.rest.OnResponseListener;
import com.xh.http.rest.Response;

public interface IOkHttpManager {
	/**
	 * 
	 * 2018 2018-1-22 上午10:45:03 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param listener
	 * @param requestMethod
	 *            void
	 */
	public void stringAsyn(int what, String url, Map<String, Object> params,
			OnResponseListener<String> listener, RequestMethod requestMethod);

	/**
	 * 
	 * 2018 2018-1-22 上午10:44:57 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void stringAsynGet(int what, String url, Map<String, Object> params,
			OnResponseListener<String> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:44:52 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void stringAsynGet(String url, Map<String, Object> params,
			OnResponseListener<String> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:44:48 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param listener
	 *            void
	 */
	public void stringAsynGet(String url, OnResponseListener<String> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:44:46 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 *            void
	 */
	public void stringAsynGet(String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:44:31 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 *            void
	 */
	public void stringAsynGet(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:44:26 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 *            void
	 */
	public void stringAsynGet(int what, String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:44:22 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param listener
	 *            void
	 */
	public void stringAsynGet(int what, String url,
			OnResponseListener<String> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:44:17 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void stringAsynPost(int what, String url,
			Map<String, Object> params, OnResponseListener<String> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:44:12 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void stringAsynPost(String url, Map<String, Object> params,
			OnResponseListener<String> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:44:08 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param listener
	 *            void
	 */
	public void stringAsynPost(String url, OnResponseListener<String> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:44:04 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 *            void
	 */
	public void stringAsynPost(String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:43:59 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 *            void
	 */
	public void stringAsynPost(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:43:50 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param listener
	 *            void
	 */
	public void stringAsynPost(int what, String url,
			OnResponseListener<String> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:43:46 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 *            void
	 */
	public void stringAsynPost(int what, String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:43:41 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param listener
	 * @param requestMethod
	 *            void
	 */
	public void jsonObjectAsyn(int what, String url,
			Map<String, Object> params,
			OnResponseListener<JSONObject> listener, RequestMethod requestMethod);

	/**
	 * 
	 * 2018 2018-1-22 上午10:43:37 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void jsonObjectAsynGet(int what, String url,
			Map<String, Object> params, OnResponseListener<JSONObject> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:43:32 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void jsonObjectAsynGet(String url, Map<String, Object> params,
			OnResponseListener<JSONObject> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:43:28 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param listener
	 *            void
	 */
	public void jsonObjectAsynGet(String url,
			OnResponseListener<JSONObject> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:43:18 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 *            void
	 */
	public void jsonObjectAsynGet(String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:43:14 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 *            void
	 */
	public void jsonObjectAsynGet(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:43:09 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param listener
	 *            void
	 */
	public void jsonObjectAsynGet(int what, String url,
			OnResponseListener<JSONObject> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:43:04 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 *            void
	 */
	public void jsonObjectAsynGet(int what, String url,
			Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:43:00 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void jsonObjectAsynPost(int what, String url,
			Map<String, Object> params, OnResponseListener<JSONObject> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:42:55 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void jsonObjectAsynPost(String url, Map<String, Object> params,
			OnResponseListener<JSONObject> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:42:50 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param listener
	 *            void
	 */
	public void jsonObjectAsynPost(String url,
			OnResponseListener<JSONObject> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:42:39 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 *            void
	 */
	public void jsonObjectAsynPost(String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:42:34 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 *            void
	 */
	public void jsonObjectAsynPost(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:42:29 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param listener
	 *            void
	 */
	public void jsonObjectAsynPost(int what, String url,
			OnResponseListener<JSONObject> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:42:24 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 *            void
	 */
	public void jsonObjectAsynPost(int what, String url,
			Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:42:20 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param listener
	 * @param requestMethod
	 *            void
	 */
	public void jsonArrayAsyn(int what, String url, Map<String, Object> params,
			OnResponseListener<JSONArray> listener, RequestMethod requestMethod);

	/**
	 * 
	 * 2018 2018-1-22 上午10:42:15 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void jsonArrayAsynGet(int what, String url,
			Map<String, Object> params, OnResponseListener<JSONArray> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:42:07 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void jsonArrayAsynGet(String url, Map<String, Object> params,
			OnResponseListener<JSONArray> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:42:02 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param listener
	 *            void
	 */
	public void jsonArrayAsynGet(String url,
			OnResponseListener<JSONArray> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:41:58 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 *            void
	 */
	public void jsonArrayAsynGet(String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:41:53 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 *            void
	 */
	public void jsonArrayAsynGet(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:41:49 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param listener
	 *            void
	 */
	public void jsonArrayAsynGet(int what, String url,
			OnResponseListener<JSONArray> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:41:44 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 *            void
	 */
	public void jsonArrayAsynGet(int what, String url,
			Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:41:40 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void jsonArrayAsynPost(int what, String url,
			Map<String, Object> params, OnResponseListener<JSONArray> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:41:31 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void jsonArrayAsynPost(String url, Map<String, Object> params,
			OnResponseListener<JSONArray> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:41:23 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param listener
	 *            void
	 */
	public void jsonArrayAsynPost(String url,
			OnResponseListener<JSONArray> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:41:19 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 *            void
	 */
	public void jsonArrayAsynPost(String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:41:11 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 *            void
	 */
	public void jsonArrayAsynPost(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:41:07 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param listener
	 *            void
	 */
	public void jsonArrayAsynPost(int what, String url,
			OnResponseListener<JSONArray> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:41:03 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 *            void
	 */
	public void jsonArrayAsynPost(int what, String url,
			Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:40:58 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param listener
	 * @param requestMethod
	 *            void
	 */
	public void bitmapAsyn(int what, String url, Map<String, Object> params,
			OnResponseListener<Bitmap> listener, RequestMethod requestMethod);

	/**
	 * 
	 * 2018 2018-1-22 上午10:40:48 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void bitmapAsynGet(int what, String url, Map<String, Object> params,
			OnResponseListener<Bitmap> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:40:43 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void bitmapAsynGet(String url, Map<String, Object> params,
			OnResponseListener<Bitmap> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:40:35 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param listener
	 *            void
	 */
	public void bitmapAsynGet(String url, OnResponseListener<Bitmap> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:40:31 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 *            void
	 */
	public void bitmapAsynGet(String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:40:25 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 *            void
	 */
	public void bitmapAsynGet(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:40:21 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param listener
	 *            void
	 */
	public void bitmapAsynGet(int what, String url,
			OnResponseListener<Bitmap> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:40:17 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 *            void
	 */
	public void bitmapAsynGet(int what, String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:40:11 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void bitmapAsynPost(int what, String url,
			Map<String, Object> params, OnResponseListener<Bitmap> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:40:01 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void bitmapAsynPost(String url, Map<String, Object> params,
			OnResponseListener<Bitmap> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:39:57 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param listener
	 *            void
	 */
	public void bitmapAsynPost(String url, OnResponseListener<Bitmap> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:39:51 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 *            void
	 */
	public void bitmapAsynPost(String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:39:47 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 *            void
	 */
	public void bitmapAsynPost(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:39:43 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param listener
	 *            void
	 */
	public void bitmapAsynPost(int what, String url,
			OnResponseListener<Bitmap> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:39:38 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 *            void
	 */
	public void bitmapAsynPost(int what, String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:39:34 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param listener
	 * @param requestMethod
	 *            void
	 */
	public void bytesAsyn(int what, String url, Map<String, Object> params,
			OnResponseListener<byte[]> listener, RequestMethod requestMethod);

	/**
	 * 
	 * 2018 2018-1-22 上午10:39:24 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void bytesAsynGet(int what, String url, Map<String, Object> params,
			OnResponseListener<byte[]> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:39:19 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void bytesAsynGet(String url, Map<String, Object> params,
			OnResponseListener<byte[]> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:39:14 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param listener
	 *            void
	 */
	public void bytesAsynGet(String url, OnResponseListener<byte[]> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:39:09 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 *            void
	 */
	public void bytesAsynGet(String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:39:04 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 *            void
	 */
	public void bytesAsynGet(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:39:00 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param listener
	 *            void
	 */
	public void bytesAsynGet(int what, String url,
			OnResponseListener<byte[]> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:38:56 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 *            void
	 */
	public void bytesAsynGet(int what, String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:38:52 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void bytesAsynPost(int what, String url, Map<String, Object> params,
			OnResponseListener<byte[]> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:38:41 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @param listener
	 *            void
	 */
	public void bytesAsynPost(String url, Map<String, Object> params,
			OnResponseListener<byte[]> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:38:37 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param listener
	 *            void
	 */
	public void bytesAsynPost(String url, OnResponseListener<byte[]> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:38:31 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 *            void
	 */
	public void bytesAsynPost(String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:38:27 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 *            void
	 */
	public void bytesAsynPost(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:38:23 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param listener
	 *            void
	 */
	public void bytesAsynPost(int what, String url,
			OnResponseListener<byte[]> listener);

	/**
	 * 
	 * 2018 2018-1-22 上午10:38:18 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 *            void
	 */
	public void bytesAsynPost(int what, String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:38:13 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param listener
	 * @param requestMethod
	 * @param clazz
	 *            void
	 */
	public <T> void objectAsyn(int what, String url,
			Map<String, Object> params, OnResponseListener<T> listener,
			RequestMethod requestMethod, Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:37:59 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param listener
	 * @param clazz
	 *            void
	 */
	public <T> void objectAsynGet(int what, String url,
			Map<String, Object> params, OnResponseListener<T> listener,
			Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:37:54 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param listener
	 * @param clazz
	 *            void
	 */
	public <T> void objectAsynGet(String url, OnResponseListener<T> listener,
			Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:37:49 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @param clazz
	 *            void
	 */
	public <T> void objectAsynGet(String url, Map<String, Object> params,
			Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:37:46 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param clazz
	 *            void
	 */
	public <T> void objectAsynGet(String url, Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:37:41 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @param listener
	 * @param requestMethod
	 * @param clazz
	 *            void
	 */
	public <T> void objectAsynGet(String url, Map<String, Object> params,
			OnResponseListener<T> listener, RequestMethod requestMethod,
			Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:37:35 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param listener
	 * @param clazz
	 *            void
	 */
	public <T> void objectAsynGet(int what, String url,
			OnResponseListener<T> listener, Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:37:25 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param clazz
	 *            void
	 */
	public <T> void objectAsynGet(int what, String url,
			Map<String, Object> params, Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:37:21 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param listener
	 * @param clazz
	 *            void
	 */
	public <T> void objectAsynPost(int what, String url,
			Map<String, Object> params, OnResponseListener<T> listener,
			Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:37:16 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @param listener
	 * @param clazz
	 *            void
	 */
	public <T> void objectAsynPost(String url, Map<String, Object> params,
			OnResponseListener<T> listener, Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:37:12 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param listener
	 * @param clazz
	 *            void
	 */
	public <T> void objectAsynPost(String url, OnResponseListener<T> listener,
			Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:37:08 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @param clazz
	 *            void
	 */
	public <T> void objectAsynPost(String url, Map<String, Object> params,
			Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:37:04 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param clazz
	 *            void
	 */
	public <T> void objectAsynPost(String url, Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:36:59 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param clazz
	 *            void
	 */
	public <T> void objectAsynPost(int what, String url,
			Map<String, Object> params, Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:36:40 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param listener
	 * @param clazz
	 *            void
	 */
	public <T> void objectAsynPost(int what, String url,
			OnResponseListener<T> listener, Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:36:34 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param requestMethod
	 * @return Response<String>
	 */
	public Response<String> string(int what, String url,
			Map<String, Object> params, RequestMethod requestMethod);

	/**
	 * 
	 * 2018 2018-1-22 上午10:36:27 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @return Response<String>
	 */
	public Response<String> stringGet(int what, String url,
			Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:36:23 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @return Response<String>
	 */
	public Response<String> stringGet(String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:36:18 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @return Response<String>
	 */
	public Response<String> stringGet(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:36:14 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @return Response<String>
	 */
	public Response<String> stringGet(int what, String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:36:04 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @return Response<String>
	 */
	public Response<String> stringPost(int what, String url,
			Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:35:55 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @return Response<String>
	 */
	public Response<String> stringPost(String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:35:50 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @return Response<String>
	 */
	public Response<String> stringPost(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:35:45 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @return Response<String>
	 */
	public Response<String> stringPost(int what, String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:35:40 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param requestMethod
	 * @return Response<JSONObject>
	 */
	public Response<JSONObject> jsonObject(int what, String url,
			Map<String, Object> params, RequestMethod requestMethod);

	/**
	 * 
	 * 2018 2018-1-22 上午10:35:33 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @return Response<JSONObject>
	 */
	public Response<JSONObject> jsonObjectGet(int what, String url,
			Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:35:28 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @return Response<JSONObject>
	 */
	public Response<JSONObject> jsonObjectGet(String url,
			Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:35:15 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @return Response<JSONObject>
	 */
	public Response<JSONObject> jsonObjectGet(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:35:09 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @return Response<JSONObject>
	 */
	public Response<JSONObject> jsonObjectGet(int what, String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:35:04 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @return Response<JSONObject>
	 */
	public Response<JSONObject> jsonObjectPost(int what, String url,
			Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:34:58 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @return Response<JSONObject>
	 */
	public Response<JSONObject> jsonObjectPost(String url,
			Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:34:53 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @return Response<JSONObject>
	 */
	public Response<JSONObject> jsonObjectPost(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:34:48 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @return Response<JSONObject>
	 */
	public Response<JSONObject> jsonObjectPost(int what, String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:34:41 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param requestMethod
	 * @return Response<JSONArray>
	 */
	public Response<JSONArray> jsonArray(int what, String url,
			Map<String, Object> params, RequestMethod requestMethod);

	/**
	 * 
	 * 2018 2018-1-22 上午10:34:32 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @return Response<JSONArray>
	 */
	public Response<JSONArray> jsonArrayGet(int what, String url,
			Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:34:20 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @return Response<JSONArray>
	 */
	public Response<JSONArray> jsonArrayGet(String url,
			Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:34:15 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @return Response<JSONArray>
	 */
	public Response<JSONArray> jsonArrayGet(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:34:10 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @return Response<JSONArray>
	 */
	public Response<JSONArray> jsonArrayGet(int what, String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:34:05 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @return Response<JSONArray>
	 */
	public Response<JSONArray> jsonArrayPost(int what, String url,
			Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:34:00 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @return Response<JSONArray>
	 */
	public Response<JSONArray> jsonArrayPost(String url,
			Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:33:56 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @return Response<JSONArray>
	 */
	public Response<JSONArray> jsonArrayPost(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:33:51 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @return Response<JSONArray>
	 */
	public Response<JSONArray> jsonArrayPost(int what, String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:33:42 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param requestMethod
	 * @return Response<Bitmap>
	 */
	public Response<Bitmap> bitmap(int what, String url,
			Map<String, Object> params, RequestMethod requestMethod);

	/**
	 * 
	 * 2018 2018-1-22 上午10:33:36 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @return Response<Bitmap>
	 */
	public Response<Bitmap> bitmapGet(int what, String url,
			Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:33:31 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @return Response<Bitmap>
	 */
	public Response<Bitmap> bitmapGet(String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:33:25 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @return Response<Bitmap>
	 */
	public Response<Bitmap> bitmapGet(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:33:18 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @return Response<Bitmap>
	 */
	public Response<Bitmap> bitmapGet(int what, String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:33:12 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @return Response<Bitmap>
	 */
	public Response<Bitmap> bitmapPost(int what, String url,
			Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:33:07 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @return Response<Bitmap>
	 */
	public Response<Bitmap> bitmapPost(String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:32:12 注释： author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param url
	 * @return Response<Bitmap>
	 */
	public Response<Bitmap> bitmapPost(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:32:07 注释： author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @return Response<Bitmap>
	 */
	public Response<Bitmap> bitmapPost(int what, String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:32:02 注释： author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param requestMethod
	 * @return Response<byte[]>
	 */
	public Response<byte[]> bytes(int what, String url,
			Map<String, Object> params, RequestMethod requestMethod);

	/**
	 * 
	 * 2018 2018-1-22 上午10:31:56 注释： author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @return Response<byte[]>
	 */
	public Response<byte[]> bytesGet(int what, String url,
			Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:31:51 注释： author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @return Response<byte[]>
	 */
	public Response<byte[]> bytesGet(String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:31:41 注释： author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param url
	 * @return Response<byte[]>
	 */
	public Response<byte[]> bytesGet(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:31:34 注释： author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @return Response<byte[]>
	 */
	public Response<byte[]> bytesGet(int what, String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:31:29 注释： author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @return Response<byte[]>
	 */
	public Response<byte[]> bytesPost(int what, String url,
			Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:31:23 注释： author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @return Response<byte[]>
	 */
	public Response<byte[]> bytesPost(String url, Map<String, Object> params);

	/**
	 * 
	 * 2018 2018-1-22 上午10:31:18 注释： author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param url
	 * @return Response<byte[]>
	 */
	public Response<byte[]> bytesPost(String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:31:09 注释： author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @return Response<byte[]>
	 */
	public Response<byte[]> bytesPost(int what, String url);

	/**
	 * 
	 * 2018 2018-1-22 上午10:31:03 注释： author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param requestMethod
	 * @param clazz
	 * @return Response<T>
	 */
	public <T> Response<T> object(int what, String url,
			Map<String, Object> params, RequestMethod requestMethod,
			Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:30:58 注释： author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param clazz
	 * @return Response<T>
	 */
	public <T> Response<T> objectGet(int what, String url,
			Map<String, Object> params, Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:30:51 注释： author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @param clazz
	 * @return Response<T>
	 */
	public <T> Response<T> objectGet(String url, Map<String, Object> params,
			Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:30:43 注释： author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param url
	 * @param clazz
	 * @return Response<T>
	 */
	public <T> Response<T> objectGet(String url, Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:30:38 注释： author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param clazz
	 * @return Response<T>
	 */
	public <T> Response<T> objectGet(int what, String url, Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:30:32 注释： author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param params
	 * @param clazz
	 * @return Response<T>
	 */
	public <T> Response<T> objectPost(int what, String url,
			Map<String, Object> params, Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:30:27 注释： author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param url
	 * @param params
	 * @param clazz
	 * @return Response<T>
	 */
	public <T> Response<T> objectPost(String url, Map<String, Object> params,
			Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:30:19 注释： author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param url
	 * @param clazz
	 * @return Response<T>
	 */
	public <T> Response<T> objectPost(String url, Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:29:14 注释: author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param what
	 * @param url
	 * @param clazz
	 * @return Response<T>
	 */
	public <T> Response<T> objectPost(int what, String url, Class<T> clazz);

	/**
	 * 
	 * 2018 2018-1-22 上午10:29:33 注释:取消请求 author：刘慧良 email ：825378291@qq.com
	 * 
	 * @param sign
	 *            void
	 */
	public void cancel(Object sign);

	/**
	 * 
	 * 2018 2018-1-22 上午10:30:00 注释：取消所有请求 author：刘慧良 email ：825378291@qq.com
	 * void
	 */
	public void cancelAll();
	/**
	 * 
	 * 2018 2018-1-22 上午10:47:43
	 * annotation：
	 * author：liuhuiliang
	 * email ：825378291@qq.com
	 *void
	 */
	public void destory();
}
