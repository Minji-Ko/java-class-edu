package com.test.java.question.collection;

import java.util.NoSuchElementException;

public class MySet {

	private String[] hashSet;
	private int index;
	private int iterIndex;
	
	public MySet() {
		this.index = 0;
		this.iterIndex = 0;
	}
	
	public boolean add(String value) {
		
		if(find(value) > -1) {
			return false;
		}
		
		if(this.hashSet == null) {
			hashSet = new String[4];
		}
		if(this.index == hashSet.length) {
			doubleSet();
		}
		
		hashSet[this.index] = value;
		this.index++;
		return true;
	}
	
	private void doubleSet() {
		String[] newSet = new String[this.index * 2];
		
		for(int i=0; i<this.index; i++) {
			newSet[i] = hashSet[i];
		}
		
		hashSet = newSet;
	}
	
	
	private int find(String value) {
		for(int i=0; i<this.index; i++) {
			if(hashSet[i].equals(value)){
				return i;
			}
		}
		return -1;
	}
	
	public int size() {
		return this.index;
	}

	public boolean remove(String value) {
		
		int valueIndex = find(value);
		
		if(valueIndex == -1) {
			return false;
		}
		
		for(int i=valueIndex; i<this.index-1; i++) {
			hashSet[i] = hashSet[i+1];
		}

		this.index--;

		modifyIterIndex(valueIndex);
				
		return true;
	}

	private void modifyIterIndex(int valueIndex) {
		if(valueIndex != -1 && valueIndex < this.iterIndex) {
			this.iterIndex--;
		}
	}

	public void clear() {
		this.index = 0;
		this.iterIndex = 0;
	}

	
	public boolean hasNext() {
		if(iterIndex >= this.index) {
			return false;
		}
		
		return true;
	}
	

	public String next() {		
		
		if(iterIndex == this.index) {
			throw new NoSuchElementException();
		}
		String temp = hashSet[iterIndex];
		iterIndex++;
		return temp;
	}

	
	@Override
	public String toString() {
		
		String temp = "";
		
		temp += "[MySet]\n";
		temp += "index: " + this.index + "\n";
		temp += "iterIndex: " + this.iterIndex + "\n";
		temp += "---------------------------------\n";
		
		for(int i=0; i<hashSet.length; i++) {
			temp += "value: " + hashSet[i] + "\n"; 
		}
		temp += "---------------------------------\n";
		
		return temp;
	}

}

