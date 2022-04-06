package com.test.java.question.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

public class Q16 {

	public static void main(String[] args) {
	
/*
 	요구사항]	모든 괄호가 서로 짝이 맞는지 검사하시오.
			> 대상 괄호: (), {}
			> Stack 사용
	리소스]	파일 > 괄호.dat
	출력]		올바른 소스입니다. /올바르지 않은 소스입니다.
 */
		
		File file = new File("C:\\class\\java\\파일_입출력_문제\\괄호.java");
		
		if(!file.exists()) {
			System.out.println("파일의 경로를 찾을 수 없습니다.");
			return;
		}
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
		
			String line = null;
			Stack<Character> temp = new Stack<Character>();
			
	
			while((line = reader.readLine()) != null) {
				
				if(line.contains("{") || line.contains("}") || line.contains("(") || line.contains(")")) {
					for(int i=0; i<line.length(); i++) {
						char c = line.charAt(i);
						
						if(c == '{' || c == '(') {
							temp.push(c);
						} 
						
						if (c == '}') {
							if(temp.pop() != '{') {
								System.out.println("올바르지 않은 소스입니다.");
								return;
							}
						} else if (c == ')') {
							if(temp.pop() != '(') {
								System.out.println("올바르지 않은 소스입니다.");
								return;
							}
						}
					}
				}
				
			}
			
			if(temp.size() == 0) {
				System.out.println("올바른 소스입니다.");
			} 
		
		
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EmptyStackException e) {
			System.out.println("올바르지 않은 소스입니다.");
		}
	}
}

/*
 	설계]
 	1. 파일 참조객체 생성
 	2. 파일 읽기
 	3. { 또는 (가 나오면 stack에 넣기
 	4. } 또는 )가 나오면 스택 pop해서 괄호짝이 맞는지 비교
 		4.1 stack에 없는데 꺼내려 예외 할 때 처리 > 올바르지 않은 소스
 	5. stack에 남아있는게 있는지 검색
 */
