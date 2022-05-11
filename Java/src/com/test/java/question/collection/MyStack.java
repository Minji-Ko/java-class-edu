package com.test.java.question.collection;

import java.util.EmptyStackException;

public class MyStack {
	
	private String[] list;
	private int index;
	
	public MyStack() {
		this.index = 0;
	}

	public String push(String value) {
		if(this.list == null) {
			list = new String[4];
		} 
		if(this.index == list.length) {
			grow();
		}
		
		list[index] = value;
		this.index++;
		
		return value;
	}
	
	private void grow() {
		String[] newList = new String[list.length * 2];
		
		for(int i=0; i<list.length; i++) {
			newList[i] = list[i];
		}
		
		list = newList;
	}
	
	public String pop() {
		
		if(this.index == 0) {
			throw new EmptyStackException();
		} 
		
		this.index--;
		String value = list[this.index];
		list[this.index] = null;  
	
		return value;	
	}
	
	public int size() {
		return this.index;
	}

	public String peek() {
		if(this.index == 0) {
			throw new EmptyStackException();
		} 
		return list[this.index - 1];
	}
	
	public void clear() {
		for(int i=0; i<this.size(); i++) {
			this.list[i] = null;
		}
		this.index = 0;
	}
	
	public void trimToSize() {
		if(list.length > this.size()) {
			String[] newList = new String[this.size()];
			
			for(int i=0; i<this.size(); i++) {
				newList[i] = list[i];
			}
			
			this.list = newList;
		}
	}
}













