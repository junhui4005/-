package dto;

public class Review {
	
	private int reviewno ;
	private int lno ;
	private int mno ; 
	private String reviewcontent ;
	private int reviewrate ;
	private int reviewhome ;
	private int reviewteam ;
	private int reviewtest ;
	
	
	public Review() {
		// TODO Auto-generated constructor stub
	}


	public Review(int reviewno, int lno, int mno, String reviewcontent, int reviewrate, int reviewhome, int reviewteam,
			int reviewtest) {
		super();
		this.reviewno = reviewno;
		this.lno = lno;
		this.mno = mno;
		this.reviewcontent = reviewcontent;
		this.reviewrate = reviewrate;
		this.reviewhome = reviewhome;
		this.reviewteam = reviewteam;
		this.reviewtest = reviewtest;
	}


	public int getReviewno() {
		return reviewno;
	}


	public void setReviewno(int reviewno) {
		this.reviewno = reviewno;
	}


	public int getLno() {
		return lno;
	}


	public void setLno(int lno) {
		this.lno = lno;
	}


	public int getMno() {
		return mno;
	}


	public void setMno(int mno) {
		this.mno = mno;
	}


	public String getReviewcontent() {
		return reviewcontent;
	}


	public void setReviewcontent(String reviewcontent) {
		this.reviewcontent = reviewcontent;
	}


	public int getReviewrate() {
		return reviewrate;
	}


	public void setReviewrate(int reviewrate) {
		this.reviewrate = reviewrate;
	}


	public int getReviewhome() {
		return reviewhome;
	}


	public void setReviewhome(int reviewhome) {
		this.reviewhome = reviewhome;
	}


	public int getReviewteam() {
		return reviewteam;
	}


	public void setReviewteam(int reviewteam) {
		this.reviewteam = reviewteam;
	}


	public int getReviewtest() {
		return reviewtest;
	}


	public void setReviewtest(int reviewtest) {
		this.reviewtest = reviewtest;
	}


	@Override
	public String toString() {
		return "Review [reviewno=" + reviewno + ", lno=" + lno + ", mno=" + mno + ", reviewcontent=" + reviewcontent
				+ ", reviewrate=" + reviewrate + ", reviewhome=" + reviewhome + ", reviewteam=" + reviewteam
				+ ", reviewtest=" + reviewtest + "]";
	}
	
	
	
}
