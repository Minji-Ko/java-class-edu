package com.test.java;

public class Item101 {

	public static void main(String[] args) {
	
		//[SUMMARY] 참조형 형변환하기(업캐스팅, 다운캐스팅)(2022. 4. 3. 오후 11:41:43)
	
		//업캐스팅 > 일괄 관리
		Mouse[] mlist = new Mouse[7];
		mlist[0] = new G304("광", 45000, 5, 12000); 	//G304
		mlist[1] = new G304("광", 38000, 4, 7000);
		
		mlist[2] = new G102("광", 28000, 8000, "검정");	//G102
		mlist[3] = new G102("광", 29000, 6000, "하양");
		mlist[4] = new G102("광", 22000, 9000, "파랑");

		mlist[5] = new M331("광", "검정", 33000, 10000);	//M331
		mlist[6] = new M331("광", "연두", 34000, 18000);
		
		for (int i=0; i<mlist.length; i++) {
			mlist[i].click();
		
			//다운캐스팅 > 고유 기능 사용
			if(mlist[i] instanceof G304) {
				((G304)mlist[i]).clean();
			}
			if(mlist[i] instanceof G102) {
				((G102)mlist[i]).check();
			}
			if(mlist[i] instanceof M331) {
				((M331)mlist[i]).charge();
			}
		
		}
		
	}
}


class Mouse {
	public void click() {

	}
}

class G304 extends Mouse {
	
	private String type;
	private int price;
	private int buttons;
	private int dpi;
	
	
	public G304(String type, int price, int buttons, int dpi) {

		this.type = type;
		this.price = price;
		this.buttons = buttons;
		this.dpi = dpi;
	}


	@Override
	public String toString() {
		return "G304 [type=" + type + ", price=" + price + ", buttons=" + buttons + ", dpi=" + dpi
				+ "]";
	}


	public void click() {
		System.out.printf("클릭합니다. %d, %d\n", this.price, this.dpi);
	}
	
	public void clean() {
		System.out.println("광센서를 자동으로 세척합니다.");
	}
	
}

class G102 extends Mouse {
	
	private String type;
	private String color;
	private int price;
	private int dpi;
	
	public G102(String type, int price, int dpi, String color) {
		this.type = type;
		this.color = color;
		this.price = price;
		this.dpi = dpi;
	}

	@Override
	public String toString() {
		return "G102 [type=" + type + ", color=" + color + ", price=" + price + ", dpi=" + dpi + "]";
	}
	
	public void click() {
		System.out.printf("Click~ %s\n", this.color);
	}
	
	public void check() {
		System.out.println("현재 DPI를 체크합니다.");
	}
	
}

class M331 extends Mouse {
	
	private String type;
	private String color;
	private int price;
	private int dpi;
	
	public M331(String type, String color, int price, int dpi) {
		this.type = type;
		this.color = color;
		this.price = price;
		this.dpi = dpi;
	}
	
	@Override
	public String toString() {
		return "M331 [type=" + type + ", color=" + color + ", price=" + price + ", dpi=" + dpi
				+ "]";
	}
	
	public void click() {
		System.out.printf("클릭!! %s\n", this.type);
	}
	
	public void charge() {
		System.out.println("충전합니다.");
	}
	
}