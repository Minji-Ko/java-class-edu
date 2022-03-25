package com.test.java.obj.constructor;

public class Ex37 {

	public static void main(String[] args) {
		
		//공산품 > 일괄적 초기화 > model(M70), pirce(40000)
		Mouse m1 = new Mouse();
		
		Mouse m2 = new Mouse();		
		m2.setPrice(35000);
		
		Mouse m3 = new Mouse();
		m3.setPrice(35000);

		
		//객체의 초기 상태 > 상황에 따라 달라질 수 있다. > 생성자의 매개변수 사용 > 다양성
		Mouse m4 = new Mouse(35000); //모델명은 기본값 + 가격은 지정
		
		Mouse m5 = new Mouse("A100"); // 모델명은 지정 + 가격은 기본값(40000)
		
		Mouse m6 = new Mouse("B123", 30000); // 모델명과 가격 지정	
		
		
		//QC > discount > 35000
		System.out.printf("모델: %s, 가격: %d\n", m1.getModel(), m1.getPrice());
		System.out.printf("모델: %s, 가격: %d\n", m2.getModel(), m2.getPrice());
		System.out.printf("모델: %s, 가격: %d\n", m3.getModel(), m3.getPrice());
		System.out.printf("모델: %s, 가격: %d\n", m4.getModel(), m4.getPrice());
		System.out.printf("모델: %s, 가격: %d\n", m5.getModel(), m5.getPrice());
		System.out.printf("모델: %s, 가격: %d\n", m6.getModel(), m6.getPrice());
		
	} //main
}

class Mouse {
	
	private String model;
	private int price;
	
	public Mouse() {
		this.model = "M70";
		this.price = 40000;
	}
	public Mouse(int price) {
		this.model = "M70";
		this.price = price;
	}
	public Mouse(String model) {
		this.model = model;
		this.price = 40000;
	}
	public Mouse(String model, int price) {
		this.model = model;
		this.price = price;		
	}  //클래스 설계자(한 순간) <<<<< 클래스 사용자(무한정)  -> 사용자 입장에서 편리하게 만들어야 함
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}