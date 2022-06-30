package com.test.toy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

public class Dummy {

	public static void main(String[] args) {
		
		//게시글 더미 생성하기
		boardAdd();
		
	}

	private static void boardAdd() {
		
		String sql = "insert into tblBoard(seq, subject, content, id , regdate, readcount) values (seqBoard.nextVal, ?, ?, ?, default, default)";
			
		
		//시드 데이터
		String[] subject = {"안녕~", "가입했습니다!", "안녕하세요", "안녕하세용", "가입이여~", "저 가입했습니다.", "열심히 활동할게요", "게시판 첫 글이에요", "반가워요"};
		
		String content = "안녕하세요!";
		
		String[] id = {"hong", "area", "hoho", "test"};
		
		Connection conn = null;
		PreparedStatement pstat = null;
		
		try {
			conn = DBUtil.open();
			pstat = conn.prepareStatement(sql);
			
			Random rnd = new Random();
			
			
			for(int i=0; i<256; i++) {
				pstat.setString(1, subject[rnd.nextInt(subject.length)]);
				pstat.setString(2, content);
				pstat.setString(3, id[rnd.nextInt(id.length)]);
				
				pstat.executeUpdate();
			}
			
			System.out.println("완료");
			
			
		} catch (Exception e) {
			System.out.println("Dummy.boardAdd");
			e.printStackTrace();
		}
		
	}
	
	
	
}
