package com.barbarianmeetscoding.cutetodolist.utils;

import com.barbarianmeetscoding.cutetodolist.R;

import android.content.Context;
import android.widget.Toast;

public class ToastLauncher {

	private static final int TOAST_NEW_TODO = 0;
	private static final int TOAST_NEW_TODO_CANNOT_BE_EMPTY = 1;
	
	public enum ToastType{
		NEW_TODO(0),
		NEW_TODO_CANNOT_BE_EMPTY(1);
		
		private int toastType;
		ToastType(int toastType){
			this.toastType = toastType;
		}
		public int getType(){
			return toastType;
		}
	}
	
	public static void showToast(Context context, ToastType toastType){
		int messageResourceId = 0;
		switch (toastType.getType()){
		case TOAST_NEW_TODO:
			messageResourceId = R.string.toast_new_todo_added;
			break;
		case TOAST_NEW_TODO_CANNOT_BE_EMPTY:
			messageResourceId = R.string.toast_todo_cannot_be_empty;
			break;
		}
		Toast.makeText(context, messageResourceId, Toast.LENGTH_SHORT).show();
	}
}
