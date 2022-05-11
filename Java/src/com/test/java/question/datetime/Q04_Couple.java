package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q04_Couple {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 남녀 커플의 이름과 만난날을 입력받아 기념일을 출력하시오.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("남자 이름 : ");
		String man = reader.readLine(); 
		System.out.print("여자 이름 : ");
		String woman = reader.readLine(); 
		
		
		System.out.print("만날날(년) : ");
		int year = Integer.parseInt(reader.readLine());
		System.out.print("만날날(월) : ");
		int month = Integer.parseInt(reader.readLine()) - 1;  //Calendar.MONTH는 0부터!!
		System.out.print("만날날(일) : ");
		int date = Integer.parseInt(reader.readLine());
		System.out.println();
		
		System.out.printf("\'%s\'과(와) \'%s\'의 기념일%n", man, woman);
		anniversary(year, month, date, 100);	
		anniversary(year, month, date, 200);	
		anniversary(year, month, date, 300);	
		anniversary(year, month, date, 500);	
		anniversary(year, month, date, 1000);	
	}
	
	public static void anniversary(int year, int month, int date, int dday) {
		
		Calendar lovedate = Calendar.getInstance();
	
		lovedate.set(year, month, date);
		lovedate.add(Calendar.DATE, dday);
		
		System.out.printf("%4d일: %tF%n", dday, lovedate); //Calendar 변수도 잊지 말고 써야함!
	
	}
}

//		설계] 
//		main()
//		1. BufferedReader 
//		2. 이름 입력받기 안내메시지 > 입력받기 > String 변수에 저장 > 2번
//		3. 안내문구 출력 > "'name1'과(와) 'name2'의 기념일" 
//		4. 만난날 입력받기 안내메시지 > 입력받기 > Int에 형변환후 저장 > 3번
//		5. 메소드 호출 5번  anniversay(year, month, date, 100)

//		anniversary()
//		8  anniversay(int year, int month, int date, int dday) 메소드 선언 
//		5. Calendar firstday 현재시각 얻어오기
//		6. 날짜변경 > 변수.set(year, month, date)
//		7. firstday.add(Calendar.DATE, dday) 
//		8. printf("%d일: %tF%n", day)











//		