package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09 {

	public static void main(String[] args) throws Exception {

//		요구사항] 금지어를 마스킹 처리 하시오.
//		- 금지어 > 바보, 멍청이
//		- 금지어 글자수에 따라 마스킹 개수도 자동으로 달라짐
		
//		입력]	입력: 너랑 안놀아 바보야!! 
//		출력]	너랑 안놀아 **야!!
//			금지어를 1회 마스킹했습니다.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("입력: ");
		String txt = reader.readLine();
		
		String[] banWord = { "바보", "멍청이" };
		
		//마스킹하기
		String maskingTxt = txt;
		
		for(int i=0; i<banWord.length; i++) {
			
			//마스킹될 문자열 만들기
			String masking = "";
			
			for(int j=0; j<banWord[i].length(); j++) {
				masking += "*";
			}
			//마스킹하기
			maskingTxt = maskingTxt.replace(banWord[i], masking);
		}

	
		//마스킹 횟수구하기
		int count = 0;
		
		for(int i=0; i<banWord.length; i++) {
			
			int index = txt.indexOf(banWord[i]);
						
			while(index > -1) {
				count++;
				index = txt.indexOf(banWord[i], index + banWord[i].length());				
			}
		}

		//출력하기
		System.out.println(maskingTxt);
		System.out.printf("금지어를 %d회 마스킹했습니다.", count);
	}
}

//		설계]
//		1. 입력받기
//		2. 금지어 배열 만들기 badWord
//		3. String masking > 배열[i].length만큼 "*"더하기 반복
//		4. replace(word[i], masking)
//		5. word[i] 횟수 찾기 > int index = indexOf(word[i], index + word[i].length)
//		6. 출력하기



