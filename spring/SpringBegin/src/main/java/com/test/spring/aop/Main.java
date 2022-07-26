package com.test.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Main > 컨트롤러 
public class Main {

	public static void main(String[] args) {
		
		//Memo memo = new MemoImpl();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/spring/aop/memo.xml");
		
		
		Memo memo = (Memo)context.getBean("memo");
		
		memo.add("스프링 AOP 작업을 하고 있습니다.");
		
		try {
			String txt = memo.read(11);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		boolean result = memo.edit(5, "수정한 내용입니다.");
		
		result = memo.del(5);
	}
}
