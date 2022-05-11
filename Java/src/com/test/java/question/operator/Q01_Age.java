package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01_Age {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 태어난 년도를 입력받아 나이를 출력하시오.
//		- 우리나라 나이로 출력하시오
//		생각하기]
//		- 숫자가 아닌 값을 입력하면?
//		- 올바른 년도가 아닌 값을 입력하면? 음수를 입력하면?
//		- 올해가 2022년이 아니라면?
				
				
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("태어난 년도 : ");
		String input = reader.readLine();
		
		int birth = Integer.parseInt(input);
		int now = 2022;
		int age  = now - birth + 1;
		
		System.out.printf((age >= 1 && age <= 150) ? "나이 : %d세%n" : "태어난 년도를 정확하게 입력해주세요.", age);
		
	}
}
