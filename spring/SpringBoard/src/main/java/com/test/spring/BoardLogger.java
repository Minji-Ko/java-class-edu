package com.test.spring;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BoardLogger {

	@Pointcut("execution(public * com.test.spring.BoardController.*(..))")
	public void pc1() {
		
	}
	
	@After("pc1()")
	public void log(JoinPoint joinPoint) {
		
		HttpServletRequest req = null;
		HttpSession session = null;
		
		for (Object obj: joinPoint.getArgs()) {
			
			if (obj instanceof HttpServletRequest) {
				req = (HttpServletRequest)obj;
			} else if (obj instanceof HttpSession) {
				session = (HttpSession)obj;
			}
		}
	
		
		if (req != null && session != null) {
			
			Calendar now = Calendar.getInstance();
			
			System.out.printf("[LOG][%tF %tT - %s] %s\n"
									, now, now
									, session.getAttribute("auth") != null? session.getAttribute("auth") : "익명"
									, req.getRequestURI());
		}
	
	}
	
}
