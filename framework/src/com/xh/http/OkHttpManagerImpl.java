package com.xh.http;

import java.net.HttpCookie;
import java.net.URI;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Application;
import android.graphics.Bitmap;

import com.xh.http.cache.DBCacheStore;
import com.xh.http.cookie.DBCookieStore;
import com.xh.http.cookie.DBCookieStore.CookieStoreListener;
import com.xh.http.rest.JavaBeanRequest;
import com.xh.http.rest.OnResponseListener;
import com.xh.http.rest.Request;
import com.xh.http.rest.RequestQueue;
import com.xh.http.rest.Response;
import com.xh.ifaces.IOkHttpManager;

public final class OkHttpManagerImpl implements IOkHttpManager {
	private final static String TAG = "OkHttpManagerImpl";
	private static OkHttpManagerImpl okHttpManagerImpl;
	private InitializationConfig config;
	private RequestQueue queue;

	public static OkHttpManagerImpl init(Application application) {
		if (okHttpManagerImpl == null) {
			synchronized (TAG) {
				if (okHttpManagerImpl == null)
					okHttpManagerImpl = new OkHttpManagerImpl(application);
			}
		}
		return okHttpManagerImpl;
	}

	public void destory() {
		queue.stop();
	}

	private OkHttpManagerImpl(Application context) {
		// TODO Auto-generated constructor stub
		config = InitializationConfig.newBuilder(context)
		// ȫ�����ӷ�������ʱʱ�䣬��λ���룬Ĭ��10s��
				.connectionTimeout(30 * 1000)
				// ȫ�ֵȴ���������Ӧ��ʱʱ�䣬��λ���룬Ĭ��10s��
				.readTimeout(30 * 1000)
				// ���û��棬Ĭ�ϱ������ݿ�DBCacheStore�����浽SD��ʹ��DiskCacheStore��
				.cacheStore(
				// new DiskCacheStore(context)//�ļ��л���
				// new DiskCacheStore(this,"�����ַ");
				// �����ʹ�û��棬setEnable(false)���á�
						new DBCacheStore(context).setEnable(false))
				// ����Cookie��Ĭ�ϱ������ݿ�DBCookieStore�������߿����Լ�ʵ��CookieStore�ӿڡ�
				.cookieStore(
				// �����ά��cookie��setEnable(false)���á�
						new DBCookieStore(context)
								.setCookieStoreListener(new CookieStoreListener() {

									@Override
									public void onSaveCookie(URI uri,
											HttpCookie cookie) {
										// TODO Auto-generated method stub
										// 1. �ж�����������Cookie�����Ƿ������·���Session��
										// 2. �����JSessionId��Session��name��
										// ����java����JSessionId��PHP����PSessionId��
										// ��Ȼ����ֻ�Ǿ�����ʵ��java�к�php��һ�������������Ҫ��ѯ���Ƿ�����������Ա��
										if ("JSessionId".equals(cookie
												.getName())) {
											// ������Ч��Ϊ���
											cookie.setMaxAge(Long.MAX_VALUE);
										}
									}

									@Override
									public void onRemoveCookie(URI uri,
											HttpCookie cookie) {// Cookie���Ƴ�ʱ�����á�
										// TODO Auto-generated method stub

									}
								})
				// .setEnable(true)
				)
				// ��������㣬Ĭ��URLConnectionNetworkExecutor���������OkHttp��OkHttpNetworkExecutor��
				.networkExecutor(new OkHttpNetworkExecutor())
				// ȫ��ͨ��Header��add����ӣ���ε���add���Ḳ���ϴ�add��
				// .addHeader()
				// ȫ��ͨ��Param��add����ӣ���ε���add���Ḳ���ϴ�add��
				// .addParam()
				// .sslSocketFactory() // ȫ��SSLSocketFactory��
				// .hostnameVerifier() // ȫ��HostnameVerifier��
				.retry(7) // ȫ�����Դ��������ú�ÿ������ʧ�ܶ�������x�Ρ�
				.build();
		XhOkHttp.initialize(config);
		queue = XhOkHttp.newRequestQueue(5);
		queue.start();
	}

	public void stringAsyn(int what, String url, Map<String, Object> params,
			OnResponseListener<String> listener, RequestMethod requestMethod) {
		Request<String> request = XhOkHttp.createStringRequest(url,
				requestMethod);
		if (params != null && params.size() > 0)
			request.add(params);
		queue.add(what, request, listener);
	}

