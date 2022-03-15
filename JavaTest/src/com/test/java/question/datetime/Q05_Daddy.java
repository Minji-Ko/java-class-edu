package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q05_Daddy {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 아빠와 딸의 생일을 입력받아 아빠가 딸보다 며칠을 더 살았는지 출력하시오.
		
		
		Calendar daddyBirth = birthday("아빠");
		Calendar daughterBirth = birthday("딸");
		
		
		//** 딸 생년월일 - 아빠 생년월일
		long duration = (daughterBirth.getTimeInMillis() - daddyBirth.getTimeInMillis()) / 1000 / 60 / 60 / 24;
		
		System.out.printf("아빠는 딸보다 총 %,d일을 더 살았습니다.", duration);
	}

	public static Calendar birthday(String person) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.printf("%s 생일(년) : ", person);
		int year = Integer.parseInt(reader.readLine());
		System.out.printf("%s 생일(월) : ", person);
		int month = Integer.parseInt(reader.readLine()) - 1;
		System.out.printf("%s 생일(일) : ", person);
		int date = Integer.parseInt(reader.readLine());
		
		Calendar birth = Calendar.getInstance();
		birth.set(year, month, date);
		return birth;
	}
}

// 		설계]
//		1. BufferedReader 
//		2. 안내메시지 > "아빠 생일(년) : "
//		3. 입력 받아서 int year, month, date로 형변환 > Exception처리 > 3번 > month는 -1
//		4. 캘린더 변수 선언 > daddyBirth
//		5. set(int, int, int) 
//		6. 입력 받아서 int year, month, date로 형변환 > Exception처리 > 3번 > month는 -1
//		7. 캘린더 변수 선언 > 딸의 daughterBirth
//		8. set(int, int, int) 
//		9. 아빠와 딸의 epoch구하기 > daddyBirth.getTimeInMillis()
//		10. - 연산해서 '일'로 변환 > duration에 저장 
//		11. 출력하기


