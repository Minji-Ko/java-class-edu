package com.test.java.question.file;

import java.io.File;
import java.util.HashSet;

public class Q7 {

	public static void main(String[] args) {
		
//		요구사항]	MusicA 폴더와 MusicB 폴더를 서로 비교해서 양쪽 폴더에 모두 존재하는 파일만을 출력하시오.
//				> 중복 파일을 찾아내시오.
//		리소스] 	폴더 > 동일 파일
//		출력] 	BAAM - 모모랜드 (MOMOLAND).mp3 
//				Dejavu - 볼빨간사춘기.mp3 
//				SoulMate (Feat. 아이유) - 지코 (ZICO).mp3 
//				..
		
		String pathA = "C:\\class\\동일 파일\\MusicA";
		File dirA = new File(pathA);
		String pathB = "C:\\class\\동일 파일\\MusicB";
		File dirB = new File(pathB);
		
		HashSet<String> set = new HashSet<String>();
		
		for(File f : dirA.listFiles()) {
			set.add(f.getName());
		}
		
		for(File f : dirB.listFiles()) {
			if(set.add(f.getName()) == false) {
				System.out.println(f.getName());
			}
		}
		
	}
}

//		설계]
//		1. MusicA 폴더와 MusicB 폴더를 서로 비교하여 중복찾기
//			1.1. Set만들기 
//			1.2 listFiles() > getName후 set에 넣기
//			1.3. 또다른 파일 set에 넣으면서 false면 중복 
//		2. 중복 파일만을 출력
