package com.barbarianmeetscoding.cutetodolist.domain;

public class ToDo {
	private int id;
	private String content;
	
	public int getId(){
		return id;
	}
	public ToDo setId(int id){
		this.id = id;
		return this;
	}
	public String getContent(){
		return content;
	}
	public ToDo setContent(String content){
		this.content = content;
		return this;
	}
	
	@Override
	public String toString() {
		return content;
	}

}
