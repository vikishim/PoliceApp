package com.example.policeapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.policeapp.common.TitleBar;
import com.example.policeapp.pending.SurveyActivity;
import com.example.policeapp.view.MenuGridView;
import com.readystatesoftware.viewbadger.BadgeView;

public class MainActivity extends Activity {

	private int mPendingCount = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		configTitleBar();
		configBody();
	}

	private void configTitleBar() {
		TitleBar titleBar = (TitleBar) findViewById(R.id.titlebar);
		titleBar.setLeftView(null);
		titleBar.setRightView(null);
		titleBar.setTitle(R.string.mani_menu_title_txt);
	}

	private void configBody() {
		MenuGridView gridView = (MenuGridView) findViewById(R.id.grid_view);
		gridView.setAdapter(new MenuAdapter(this));
	}

	class MenuAdapter extends BaseAdapter {

		private Context mContext;

		public MenuAdapter(Context context) {
			this.mContext = context;
		}

		@Override
		public int getCount() {
			return mLabelIds.length;
		}

		@Override
		public Object getItem(int position) {
			return getString(mLabelIds[position]);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = LayoutInflater.from(mContext).inflate(
						R.layout.menu_item, null);
				holder.img = (ImageButton) convertView
						.findViewById(R.id.img_btn);
				holder.label = (TextView) convertView.findViewById(R.id.label);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.img.setImageResource(mImageIds[position]);
			holder.label.setText(mLabelIds[position]);
			holder.img.setOnClickListener(new ImgBtnClickListener(position));
			if (1 == position) {
				BadgeView badge = new BadgeView(mContext, holder.img);
				badge.setText("" + mPendingCount);
				badge.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
				badge.toggle();
			}
			return convertView;
		}

		class ImgBtnClickListener implements View.OnClickListener {

			private int mPosition;

			ImgBtnClickListener(int pos) {
				this.mPosition = pos;
			}

			@Override
			public void onClick(View v) {
				switch (mPosition) {
				case 1:
					startActivity(new Intent(MainActivity.this, SurveyActivity.class));
					break;
				default:
					break;
				}
			}
		}

	}

	static class ViewHolder {
		ImageButton img;
		TextView label;
	}

	private Integer[] mImageIds = { R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher };

	private Integer[] mLabelIds = { R.string.mani_menu_label_msg_txt,
			R.string.mani_menu_label_pending_txt,
			R.string.mani_menu_label_finish_txt,
			R.string.mani_menu_label_setting_txt,
			R.string.mani_menu_label_exit_txt };

}