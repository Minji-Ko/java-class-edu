package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {

	public static void main(String[] args) throws Exception {

//		요구사항] 숫자를 입력받아 3자리마다 , 를 붙이시오.
//		- %,d 사용 금지
		
//		입력] 1234
//		출력] 1,234
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
		System.out.print("숫자: ");
		String num = reader.readLine();
		
		
		int firstComma = (num.length() % 3 != 0) ? num.length() % 3 : 3;
	
		System.out.print("결과: " + num.substring(0, firstComma) + ",");
	
		
		for(int i=firstComma; i<num.length()-2; i+=3) {
			System.out.print(num.substring(i, i+3) + ",");
		}
		System.out.print("\b ");

	
	}
}

//		설계]
//		1. 배열로 만들어서 저장 > toCharArray
//		2. 뒤에서 부터 출력 
//			2.1 for문 변수 2개, 하나는 index, 하나는 count
//			2.2 %3 ==0인부분에서 ,붙여서 출력
