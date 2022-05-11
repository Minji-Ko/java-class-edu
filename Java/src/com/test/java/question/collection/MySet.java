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
		
		if(indexOf(value) > -1) { 
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
		return true; //*mj* try catch문
	}
	
	private void doubleSet() {
		String[] newSet = new String[this.index * 2]; //*mj* hashSet.length를 이용하면 가독성 좋음
		
		for(int i=0; i<this.index; i++) {
			newSet[i] = hashSet[i];
		}
		
		hashSet = newSet;
	}
	
	
	private int indexOf(String value) {
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
		
		int valueIndex = indexOf(value);
		
		if(valueIndex == -1) {
			return false;
		}
		
		for(int i=valueIndex; i<this.index-1; i++) {
			hashSet[i] = hashSet[i+1];
		}

		this.index--;

		modifyIterIndex(valueIndex); //*mj*
				
		return true;
	}

	private void modifyIterIndex(int valueIndex) {
		if(valueIndex != -1 && valueIndex < this.iterIndex) {
			this.iterIndex--;
		}
	}

	public void clear() {
		this.index = 0;
		this.iterIndex = 0; //*mj*
	}

	
	public boolean hasNext() {
		if(iterIndex >= this.index) {
			return false;
		}
		
		return true;
	}
	

	public String next() {		
		
		if(iterIndex == this.index) {  //*mj*
			throw new NoSuchElementException();
		}
		String temp = hashSet[iterIndex];
		iterIndex++;
		return temp;  //*mj* hashSet[iterIndex -1]을 return하면 따로 temp변수 없어도 됌
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