	public void stringAsynGet(int what, String url, Map<String, Object> params,
			OnResponseListener<String> listener) {
		stringAsyn(what, url, params, listener, RequestMethod.GET);
	}

	public void stringAsynGet(String url, Map<String, Object> params,
			OnResponseListener<String> listener) {
		stringAsyn(-1, url, params, listener, RequestMethod.GET);
	}

	public void stringAsynGet(String url, OnResponseListener<String> listener) {
		stringAsyn(-1, url, null, listener, RequestMethod.GET);
	}

	public void stringAsynGet(String url, Map<String, Object> params) {
		stringAsyn(-1, url, params, null, RequestMethod.GET);
	}

	public void stringAsynGet(String url) {
		stringAsyn(-1, url, null, null, RequestMethod.GET);
	}

	public void stringAsynGet(int what, String url, Map<String, Object> params) {
		stringAsyn(what, url, params, null, RequestMethod.GET);
	}

	public void stringAsynGet(int what, String url,
			OnResponseListener<String> listener) {
		stringAsynGet(what, url, null, listener);
	}

	public void stringAsynPost(int what, String url,
			Map<String, Object> params, OnResponseListener<String> listener) {
		stringAsyn(what, url, params, listener, RequestMethod.POST);
	}

	public void stringAsynPost(String url, Map<String, Object> params,
			OnResponseListener<String> listener) {
		stringAsyn(-1, url, params, listener, RequestMethod.POST);
	}

	public void stringAsynPost(String url, OnResponseListener<String> listener) {
		stringAsyn(-1, url, null, listener, RequestMethod.POST);
	}

	public void stringAsynPost(String url, Map<String, Object> params) {
		stringAsyn(-1, url, params, null, RequestMethod.POST);
	}

	public void stringAsynPost(String url) {
		stringAsyn(-1, url, null, null, RequestMethod.POST);
	}

	public void stringAsynPost(int what, String url,
			OnResponseListener<String> listener) {
		stringAsyn(what, url, null, listener, RequestMethod.POST);
	}

	public void stringAsynPost(int what, String url, Map<String, Object> params) {
		stringAsyn(what, url, params, null, RequestMethod.POST);
	}

	public void jsonObjectAsyn(int what, String url,
			Map<String, Object> params,
			OnResponseListener<JSONObject> listener, RequestMethod requestMethod) {
		Request<JSONObject> request = XhOkHttp.createJsonObjectRequest(url,
				requestMethod);
		if (params != null && params.size() > 0)
			request.add(params);
		queue.add(what, request, listener);
	}

	public void jsonObjectAsynGet(int what, String url,
			Map<String, Object> params, OnResponseListener<JSONObject> listener) {
		jsonObjectAsyn(what, url, params, listener, RequestMethod.GET);
	}

	public void jsonObjectAsynGet(String url, Map<String, Object> params,
			OnResponseListener<JSONObject> listener) {
		jsonObjectAsyn(-1, url, params, listener, RequestMethod.GET);
	}

	public void jsonObjectAsynGet(String url,
			OnResponseListener<JSONObject> listener) {
		jsonObjectAsyn(-1, url, null, listener, RequestMethod.GET);
	}

	public void jsonObjectAsynGet(String url, Map<String, Object> params) {
		jsonObjectAsyn(-1, url, params, null, RequestMethod.GET);
	}

	public void jsonObjectAsynGet(String url) {
		jsonObjectAsyn(-1, url, null, null, RequestMethod.GET);
	}

	public void jsonObjectAsynGet(int what, String url,
			OnResponseListener<JSONObject> listener) {
		jsonObjectAsyn(what, url, null, listener, RequestMethod.GET);
	}

	public void jsonObjectAsynGet(int what, String url,
			Map<String, Object> params) {
		jsonObjectAsyn(what, url, params, null, RequestMethod.GET);
	}

	public void jsonObjectAsynPost(int what, String url,
			Map<String, Object> params, OnResponseListener<JSONObject> listener) {
		jsonObjectAsyn(what, url, params, listener, RequestMethod.POST);
	}

	public void jsonObjectAsynPost(String url, Map<String, Object> params,
			OnResponseListener<JSONObject> listener) {
		jsonObjectAsyn(-1, url, params, listener, RequestMethod.POST);
	}

