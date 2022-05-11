package com.test.java.question.classtest;

public class Q09_static {

	public static void main(String[] args) {
		
//		요구사항] 포장하는 직원 객체를 만드시오. 그 직원을 통해 연필, 지우개, 볼펜, 자를 포장하시오.
//		Packer > 사무용품을 포장하는 직원
//			- 상태
//			static pencilCount > 연필 포장 개수(개)
//			static eraserCount > 지우개 포장 개수(개)
//			static ballPoinPenCount > 볼펜 포장 개수(개)
//			static rulerCount >	자 포장 개수(개)
//			- 행동
//			void packing(Pencil pencil) >연필을 검수하고 포장한다.
//			void packing(Eraser eraser) >지우개를 검수하고 포장한다.
//			void packing(BallPointPen ballPointPen)
//			void packing(Ruler ruler)
//			void countPacking(int type) > 포장한 내용물 개수를 출력한다.
//				- int type : 출력할 내용물의 종류 > 모든 내용물(0), 연필, 지우개, 볼펜, 자
//		Pencil > 연필 클래스
//			- 상태 > hardness > 흑연 등급(4B, 3B, 2B, B, HB, H, 2H, 3H, 4H)
//			- 행동 >	String info() > 연필의 정보를 반환한다.
//		Eraser
//			- 상태 > size > 지우개 크기(Large, Medium, Small)
//			- 행동 > String info()
//		BallPointPen
//			- 상태 
//			thickness > 볼펜 심 두께(0.3mm, 0.5mm, 0.7mm, 1mm, 1.5mm)
//			color > 볼펜 색상(red, blue, green, black)
//			- 행동 >	String info()
//		Ruler
//			- 상태
//			length > 자 길이(30cm, 50cm, 100cm)
//			shape > 자 형태(줄자, 운형자, 삼각자)
//			- 행동 >	String info()
		
		//포장하는 직원
		Packer packer = new Packer();

		//연필
		Pencil p1 = new Pencil();
		p1.setHardness("HB");
		packer.packing(p1);

		Pencil p2 = new Pencil();
		p2.setHardness("4B");
		packer.packing(p2);

		//지우개
		Eraser e1 = new Eraser();
		e1.setSize("Large");
		packer.packing(e1);

		//볼펜
		BallPointPen b1 = new BallPointPen();
		b1.setThickness(0.3);
		b1.setColor("black");
		packer.packing(b1);

		BallPointPen b2 = new BallPointPen();
		b2.setThickness(1);
		b2.setColor("red");
		packer.packing(b2);

		//자
		Ruler r1 = new Ruler();
		r1.setLength(30);
		r1.setShape("줄자");
		packer.packing(r1);

		//결과 확인
		packer.countPacking(0);
		packer.countPacking(1);
		packer.countPacking(2);
		packer.countPacking(3);
		packer.countPacking(4);
		
	}
}

class Packer {
	
	private static int pencilCount = 0;
	private static int eraserCount = 0;
	private static int ballPointPenCount = 0;
	private static int rulerCount = 0;
	
	public void packing(Pencil pencil) {
		
		if(pencil.isPacking() == true) {
			System.out.println("이미 포장되어있는 상품입니다.\n");
			return;
		}
		
		System.out.printf("포장 전 검수 : %s 진하기 연필입니다.\n", pencil.getHardness());

		if (!pencil.getHardness().equals("미정")) {
			System.out.println("포장을 완료했습니다.\n");
			pencil.setPacking(true);
			pencilCount++;
		} else {
			System.out.println("포장할 수 없는 상품입니다.\n");
		}
	}
	public void packing(Eraser eraser) {
		
		if(eraser.isPacking() == true) {
			System.out.println("이미 포장되어있는 상품입니다.\n");
			return;
		}

		System.out.printf("포장 전 검수 : %s 사이즈 지우개입니다.\n", eraser.getSize());

		if (!eraser.getSize().equals("미정")) {
			System.out.println("포장을 완료했습니다.\n");
			eraser.setPacking(true);
			eraserCount++;
		} else {
			System.out.println("포장할 수 없는 상품입니다.\n");
		}
	}
	
