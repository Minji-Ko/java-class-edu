package com.test.toy.board;

import java.io.File;
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
		String column = req.getParameter("column");
		String word = req.getParameter("word");
		
		BoardDTO dto = new BoardDTO();
		dto.setSeq(seq);
		dto.setId((String)session.getAttribute("auth"));
		
		
		BoardDAO dao = new BoardDAO();
		
		int result = 0;
		
		if((dto.getId() != null && dto.getId().equals("admin")) || dao.check(dto)){
			
			//댓글 삭제
			dao.delCommentAll(seq);
			
			
			//첨부 파일 삭제
			dto = dao.get(seq);
			
			if(dto.getFilename() != null) {
				String path = req.getRealPath("/files") +"\\" + dto.getFilename();
				File file = new File(path);
				file.delete();
			}
			
			//해시 태그 삭제
			dao.delTags(seq);
			
			dao.gelGoodBad(seq);
			
			result = dao.del(seq);
			
			//두 작업은 Procedure를 만들어 한번에 처리
		}
		
		
		req.setAttribute("result", result);
		req.setAttribute("column", column);
		req.setAttribute("word", word);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/delok.jsp");

		dispatcher.forward(req, resp);
	}

}

