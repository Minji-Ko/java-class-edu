package com.test.java;

public class Item96 {

	public static void main(String[] args) {
		
		//[SUMMARY] ToString 오버라이드하기(dump) (2022. 3. 28. 오후 10:31:42)
		
		Time t1 = new Time(1, 30);
		
		System.out.println(t1);
		System.out.println(t1.toString());
	
	}	
}

class Time {
	
	private int hour;
	private int min;
	
	public Time(int hour, int min) {
		this.hour = hour;
		this.min = min;
	}
	
	@Override 
	public String toString() {   //개발자만 보는 정보
		return "Time [hour=" + hour + ", min=" + min + "]";
	}
	
}