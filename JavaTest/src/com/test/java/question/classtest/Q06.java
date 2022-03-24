package com.test.java.question.classtest;

import java.util.Arrays;
import java.util.Calendar;

public class Q06 {
	
	public static void main(String[] args) {
		
//		요구사항] Refrigerator 클래스와 Item 클래스를 설계하시오.
//		- Refrigerator 객체의 정보
//			- Item을 최대 100개까지 담을 수 있다.(멤버 변수 = Item 배열)
//		- Refrigerator 객체의 사용
//			- Item을 냉장고에 넣는다. void add(Item item);
//			- Item을 냉장고에서 꺼낸다. Item get(String name);
//			- 냉장고에 있는 Item의 개수를 확인한다. int count();
//			- 냉장고에 있는 Item을 확인한다. void listItem();
//		- Item 객체의 정보
//			- 식품명, 유통기한
		//꺼내기 > 배열에서 사라져야 함  > Item!
		
		Refrigerator r = new Refrigerator();

		Item item1 = new Item();
		item1.setName("김치");
		item1.setExpiration("2022-4-8");
		r.add(item1);//냉장고에 넣기

		Item item2 = new Item();
		item2.setName("깍두기");
		item2.setExpiration("2022-4-1");
		r.add(item2);//냉장고에 넣기
		
		Item item3 = new Item();
		item3.setName("멸치볶음");
		item3.setExpiration("2022-4-8");
		r.add(item3);//냉장고에 넣기
		
		Item item4 = r.get("깍두기");//냉장고에서 꺼내기
		System.out.printf("%s의 유통기한 : %s\n", item4.getName(), item4.getExpiration());
		
		System.out.printf("냉장고 안의 총 아이템 개수 : %d개\n", r.count());
		r.listItem();

	}
	
}

class Refrigerator {
	
	private Item[] refrigerator = new Item[100];
	
	public void add(Item item) {
		
		for(int i=0; i<refrigerator.length; i++) {
			if(refrigerator[i] == null) {
				refrigerator[i] = item;
				System.out.printf("'%s'를 냉장고에 넣었습니다.\n", item.getName());
				return;
			}
		}
		System.out.println("냉장고에 더 이상 넣을 공간이 없습니다.");
	}
	
	public Item get(String item) {

		for(int i=0; i<refrigerator.length; i++) {
			if(refrigerator[i] != null && refrigerator[i].getName().equals(item)) {
				
				Item temp = refrigerator[i];
				refrigerator[i] = null;
				return temp;
			}
		}
		System.out.printf("냉장고에 %s가 없습니다.\n", item);
		return null;
	}
	
	public int count() {
		int count = 0;
		
		for(int i=0; i<refrigerator.length; i++) {
 			if(refrigerator[i]!=null) {
 				count++;
 			}
		}
		
		return count;
	}
	
	public void listItem() {
	
		System.out.println("[냉장고 아이템 목록]");
		for(int i=0; i<refrigerator.length; i++) {
 			if(refrigerator[i]!=null) {
				System.out.printf("%s(%s)\n", refrigerator[i].getName(), refrigerator[i].getExpiration());
			}
		}
	}
} //Refrigerator

class Item {
	
	private String name;
	private Calendar expiration;
	
	
	public String getName() {
			return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpiration() {
//		return String.format("%tF", expiration);
		return  String.format("%d-%d-%d"
								, expiration.get(Calendar.YEAR)
								, expiration.get(Calendar.MONTH)+1
								, expiration.get(Calendar.DATE));
	}	
	
	public void setExpiration(String expiration) {
		
		int year = Integer.parseInt(expiration.split("-")[0]);
		int month = Integer.parseInt(expiration.split("-")[1]);
		int date = Integer.parseInt(expiration.split("-")[2]);
		
		if(validate(year,month,date)) {
			this.expiration = Calendar.getInstance();
			this.expiration.set(year, month-1, date); 
		} else {
			System.out.println("유통기한이 올바르지 않습니다.");
		}
	}
	
	private boolean validate(int year, int month, int date) {
		
		if(year < 2020 || year > 2024) {
			return false;
		} else if (month < 0 || month > 12) {
			return false;
		} else if (date < 0 || date > 31){
			return false;
		} else {
			switch(month) {
				case 4: case 6: case 9: case 11:
				if(date == 31) return false;
				case 2:
				if(date > 29) return false;
				if(year != 2020 && year != 2024 && date == 29 ) return false;
			}
		}
		return true;
	}
	
	
	
}



//		설계]
//		Refrigerator 클래스
//		- 100칸 짜리 Item 넣는 배열
//		- add로 넣고 get으로 꺼내고 > 배열에서 없애고 == null
//		Item 클래스
//		- private name, expiration