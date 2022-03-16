package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q03_Age {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 태어난 년도를 입력하면 나이를 출력하시오.
//		- 올해를 기준으로 나이를 계산하시오.
//		- 내년, 내후년에 실행해도 그때에 맞는 나이가 출력되야합니다.
//		- 우리나라 나이로 출력하시오.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("태어난 년도: ");
		int birth = Integer.parseInt(reader.readLine());
		
		Calendar now = Calendar.getInstance();
		
		int age = now.get(Calendar.YEAR) - birth + 1;
		System.out.printf("나이: %d세%n", age);
	}	//TODO 승연님코드랑 비교 (2022. 3. 16. 오후 12:03:55)
}

//		설계]
//		1. 태어난 년도 입력받기 > Buffered > 안내 메시지 > read.readLine() > int birth에 형변환하여 저장
//		2. 현재 시각 얻어오기 > now = Calendar.getInstance()
//		3. age변수 생성 및 저장 > now.get(Calendar.YEAR) - birth + 1
//		4. 출력하기