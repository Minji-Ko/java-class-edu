package com.test.toy.etc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/etc/openapi02.do")
public class OpenAPI02 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String query = req.getParameter("query");
		String page = req.getParameter("page");
		
		//페이징
		int nowPage = 0;
		
		if(!(page == null || page.equals(""))) {
			nowPage = Integer.parseInt(page);
		} else {
			nowPage = 1;
		}
		
		int start = (nowPage - 1) * 10 + 1;
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("query", query);
		map.put("start", start + "");
		
		
		OpenAPIDAO dao = new OpenAPIDAO();

		ResultDTO rdto = null;
		
		if(!(query == null || query.equals(""))) {
			rdto = dao.search(map);

			rdto.setQuery(query);
			
			rdto.setTotalPage(String.valueOf((int)Math.ceil(Integer.parseInt(rdto.getTotal()) / 10.0)));
		}
		
		req.setAttribute("rdto", rdto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/etc/openapi02.jsp");

		dispatcher.forward(req, resp);
	}

}
