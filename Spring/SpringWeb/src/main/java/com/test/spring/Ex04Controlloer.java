package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class Ex04Controlloer {
	
	@RequestMapping(value="/ex04.do")
	public String test() {
		
		return "ex04";
	}

	@RequestMapping(value="/ex04_1.do")
	public String test2() {
		
		return "ex03";
	}
	
	
	
	private SpringDAO dao;
	
	@RequestMapping(value="/list.do")  // /board/list.do
	public String list() {
		
		return "list";
	}
	@RequestMapping(value="/add.do")
	public String add() {
		
		return "add";
	}
	@RequestMapping(value="/addok.do", method=RequestMethod.POST) //웬만하면 생략하지 말고 GET과 POST를 구분!
	public String addok() {
		
		return "addok";
	}
	
	@RequestMapping(value="/edit.do", method=RequestMethod.GET)
	public String edit() {
		return "edit";
	}
	
	@RequestMapping(value="/editok.do", method=RequestMethod.POST)
	public String editok() {
		return "editok";
	}
	
	@GetMapping(value="/del.do")   //스프링 버전 5에서 가능
	public String del() {
		return "del";
	}
	
	@PostMapping(value="/delok.do")
	public String delok() {
		return "delok";
	}
}
