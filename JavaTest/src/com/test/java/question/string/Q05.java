package com.test.java.question.string;

public class Q05 {

	public static void main(String[] args) {

//		요구사항] 특정 단어가 문장내에 몇회 있어있는지 수를 세시오.
//		- 무한루프, indexOf + substring / replace  
//		- 대상 문자열: String content = "안녕~ 길동아~ 잘가~ 길동아~";
//		- 검색 문자열: String word = "길동";
		
//		출력] '길동'을 총 2회 발견했습니다.

		String content = "안녕~ 길동아~ 잘가~ 길동아~";
		String word = "길동";

		
		int index = content.indexOf(word);
		
		int count = 0;
	
		while(index > -1) {
			
			count++;				
			
			index = content.indexOf(word, index + word.length());
		}
		
		System.out.printf("'%s'을 총 %d회 발견했습니다.", word, count);
		
			
//		System.out.println((content.length() - content.replace("길동", "").length())/2);
		
		
	}
}
//		설계]
//		1. while -> count++;
//		2. int index = content.indexOf(word, 0)
//		3. index = content.indexOf(word, index + word.length())
//		4. while문 탈출하기 
//			index == lastIndexOf(word)