package com.test.java.question.file;

import java.io.File;
import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		
//		요구사항] 지정한 파일을 다른 폴더로 이동하고, 이동한 파일과 동일한 파일명의 파일이 존재하는 경우 중복 처리하시오.
//				> D:\class\java\file\AAA\test.txt → D:\class\java\file\BBB\test.txt 로 이동하는 것이 목적
//				> BBB 폴더에 이미 test.txt가 있을 경우 덮어쓰거나(y) 작업을 취소(n) 하시오.
//		
//		입력] 	파일 이동을 실행합니다.
//				같은 이름을 가지는 파일이 이미 존재합니다. 덮어쓸까요?(y/n) 
//		출력] 	y. 파일을 덮어썼습니다.
		
	
		String path = "C:\\class\\java\\file\\aaa\\test.txt";
		File file = new File(path);
		
		String newPath = "C:\\class\\java\\file\\bbb\\test.txt";
		File newFile = new File(newPath);
		File newDir = new File(newFile.getParent());
				
		
		if(file.exists()) {
			
			if(file.isFile()) {
				
				System.out.println("파일 이동을 실행합니다");
					
				if(newFile.exists()) {
					
					if(newFile.isFile()) {
						solveDuplicate(file, newFile);
					}
					
					if(newFile.isDirectory()) {
						System.out.print("같은 이름으로 된 폴더가 이미 존재합니다.");
					}
					
				} else {
					file.renameTo(newFile);
					System.out.println("파일을 이동했습니다.");
				}
				
				
//				if(file.renameTo(newFile)) {
//					System.out.println("파일을 이동했습니다.");
//					return;
//				} 
//					
//				for(File f : newDir.listFiles()) {
//					if(f.getName().equals(file.getName())) { //newFile이 존재한다면 중복 존재!
//						
//						if(f.isFile()) {
//							solveDuplicate(file, newFile);
//						}
//						
//						if(f.isDirectory()) {
//							System.out.print("같은 이름으로 된 폴더가 이미 존재합니다.");
//						}
//						break;
//					}
//				}
			} else {
				System.out.println("파일이 아닙니다.");
			}
			
		} else {
			System.out.println("파일을 찾을 수 없습니다.");
		}
		
	} //main

	private static void solveDuplicate(File file, File newFile) {
		
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		while(loop) {
			System.out.print("같은 이름을 가지는 파일이 이미 존재합니다. 덮어쓸까요?(y/n)");
			String answer = scan.nextLine();
			
			if(answer.equals("y")) {
				newFile.delete();
				file.renameTo(newFile);
				System.out.println("y. 파일을 덮어썼습니다.");
				loop = false;
				
			} else if(answer.equals("n")) {
				System.out.println("n. 작업을 취소합니다.");
				loop = false;
			}
		}
	}
}

//		설계]
//		1. 파일 지정하기 
//			1.1. 파일 객체 생성 > D:\class\java\file\AAA\test.txt
//		2. 지정한 파일을 다른 폴더로 이동
//			2.1. 파일 객체 생성 > D:\class\java\file\BBB\test.txt
//			2.2. 이동메시지 출력
//		3. 이동한 파일과 동일한 파일명의 파일이 존재하는 경우 중복 처리하시오.
//			3.1. 동일한 이름의 파일 존재하는지 확인 > 다른폴더 list 얻어서 getName끼리 비교
//			3.2. 없다면 파일 이동 > renameTo
//			3.3. 있다면 메시지 출력 > 지정한 파일 이름과 같은 이름으로 된 폴더가 이미 있습니다. 다른 이름을 지정하십시오
//			3.4. y 입력 > 파일 덮어쓰기 > 삭제 후 이동 > 메시지 출력
//				 n 입력 > 작업 취소하기 > 메시지 출력