package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02_Range {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 시작 숫자, 종료 숫자, 증감치를 입력받아 숫자를 순차적으로 출력하시오.
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("시작 숫자 : ");
		int start = Integer.parseInt(reader.readLine());
		System.out.print("종료 숫자 : ");
		int end = Integer.parseInt(reader.readLine());
		System.out.print("증감치 : ");
		int change = Integer.parseInt(reader.readLine());
	
		
		if (start <= end) {
			for(int i=start; i<=end; i=i+change) {
				System.out.println(i);
			}
		} else {
			for(int i=start; i >= end; i=i+change) {
				System.out.println(i);
			}
		}
	
	} //main
}

//		설계]
//		1. 입력받기 > int start, end, change에 저장
//		2. for문 생성 > 출력

//   	**for문 증감 방향에 따른 조건식!
