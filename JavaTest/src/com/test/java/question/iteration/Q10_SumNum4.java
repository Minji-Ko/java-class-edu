package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10_SumNum4 {

	public static void main(String[] args) throws Exception {

		// 요구사항] 숫자를 N개 입력받아 아래와 같이 출력하시오.
		// - 출력: 12 + 28 - 39 - 15 + 38 + 24 + 78 = 126
		// - 누적값이 100을 넘어가는 순간 루프를 종료하시오.
		// - 짝수는 더하고 홀수는 빼시오.

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;
		String print = ""; // *****

		while (sum < 100) {

			System.out.print("숫자 : ");
			int num = Integer.parseInt(reader.readLine());


			if (num % 2 == 0) {
				sum += num;
			} else {
				sum -= num;
				print += "\b\b- ";
			}

			print += String.format("%d + ", num);

		}
		print += String.format("\b\b= %d\n", sum);
		
		System.out.println(print);

	}
}

// 설계]
// 1. Buffered
// 2. int sum = 0;
// 3. int loop = true;
//
// 4. 반복문 만들기 > while()
// 4.1 숫자 입력받기 > int num에 저장
// 4.2 짝수인지 홀수인지 판단 > if
// - 짝수 > sum에 더하기
// - 홀수 > print(\b\b-)> 부호 바꿔서 sum에 더하기
// 4.3 출력하기
// - print(num + )
// 5. 반복문 끝내기
// 5.1 if(sum > 100) {break;}
// 5.2 print(\b\b = num) > break전에
//

