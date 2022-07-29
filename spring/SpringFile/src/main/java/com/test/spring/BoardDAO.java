package com.test.spring;

import java.util.List;

public interface BoardDAO {

	public List<BoardDTO> list();

	public List<FileDTO> flist(String seq);

	public int add(String title);

	public int geSeq();

	public void addFile(FileDTO fdto);

}
