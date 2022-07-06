package com.test.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String skey = req.getParameter("skey");
		String svalue = req.getParameter("svalue");
		
		
		BoardDAO dao = new BoardDAO();
		
		//페이지바
		int qnaSize = dao.getPages();
		int pageQnaSize = 8;
		int lastPage = (int)Math.ceil((double)qnaSize / pageQnaSize);
		
		String reqPage = req.getParameter("page");

		int page = 1;
		if(reqPage == null || reqPage.equals("0")) {
			page = 1;
		} else if (reqPage.equals(lastPage + 1 + "")) {
			page = lastPage;			
		} else {
			page = Integer.parseInt(reqPage);
		}
		
		int pagebarSize = 10;
		int pagebarBegin = ((page - 1)/pagebarSize) * pagebarSize + 1;
		int pagebarEnd = pagebarBegin + pagebarSize - 1;
		if (pagebarEnd > lastPage) { pagebarEnd = lastPage; }
		
		int beginQna = (page - 1) * pageQnaSize + 1;
		if (beginQna < 0 || beginQna > qnaSize) { beginQna = 1;}
		
		int endQna = beginQna + pageQnaSize - 1;
		if(endQna > qnaSize) { endQna = qnaSize; }
		
		
		//목록 출력 
		ArrayList<QnaDTO> list = dao.getlist(beginQna, endQna);
		
		if (list != null) {
			for (QnaDTO dto : list) {
				if (dto.getHeader().length() > 33) {
					dto.setHeader(dto.getHeader().substring(0, 33) + " . . .");
				}
			}
		}
		
		
		req.setAttribute("page", page);
		req.setAttribute("pagebarBegin", pagebarBegin);
		req.setAttribute("pagebarEnd", pagebarEnd);
		req.setAttribute("lastPage", lastPage);
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/board/list.jsp");

		dispatcher.forward(req, resp);
	}

}
