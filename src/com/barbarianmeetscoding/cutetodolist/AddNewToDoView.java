package com.barbarianmeetscoding.cutetodolist;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class AddNewToDoView extends RelativeLayout{

	// members
	private EditText et_AddNewToDo;
	private Button bt_AddNewToDo;
	private Resources resources;
	
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

	
	
	public void setButtonOnClickListener(OnClickListener onClickListener) {
		bt_AddNewToDo.setOnClickListener(onClickListener);
	}
	
	public String getContent(){
		return et_AddNewToDo.getText().toString();
	}	

	@Override
	public Resources getResources() {
		// to ensure only one object is created
		if (resources == null)
			resources = super.getResources();
		return resources;
	}
	
	private void inflateView() {
		// Inflate view
		LayoutInflater li = (LayoutInflater)getContext()
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		li.inflate(R.layout.addnew_todoview, this, true);
		// get reference to child controls
		et_AddNewToDo = (EditText)findViewById(R.id.et_addnewtask);
		bt_AddNewToDo = (Button)findViewById(R.id.bt_addnewtask);
		// initialize view behavior
		initializeViewBehavior();
	}

	private void initializeViewBehavior() {
		et_AddNewToDo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (editTextHasDefaultValue())
					activateTextView();
			}
		});
		et_AddNewToDo.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus && editTextHasDefaultValue())
					activateTextView();
				if (!hasFocus && isEmpty())
					resetControl();
			}
		});
	}
	
	private boolean editTextHasDefaultValue(){
		String initialEditTextString = getResources().getString(R.string.add_new_todo);
		if (et_AddNewToDo.getText().toString().equals(initialEditTextString))
			return true;
		return false;
	}

	private boolean isEmpty() {
		if (et_AddNewToDo.getText().toString().contentEquals(""))
			return true;
		return false;
	}
	
	public void resetControl(){
		deleteEditTextContent();
		applyTextColor(R.color.addnewtodo_pasivetext);
		et_AddNewToDo.setText(R.string.add_new_todo);
	}
	
	public void deleteEditTextContent(){
		et_AddNewToDo.setText("");
	}

	private void activateTextView() {
		deleteEditTextContent();
		applyTextColor(R.color.addnewtodo_activetext);
	}
	
	private void applyTextColor(int resourceId){
		et_AddNewToDo.setTextColor(getResources().getColor(resourceId));
	}
}
