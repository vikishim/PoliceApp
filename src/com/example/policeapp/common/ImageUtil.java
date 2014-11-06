package com.example.policeapp.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

public class ImageUtil {

	private static ImageUtil mInstance;

	private Context mContext;

	private ImageUtil() {

	}

	public static ImageUtil getInstance() {
		if (null == mInstance) {
			mInstance = new ImageUtil();
		}
		return mInstance;
	}

	public void setContext(Context context) {
		this.mContext = context;
	}

	public Bitmap drawableToBitmap(Drawable drawable) {
		int width = drawable.getIntrinsicWidth();
		int height = drawable.getIntrinsicHeight();
		Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
				: Bitmap.Config.RGB_565;
		Bitmap bitmap = Bitmap.createBitmap(width, height, config);
		Canvas canvas = new Canvas(bitmap);
		drawable.setBounds(0, 0, width, height);
		drawable.draw(canvas);
		return bitmap;
	}
	
	private Bitmap drawCircle(int color) {
		Bitmap circle = Bitmap.createBitmap(30, 30, Config.ARGB_8888);
		Canvas canvas = new Canvas(circle);
		Paint basePaint = new Paint();
		basePaint.setStyle(Style.STROKE);
		basePaint.setStrokeWidth(2);
		basePaint.setColor(Color.WHITE);
		canvas.drawCircle(15, 15, 15, basePaint);
		Paint floatPaint = new Paint();
		floatPaint.setStyle(Style.FILL);
		floatPaint.setColor(color);
		canvas.drawCircle(15, 15, 15, floatPaint);
		return circle;
	}

	public Bitmap drawCountIcon(Bitmap icon, int count) {
		int iconSize = (int) mContext.getResources().getDimension(
				android.R.dimen.app_icon_size);
		Bitmap contactIcon = Bitmap.createBitmap(iconSize, iconSize,
				Config.ARGB_8888);
		Canvas canvas = new Canvas(contactIcon);
		Paint iconPaint = new Paint();
//		iconPaint.setDither(true);
//		iconPaint.setFilterBitmap(true);
		Rect src = new Rect(0, 0, icon.getWidth(), icon.getHeight());
		Rect dst = new Rect(0, 0, iconSize, iconSize);
		canvas.drawBitmap(icon, src, dst, iconPaint);
		canvas.drawBitmap(drawCircle(Color.RED), iconSize - 35, 15, iconPaint);
		Paint countPaint = new Paint(Paint.ANTI_ALIAS_FLAG
				| Paint.DEV_KERN_TEXT_FLAG);
		countPaint.setColor(Color.WHITE);
		countPaint.setTextSize(20f);
		countPaint.setTypeface(Typeface.DEFAULT_BOLD);
		canvas.drawText(String.valueOf(count), iconSize - 18, 25, countPaint);
		return contactIcon;
	}

	public Bitmap drawCountIcon(Bitmap icon, int count, int colorRes) {
		int iconSize = (int) mContext.getResources().getDimension(
				android.R.dimen.app_icon_size);
		Bitmap contactIcon = Bitmap.createBitmap(iconSize, iconSize,
				Config.ARGB_8888);
		Canvas canvas = new Canvas(contactIcon);
		Paint iconPaint = new Paint();
		iconPaint.setDither(true);
		iconPaint.setFilterBitmap(true);
		Rect src = new Rect(0, 0, icon.getWidth(), icon.getHeight());
		Rect dst = new Rect(0, 0, iconSize, iconSize);
		canvas.drawBitmap(icon, src, dst, iconPaint);
		Paint countPaint = new Paint(Paint.ANTI_ALIAS_FLAG
				| Paint.DEV_KERN_TEXT_FLAG);
		countPaint.setColor(colorRes);
		countPaint.setTextSize(20f);
		countPaint.setTypeface(Typeface.DEFAULT_BOLD);
		canvas.drawText(String.valueOf(count), iconSize - 18, 25, countPaint);
		return contactIcon;
	}

}
