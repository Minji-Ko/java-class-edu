package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05_SumNum {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 아래와 같이 출력하시오.
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자 : ");
		int start = Integer.parseInt(reader.readLine());
		System.out.print("종료 숫자 : ");
		int end = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		
		for(int i=start; i<=end; i++) {
			sum += i;
			System.out.print(i);
			
			if(i==end) {
				System.out.printf(" = %d\n", sum);
				break;
			}
			
			System.out.print(" + ");
		}
		
	}
}

//		설계]
//		1. 입력받기 > int start, int end
//		2. 출력하기
//			2.1 int sum = 0;
//			2.2 for(int i=start; i<=end; i++)
//			2.3 sum += i;
//			2.4 print(i)
//			2.5 if(i==end) { printf("= %d",sum); break;}
//			2.6 print(" + ")
		