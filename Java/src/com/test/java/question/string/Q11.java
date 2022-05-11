package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11 {

	public static void main(String[] args) throws Exception {

//		요구사항] 입력받은 문장에서 숫자를 찾아 그 합을 구하시오.
// 		- 모든 숫자는 한자리 숫자로 처리한다.
//		
//		입력] 입력: 국어 점수는 95점입니다. 
//		출력] 문장에 존재하는 모든 숫자의 합은 14입니다.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력: ");
		char[] statement = reader.readLine().toCharArray();
		
		
		int sum = 0;
		
		for(int i=0; i<statement.length; i++) {
			if('0' <=statement[i] && statement[i] <= '9') {
				sum += statement[i] - '0';
			}
		}
		
		
		System.out.printf("문장에 존재하는 모든 숫자의 합은 %d입니다.", sum);
	}
}

//		설계]
//		1. 입력받기 > char[]에 저장
//		2. for > char[i]가 숫자면 int변환후 sum에 누적