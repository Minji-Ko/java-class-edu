package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03_SumRange {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 숫자 1개를 입력받아 1부터 입력한 숫자까지의 합을 출력하시오.	}
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("숫자 : ");
		int num = Integer.parseInt(reader.readLine());
		
		int sum = 0;
	
		if(num >= 1) {
			for(int i=1; i<=num; i++) {
				sum += i;
			}
		} else {
			System.out.println("1이상의 정수를 입력해주세요.");
		}
		
		System.out.printf("1 ~ %d = %d%n", num, sum);
	
	}
}

//		설계]
//		1. 입력받기 > int num에 저장
//		2. sum 변수 선언
//		3. for문 
//			3.1 유효성 검사? 1이상의 수
//			3.2 for(i=0; i<=num; i++)
//			3.3 sum에 누적
//		4. 출력
			