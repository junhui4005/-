package dao;

import java.util.ArrayList;


import dto.Reply;

public class ReplyDao extends Dao {
	public ReplyDao() {
		
		super();
	}
	public static ReplyDao replyDao = new ReplyDao();
	public static ReplyDao getReplyDao() {
		return replyDao;
	}
	
	
	// 1.댓글 작성
public boolean replywrite(Reply reply) {
		String sql = "insert into reply(rcontent,rnickname,rindex,bno,mno)values(?,?,?,?,?)";
		//String sql2 = "update board set rcount = rcount+1 where bno ="+reply.getBno();
		
		
		
		try {
			
			
			ps = con.prepareStatement(sql);
			ps.setString(1, reply.getRcontent());
			ps.setString(2, reply.getRnickname());
			ps.setInt(3, reply.getRindex());
			ps.setInt(4, reply.getBno());
			ps.setInt(5, reply.getMno());	
			ps.executeUpdate();
			
			String sql2 = "update board set rcount = "+BoardDao.getBoardDao().getcountcoment(reply.getBno())+" where bno ="+reply.getBno();
			ps= con.prepareStatement(sql2);
			ps.executeUpdate();
			
			return true;
			
		} catch (Exception e) {System.out.println("댓글 작성 오류" + e);}
		
		return false;
	}

// 댓글출력
public ArrayList<Reply> replylist( int bno ) { 
	ArrayList<Reply> replylist = new ArrayList<Reply>();
	String sql = "select * from reply where bno = "+bno+" and rindex = 0"; // rindex = 0  : 댓글만 출력 [ 대댓글 제외 ] 
	try {
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery(); 
		while( rs.next() ) { 
			Reply reply = new Reply( 
					rs.getInt(1) , rs.getString(2) , 
					rs.getString(3) , rs.getString(4) , 
					rs.getInt(5), rs.getInt(6), rs.getInt(7),rs.getInt(8));
			replylist.add(reply);
		}
		return replylist;
	}catch (Exception e) { System.out.println( e ); } return null; 
}

// 대댓글출력
public ArrayList<Reply> rereplylist( int bno , int  rno ){
	ArrayList<Reply> rereplylist = new ArrayList<Reply>();
	String sql = "select * from reply where bno = "+bno+" and rindex = "+rno;
	try { 
		ps = con.prepareStatement(sql); rs= ps.executeQuery();
		while( rs.next() ) {
			Reply reply = new Reply(
					rs.getInt(1) , rs.getString(2) , 
					rs.getString(3) , rs.getString(4) , 
					rs.getInt(5), rs.getInt(6), rs.getInt(7),rs.getInt(8));
			rereplylist.add(reply);
		}
		return rereplylist;
	}catch (Exception e) { System.out.println(e); } return null;
	
}

// 댓글수정
public boolean replyupdate(Reply reply) {
	String sql = "update reply set rcontent=?,rnickname=? where rno=?";
	
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1,reply.getRcontent() );
		ps.setString(2, reply.getRnickname());
		ps.setInt(3, reply.getRno());
		ps.executeUpdate();
		System.out.println(reply.getRcontent()+"+"+reply.getRno());
		return true;
	} catch (Exception e) {System.out.println("댓글수정오류" + e);}
	
	return false;
	}

// 댓글 삭제

public boolean replydelete( int rno ,int bno) { 
	String sql ="delete from reply "
			+ "where rno = "+rno+" or rindex = "+rno;
	
	try { 
		
		
		ps = con.prepareStatement(sql); 
		ps.executeUpdate();
		String sql2 = "update board set rcount = "+BoardDao.getBoardDao().getcountcoment(bno)+" where bno ="+bno;
		ps= con.prepareStatement(sql2);
		ps.executeUpdate();
		return true;
	}
	catch( Exception e ) {} return false;
}


//7. 추천메소드  <수정사항 쿼리문 하나로 쓰는법 생각해보기>
	public int replylike(int rno, int mno) {
		String sql = "select relikeno from relike where rno="+rno+" and mno="+mno;
		try {
			ps= con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				sql = "delete from relike where relikeno = " + rs.getInt(1);
				ps =con.prepareStatement(sql); ps.executeUpdate();
				String sql2 ="update reply set relike = relike-1 where rno = "+rno;
				ps = con.prepareStatement(sql2);ps.executeUpdate();
				return 2; // 삭제
			} else {
				sql = "insert into relike(rno,mno)values("+rno+","+mno+")";
				
				ps = con.prepareStatement(sql); ps.executeUpdate();
				
				String sql2 ="update reply set relike = relike+1 where rno = "+rno;
				ps = con.prepareStatement(sql2);ps.executeUpdate();
				return 1;// 등록
			}
			
		} catch (Exception e) {System.out.println("게시물 추천 오류" + e);}
		return 3;
	}
	
	public boolean getreplylike(int rno, int mno) {
		
		String sql = "select*from relike where rno = "+rno+" and mno="+mno;
		try {
			ps =con.prepareStatement(sql); rs = ps.executeQuery();
			if(rs.next())return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
