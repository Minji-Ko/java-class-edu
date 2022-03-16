package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q06_Delivery {

	public static void main(String[] args) throws Exception{
		
//		요구사항] 여러 배달 음식을 같은 시간에 받기를 원하는 고객이 있다. 고객이 각각의 매장에 몇시에 전화를 해야 모든 음식을 같은 시간에 받을 수 있는지 알려주시오.
//		- 전화를 걸면 짜장면은 10분 뒤에 도착합니다.
//		- 전화를 걸면 치킨은 18분 뒤 도착합니다.
//		- 전화를 걸면 피자는 25분 뒤 도착합니다.
//		- 음식을 받기 원하는 시간은 오후 11시 이전에만 가능합니다.(날짜 변경 금지) 
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("음식을 받기 원하는 시각");
		
		System.out.print("시 : ");
		int hour = Integer.parseInt(reader.readLine());
			hour = (0 <= hour && hour < 23) ? hour : null; 
	
		System.out.print("분 : ");
		int min = Integer.parseInt(reader.readLine());
			min = (0 <= min && min < 60) ? min : null;
		
			
		order(hour, min, "짜장면", -10);
		order(hour, min, "치킨", -18);
		order(hour, min, "피자", -25);
	
	} //main

	public static void order(int hour, int min, String food, int arrival) {
		
		Calendar time = Calendar.getInstance();
		
		time.set(Calendar.HOUR_OF_DAY, hour);
		time.set(Calendar.MINUTE, min);
		
		time.add(Calendar.MINUTE, arrival);
		System.out.printf("%s: %d시 %d분%n", food, time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE));
		

	}
	
	////TODO int로 해보기 (2022. 3. 16. 오전 10:52:52)
}

//		설계]
//		1. BufferedReader
//		2. 안내메시지 > "음식받기를 원하는 시각%n" > "시 : "
//		3. 값 입력받고 int hour 변수에 저장 > 2번 반복
//		4. Calendar time 변수 선언 > getInstance()
//		5. 변수.set(hour, min)
//		6. 변수.add(Calendar.MINUTE, -10)
//		7. 출력하기 > printf("짜장면: %d시 %d분%n", 변수.get(Calendar.Hour_ofday), 변수.get(Calendar.mininute))  
//		8. 5~7 2번반복