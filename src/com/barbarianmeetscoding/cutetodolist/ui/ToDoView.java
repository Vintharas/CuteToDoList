package com.barbarianmeetscoding.cutetodolist.ui;

import com.barbarianmeetscoding.cutetodolist.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

public class ToDoView extends CheckedTextView{

	private Paint marginPaint;
	private Paint linePaint;
	private int paperColor;
	private float margin;
	
	private void init(){
		// get ref to resources
		Resources resources = getResources();
		// Create brushes
		marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		marginPaint.setColor(resources.getColor(R.color.notepad_margin));
		linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		linePaint.setColor(resources.getColor(R.color.notepad_lines));
		// Get the paper background color and margin width
		paperColor = resources.getColor(R.color.notepad_paper);
		margin = resources.getDimension(R.dimen.notepad_margin);
	}
	
	public ToDoView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public ToDoView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
		}

	public ToDoView(Context context) {
		super(context);
		init();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// Color as paper
		canvas.drawColor(paperColor);
		// Draw ruled lines
		// canvas.drawLine(0, 0, getMeasuredHeight(), 0, linePaint);
		canvas.drawLine(0, getMeasuredHeight(),
							getMeasuredWidth(), 
							getMeasuredHeight(), linePaint);
		// Draw margin
		canvas.drawLine(margin, 0, margin, getMeasuredHeight(), marginPaint);
		// Move the text across from the margin
		canvas.save();
		canvas.translate(margin, 0);
		// Use the textview to render the text (call parent)
		super.onDraw(canvas);			
		canvas.restore();
	}

	
}
