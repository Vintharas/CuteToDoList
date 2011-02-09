package com.barbarianmeetscoding.cutetodolist;

import com.barbarianmeetscoding.cutetodolist.domain.ToDo;
import com.barbarianmeetscoding.cutetodolist.domain.ToDoList;
import com.barbarianmeetscoding.cutetodolist.storage.MockUpToDoList;
import com.barbarianmeetscoding.cutetodolist.utils.ToastLauncher;
import com.barbarianmeetscoding.cutetodolist.utils.ToastLauncher.ToastType;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class CuteToDoListActivity extends ListActivity {
	
	
	private ToDoList toDoList;
	private AddNewToDoView addNewToDoView;
	private ArrayAdapter<ToDo> arrayAdapter;
	private ListView toDoListView;
	
	private static final int MENU_SETTINGS = Menu.FIRST;
	private static final int MENU_EDIT_TODO = Menu.FIRST + 1;
	private static final int MENU_DELETE_TODO = Menu.FIRST + 2;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todolist);
        setUpListView();
        loadToDoList();
        loadAddNewToDoBehavior();
        registerForContextMenu(getListView());
    }

	private void setUpListView() {
        toDoListView = getListView();
        toDoListView.setDivider(null);
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
	public boolean onOptionsItemSelected(MenuItem menuItem) {
		super.onOptionsItemSelected(menuItem);
		int toDoPosition = toDoListView.getSelectedItemPosition();
		switch (menuItem.getItemId()){
		case MENU_SETTINGS:
			break;
		case MENU_EDIT_TODO:
			break;
		case MENU_DELETE_TODO:
			 if (!deleteToDo(toDoPosition))
				 ToastLauncher.showToast(this, ToastType.ERROR_NOTODO_SELECTED);
			break;
		}
		
		return true;
	}
	
	private boolean deleteToDo(int toDoPosition) {
		try {
			toDoList.deleteToDo(toDoPosition);
			arrayAdapter.notifyDataSetChanged();
		}catch(ArrayIndexOutOfBoundsException ex){
			return false;
		}
		return true;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		getMenuInflater().inflate(R.menu.contextmenu_todolist, menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem menuItem) {
		super.onContextItemSelected(menuItem);
		// get current selected toDo
		AdapterView.AdapterContextMenuInfo menuInfo;
		menuInfo = (AdapterView.AdapterContextMenuInfo)menuItem.getMenuInfo();
		int toDoPosition = menuInfo.position;
		// act upon the selected todo
		switch(menuItem.getItemId())
		{
		case R.id.contextmenu_edit_todo:
			break;
		case R.id.contextmenu_delete_todo:
			deleteToDo(toDoPosition);
			break;
		}
		return true;
	}
	
}