package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08_Apple {
	
	public static void main(String[] args) throws Exception {
		
//		요구사항] 사과 나무가 있다. 사과 나무 씨앗을 심을 날로부터 특정 시간이 흘렀을 때 사과 총 몇개가 열리는지 구하는 메소드를 선언하시오.
//		- int getApple(int sunny, int foggy)
//		- 사과 나무를 처음 심었을 때 나무의 길이: 0m
//		- 맑은 날 사과 나무의 성장률: 5㎝
//		- 흐린 날 사과 나무의 성잘률: 2㎝
//		- 사과 나무는 길이가 1m 넘는 시점부터 사과가 열린다.
//		- 1m 넘는 시점부터 10㎝ 자랄 때마다 사과가 1개씩 열린다.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("맑은 날 : ");
		String input1 = reader.readLine();
		int sunny = Integer.parseInt(input1);

		System.out.print("흐린 날 : ");
		String input2 = reader.readLine();
		int foggy = Integer.parseInt(input2);
		
		int apple = getApple(sunny, foggy);
		System.out.printf("사과가 총 %d개 열렸습니다.\n", apple);
	}
	
	public static int getApple(int sunny, int foggy) {
		
		int height = (sunny * 5) + (foggy * 2);
		return (height >= 100)? (height - 100)/10 : 0; 
	}
}

//		설계]
//		1. 맑은 날, 흐린 날 각각 입력받기 > Buffered.. > 안내메시지 출력 > String에 저장 > int sunny, int foggy로 형변환
//		2. getApple 메소드 생성 > int height 변수 생성 > (sunny * 5) + (foggy * 2) > return값으로는 (height >= 100)? : (height - 100)/10 : 0; 
//		3. sunny, foggy를 인자로 getApple 메소드 호출
//		4. int apple생성 후 getApple() return값 저장
//		5. 출력 > printf("사과가 총 %d개 열렸습니다.", apple)