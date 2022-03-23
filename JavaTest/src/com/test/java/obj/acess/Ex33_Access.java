package com.test.java.obj.acess;

public class Ex33_Access {

	//Alt + Tap > 프로그램 전환
	//Ctrl + Tap > 탭 전환
	
	public static void main(String[] args) {
		
		//접근 지정자(제어자), Access Modifier
		//- 클래스 멤버에 붙어서 사용한다.
		//- 클래스 자체에 붙여서 사용한다.
		//- 지역변수에는 사용 불가능
		//- 클래스(객체)의 영역을 기준으로 외부에 해당 멤버를 노출하는 수위를 결정
		//- 멤버를 외부에 공개할지 여부를 조절하는 역할
		
		//1. public > 100% 공개
		//2. private > 100% 비공개
		//----------
		//3. protected
		//4. default
	
	
		Book b1 = new Book();
		
		b1.title = "자바의 정석"; 	//public
		//b1.author = "남궁성";	//private -> 클래스 외부영역에는 비공개
		
		
		
		//"홍길동" : Phone 클래스 설계
		//"아무개" : 객체 생성
//		Phone p1 = new Phone();
//		
//		p1.model = "S22";
//		p1.color = "white";
//		p1.price = 1200000;
//		p1.weight = 350;
//		
//		System.out.println(p1.model);
//		System.out.println(p1.color);
//		System.out.println(p1.price);
//		System.out.println(p1.weight);
//		
//		
//		//"하하하" : 객체 생성
//		Phone p2 = new Phone();
//		p2.model = "A10";
//		p2.color = "yellow";
//		p2.price = 1000000000;
//		p2.weight = 1000000000;
//		
//		System.out.println(p2.model);
//		System.out.println(p2.color);
//		System.out.println(p2.price);  //10억
//		System.out.println(p2.weight); //10억
		
		
		
		Phone p3 = new Phone();
		
		p3.aaa("S22");
//		System.out.println(p3.model);
		System.out.println(p3.bbb());
		
		p3.ccc(100000000);
		System.out.println(p3.ddd());
		
		
		
		SmartPhone s1 = new SmartPhone();
		
		//쓰기
		s1.setModel("S22");
		s1.setColor("white");
		s1.setPrice(120);
		s1.setWeight(300); //g
		
		System.out.println(s1.getModel());
		System.out.println(s1.getColor());
		System.out.println(s1.getPrice());
		System.out.println(s1.getWeight()); //kg > 환산
		
		
		//*** 사용자에게 혼동을 초래한다!!!! > 이 메소드가 왜 있지?
		//s1.calcWeight(0);  > getWeight()를 위해 만들어진 메소드
		
		
		
		
		
		//클래스 설계시 접근 지정자 가이드
		//1. 멤버 변수 > private
		//2. 필요한 Getter/Setter > public
		//3. 불필요한 내부 멤버 메소드 > private
		//4. 외부 호출 멤버 메소드 > public
		
		//설계할 때 잘 모르겠다;;;
		//1. 무조건 모두 다 private(변수, 메소드)  -> 사고는 안터짐
		//2. Getter/Setter > public
		//3. 필요한데 안보이는 멤버가 발생!!! > 걔네들만 하나씩 public 교체..
		
		
		
		Cup cup = new Cup();
		
		
		//Getter/Setter 역할
		//1. 멤버 보호(멤버 변수에 유효하지 않은 값이 들어가는 것을 방지!!!)
		//2. 쓰기 전용, 읽기 전용 가능
		//3. 계산된 멤버 생성 가능
		
		//쓰기, 읽기 프로퍼티
		cup.setColor("brown");  //쓰기
		System.out.println(cup.getColor()); //읽기
		
		//쓰기 전용 프로퍼티 > ** 변수로는 이렇게 만들 수 없음
		cup.setWeight(500);
//		System.out.println(cup.getWeight());  
		
		//읽기 전용 프로퍼티
		//cup.setPrice(2000);
		System.out.println(cup.getPrice());
		
		//getInfo를 보면 info라는 private property가 존재한다고 상상함 > private String info; > 중요하지 않음
		System.out.println(cup.getInfo());
		
		
		
		//자바의 정석은 반드시 봐야함!!!
		//나중에(지금~ 1개월 뒤) 
		
		
	} //main
	
}

//정보 은닉화
//인터페이스 > 내부<->외부 교류 할 수 있는 통로가 필요
//캡슐화

//객체 > 내부에 여러가지 멤버 소유

//케이스(캡슐)로 감싸는 이유?
//- 외부로부터 내부 요소를 보호하기 위해서
//- 객체의 사용법을 단순화하기 위해서  ex)컴퓨터본체의 전원

class Book {
	
	public String title; 	//도서명
	private String author;	//저자
	
//TODO 클래스 안에는 변수생성 후 나~중에 데이터를 넣어 초기화를 못하나? (2022. 3. 23. 오후 12:42:13)
}


class Phone {
	
//	1. 무조건 멤버 변수는 private을 지정한다.
	private String model;
	private String color;
	private int price; 
	private int weight;
	
//	2. public 메소드를 생성한다. > 대리자 > 인터페이스 > 리모컨의 버튼들.. > 객체의 사용법(방법)
	public void aaa(String a) {
		model = a;
	}
	
	public String bbb() {
		return model;
	}

	public void ccc(int c) {
		
		if(c >= 0 && c <= 1500000) {
			price = c;
		} else {
			System.out.println("에러");
		}
	}
	
	public int ddd() {
		return price;
	}
}


class SmartPhone {
	
	//1.멤버 변수 > 무조건 private
	private String model;
	private String color;
	private int price;
	private int weight;
	
	//2. 인터페이스 역할 메소드 생성

	//Setter
	//- setXXX() > 외부에서 값을 받아서 넣어줌
	//- set멤버변수()
	public void setModel(String model) {
		
		//this
		//- 객체 접근 연산자
		
		//this.멤버변수 = 매개변수(지역변수)
		this.model = model;
		
	}
	
	//Getter
	//- getXXX()
	//- get멤버변수()
	public String getModel() {
		
		return this.model; //충돌이 안나도 가독성때문에 붙임
	}
	
	public void setColor(String color) {
		//색상 > 주관식x > 선택 > 열거형
		if(color.equals("black")
				|| color.equals("white")
				|| color.equals("red")
				|| color.equals("yellow")
				|| color.equals("blue")) {
			this.color = color;			
		} else {
			System.out.println("존재하지 않는 색상입니다.");
		}
	}
	
	public String getColor() {
		return this.color;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public void setWeight(int weight) {
		if(weight > 0) {
			this.weight = weight;
		}
	}
	
	public double getWeight() {
		return calcWeight(this.weight);  //if 연산이 길다면 메소드로 처리할 수 있음
	}
	
	//*** 이 메소드의 성격?
	//- Getter > x
	//- 내부 업부에 필요한 작업을 분리시키기 위해서
	private double calcWeight(int weight) {  //무심코 public으로 !?!?
		return weight /1000.0;
	}



}

//**** 모든 상황에서 범위가 큰 요소와 범위가 작은 요소끼리 충돌이 발생하면?
//	-> 무조건(100%) 범위가 작은 요소가 우선한다.


//캡슐화 > 블랙 박스
class Cup {
	
	private String color;
	private int weight;
	private int price = 1000;
	private String type;
	
	
	public String getColor() {
		return color;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getInfo() {
		if(this.price < 500) {
			return "싼 컵";
		} else if(this.price < 1000) {
			return "보통 컵";
		} else {
			return "비싼 컵";
		}
	}
	
	
}









