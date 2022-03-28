package com.test.java.question.classtest;

public class Q10_static {

	public static void main(String[] args) {
		
//		요구사항] 음료를 판매하고 그 매출액과 판매량을 구하시오.
//		Barista
//			- Espresso makeEspresso(int bean) > 에스프레소 1잔을 만든다.
//				int bean : 원두량(g)
//				return Espreeso : 에스프레소 1잔
//			- Espresso[] makeEspressoes(int bean, int count) > 에스프레소 N잔을 만든다.
//				int bean : 원두량(g)
//				int count : 음료 개수(잔)
//				return Espresso[] : 에스프레소 N잔
//			- Latte makeLatte(int bean, int milk) > 라테 1잔을 만든다.
//				int bean : 원두량(g)
//				int milk : 우유량(ml)
//				return Latte : 라테 1잔
//			- Latte[] makeLattes(int bean, int milk, int count) > 라테 N잔을 만든다.
//				int bean : 원두량(g)
//				int milk : 우유량(ml)
//				int count : 음료 개수(잔)
//				return Latte[] : 라테 N잔
//			- Americano makeAmericano(int bean, int water, int ice)
//				int bean : 원두량(g)
//				int water : 물량(ml)
//				int ice : 얼음 개수(개)
//				return Americano : 아메리카노 1잔
//			- Americano[] makeAmericanos(int bean, int water, int ice, int count)
//				int bean : 원두량(g)
//				int water : 물량(ml)
//				int ice : 얼음 개수(개)
//				int count : 음료 개수(잔)
//				return Americano[] : 아메리카노 N잔
//			- void result() > 판매 결과를 출력한다.
//				- 음료 판매량(에스프레소 판매 개수, 라테 판매 개수, 아메리카노 판매 개수)
//				- 원자재 소비량(원두 소비량, 물 소비량, 우유 소비량, 얼음 소비량)
//				- 매출액(원두 판매액, 물 판매액, 우유 판매액, 얼음 판매액)
//		Coffee > 공용 정보 클래스
//			static bean		총 원두량(g)
//			static water 	총 물 용량(ml)
//			static ice		총 얼음 개수(개)
//			static milk		총 우유 용량(ml)
//			static beanUnitPrice 	원두 단가(원)	1g당 1원
//			static waterUnitPrice	물 단가(원)	1ml당 0.2원
//			static iceUnitPrice		얼음 단가(원)	1개당 3원
//			static milkUnitPrice	우유 단가(원)	1ml당 4원
//			static beanTotalPrice	원두 총 판매액(원)
//			static waterTotalPrice	물 총 판매액(원)
//			static iceTotalPrice	얼음 총 판매액(원)
//			static milkTotalPrice	우유 총 판매액(원)
//			static americano		아메리카노 총 판매 개수(잔)
//			static latte			라테 총 판매 개수(잔)
//			static espresso			에스프레소 총 판매 개수(잔)
//		Espresso
//			- 상태	bean	에스프레소 생산 시 들어가는 원두량(g)
//			- 행동
//			void drink()	커피를 마신다.(출력)
//		Latte
//			- 상태	bean	라테 생산 시 들어가는 원두량(g)
//					milk	라테 생산 시 들어가는 우유량(ml)
//			- 행동
//			void drink()	커피를 마신다.(출력)
//		Americano
//			- 상태	bean	아메리카노 생산 시 들어가는 원두량(g)
//					water	아메리카노 생산 시 들어가는 물량(ml)
//					ice		아메리카노 생산 시 들어가는 얼음 개수(개)
//			- 행동
//			void drink()	커피를 마신다.(출력)
		
		//바리스타
		Barista barista = new Barista();

		//손님 1
		//에스프레소 1잔 주문 - 원두 30g
		Espresso e1 = barista.makeEspresso(30);
		e1.drink();

		//손님 2
		//라테 1잔 주문 - 원두 30g, 우유 250ml
		Latte l1 = barista.makeLatte(30, 250);
		l1.drink();

		//손님 3
		//아메리카노 1잔 주문 - 원두 30g, 물 300ml, 각얼음 20개
		Americano a1 = barista.makeAmericano(30, 300, 20);
		a1.drink();

		//손님 4
		//에스프레소 10잔 주문 - 원두 25g
		Espresso[] e2 = barista.makeEspressoes(25, 10);

		for (Espresso e : e2) {
		      e.drink();
		}

		//손님 5
		//라테 5잔 주문 - 원두 25g, 우유 300ml
		Latte[] l2 = barista.makeLattes(25, 300, 5);

		for (Latte l : l2) {
		      l.drink();
		}

		//손님 6
		//아메리카노 15잔 주문 - 원두 20g, 물 350ml, 각얼음 30개
		Americano[] a2 = barista.makeAmericanos(20, 350, 30, 15);

		for (Americano a : a2) {
		      a.drink();
		}

		//결산
		barista.result();
	}
}

class Barista {
	
