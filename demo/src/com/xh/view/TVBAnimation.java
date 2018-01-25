package com.xh.view;

import android.view.View;
import android.view.animation.Animation;

/**
 * @version 创建时间�?017-11-16 下午5:59:00
 * 项目：TvBlackAD-eclipse
 * 包名：com.tvblack.tv.animation
 * 文件名：TVBAnimation.java
 * 作�?：lhl
 * 说明:动画
 */

public class TVBAnimation extends Animation {
private boolean isFillAfter=true;
private int time=700;
/**
 * 
 * lhl
 * 2017-11-16 下午6:01:57
 * 说明：开始动�?
 * @param view void
 */
public void start(View view){
	if(view==null)
		return;
	this.setFillAfter(isFillAfter);
	this.setDuration(time);
	view.startAnimation(this);
}
public boolean isFillAfter() {
	return isFillAfter;
}
public void setFillAfter(boolean isFillAfter) {
	this.isFillAfter = isFillAfter;
}
public int getTime() {
	return time;
}
public void setTime(int time) {
	if(time<=0)
		time=700;
	this.time = time;
}

}
