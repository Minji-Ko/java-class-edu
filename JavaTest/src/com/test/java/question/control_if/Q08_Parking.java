package com.test.java.question.control_if;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08_Parking { 

	public static void main(String[] args) throws Exception {
		
//		요구사항] 주차 요금을 계산하시오.
//		- 무료 주차 : 30분
//		- 초과 10분당 : 2,000원
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.println("[들어온 시간]");
		System.out.print("시 : ");
		int entryHour = Integer.parseInt(reader.readLine());
		System.out.print("분 : ");
		int entryMin = Integer.parseInt(reader.readLine());
		
		System.out.println("[나간 시간]");
		System.out.print("시 : ");
		int exitHour = Integer.parseInt(reader.readLine());
		System.out.print("분 : ");
		int exitMin = Integer.parseInt(reader.readLine());
	
		
		int parkingMin = (exitHour - entryHour) * 60 + (exitMin - entryMin);
		
		if (parkingMin >= 0) {
			
			if (parkingMin > 30) {
				int fee = (int)((parkingMin - 30)/10.0 + 0.9) * 2000;
				System.out.printf("주차 요금은 %,d원입니다.", fee);
			
			} else {
				System.out.print("주차 요금은 0원입니다.");
			}
			
		} else {
			System.out.println("시간을 정확히 입력해주세요.");
		}
			
		
	}
}

//		설계] 
//		1. 입력받기
//			1.1 Buffered
//			1.2 안내메시지 > [들어온 시간] > 시 : 
//			1.3 int entryHour, exitHour...
//			1.4 들어온 시간, 나간 시간 모두 int 변수에 형변환후 저장
//		2. 주차 요금 계산해서 출력
//			2.1 int parkingMin 선언후 아래 식 저장
//			2.2 (exitH - entryH) * 60 + (exitM - entryM)
//			2.3 if문 출력	
//				- if(,parkingMin 30분초과) {((초과시간/10)+1) * 2000}
//				- else {요금 0}
