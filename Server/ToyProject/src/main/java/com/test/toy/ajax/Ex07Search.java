package com.test.toy.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/ex07search.do")
public class Ex07Search extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String gender = req.getParameter("gender"); //m, f, all
		
		AjaxDAO dao = new AjaxDAO();
		
		ArrayList<AddressDTO> list = dao.getAddress(gender);
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
				
		PrintWriter writer = resp.getWriter();
		
		StringBuilder str = new StringBuilder();
		
		str.append('[');
		for(int i=0; i<list.size(); i++) {
			AddressDTO dto = list.get(i);
			
			str.append('{');
			str.append("\"seq\": \"").append(dto.getSeq()).append("\",");
			str.append("\"name\": \"").append(dto.getName()).append("\",");
			str.append("\"age\": \"").append(dto.getAge()).append("\",");
			str.append("\"gender\": \"").append(dto.getGender().equals("f") ? "여자": "남자").append("\",");
			str.append("\"tel\": \"").append(dto.getTel()).append("\",");
			str.append("\"address\": \"").append(dto.getAddress()).append("\"");
			str.append('}');
			
			if(i < list.size()-1) { str.append(','); }
		}
		str.append(']');
		
		writer.print(str);
		
		writer.close();
		
	}

}
