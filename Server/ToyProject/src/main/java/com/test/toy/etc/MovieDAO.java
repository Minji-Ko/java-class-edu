package com.test.toy.etc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.test.toy.DBUtilHr;

public class MovieDAO {

	private Connection conn;
	private PreparedStatement pstat;
	
	public MovieDAO() {
		conn = DBUtilHr.open();
	}

	public int addMovie(MovieDTO dto) {
		
		try {
			String sql = "insert into tblMovie values (seqMovie.nextVal, ?, ?, ?, ?, ?, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getCategory());
			pstat.setString(3, dto.getTime());
			pstat.setString(4, dto.getRdate());
			pstat.setString(5, dto.getDirector());
			pstat.setString(6, dto.getActor());
			pstat.setString(7, dto.getPoster());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("MovieDAO.addMovie");
			e.printStackTrace();
		}
		
		return 0;
	}
}
