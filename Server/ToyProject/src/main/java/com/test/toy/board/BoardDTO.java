package com.test.toy.board;

import java.util.ArrayList;

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
    private double isNew;
    
    private String filename;
    private String orgfilename;
    
    private ArrayList<String> taglist;
    
    private String good;
    private String bad;
    private String goodbad;
    
}
