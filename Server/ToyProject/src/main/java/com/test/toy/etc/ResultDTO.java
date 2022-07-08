package com.test.toy.etc;

import java.util.ArrayList;
import lombok.Data;

@Data
public class ResultDTO {
	
	private String query;
	private String total;
	private ArrayList<BookDTO> list;
	private String totalPage;
}
