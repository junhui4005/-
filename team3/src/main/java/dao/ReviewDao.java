package dao;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


import dto.Lecture;
import dto.Review;

public class ReviewDao extends Dao{

	public ReviewDao() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public static ReviewDao reviewDao = new ReviewDao();
	
	public static ReviewDao getreviewDao() {
		return reviewDao;
	}
	
	
	
	public ArrayList<Lecture> getlecturelist( String keyword ) {
		ArrayList<Lecture> getlecturelist = new ArrayList<Lecture>();
		String sql = "";
		if( keyword.equals("") ) { //검색이 없을경우 
			sql = "select * from lecture order by lno desc"; /* limit 시작 인덱스 , 표시 개수 */
		}else {
			sql ="select * from lecture where lname like '%"+keyword+"%' or lprofessor like '%"+keyword+"%' order by lno desc";
		}
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Lecture lecture = new Lecture(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8));
				getlecturelist.add(lecture);
			}
			return getlecturelist;
			
		} catch (Exception e) {
			System.out.println("" + e);
		}
		return null;
	}
	
	
	public JSONArray getlecture( int lno ) {
		JSONArray jsonArray = new JSONArray(); // json배열 선언 
		String sql = "select * from lecture where lno ="+lno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				// 결과내 하나씩 모든 레코드를 -> 하나씩 json객체 변환  
				JSONObject object = new JSONObject();
				object.put( "lno" , rs.getInt(1) );
				object.put( "ldivision" , rs.getInt(2) );
				object.put( "lcollege" , rs.getString(3) );
				object.put( "ldepartment" , rs.getString(4) );
				object.put( "lprofessor" , rs.getString(5) );
				object.put( "lcredit" , rs.getInt(6) );
				object.put( "ltime" , rs.getString(7) );
				object.put( "lname" , rs.getString(8));
				jsonArray.put( object );
			}
			return jsonArray;
		}catch (Exception e) { System.out.println( e );}  return null; 
	}
	
	
	public int getmno(String mid) {
		String sql = "select mno from member where mid=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid);
			rs= ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		}catch(Exception e) {}
		return 0;
	}
	
	
	public boolean reviewadd(Review review) {
		String sql = "insert into review(lno,mno,reviewcontent,reviewrate,reviewhome,reviewteam,reviewtest) values(?,?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, review.getLno());
			ps.setInt(2, review.getMno());
			ps.setString(3, review.getReviewcontent());
			ps.setInt(4, review.getReviewrate());
			ps.setInt(5, review.getReviewhome());
			ps.setInt(6, review.getReviewteam());
			ps.setInt(7, review.getReviewtest());
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
		}
		return false;
	}
	
	
	public ArrayList<Review> list(int startrow,int listsize){
		ArrayList<Review> getreviewlist = new ArrayList<Review>();
		try {
			String sql = "select * from review order by reviewno desc limit "+startrow+","+listsize;
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Review review = new Review(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8)
						);
				getreviewlist.add(review);
			}
			return getreviewlist;
		}catch(Exception e) {}
		return null;
	}

	public Lecture lecture(int lno) {
		String sql ="select * from lecture where lno="+lno;	// 1. SQL 작성 
			try {
				ps = con.prepareStatement(sql);	// 2.연결된DB( con ) 에 SQL문 설정  
				rs = ps.executeQuery(); 		// 3.조작된 SQL를 실행
				if( rs.next() ) { // 4. 검색 결과 [ rs.next() 할 때 마다 결과물에서 레코드 1개씩 호출 ]  
					Lecture lecture = new Lecture( 
						rs.getInt(1),rs.getInt(2), 
						rs.getString(3),rs.getString(4),
						rs.getString(5), rs.getInt(6),
						rs.getString(7), rs.getString(8) 
					);
					return lecture;
				}
			}catch (Exception e) {} return null;
	}
	
