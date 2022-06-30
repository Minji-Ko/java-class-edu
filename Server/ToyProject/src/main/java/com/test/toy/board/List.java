package com.test.toy.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doList(req, resp);
	}

	/*
	 * @Override 
	 * protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 *  	doList(req, resp); 
	 * }
	 */
	
	private void doList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		//1. DB작업 > DAO 위임 > select
		//2. 결과
		//3. JSP 호출하기 + 결과 전달하기
		
		//그냥 목록? vs 검색 결과?
		//- list.do
		//- list.do + (column + word)
		req.setCharacterEncoding("UTF-8");
		
		
		String column = req.getParameter("column");
		String word = req.getParameter("word");
		
		String isSearch = "n";
		
		if((column == null || word == null)
				||(column == "" || word == "")) {
			isSearch = "n";
		} else {
			isSearch = "y";
		}

		//System.out.println(isSearch);
		
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("column", column);
		map.put("word", word);
		map.put("isSearch", isSearch);
		
		
		
		//페이징
		int nowPage = 0; //현재 페이지 번호
		int pageSize = 10; //한페이지당 출력할 게시물 수
		int begin = 0;
		int end = 0;
		int totalCount = 0;
		int totalPage = 0;
		
		String page = req.getParameter("page");
		if(page == null || page == "") nowPage = 1;
		else nowPage = Integer.parseInt(page);
		
		begin = ((nowPage-1) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		map.put("begin", begin + "");
		map.put("end", end + "");
		
		
		//1 + 2. 
		BoardDAO dao = new BoardDAO();
		
		ArrayList<BoardDTO> list = dao.list(map);
		
		
		//2.5 출력 데이터 가공 업무
		Calendar now = Calendar.getInstance();
		String strNow = String.format("%tF", now);

		
		for(BoardDTO dto : list) {
			
			//오늘 날짜는 시간출력
			if(dto.getRegdate().startsWith(strNow)) {
				dto.setRegdate(dto.getRegdate().substring(11, 16));
			} else {
				dto.setRegdate(dto.getRegdate().substring(0, 10));
			}
			
			//제목 길이 자르기
			if(dto.getSubject().length() > 20) {
				dto.setSubject(dto.getSubject().substring(0, 20) + "...");
			}
			
			//태그 비활성화
			dto.setSubject(dto.getSubject().replace("<", "&lt;").replace(">", "&gt;"));
		}
		
		
		//2.6 총 페이지 수 구하기
		totalCount = dao.getTotalCount(map);
		totalPage = (int) Math.ceil((double)totalCount/pageSize);
		
		String pagebar = "";
		int blockSize = 10; //한번에 보여질 페이지 개수
		int n = 0;			//페이지 번호
		int loop = 0;
		
		n= ((nowPage-1) / blockSize) * blockSize + 1;
		loop = 1;
		
//		for(n = 1; n<=totalPage; n++) {
//			
//			if(n == nowPage) {
//				pagebar += String.format(" <a href='#!' style='color: cornflower;'>%d</a> "
//						, n, column, word, n);
//			} else {
//				pagebar += String.format(" <a href='/toy/board/list.do?page=%d&column=%s&word=%s'>%d</a> "
//						, n, column, word, n);
//			}
//		}
		
		
		
		
		pagebar += "<ul class=\"pagination justify-content-center\">";
		
		pagebar += String.format("<li class=\"page-item\">\r\n"
				+ "	      <a class=\"page-link\" href=\"/toy/board/list.do?page=%d&column=%s&word=%s\" aria-label=\"Previous\">\r\n"
				+ "	        <span aria-hidden=\"true\">&laquo;</span>\r\n"
				+ "	      </a>\r\n"
				+ "	    </li>"
				, 1, column==null?"":column, word==null?"":word);
		
		//이전 10페이지
		if (n == 1) {
			pagebar += " <li class=\"page-item\">\r\n"
					+ "		      <a class=\"page-link\" href=\"#!\" aria-label=\"Previous\">\r\n"
					+ "		        <span aria-hidden=\"true\">&laquo;</span>\r\n"
					+ "		      </a>\r\n"
					+ "		    </li>";
		} else {
			pagebar += String.format("<li class=\"page-item\">\r\n"
					+ "	      <a class=\"page-link\" href=\"/toy/board/list.do?page=%d&column=%s&word=%s\" aria-label=\"Previous\">\r\n"
					+ "	        <span aria-hidden=\"true\">&laquo;</span>\r\n"
					+ "	      </a>\r\n"
					+ "	    </li>"
					, n-1, column==null?"":column, word==null?"":word);
		}
		
		
		while (!(loop > blockSize || n > totalPage)) {
			
			if(n == nowPage) {
				pagebar += String.format(" <li class=\"page-item active\"><a class=\"page-link\" href=\"#!\">%d</a></li>"
						, n);
			} else {
				pagebar += String.format("<li class=\"page-item\"><a class=\"page-link\" href=\"/toy/board/list.do?page=%d&column=%s&word=%s\">%d</a></li>"
						, n, column==null?"":column, word==null?"":word, n);
			}
			
			loop ++;
			n++;
		}
//		while (!(loop > blockSize || n > totalPage)) {
//			
//			if(n == nowPage) {
//				pagebar += String.format(" <a href='#!' class='badge badge-pill badge-primary' style='color: white; font-size: 14px;'>%d</a> "
//						, n, column, word, n);
//			} else {
//				pagebar += String.format(" <a href='/toy/board/list.do?page=%d&column=%s&word=%s'>%d</a> "
//						, n, column==null?"":column, word==null?"":word, n);
//			}
//			
//			loop ++;
//			n++;
//		}
		
		
		
	    
		
		//다음 10페이지
		if(n > totalPage) {
			pagebar += "<li class=\"page-item\">\r\n"
					+ "	      <a class=\"page-link\" href=\"#!\" aria-label=\"Next\">\r\n"
					+ "	        <span aria-hidden=\"true\">&raquo;</span>\r\n"
					+ "	      </a>\r\n"
					+ "	    </li>";
		} else {
			pagebar += String.format("    <li class=\"page-item\">\r\n"
					+ "	    <a class=\"page-link\" href=\"/toy/board/list.do?page=%d&column=%s&word=%s\" aria-label=\"Next\">\r\n"
					+ "	    <span aria-hidden=\"true\">&raquo;</span>\r\n"
					+ "	    </a>\r\n"
					+ "	    </li>"
					, n, column==null?"":column, word==null?"":word);
		}
		
		pagebar += String.format("    <li class=\"page-item\">\r\n"
				+ "	    <a class=\"page-link\" href=\"/toy/board/list.do?page=%d&column=%s&word=%s\" aria-label=\"Next\">\r\n"
				+ "	    <span aria-hidden=\"true\">&raquo;</span>\r\n"
				+ "	    </a>\r\n"
				+ "	    </li>"
				, totalPage, column==null?"":column, word==null?"":word);
		
		pagebar += "</ul>";
		
		
		//2.7 새로고침으로 인한 조회수 증가 방지
		session.setAttribute("readcount", "n");
		
		//3.
		req.setAttribute("map", map);
		req.setAttribute("list", list);
		req.setAttribute("page", nowPage);
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("pagebar", pagebar);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/list.jsp");

		dispatcher.forward(req, resp);
	}

}
