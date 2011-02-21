package com.barbarianmeetscoding.cutetodolist.ui;

import java.util.List;

import com.barbarianmeetscoding.cutetodolist.R;
import com.barbarianmeetscoding.cutetodolist.domain.ToDo;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ToDoListAdapter extends ArrayAdapter<ToDo>{

	Typeface font;
	private void setTypeFace(Typeface font){
		this.font = font;
	}
	
	public ToDoListAdapter(Context context, int textViewResourceId,
			List<ToDo> objects) {
		super(context, textViewResourceId, objects);
		initialize();
	}
	
	private void initialize() {
		setTypeFace(Typeface.createFromAsset(getContext().getAssets(), "angelina.ttf"));  
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		super.getView(position, convertView, parent);
		ToDoView toDoView;
		// inflate view
		if (convertView == null)
		{
			
			LayoutInflater layoutInflater = 
				(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			toDoView = (ToDoView)layoutInflater.inflate(R.layout.todo_view, null);
		}
		else
		{
			toDoView = (ToDoView)convertView;
		}
		// set font face style
			toDoView.setTypeface(font);
		// set text
			toDoView.setText(getItem(position).toString());
		return toDoView;
	}

}
