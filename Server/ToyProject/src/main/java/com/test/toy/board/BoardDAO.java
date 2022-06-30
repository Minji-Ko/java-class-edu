package com.test.toy.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.toy.DBUtil;

public class BoardDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public BoardDAO() {
		conn = DBUtil.open();
	}

	//Add 서블릿 > dto > 글쓰기
	public int add(BoardDTO dto) {

		try {
			
			String sql = "insert into tblBoard(seq, subject, content, id , regdate, readcount, thread, depth) values (seqBoard.nextVal, ?, ?, ?, default, default, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getId());
			pstat.setInt(4, dto.getThread());
			pstat.setInt(5, dto.getDepth());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("BoardDAO.add");
			e.printStackTrace();
		}
		
		return 0;
	}

	//List 서블릿 > 목록 주세요
	public ArrayList<BoardDTO> list(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if(map.get("isSearch").equals("y")) {
				where = String.format("where %s like '%%%s%%'"
											, map.get("column")
											, map.get("word"));
			}
			
			String sql = String.format("select * from (select b.*, rownum as rnum from vwBoard b %s) where rnum between %s and %s ", where, map.get("begin"), map.get("end"));
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
			
			while(rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcount(rs.getString("readcount"));
				dto.setCommentcount(rs.getString("commentcount"));
				
				dto.setDepth(rs.getInt("depth"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("BoardDAO.list");
			e.printStackTrace();
		}
		
		return null;
	}

	//View 서블릿 > seq > DTO 주세요.
	public BoardDTO get(String seq) {

		try {
			
			String sql = "select * from vwBoard where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			BoardDTO dto = new BoardDTO();
			
			if(rs.next()) {
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcount(rs.getString("readcount"));
				
				dto.setThread(rs.getInt("thread"));
				dto.setDepth(rs.getInt("depth"));
			}
					
			return dto;	
			
		} catch (Exception e) {
			System.out.println("BoardDAO.get");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void updateReadcount(String seq) {

		try {
			String sql = "update tblBoard set readcount = readcount + 1 where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("BoardDAO.updateReadcount");
			e.printStackTrace();
		}
	}

	//EditOk 서블릿 > dto > 수정해주세요~
	public int edit(BoardDTO dto) {
		
		try {
			
			String sql = "update tblBoard set subject = ?, content = ? where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("BoardDAO.edit");
			e.printStackTrace();
		}
		
		return 0;
	}

	//DelOk 서블릿 > seq > 삭제해주세요~
	public int del(String seq) {

		try {
			
			String sql = "delete from tblBoard where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("BoardDAO.del");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	//EditOk 서블릿 > dto 
	public boolean check(BoardDTO dto) {

		try {
			
			String sql = "select count(*) as cnt from tblBoard where seq = ? and id = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getSeq());
			pstat.setString(2, dto.getId());
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt("cnt") == 1) {
					return true;
				}
			}
			
		} catch (Exception e) {
			System.out.println("BoardDAO.check");
			e.printStackTrace();
		}
		
		return false;
	}

	public int addcomment(CommentDTO dto) {
		
		try {
			
			String sql = "insert into tblComment(seq, content, id, regdate, pseq) values (seqComment.nextVal, ?, ?, default, ?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getComment());
			pstat.setString(2, dto.getId());
			pstat.setString(3, dto.getPseq());
			
			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("BoardDAO.addcomment");
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<CommentDTO> listComment(String seq) {

		try {
			
			
			
			String sql = "select tblComment.*, (select name from tblMember where id = tblComment.id) as name from tblComment where pseq = ? order by regdate desc";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			ArrayList<CommentDTO> clist = new ArrayList<CommentDTO>();
			
			while(rs.next()) {
				
				CommentDTO dto = new CommentDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setComment(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate"));
				
				clist.add(dto);
			}
		
			return clist;
			
		} catch (Exception e) {
			System.out.println("BoardDAO.listComment");
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public static void main(String[] args) {
		
		BoardDAO dao = new BoardDAO();
		
		ArrayList<CommentDTO> dto = dao.listComment("8");
		
		for(CommentDTO d : dto) {
			System.out.println(d);
		}
	}

	//DelCommentOk > seq > 삭제
	public int delComment(String seq) {
		
		try {
			String sql = "delete from tblComment where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("BoardDAO.delcomment");
			e.printStackTrace();
		}
		
		return 0;
	}

	public int editComment(CommentDTO dto) {
		
		try {
			String sql = "update tblComment set content = ? where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getComment());
			pstat.setString(2, dto.getSeq());
			
			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("BoardDAO.delcomment");
			e.printStackTrace();
		}
		
		
		return 0;
	}

	//DelOk 서블릿 > 부모글 번호 > 달린 댓글들을 모두 삭제해주세요~
	public void delCommentAll(String seq) {
		
		try {
			String sql = "delete from tblComment where pseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("BoardDAO.delcomment");
			e.printStackTrace();
		}
		
	}

	public int getTotalCount(HashMap<String, String> map) {


		try {
		
			String where = "";
			
			if(map.get("isSearch").equals("y")) {
				where = String.format("where %s like '%%%s%%'"
											, map.get("column")
											, map.get("word"));
			}
			
			String sql = "select count(*) as cnt from tblBoard " + where;
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
		
		} catch (Exception e) {
			System.out.println("BoardDAO.check");
			e.printStackTrace();
		}
			
		return 0;
	}
	
	
	public int gatMaxThread() {
		
		try {
			
			String sql = "select nvl(max(thread), 0) as thread from tblBoard";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getInt("thread");
			}
			
		} catch (Exception e) {
			System.out.println("BoardDAO.gatMaxThread");
			e.printStackTrace();
		}
		
		return 0;
	}

	//AddOk 서블릿 > thread 업데이트~
	public void updateThread(HashMap<String, Integer> map) {

		try {
			String sql = "update tblBoard set thread = thread - 1 where thread > ? and thread < ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, map.get("previousThread"));
			pstat.setInt(2, map.get("parentThread"));
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("BoardDAO.updateThread");
			e.printStackTrace();
		}
	}
	
}


















