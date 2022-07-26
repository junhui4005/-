package dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Board {
	
	
	private int bno;
	private String btitle; 
	private String bcontent;
	private int mno;
	private String bimg;
	private int rcount; 
	private int blike; 
	private String bnickname;  
	private String bdate;
	
	
	public Board() {
		// TODO Auto-generated constructor stub
	}


	public Board(int bno, String btitle, String bcontent, int mno, String bimg, int rcount, int blike,
			String bnickname, String bdate) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mno = mno;
		this.bimg = bimg;
		this.rcount = rcount;
		this.blike = blike;
		this.bnickname = bnickname;
if( bdate != null ) { 
			
			DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 날짜 형식 변환 설정 
			String today = dateformat.format( LocalDate.now() ) ; // 오늘날짜를 문자열 변환
			String boardday = bdate.split(" ")[0];	// 날짜만 
			String boardtime = bdate.split(" ")[1]; // 시간만 
								// db에 저장된 게시물 등록날짜의 날짜 시간 중에 split 분리후 앞에 있는 날짜만 가져오기 
			// 현재날짜와 게시물등록날짜와 동일하면 
			if( today.equals(boardday) ) { this.bdate = boardtime;}
			// 동일하지 않으면 
			else { this.bdate = boardday; }
			
		}else { this.bdate = bdate; }
	}


	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public String getBtitle() {
		return btitle;
	}


	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}


	public String getBcontent() {
		return bcontent;
	}


	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}


	public int getMno() {
		return mno;
	}


	public void setMno(int mno) {
		this.mno = mno;
	}


	public String getBimg() {
		return bimg;
	}


	public void setBimg(String bimg) {
		this.bimg = bimg;
	}


	public int getRcount() {
		return rcount;
	}


	public void setRcount(int rcount) {
		this.rcount = rcount;
	}


	public int getBlike() {
		return blike;
	}


	public void setBlike(int blike) {
		this.blike = blike;
	}


	public String getBnickname() {
		return bnickname;
	}


	public void setBnickname(String bnickname) {
		this.bnickname = bnickname;
	}


	public String getBdate() {
		return bdate;
	}


	public void setBdate(String bdate) {
		this.bdate = bdate;
	}


	@Override
	public String toString() {
		return "Board [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", mno=" + mno + ", bimg=" + bimg
				+ ", rcount=" + rcount + ", blike=" + blike + ", bnickname=" + bnickname + ", bdate=" + bdate
				+ "]";
	}
	
	
	
	

}
