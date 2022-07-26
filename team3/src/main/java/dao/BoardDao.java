package dao;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.Board;

public class BoardDao extends Dao {
	public BoardDao() {
		// TODO Auto-generated constructor stub
		super();
	}
	public static BoardDao boardDao = new BoardDao();
	public static BoardDao getBoardDao() {
		return boardDao;
	}
	
	// MemberDao 사용 메소드
	public int getmno(String mid) {
		String sql = "select mno from member where mid = '"+mid+"'";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {}
		return 0;
		}
	
	public String getmid(int mno) {
		String sql = "select mid from member where mno = '"+mno+"'";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {}
		return null;
		}
	
	public int getnos(int bno) {
		String sql = "select mno from board where bno = '"+bno+"'";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {}
		return 0;
		}
	
	public int getnos2(int rno) {
		String sql = "select mno from reply where rno = '"+rno+"'";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {}
		return 0;
		}
	
	
	
	
	
	
	// 1. 글작성
	public boolean boardwrite(Board board) {
		
		String sql = "insert into board(btitle,bcontent,mno,bimg,bnickname,rcount)values(?,?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setInt(3, board.getMno());
			ps.setString(4, board.getBimg());
			ps.setString(5, board.getBnickname());
			ps.setInt(6, board.getRcount());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {System.out.println("게시판 글 작성 오류" + e);}
		
		return false;
	}
	
//public int gettotalrow( String key , String keyword  ) {
//		
//		// 만약에 작성자 요청이면 
//		//if( key.equals("mid") ) { key = "mno"; keyword = MemberDao.getmemberDao().getmno(keyword)+""; }
//		
//		String sql = null;
//		if( key.equals("") && keyword.equals("") ) { sql ="select count(*) from board";} //검색이 없을경우 
//		else { sql ="select count(*) from board where "+key+" like '%"+keyword+"%'";} // 검색이 있을경우
//		
//		try { ps = con.prepareStatement(sql); rs = ps.executeQuery(); 
//			if( rs.next() ) return rs.getInt(1); 
//		}
//		catch( Exception e ) { System.out.println( e );} return 0;
//	}
//	
//	// 2. 모든 게시물 출력
//	public ArrayList<Board> getboardlist(int startrow,int listsize,String key,String keyword) {
//		ArrayList<Board> boardlist = new ArrayList<Board>();
//		String sql = "null";
//		//if( key.equals("mid") ) { key = "mno"; keyword = MemberDao.getmemberDao().getmno(keyword)+""; }
//		if( key.equals("") && keyword.equals("") ) { //검색이 없을경우 
//			sql = "select * from board order by bno desc limit "+startrow+","+listsize; /* limit 시작 인덱스 , 표시 개수 */
//		}else {
//			sql ="select * from board where "+key+" like '%"+keyword+"%' order by bno desc limit "+startrow+","+listsize;
//		}
//		try {
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				Board board = new Board(
//						rs.getInt(1),rs.getString(2),
//						rs.getString(3),rs.getInt(4),
//						rs.getString(5),rs.getInt(6),rs.getInt(7),
//						rs.getString(8),rs.getString(9)
//						);
//				boardlist.add(board);
//			}
//			return boardlist;
//			
//		} catch (Exception e) {System.out.println("모든 게시물 출력 오류" +e);}
//		return null;
//	}
	
	// 2. 모든 게시물 출력 <리스트버전 자바에서 바로 뿌릴거면사용 >
	public ArrayList<Board> getboardlist() {
		ArrayList<Board> boardlist = new ArrayList<Board>();
		String sql = "select * from board order by bno desc";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Board board = new Board(
						rs.getInt(1),rs.getString(2),
						rs.getString(3),rs.getInt(4),
						rs.getString(5),rs.getInt(6),rs.getInt(7),
						rs.getString(8),rs.getString(9)
						);
				boardlist.add(board);
			}
			return boardlist;
			
		} catch (Exception e) {System.out.println("모든 게시물 출력 오류" +e);}
		return null;
	}
	
	// 2. 모든게시물출력 json버전 <ajax로 뿌릴때 사용>
	public JSONArray getboardlist2(String key,String keyword) {
		JSONArray jsonArray = new JSONArray();
		String sql = null;
		System.out.println(key);
		System.out.println(keyword);
		if(key==null  && keyword==null)
		{sql = "select * from board order by bno desc";}
		else {
			sql = "select * from board where "+key+" like '%"+keyword+"%' order by bno desc";
		}
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				JSONObject object = new JSONObject();
				object.put("bno", rs.getInt(1));
				object.put("btitle",rs.getString(2) );
				object.put("bcontent",rs.getString(3));
				object.put("rcount", rs.getInt(6));
				object.put("blike", rs.getInt(7));
				object.put("bnickname",rs.getString(8) );
				object.put("bdate",rs.getString(9) );
				jsonArray.put(object);
				
			}
			return jsonArray;
			
		} catch (Exception e) {System.out.println("전체 게시물 출력오류"+ e);}
		
		
		return null;
	}
	
	// 인기글 출력 메소드
	public JSONArray getboardbestlist() {
		JSONArray jsonArray = new JSONArray();
		String sql = "select * from board order by blike desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				JSONObject object = new JSONObject();
				object.put("bno", rs.getInt(1));
				object.put("btitle",rs.getString(2) );
				object.put("bcontent",rs.getString(3));
				object.put("rcount", rs.getInt(6));
				object.put("blike", rs.getInt(7));
				object.put("bnickname",rs.getString(8) );
				object.put("bdate",rs.getString(9) );
				jsonArray.put(object);
				
			}
			return jsonArray;
			
		} catch (Exception e) {System.out.println("dd"+ e);}
		return null;
	}
	
	
	
	
	// 3. 개별 게시물 출력
	public Board getboaBoard(int bno) {
		String sql = "select * from board where bno=" +bno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				Board board = new Board(
						rs.getInt(1),rs.getString(2), 
						rs.getString(3),rs.getInt(4),
						rs.getString(5), rs.getInt(6),
						rs.getInt(7), rs.getString(8),
						rs.getString(9)
						);
				return board;
			}
			
		} catch (Exception e) {System.out.println("개별 게시물 출력 오류" + e);}
		return null;
	}
	// 4. 게시물 수정 메소드
	public boolean boardupdate(Board board) {
		String sql = "update board set btitle=? , bcontent=? , bimg=?,bnickname=? where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , board.getBtitle() );
			ps.setString( 2 , board.getBcontent() );
			ps.setString( 3 , board.getBimg() );
			ps.setString( 4 , board.getBnickname() );
			ps.setInt( 5 , board.getBno() );
			ps.executeUpdate(); return true;
		}
		catch (Exception e) { System.out.println( e );} return false;
	}
	
	public boolean filedelete( int bno ) {
		String sql = "update board set bimg = null where bno = "+bno;
		try { ps = con.prepareStatement(sql); ps.executeUpdate(); return true; }
		catch (Exception e) {} return false;
	}
	
	// 5. 게시물 삭제
	public boolean delete( int bno ) { 
		String sql = "delete from board where bno="+bno;
		try { ps = con.prepareStatement(sql); ps.executeUpdate(); return true;}
		catch (Exception e) {System.out.println("게시물삭제 오류"+ e);} return false;
	}
	
	
	// 7. 추천메소드  <수정사항 쿼리문 하나로 쓰는법 생각해보기>
	public int boardlike(int bno, int mno) {
		String sql = "select blikeno from blike where bno="+bno+" and mno="+mno;
		try {
			ps= con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				sql = "delete from blike where blikeno = " + rs.getInt(1);
				ps =con.prepareStatement(sql); ps.executeUpdate();
				String sql2 ="update board set blike = blike-1 where bno = "+bno;
				ps = con.prepareStatement(sql2);ps.executeUpdate();
				return 2; // 삭제
			} else {
				sql = "insert into blike(bno,mno)values("+bno+","+mno+")";
				
				ps = con.prepareStatement(sql); ps.executeUpdate();
				
				String sql2 ="update board set blike = blike+1 where bno = "+bno;
				ps = con.prepareStatement(sql2);ps.executeUpdate();
				return 1;// 등록
			}
			
		} catch (Exception e) {System.out.println("게시물 추천 오류" + e);}
		return 3;
	}
	
	public boolean getblike(int bno, int mno) {
		
		String sql = "select*from blike where bno = "+bno+" and mno="+mno;
		try {
			ps =con.prepareStatement(sql); rs = ps.executeQuery();
			if(rs.next())return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	// 게시판 댓글갯수 세기
	public int getcountcoment(int bno) {
		String sql = "select count(bno) from reply where bno="+bno ;
		
		try {
			ps =con.prepareStatement(sql); rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			
			
			
		} catch (Exception e) {System.out.println("댓글갯수 출력 오류"+ e);}
		return 0;
	}
	
	
	

	

	
	//////////////////////////////////댓글관련////////////////////////////////////////////////

}
