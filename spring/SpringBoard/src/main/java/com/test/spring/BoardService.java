package com.test.spring;

import java.util.List;

public interface BoardService {

	List<BoardDTO> list();

	int add(BoardDTO dto);

	BoardDTO get(String seq);

}
