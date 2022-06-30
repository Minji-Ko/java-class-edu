package com.test.toy.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/delok.do")
public class DelOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String seq = req.getParameter("seq");
		
		BoardDTO dto = new BoardDTO();
		dto.setSeq(seq);
		dto.setId((String)session.getAttribute("auth"));
		
		
		BoardDAO dao = new BoardDAO();
		
		int result = 0;
		
		if((dto.getId() != null && dto.getId().equals("admin")) || dao.check(dto)){
			
			dao.delCommentAll(seq);
			
			result = dao.del(seq);
			
			//두 작업은 Procedure를 만들어 한번에 처리
		}
		
		
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/delok.jsp");

		dispatcher.forward(req, resp);
	}

}

