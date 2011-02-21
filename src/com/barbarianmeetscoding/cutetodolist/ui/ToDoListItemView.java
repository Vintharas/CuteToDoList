package com.barbarianmeetscoding.cutetodolist.ui;


import com.barbarianmeetscoding.cutetodolist.R;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ToDoListItemView extends RelativeLayout{

	private ToDoView toDoView;
	
	public void setText(String content) {
		if (toDoView == null)
			toDoView = (ToDoView)findViewById(R.id.tv_todolistitem);
		toDoView.setText(content);
	}
	
	public ToDoListItemView(Context context) {
		super(context);
	}

	public ToDoListItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
    
}
