package com.barbarianmeetscoding.cutetodolist.domain;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
	private List<ToDo> toDoList = new ArrayList<ToDo>();
	
	public List<ToDo> getToDoList(){
		return toDoList;
	}
	
	public boolean addToDo(String content) {
		if (!content.contentEquals("")){
			toDoList.add(0, new ToDo().setContent(content));
			return true;
		}
		return false;
			
	}
	
	public void deleteToDo(int position){
		toDoList.remove(position);
	}
}
