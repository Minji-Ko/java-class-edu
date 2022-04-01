package com.test.java.question.collection;

public class MyHashMap2 {
	
	private KVSet[] hashMap;
	private int index;
	
	public MyHashMap2() {
		this.index = 0;	
	}
	
	public String put(String key, String value) {
		
		int keyIndex = findKey(key);
		
		if(keyIndex > -1) {
			String oldValue = hashMap[keyIndex].getValue();
			hashMap[keyIndex].setValue(value);
			return oldValue;	
		}
		
		if(this.hashMap == null) {
			hashMap = new KVSet[4];
		}
		if(this.index == hashMap.length) {
			doubleMap();
		}
		
		hashMap[this.index] = new KVSet(key, value);
		this.index++;
		
		return null;
	}

	private void doubleMap() {
		KVSet[] newMap = new KVSet[this.index * 2];
		
		for(int i=0; i<this.index; i++) {
			newMap[i]= hashMap[i];
		}
		
		hashMap = newMap;
	}
	
	public String get(String key) {
		
		int keyIndex = findKey(key);
		
		if(keyIndex == -1) {
			return null;
		}
		
		return hashMap[keyIndex].getValue();
		
	}

	public int size() {
		return this.index;
	}
	
	public String remove(String key) {
		
		int keyIndex = findKey(key);
		
		if(keyIndex == -1) {
			return null;
		}
		
		String oldValue = hashMap[keyIndex].getValue();

		for(int i=keyIndex; i<this.index-1; i++) {
			hashMap[i] = hashMap[i+1];
		}
		this.index--;
		
		return oldValue;
				
	}
	
	private int findKey(String key) {
		
		for(int i=0; i<this.index; i++) {
			if(hashMap[i].getKey().equals(key)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean containsKey(String key) {
		
		for(int i=0; i<this.index; i++) {
			if(hashMap[i].getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsValue(String value) {
		
		for(int i=0; i<this.index; i++) {
			if(hashMap[i].getValue().equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	
	public void clear() {
		this.index = 0;
	}
	
	public void trimToSize() {
		
		KVSet[] newMap = new KVSet[this.index];
		
		for(int i=0; i<this.index; i++) {
			newMap[i] = hashMap[i];
		}
		
		hashMap = newMap;
	}
	
	@Override
	public String toString() {
		String temp = "";
		
		temp += "MyHashMap\n";
		temp += "- hashMap: "+ hashMap.length +"\n"; 
		temp += "- index: " + this.index + "\n"; 		
		temp += "---------------------------------\n";
		
		for(int i=0; i<hashMap.length; i++) {
			if(hashMap[i] == null) {
				temp += "hashMap["+ i +"] key: null, value: null\n"; 	
				continue;
			}
			temp += "hashMap["+ i +"] key: " + hashMap[i].getKey() + ", value: " + hashMap[i].getValue() + "\n"; 
		}
		temp += "---------------------------------\n";
		
		return temp;
		
	}
}

class KVSet {
	private String key;
	private String value;

	public KVSet(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}