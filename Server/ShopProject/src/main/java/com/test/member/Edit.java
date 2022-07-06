package com.test.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String seq = ((MemberDTO)session.getAttribute("auth")).getSeq();
		
		
		MemberDAO dao = new MemberDAO();
		
		MemberDTO dto = dao.getProfile(seq);
		
		if(dto.getBirthdate() != null) {
			dto.setBirthdate(dto.getBirthdate().substring(0, 10));
		}
			
		req.setAttribute("dto", dto);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/member/edit.jsp");

		dispatcher.forward(req, resp);
	}

}
