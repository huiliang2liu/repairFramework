package com.xh.http;

import static com.xh.string.StringUtil.isEmpty;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import android.annotation.SuppressLint;

import com.xh.encryption.IEncryption;
import com.xh.string.StringUtil;
import com.xh.thread.IRunnableManager;
import com.xh.util.StreamManage;
import com.xh.util.XhLog;

/**
 * @version 创建时间：2017-11-15 下午4:38:07 项目：TvBlackAD-eclipse
 *          包名：com.tvblack.tv.http 文件名：TVBHttp.java 作者：lhl 说明:网络请求任务
 */

public class XhHttp implements Runnable {

	private String path;
	private Map<String, Object> params;
	private int connectTime = 5 * 1000;// 超时设置
	private int readTimeOut = 5 * 1000;// 读取超时
	private String charset = "UTF-8";// 设置编码
	private int time = 4;// 默认重试4次
	protected XhHttpCallback callback;
	private IRunnableManager manager;
	private Type type = Type.GET;
	private boolean isAsyn = false;
	private SSLSocketFactory factory;
	private HostnameVerifier verifier;
	private IEncryption encryption;
	static {
		defaultHostnameVerifier();
		defaultSSLSocketFactory();
	}
	private Map<String, String> head;

	public void setHead(Map<String, String> head) {
		this.head = head;
	}

	public void setEncryption(IEncryption encryption) {
		this.encryption = encryption;
	}

	public IEncryption getEncryption() {
		return encryption;
	}

	enum Type {
		POST, GET;
	}

	public boolean isAsyn() {
		return isAsyn;
	}

	public void setAsyn(boolean isAsyn) {
		this.isAsyn = isAsyn;
	}

	public void setCallback(XhHttpCallback callback) {
		callback.setHttp(this);
		this.callback = callback;
	}

