package com.test.member;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import com.test.DBUtil;

import oracle.jdbc.OracleTypes;

public class MemberDAO {

	Connection conn;
	Statement stat;
	PreparedStatement pstat;
	CallableStatement cstat;
	ResultSet rs;
	
	public MemberDAO() {
		conn = DBUtil.open();
	}
	
	public static void main(String[] args) {
		
		MemberDAO dao = new MemberDAO();
		
	}

	public int join(MemberDTO dto) {

		try {
			String sql = "{ call procJoin(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
			
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, dto.getId());
			cstat.setString(2, dto.getPw());
			cstat.setString(3, dto.getName());
			cstat.setString(4, dto.getAddress());
			cstat.setString(5, dto.getTel());
			cstat.setString(6, dto.getSmsConsent());
			cstat.setString(7, dto.getEmail());
			cstat.setString(8, dto.getEmailConsent());
			cstat.setString(9, dto.getSolarLunar());
			cstat.setString(10, dto.getBirthdate());
			cstat.setString(11, dto.getFootSize());
			cstat.registerOutParameter(12, OracleTypes.NUMBER);
			
			cstat.executeQuery();
			
			return cstat.getInt(12);
			
		} catch (Exception e) {
			System.out.println("MemberDAO.join");
			e.printStackTrace();
		}
		return 0;
	}

	public Object login(MemberDTO dto) {
		
		try {
			String sql = "select * from tblMember where id = ? and pw = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				dto.setPw(null);
				dto.setName(rs.getString("name"));
				dto.setSeq(rs.getString("seq"));
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println("MemberDAO.login");
			e.printStackTrace();
		}
		
		return null;
	}

	public String getPoint(String memberSeq) {
		
		try {
			
			String sql = "select sum(point) as point from tblPoint where memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, memberSeq);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				return rs.getString("point");
			}
			
		} catch (Exception e) {
			System.out.println("MemberDAO.getPoint");
			e.printStackTrace();
		}
		
		return null;
	}

	public HashMap<String, Integer> getProcess(String memberSeq) {

		try { 
			
			String sql = "{ call procOrderProcess( ?, ?, ?, ?, ?, ? ) }";
			
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, memberSeq);
			cstat.registerOutParameter(2, OracleTypes.NUMBER);
			cstat.registerOutParameter(3, OracleTypes.NUMBER);
			cstat.registerOutParameter(4, OracleTypes.NUMBER);
			cstat.registerOutParameter(5, OracleTypes.NUMBER);
			cstat.registerOutParameter(6, OracleTypes.NUMBER);
			
			cstat.executeQuery();

			HashMap<String, Integer> map = new HashMap<String, Integer>();
			
			map.put("paid", cstat.getInt(2));
			map.put("ready", cstat.getInt(3));
			map.put("delivering", cstat.getInt(4));
			map.put("delivered", cstat.getInt(5));
			map.put("refund", cstat.getInt(6));
			
			return map;
			
		} catch (Exception e) {
			System.out.println("MemberDAO.getPoint");
			e.printStackTrace();
		}
		
		return null;
	}

	public String getGrade(String memberSeq) {

		try {
			
			String sql = "select g.name as grade from tblGrade g inner join tblMember m on g.seq = m.gradeSeq where m.seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, memberSeq);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				return rs.getString("grade");
			}
			
		} catch (Exception e) {
			System.out.println("MemberDAO.getGrade");
			e.printStackTrace();
		}
		
		return null;
	}
}
