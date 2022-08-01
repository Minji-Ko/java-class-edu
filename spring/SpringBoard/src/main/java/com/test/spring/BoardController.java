package com.test.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

	private BoardService service;
	
	@Autowired
	public BoardController(BoardService service) {
		this.service = service;
	}
	
	@GetMapping(value="/test")
	public String test() {
		
		System.out.println("test");
		
		return "test";
	}
	
	@GetMapping(value="/list")
	public String list(HttpSession session, HttpServletRequest req, HttpServletResponse resp, Model model) {
		
		List<BoardDTO> list = service.list();
		
		model.addAttribute("list", list);
		
		return "list";
	}

	@GetMapping(value="/login")
	public String login(HttpSession session, HttpServletRequest req, HttpServletResponse resp, String id) {
		
		session.setAttribute("auth", id);
		
		return "redirect:/list";
	}
	
	@GetMapping(value="/logout")
	public String logout(HttpSession session, HttpServletRequest req, HttpServletResponse resp) {
		
		session.removeAttribute("auth");
		
		return "redirect:/list";
	}

	@GetMapping(value="/add")
	public String add(HttpSession session, HttpServletRequest req, HttpServletResponse resp) {
		
		return "add";
	}
	
	@PostMapping(value="/addok")
	public void addok(HttpSession session, HttpServletRequest req, HttpServletResponse resp, BoardDTO dto) {
		
		dto.setId((String)session.getAttribute("auth"));
		
		int result = service.add(dto);
		
		try {
			if (result == 1) {
				resp.sendRedirect("/spring/list");
			} else {
				resp.sendRedirect("/spring/add");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping(value="/view")
	public String view(HttpSession session, HttpServletRequest req, HttpServletResponse resp, Model model, String seq) {
		
		BoardDTO dto = service.get(seq);
		
		model.addAttribute("dto", dto);
		
		return "view";
	}
	
	
}
