package com.test.java.question.collection;

public class TArrayList {
	
	private String[] list; 
	private int index; 
	
	public TArrayList() {
		this.index = 0;
	}
	
	public boolean add(String value) {
		//배열의 끝에 아이템넣기
		//1. 처음 넣을 때 배열 만들기
		//1.5 방이 모자라면 배열을 2배로 늘리기
		//2. 데이터 넣기
		
		try {
			init();
			
			if(checkLength()) { 
				doubleList();    //***mj)메소드로
			}
			
			this.list[this.index] = value;
			this.index++; //Append
			
			return true;
		
		} catch (Exception e) {	//***mj)try catch문
			return false;
		}
	
	}
	
	private void doubleList() {

		//1. 2배 길이의 배열 생성
		//2. 깊은 복사
		//3. 교체
		
		String[] temp = new String[this.list.length * 2];
		
		for(int i=0; i<this.list.length; i++) { //***mj)i값을 위와 똑같이 list.length로
			temp[i] = this.list[i];
		}
	
		this.list = temp;
	}

	private boolean checkLength() {
		
		//방이 꽉찼는지?
		if(this.index == this.list.length) {
			return true;
		}
		
		return false;
	}

	private void init() {
		//처음 넣을 때 배열 만들기
		if(this.index == 0) {
			this.list = new String[4];			
		}
	}

	public String get(int index) {
		if(!checkIndex(index)) { //***mj)checkIndex가 true면 유효하게 설계한 후 !를 붙임
			//잘못된 방번호
			throw new IndexOutOfBoundsException();
		}
		return this.list[index];
	
	}
	
	public int size() {
		return this.index;
	}
	
	public String set(int index, String value) {
		
		if(!checkIndex(index)) { 
			throw new IndexOutOfBoundsException();
		}
		
		String temp = this.list[index];
		
		this.list[index] = value;
		
		return temp;
	}
	
	public String remove(int index) {
		
		String temp = this.list[index];
		
		//Left Shift 처리
		for (int i=index; i<this.list.length-1; i++) {
			this.list[i] = this.list[i+1];
		}
		
		//데이터 1개 삭제 > this.index 반영(***)
		this.index--;
		
		return temp;
	}
	
	public boolean add(int index, String value) {
		
		//삽입 > Right Shift
		try {
			
			if(checkLength()) { 
				doubleList();    
			}
			
			for (int i=this.list.length - 2; i>=index; i--) {
				this.list[i+1] = this.list[i];
			}
			
			this.list[index] = value;
			this.index++;
			
			return true;
		
		} catch (Exception e) {
			return false;
		}
	}
	
	public int indexOf(String value) {
		
		for(int i=0; i<this.list.length; i++) {
			if(this.list[i].equals(value)) {
				return i;
			}
		}
		return -1;
	
	}

	public int lastIndexOf(String value) {
		
		for(int i=this.index -1; i>=0; i--) {
			if(this.list[i].equals(value)) {
				return i;
			}
		}
		return -1;
		
	}
	
	public void clear() {
		
		//모든 요소 삭제
		//Case 1.
//		for(int i=0; i<this.size(); i++) {
//			this.list[i] = null;
//		}
		
		//Case 2.
		this.list = new String[4]; 
		//메모리면에서는 낭비 > 비용은 더 비쌈
		//배열의 길이가 길수록 속도는 더 빠름
		
		//Case 3. 이 방법을 가장 추천
		this.index = 0; //속도, 경제측면에서 우위 ***
		
	}
	
	public void trimToSize() {
	
		//배열 늘리기의 반대 작업
		String[] temp = new String[this.index];
		
		for(int i=0; i<this.list.length; i++) { 
			temp[i] = this.list[i];
		}
	
		this.list = temp;
		
	}
	
	
	private boolean checkIndex(int index) {
		
		//유효한 index의 범위
		//0 ~ index - 1
		if(index >= 0 && index < this.index	) { 
			return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		
		//객체의 상태를 확인하는 용도
		// > 되도록 상황에 따라 보기 좋게 구현
		
		String temp = "";
		
		temp += "\n";
		temp += String.format("length: %d\n", this.list.length); //배열의 실제 길이
		temp += String.format("index: %d\n", this.index); //현재 방번호
		temp += String.format("[\n");
	
		for(int i=0; i<this.list.length; i++) {
			temp+= String.format("	%d: %s\n", i, this.list[i]);
		}
		temp += String.format("\n]");
		
		return temp;
	}
}








