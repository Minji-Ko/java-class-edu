package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05_Bicycle {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 자전거가 있다. 자전거의 바퀴는 지름(직경)이 26인치이다. 사용자가 페달을 밟은 횟수를 입력하면 자전거가 총 몇 m를 달렸는지 출력하시오.
//		- 기어비 1:1 -> 페달 1회전 == 자전거 바퀴 1회전
//		- 모든 출력 숫자는 천단위 표기하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.printf("사용자가 페달을 밟은 횟수 : ");
		String input = reader.readLine();
		int pedal = Integer.parseInt(input);
		
		final double PI = 3.141592;
		final double INCH_TO_M = 0.0254;
		
		double distance = (26 * PI) * pedal * INCH_TO_M;   //기어비 1:1
		System.out.printf("사용자가 총 %,d회 페달을 밟아 자전거가 총 %,.3fm를 달렸습니다.", pedal, distance);
		
		
//		double distance = (26 * PI) * (pedal * 0.5) * INCH_TO_M;   //기어비 2:1
//		System.out.printf("사용자가 총 %,d회 페달을 밟아 자전거가 총 %,.3fm를 달렸습니다.", pedal, distance);		
		
	}
}
