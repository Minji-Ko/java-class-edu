package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 주민 등록 번호 유효성 검사를 하시오.
//		- '-'의 입력 유무 상관없이 검사하시오.
//		-  95(생년)12(생월)20(생일)-1(성별)0215(출생지역)4(출생순서)7(계산)
//		- 성별 > 9,0 -> 1800년대생 / 1(남),2(여) -> 1990년대생 / 3,4 -> 2000년대생 / 5,6,7,8 -> 귀화 
//		- 각자리에 234567892345를 각각 곱해서 더하기 > 11로 나누기 > 11에서 나머지 빼기 > 일의 자리
//		- 마지막자리만 유효성검사하기
		
//		입력] 주민등록번호: 951220-1234567 
//		출력] 올바르지 않은 주민등록번호입니다.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("주민등록번호: ");
		String jumin = reader.readLine();
		
		char[] juminCopy = jumin.replace("-", "").toCharArray();
		
		
		int validationValue = 0;

			
		//유효성 확인 기준값 만들기
		for(int i=0; i<juminCopy.length - 1; i++) {
			validationValue += (juminCopy[i] - '0') * (i % 8 + 2);			 
		}
		
		validationValue = (11 - (validationValue % 11)) % 10;
		
		//유효성확인하기
		if(juminCopy[juminCopy.length - 1] - '0' == validationValue) {
			System.out.println("올바른 주민등록번호입니다.");
		} else {
			System.out.println("올바르지 않은 주민등록번호입니다.");
		}
	}
	
	
}

//		설계]
//		1. 주민등록번호 입력받기
//		2. replace "-", "" > char배열에 담기
//		3. 검사하기
//			- for문 > jumin.length - 1보다 작은수까지만!
//			- 각 배열의 문자코드값에서 '0'을 뺀후 
//			- 각각 곱해서(validationNum) 더하기 
//			- jumin[length-1] - '0' = sum > 올바름
//		4. 출력하기
