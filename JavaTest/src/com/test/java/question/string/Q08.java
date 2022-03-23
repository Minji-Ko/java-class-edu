package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08 {

	public static void main(String[] args) throws Exception {

//		요구사항] 영단어를 입력받아 분리하시오.
//		- 쪼개서 배열에 넣기
//		- 합성어를 입력한다.
//		- 합성어는 파스칼 표기법으로 입력한다.
//		- 출력은 각 단어를 공백으로 구분한다.
		
//		입력] 단어: StudentName 
//		출력] 결과: Student Name
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("단어: ");
		char[] word = reader.readLine().toCharArray();
		

		System.out.print("결과:");
		
		//출력하기 
		for(int i=0; i<word.length; i++) {
			
			if('A' <= word[i] && word[i] <= 'Z') {
				System.out.print(" ");
			}
			System.out.print(word[i]);	
		}
	
	}
}
//		설계]
//		1. 입력받기
//		2. toCharArray
//		3. 'A'~'Z'까지면 앞에 공백 출력