package com.test.java.question.classtest;

public class Q08_constructor {

	public static void main(String[] args) {
		
//		요구사항] Time 클래스의 생성자 오버로딩을 구현하시오.
//		- 상태
//			hour: 시(0 이상 양의 정수)
//			minute: 분(0 이상 양의 정수)
//			second: 초(0 이상 양의 정수)
//		- 행동
//			public Time() >	시(0), 분(0), 초(0)
//			public Time(int hour, int minute, int second)
//			public Time(int minute, int second)
//			public Time(int second)
//			String info() >	02:30:45 > 숫자 2자리
			
		//시간 1
		Time t1 = new Time(); //기본 생성자 호출
		System.out.println(t1.info());

		//시간 2
		Time t2 = new Time(2, 30, 45); //오버로딩 생성자 호출
		System.out.println(t2.info());

		//시간 3
		Time t3 = new Time(1, 70, 30); //오버로딩 생성자 호출
		System.out.println(t3.info());

		//시간 4
		Time t4 = new Time(30, 10); //오버로딩 생성자 호출
		System.out.println(t4.info());

		//시간 5
		Time t5 = new Time(90, 10); //오버로딩 생성자 호출
		System.out.println(t5.info());

		//시간 6
		Time t6 = new Time(2, 70, -10); //오버로딩 생성자 호출
		System.out.println(t6.info());

		//시간 7
		Time t7 = new Time(10000); //오버로딩 생성자 호출
		System.out.println(t7.info());
		
		Time t8 = new Time(-1, -1, -1);
		System.out.println(t8.info());
	
		
	}
}

class Time {
	
	private int hour;
	private int minute;
	private int second;
	
	public Time() {
		this(0, 0, 0);
	}
	public Time(int second) {
		this(0, 0, second);
	}
	public Time(int minute, int second) {
		this(0, minute, second);
	}
	public Time(int hour, int minute, int second) {
		
//		this.hour = 0;
//		this.minute = 0;
//		this.second = 0;  
		
		if(second > 0) {
			this.second += second % 60;
			this.minute += (second / 60) % 60 ;
			this.hour += second / 60 / 60;
		}
		if(minute > 0) {
			this.minute += minute % 60;
			this.hour += minute / 60;
		}
		if(hour > 0) {
			this.hour += hour;
		}
	}
	
	public String info() {
		return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
	}
}







