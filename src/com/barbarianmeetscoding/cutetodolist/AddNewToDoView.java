package com.barbarianmeetscoding.cutetodolist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class AddNewToDoView extends RelativeLayout{

	// members
	private EditText et_AddNewTask;
	private Button bt_AddNewTask;
	
	@Override
	public void setOnClickListener(OnClickListener onClickListener) {
		bt_AddNewTask.setOnClickListener(onClickListener);
	}
	
	public String getContent(){
		return et_AddNewTask.getText().toString();
	}
	
	public AddNewToDoView(Context context) {
		super(context);
		inflateView();
	}
	

	public AddNewToDoView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		inflateView();
	}

	public AddNewToDoView(Context context, AttributeSet attrs) {
		super(context, attrs);
		inflateView();
	}

	private void inflateView() {
		// Inflate view
		LayoutInflater li = (LayoutInflater)getContext()
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		li.inflate(R.layout.addnew_todoview, this, true);
		// get reference to child controls
		et_AddNewTask = (EditText)findViewById(R.id.et_addnewtask);
		bt_AddNewTask = (Button)findViewById(R.id.bt_addnewtask);
		// initialize view behavior
		initializeViewBehavior();
	}

	private void initializeViewBehavior() {
		et_AddNewTask.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String initialEditTextString = getResources().getString(R.string.add_new_todo);
				if (et_AddNewTask.getText().toString() == initialEditTextString)
					et_AddNewTask.setText("");
			}
		});
		
	}

}
