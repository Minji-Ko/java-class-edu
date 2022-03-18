package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02_AlignName {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 학생의 이름을 N개 입력받아 아래와 같이 출력하시오.
//		- 이름을 오름차순 정렬하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("학생 수 : ");
		String[] students = new String[Integer.parseInt(reader.readLine())];
		
		//학생명 입력받기
		for(int i=0; i<students.length; i++) {
			System.out.print("학생명 : ");
			students[i] = reader.readLine();
		}
		
		//버블 정렬
		for(int i=0; i<students.length-1; i++) {
			for(int j=0; j<students.length-1-i; j++) {
				//문자열 한글자씩 비교하고 바꾸기
				for(int k=0; k<3; k++) {
					if(students[j].charAt(k) > students[j+1].charAt(k)) {
						
						String temp = students[j];
						students[j] = students[j+1];
						students[j+1] = temp;
						break;
						
					} else if(students[j].charAt(k) < students[j+1].charAt(k)) {
						break;
					}  //****else if문도 빼먹으면 안됨!!
				}
				
			}
		}
		
		//출력하기
		System.out.printf("입력한 학생은 총 %d명입니다.\n", students.length);
		
		for(int i=0; i<students.length; i++) {
			System.out.printf("%d. %s\n",  i+1, students[i]);
		}
		
	}
}

//		설계]
//		1. 학생수 입력받기 
//		2. 배열 생성 String[] students = new String[Inter..(reader..)];
//		3. for문 작성 > 배열 길이 만큼
//			3.1 학생명 입력받기
//			3.2 배열에 저장하기 students[i] = reader.readLine();
			//TODO 입력받기와 오름차순 정렬 한번에 (2022. 3. 18. 오후 6:00:10)
//		4. for문 작성 > 오름차순 정렬
//			4.1 한글자씩 비교 
//		5. for문 작성 > 출력하기
//			- "입력한 학생은 총 %d명입니다.\n", arrays.length
//			- "%d. %s\n",  i-1, students[i]