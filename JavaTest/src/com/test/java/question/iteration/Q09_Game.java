package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09_Game {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 컴퓨터가 1~10 사이의 숫자 1개를 생각하면 사용자가 맞추는 프로그램을 구현하시오.
//		- 시도 횟수가 10회가 넘어가면 프로그램을 강제로 종료하시오.
		
		int num = (int)(Math.random() * 10) + 1;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 0;
		
		for(int i=1; i<=10; i++) {
			System.out.print("숫자 : ");
			int input = Integer.parseInt(reader.readLine());
			
			if (input == num) {
				System.out.println("맞았습니다.");
				System.out.println();
				count = i;
				break;
			} else {
				System.out.println("틀렸습니다.");
				System.out.println();
			}
		}
		
		System.out.printf("컴퓨터가 생각한 숫자는 %d입니다.\n"
						+ "정답을 맞추는데 시도한 횟수는 %d회입니다\n"
						, num
						, count);
		System.out.println();
		
		System.out.println("프로그램을 종료합니다.");
	}
}

//		설계]
//		1. 숫자 1개 정하기
//			- int num = (int)(Math.random() * 10) + 1;
//		2. 사용자가 입력하기
//			- for(int i=1; i<=10; i++)
//			- 사용자에게 숫자받기 > int자료형으로
//		3. 사용자에게 답변 출력하기
//			- if (input == num) {"맞았습니다."출력; count=i; break;} else {}
//		4. 시도한 횟수 출력하기 > i회
//			- "컴퓨터가 생각한 숫자는 %d입니다.\n정답을 맞추는데 시도한 횟수는 %d회입니다.", num, i
//			- syso
//			- "프로그램을 종료합니다."