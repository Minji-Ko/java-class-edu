package com.test.java.question.overload;

public class Q03_Positive {

	public static void main(String[] args) {
		
//		요구사항] 인자로 받은 숫자들 중 양수의 갯수를 반환하는 메소드를 선언하시오.
//		- int positive(int)
//		- int positive(int, int)
//		- int positive(int, int, int)
//		- int positive(int, int, int, int)
//		- int positive(int, int, int, int, int)
		
		int count;
		count = positive(10);
		System.out.printf("양수 : %d개%n", count);
		count = positive(10, 20);
		System.out.printf("양수 : %d개%n", count);
		count = positive(10, 20, -30);
		System.out.printf("양수 : %d개%n", count);
		count = positive(10, 20, -30, 40);
		System.out.printf("양수 : %d개%n", count);
		count = positive(10, 20, -30, 40, 50);
		System.out.printf("양수 : %d개%n", count);
	}

	public static int positive(int n1) {
		int count = 0;
		count = (n1 > 0) ? ++count : count;  //count += (n1 > 0) ? 1 :0; 이렇게 쓰는 방법도 있음
		return count;
	}

	public static int positive(int n1, int n2) {
		int count = 0;
		count = (n1 > 0) ? ++count : count;
		count = (n2 > 0) ? ++count : count;
		return count;
	}

	public static int positive(int n1, int n2, int n3) {
		int count = 0;
		count = (n1 > 0) ? ++count : count;
		count = (n2 > 0) ? ++count : count;
		count = (n3 > 0) ? ++count : count;
		return count;
	}

	public static int positive(int n1, int n2, int n3, int n4) {
		int count = 0;
		count = (n1 > 0) ? ++count : count;
		count = (n2 > 0) ? ++count : count;
		count = (n3 > 0) ? ++count : count;
		count = (n4 > 0) ? ++count : count;
		return count;
	}

	public static int positive(int n1, int n2, int n3, int n4, int n5) {
		int count = 0;
		count = (n1 > 0) ? ++count : count;
		count = (n2 > 0) ? ++count : count;
		count = (n3 > 0) ? ++count : count;
		count = (n4 > 0) ? ++count : count;
		count = (n5 > 0) ? ++count : count;
		return count;
	}

}

//		설계]
//		1. positive 메소드 인자별로 5개 선언 
//			> public static int positive(int n) {} 
//			> count 변수 선언 및 초기화 int count = 0; 
//			> (n1 > 0) ? ++count : count;  
//			> return sum;
//		2. 메인메소드에 int count 변수 선언 > int count;
//		3. 호출된 값 count변수에 저장 > count = positive()
//		4. count 출력 > printf("양수 : %d개%n", count)