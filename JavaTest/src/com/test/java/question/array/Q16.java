package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q16 {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 성적을 입력받아 아래와 같이 출력하시오.
//		- String[][] score = new String[10][3];
		
//		입력]
//		- 국어 점수: 80
//		- 영어 점수: 50
//		- 수학 점수: 70
	 	
//		■		
//		■		■
//		■		■
//		■	■	■
//		■	■	■
//		■	■	■
//		■	■	■
//		■	■	■
//		국어	영어	수학

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int[] grade = new int[3];
		
		System.out.print("국어 점수 : ");
		grade[0] = Integer.parseInt(reader.readLine());
		System.out.print("영어 점수 : ");
		grade[1] = Integer.parseInt(reader.readLine());
		System.out.print("수학 점수 : ");
		grade[2] = Integer.parseInt(reader.readLine());
		
		
		String[][] score = new String[10][3];
		
		//데이터 입력 > 문제의 요구사항에 따라 수정
		for(int i=0; i<10; i++) { 
			for(int j=0; j<3; j++) {
				for(int k=9; k>9-grade[j]/10; k--) {
					score[k][j] = "■";
				}
				for(int k=9-grade[j]/10; k>=0; k--) {
					score[k][j] = " ";
				}
			}
		}
		

		
		//데이터 출력 > 절대 수정 금지!!!
		for(int i=0; i<10; i++) { //문제풀 때 상수쓰기
			for(int j=0; j<3; j++) {
				System.out.printf("%5s", score[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("   -------------");
		System.out.println("   국어  영어  수학");
	}
}
 

//		설계]
//		1. 데이터 입력받기 > int 변환
//		2. for문 
//			- 국어[i][0] -> 0, 1 공백출력
//			- 영어[i][1] -> 0, 1, 2, 3, 4
//			- 수학[i][2]
