package com.barbarianmeetscoding.cutetodolist.storage;

import com.barbarianmeetscoding.cutetodolist.domain.ToDoList;

public class MockUpToDoList {

	public static ToDoList getFakeToDoList()
	{
		ToDoList toDoList = new ToDoList();
		toDoList.addToDo("Remember to Love Myself");
		toDoList.addToDo("Paint my nails");
		toDoList.addToDo("Blog about painting my nails");
		toDoList.addToDo("I love myself");
		return toDoList;
	}

}
