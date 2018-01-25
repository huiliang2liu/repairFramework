package com.xh.repairapk;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.xh.adapterView.BaseAdapter;
import com.xh.adapterView.BaseTag;
import com.xh.animation.TranslateAnimation;
import com.xh.animation.XhAnimation;
import com.xh.annotation.ViewAnnotation;
import com.xh.base.BaseActivity;

/**
 * @version 创建时间：2017-12-14 下午12:17:10 项目：repairText 包名：com.xh.repairapk
 *          文件名：NormalActivity.java 作者：lhl 说明:
 * @param <T>
 */

public class NormalActivity extends BaseActivity {
	@ViewAnnotation(id = R.id.list)
	private ListView listView;
	private Adapter<Entity> adapter;

	@Override
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView("normal");
		setContent();
	}

	public void setContent() {
		// TODO Auto-generated method stub
		try {
			adapter = new Adapter<Entity>(listView);
			for (int i = 0; i < 10; i++) {
				adapter.addItem(new Entity());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private class Adapter<Entity> extends BaseAdapter<Entity> {
		List<XhAnimation> animations;

		public Adapter(AdapterView adapterView) {
			super(adapterView);
			// TODO Auto-generated constructor stub
			animations = new ArrayList<XhAnimation>();
			TranslateAnimation animation = new TranslateAnimation();
			animation.setmFromXDelta(-1000);

			TranslateAnimation animation1 = new TranslateAnimation();
			animation1.setmFromXDelta(1000);

			TranslateAnimation animation2 = new TranslateAnimation();
			animation2.setmFromYDelta(-1000);

			TranslateAnimation animation3 = new TranslateAnimation();
			animation3.setmFromYDelta(1000);
			animations.add(animation);
			animations.add(animation1);
			animations.add(animation2);
			animations.add(animation3);
		}

		@Override
		public BaseTag<Entity> getViewHolder(int itemType) {
			// TODO Auto-generated method stub
			return new Tag<Entity>();
		}

		@Override
		public View getView(int itemType) {
			// TODO Auto-generated method stub
			return LinearLayout.inflate(NormalActivity.this,
					R.layout.list_view_item, null);
		}

		// @Override
		// public XhAnimation getAnimation(int position) {
		// // TODO Auto-generated method stub
		// return animations.get(position % 4);
		// }
	}

	@SuppressWarnings("hiding")
	private class Tag<Entity> extends BaseTag<Entity> {
		@ViewAnnotation(id = R.id.list_view_item_textView, clickMethodName = "ceshi")
		TextView list_view_item_textView;

		@Override
		public void setContext(Entity t) {
			// TODO Auto-generated method stub
			list_view_item_textView
					.setText(((com.xh.repairapk.NormalActivity.Entity) t)
							.text());
		}

		// @Override
		// protected Object receiver() {
		// // TODO Auto-generated method stub
		// return new Receiver();
		// }
		private void ceshi() {
			Toast.makeText(NormalActivity.this,
					list_view_item_textView.getText().toString(), 1).show();
		}
	}

	private class Entity {
		public String text() {
			return "" + System.currentTimeMillis();
		}
	}

	private class Receiver {
	}
}
