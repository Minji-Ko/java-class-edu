package com.test.java.obj.stereo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex55_Exception {

	//TODO 왜 public? 
	//String[] args? arguments 전달인자, main(String[] args)이 자바에서 정의된 엔트리 포인트(시작점)
	public static void main(String[] args) {  
		
		/*
		  	예외, Exception
		 	- 컴파일 발견 X > 실행 중 발견 O
		 	- 런타임 오류
		 	- 개발자 미리 예측 O, X
		 	
		 	카톡
		 	- 메시지 전송 기능
		 	- 네트워크 연결문제로 인한 오류 > 환경의 문제
		 	- 예외 처리 > 개발자의 잘못으로 발생하는 게 아님 > 울며 겨자먹기로 하는 일 중 하나...
		 	
		 	예외 처리, Exception Handling  > 둘 다 사용함
		 	1. 전통적인 방식
		 		- 제어문 사용(조건문)
		 		
		 	2. 전용 처리 방식(권유)
		 		- try catch (fianlly)문 사용
		 */
		
		
		//static을 지우면 에러 > 왜? 
		//this.m1(); //같은 클래스 this > 에러 > main메소드는 static!
		//Ex55_Exception.m1();  //원형
		
		//static을 지우려면?
		//Ex55_Exception ex = new Ex55_Exception();
		//ex.m1();
		
		//m1(); 	
		//m2();
		//m3();
		
		try {
			m4(); //main(String[] args) throws Exception > 예외를 아무도 책임을 안짐 > 뻑이 남 > 예외처리가 아님 *** > 예외 방치
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		m5();
		
	}//main


	private static void m5() {
		
		//예외 던지기
		
		// 요구사항] 숫자 입력 > 처리
		// 조건] 반드시 짝수만 입력 > 홀수 > 에러
		
		int num = 9;
		
		//Case 1. 전통적인 방식
		if(num % 2 == 0) {
			System.out.println("업무 코드..");
		} else {
			System.out.println("예외처리");
		}
		
		//Case 2. try catch > 회사에서 정책적으로 try catch를 쓰기로 했다면? 
		try {

			if(num % 2 == 1) {
				//throws(x) throw(o) > 예외 미루기 아님
				throw new Exception("홀수를 입력했습니다.");  //강제 에러 발생!!! > 반드시 조건부로 해야 함!!!
			}
			System.out.println("업무 코드..");			
		} catch (Exception e) {
			System.out.println("예외처리");
			System.out.println(e.getMessage());
		}
	
	}

	private static void m4() throws Exception { //호출한 곳으로 예외 미루기
		
		//예외 미루기
		//- 해당 영역에서 예외 처리를 할만한 상황이 안되면 다른 곳으로 예외 처리의 책임을 떠 넘길 수 있다.
		
		//- throws Exception
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//Unhandled exception type IOException
		//String input = reader.readLine(); //누군가는 try catch를 처리해야함 > m4() throws Exception
	}


	private static void m3() {
		
		//Exception 객체의 역할
		
		try {
			
			int num = 10;
			System.out.println(100 / num); //ArithmeticException
			
			//에러가 나는 순간
			//throw new ArithmeticException();
			
			int[] nums = { 10, 20, 30 };
			System.out.println(nums[0]);  //ArrayIndexOutOfBoundsException
			
			//throw new ArrayIndexOutOfBoundsException();
					
			Parent p = new Parent();
			Child c;
			//c = (Child)p; 	//ClassCastException
			
			Parent p2 = null;
			System.out.println(p2.toString());
			
//		} catch (Exception e) {
//			System.out.println("예외 처리");
//			System.out.println(e.getMessage());
//		}
			
		} catch (ArithmeticException e) { //ArithmeticException e = new ArithmeticException();
			
			System.out.println("0으로 나누기");
		
		} catch (ArrayIndexOutOfBoundsException e) {	
		
			System.out.println("배열 첨자 오류");
		
		} catch (ClassCastException e) {	
		
			System.out.println("형변환 오류");
		
		} catch (Exception e) {	 //Exception > 모든 OOOException의 부모클래스 > 맨 마지막에 필수(***)
			
			System.out.println("예외 처리");
		
		}
		
	}


	private static void m2() {
		
		//Exception 객체의 역할
		int num = 0;
		try {
			System.out.println(100 / num);
		} catch(Exception e) {
			System.out.println("0으로 나누기");
		}
		
		int[] nums = { 10, 20, 30 };
		try {
		System.out.println(nums[5]);
		} catch(Exception e) {
			System.out.println("배열 첨자 오류");
		}
		
		
		Parent p = new Parent();
		Child c;

		try {
			c = (Child)p;
		} catch(Exception e) {
			System.out.println("형변환 오류");
		}
		
		//너무 잦은 try catch문 > 가독성이 떨어짐
	}


	//메소드 자동 생성 > 생각?
	//1. private > 안정성
	//2. static
	//3. void
	//4. ()
	private static void m1() {
		
		//요구사항] 숫자를 입력받아 연산을 하시오.
		
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//int num = Integer.parseInt(reader.readLine());
		
		Scanner scan = new Scanner(System.in); //예외처리 안해도 됨
		
		System.out.print("숫자: ");
		int num = scan.nextInt();
		
		//전통적인 방식
		if (num != 0) {
			
			//비즈니스 코드(= 업무 코드) > 주목적!!
			System.out.printf("100 / %d =  %d\n", num, 100 / num);
	
		} else {
		
			//예외 처리 코드
			System.out.println("0을 입력하면 안됩니다.");
		}
		
		
		//비권장 > 가독성이 낮아짐
		if (num == 0) {
			System.out.println("0을 입력하면 안됩니다.");			
		} else {
			System.out.printf("100 / %d =  %d\n", num, 100 / num);
		}
		
		
		/*
			if (조건) {
				참 블럭 > 긍정적
			} else {
				거짓 블럭 > 부정적
			}
		*/
		
		
		// try문
		//- try : 비즈니스 코드 작성
		//- catch : 예외 처리 코드 작성
		
		//조건이 없다?
		//1. 일단 try내부의 코드를 실행한다 > 업무 코드라서..
		//	- 아무 문제 없음 > 빠져 나감 > catch 실행 안함
		//	- 에러 발생!! > 남아있는 업무 코드의 실행을 중단 > 즉시, catch로 이동 > catch 실행
		try {
			System.out.printf("100 / %d =  %d\n", num, 100 / num);	
		} catch (Exception e) {
			//Exception e
			//- 예외 객체
			//- 예외가 발생한 상황에 대한 정보를 알려준다.
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			
			System.out.println("0을 입력하면 안됩니다.");						
		}

		
		//if문 vs try문
		//- if문 : 사전에 미리 검사를 해서 사고가 안나게 처리..
		//- try문 : 일단 실행 > 감시!!! > 사고가 터지면 그때 처리..  
		//	- 사고가 터질지 예측하지 못해도 커버할 수 있음
		//	- 너무 광범위하게 try catch문을 쓰면 무거워짐
		//	- try의 영역 > 예외가 발생할 것 같다고 예측 가능한 최소한의 영역에만 적용 
		
		
		
	}
	
}//Ex55

class Parent {
	
}
class Child extends Parent {
	
}

















