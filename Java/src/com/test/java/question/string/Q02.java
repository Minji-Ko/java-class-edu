package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {

	public static void main(String[] args) throws Exception {
	
//		요구사항] 이메일 주소를 입력받아 아이디와 도메인을 각각 추출하시오.
//		- split / indexOf + substring
		
//		입력]	이메일: hong@gmail.com
//		출력]	아이디: hong 
//			도메인: gmail.com
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이메일: ");
		String email = reader.readLine();
		
		String[] idDomain = email.split("@");
		
		System.out.printf("아이디: %s\n", idDomain[0]);
		System.out.printf("도메인: %s\n", idDomain[1]);

		
//		int index = email.indexOf("@");
//		String id = email.substring(0, index);
//		String domain = email.substring(index+1);
//		
//		System.out.printf("아이디: %s\n", id);
//		System.out.printf("도메인: %s\n", domain);
		
	}
}

//		설계]
//		1. 이메일 주소 입력받기
//		2. split(@) -> 배열에 저장
//		3. 출력