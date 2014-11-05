package com.example.policeapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.policeapp.common.TitleBar;

public class MainActivity extends Activity {

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
		GridView gridView = (GridView) findViewById(R.id.grid_view);
		gridView.setAdapter(new MenuAdapter(this));
		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Toast.makeText(MainActivity.this, "" + position,
						Toast.LENGTH_SHORT).show();
			}
		});
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
			ViewHolder hodler;
			if(convertView == null){
				hodler = new ViewHolder();
				convertView = LayoutInflater.from(mContext).inflate(R.layout.menu_item, null);
				hodler.img = (ImageButton) convertView.findViewById(R.id.img_btn);
				hodler.label = (TextView) convertView.findViewById(R.id.label);
				convertView.setTag(hodler);
			}else{
				hodler = (ViewHolder) convertView.getTag();
			}
			hodler.img.setImageResource(mImageIds[position]);
			hodler.label.setText(mLabelIds[position]);
			return convertView;
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