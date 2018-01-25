package com.xh.repairapk;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.TextView;

import com.xh.animation.XhAnimation;
import com.xh.annotation.ViewAnnotation;
import com.xh.base.BaseActivity;
import com.xh.http.rest.OnResponseListener;
import com.xh.http.rest.Response;
import com.xh.svg.PathAnimView;
import com.xh.svg.PathSVG;
import com.xh.thread.XhHandler;
import com.xh.util.XhLog;

public class MainActivity extends BaseActivity {
	private final static String TAG = MainActivity.class.getName();
	// @ViewAnnotation(id = R.id.jiemian1)
	// TextView textView;
	@ViewAnnotation(id = R.id.image_view, clickMethodName = "text")
	PathAnimView image_view;
	@ViewAnnotation(id = R.id.image_view_full)
	ImageView image_view_full;
	@ViewAnnotation(id = R.id.image_view1)
	ImageView image_view1;
	@ViewAnnotation(id = R.id.image_view_full1)
	ImageView image_view_full1;
	@ViewAnnotation(id = R.id.ll)
	View ll;
	@ViewAnnotation(id = R.id.jiemian1, clickMethodName = "jiemian1")
	TextView jiemian1;
	@ViewAnnotation(id = R.id.jiemian2, clickMethodName = "jiemian2")
	View jiemian2;
	@ViewAnnotation(id = R.id.jiemian3, clickMethodName = "jiemian3")
	View jiemian3;
	@ViewAnnotation(id = R.id.anima_view1)
	View anima_view1;
	@ViewAnnotation(id = R.id.anima_view2)
	View anima_view2;
	private TextView textView;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setTheme(android.R.style.Theme_Light_NoTitleBar);
		super.onCreate(savedInstanceState);
		setContent();
		XhHandler handler = new XhHandler() {
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				textView = new TextView(MainActivity.this);
				textView.setBackgroundColor(Color.RED);
				textView.setText("ÄãºÃ");
				textView.setTextColor(Color.WHITE);
				textView.setGravity(Gravity.CENTER);
				LayoutParams params = new LayoutParams(200, 200);
				textView.setLayoutParams(params);
				// int x=(int) jiemian1.getLeft();
				// int y=(int) jiemian1.getBottom();
				// XhLog.e(TAG, "y="+y);
				// params.setMargins(x, y, x+200, y+200);
				// addView(fatherView, params);
				addViewRigthBottom(textView, jiemian1);
			}
		};
		handler.sendEmptyMessageDelayed(0, 2000);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

	}

	@Override
	protected String layoutName() {
		// TODO Auto-generated method stub
		return "activity12";
	}

	public void setContent() {
		// TODO Auto-generated method stub
		int width = 100;
		int height = 50;
		int color = Color.RED;
		float strokeWidth = 10.0f;
		float startAngle = 20;
		float sweepAngle = 90;
		float textSize = 15.0f;
		// image_view
		// .setVector("M7.52,21.48C4.25,19.94 1.91,16.76 1.55,13H0.05C0.56,19.16 5.71,24 12,24l0.66,-0.03 -3.81,-3.81 -1.33,1.32zm0.89,-6.52c-0.19,0 -0.37,-0.03 -0.52,-0.08 -0.16,-0.06 -0.29,-0.13 -0.4,-0.24 -0.11,-0.1 -0.2,-0.22 -0.26,-0.37 -0.06,-0.14 -0.09,-0.3 -0.09,-0.47h-1.3c0,0.36 0.07,0.68 0.21,0.95 0.14,0.27 0.33,0.5 0.56,0.69 0.24,0.18 0.51,0.32 0.82,0.41 0.3,0.1 0.62,0.15 0.96,0.15 0.37,0 0.72,-0.05 1.03,-0.15 0.32,-0.1 0.6,-0.25 0.83,-0.44s0.42,-0.43 0.55,-0.72c0.13,-0.29 0.2,-0.61 0.2,-0.97 0,-0.19 -0.02,-0.38 -0.07,-0.56 -0.05,-0.18 -0.12,-0.35 -0.23,-0.51 -0.1,-0.16 -0.24,-0.3 -0.4,-0.43 -0.17,-0.13 -0.37,-0.23 -0.61,-0.31 0.2,-0.09 0.37,-0.2 0.52,-0.33 0.15,-0.13 0.27,-0.27 0.37,-0.42 0.1,-0.15 0.17,-0.3 0.22,-0.46 0.05,-0.16 0.07,-0.32 0.07,-0.48 0,-0.36 -0.06,-0.68 -0.18,-0.96 -0.12,-0.28 -0.29,-0.51 -0.51,-0.69 -0.2,-0.19 -0.47,-0.33 -0.77,-0.43C9.1,8.05 8.76,8 8.39,8c-0.36,0 -0.69,0.05 -1,0.16 -0.3,0.11 -0.57,0.26 -0.79,0.45 -0.21,0.19 -0.38,0.41 -0.51,0.67 -0.12,0.26 -0.18,0.54 -0.18,0.85h1.3c0,-0.17 0.03,-0.32 0.09,-0.45s0.14,-0.25 0.25,-0.34c0.11,-0.09 0.23,-0.17 0.38,-0.22 0.15,-0.05 0.3,-0.08 0.48,-0.08 0.4,0 0.7,0.1 0.89,0.31 0.19,0.2 0.29,0.49 0.29,0.86 0,0.18 -0.03,0.34 -0.08,0.49 -0.05,0.15 -0.14,0.27 -0.25,0.37 -0.11,0.1 -0.25,0.18 -0.41,0.24 -0.16,0.06 -0.36,0.09 -0.58,0.09H7.5v1.03h0.77c0.22,0 0.42,0.02 0.6,0.07s0.33,0.13 0.45,0.23c0.12,0.11 0.22,0.24 0.29,0.4 0.07,0.16 0.1,0.35 0.1,0.57 0,0.41 -0.12,0.72 -0.35,0.93 -0.23,0.23 -0.55,0.33 -0.95,0.33zm8.55,-5.92c-0.32,-0.33 -0.7,-0.59 -1.14,-0.77 -0.43,-0.18 -0.92,-0.27 -1.46,-0.27H12v8h2.3c0.55,0 1.06,-0.09 1.51,-0.27 0.45,-0.18 0.84,-0.43 1.16,-0.76 0.32,-0.33 0.57,-0.73 0.74,-1.19 0.17,-0.47 0.26,-0.99 0.26,-1.57v-0.4c0,-0.58 -0.09,-1.1 -0.26,-1.57 -0.18,-0.47 -0.43,-0.87 -0.75,-1.2zm-0.39,3.16c0,0.42 -0.05,0.79 -0.14,1.13 -0.1,0.33 -0.24,0.62 -0.43,0.85 -0.19,0.23 -0.43,0.41 -0.71,0.53 -0.29,0.12 -0.62,0.18 -0.99,0.18h-0.91V9.12h0.97c0.72,0 1.27,0.23 1.64,0.69 0.38,0.46 0.57,1.12 0.57,1.99v0.4zM12,0l-0.66,0.03 3.81,3.81 1.33,-1.33c3.27,1.55 5.61,4.72 5.96,8.48h1.5C23.44,4.84 18.29,0 12,0z");
		try {
			// VectorEntity entity = vectorParas.paras(getResources(),
			// R.raw.ic_add_to_queue);
			// Path path = entity.createPath(image_view);
			//
			// // image_view.set
			// // image_view.setInfinite(false);
			// image_view.setSourcePath(path);
			image_view.drawVectorPath(R.raw.ic_add_to_queue);
			image_view_full.setImageDrawable(vectorParas.drawable(
					getResources(), R.raw.ic_add_to_queue, image_view_full));
			image_view1.setImageDrawable(svgParser.drawable(getResources(),
					R.raw.gradients, image_view1));
			PathSVG pathSVG = new PathSVG(information);
			pathSVG.svg2path("M1.8,10l6.4,6.1v-4.2c0,0,0.4,0,2.1,0c4.5,0,6.4,4.2,6.4,4.2s0.4-8.2-6.4-8.2c-1.3,0-2.1,0-2.1,0v-4L1.8,10z");
			// pathSVG.setViewBoxHeigth(20);
			// pathSVG.setViewBoxWidth(20);
			pathSVG.setColor(Color.YELLOW);
			image_view_full1.setImageDrawable(pathSVG
					.createDrawable(image_view_full1));
			okHttpManager.stringAsynGet(
					"http://api.nohttp.net/jsonObject?name=yanzhenjie&pwd=123",
					new OnResponseListener<String>() {

						@Override
						public void onSucceed(int arg0, Response<String> arg1) {
							// TODO Auto-generated method stub
							XhLog.e(TAG,
									"onSucceed=" + arg0 + " msg=" + arg1.get());
						}

						@Override
						public void onStart(int arg0) {
							// TODO Auto-generated method stub
							XhLog.e(TAG, "onStart=" + arg0);
						}

						@Override
						public void onFinish(int arg0) {
							// TODO Auto-generated method stub
							XhLog.e(TAG, "onFinish=" + arg0);
						}

						@Override
						public void onFailed(int arg0, Response<String> arg1) {
							// TODO Auto-generated method stub
							XhLog.e(TAG, arg1.getException().getMessage());
						}
					});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// imageManager.loadImage(image_view_full,
		// "https://ss0.baidu.com/73F1bjeh1BF3odCf/it/u=1156432014,2449352063&fm=85&s=329015CD9C40F5571A94D8A203006011");
		// image_view_full.setImageBitmap(XhImageUtile.starFill(width, color));
		// image_view.setImageBitmap(XhImageUtile.film(BitmapFactory
		// .decodeResource(getResources(), R.drawable.text)));
		// image_view.setOnClickListener(this);
		// image_view_full1.setImageBitmap(XhImageUtile
		// .reflection_with_origin(BitmapFactory.decodeResource(
		// getResources(), R.drawable.text)));
		// image_view1.setImageBitmap(XhImageUtile.rotate_bitmap(
		// BitmapFactory.decodeResource(getResources(), R.drawable.text),
		// 20f));
		XhLog.e(TAG, getBaseContext().getClass().getName());
	}

	@Override
	protected String packageName() {
		// TODO Auto-generated method stub
		return "com.xh.repairapk";
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		Log.e(TAG, "activity dispatchKeyEvent");
		return super.dispatchKeyEvent(event);
	}

	private void jiemian1() {
		// startActivity(new Intent(this, QppRActivity.class));
		okHttpManager.objectAsynGet(
				"http://api.nohttp.net/jsonObject?name=yanzhenjie&pwd=123",
				new OnResponseListener<Text>() {

					@Override
					public void onStart(int what) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSucceed(int what, Response<Text> response) {
						// TODO Auto-generated method stub
						XhLog.e(TAG, response.get().toString());
					}

					@Override
					public void onFailed(int what, Response<Text> response) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onFinish(int what) {
						// TODO Auto-generated method stub

					}
				}, Text.class);
		// httpManager.string("http://bbs.csdn.net/topics/390337449?page=1",
		// new XhHttpLoadListenString() {
		//
		// @Override
		// public void starting() {
		// // TODO Auto-generated method stub
		// XhLog.e("starting");
		// }
		//
		// @Override
		// public void loadDeafalt(String deafalt) {
		// // TODO Auto-generated method stub
		// XhLog.e(deafalt);
		// }
		// @Override
		// public void loaded(String string) {
		// // TODO Auto-generated method stub
		// XhLog.e(string);
		// }
		// });
	}

	private void jiemian3() {
		// startActivity(new Intent(this, NormalActivity.class));
		startActivity(new Intent(this, XhFragmentActivity.class));
	}

	@Override
	protected void noNetwork() {
		// TODO Auto-generated method stub
		// fatherView.addView(textView);
		super.noNetwork();
	}

	@Override
	protected void network() {
		// TODO Auto-generated method stub
		// fatherView.removeView(textView);
		super.network();
	}

	private int h1, h2, w1, w2;
	private int ph1, ph2, pw1, pw2;
	LayoutParams params1, params2;

	private void jiemian2() {
		Intent intent = new Intent(this, MyService.class);
		startService(intent);
		stopService(intent);
		intent = new Intent(this, MyService1.class);
		startService(intent);
		// params1 = anima_view1.getLayoutParams();
		// params2 = anima_view2.getLayoutParams();
		// h1 = params1.height;
		// w1 = params1.width;
		// ph1 = h1 >> 1;
		// pw1 = w1 >> 1;
		// // params1.height = ph1;
		// // params1.width = pw1;
		// // anima_view1.requestLayout();
		// h2 = params2.height;
		// w2 = params2.width;
		// ph2 = h2 >> 1;
		// pw2 = w2 >> 1;
		// XhLog.e(TAG, "h1=" + h1 + " w1=" + w1 + " ph1=" + ph1 + " pw1=" + pw1
		// + " h2=" + h2 + " w2=" + w2 + " ph2=" + ph2 + " pw2=" + pw2);
		// final XAnimation xAnimation = new XAnimation();
		// final XAnimation1 xAnimation1 = new XAnimation1();
		// xAnimation1.setAnimationListener(new AnimationListener() {
		//
		// @Override
		// public void onAnimationStart(Animation arg0) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void onAnimationRepeat(Animation arg0) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void onAnimationEnd(Animation arg0) {
		// // TODO Auto-generated method stub
		// xAnimation.start(anima_view1);
		// }
		// });
		// xAnimation.setAnimationListener(new AnimationListener() {
		//
		// @Override
		// public void onAnimationStart(Animation arg0) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void onAnimationRepeat(Animation arg0) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void onAnimationEnd(Animation arg0) {
		// // TODO Auto-generated method stub
		// xAnimation1.start(anima_view1);
		// }
		// });
		// xAnimation.start(anima_view1);
	}

	public class XAnimation extends XhAnimation {

		@Override
		protected void applyTransformation(float interpolatedTime,
				Transformation t) {
			// TODO Auto-generated method stub
			params1.height = (int) (ph1 + ph1 * interpolatedTime);
			params1.width = (int) (pw1 + pw1 * interpolatedTime);
			params2.height = (int) (ph2 + ph2 * (1 - interpolatedTime));
			params2.width = (int) (pw2 + pw2 * (1 - interpolatedTime));
			anima_view1.requestLayout();
			anima_view2.requestLayout();
		}
	}

	private void text() {

	}

	public class XAnimation1 extends XhAnimation {

		@Override
		protected void applyTransformation(float interpolatedTime,
				Transformation t) {
			// TODO Auto-generated method stub
			params2.height = (int) (ph2 + ph2 * interpolatedTime);
			params2.width = (int) (pw2 + pw2 * interpolatedTime);
			params1.height = (int) (ph1 + ph1 * (1 - interpolatedTime));
			params1.width = (int) (pw1 + pw1 * (1 - interpolatedTime));
			anima_view1.requestLayout();
			anima_view2.requestLayout();
		}
	}

	public class Text {
		int error;
		Data data;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "{error=" + error + " data=" + data.toString() + "}";
		}
	}

	public class Data {
		String blog;
		String name;
		List<Comment> projectList;
		String url;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuffer sb = new StringBuffer("[");
			if (projectList != null && projectList.size() > 0) {
				for (Comment comment : projectList) {
					sb.append(comment.toString());
				}
			}
			sb.append("]");
			return "{blog=" + blog + " name=" + name + " url=" + url
					+ " projectList=" + sb.toString() + "}";
		}
	}

	public class Comment {
		String comment;
		int id;
		String name;
		String url;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "{comment=" + comment + " id=" + id + " name=" + name
					+ " url=" + url + "}";
		}
	}
}
