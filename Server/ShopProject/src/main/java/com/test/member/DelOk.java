package com.test.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/delok.do")
public class DelOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		HttpSession session = req.getSession();
		
		String seq = ((MemberDTO)session.getAttribute("auth")).getSeq();
		String id = ((MemberDTO)session.getAttribute("auth")).getId();
		String pw = req.getParameter("pw");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPw(pw);
		
		MemberDAO dao = new MemberDAO();
		
		int result = 0;
		
		if (dao.checkPw(dto)) {
			result = dao.delAccount(seq);
		}
		
		if (result == 1) {
			session.invalidate();
		}
		
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/member/delok.jsp");

		dispatcher.forward(req, resp);
	}

}

