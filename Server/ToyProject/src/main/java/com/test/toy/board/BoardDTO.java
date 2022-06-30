package com.test.toy.board;

import lombok.Data;

@Data
public class BoardDTO {

	private String seq;
    private String subject;
    private String content;
    private String id;
    private String regdate;
    private String readcount;
    private int thread;
    private int depth;
    
    private String name;
    private String commentcount;
    
}
