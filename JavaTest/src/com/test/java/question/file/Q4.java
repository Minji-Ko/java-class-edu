package com.test.java.question.file;

import java.io.File;

public class Q4 {

	public static void main(String[] args) {
		
//		요구사항] 음악 파일이 100개 있다. 파일명 앞에 일련 번호를 붙이시오.
//				> '001'부터 3자리 형식으로 붙이시오.
//		리소스] 	폴더 > 음악 파일
//		출력]		[001]1도 없어 - Apink (에이핑크).mp3 
//				[002]11 (Prod. 다이나믹듀오) - Wanna One (워너원) - 남바완.mp3 
//				[003]134340 - 방탄소년단.mp3
//				..
//				[100]花요일 (Blooming Day) - EXO-CBX (첸백시).mp3
	
		String path = "C:\\class\\java\\파일_디렉토리_문제\\음악파일\\Music";
		File dir = new File(path);
		
		File[] musics = dir.listFiles();

		//TODO 정렬? (2022. 4. 4. 오후 9:23:05)
//		for(int i=0; i<musics.length-1; i++) {
//			for(int j=0; j<musics[i].length(); j++) {
//				if(musics[i].getName().charAt(j) > musics[i+1].getName().charAt(j)) {
//					File temp = musics[i];
//					musics[i] = musics[i+1];
//					musics[i+1] = temp;
//					break;
//				} else if(musics[i].getName().charAt(j) < musics[i+1].getName().charAt(j) ) {
//					break;
//				}
//			}
//		}
		
		
		for(int i=0; i<musics.length; i++) {
			String newPath = path + String.format("\\[%03d]", i+1) + musics[i].getName();
			File newName = new File(newPath); 
			
			
			musics[i].renameTo(newName);
		}
		
	
	}
}

//		설계]
//		1. 음악 파일 객체 만들기
//		2. 파일명 얻어와서 정렬하기
//		3. 파일명 수정하기 > for문 
//			3.1. 수정할 파일 객체만들기
//			3.2. renameTo
				