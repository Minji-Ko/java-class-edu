package com.test.member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/mypage.do")
public class Mypage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String memberSeq = ((MemberDTO)session.getAttribute("auth")).getSeq(); 
		
		MemberDAO dao = new MemberDAO();

		//회원 등급 정보
		String grade = dao.getGrade(memberSeq);
		
		//적립금 정보
		String point = dao.getPoint(memberSeq);
		
		//주문 진행현황 정보
		HashMap<String, Integer> map = dao.getProcess(memberSeq);
		
		
		req.setAttribute("grade", grade);
		req.setAttribute("map", map);
		req.setAttribute("point", point);
		req.setAttribute(memberSeq, point);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/member/mypage.jsp");

		dispatcher.forward(req, resp);
	}

}

