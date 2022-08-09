package com.test.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class BoardController {

	private BoardService service;
	
	@Autowired
	public BoardController(BoardService service) {
		this.service = service;
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		
		List<BoardDTO> list = service.list();
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@GetMapping(value="/write")
	public String write() {
		return "write";
	}
	
	@PostMapping(value="/writeok")
	public String writeok(MultipartHttpServletRequest multi, Model model) {
		
		int result = service.writeok(multi);
		
		model.addAttribute("result", result);
		
		return "writeok";
	}
}
