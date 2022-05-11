package com.test.java;

public class Item93 {

	public static void main(String[] args) {
		
		//[SUMMARY] 클래스 멤버변수 만들기(배열) (2022. 3. 27. 오후 9:44:03)
		
		Computer computer = new Computer();
		
		Memory memory = new Memory();
		computer.setMemory(memory);
		
		computer.removeMemory();
	
	}	
}

class Computer {
	
	private int i = 0;	
	private Memory[] memory = new Memory[4];
	
	public void setMemory(Memory memory) {
		if(i == this.memory.length) return; 
		
		this.memory[i] = memory;
		i++;
	} 
	
	public void removeMemory() {
		if(i == 0) return;
		
		i--;
		this.memory[i] = null; //NULL 상수, NULL 리터럴
	}
	
}

class Memory {	
	
}