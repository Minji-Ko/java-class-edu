package com.test.java.obj.inheritance;

import java.util.Calendar;

public class Ex45_final {

	public static void main(String[] args) {
		
		/*
			final 키워드
			- 한번 결정하면 바꿀 수 없다.
			
			1. 변수 적용(지역 변수 + 멤버 변수) ******
				- 초기화 이후에 값을 변경할 수 없다.
				- 상수
				- const int num = 10;
				
			2. 메소드 적용
				- 상속 시 재정의(Override)를 할 수 없다.
				
			3. 클래스 적용
				- 상속이 불가능하다.
		*/
		
		//지역 변수
		int a = 10;
		a = 20;
		
		//상수
		//- 상수는 되도록 선언과 동시에 초기화를 한다.(권장)
		final int b = 20;
		//b = 30; > The final local variable b cannot be assigned. It must be blank and not using a compound assignment
		
		//아래처럼 따로 초기화하는 방식은 비권장 > 변수처럼 보여서;;
		final int c;
		c = 30;
		//c = 40;
		
		//*** 상수명은 모두 대문자로 작성하다. (명명법)
		final double PI = 3.14;
		
		Calendar now = Calendar.getInstance();
		
		System.out.println(now.get(1)); //의미 없음

		int year = 1;
		System.out.println(now.get(year)); //의미 있음
		
		System.out.println(Calendar.YEAR); //1 -> 캘린더 상수
		//Calendar.YEAR = 2; > The final field Calendar.YEAR cannot be assigned
		
		
		User u1 = new User();
		System.out.println(u1.GENDER);
		
		User u2 = new User();
		System.out.println(u2.GENDER);
		
		User u3 = new User();
		System.out.println(u3.GENDER);
		
		System.out.println(User.NUM); 		//final static 상수
		System.out.println(Calendar.YEAR);	//final static 상수
		
		//Member m1 = new Member();
		//System.out.println(m1.a); 	//10
		//System.out.println(Member.b);	//20
		
		System.out.println(Member.b);	//0
		
		Member.b += 5;
		System.out.println(Member.b);	//25
		
		Member m2 = new Member();
		System.out.println(Member.b);
		
		
	}//main
	
}//Ex45


class User {
	
	//객체 변수의 역할(*****) > 객체 각각이 자신의 저장 공간 > 자신만의 데이터를 저장하기 위해 > 객체의 상태(State) > 객체를 구분한다.
	public int age;				 //멤버 변수
	final public int GENDER = 2; //멤버 상수 > 객체 멤버 상수를 잘 안만든다. > static 유사
	
	//final, public, static은 순서가 정해져 있지 않음
	final public static int NUM = 3; //static 변수 > 상수 > static 상수
	
	
	public User() {
		this.age = 0;
	}

}

class Member {
	
	public int a; 			//객체 멤버
	public static int b;	//정적 멤버(공용 멤버)
	
	//생성자 > 객체 생성자 > 객체 멤버만을 초기화하는 역할
	public Member() {
		this.a = 10;
		//Member.b = 20;  //> 정적 변수를 생성자에서 초기화를 하면 안된다!!! 
	}
	
	//생성자 > 정적 생성자 > 정적 멤버만을 초기화하는 역할
	static {
		//this.a = 10;  //> Cannot use this in a static context
		Member.b = 20;
	}
}


class FinalParent {
	//부모 클래스 설계시..
	//- 상속받는 자식이 이 메소드만큼은 고치지 않았으면... 하는 경우가 있다.
	//- 프로그램의 안정성 문제
	final public void test() {
		System.out.println("메소드");
	}
	
}

class FinalChild extends FinalParent {

//	@Override // > Cannot override the final method from FinalParent
//	public void test() {
//		System.out.println("재정의");
//	}
}


//부모 클래스를 생성할 당시.. 먼 훗날 자식 클래스.. > 포기 > 자식을 안만들래..
//- 터미널 클래스
//- Leaf Node
//결론 > 궁극적으로는 구별해가면서 final을 붙임 > 지금 사용하기엔 경험이 너무 부족
final class FinalUser {
	
}

//The type FinalUserAdmin cannot subclass the final class FinalUser
//class FinalUserAdmin extends FinalUser {
//	//무슨 짓?  > 예측해야 함
//}













