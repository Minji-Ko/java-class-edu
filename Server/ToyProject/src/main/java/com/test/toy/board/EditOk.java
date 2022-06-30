package com.test.toy.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 인코딩
		//2. 데이터 가져오기
		//3. DB 작업 > update
		//4. 결과
		//5. JSP 호출하기
		
		HttpSession session = req.getSession();
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		//2.
		String seq = req.getParameter("seq");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		//3.
		BoardDTO dto = new BoardDTO();
		dto.setSeq(seq);
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setId((String)session.getAttribute("auth"));
		
		
		BoardDAO dao = new BoardDAO();
		
		int result = 0;
		
		if((dto.getId() != null && dto.getId().equals("admin")) || dao.check(dto)) {
			result = dao.edit(dto);
		}
		
		
		
		//4.
		req.setAttribute("seq", seq);
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/editok.jsp");

		dispatcher.forward(req, resp);
	}

}

