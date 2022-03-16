package com.test.java;

public class Item38 {
	
	public static void main(String[] args) {
		
		//[SUMMARY] 중첩 if문 만들기 (2022. 3. 17. 오전 1:38:23)
		
		int score = 98;
		
		if (0 <= score && score <= 100) {
					
			if (score >= 60) {
				System.out.println("합격");
			} else {
				System.out.println("불합격");
			}
					
		} else {
			System.out.println("점수는 0 ~ 100사이로 입력해주세요.");
		}
		
	}
}
