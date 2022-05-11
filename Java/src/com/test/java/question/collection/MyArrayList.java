package com.test.java.question.collection;


//ArrayList와 동일한 동작을 하는 클래스를 선언하시오.
public class MyArrayList {

	private String[] list; //ArrayList의 내부 배열(*****)
	private int index; //***** 가장 중요한 역할
	
	public MyArrayList() {
		this.index = 0;
	}
	public MyArrayList(int initialCapacity) {
		if(initialCapacity < 0) {
			throw new IllegalArgumentException();
		}
		this.list = new String[initialCapacity];
		this.index = 0;
	}

	public boolean add(String value) {
		//TODO remove, clean, trimToSize에서 index==0일 때 배열상태가 null? string[0]? string[n]? (2022. 3. 31. 오후 5:08:25)
		
		init(); 
		
		if (this.index == list.length) {
			grow();
		}
		
		this.list[this.index] = value;
		this.index++;	
		
		return true; //ArrayList는 항상 true > Collection interface 상속 > Set에서는 중복된 값을 add할 경우 false가 나옴
	}
	
	
	public boolean add(int index, String value) {
		//없는 방번호 요청
		if(index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException(); 
		}
		
		if(list.length == this.index) { 
			grow();
		} 
		
		//남는 배열칸수가 있을 때
		for(int i=this.index; i>index; i--) {
			this.list[i] = this.list[i-1];
		}
		this.list[index] = value;
		this.index++;
		
		return true;
		
	}
	
	private void init() {
		if (this.list == null) { 
			this.list = new String[4];
		}
	}
	
	private void grow() {
		String[] newlist = new String[list.length * 2];
		
		for(int i=0; i<this.index; i++) { //배열 복사
			newlist[i] = list[i];
		}	
		
		this.list = newlist;
	}
	
	public String get(int index) {
		//없는 방번호를 요청했을 때?
		if(index < 0 || index >= this.index) {
			throw new IndexOutOfBoundsException(); //예외 처리를 해서 상황을 출력하지 않고 예외를 던져서 사용자가 처리하도록 유도~
		}
		
		return this.list[index];
		
	}
	
	public int size() {
		return this.index;
	}
	
	public String set(int index, String value) {
		if(index < 0 || index >= this.index) {
			throw new IndexOutOfBoundsException(); 
		}
		
		String oldValue = this.list[index];
		this.list[index] = value;
		return oldValue;
	}
	
	public String remove(int index) {

		if(index < 0 || index >= this.index) {
			throw new IndexOutOfBoundsException();
		}
		
		String oldValue = this.list[index];
		
		this.index--;
		
		for(int i=index; i<this.index; i++) {
			this.list[i] = this.list[i+1];
		}
		//this.list[this.index] = null;  //마지막방 삭제
		return oldValue;
	}
	
	public int indexOf(String value) {
		for(int i=0; i<this.index; i++) {
			if(list[i].equals(value)) {
				return i;
			} 
		}
		return -1; 
	}
	
	public int lastIndexOf(String value) {
		for(int i=this.index-1; i>=0; i--) {
			if(list[i].equals(value)) {
				return i;
			}
		}
		return -1; 
	}
	
	public void clear() { 
		for(int i=0; i<this.size(); i++) {
			this.list[i] = null;
		}
		this.index = 0;
	}
	
	public void trimToSize() {
		if (list.length > this.index) {
			
			String[] newList = new String[this.index];
			
			for(int i=0; i<this.index; i++) { //배열 복사
				newList[i] = list[i];
			}	
			
			list = newList;
		}
		
	}
	
}	










