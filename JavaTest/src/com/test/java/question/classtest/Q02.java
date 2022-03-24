package com.test.java.question.classtest;

public class Q02 {

	public static void main(String[] args) {
		
//		요구사항] Note 클래스를 설계하시오.
//		- Note 객체의 정보 > 크기, 표지 색상, 페이지수, 소유자이름, 가격
//		- 모든 멤버 변수의 접근 지정자는 private으로 한다.
//		- 멤버 접근을 위한 Setter와 Getter를 정의한다.
//			- 크기 : 쓰기 전용, A3, A4, A5, B3, B4, B5
//			- 표지 색상 : 쓰기 전용, 검정색, 흰색, 노란색, 파란색
//			- 페이지수 : 쓰기 전용, 10 ~ 200페이지 이내
//				(+) 10~50(얇다), 51 ~ 100(보통), 101 ~ 200(두껍다)
//			- 소유자이름 : 쓰기 전용, 한글 2~5자이내. 필수값 > 소유자 정보를 안넣으면 주인없는노트 출력!
//			- 가격 : Setter,Getter 구현 안함. 추후 info() 메소드에서 사용하기 위해 아래와 같은 규칙으로 계산
//				(+) 기본 노트 : A5 + 흰색 + 10페이지 = 가격(500원)
//				(+) 크기 변경 : A3(+400원), A4(+200원), B3(+500원), B4(+300원), B5(+100원)
//				(+) 색상 변경 : 검정색(+100원), 노란색(+200원), 파란색(+200원)
//				(+) 페이지수 변경 : 페이지 당 x 10원 추가
//		- Note 객체의 정보를 확인하기 위한 메소드를 구현한다. > String info()
		
		Note note = new Note();

		note.setSize("B4");
		note.setColor("노란색");
		note.setPage(25);
		note.setOwner("홍길동");

		System.out.println(note.info());


		Note note2 = new Note();

		note2.setOwner("홍길동");
		note2.setSize("A4");
		note2.setPage(100);

		System.out.println(note2.info());
	}
}

class Note {
	
	private String size;
	private String color;
	private int page;
	private String owner;
	private int price;
	
	public void setSize(String size) {
		if(size.equals("A3") 
				||size.equals("A4") 
				||size.equals("A5")
				||size.equals("B3") 
				||size.equals("B4")
				||size.equals("B5")) {
			
			this.size = size;
		} else {
			System.out.println("잘못된 사이즈입니다.");
		}
	}
	public void setColor(String color) {
		if(color.equals("검정색") 
				||color.equals("흰색") 
				||color.equals("노란색")
				||color.equals("파란색")) { 
			this.color = color;
		} else {
			System.out.println("잘못된 색상입니다.");
		}
	}
	public void setPage(int page) {
		if(10<=page && page <=200) {
			this.page = page;
		} else {
			System.out.println("페이지 수가 올바르지 않습니다.");
		}
	}
	public void setOwner(String owner) {
		if(checkOwner(owner)) {
			this.owner = owner;
		} else {
			System.out.println("노트의 주인을 식별할 수 없습니다.");
		}
	}

	private boolean checkOwner(String owner) {
		if(owner.length() < 2 || owner.length() > 5) {
			return false;		
		}
		
		for(int i=0; i<owner.length(); i++) {
			if(!('가' <= owner.charAt(i) && owner.charAt(i) <='힣' )) {
				return false;
			}
		}
		return true;
	}
	
	private int calcPrice() {
				
		if((color != null) && (size != null) && (page != 0)) {
			
			int price = 500;
				
			switch(color) {
				case "노란색": case "파란색":
					price += 100;
				case "검정색":
					price += 100;
			}
			
			switch(size) {
				case "B3":
					price += 100;
				case "A3":
					price += 100;
				case "B4":
					price += 100;
				case "A4":
					price += 100;
				case "B5":
					price += 100;	
			} 
			
			price += (page - 10) * 10;

			this.price = price;
		}
		
		return this.price;
	}
	
	private String calcThickness() {
		
		if(10<= page && page <= 50) {
			return "얇은";
		} else if (51 <= page && page <= 100) {
			return "보통";
		} else if (100<= page && page <= 200) {
			return "두꺼운";
		}
		return null;
	}
	
	public String info() {
		
		if(owner == null) {  //null은 주소값이 없는 상태라서 == 로 비교해야 함
			return "■■■■■■ 노트 정보 ■■■■■■\n주인 없는 노트\n■■■■■■■■■■■■■■■■■■■■■\n";
		}
		
		
		this.calcPrice();
		
		return String.format("■■■■■■ 노트 정보 ■■■■■■\n"
								+ "소유자: %s\n"
								+ "특성 : %s %s %s노트\n"
								+ "가격 : %,d원\n"
								+ "■■■■■■■■■■■■■■■■■■■■■\n"
									,this.owner
									,this.color, this.calcThickness(), this.size
									,this.price);	
		
	}
	
	
}

//		설계]
//		1. Note 클래스
//			1.1 private 멤버 변수 5개 생성
//			1.2 getter, setter 메소드 생성  > 가격빼고 다 쓰기 전용
//			1.3 유효성검사
//			1.4 info 메소드
//		2. main 메소드
//			2.1 객체구현
//			2.2 set
//			2.3 info 호출해서 출력