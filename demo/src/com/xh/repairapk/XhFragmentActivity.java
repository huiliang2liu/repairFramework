package com.xh.repairapk;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.xh.annotation.ViewAnnotation;
import com.xh.base.BaseFragment;
import com.xh.base.BasePluginFragmentActivity;

/**
 * @version 创建时间：2017-12-23 下午4:38:58 项目：repairText 包名：com.xh.repairapk
 *          文件名：XhFragmentActivity.java 作者：lhl 说明:
 */

@SuppressLint("NewApi")
public class XhFragmentActivity extends BasePluginFragmentActivity {
	@Override
	protected String layoutName() {
		// TODO Auto-generated method stub
		return "fragment";
	}

	@Override
	protected int groupId() {
		// TODO Auto-generated method stub
		return R.id.frame_layout;
	}

	@Override
	protected List<? extends Fragment> fragments() {
		// TODO Auto-generated method stub
		List<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(new Myfragment());
		return fragments;
	}

	private class Myfragment extends BaseFragment {
		@ViewAnnotation(id = R.id.jiemian1, clickMethodName = "jiemian1")
		TextView jiemian1;

		@ViewAnnotation(id = R.id.jiemian2, clickMethodName = "jiemian2")
		TextView jiemian2;

		@ViewAnnotation(id = R.id.jiemian3, clickMethodName = "jiemian3")
		TextView jiemian3;

		@Override
		public String layoutName() {
			// TODO Auto-generated method stub
			return "activity12";
		}

		@Override
		public void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
		}

		private void jiemian1() {

			baseActivity.startActivity(new Intent(baseActivity,
					XhViewpacage.class));
			// Toast.makeText(getActivity(), "jiemian1", 0).show();
		}

		private void jiemian2() {
			// Toast.makeText(getActivity(), "jiemian2", 0).show();
			// Picture picture = SVGParser.getSVGFromResource(getResources(),
			// R.raw.back).getPicture();
			// Drawable drawable = new PictureDrawable(picture);
			// Bitmap bitmap = XhImageUtile.drawable2bitmap(drawable,
			// jiemian3.getWidth(), jiemian3.getHeight());
			// XhLog.e("==",
			// "Height=" + bitmap.getHeight() + " Width="
			// + bitmap.getWidth());
			// jiemian3.setBackground(XhImageUtile.bitmap2drawable(bitmap));
			// imageManager
			// .loadBackground(
			// jiemian3,
			// "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1602552054,373587514&fm=27&gp=0.jpg");
		}

		private void jiemian3() {
			// Toast.makeText(getActivity(), "jiemian3", 0).show();
			Class cls = null;
			try {
				cls = Class.forName("com.xh.repairtest.MainActivity");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (cls != null)
				baseActivity.startActivity(new Intent(baseActivity, cls));
		}
	}

	@Override
	protected int color() {
		// TODO Auto-generated method stub
		return Color.RED;
	}
}
