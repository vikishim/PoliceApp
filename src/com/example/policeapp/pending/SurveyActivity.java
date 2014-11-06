package com.example.policeapp.pending;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.policeapp.R;
import com.example.policeapp.common.TitleBar;
import com.example.policeapp.view.MenuGridView;
import com.readystatesoftware.viewbadger.BadgeView;

public class SurveyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_survey);
		configTitleBar();
	}

	private void configTitleBar() {
		TitleBar titleBar = (TitleBar) findViewById(R.id.titlebar);
		titleBar.setLeftView(null);
		titleBar.setRightView(null);
		titleBar.setTitle(R.string.mani_menu_title_txt);
	}

}