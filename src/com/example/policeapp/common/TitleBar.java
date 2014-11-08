package com.example.policeapp.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.policeapp.R;

public class TitleBar extends RelativeLayout implements OnClickListener {

	private Context mContext;
	private View mLeftView;
	private View mRightView;
	private TextView mCenterView;

	public TitleBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
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
	
	public void setLeftTxt(CharSequence txt) {
		Button btn = new Button(mContext);
		btn.setText(txt);
		btn.setBackgroundResource(R.drawable.titlebar_button_bg);
		btn.setGravity(Gravity.CENTER);
		btn.setPadding(20, 2, 20, 2);
		setLeftView(btn);
	}
	
	public void setLeftTxt(int resid) {
		setLeftTxt(mContext.getString(resid));
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
	
	public void setRightTxt(CharSequence txt) {
		Button btn = new Button(mContext);
		btn.setText(txt);
		btn.setBackgroundResource(R.drawable.titlebar_button_bg);
		btn.setGravity(Gravity.CENTER);
		btn.setPadding(20, 2, 20, 2);
		setRightView(btn);
	}
	
	public void setRightTxt(int resid) {
		setRightTxt(mContext.getString(resid));
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