package com.test.java.question.iteration;

public class Q20_PrimeNumber {

	public static void main(String[] args) {
		
//		요구사항] 2부터 100사이의 소수를 구하시오.
//		- 소수: 1과 자기자신으로밖에 나눠지지 않는 수
	
		int startNum = 2;
		int endNum = 100;
		
		
		for(int i=startNum; i<=endNum; i++) {
			
			//시작 숫자가 2일 때, 2는 그냥 출력
			if (i == 2) {
				System.out.print("2, ");
				continue;
			}
			
			//소수 출력
			for(int j=2; j<=i-1; j++) {
				
				// 소수 아니면 다음 숫자 검토
				if(i % j == 0){
					break;
				}
				
				// 소수면 마지막에 출력
				if (j == i-1) {
					System.out.printf("%d, ", i);
				}
			}	
		}
		
		System.out.print("\b\b ");
	
		
	} //main
}
	

//		설계]
//		1. for문 2~100
//		2. 소수 구하기 
//			- 2 
//			- 3 > 2로 안나눠짐
//			- 5 > 234로 안나눠짐
//		3. 출력 