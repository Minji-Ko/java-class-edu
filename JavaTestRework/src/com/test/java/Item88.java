package com.test.java;

public class Item88 {

	public static void main(String[] args) {
		
		//[SUMMARY] 클래스 멤버메소드 만들기(Getter, Setter) (2022. 3. 27. 오후 8:56:05)
		
		Phone p1 = new Phone();
		
		p1.setModel("S21");
		p1.setWeight(300);
		
		System.out.println(p1.getModel());
		System.out.println(p1.getWeight());
	}	
}

class Phone {
	
	private String model;
	private int weight;
	
	
	public String getModel() {  			//public(***)
		return model;
	}
	public void setModel(String model) {	
		this.model = model;
	}
	
	
	public double getWeight() {
		return calcWeight(weight); //calWeight메소드에서 내부 업무 처리
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	private double calcWeight(int weight) {  //private(***)
		return weight /1000.0;
	}
	
}