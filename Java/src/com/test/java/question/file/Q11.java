package com.test.java.question.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Q11 {

	public static void main(String[] args) {
		
//		요구사항] 특정 이름을 찾아 다른 이름으로 변환 후 파일을 다른 이름으로 저장하시오.
//				> '유재석' → '메뚜기'
//				> 저장할 파일명: 이름수정_변환.dat
//		리소스] 	파일 > 이름수정.dat
//		출력]		변환 후 다른 이름으로 저장하였습니다.

		
		File file = new File("C:\\class\\java\\파일_입출력_문제\\이름수정.dat");
		
		if(!file.exists()) {
			System.out.println("파일의 경로를 찾을 수 없습니다.");
			return;
		}
		
		try {
			
			if(file.isFile()) {
				
				File newFile = new File(file.getParent() + "\\" + file.getName().substring(0, file.getName().lastIndexOf(".")) + "_변환" +  file.getName().substring(file.getName().lastIndexOf(".")));
				
				BufferedReader reader = new BufferedReader(new FileReader(file)); 
				BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
				
				String word = "유재석";
				String newWord = "메뚜기";
				
				
				String line = null;
				
				while((line = reader.readLine()) != null) {
					writer.write(line.replace(word, newWord));
					writer.newLine();
					System.out.println(line);
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
//				String word = "유재석";
//				String newWord = "메뚜기";
//				
//				String newContent = content.toString().replace(word, newWord);
//				
//				//3. 파일 내용 변경
//				BufferedWriter writer = new BufferedWriter(new FileWriter(file)); //*mj*어짜피 새파일을 만드는 작엄 > 이름바꾸기
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
 		1. 특정 이름을 찾아 
 			1.1 파일 참조 객체 생성
 			1.2 파일 내용 얻어와서 저장
 		2. 다른 이름으로 변환 
 			2.1. replace
 			2.2 내용 덮어쓰기하기
 		3. 파일을 다른 이름으로 저장하시오.
 			3.1 renameTo
  		4. 출력 
 */