	public void jsonObjectAsynPost(String url,
			OnResponseListener<JSONObject> listener) {
		jsonObjectAsyn(-1, url, null, listener, RequestMethod.POST);
	}

	public void jsonObjectAsynPost(String url, Map<String, Object> params) {
		jsonObjectAsyn(-1, url, params, null, RequestMethod.POST);
	}

	public void jsonObjectAsynPost(String url) {
		jsonObjectAsyn(-1, url, null, null, RequestMethod.POST);
	}

	public void jsonObjectAsynPost(int what, String url,
			OnResponseListener<JSONObject> listener) {
		jsonObjectAsyn(what, url, null, listener, RequestMethod.POST);
	}

	public void jsonObjectAsynPost(int what, String url,
			Map<String, Object> params) {
		jsonObjectAsyn(what, url, params, null, RequestMethod.POST);
	}

	public void jsonArrayAsyn(int what, String url, Map<String, Object> params,
			OnResponseListener<JSONArray> listener, RequestMethod requestMethod) {
		Request<JSONArray> request = XhOkHttp.createJsonArrayRequest(url,
				requestMethod);
		if (params != null && params.size() > 0)
			request.add(params);
		queue.add(what, request, listener);
	}

	public void jsonArrayAsynGet(int what, String url,
			Map<String, Object> params, OnResponseListener<JSONArray> listener) {
		jsonArrayAsyn(what, url, params, listener, RequestMethod.GET);
	}

	public void jsonArrayAsynGet(String url, Map<String, Object> params,
			OnResponseListener<JSONArray> listener) {
		jsonArrayAsyn(-1, url, params, listener, RequestMethod.GET);
	}

	public void jsonArrayAsynGet(String url,
			OnResponseListener<JSONArray> listener) {
		jsonArrayAsyn(-1, url, null, listener, RequestMethod.GET);
	}

	public void jsonArrayAsynGet(String url, Map<String, Object> params) {
		jsonArrayAsyn(-1, url, params, null, RequestMethod.GET);
	}

	public void jsonArrayAsynGet(String url) {
		jsonArrayAsyn(-1, url, null, null, RequestMethod.GET);
	}

	public void jsonArrayAsynGet(int what, String url,
			OnResponseListener<JSONArray> listener) {
		jsonArrayAsyn(what, url, null, listener, RequestMethod.GET);
	}

	public void jsonArrayAsynGet(int what, String url,
			Map<String, Object> params) {
		jsonArrayAsyn(what, url, params, null, RequestMethod.GET);
	}

	public void jsonArrayAsynPost(int what, String url,
			Map<String, Object> params, OnResponseListener<JSONArray> listener) {
		jsonArrayAsyn(what, url, params, listener, RequestMethod.POST);
	}

	public void jsonArrayAsynPost(String url, Map<String, Object> params,
			OnResponseListener<JSONArray> listener) {
		jsonArrayAsyn(-1, url, params, listener, RequestMethod.POST);
	}

	public void jsonArrayAsynPost(String url,
			OnResponseListener<JSONArray> listener) {
		jsonArrayAsyn(-1, url, null, listener, RequestMethod.POST);
	}

	public void jsonArrayAsynPost(String url, Map<String, Object> params) {
		jsonArrayAsyn(-1, url, params, null, RequestMethod.POST);
	}

	public void jsonArrayAsynPost(String url) {
		jsonArrayAsyn(-1, url, null, null, RequestMethod.POST);
	}

	public void jsonArrayAsynPost(int what, String url,
			OnResponseListener<JSONArray> listener) {
		jsonArrayAsyn(what, url, null, listener, RequestMethod.POST);
	}

	public void jsonArrayAsynPost(int what, String url,
			Map<String, Object> params) {
		jsonArrayAsyn(what, url, params, null, RequestMethod.POST);
	}

	public void bitmapAsyn(int what, String url, Map<String, Object> params,
			OnResponseListener<Bitmap> listener, RequestMethod requestMethod) {
		Request<Bitmap> request = XhOkHttp.createImageRequest(url,
				requestMethod);
		if (params != null && params.size() > 0)
			request.add(params);
		queue.add(what, request, listener);
	}

