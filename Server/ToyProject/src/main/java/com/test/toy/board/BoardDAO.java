package com.test.toy.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.toy.DBUtil;
import com.test.toy.etc.ChartDTO01;
import com.test.toy.etc.ChartDTO02;
import com.test.toy.etc.ChartDTO03;

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

		return getService(seq, "");
	}
	
	public BoardDTO get(BoardDTO dto) {
		return getService(dto.getSeq(), dto.getId());
	}

	private BoardDTO getService(String seq, String id) {
	
		try {
			
			String sql = "select vwBoard.*,"
					+ " nvl((select sum(good) from tblGoodBad where bseq = vwBoard.seq), 0) as good,"
					+ " nvl((select sum(bad) from tblGoodBad where bseq = vwBoard.seq), 0) as bad,"
					+ " (select case \r\n"
					+ "        when good = 1 then 1\r\n"
					+ "        when bad = 1 then 2\r\n"
					+ "        else 3\r\n"
					+ "    end\r\n"
					+ "    from tblGoodBad where bseq = vwBoard.seq and id= ?) as goodbad "
					+ "from vwBoard where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			pstat.setString(2, seq);
			
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
				
				dto.setGood(rs.getString("good"));
				dto.setBad(rs.getString("bad"));
				dto.setGoodbad(rs.getString("goodbad"));
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
			
			
		} catch (java.sql.SQLIntegrityConstraintViolationException e) {
			System.out.println("이미 있는 태그명입니다.");
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

	//GoodBad 서블릿 > dto > 좋아요/싫어요 반영해주세요.
	public int updateGoodBad(GoodBadDTO dto) {

		try {
			//참여(x) > 참여(o)
			//참여(o) > 같은 항목 참여 > 취소!!
			//참여(o) > 다른 항목 참여 > 변경!!
			
			int state = 0;
			String good = "";
			String bad = "";
			String seq = "";
			
			String sql = "select * from tblGoodBad where bseq = ? and id = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getBseq());
			pstat.setString(2, dto.getId());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				if(!dto.getGood().equals(rs.getString("good"))) {
					state = 2;
					seq = rs.getString("seq");
					good = dto.getGood();
					bad = dto.getBad();
					
				} else  {
					state = 3;
					seq = rs.getString("seq");
				}
				
			} else {
				state = 1;
			}
			
			rs.close();
			pstat.close();
			
			if(state == 1) {
				sql = "insert into tblGoodBad (seq, id, bseq, good, bad) values (seqGoodBad.nextVal, ?, ?, ?, ?)";
				
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, dto.getId());
				pstat.setString(2, dto.getBseq());
				pstat.setString(3, dto.getGood());
				pstat.setString(4, dto.getBad());
				
				return pstat.executeUpdate();
			} else if (state == 2) { 
				sql = "update tblGoodBad set good = ?, bad = ? where seq = ?";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, good);
				pstat.setString(2, bad);
				pstat.setString(3, seq);
				
				return pstat.executeUpdate();
			} else if (state == 3) {
				sql = "delete from tblGoodBad where seq = ?";
				
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, seq);
				
				return pstat.executeUpdate();
			}
			
		} catch (Exception e) {
			System.out.println("BoardDAO.updateGoodBad");
			e.printStackTrace();
		}
		
		return 0;
	}

	public void gelGoodBad(String seq) {

		try {
			try {
				String sql = "delete from tblGoodBad where bseq = ?";
				
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, seq);
				
				pstat.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("BoardDAO.delTags");
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			System.out.println("BoardDAO.gelGoodBad");
			e.printStackTrace();
		}
	}

	public ArrayList<ChartDTO01> chart1() {
		
		try {
			
			String sql = "select m.id, (select name from tblMember where id = m.id) as name, (select count(*) from tblBoard where id = m.id)  as cnt\r\n"
					+ "from tblBoard b right outer\r\n"
					+ "    join tblMember m\r\n"
					+ "        on m.id = b.id\r\n"
					+ "            group by m.id";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			ArrayList<ChartDTO01> list = new ArrayList<ChartDTO01>();
			
			while (rs.next()) {
				ChartDTO01 dto = new ChartDTO01();
				
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setCnt(rs.getString("cnt"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("BoardDAO.chart1");
			e.printStackTrace();
		}
		
		return null;
	}
	public ArrayList<ChartDTO02> chart2() {
		
		try {
			
			String sql = "select m.id, (select name from tblMember where id = m.id) as name, (select count(*) from tblComment where id = m.id) as cnt\r\n"
					+ "from tblComment c right outer\r\n"
					+ "    join tblMember m\r\n"
					+ "        on m.id = c.id\r\n"
					+ "            group by m.id";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			ArrayList<ChartDTO02> list = new ArrayList<ChartDTO02>();
			
			while (rs.next()) {
				ChartDTO02 dto = new ChartDTO02();
				
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setCnt(rs.getString("cnt"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("BoardDAO.chart2");
			e.printStackTrace();
		}
		
		return null;
	}
	public ArrayList<ChartDTO03> chart3() {
		
		try {
			
			String sql = "select h.tag, (select count(*) from tblTagging where hseq = h.seq) as cnt \r\n"
					+ "from tblHashTag h left outer\r\n"
					+ "    join tblTagging t \r\n"
					+ "        on h.seq = t.hseq \r\n"
					+ "            group by h.tag, h.seq";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			ArrayList<ChartDTO03> list = new ArrayList<ChartDTO03>();
			
			while (rs.next()) {
				ChartDTO03 dto = new ChartDTO03();
				
				dto.setTag(rs.getString("tag"));
				dto.setCnt(rs.getString("cnt"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("BoardDAO.chart3");
			e.printStackTrace();
		}
		

		return null;
	}
}


















