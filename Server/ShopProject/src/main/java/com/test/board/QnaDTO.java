package com.test.board;

import lombok.Data;

@Data
public class QnaDTO {

	private String seq;
	private String answerSeq;
	private String id;
	private String header;
	private String content;
	private String regdate;
	private String secret;
	
	private String isNew;
	
}