	public void bitmapAsynGet(int what, String url, Map<String, Object> params,
			OnResponseListener<Bitmap> listener) {
		bitmapAsyn(what, url, params, listener, RequestMethod.GET);
	}

	public void bitmapAsynGet(String url, Map<String, Object> params,
			OnResponseListener<Bitmap> listener) {
		bitmapAsyn(-1, url, params, listener, RequestMethod.GET);
	}

	public void bitmapAsynGet(String url, OnResponseListener<Bitmap> listener) {
		bitmapAsyn(-1, url, null, listener, RequestMethod.GET);
	}

	public void bitmapAsynGet(String url, Map<String, Object> params) {
		bitmapAsyn(-1, url, params, null, RequestMethod.GET);
	}

	public void bitmapAsynGet(String url) {
		bitmapAsyn(-1, url, null, null, RequestMethod.GET);
	}

	public void bitmapAsynGet(int what, String url,
			OnResponseListener<Bitmap> listener) {
		bitmapAsyn(what, url, null, listener, RequestMethod.GET);
	}

	public void bitmapAsynGet(int what, String url, Map<String, Object> params) {
		bitmapAsyn(what, url, params, null, RequestMethod.GET);
	}

	public void bitmapAsynPost(int what, String url,
			Map<String, Object> params, OnResponseListener<Bitmap> listener) {
		bitmapAsyn(what, url, params, listener, RequestMethod.POST);
	}

	public void bitmapAsynPost(String url, Map<String, Object> params,
			OnResponseListener<Bitmap> listener) {
		bitmapAsyn(-1, url, params, listener, RequestMethod.POST);
	}

	public void bitmapAsynPost(String url, OnResponseListener<Bitmap> listener) {
		bitmapAsyn(-1, url, null, listener, RequestMethod.POST);
	}

	public void bitmapAsynPost(String url, Map<String, Object> params) {
		bitmapAsyn(-1, url, params, null, RequestMethod.POST);
	}

	public void bitmapAsynPost(String url) {
		bitmapAsyn(-1, url, null, null, RequestMethod.POST);
	}

	public void bitmapAsynPost(int what, String url,
			OnResponseListener<Bitmap> listener) {
		bitmapAsyn(what, url, null, listener, RequestMethod.POST);
	}

	public void bitmapAsynPost(int what, String url, Map<String, Object> params) {
		bitmapAsyn(what, url, params, null, RequestMethod.POST);
	}

	public void bytesAsyn(int what, String url, Map<String, Object> params,
			OnResponseListener<byte[]> listener, RequestMethod requestMethod) {
		Request<byte[]> request = XhOkHttp.createByteArrayRequest(url,
				requestMethod);
		if (params != null && params.size() > 0)
			request.add(params);
		queue.add(what, request, listener);
	}

	public void bytesAsynGet(int what, String url, Map<String, Object> params,
			OnResponseListener<byte[]> listener) {
		bytesAsyn(what, url, params, listener, RequestMethod.GET);
	}

	public void bytesAsynGet(String url, Map<String, Object> params,
			OnResponseListener<byte[]> listener) {
		bytesAsyn(-1, url, params, listener, RequestMethod.GET);
	}

	public void bytesAsynGet(String url, OnResponseListener<byte[]> listener) {
		bytesAsyn(-1, url, null, listener, RequestMethod.GET);
	}

	public void bytesAsynGet(String url, Map<String, Object> params) {
		bytesAsyn(-1, url, params, null, RequestMethod.GET);
	}

	public void bytesAsynGet(String url) {
		bytesAsyn(-1, url, null, null, RequestMethod.GET);
	}

	public void bytesAsynGet(int what, String url,
			OnResponseListener<byte[]> listener) {
		bytesAsyn(what, url, null, listener, RequestMethod.GET);
	}

	public void bytesAsynGet(int what, String url, Map<String, Object> params) {
		bytesAsyn(what, url, params, null, RequestMethod.GET);
	}

	public void bytesAsynPost(int what, String url, Map<String, Object> params,
			OnResponseListener<byte[]> listener) {
		bytesAsyn(what, url, params, listener, RequestMethod.POST);
	}

	public void bytesAsynPost(String url, Map<String, Object> params,
			OnResponseListener<byte[]> listener) {
		bytesAsyn(-1, url, params, listener, RequestMethod.POST);
	}

