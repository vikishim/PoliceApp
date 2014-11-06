package com.example.policeapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class ScrollviewEdit extends ScrollView {
	
	private static final String TAG = "ScrollviewEdit";
	private ScrollView mParentScrollView;

	public ScrollView getParentScrollView() {
		return mParentScrollView;
	}

	public void setParentScrollView(ScrollView parentScrollView) {
		this.mParentScrollView = parentScrollView;
	}

	public ScrollviewEdit(Context context) {
		super(context);
	}

	public ScrollviewEdit(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	int currentY;

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		Log.i(TAG, "onInterceptTouchEvent--------");
		if (mParentScrollView == null) {
			return super.onInterceptTouchEvent(ev);
		} else {
			if (ev.getAction() == MotionEvent.ACTION_DOWN) {
				// Intercept parent ScrollView rolling event
				currentY = (int) ev.getY();
				setParentScrollAble(false);
				Log.i(TAG, "Intercept parent ScrollView rolling event-----");
				return super.onInterceptTouchEvent(ev);
			} else if (ev.getAction() == MotionEvent.ACTION_UP) {
				// Parent ScrollView regain rolling event
				setParentScrollAble(true);
				Log.i(TAG, "Parent ScrollView regain rolling event-----");
			} else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
			}
		}
		return super.onInterceptTouchEvent(ev);
	}

	/**
	 * Whether pass event to parent view
	 * 
	 * @param flag
	 */
	private void setParentScrollAble(boolean flag) {
		mParentScrollView.requestDisallowInterceptTouchEvent(!flag);
	}
}
