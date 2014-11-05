package com.example.policeapp.common;

import com.example.policeapp.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;

public class DefaultTitleBar extends TitleBar {

	// private Button mBtnBack;
	private ImageButton mBtnBack;
	// private Button mBtnNextStep;
	private ImageButton mBtnNextStep;

	public DefaultTitleBar(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setActivity(final Activity thisActivity,
			final Class<?> nextActivityClass) {
		setLeftOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				thisActivity.finish();
			}
		});
		setRightOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(thisActivity, nextActivityClass);
				thisActivity.startActivity(i);
			}
		});
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		configureBar();
	}

	private void configureBar() {
		// Context context = getContext();
		mBtnBack = (ImageButton) findViewById(R.id.titlebar_leftview);
		mBtnNextStep = (ImageButton) findViewById(R.id.titlebar_rightview);
		setLeftView(mBtnBack);
		setRightView(mBtnNextStep);
	}

}