	public void bytesAsynPost(String url, OnResponseListener<byte[]> listener) {
		bytesAsyn(-1, url, null, listener, RequestMethod.POST);
	}

	public void bytesAsynPost(String url, Map<String, Object> params) {
		bytesAsyn(-1, url, params, null, RequestMethod.POST);
	}

	public void bytesAsynPost(String url) {
		bytesAsyn(-1, url, null, null, RequestMethod.POST);
	}

	public void bytesAsynPost(int what, String url,
			OnResponseListener<byte[]> listener) {
		bytesAsyn(what, url, null, listener, RequestMethod.POST);
	}

	public void bytesAsynPost(int what, String url, Map<String, Object> params) {
		bytesAsyn(what, url, params, null, RequestMethod.POST);
	}

	public <T> void objectAsyn(int what, String url,
			Map<String, Object> params, OnResponseListener<T> listener,
			RequestMethod requestMethod, Class<T> clazz) {
		Request<T> request = new JavaBeanRequest<>(url, requestMethod, clazz);
		if (params != null && params.size() > 0)
			request.add(params);
		queue.add(what, request, listener);
	}

	public <T> void objectAsynGet(int what, String url,
			Map<String, Object> params, OnResponseListener<T> listener,
			Class<T> clazz) {
		objectAsyn(what, url, params, listener, RequestMethod.GET, clazz);
	}

	public <T> void objectAsynGet(String url, OnResponseListener<T> listener,
			Class<T> clazz) {
		objectAsyn(-1, url, null, listener, RequestMethod.GET, clazz);
	}

	public <T> void objectAsynGet(String url, Map<String, Object> params,
			Class<T> clazz) {
		objectAsyn(-1, url, params, null, RequestMethod.GET, clazz);
	}

	public <T> void objectAsynGet(String url, Class<T> clazz) {
		objectAsyn(-1, url, null, null, RequestMethod.GET, clazz);
	}

	public <T> void objectAsynGet(String url, Map<String, Object> params,
			OnResponseListener<T> listener, RequestMethod requestMethod,
			Class<T> clazz) {
		objectAsyn(-1, url, params, listener, RequestMethod.GET, clazz);
	}

	public <T> void objectAsynGet(int what, String url,
			OnResponseListener<T> listener, Class<T> clazz) {
		objectAsyn(what, url, null, listener, RequestMethod.GET, clazz);
	}

	public <T> void objectAsynGet(int what, String url,
			Map<String, Object> params, Class<T> clazz) {
		objectAsyn(what, url, params, null, RequestMethod.GET, clazz);
	}

	public <T> void objectAsynPost(int what, String url,
			Map<String, Object> params, OnResponseListener<T> listener,
			Class<T> clazz) {
		objectAsyn(what, url, params, listener, RequestMethod.POST, clazz);
	}

	public <T> void objectAsynPost(String url, Map<String, Object> params,
			OnResponseListener<T> listener, Class<T> clazz) {
		objectAsynPost(-1, url, params, listener, clazz);
	}

	public <T> void objectAsynPost(String url, OnResponseListener<T> listener,
			Class<T> clazz) {
		objectAsynPost(-1, url, null, listener, clazz);
	}

	public <T> void objectAsynPost(String url, Map<String, Object> params,
			Class<T> clazz) {
		objectAsynPost(-1, url, params, null, clazz);
	}

	public <T> void objectAsynPost(String url, Class<T> clazz) {
		objectAsynPost(-1, url, null, null, clazz);
	}

	public <T> void objectAsynPost(int what, String url,
			Map<String, Object> params, Class<T> clazz) {
		objectAsynPost(what, url, params, null, clazz);
	}

	public <T> void objectAsynPost(int what, String url,
			OnResponseListener<T> listener, Class<T> clazz) {
		objectAsynPost(what, url, listener, clazz);
	}

	public Response<String> string(int what, String url,
			Map<String, Object> params, RequestMethod requestMethod) {
		Request<String> request = XhOkHttp.createStringRequest(url,
				requestMethod);
		if (params != null && params.size() > 0)
			request.add(params);
		return XhOkHttp.startRequestSync(request);
	}

	public Response<String> stringGet(int what, String url,
			Map<String, Object> params) {
		return string(what, url, params, RequestMethod.GET);
	}

	public Response<String> stringGet(String url, Map<String, Object> params) {
		return string(-1, url, params, RequestMethod.GET);
	}

