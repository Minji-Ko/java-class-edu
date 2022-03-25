package com.test.java.question.classtest;

import java.util.Calendar;

public class Q03 {

	public static void main(String[] args) {

//		요구사항] 과자(Bugles) 클래스를 설계하시오.
//		- Bugles 객체의 정보 > 	가격, 용량, 생산일자, 유통기한
//		- 모든 멤버 변수의 접근 지정자는 private으로 한다.
//		- 멤버 접근을 위한 Setter와 Getter를 정의한다.
//			- 용량 : 쓰기 전용, 300g, 500g, 850g
//			- 가격 : 읽기 전용, 850원(300g), 1200원(500g), 1950원(850g)
//			- 생산일자 : 쓰기 전용(Calendar)
//			- 남은유통기한 : 읽기 전용, 생산된 제품의 유통기한 기준 : 7일(300g), 10일(500g), 15일(850g)
//		- Bugles 객체 메소드
//			- void eat() : 과자 먹기
//		- 먹을수 있는 날짜 = 유통기한 - 현재 - 제조시간
//			- 5 : 먹을 수 있는 날짜가 5일 남음
//			- -3 : 먹을 수 있는 날짜가 3일 지남
	
	
		Bugles snack = new Bugles();

		snack.setWeight(500);
		snack.setCreationTime("2022-3-21");
		System.out.println("가격 : " + snack.getPrice() + "원");
		System.out.println("유통 기한이 " + snack.getExpiration() + "일 남았습니다.");

		snack.eat();


		Bugles snack2 = new Bugles();

		snack2.setWeight(300);
		snack2.setCreationTime("2022-3-13");
		System.out.println("가격 : " + snack2.getPrice() + "원");
		System.out.println("유통 기한이 " + snack2.getExpiration() + "일 남았습니다.");

		snack2.eat();
		
		
		Bugles snack3 = new Bugles();

		snack3.setWeight(850);
		snack3.setCreationTime("2022-3-25");
		System.out.println("유통 기한이 " + snack3.getExpiration() + "일 남았습니다.");

		snack2.eat();
		
	
	}
}

class Bugles {
	
	private int price;
	private int weight;
	private Calendar creationTime;
	private int expiration;
	
	public int getPrice() {
		return price;
	}
	public void setWeight(int weight) {
		
		if(weight == 300) {
			this.weight = weight;
			this.price = 850;
			this.expiration = 7;
			
		} else if (weight == 500) {
			this.weight = weight;
			this.price = 1200;
			this.expiration = 10;
			
		} else if (weight == 850) {
			this.weight = weight;
			this.price = 1950;
			this.expiration = 15;
			
		} else {
			System.out.println("용량이 올바르지 않습니다. (용량 : 300g, 500g, 850g)");
		}
		
	}
	public int getExpiration() {
		int time = (int)((System.currentTimeMillis() - creationTime.getTimeInMillis()) / 1000 / 60 / 60 / 24);  //** Math.ceil로 처리해야 함
		
		return this.expiration - time - 1;
	}
	
	public void setCreationTime(String time) {
		
		int year = Integer.parseInt(time.substring(0,time.indexOf("-")));
		int month = Integer.parseInt(time.substring(time.indexOf("-") + 1, time.lastIndexOf("-")));
		int date = Integer.parseInt(time.substring(time.lastIndexOf("-") + 1));
		
		creationTime = Calendar.getInstance();
		creationTime.set(year, month-1, date);
	}
	
	public void eat() {
		if(getExpiration() >= 0) {
			System.out.println("과자를 맛있게 먹습니다.");
		} else {
			System.out.println("유통기한이 지나 먹을 수 없습니다.");
		}
	}
}


//		설계] 
//		1. Bugle 클래스 private 멤버변수 만들기 4개 
//		2. setter, getter 만들기
//		3. void eat() 만들기 
//		4. main메소드에서 객체만들어서 실행하기