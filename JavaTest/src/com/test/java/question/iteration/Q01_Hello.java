package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01_Hello {

	public static void main(String[] args) throws Exception {
		
//	요구사항] 사용자의 이름과 인사할 횟수를 입력 받아 출력하시오.

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("이름 : ");
		String name = reader.readLine();
		
		System.out.print("횟수 : ");
		int count = Integer.parseInt(reader.readLine());
		
	
		for (int i=0; i<count; i++) {
			System.out.printf("%s님 안녕하세요~\n", name);
		}
	
			
	}

}

//	설계] 
//	1.이름과 횟수입력받기 
//		1.1 buffered 
//		1.2 라벨	
//		1.3 변수에 저장 > String name, int num
//	2. for문 만들기
//		2.1 for(int i=0; i<num; i++) {}
//		2.2 출력하기