	public void packing(BallPointPen ballPointPen) {
		
		if(ballPointPen.isPacking() == true) {
			System.out.println("이미 포장되어있는 상품입니다.\n");
			return;
		}

		System.out.printf("포장 전 검수 : %s 색상 %.1fmm 볼펜입니다.\n", ballPointPen.getColor(), ballPointPen.getThickness());

		if (!ballPointPen.getColor().equals("미정") && ballPointPen.getThickness() != 0.0) {
			System.out.println("포장을 완료했습니다.\n");
			ballPointPen.setPacking(true);
			ballPointPenCount++;
		} else {
			System.out.println("포장할 수 없는 상품입니다.\n");
		}

	}
	public void packing(Ruler ruler) {
		
		if(ruler.isPacking() == true) {
			System.out.println("이미 포장되어있는 상품입니다.\n");
			return;
		}
		
		System.out.printf("포장 전 검수 : %dcm %s입니다.\n", ruler.getLength(), ruler.getShape());

			
		if (!ruler.getShape().equals("미정") && ruler.getLength() != 0) {
			System.out.println("포장을 완료했습니다.\n");
			ruler.setPacking(true);
			rulerCount++;
		} else {
			System.out.println("포장할 수 없는 상품입니다.\n");
		}
	}
	
	public void countPacking(int type) {
		System.out.print("=====================\n포장 결과\n=====================\n");
		
		if (type == 0 || type == 1) System.out.printf("연필 %d회\n", Packer.pencilCount);  
		if (type == 0 || type == 2) System.out.printf("지우개 %d회\n", Packer.eraserCount); 
		if (type == 0 || type == 3)	System.out.printf("볼펜 %d회\n", Packer.ballPointPenCount); 
		if (type == 0 || type == 4) System.out.printf("자 %d회\n", Packer.rulerCount); 
		if (type < 0 || type > 4) System.out.println("포장 결과를 조회할 수 없습니다.");
		System.out.println();
	}
	
}



class Pencil {
	
	private String hardness;
	private boolean packing;

	public Pencil() {
		this.hardness = "미정";
		this.packing = false;
	}
	
	public boolean isPacking() {
		return packing;
	}
	public void setPacking(boolean packing) {
		this.packing = packing;
	}
	public String getHardness() {
		return hardness;
	}
	public void setHardness(String hardness) {
		switch(hardness) {
			case "4B": case "3B": case "2B": case "B": case "HB": case "H": case "2H": case "3H": case "4H":
				this.hardness = hardness;
		}
	}
	
	public String info() {
		return "이 연필의 흑연 등급은" + this.hardness+ "입니다.\n";
	}
	
}

class Eraser {
	
	private String size;
	private boolean packing;
	
	public Eraser() {
		this.size = "미정";
		this.packing = false;
	}
	
	public boolean isPacking() {
		return packing;
	}
	public void setPacking(boolean packing) {
		this.packing = packing;
	}
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		switch(size) {
			case "Large": case "Medium": case "Small":
				this.size = size;
		}
	}
	
	public String info() {
		return "이 지우개의 크기는" + this.size + "입니다.\n";
	}
	
}

class BallPointPen {
	
	private double thickness;
	private String color;
	private boolean packing;
	
	public BallPointPen() {
		this.thickness = 0.0;
		this.color = "미정";
		this.packing = false;
	}
	
	public boolean isPacking() {
		return packing;
	}
	public void setPacking(boolean packing) {
		this.packing = packing;
	}
	public double getThickness() {
		return thickness;
	}

	public String getColor() {
		return color;
	}

	public void setThickness(double thickness) {
		if(thickness == 0.3 || thickness == 0.5 || thickness == 0.7 || thickness == 1.0 || thickness == 1.5) {
			this.thickness = thickness;
		}
	}
	
	public void setColor(String color) {
		switch(color) {
			case "red": case "blue": case "green": case "black":
				this.color = color;
		}
	}
	
	public String info() {
		return String.format("이 볼펜의 색상은 %s이며, 볼펜 심의 두께는 %.1fmm입니다.\n", this.color, this.thickness);
	}
	
}

class Ruler {
	
	private int length;
	private String shape;
	private boolean packing;
	
	public Ruler() {
		this.length = 0;
		this.shape = "미정";
		this.packing = false;
	}
	
	public boolean isPacking() {
		return packing;
	}
	public void setPacking(boolean packing) {
		this.packing = packing;
	}
	public int getLength() {
		return length;
	}
	public String getShape() {
		return shape;
	}

	public void setLength(int length) {
		switch(length) {
			case 30: case 50: case 100:
				this.length = length;
		}
	}
	public void setShape(String shape) {
		switch(shape) {
			case "줄자": case "운형자": case "삼각자":
				this.shape = shape;
		}
	}
	
	public String info() {
		return String.format("이 자의 형태는 %s이고, 길이는 %dcm입니다.\n", this.shape, this.length);
	}

	
}
