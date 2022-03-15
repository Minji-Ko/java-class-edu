package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06_Grade {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 국어, 영어, 수학 점수를 전달하면 '합격' 혹은 '불합격'이라는 단어를 반환하는 메소드를 선언하시오.
//		- String test(int kor, int eng, int math)
//		- 평균 점수 60점 이상은 '합격'이다.
//		- 평균 점수 60점 미만은 '불합격'이다.
//		- 과락: 한 과목 이상 40점 미만이면 불합격이다.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("국어 : ");
		String input1 = reader.readLine();
		int kor = Integer.parseInt(input1);

		System.out.print("영어 : ");
		String input2 = reader.readLine();
		int eng = Integer.parseInt(input2);
		
		System.out.print("수학 : ");
		String input3 = reader.readLine();
		int math = Integer.parseInt(input3);
		
		String result = test(kor, eng, math);
		System.out.println(result);
//		System.out.println(test(kor, eng, math)); 
		
	}
	
	public static String test(int kor, int eng, int math) {
		
		int avg = (kor + eng + math) / 3;
		return (avg >= 60 && kor >= 40 && eng >= 40 && math >= 40) ? "합격입니다." : "불합격입니다.";
	
	}
}

//		설계]
//		1. 국어, 영어, 수학 점수 입력받기 > BufferedReader > 안내메시지 출력 > String 값에 저장 > 형변환
//		2. String test 메소드 선언하기 
//		3. int avg 변수 선언 및 초기화 > (kor + eng + math) / 3
//		4. test메소드의 return 값 > (avg >= 60 && kor >= 40 && .. && ..) ? "합격" : "불합격" 
//		5. return값 출력