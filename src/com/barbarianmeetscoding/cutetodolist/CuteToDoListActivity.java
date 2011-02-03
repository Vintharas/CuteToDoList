package com.barbarianmeetscoding.cutetodolist;

import java.util.ArrayList;
import java.util.List;

import com.barbarianmeetscoding.cutetodolist.R;
import com.barbarianmeetscoding.cutetodolist.domain.ToDo;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class CuteToDoListActivity extends Activity {
	
	private List<ToDo> ToDoList;
	private ListView toDoListView;
	private AddNewToDoView addNewToDoView;
	private ArrayAdapter<ToDo> arrayAdapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        loadToDoList();
        loadAddNewToDoBehavior();
    }

	private void loadToDoList() {
		loadFakeToDoList();
        arrayAdapter = new ArrayAdapter<ToDo>(this, 
        									R.layout.todoview,
        									ToDoList);
        toDoListView = (ListView)findViewById(R.id.todolist);
        toDoListView.setAdapter(arrayAdapter);
        toDoListView.setDivider(null);
	}

	private void loadAddNewToDoBehavior() {
        addNewToDoView = (AddNewToDoView)findViewById(R.id.addnewtodoview);
        addNewToDoView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				addNewToDo(addNewToDoView.getContent());
			}
		});
	}

	private void loadFakeToDoList() {
		ToDoList = new ArrayList<ToDo>();
		ToDoList.add(new ToDo().setContent("Remember to Love Myself"));
		ToDoList.add(new ToDo().setContent("Paint my nails"));
		ToDoList.add(new ToDo().setContent("Blog about painting my nails"));
		ToDoList.add(new ToDo().setContent("I love myself"));
	}

	private void addNewToDo(String content) {
		ToDoList.add(0, new ToDo().setContent(content));
	}
}