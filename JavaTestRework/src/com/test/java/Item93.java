package com.test.java;

public class Item93 {

	public static void main(String[] args) {
		
		//[SUMMARY] 클래스 멤버변수 만들기(배열) (2022. 3. 27. 오후 9:44:03)
		
		CPU cpu = new CPU();
		MainBoard mainboard = new MainBoard();
	
		Computer computer = new Computer();
		computer.setCpu(cpu);
		computer.setMainboard(mainboard);
		
		
		Memory memory = new Memory();
		computer.setMemory(memory);
		Memory memory2 = new Memory();
		computer.setMemory(memory2);
		
		
		computer.removeMemory();
	
	}	
}

class Computer {
	
	private CPU cpu;
	private MainBoard mainboard;	
	
	private int i = 0;			 
	private Memory[] memory = new Memory[4];
	
	
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	public void setMainboard(MainBoard mainboard) {
		this.mainboard = mainboard;
	}
	
	
	public void setMemory(Memory memory) {
		if(i == 4) return; 
		
		this.memory[i] = memory;
		i++;
	} 
	public void removeMemory() {
		if(i == 0) return;
		
		i--;
		this.memory[i] = null; //NULL 상수, NULL 리터럴
	}
	
}

class CPU {
}
class MainBoard {	
}
class Memory {	
}