package com.test.java.question.control_if;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02_Grade {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 학생의 국어 점수를 입력받아 성적을 출력하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("점수 : ");
		int kor = Integer.parseInt(reader.readLine());
		
		if (0 <= kor && kor <= 100) {
			
			if (kor >= 90) {
				System.out.printf("입력한 %d점은 성적 A입니다.\n", kor);
				
			} else if (kor >= 80) {
				System.out.printf("입력한 %d점은 성적 B입니다.\n", kor);
				
			} else if (kor >= 70) {
				System.out.printf("입력한 %d점은 성적 C입니다.\n", kor);
				
			} else if (kor >= 60) {
				System.out.printf("입력한 %d점은 성적 D입니다.\n", kor);
				
			} else {
				System.out.printf("입력한 %d점은 성적 F입니다.\n", kor);
			}
			
		} else {
			System.out.println("점수가 올바르지 않습니다. 0~100사이의 값을 입력하시오.");
		}
		
	}
}

//		설계]
//		1. 학생의 국어 점수를 입력
//			1.1 BufferedReader
//			1.2 라벨
//			1.3 int kor 변수에 형변환하여 저장
// 		2. 성적 구분 > 출력
// 			2.1 유효성 검사if > 0~100점
// 			2.2 성적처리 if > else if 3개
// 			2.3 성적처리 if 출력 "입력한 %d점은 성적 B입니다."
// 			2.4 유효성 검사 출력 "점수가 올바르지 않습니다. 0~100사이의 값을 입력하시오."