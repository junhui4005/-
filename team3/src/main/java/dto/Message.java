package dto;

public class Message {

	private int mnum ;
	private int msendno; 
	private int mgetno;
	private String mcontent;
	private int mactive;
	private String mtime;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Message(int mnum, int msendno, int mgetno, String mcontent, int mactive, String mtime) {
		super();
		this.mnum = mnum;
		this.msendno = msendno;
		this.mgetno = mgetno;
		this.mcontent = mcontent;
		this.mactive = mactive;
		this.mtime = mtime;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public int getMsendno() {
		return msendno;
	}

	public void setMsendno(int msendno) {
		this.msendno = msendno;
	}

	public int getMgetno() {
		return mgetno;
	}

	public void setMgetno(int mgetno) {
		this.mgetno = mgetno;
	}

	public String getMcontent() {
		return mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	public int getMactive() {
		return mactive;
	}

	public void setMactive(int mactive) {
		this.mactive = mactive;
	}

	public String getMtime() {
		return mtime;
	}

	public void setMtime(String mtime) {
		this.mtime = mtime;
	}

	@Override
	public String toString() {
		return "Message [mnum=" + mnum + ", msendno=" + msendno + ", mgetno=" + mgetno + ", mcontent=" + mcontent
				+ ", mactive=" + mactive + ", mtime=" + mtime + "]";
	}


	
	
}
