package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {

	public static void main(String[] args) throws Exception {
//		요구사항] 문장을 입력받아 역순으로 출력하시오.
//		- charAt / substring
		
//		입력] 문장 입력 : 가나다
//		출력] 역순 결과 : "다나가"
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문장 입력 : ");
		String statement = reader.readLine();
		
		
		
		System.out.print("역순 결과 : \"");
		
		for(int i=statement.length()-1; i>=0; i--) {
			System.out.print(statement.charAt(i));
//			System.out.print(statement.substring(i,i+1));
		}
		
		System.out.print("\"");
	}
}

//		설계]
//		1. 문장 입력받기
//		2. for문 > charAt으로 역순출력
		
