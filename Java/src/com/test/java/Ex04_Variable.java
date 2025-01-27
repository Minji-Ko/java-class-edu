package com.test.java;

public class Ex04_Variable {

	public static void main(String[] args) {
		
//		- 성적 관리 프로그램
//		- 과목별 점수
//		- 국어 점수
		
//		1. 국어 점수 > 성질 분석 > 형태(정수) + 길이(0~100)
//		2. 1의 상황 > 자료형 중 하나를 선택 > byte 형
//		3. 2의 자료형 > 변수 생성
//		4. 변수 입출력

//		변수 생성하기
//		- 자료형 변수명;
		byte 국어점수;
		
//		변수 초기화
//		- 변수명 = 값;
		국어점수 = 100;
		
//		변수 사용하기
		System.out.println(국어점수); // 공간 출력(X), 공간을 찾아가서 그 안의 값을 가져와 출력
	
		
//		**변수 생성하기
//		영어점수
		byte eng;
		//byte eng;  //Duplicate local variable eng
		//short eng;
		//char eng;
		byte eng1; //The value of the local variable eng is not used
		
		
//		수학점수
		byte math$;
		
//		**변수명 생성 규칙 > 명명법
//		1. 영문자 사용 + 숫자 사용 + 특수문자(_) > 권장(필수)
//	    2. 숫자로 시작 불가능
//		3. 예약어 사용 불가능
//		4. 의미있게(******)
		
		byte eng2;
		//byte 3eng;  
		byte _3eng;
		
		//byte byte;
		
//		프로그램 통과(O), 가독성 실패(X)
		byte a;
		a = 90;
		System.out.println(a);
		
		byte kor;
		kor = 80;
		System.out.println(kor);
		
		byte korscore;
		byte kor_score;
		byte korScore;
		//byte ks;  알아보지 못할 약자(x)
		//byte kor score; 
		
//		프로그래밍 기술의 발전 방향!! > 코드의 재사용(감소)
//		프로그램 생성 > 프로그램 유지/보수
		
//		math1, math2, math3
		byte math1;
		byte math2;
		byte math3;
		
		byte math4, math5, math6; //생산성 높음, 유지보수성 높음
		
		byte math7; 	//변수 선언
		math7 = 100;	//변수 초기화

		byte math8 = 100;  //변수 선언 + 초기화

		byte math9 = 100, math10 = 90 , math11 = 80; 
		byte math12, math13 = 100, math14;
		

		System.out.println();
//		국어 점수 > 90점 > 화면 출력
		
//		의미를 알 수 있나? 없나?
		System.out.println(90); //의미없음
		
		byte kor1;		//변수 선언
		kor1 = 90;		//변수 초기화
		System.out.println(kor1); //의미있음 > 변수의 역할 중 하나(****)
		//kor1 출력 > 90
		
		kor1 = 80;	//변수값 수정 > 변수 치환 > 덮어쓰기
		System.out.println(kor1);
		//kor1 출력 > 80
		
//      *** 표현식은 동일한데(kor1) 값이 바뀌었다. > 변수

//      *** 표현식은 동일한데(90) 값이 안바뀌었다. > 상수 > 데이터(값) > 리터럴(Literal)
		System.out.println(90);
		System.out.println(90);

//		데이터 취급
//		1. 변수 > 의미부여!!!
//		2. 상수
		
		System.out.println(80);   //리터럴 > 의미 없음 + 값이 불변
		
		byte kor2 = 80;
		System.out.println(kor2); //변수 > 의미 있음 + 값이 바뀔 수 있음
		
//		final 변수(=상수)
//		- 수정이 불가능하다
//		- 한번 값을 초기화하면 더 이상 변경할 수 없는 변수
//		- *** 상수를 사용하고 싶은데 리터럴은 의미가 없어서, 의미있는 상수를 사용하기 위해서! 
		
		final byte kor3 = 70;
		//kor3 = 65;
		System.out.println(kor3);
		
		
//		자바는 (식별자의) 대소문자를 구분한다.
		
//		final 변수(=상수)는 대문자로 작성한다. (****) > 변수와 구분하기 위해서!!(가독성)
		final double PI = 3.14;
		System.out.println(PI * 20);
		
		//pi = 5.20;
		System.out.println(PI * 20);
		
		
		byte KOR;
		byte Kor;
		byte kOr;
		byte koR; 	
		
		
//		식별자 명명법 패턴
//		1. 헝가리언 표기법
//		2. 파스칼 표기법 
//		3. 캐멀 표기법 	 
//		4. 스네이크 표기법
//		5. 케밥 표기법
		
//		1. 헝가리언 표기법 
//		- 식별자를 만들 때 식별자의 접두어로 해당 자료형을 표시하는 방법
//		- 사용) 인터페이스명
//			- interface IHello {}
		
		//int age; 
		int intAge;
		int iage ;
		int i_age; //(****)
		
		
//		2. 파스칼 표기법
//		- 식별자 단어의 첫문자를 "대"문자로 표기 + 나머지 문자를 소문자로 표기
//		- 2개 이상의 단어로 만든 합성어 > 각 단어의 첫문자를 대문자로 표기
//		- 사용) 클래스명

		//int englishscore;
		class EnglishScore {}
		class English {}
		
		
//		3. 캐멀 표기법
//		- 식별자 단어의 첫문자를 "소"문자로 표기 + 나머지 문자를 소문자로 표기
//		- 2개 이상의 단어로 만든 합성어 > 각 단어의 첫문자를 대문자로 표기
//		- 사용) 변수명, 메소드명

		int englishScore;
		int english;
		
		
		int MathScore; // 파스칼 > x
		int mathScore; // 캐멀 > o
		
		
//		4. 스네이크 표기법
//		- 전부 소문자로 표기
//		- 합성어 > 각 단어를 '_'로 연결
//		- 사용) 정해지지 않음 > 마음대로..
		
		int english_score;
		
//		코딩 컨벤션
		
//		5. 케밥 표기법
//		- 전부 소문자로 표기
//		- 합성어 > 각 단어를 '-'로 연결 > minus 연산자로 인식
//		- 사용) 자바 불가능, 나중에 다른 과목에서 사용(HTML, CSS)
//		
		//int english-score; 
		
	}	
	
}

