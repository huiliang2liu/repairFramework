package com.xh.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;

import android.os.Process;

/**
 * @version 创建时间：2017-11-14 下午12:13:26 项目：TvBlackAD-eclipse
 *          包名：com.tvblack.tv.utils 文件名：ce.java 作者：lhl 说明: 异常处理
 */

public class XhExceptionHandler implements UncaughtExceptionHandler {
	private UncaughtExceptionHandler defaultHandle;
	private String savePath;
	private final static String ERROR = "error.xml";

	public XhExceptionHandler(String savePath) {
		// TODO Auto-generated constructor stub
		this.savePath = savePath;
		defaultHandle = Thread.getDefaultUncaughtExceptionHandler();
		Thread.setDefaultUncaughtExceptionHandler(this);

	}

	@Override
	public void uncaughtException(Thread arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		String erro = throwable2string(arg1);
		try {
			FileManagemet.save(savePath, ERROR, erro, "UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XhLog.e(erro);
		if (defaultHandle != null)
			defaultHandle.uncaughtException(arg0, arg1);
		Process.killProcess(Process.myPid());
		System.exit(0);
	}

	private String throwable2string(Throwable arg1) {
		// TODO Auto-generated method stub
		Writer writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		arg1.printStackTrace(printWriter);
		Throwable ex = arg1.getCause();
		while (ex != null) {
			ex.printStackTrace(printWriter);
			ex = ex.getCause();
		}
		printWriter.close();
		return writer.toString();
	}

	/**
	 * 
	 * lhl 2017-12-22 下午3:30:27 说明：获取错误日志
	 * 
	 * @return String
	 */
	public String error() {
		try {
			String error = StreamManage.inputStream2String(
					FileManagemet.file2InputStream(savePath + "/" + ERROR),
					"UTF-8");
			FileManagemet.delete_file(savePath + "/" + ERROR);
			return error;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
