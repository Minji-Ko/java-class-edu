package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07_Subway {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 지하철 탑승 소요 시간을 구하시오. 지나가는 역의 개수, 환승역의 횟수, 시간대를 전달 받아 총 걸리는 시간을 반환하는 메소드를 선언하시오.
//		- int getTime(int station, int change, int time)
//		- 각 역간 소요 시간 : 2분 소요
//		- 환승 소요 시간 : N분 소요
//		- 시간대에 따라 환승 소요 시간이 다르다.
//			- 평상시: 3분
//			- 출근시: 4분
//			- 퇴근시: 5분
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("역의 개수 : ");
		String input1 = reader.readLine();
		int station = Integer.parseInt(input1);

		System.out.print("환승역의 횟수 : ");
		String input2 = reader.readLine();
		int change = Integer.parseInt(input2);
		
		System.out.print("시간대(1.평상시, 2.출근시, 3.퇴근시): ");
		String input3 = reader.readLine();
		int time = Integer.parseInt(input3);
		
		int totalTime = getTime(station, change, time);
		System.out.printf("총 소요 시간은 %d분입니다.\n", totalTime);
	
	}
	
	public static int getTime(int station, int change, int time) {
		
		int totalTime = (station * 2) + change * (time + 2);
		return totalTime;
	}
}

//		설계]
//		1. 역의 개수, 환승역의 횟수, 시간대 각각 입력받기 > Buffered.. > 안내 메시지 출력 > String input에 저장 > int로 형변환
//		2. getTime 메소드 선언 > int totalTime 변수에 (station * 2) + change *(time + 2) 저장 > return값은 totalTime
//		3. getTime 메소드로 호출 > return 값은 총 소요시간
//		4. in totalTime에 return값 저장
//		5. prinf 출력 > ("총 소요 시간은 %d분입니다.\n", totalTime)