	public Espresso makeEspresso(int bean) {
		Espresso espresso = new Espresso(bean);
		return espresso;
	}
	public Espresso[] makeEspressoes(int bean, int count) {
		
		Espresso[] carrier = new Espresso[count];
		
		for(int i=0; i<carrier.length; i++) {
			Espresso espresso = new Espresso(bean);
			carrier[i] = espresso;
		}
	
		return carrier;
	}
	public Latte makeLatte(int bean, int milk) {
		Latte latte = new Latte(bean, milk);
		return latte;
	}
	public Latte[] makeLattes(int bean, int milk, int count) {
		
		Latte[] carrier = new Latte[count];
		
		for(int i=0; i<carrier.length; i++) {
			Latte latte = new Latte(bean, milk);
			carrier[i] = latte;
		}
		
		return carrier;
	}
	public Americano makeAmericano(int bean, int water, int ice) {
		Americano americano = new Americano(bean, water, ice);
		return americano;
	}
	public Americano[] makeAmericanos(int bean, int water, int ice, int count) {
		
		Americano[] carrier = new Americano[count];
		
		for(int i=0; i<carrier.length; i++) {
			Americano americano = new Americano(bean, water, ice);
			carrier[i] = americano;
		}
		
		return carrier;
	}
	public void result() {
		System.out.println("=================================");
		System.out.println("판매 결과");
		System.out.println("=================================");
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("음료 판매량");
		System.out.println("---------------------------------");
		System.out.printf("에스프레소 : %d잔\n", Coffee.getEspresso());
		System.out.printf("아메리카노 : %d잔\n", Coffee.getAmericano());
		System.out.printf("라테 : %d잔\n", Coffee.getLatte());
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("원자재 소비량");
		System.out.println("---------------------------------");
		System.out.printf("원두 : %,dg\n", Coffee.getBean());
		System.out.printf("물 : %,dml\n", Coffee.getWater());
		System.out.printf("얼음 : %,d개\n", Coffee.getIce());
		System.out.printf("우유 : %,dml\n", Coffee.getMilk());
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("매출액");
		System.out.println("---------------------------------");
		System.out.printf("원두 : %,d원\n", Coffee.getBeanTotalPrice());
	
		if (Coffee.getWaterTotalPrice() == (int)Coffee.getWaterTotalPrice()) {
			System.out.printf("물 : %,d원\n", (int)Coffee.getWaterTotalPrice());
		} else {
			System.out.printf("물 : %,.1f원\n", Coffee.getWaterTotalPrice());
		}
	
		System.out.printf("얼음 : %,d원\n", Coffee.getIceTotalPrice());
		System.out.printf("우유 : %,d원\n", Coffee.getMilkTotalPrice());
		System.out.println();
	}
}

class Coffee {
	
	private static int espresso;
	private static int latte;
	private static int americano;
	
	private static int bean;
	private static int water;
	private static int milk;
	private static int ice;
	
	private static int beanUnitPrice = 1;
	private static double waterUnitPrice = 0.2;
	private static int iceUnitPrice = 3;
	private static int milkUnitPrice = 4;
	
	private static int beanTotalPrice;
	private static double waterTotalPrice;	
	private static int iceTotalPrice;
	private static int milkTotalPrice;	
	
	
	public static int getEspresso() {
		return espresso;
	}
	public static void setEspresso() {
		Coffee.espresso++;
	}
	public static int getLatte() {
		return latte;
	}
	public static void setLatte() {
		Coffee.latte++;
	}
	public static int getAmericano() {
		return americano;
	}
	public static void setAmericano() {
		Coffee.americano++;
	}
	
	
	public static int getBean() {
		return bean;
	}
	public static void setBean(int bean) {
		Coffee.bean += bean;
	}
	public static int getWater() {
		return water;
	}
	public static void setWater(int water) {
		Coffee.water += water;
	}
	public static int getMilk() {
		return milk;
	}
	public static void setMilk(int milk) {
		Coffee.milk += milk;
	}
	public static int getIce() {
		return ice;
	}
	public static void setIce(int ice) {
		Coffee.ice += ice;
	}
	
	
	public static int getBeanTotalPrice() {
		return beanTotalPrice = bean * beanUnitPrice;
	}
	public static double getWaterTotalPrice() {
		return waterTotalPrice = water * waterUnitPrice;
	}
	public static int getIceTotalPrice() {
		return iceTotalPrice = ice * iceUnitPrice;
	}
	public static int getMilkTotalPrice() {
		return milkTotalPrice = milk * milkUnitPrice;
	}

		
}


class Espresso {
	private int bean;
	
	public Espresso(int bean) {
		this.bean = bean;
		
		Coffee.setBean(bean);
		Coffee.setEspresso();
	}
	
	public void drink() {
		System.out.printf("원두 %dg으로 만들어진 에스프레소를 마십니다.\n", this.bean);
	}
}

class Latte {
	private int bean;
	private int milk;
	
	public Latte(int bean, int milk) {
		
		this.bean = bean;
		this.milk = milk;
		
		Coffee.setBean(bean);
		Coffee.setMilk(milk);
		Coffee.setLatte();
	}
	
	public void drink() {
		System.out.printf("원두 %dg, 우유 %dml으로 만들어진 라테를 마십니다.\n", this.bean, this.milk);
	}
}

class Americano {
	private int bean;
	private int water;
	private int ice;
	
	public Americano(int bean, int water, int ice) {
		this.bean = bean;
		this.water = water;
		this.ice = ice;
		
		Coffee.setBean(bean);
		Coffee.setWater(water);
		Coffee.setIce(ice);
		Coffee.setAmericano();
	}
	
	public void drink() {
		System.out.printf("원두 %dg, 물 %dml, 얼음 %d개로 만들어진 아메리카노를 마십니다.\n", this.bean, this.water, this.ice);
	}
}