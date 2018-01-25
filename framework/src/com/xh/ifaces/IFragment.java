package com.xh.ifaces;



/**
 * @version 创建时间：2017-12-23 上午11:57:33 项目：repair 包名：com.xh.ifaces
 *          文件名：IFragmentManeger.java 作者：lhl 说明:
 */

public interface IFragment {
	void setTable(int table);

	void onResume();

	void onPause();
}
