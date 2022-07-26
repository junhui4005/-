package dto;

public class Lecture {
	
	private int lno, ldivision;
	private String lcollege, ldepartment, lprofessor;
	private int lcredit;
	private String ltime, lname;
	
	
	public Lecture() {
		// TODO Auto-generated constructor stub
	}


	public Lecture(int lno, int ldivision, String lcollege, String ldepartment, String lprofessor, int lcredit,
			String ltime, String lname) {
		super();
		this.lno = lno;
		this.ldivision = ldivision;
		this.lcollege = lcollege;
		this.ldepartment = ldepartment;
		this.lprofessor = lprofessor;
		this.lcredit = lcredit;
		this.ltime = ltime;
		this.lname = lname;
	}


	public int getLno() {
		return lno;
	}


	public void setLno(int lno) {
		this.lno = lno;
	}


	public int getLdivision() {
		return ldivision;
	}


	public void setLdivision(int ldivision) {
		this.ldivision = ldivision;
	}


	public String getLcollege() {
		return lcollege;
	}


	public void setLcollege(String lcollege) {
		this.lcollege = lcollege;
	}


	public String getLdepartment() {
		return ldepartment;
	}


	public void setLdepartment(String ldepartment) {
		this.ldepartment = ldepartment;
	}


	public String getLprofessor() {
		return lprofessor;
	}


	public void setLprofessor(String lprofessor) {
		this.lprofessor = lprofessor;
	}


	public int getLcredit() {
		return lcredit;
	}


	public void setLcredit(int lcredit) {
		this.lcredit = lcredit;
	}


	public String getLtime() {
		return ltime;
	}


	public void setLtime(String ltime) {
		this.ltime = ltime;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	@Override
	public String toString() {
		return "lecture [lno=" + lno + ", ldivision=" + ldivision + ", lcollege=" + lcollege + ", ldepartment="
				+ ldepartment + ", lprofessor=" + lprofessor + ", lcredit=" + lcredit + ", ltime=" + ltime + ", lname="
				+ lname + "]";
	}
	
	

}
