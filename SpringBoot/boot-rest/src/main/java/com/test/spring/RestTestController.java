package com.test.spring;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {
//어노테이션과 클래스 이름이 중복되면 안됨!!
	
	@GetMapping("/fruit")
	@ResponseBody
	public List<String> list() {
		List<String> list = Arrays.asList("사과", "딸기", "바나나");
		
		return list;
	}
}
