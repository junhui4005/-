package dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reply {
	
	private int rno; 
	private String rcontent;
	private String rnickname;
	private String rdate;  
	private int rindex; 
	private int relike;
	private int bno; 
	private int mno;
	
	public Reply() {
		// TODO Auto-generated constructor stub
	}

	public Reply(int rno, String rcontent, String rnickname, String rdate, int rindex, int relike, int bno, int mno) {
		super();
		this.rno = rno;
		this.rcontent = rcontent;
		this.rnickname = rnickname;
if( rdate != null ) { 
			
			DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 날짜 형식 변환 설정 
			String today = dateformat.format( LocalDate.now() ) ; // 오늘날짜를 문자열 변환
			String boardday = rdate.split(" ")[0];	// 날짜만 
			String boardtime = rdate.split(" ")[1]; // 시간만 
								// db에 저장된 게시물 등록날짜의 날짜 시간 중에 split 분리후 앞에 있는 날짜만 가져오기 
			// 현재날짜와 게시물등록날짜와 동일하면 
			if( today.equals(boardday) ) { this.rdate = boardtime;}
			// 동일하지 않으면 
			else { this.rdate = boardday; }
			
		}else { this.rdate = rdate; }
	
		this.rindex = rindex;
		this.relike = relike;
		this.bno = bno;
		this.mno = mno;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRnickname() {
		return rnickname;
	}

	public void setRnickname(String rnickname) {
		this.rnickname = rnickname;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getRindex() {
		return rindex;
	}

	public void setRindex(int rindex) {
		this.rindex = rindex;
	}

	public int getRelike() {
		return relike;
	}

	public void setRelike(int relike) {
		this.relike = relike;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "Reply [rno=" + rno + ", rcontent=" + rcontent + ", rnickname=" + rnickname + ", rdate=" + rdate
				+ ", rindex=" + rindex + ", relike=" + relike + ", bno=" + bno + ", mno=" + mno + "]";
	}
	
	
	
	

}
