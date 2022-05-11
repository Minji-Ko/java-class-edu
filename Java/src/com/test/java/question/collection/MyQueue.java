package com.test.java.question.collection;

public class MyQueue {

	private String[] list;
	private int index;
	
	public MyQueue() {
		this.index = 0;
	}
	
	public boolean add(String value) {
		if(this.list == null) {
			this.list = new String[4];
		}
		if(list.length == this.index) {
			grow();
		}
		
		this.list[index] = value;
		this.index++;
		
		return true;
	}
	private void grow() {
		String[] newList = new String[list.length * 2];
		
		for(int i=0; i<this.index; i++) {
			newList[i] = list[i];
		}
		
		this.list = newList;
	}
	

	public String poll() {
		if(this.index == 0) {
			return null;
		}
		
		this.index--;
		String oldValue = this.list[0];
		for(int i=1; i<this.index; i++) {
			list[i-1] = list[i];
		}
		this.list[index] = null;

		return oldValue;
	}

	public int size() {
		return this.index;
	}
	
	public String peek() {
		if(this.index == 0) {
			return null;
		}
		
		return this.list[0];
	}
	
	public void clear() {
		for(int i=0; i<this.index; i++) {
			list[i] = null;
		}
		this.index = 0;
	}

	public void trimToSize() {
		String[] newList = new String[this.index];
		
		for(int i=0; i<this.index; i++) {
			newList[i] = list[i];
		}
		
		this.list = newList;
	}
}
