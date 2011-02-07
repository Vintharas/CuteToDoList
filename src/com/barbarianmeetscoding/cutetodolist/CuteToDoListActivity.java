package com.barbarianmeetscoding.cutetodolist;

import com.barbarianmeetscoding.cutetodolist.domain.ToDo;
import com.barbarianmeetscoding.cutetodolist.domain.ToDoList;
import com.barbarianmeetscoding.cutetodolist.storage.MockUpToDoList;
import com.barbarianmeetscoding.cutetodolist.utils.ToastLauncher;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;

public class CuteToDoListActivity extends ListActivity {
	
	
	private ToDoList toDoList;
	private AddNewToDoView addNewToDoView;
	private ArrayAdapter<ToDo> arrayAdapter;
	
	private static final int MENU_SETTINGS = Menu.FIRST;
	private static final int MENU_EDIT_TODO = Menu.FIRST + 1;
	private static final int MENU_DELETE_TODO = Menu.FIRST + 2;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todolist);
        loadToDoList();
        loadAddNewToDoBehavior();
    }

	private void loadToDoList() {
		// temporary instantiation
		toDoList = MockUpToDoList.getFakeToDoList();
		// bind list to adapter
        arrayAdapter = new ArrayAdapter<ToDo>(this, 
        									R.layout.todoview,
        									toDoList.getToDoList());
        //toDoListView = (ListView)findViewById(R.id.todolist);
        //toDoListView.setAdapter(arrayAdapter);
        //toDoListView.setDivider(null);
        setListAdapter(arrayAdapter);
        getListView().setDivider(null);
	}

	private void loadAddNewToDoBehavior() {
        addNewToDoView = (AddNewToDoView)findViewById(R.id.addnewtodoview);
        addNewToDoView.setButtonOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Context context = CuteToDoListActivity.this;
				if (toDoList.addToDo(addNewToDoView.getContent())){
					arrayAdapter.notifyDataSetChanged();
					addNewToDoView.resetControl();
					ToastLauncher.showToast(context, ToastLauncher.ToastType.NEW_TODO);
				}
				else
					ToastLauncher.showToast(context, ToastLauncher.ToastType.NEW_TODO_CANNOT_BE_EMPTY);

			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// add system menu options
		super.onCreateOptionsMenu(menu);
		// add application related menu options
		int groupId = 0;
		menu.add(groupId, MENU_SETTINGS, Menu.NONE, R.string.menu_settings);
		menu.add(groupId, MENU_EDIT_TODO, Menu.NONE, R.string.menu_edit_todo);
		menu.add(groupId, MENU_DELETE_TODO, Menu.NONE, R.string.menu_delete_todo);
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		switch (item.getItemId()){
		case MENU_SETTINGS:
			break;
		case MENU_EDIT_TODO:
			break;
		case MENU_DELETE_TODO:
			break;
		}
		
		return true;
	}
	
}