	public Response<String> stringGet(String url) {
		return string(-1, url, null, RequestMethod.GET);
	}

	public Response<String> stringGet(int what, String url) {
		return string(what, url, null, RequestMethod.GET);
	}

	public Response<String> stringPost(int what, String url,
			Map<String, Object> params) {
		return string(what, url, params, RequestMethod.POST);
	}

	public Response<String> stringPost(String url, Map<String, Object> params) {
		return string(-1, url, params, RequestMethod.POST);
	}

	public Response<String> stringPost(String url) {
		return string(-1, url, null, RequestMethod.POST);
	}

	public Response<String> stringPost(int what, String url) {
		return string(what, url, null, RequestMethod.POST);
	}

	public Response<JSONObject> jsonObject(int what, String url,
			Map<String, Object> params, RequestMethod requestMethod) {
		Request<JSONObject> request = XhOkHttp.createJsonObjectRequest(url,
				requestMethod);
		if (params != null && params.size() > 0)
			request.add(params);
		return XhOkHttp.startRequestSync(request);
	}

	public Response<JSONObject> jsonObjectGet(int what, String url,
			Map<String, Object> params) {
		return jsonObject(what, url, params, RequestMethod.GET);
	}

	public Response<JSONObject> jsonObjectGet(String url,
			Map<String, Object> params) {
		return jsonObject(-1, url, params, RequestMethod.GET);
	}

	public Response<JSONObject> jsonObjectGet(String url) {
		return jsonObject(-1, url, null, RequestMethod.GET);
	}

	public Response<JSONObject> jsonObjectGet(int what, String url) {
		return jsonObject(what, url, null, RequestMethod.GET);
	}

	public Response<JSONObject> jsonObjectPost(int what, String url,
			Map<String, Object> params) {
		return jsonObject(what, url, params, RequestMethod.POST);
	}

	public Response<JSONObject> jsonObjectPost(String url,
			Map<String, Object> params) {
		return jsonObject(-1, url, params, RequestMethod.POST);
	}

	public Response<JSONObject> jsonObjectPost(String url) {
		return jsonObject(-1, url, null, RequestMethod.POST);
	}

	public Response<JSONObject> jsonObjectPost(int what, String url) {
		return jsonObject(what, url, null, RequestMethod.POST);
	}

	public Response<JSONArray> jsonArray(int what, String url,
			Map<String, Object> params, RequestMethod requestMethod) {
		Request<JSONArray> request = XhOkHttp.createJsonArrayRequest(url,
				requestMethod);
		if (params != null && params.size() > 0)
			request.add(params);
		return XhOkHttp.startRequestSync(request);
	}

	public Response<JSONArray> jsonArrayGet(int what, String url,
			Map<String, Object> params) {
		return jsonArray(what, url, params, RequestMethod.GET);
	}

	public Response<JSONArray> jsonArrayGet(String url,
			Map<String, Object> params) {
		return jsonArray(-1, url, params, RequestMethod.GET);
	}

	public Response<JSONArray> jsonArrayGet(String url) {
		return jsonArray(-1, url, null, RequestMethod.GET);
	}

	public Response<JSONArray> jsonArrayGet(int what, String url) {
		return jsonArray(what, url, null, RequestMethod.GET);
	}

	public Response<JSONArray> jsonArrayPost(int what, String url,
			Map<String, Object> params) {
		return jsonArray(what, url, params, RequestMethod.POST);
	}

	public Response<JSONArray> jsonArrayPost(String url,
			Map<String, Object> params) {
		return jsonArray(-1, url, params, RequestMethod.POST);
	}

	public Response<JSONArray> jsonArrayPost(String url) {
		return jsonArray(-1, url, null, RequestMethod.POST);
	}

	public Response<JSONArray> jsonArrayPost(int what, String url) {
		return jsonArray(what, url, null, RequestMethod.POST);
	}

	public Response<Bitmap> bitmap(int what, String url,
			Map<String, Object> params, RequestMethod requestMethod) {
		Request<Bitmap> request = XhOkHttp.createImageRequest(url,
				requestMethod);
		if (params != null && params.size() > 0)
			request.add(params);
		return XhOkHttp.startRequestSync(request);
	}

