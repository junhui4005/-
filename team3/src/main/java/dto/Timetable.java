package dto;

public class Timetable {
	
	public int idtimetable;
	public String table_name, table_professor, table_time;
	public int table_code, mno;
	
	public Timetable() {
		// TODO Auto-generated constructor stub
	}

	public Timetable(int idtimetable, String table_name, String table_professor, String table_time, int table_code,
			int mno) {
		super();
		this.idtimetable = idtimetable;
		this.table_name = table_name;
		this.table_professor = table_professor;
		this.table_time = table_time;
		this.table_code = table_code;
		this.mno = mno;
	}

	public int getIdtimetable() {
		return idtimetable;
	}

	public void setIdtimetable(int idtimetable) {
		this.idtimetable = idtimetable;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getTable_professor() {
		return table_professor;
	}

	public void setTable_professor(String table_professor) {
		this.table_professor = table_professor;
	}

	public String getTable_time() {
		return table_time;
	}

	public void setTable_time(String table_time) {
		this.table_time = table_time;
	}

	public int getTable_code() {
		return table_code;
	}

	public void setTable_code(int table_code) {
		this.table_code = table_code;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "Timetable [idtimetable=" + idtimetable + ", table_name=" + table_name + ", table_professor="
				+ table_professor + ", table_time=" + table_time + ", table_code=" + table_code + ", mno=" + mno + "]";
	}
	
	

}
