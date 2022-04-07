package com.test.java.question.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Q12 {

	public static void main(String[] args) {
		
//		요구사항] 숫자를 한글로 바꾼 뒤 파일을 다른 이름으로 저장하시오.
//				> 0 → 영, 1 → 일 ... 9 → 구
//				> 저장할 파일명: 숫자_변환.dat
//		리소스] 	파일 > 숫자.dat
//		출력]		변환 후 다른 이름으로 저장하였습니다.

		File file = new File("C:\\class\\java\\파일_입출력_문제\\숫자.dat");

		if(!file.exists()) {
			System.out.println("파일의 경로를 찾을 수 없습니다.");
			return;
		}
		
		try {
			
			if(file.isFile()) {
				
				File newFile = new File(file.getParent() + "\\" + file.getName().substring(0, file.getName().lastIndexOf(".")) + "_변환" +  file.getName().substring(file.getName().lastIndexOf(".")));
				
				BufferedReader reader = new BufferedReader(new FileReader(file)); 
				BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
				
				String line = null;
				String[] word = { "영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
				
				while((line = reader.readLine()) != null) {
					
					for(int i=0; i<word.length; i++) {
						writer.write(line.replace(String.valueOf(i), word[i]));
					}
					writer.newLine();
				}
				
				reader.close();
				writer.close();
				
				file.delete();
				
				System.out.println("변환 후 다른 이름으로 저장하였습니다.");
				
				
//				//1. 파일 내용 확인
//				BufferedReader reader = new BufferedReader(new FileReader(file));
//				
//				String line = null;
//				StringBuilder content = new StringBuilder();
//				
//				while((line = reader.readLine()) != null) {
//					content.append(line);
//					content.append("\n");
//				}
//				
//				reader.close();
//			
//				
//				//2. 수정할 내용물 생성
//				String[] word = { "영", "일", "이", "삼", "사","오","육","칠","팔", "구"};
//				String newContent = content.toString();
//				
//				for(int i=0; i<word.length; i++) {
//					newContent = newContent.replace(String.valueOf(i), word[i]);
//				}
//				
//				//3. 파일 내용 변경
//				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//				
//				writer.write(newContent);
//				
//				writer.close();
//				
//				
//				//4. 파일 이름 변경
//				String newFileName = file.getParent() + "\\" + file.getName().substring(0, file.getName().lastIndexOf(".")) + "_변환" +  file.getName().substring(file.getName().lastIndexOf("."));
//				
//				File newFile = new File(newFileName); 
//				
//				file.renameTo(newFile);
//				
//				System.out.println("변환 후 다른 이름으로 저장하였습니다.");
				
			} else {
				System.out.println("파일이 아닙니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}

/*
 		설계]
 		1. 파일 참조 객체 만들기
 		2. 파일 내용 불러오기
 		3. 숫자를 한글로 바꾸기 > 배열 이용
 		4. 파일을 다른 이름으로 저장
 		5. 출력하기
 		
 */
