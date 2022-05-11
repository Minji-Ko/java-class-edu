package com.test.java.obj.stereo;

public class Ex48_interface {

	public static void main(String[] args) {
		
		/*
			<<Stereo Type>>		
			- 추상적인 자료형
			- 인터페이스, 추상클래스 > 클래스의 일종
			
		
		*/
		
		//둘다 마우스 > 같은 범주 객체 > 기대치 > 비슷할거라고, 똑같을 거라고 기대
		
		G304 m1 = new G304();
		m1.click();
		m1.click();
		m1.click();
		
		//새 마우스
		G102 m2 = new G102();
//		m2.down();
//		m2.down();
//		m2.down();
		m2.click();
		m2.click();
		m2.click(); //사용자를 위한 기술
		
		
		
		//1. 인터페이스는 자료형이다.			> 데이터를 만드는 규칙
		//int n;
		//Mouse m1;
		//2. 인터페이스는 객체를 만들 수 없다. 	> 데이터를 못만든다. > 추상 멤버(추상 메소드)를 가지고 있기 때문에 실체화(객체 생성) 불가
		//Mouse m1 =  new Mouse();
		
		//m1.test(); //이것때문에 객체를 만들 수가 없다.(*****)
		
		
	} //main
} //Ex48

//서로 비슷한 부류의 객체들의 사용법을 물리적으로 통일시키는 방법 > 인터페이스
//인터페이스 == 제품의 규격 역할
//인터페이스 -> ex) 건전지 사이즈, 콘센트 규격
//인터페이스 선언 > 클래스의 일종
interface Mouse {
	
	//인터페이스 멤버 선언
	//- 추상 메소드를 멤버로 가진다. (*****) > 인터페이스의 이유
	//- 멤버 변수를 가질 수 없다.
	//- 멤버 메소드는 가질 수 있다.
	
	//public String name; 변수 선언 불가능 //TODO 초기화하면 왜 되는거지..? (2022. 3. 29. 오후 12:15:01)
	
	//추상 메소드 선언(인터페이스 멤버)
	//Abstract methods do not specify a body
	void test(); //public
	
	void click();
	
}


//클래스 선언
class G304 implements Mouse {
	private String type;
	private String color;
	private int dpi;
	
	@Override
	public void click() {
		
	}

	//*** 인터페이스는 자식 클래스에 강제로(***) 어떤 메소드를 만들도록 한다.
	@Override
	//void test(); //일반클래스는 추상메소드를 가질 수 없음(***)
	public void test() {
		
	}
}

class G102 implements Mouse {
	private String color;
	private int price;
	private int buttons;
	
	public void click() {
		
	}
	
	@Override
	public void test() {
		
	}
}



class AAA {
	private BBB b;
	private int num;
	private CCC[] list = new CCC[5];
}

class BBB {
	
}

class CCC {
	
}

class DDD{
	public void test() {
		EEE e = new EEE();
	}
}

class EEE {
	
}