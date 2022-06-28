package com.test.toy.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.toy.DBUtil;

public class MemberDAO {
	
	private Connection conn; 
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public MemberDAO() {
		conn = DBUtil.open();
	}

	//RegisterOk 서블릿 > dto > insert
	public int add(MemberDTO dto) {

		try {
			
			String sql = "insert into tblMember (id, pw, name, lv, pic, regdate) values (?, ?, ?, '1', ?, default)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getPic());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("MemberDAO.add");
			e.printStackTrace();
		}
		
		return 0;
	}
	//LoginOk 서블릿 > dto > 로그인 처리
	public MemberDTO login(MemberDTO dto) {

		try {
			
			String sql = "select * from tblMember where id = ? and pw = ? and active = 'y'";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				dto.setName(rs.getString("name"));
				dto.setLv(rs.getString("lv"));
				dto.setPic(rs.getString("pic"));
				dto.setRegdate(rs.getString("regdate"));
				
				return dto;
			} 

			
		} catch (Exception e) {
			System.out.println("MemberDAO.login");
			e.printStackTrace();
		}
		
		return null;
	}

	//Info 서블릿 > id > 회원 정보 반환
	public MemberDTO get(String id) {

	try {
			
			String sql = "select * from tblMember where id = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			MemberDTO dto = new MemberDTO();
			
			if (rs.next()) {
				
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setLv(rs.getString("lv"));
				dto.setPic(rs.getString("pic"));
				dto.setRegdate(rs.getString("regdate"));
				
				return dto;
			} 

			
		} catch (Exception e) {
			System.out.println("MemberDAO.login");
			e.printStackTrace();
		}
		
		return null;
	}

	public int unregister(String id) {

		try {
			
			String sql = "update tblMember set active = 'n', pw = 'not used', name = 'not used', lv = 0, pic = 'not used', regdate = sysdate where id = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("MemberDAO.unregister");
			e.printStackTrace();
		}
		
		return 0;
	}
}
















