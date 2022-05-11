package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {

	public static void main(String[] args) throws Exception {
	
//		요구사항] 파일명 10개를 입력받아 각 확장자별로 총 개수를 출력하시오.
//		- 없는 확장자는 하기 말기, 대소문자 구분없이!
//		- 확장자는 다음으로 제한한다. >mp3, jpg, java, hwp, doc
	
//		입력]	파일명: 인기가요.mp3  (*10)
//		출력]	mp3 : 1개
//			jpg : 3개
//			java: 2개
//			hwp : 2개
//			doc : 2개
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//파일명 저장하기
		String[] fileName = new String[10];
		
		for(int i=0; i<fileName.length; i++) {
			System.out.print("파일명: ");
			fileName[i] = reader.readLine();
		}

		
		//파일확장자 추출하기 -> 확장자별 개수 파악하기
		String[] extension = {"mp3", "jpg", "java", "hwp", "doc"};
		
		int[] extensionNum = new int[5];
		
		
		for(int i=0; i<fileName.length; i++) {
			
			int index = fileName[i].lastIndexOf(".");
			String fileExtension = fileName[i].toLowerCase().substring(index + 1);
			
			for(int j=0; j<extension.length; j++) {
				if(fileExtension.equals(extension[j])) {
					++extensionNum[j];
					break;
				}
			}
			
		}
		
		//출력하기
		for(int i=0; i<extension.length; i++) {
			System.out.printf("%-4s : %d개\n", extension[i], extensionNum[i]);			
		}
		
		
					
	}
}

//		설계]
//		1. 파일 10개 입력받기 > 배열에 저장
//		2. 각 확장자 별 개수 파악하기
//			2.1 int index = lastIndexOf(".")
//			2.2 substring(index)
//			2.3 toLowerCase().
//			2.4 String 배열만들기 > 확장자 저장
//			2.4 int 배열만들기 > String 배열과 비교하여 같으면 배열에++
//			2.5 출력