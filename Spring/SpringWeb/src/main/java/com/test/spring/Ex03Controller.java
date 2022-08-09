package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//컨트롤러 구현
//1. Controller 인터페이스 구현
//2. 어노테이션 사용

@Controller
@RequestMapping(value="/ex03.do")
public class Ex03Controller {
	
	//요청 메소드 > 맘대로~
//	@RequestMapping
//	public String test() {
//		
//		
//		return "ex03";
//	}
	
	
	//요청 메소드가 void > 가상 주소와 동일한 이름의 jsp를 자동으로 찾아준다 > 사용 비 추천 
	@RequestMapping 
	public void test() {
		System.out.println("test");
	}
	
	
	//RequestMapping > 유일해야 함!!
	public void aaa() {
		
	}
	public void bbb() {
		
	}
	public String ccc() {
		return "ccc";
	}

	
}