//////강의평 전체갯수출력
	public int gettotallist(String keyword) {
		try {
			String sql = null;
			if(keyword.equals("")) {
				sql = "select count(*) from review";
			}
			else {
				sql = "select count(*) from review A, lecture B"
						+ " where A.lno = B.lno and"
						+ " B.lname like '%"+keyword+"%' or A.lno = B.lno and B.lprofessor like '%"+keyword+"%'";
			}
			ps = con.prepareStatement(sql); rs = ps.executeQuery(); 
			if( rs.next() )
			{	
				return rs.getInt(1); }
		}catch (Exception e) {System.out.println(e);
		}return 0;
	}
	
	public JSONArray getlist(int startrow, int listsize, String keyword){
		JSONArray jsonArray = new JSONArray();
		try {
			String sql = null;
			if( keyword.equals("")) {
			sql = "select * from review A, lecture B"
					+ " where A.lno = B.lno order by reviewno desc limit "+startrow+","+listsize;
			}
			else {
				sql = "select * from review A, lecture B"
						+ " where A.lno = B.lno and"
						+ " B.lname like '%"+keyword+"%' or A.lno = B.lno and B.lprofessor like '%"+keyword+"%'  order by reviewno desc limit "+startrow+","+listsize;
	 		}
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while( rs.next() ) {
				// 결과내 하나씩 모든 레코드를 -> 하나씩 json객체 변환  
				JSONObject object = new JSONObject();
				object.put( "reviewno" , rs.getInt(1) );
				object.put( "lno" , rs.getInt(2) );
				object.put( "mno" , rs.getInt(3) );
				object.put( "reviewcontent" , rs.getString(4) );
				object.put( "reviewrate" , rs.getInt(5) );
				object.put( "reviewhome" , rs.getInt(6) );
				object.put( "reviewteam" , rs.getInt(7) );
				object.put( "reviewtest" , rs.getInt(8));
				object.put( "llno" , rs.getInt(9));
				object.put( "ldivision" , rs.getInt(10));
				object.put( "lcollege" , rs.getString(11));
				object.put( "ldepartment" , rs.getString(12));
				object.put( "lprofessor" , rs.getString(13));
				object.put( "lcredit" , rs.getInt(14));
				object.put( "ltime" , rs.getString(15));
				object.put( "lname" , rs.getString(16));
				jsonArray.put( object );
			}
			return jsonArray;
		}catch(Exception e) {System.out.println(e);}
		return null;
	}
	
	
	public JSONArray getreview(int lno,int startrow, int listsize){
		JSONArray jsonArray = new JSONArray();
		try {
			 String sql = "select * from review A, lecture B where A.lno = "+lno+" and B.lno = "+lno+" order by reviewno desc limit "+startrow+","+listsize;
	 		
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while( rs.next() ) {
				// 결과내 하나씩 모든 레코드를 -> 하나씩 json객체 변환  
				JSONObject object = new JSONObject();
				object.put( "reviewno" , rs.getInt(1) );
				object.put( "lno" , rs.getInt(2) );
				object.put( "mno" , rs.getInt(3) );
				object.put( "reviewcontent" , rs.getString(4) );
				object.put( "reviewrate" , rs.getInt(5) );
				object.put( "reviewhome" , rs.getInt(6) );
				object.put( "reviewteam" , rs.getInt(7) );
				object.put( "reviewtest" , rs.getInt(8));
				object.put( "llno" , rs.getInt(9));
				object.put( "ldivision" , rs.getInt(10));
				object.put( "lcollege" , rs.getString(11));
				object.put( "ldepartment" , rs.getString(12));
				object.put( "lprofessor" , rs.getString(13));
				object.put( "lcredit" , rs.getInt(14));
				object.put( "ltime" , rs.getString(15));
				object.put( "lname" , rs.getString(16));
				jsonArray.put( object );
			}
			return jsonArray;
		}catch(Exception e) {System.out.println(e);}
		return null;
	}
	
	
	
	//특정강의평 전체갯수 출력
	public int gettotal(int lno) {
		try {
			String sql = "select count(*) from review where lno = "+lno+"";
			ps = con.prepareStatement(sql); rs = ps.executeQuery(); 
			if( rs.next() )
			{	
				return rs.getInt(1); }
		}catch (Exception e) {System.out.println(e);
		}return 0;
	}
	
	////강의평 평균 
	public double review(int lno, String num) {
	try {
		String sql = "SELECT avg("+num+") FROM review where lno = "+lno;
		ps = con.prepareStatement(sql);
		rs=ps.executeQuery();
		if( rs.next() ) { // 4. 검색 결과 [ rs.next() 할 때 마다 결과물에서 레코드 1개씩 호출 ]  
			return rs.getDouble(1);
		}
	}catch (Exception e) {
		// TODO: handle exception
	}
	return 0;
	
	}
	
	public boolean addcheck(int lno , int mno) {
		try {
			String sql = "select * from review where lno= "+lno+" and mno = " + mno;
			ps=con.prepareStatement(sql);
			rs= ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}catch(Exception e){}
		return false;
	}
	
	
}
