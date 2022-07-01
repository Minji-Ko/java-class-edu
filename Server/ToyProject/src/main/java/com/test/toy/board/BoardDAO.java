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
			
			String sql = "insert into tblBoard(seq, subject, content, id , regdate, readcount, thread, depth, filename, orgfilename) values (seqBoard.nextVal, ?, ?, ?, default, default, ?, ?, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getId());
			pstat.setInt(4, dto.getThread());
			pstat.setInt(5, dto.getDepth());
			pstat.setString(6, dto.getFilename());
			pstat.setString(7, dto.getOrgfilename());
			
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
			String sql = "";
			
			
			if(map.get("tag") == null) {
				if(map.get("isSearch").equals("y")) {
					where = String.format("where %s like '%%%s%%'"
							, map.get("column")
							, map.get("word"));
				}
				
				sql = String.format("select * from (select b.*, rownum as rnum from vwBoard b %s) where rnum between %s and %s ", where, map.get("begin"), map.get("end"));
				
			} else {
				
				sql = String.format("select b.* from tblBoard b \r\n"
						+ "    inner join  tblTagging t on t.bseq = b.seq\r\n"
						+ "    inner join tblHashTag h on h.seq = t.hseq\r\n"
						+ "        where h.tag = '%s'", map.get("tag"));
			}
			
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
				dto.setDepth(rs.getInt("depth"));
				dto.setCommentcount(rs.getString("commentcount"));
				dto.setIsNew(rs.getDouble("isnew"));
				dto.setFilename(rs.getString("filename"));
				
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
				
				dto.setFilename(rs.getString("filename"));
				dto.setOrgfilename(rs.getString("orgfilename"));
			}
					
			
			//해시태그
			sql = "select tag from tblHashTag h inner join  tblTagging t on h.seq = t.hseq where bseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			dto.setTaglist(new ArrayList<String>());
			
			while (rs.next()) {
				dto.getTaglist().add(rs.getString("tag"));
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
			
			String sql = "update tblBoard set subject = ?, content = ?, filename= ?, orgfilename = ? where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getFilename());
			pstat.setString(4, dto.getOrgfilename());
			pstat.setString(5, dto.getSeq());
			
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

	//AddOk 서블릿 > 방금 작성한 글번호 주세요~
	public String getSeq() {

		try {
			//안정성 높은 코드
			//99.9%의 사이트에서 문제없이 작동함 
			String sql = "select max(seq) as seq from tblBoard";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getString("seq");
			}
			
			
		} catch (Exception e) {
			System.out.println("BoardDAO.getSeq");
			e.printStackTrace();
		}
		
		return null;
	}

	
	public void addHashTag(String tag) {
		try {
			String sql = "insert into tblHashTag (seq, tag) values (seqHashTag.nextVal, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, tag);
			
			pstat.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("BoardDAO.addHashTag");
			e.printStackTrace();
		}
	}

	public String getHashTagSeq(String tag) {
		
		try {
			
			String sql = "select seq from tblHashTag where tag= ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, tag);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				return rs.getString("seq");
			}
			
			
		} catch (Exception e) {
			System.out.println("BoardDAO.getSeq");
			e.printStackTrace();
		}
		
		
		return null;
	}

	public void addTagging(HashMap<String, String> map) {
		try {
			String sql = "insert into tblTagging (seq, bseq, hseq) values (seqTagging.nextVal, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, map.get("bseq"));
			pstat.setString(2, map.get("hseq"));
			
			pstat.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("BoardDAO.addHashTag");
			e.printStackTrace();
		}
	}

	public void delTags(String seq) {

		try {
			String sql = "delete from tblTagging where bseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("BoardDAO.delTags");
			e.printStackTrace();
		}
	}

	public ArrayList<String> taglist() {
		
		try {
			
			String sql = "select * from tblHashTag order by tag asc";
			
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			
			ArrayList<String> list = new ArrayList<String>();
			
			while(rs.next()) {
				list.add(rs.getString("tag"));
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("BoardDAO.taglist");
			e.printStackTrace();
		}
		
		return null;
	}
}


















