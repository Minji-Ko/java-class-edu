package com.test.toy.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기(seq)
		//2. DB 작업 > DAO 위임 > select
		//3. 결과
		//4. JSP 호출하기 + 결과 전달하기
		
		HttpSession session = req.getSession();
		
		//1.
		String seq = req.getParameter("seq");
		String column = req.getParameter("column");
		String word = req.getParameter("word");
		
		
		//2 + 3
		BoardDAO dao = new BoardDAO();
		
		//3.2 죄회수 증가
		if(session.getAttribute("readcount") == null ||
			session.getAttribute("readcount").toString().equals("n")) {
			dao.updateReadcount(seq);
			session.setAttribute("readcount", "y");
		}
		
		BoardDTO dto = dao.get(seq);
		
		//3.5. 
		// 태그비활성화 > 원본은 그대로 저장해야하기에!!!! 출력시 조작
		dto.setSubject(dto.getSubject().replace("<", "&lt;").replace(">", "&gt;"));
		dto.setContent(dto.getContent().replace("<", "&lt;").replace(">", "&gt;"));
		
		// 출력 데이터 조작하기
		dto.setContent(dto.getContent().replace("\r\n","<br>"));

		//- 검색어 표시하기
		if(column != null && column.equals("content")) {
			dto.setContent(dto.getContent().replace(word, "<span style=\"background-color:yellow;font-weight:bold;\">" + word + "</span>"));
		}
		
		
		//3.7 댓글 목록 가져오기
		ArrayList<CommentDTO> clist = dao.listComment(seq);
		
		for (CommentDTO cdto : clist) {
			cdto.setComment(cdto.getComment().replace("\r\n", "<br>"));
		}
		
		
		req.setAttribute("dto", dto);
		req.setAttribute("column", column);
		req.setAttribute("word", word);
		
		req.setAttribute("clist", clist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/view.jsp");

		dispatcher.forward(req, resp);
	}

}