	public Response<Bitmap> bitmapGet(int what, String url,
			Map<String, Object> params) {

		return bitmap(what, url, params, RequestMethod.GET);
	}

	public Response<Bitmap> bitmapGet(String url, Map<String, Object> params) {

		return bitmap(-1, url, params, RequestMethod.GET);
	}

	public Response<Bitmap> bitmapGet(String url) {

		return bitmap(-1, url, null, RequestMethod.GET);
	}

	public Response<Bitmap> bitmapGet(int what, String url) {

		return bitmap(what, url, null, RequestMethod.GET);
	}

	public Response<Bitmap> bitmapPost(int what, String url,
			Map<String, Object> params) {

		return bitmap(what, url, params, RequestMethod.POST);

	}

	public Response<Bitmap> bitmapPost(String url, Map<String, Object> params) {

		return bitmap(-1, url, params, RequestMethod.POST);

	}

	public Response<Bitmap> bitmapPost(String url) {

		return bitmap(-1, url, null, RequestMethod.POST);

	}

	public Response<Bitmap> bitmapPost(int what, String url) {

		return bitmap(what, url, null, RequestMethod.POST);

	}

	public Response<byte[]> bytes(int what, String url,
			Map<String, Object> params, RequestMethod requestMethod) {
		Request<byte[]> request = XhOkHttp.createByteArrayRequest(url,
				requestMethod);
		request.add(params);
		return XhOkHttp.startRequestSync(request);
	}

	public Response<byte[]> bytesGet(int what, String url,
			Map<String, Object> params) {

		return bytes(what, url, params, RequestMethod.GET);
	}

	public Response<byte[]> bytesGet(String url, Map<String, Object> params) {

		return bytes(-1, url, params, RequestMethod.GET);
	}

	public Response<byte[]> bytesGet(String url) {

		return bytes(-1, url, null, RequestMethod.GET);
	}

	public Response<byte[]> bytesGet(int what, String url) {

		return bytes(what, url, null, RequestMethod.GET);
	}

	public Response<byte[]> bytesPost(int what, String url,
			Map<String, Object> params) {

		return bytes(what, url, params, RequestMethod.POST);
	}

	public Response<byte[]> bytesPost(String url, Map<String, Object> params) {

		return bytes(-1, url, params, RequestMethod.POST);
	}

	public Response<byte[]> bytesPost(String url) {

		return bytes(-1, url, null, RequestMethod.POST);
	}

	public Response<byte[]> bytesPost(int what, String url) {

		return bytes(what, url, null, RequestMethod.POST);
	}

	public <T> Response<T> object(int what, String url,
			Map<String, Object> params, RequestMethod requestMethod,
			Class<T> clazz) {
		Request<T> request = new JavaBeanRequest<>(url, requestMethod, clazz);
		request.add(params);
		return XhOkHttp.startRequestSync(request);
	}

	public <T> Response<T> objectGet(int what, String url,
			Map<String, Object> params, Class<T> clazz) {

		return object(what, url, params, RequestMethod.GET, clazz);
	}

	public <T> Response<T> objectGet(String url, Map<String, Object> params,
			Class<T> clazz) {

		return object(-1, url, params, RequestMethod.GET, clazz);
	}

	public <T> Response<T> objectGet(String url, Class<T> clazz) {

		return object(-1, url, null, RequestMethod.GET, clazz);
	}

	public <T> Response<T> objectGet(int what, String url, Class<T> clazz) {

		return object(what, url, null, RequestMethod.GET, clazz);
	}

	public <T> Response<T> objectPost(int what, String url,
			Map<String, Object> params, Class<T> clazz) {

		return object(what, url, params, RequestMethod.POST, clazz);
	}

	public <T> Response<T> objectPost(String url, Map<String, Object> params,
			Class<T> clazz) {

		return object(-1, url, params, RequestMethod.POST, clazz);
	}

	public <T> Response<T> objectPost(String url, Class<T> clazz) {

		return object(-1, url, null, RequestMethod.POST, clazz);
	}

	public <T> Response<T> objectPost(int what, String url, Class<T> clazz) {

		return object(what, url, null, RequestMethod.POST, clazz);
	}

	/**
	 * ȡ������
	 * 
	 * @param sign
	 */
	public void cancel(Object sign) {
		queue.cancelBySign(sign);
	}

	public void cancelAll() {
		queue.cancelAll();
	}
}
