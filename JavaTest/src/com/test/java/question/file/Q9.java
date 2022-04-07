package com.test.java.question.file;

import java.io.File;
import java.util.ArrayList;

public class Q9 {

	public static void main(String[] args) {
	
//		요구사항]	폴더 내의 모든 파일들을 찾아 크기를 비교하고, 크기가 큰 순으로 정렬하시오.
//				> 자식 폴더내의 파일도 모두 검색하시오.
//				> 부모 자식 폴더에 상관없이 파일을 한번에 비교하시오.
//		리소스] 	폴더 > 크기 정렬
//		출력]		[파일명]      [크기]     [파일이 들어있는 폴더]
//				aaa.exe     57KB      AAA 
//				bbb.exe     50KB  	  BBB 
//				ccc.dat     41KB   	  AAA 
//				ddd.txt     20KB      CCC 
//				..
		

		String path = "C:\\class\\java\\파일_디렉토리_문제\\크기 정렬";
		File dir = new File(path);
		
		if(!dir.exists()) {
			System.out.println("파일을 찾을 수 없습니다.");
			return;
		}
		
		ArrayList<File> files = new ArrayList<File>();
		
		files = search(dir, files);
		
		files = align(files);
		
		System.out.println("[파일명]\t\t\t\t  [크기]\t\t[파일이 들어있는 폴더]");
		for(File f : files) {
			System.out.printf("%-30s\t%7s\t\t%s\n"
									, f.getName()
									, calcSize(f.length())
									, f.getParent().substring(f.getParent().lastIndexOf("\\") + 1));
		}
		
	}
	
	private static String calcSize(long size) {
		
		if (size < Math.pow(1024, 1)) {
			return String.format("%dB", size);
		} else if (size < Math.pow(1024, 2)) {
			return String.format("%.1fKB", size / Math.pow(1024, 1));	
		} else if (size < Math.pow(1024, 3)) {
			return String.format("%.1fMB", size / Math.pow(1024, 2));	
		} else if (size < Math.pow(1024, 4)) {
			return String.format("%.1fGB", size / Math.pow(1024, 3));	
		} else {
			return String.format("%.1TB", size / Math.pow(1024, 4));		
		}
	}

	private static ArrayList<File> align(ArrayList<File> files) {
		
		for(int i=0; i<files.size(); i++) {
			for(int j=0; j<files.size()-1-i; j++) {
				
				long front = files.get(j).length();
				long back = files.get(j+1).length();
				
				if(front < back) {
					files.add(j+2, files.get(j));
					files.remove(j);
				}
			}
		} 
		
		return files;
	}

	private static ArrayList<File> search(File dir, ArrayList<File> files) {
		
		for(File subFile : dir.listFiles()) {
			if(subFile.isFile()) {
				files.add(subFile);
			}
		}
		
		for(File subDir: dir.listFiles()) {
			if(subDir.isDirectory()) {
				search(subDir, files);
			}
		}
		
		return files;  //return을 안해도 되는 이유? 참조형은 주소값 복사가 이뤄짐! (2022. 4. 5. 오후 3:30:25)
		
	}
}

//		설계]
//		1. 폴더 내의 모든 파일들을 찾아 크기를 비교
//			1.1 모든파일을 하나의 File 배열에 넣기
//		2. 크기가 큰 순으로 정렬
//			2.1 length이용하여 버블정렬

