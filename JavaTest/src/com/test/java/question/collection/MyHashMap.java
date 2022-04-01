package com.test.java.question.collection;

public class MyHashMap {
	
	private String[][] hashMap;
	private int index;
	private static final int key = 0;
	private static final int value = 1;
	private static final int col = 2;
	
	public MyHashMap() {
		this.index = 0;	
	}
	
	public String put(String key, String value) {
		
		int keyIndex = findKey(key);
		
		if(keyIndex > -1) {
			String oldValue = hashMap[keyIndex][MyHashMap.value];
			hashMap[keyIndex][MyHashMap.value] = value;
			return oldValue;	
		}
		
		if(this.hashMap == null) {
			hashMap = new String[4][MyHashMap.col];
		}
		if(this.index == hashMap.length) {
			doubleMap();
		}
		
		hashMap[this.index][MyHashMap.key] = key;
		hashMap[this.index][MyHashMap.value] = value;
		this.index++;
		
		return null;
	}
	

	private void doubleMap() {
		String[][] newMap = new String[this.index * 2][MyHashMap.col];
		
		for(int i=0; i<this.index; i++) {
			newMap[i][MyHashMap.key] = hashMap[i][MyHashMap.key];
			newMap[i][MyHashMap.value] = hashMap[i][MyHashMap.value];
		}
		
		hashMap = newMap;
	}
	
	public String get(String key) {
		
		int keyIndex = findKey(key);
		
		if(keyIndex == -1) {
			return null;
		}
		
		return hashMap[keyIndex][MyHashMap.value];
		
	}

	public int size() {
		return this.index;
	}
	
	public String remove(String key) {
		
		int keyIndex = findKey(key);
		
		if(keyIndex == -1) {
			return null;
		}
		
		String oldValue = hashMap[keyIndex][MyHashMap.value];

		for(int i=keyIndex; i<this.index-1; i++) {
			hashMap[i][MyHashMap.key] = hashMap[i+1][MyHashMap.key];
			hashMap[i][MyHashMap.value] = hashMap[i+1][MyHashMap.value];
		}
		this.index--;
		
		return oldValue;
				
	}
	
	private int findKey(String key) {
		for(int i=0; i<this.index; i++) {
			if(hashMap[i][MyHashMap.key].equals(key)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean containsKey(String key) {
		for(int i=0; i<this.index; i++) {
			if(hashMap[i][MyHashMap.key].equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsValue(String value) {
		for(int i=0; i<this.index; i++) {
			if(hashMap[i][MyHashMap.value].equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	
	public void clear() {
		this.index = 0;
	}
	
	public void trimToSize() {
		
		String[][] newMap = new String[this.index][MyHashMap.col];
		
		for(int i=0; i<this.index; i++) {
			newMap[i][MyHashMap.key] = hashMap[i][MyHashMap.key];
			newMap[i][MyHashMap.value] = hashMap[i][MyHashMap.value];
		}
		
		hashMap = newMap;
	}
	
	@Override
	public String toString() {
		String temp = "";
		
		temp += "[MyHashMap]\n";
		temp += "- hashMap: "+ hashMap.length +"]\n"; 
		temp += "- index: " + this.index + "\n"; 		
		temp += "---------------------------------\n";
		
		for(int i=0; i<hashMap.length; i++) {
			temp += "key: " + hashMap[i][MyHashMap.key] + ", value: " + hashMap[i][MyHashMap.value] + "\n"; 
		}
		temp += "---------------------------------\n";
		
		return temp;
	}
}
	
	
	
	
	
	

