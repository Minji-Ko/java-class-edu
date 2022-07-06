package com.test.board;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.DBUtil;

public class BoardDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;

	public BoardDAO() {
		conn = DBUtil.open();
	}

	public ArrayList<QnaDTO> getlist(int beginQna, int endQna) {

		try {
			
			String sql = String.format("select * from (select vwQna.*, rownum as rnum from vwQna) where rnum between %d and %d"
									, beginQna, endQna);
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			ArrayList<QnaDTO> list = new ArrayList<QnaDTO>();
			
			while (rs.next()) {
				QnaDTO dto = new QnaDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setAnswerSeq(rs.getString("answerseq"));
				dto.setHeader(rs.getString("header"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setId(rs.getString("id"));
				dto.setSecret(rs.getString("secret"));
				dto.setIsNew(rs.getString("isnew"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("BoardDAO.getlist");
			e.printStackTrace();
		}
		
		return null;
	}

	public int getPages() {
		
		try {
			
			String sql = "select count(*) as cnt from vwQna";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("BoardDAO.getPages");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	

}
