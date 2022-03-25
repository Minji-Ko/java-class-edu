package com.test.java;

public class prac {

	public static void main(String[] args) {
		
		CPU cpu = new CPU();
		cpu.setModel("Intel i5");
		cpu.setSpeed("1.8");
	
		MainBoard mainboard = new MainBoard();
		mainboard.setModel("M500");
	
		Storage storage = new Storage();
		storage.setModel("SM");
		storage.setSize(500);
		storage.setType("SSD");
		
		Computer computer = new Computer();
		computer.setCpu(cpu);
		computer.setMainboard(mainboard);
		computer.setStorage(storage);
		
		Memory m1 = new Memory();
		computer.setLists(m1);
		Memory m2 = new Memory();
		computer.setLists(m2);
		Memory m3 = new Memory();
		computer.setLists(m3);
		Memory m4 = new Memory();
		computer.setLists(m4);
		
		computer.removeMemory();
	}
}

class Computer {
	
	private CPU cpu;
	private MainBoard mainboard;
	private Storage storage;
	private int i = 0;
	private Memory[] lists = new Memory[4];
	
	
	public CPU getCpu() {
		return cpu;
	}
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	public MainBoard getMainboard() {
		return mainboard;
	}
	public void setMainboard(MainBoard mainboard) {
		this.mainboard = mainboard;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	public Memory[] getLists() {
		return lists;
	}
	public void setLists(Memory list) {
		if(i<4) {
			this.lists[i] = list;
			i++;
		} else {
			System.out.println("full");
		}
	}
	public void removeMemory() {
		if(i==0) {
			System.out.println("x");
		}
		
		i--;
		this.lists[i] = null;
	}
	
}

class Memory {
	private String model;
	private int size;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}

class CPU {
	private String model;
	private String speed;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	
	
}


class MainBoard {
	private String model;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}


}

class Storage {
	private String model;
	private String type;
	private int size;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}

