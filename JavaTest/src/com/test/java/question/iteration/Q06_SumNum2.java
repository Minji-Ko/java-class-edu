package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06_SumNum2 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자 : ");
		int startNum = Integer.parseInt(reader.readLine());
		System.out.print("종료 숫자 : ");
		int endNum = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		int order = 1;
		
		for (int i = startNum; i <= endNum; i++) {
			
			//첫번째("i") 또는 홀수번째("+ i") 또는 짝수번쨰("-i") 출력
			if (order % 2 != 0) { // i가 홀수번째일 떄,
				sum += i;
				if (i == startNum) { //첫번째일때
					System.out.printf("%d", i);
				} else {
					System.out.printf(" + %d", i);
				}

			} else {// i가 짝수번째일 때,
				sum -= i;
				System.out.printf(" - %d", i);
			}
						
			order++;
		}
		
		//마지막 "= sum" 출력하기
		System.out.printf(" = %d", sum);

		
		
		
		
//		for(int i=starNum; i<=endNum; i++) {
//			
//			if(order % 2 != 0) { //홀수
//				sum += i;
//				System.out.print(i);
//				
//				if(i==endNum) {
//					System.out.printf(" = %d\n", sum);
//					break;
//				}
//				
//				System.out.print(" - ");
//			} else { 
//			
//				sum += -i;
//				System.out.print(i);
//				
//				if(i==endNum) {
//					System.out.printf(" = %d\n", sum);
//					break;
//				}
//				
//				System.out.print(" + ");
//			}
//			
//			order++;
//			
//		}
	}
}

//		설계]
//		2. 출력하기
//			- 부호바꾸기 > -
//			- if(i % 2 != 0) {-출력}else {+}
