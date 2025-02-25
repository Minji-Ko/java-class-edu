package com.test.spring.di01;

public class Ex01 {

	public static void main(String[] args) {
		
		//Ex01이 자신의 업무를 구현하기 위해서 Pen을 사용했다.
		//	= Pen이 없으면 Ex01은 업무를 진행할 수 없다.
		//	= Ex01과 Pend의 관겨 : Ex01이 Pen을 의존(사용)한다.
		// 	= Pen은 Ex01의 의존객체라고 부른다.
		Pen pen = new Pen();
		pen.write();
		
		//Brush는 의존객체이다.
		Brush brush = new Brush();
		brush.draw();
		
		//Ex01 > (Ex01의 의존 객체) Hong > (Hong의 의존 객체) Pen
		// Hong 생성 > Pen 생성
		Hong hong = new Hong();
		hong.run();
		
		
		//Ex02 > Lee > Brush
		//IoC: Brush 생성 > Lee 생성
		Brush b = new Brush();
		
		Lee lee = new Lee(b); //DI, 의존(객체) 주입 
		lee.run();
		
		//Hong vs Lee 
		//	- 업무 관리의 중심이 어디인가?
		//	- Spring은 전적으로 Lee(의존 주입)
		
		
	}
}
