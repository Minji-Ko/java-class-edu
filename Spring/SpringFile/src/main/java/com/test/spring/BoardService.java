package com.test.spring;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {

	public List<BoardDTO> list();

	public int writeok(MultipartHttpServletRequest multi); 

}
