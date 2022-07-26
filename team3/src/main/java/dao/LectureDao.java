package dao;

import java.util.ArrayList;
import java.util.Arrays;

import dto.Lecture;
import dto.Timetable;

public class LectureDao extends Dao{
	public LectureDao() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public static LectureDao lectureDao = new LectureDao();
	
	public static LectureDao getLectureDao() {
		return lectureDao;
	}
	
	public ArrayList<Lecture> getlecturelist() {
		
		ArrayList<Lecture> getlecturelist = new ArrayList<Lecture>();
		
		String sql = "select * from lecture";
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Lecture lecture = new Lecture(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8));
				getlecturelist.add(lecture);
			}
			
			return getlecturelist;
			
		} catch (Exception e) {
			System.out.println("GET LECTURE ERROR : " + e);
		}
		return null;
	}
	
	public ArrayList<Lecture> getdepartmentlist(String college) {
		
		ArrayList<Lecture> getdepartmentlist = new ArrayList<Lecture>();
		
		String sql = "SELECT * FROM lecture WHERE lcollege = '" + college + "'";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Lecture lecture = new Lecture(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8));
				getdepartmentlist.add(lecture);
			}
			return getdepartmentlist;
		} catch (Exception e) {
			System.out.println("GET Department ERROR : " + e);
		}
		return null;
		
	}
	
	public ArrayList<Lecture> getlectureList_depart(String department){
		ArrayList<Lecture> list = new ArrayList<Lecture>();
		
		String sql = "SELECT * FROM lecture WHERE ldepartment = '" + department + "'";
		
		if (department.equals("")) {
			sql = "SELECT * FROM lecture WHERE ldivision = 1";
		}
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Lecture lecture = new Lecture(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8));
				list.add(lecture);
			}

			return list;
		} catch (Exception e) {
			System.out.println("getlectureList_depart ERROR : " + e);
		}
		return null;
	}
	
	public Lecture getlectureinfo(int lno){
		
		
		String sql = "SELECT * FROM lecture WHERE lno = " + lno;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				Lecture lecture = new Lecture(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8));
				return lecture; 
			}
			
			
		} catch (Exception e) {
			System.out.println("getlectureinfo ERROR : " + e);
		}
		return null;
	}
	
	public boolean savetimetable(String table_name, String table_professor, String table_time, int table_code, int mno) {
		
		String sql = "INSERT INTO timetable(table_name, table_professor, table_time, table_code, mno) VALUES (?, ?, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, table_name);
			ps.setString(2, table_professor);
			ps.setString(3, table_time);
			ps.setInt(4, table_code);
			ps.setInt(5, mno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("savetimetable ERROR : " + e);
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean deletetimetable(String table_code, int mno) {
		
		String sql = "DELETE FROM timetable WHERE table_code = '" + table_code + "' AND mno = " + mno;
		
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("deletetimetable ERROR : " + e);
			e.printStackTrace();
		}
		
		return false;
	}
	
	public ArrayList<Timetable> gettimetabe(int mno){
		
		String sql = "SELECT * FROM timetable WHERE mno = " + mno;
		ArrayList<Timetable> arrayList = new ArrayList<Timetable>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Timetable timetable = new Timetable(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), 0);
				arrayList.add(timetable);
			}
			return arrayList;
		} catch (Exception e) {
			
		}
		return null;
	}
	
	public boolean savememo(String memo, int mno, int table_code) {

		String sql = "UPDATE timetable SET memo = '" + memo + "' WHERE mno = " + mno + " AND table_code = " + table_code;
		try {
			System.out.println(sql);
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("save memo ERROR : " + e);
		}

		return false;
	}

	public String getmemo(int mno, int table_code) {
		String sql = "SELECT memo FROM timetable WHERE mno = " + mno + " AND table_code = " + table_code;
		System.out.println(sql);
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String memo = rs.getString(1);
				return memo;
			}

		} catch (Exception e) {
			System.out.println("get memo ERROR : " + e);
		}
		return null;
	}
}
