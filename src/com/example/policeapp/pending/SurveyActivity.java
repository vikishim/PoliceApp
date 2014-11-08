package com.example.policeapp.pending;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.policeapp.R;
import com.example.policeapp.common.TitleBar;
import com.example.policeapp.view.MenuGridView;

public class SurveyActivity extends Activity {
	
	private EditText mSurveyView;
	private String[] mImgPaths = new String[8];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_survey);
		configTitleBar();
		configBody();
	}

	private void configTitleBar() {
		TitleBar titleBar = (TitleBar) findViewById(R.id.titlebar);
		titleBar.setLeftTxt(R.string.titlebar_left_btn_txt);
		titleBar.setLeftTxt(R.string.titlebar_right_btn_txt);
		titleBar.setTitle(R.string.mani_menu_title_txt);
		titleBar.setLeftOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SurveyActivity.this.finish();
			}
		});
	}
	
	private void configBody() {
		mSurveyView = (EditText) findViewById(R.id.survey_edit);
		MenuGridView gridView = (MenuGridView) findViewById(R.id.grid_view);
		gridView.setAdapter(new ImageAdapter(this));
	}
	
	class ImageAdapter extends BaseAdapter {

		private Context mContext;
		
		ImageAdapter(Context context) {
			this.mContext = context;
		}
		
		@Override
		public int getCount() {
			return mImgPaths.length;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if(convertView == null) {
				holder = new ViewHolder();
				convertView = LayoutInflater.from(mContext).inflate(R.layout.survey_img_item, null);
				holder.img = (ImageView) convertView.findViewById(R.id.img_btn);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.img.setBackgroundResource(R.drawable.rate_cross_480);
			return convertView;
		}
		
	}
	
	static class ViewHolder {
		ImageView img;
	}

}