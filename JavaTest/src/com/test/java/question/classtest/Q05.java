package com.test.java.question.classtest;

public class Q05 {

	public static void main(String[] args) {
		
//		요구사항] Box 클래스와 Macaron 클래스를 설계하시오.
		//cook에서 마카롱 10개 만들어서 []에 넣기, 대신 마카롱 사이즈 등등은 무작위로 넣기 
//		- 1Box에는 10개의 마카롱을 담을 수 있다.(멤버 변수 = Macaron 배열)
//		- Box 객체의 사용
//			- Box 객체를 생성시 Box에 마카롱 객체를 10개 담는다.(무작위)
//			- 품질 검사에 통과하지 못하는 마카롱을 구분한다.
//		- Macaron 객체의 정보		
//			- 생산 크기(5cm ~ 15cm) → 판매 유효 크기(8cm ~ 14cm)
//			- 생산 색상(red, blue, yellow, white, pink, purple, green, black) → 판매 유효 색상(black을 제외한 모든 색상)
//			- 생산 샌드 두께(1mm ~ 20mm) → 판매 유효 두께(3mm ~ 18mm)
	
	
		Box box1 = new Box();

		box1.cook();
		box1.check();
		box1.list();
	
	}
}

class Box {
	private Macaron[] list = new Macaron[10];
	
	public void cook() {
		
		String[] color = { "red", "blue", "yellow", "white", "pink", "purple", "green", "black"};
		
		for(int i=0; i<list.length; i++) {
			list[i] = new Macaron();
			list[i].setSize((int)(Math.random() * 11) + 5);
//			list[i].setColor(color[(int)(Math.random() * 8)]);
			list[i].setColor(color[(int)(Math.random() * color.length)]); //유지보수를 최대한 적게할 수 있도록!
			list[i].setThickness((int)(Math.random() * 20) + 1);
		}
//		System.out.println("마카롱 10개를 만들었습니다.");
		System.out.println("마카롱 " + list.length + "개를 만들었습니다.");
		System.out.println();
	}
	
	public void check() {

		int pass = 0;
		
		for(int i=0; i<list.length; i++) {
			if(list[i].check().equals("합격")) pass++;
		}
		
		System.out.printf("[박스 체크 결과]\nQC 합격 개수 : %d개\nQC 불합격 개수 : %d개\n", pass, list.length - pass);
		System.out.println();
	}
	
	public void list() {

		System.out.println("[마카롱 목록]");
		
		for(int i=0; i<list.length; i++) {
			System.out.printf("%2d번 마카롱 : %dcm(%s, %dmm) : %s\n"
									, i+1
									, list[i].getSize()
									, list[i].getColor()
									, list[i].getThickness() 
									, list[i].check());
		}
		System.out.println();
	}
}

class Macaron {

	private int size;
	private String color;
	private int thickness;

	public int getSize() {  	//**  getter, setter에는 업무코드를 안넣음. 최소한의 유효성 검사만!
		return size;
	}
	public void setSize(int size) {
		if(5 <= size && size <= 15) {
			this.size = size;
		} else {
			System.out.println("생산할 수 없는 크기의 마카롱입니다.");
		}
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		
		if(color.equals("red")
				||color.equals("blue")
				||color.equals("yellow")
				||color.equals("white")
				||color.equals("pink")
				||color.equals("purple")
				||color.equals("green")
				||color.equals("black")) {
			this.color = color;
			
		} else {
			System.out.println("생산할 수 없는 마카롱 색상입니다.");
		}
	}
	public int getThickness() {
		return thickness;
	}
	public void setThickness(int thickness) {
		if(1 <=thickness  && thickness <= 20) {
			this.thickness = thickness;
		} else {
			System.out.println("생산할 수 없는 마카롱 샌드의 두께입니다.");
		}
	}
	
	public String check() {
		if(size < 8 ||size > 14) {
			return "불합격";
		} 
		
		if (color.equals("black")) {  //else if로 할 필요없음.
			return "불합격";
		} 
		
		if (thickness < 3 || thickness > 18) {
			return "불합격";
		}	
		return "합격";
	}
}

//		설계]
//		1. Box클래스
//			1.1 cook -> 무작위 10개 마카롱 담기
//			1.2 check -> 품질검사
//			1.3 list -> 상세 설명
//		2. Macaron클래스
			
