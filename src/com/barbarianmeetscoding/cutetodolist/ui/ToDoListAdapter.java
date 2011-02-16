package com.barbarianmeetscoding.cutetodolist.ui;

import java.util.List;

import com.barbarianmeetscoding.cutetodolist.R;
import com.barbarianmeetscoding.cutetodolist.domain.ToDo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

public class ToDoListAdapter extends ArrayAdapter<ToDo>{

	int resource;
	
	public ToDoListAdapter(Context context, 
						   int _resource,
						   int textViewResourceId, 
						   List<ToDo> objects) {
		super(context, _resource, textViewResourceId, objects);
		resource = _resource;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// inflate and populate view items
		ToDoListItemView toDoListItemView;
		// Inflate a new view if this is not an update
		if (convertView == null){
			toDoListItemView = new ToDoListItemView(getContext());
			LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layoutInflater.inflate(resource, toDoListItemView, true);
		}
		else
		{
			toDoListItemView = (ToDoListItemView)convertView;
		}
		// populate
		ToDo toDo = getItem(position);
		toDoListItemView.setText(toDo.toString());
		return toDoListItemView;
	}

}