	public void setManager(IRunnableManager manager) {
		this.manager = manager;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			if (callback != null)
				callback.start();
			if (isEmpty(path)) {
				if (callback != null)
					callback.loadDeafalt("path is empty");
				return;
			}
			StringBuffer sb = null;
			if (params != null && !params.isEmpty()) {
				sb = new StringBuffer();
				Set<Entry<String, Object>> keys = params.entrySet();
				Iterator<Entry<String, Object>> iterable = keys.iterator();
				while (iterable.hasNext()) {
					Entry<String, Object> entry = iterable.next();
					String key = entry.getKey();
					if (StringUtil.isEmpty(key)) {
						Object value = entry.getValue();
						String valueString = value == null ? "null"
								: (value instanceof String ? value.toString()
										: URLEncoder.encode(value.toString(),
												charset));
						sb.append(encryption == null ? valueString : encryption
								.encryption(valueString));
					} else {
						sb.append(entry.getKey());
						sb.append("=");
						Object value = entry.getValue();
						String valueString = value == null ? "null"
								: (value instanceof String ? value.toString()
										: URLEncoder.encode(value.toString(),
												charset));
						sb.append(encryption == null ? valueString : encryption
								.encryption(valueString));
						sb.append("&");
					}
				}
				XhLog.e("params", sb.toString());
			}
			if ((type == Type.GET) && sb != null) {
				StringBuffer psb = new StringBuffer(path);
				if (path.indexOf("?") > 1)
					psb.append("&");
				else
					psb.append("?");
				psb.append(sb.toString());
				path = psb.toString();
			}
			XhLog.e("path", path);
			URL url = new URL(path);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			if (path.startsWith("https")) {
				HttpsURLConnection https = (HttpsURLConnection) connection;
				if (verifier != null)
					https.setHostnameVerifier(verifier);
				if (factory != null)
					https.setSSLSocketFactory(factory);
			}
			connection.setReadTimeout(readTimeOut);
			connection.setConnectTimeout(connectTime);
			connection.setInstanceFollowRedirects(true);// 设置支持重定向
			connection.setDoInput(true);
			if (type == Type.GET)
				connection.setDoOutput(false);
			else
				connection.setDoOutput(true);
			connection.setUseCaches(false);
			// connection.setInstanceFollowRedirects(false);
			if (type == Type.GET)
				connection.setRequestMethod("GET");
			else
				connection.setRequestMethod("POST");
			connection.setRequestProperty("Charset", charset);
			connection.setRequestProperty("Content-Type",
					"application/x-www-from-urlencoded");
			if (head != null && !head.isEmpty()) {
				Iterator<Entry<String, String>> iterator = head.entrySet()
						.iterator();
				while (iterator.hasNext()) {
					Entry<String, String> entry = iterator.next();
					connection.setRequestProperty(entry.getKey(),
							entry.getValue());
				}
			}
			connection.connect();
			if ((type == Type.POST) && sb != null) {
				DataOutputStream dos = new DataOutputStream(
						connection.getOutputStream());
				dos.write(sb.toString().getBytes());
				dos.flush();
				dos.close();
			}
			int code = connection.getResponseCode();
			InputStream is;
			if (callback != null) {
				if (code == 200) {
					is = connection.getInputStream();
					if (is == null)
						is = StreamManage.string2InputStream("访问成功，服务器无返回值",
								null);
					callback.loaded(is);
				} else {
					is = connection.getErrorStream();
					if (is != null)
						callback.loadDeafalt(StreamManage.inputStream2String(
								is, null));
					else
						callback.loadDeafalt("访问失败。访问code=" + code);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
//			if (time > 0) {
//				time--;
//				manager.submit(this, (4 - time) + 15);
//				return;
//			}
			callback.loadDeafalt("加载失败，失败信息是"
					+ (e == null ? "" : e.getMessage()));
		}
	}

	public SSLSocketFactory getFactory() {
		return factory;
	}

	public void setFactory(SSLSocketFactory factory) {
		this.factory = factory;
	}

	/**
	 * 
	 * lhl 2017-11-25 下午3:53:13 说明： 设置默认套接工厂 void
	 */
	@SuppressLint("TrulyRandom")
	private static void defaultSSLSocketFactory() {
		try {
			TrustManager myX509TrustManager = new X509TrustManager() {

				@Override
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				@Override
				public void checkServerTrusted(X509Certificate[] chain,
						String authType) throws CertificateException {
				}

				@Override
				public void checkClientTrusted(X509Certificate[] chain,
						String authType) throws CertificateException {
				}
			};
			KeyStore trustStore = KeyStore.getInstance(KeyStore
					.getDefaultType());
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("X509");
			kmf.init(trustStore, "password".toCharArray());
			// 设置SSLContext
			SSLContext sslcontext = SSLContext.getInstance("SSL",
					"AndroidOpenSSL");
			sslcontext.init(kmf.getKeyManagers(),
					new TrustManager[] { myX509TrustManager },
					new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sslcontext
					.getSocketFactory());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public HostnameVerifier getVerifier() {
		return verifier;
	}

	/**
	 * 
	 * lhl 2017-11-25 下午3:57:38 说明：设置是否忽略证书
	 * 
	 * @param verifier
	 *            void
	 */
	public void setVerifier(HostnameVerifier verifier) {
		this.verifier = verifier;
	}

	/**
	 * 
	 * lhl 2017-11-25 下午3:38:48 说明：设置默认是否忽略证书
	 * 
	 * @param hostnameVerifier
	 *            void
	 */
	private static void defaultHostnameVerifier() {
		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {

			@Override
			public boolean verify(String arg0, SSLSession arg1) {
				// TODO Auto-generated method stub
				return true;
			}
		});
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public int getConnectTime() {
		return connectTime;
	}

	public void setConnectTime(int connectTime) {
		this.connectTime = connectTime;
	}

	public int getReadTimeOut() {
		return readTimeOut;
	}

	public void setReadTimeOut(int readTimeOut) {
		this.readTimeOut = readTimeOut;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
