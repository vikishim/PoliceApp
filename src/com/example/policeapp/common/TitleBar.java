package com.example.policeapp.common;

import com.example.policeapp.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TitleBar extends RelativeLayout implements OnClickListener {

	private View mLeftView;
	private View mRightView;
	private TextView mCenterView;

	public TitleBar(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onFinishInflate() {
		mLeftView = findViewById(R.id.titlebar_leftview);
		mRightView = findViewById(R.id.titlebar_rightview);
		mCenterView = (TextView) findViewById(R.id.titlebar_centerview);
	}

	@Override
	public void onClick(View v) {
	}

	public void setTitle(CharSequence title) {
		mCenterView.setText(title);
	}

	public void setTitle(int resid) {
		mCenterView.setText(resid);
	}

	public void setLeftView(View view) {
		removeView(mLeftView);
		mLeftView = view;
		if (null != mLeftView) {
			RelativeLayout.LayoutParams layout = new RelativeLayout.LayoutParams(
					ViewGroup.LayoutParams.WRAP_CONTENT,
					ViewGroup.LayoutParams.MATCH_PARENT);
			layout.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			addView(mLeftView, layout);
		}
	}

	public void setRightView(View view) {
		removeView(mRightView);
		mRightView = view;
		if (null != mRightView) {
			RelativeLayout.LayoutParams layout = new RelativeLayout.LayoutParams(
					ViewGroup.LayoutParams.WRAP_CONTENT,
					ViewGroup.LayoutParams.MATCH_PARENT);
			layout.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			addView(mRightView, layout);
		}
	}

	public View getLeftView() {
		return mLeftView;
	}

	public View getRightView() {
		return mRightView;
	}

	public void setLeftOnClickListener(OnClickListener onClickListener) {
		if (null != mLeftView) {
			mLeftView.setOnClickListener(onClickListener);
		}
	}

	public void setRightOnClickListener(OnClickListener onClickListener) {
		if (null != mRightView) {
			mRightView.setOnClickListener(onClickListener);
		}
	}
	
}