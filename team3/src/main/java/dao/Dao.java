package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	protected Connection con;
	protected PreparedStatement ps;
	protected ResultSet rs;
	
	public Dao() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/team3?serverTimezone=Asia/Seoul","root","1234");
			System.out.println("Connection");
		} catch (Exception e) {
			System.err.println("DB Connect error : " + e);
		}
		
	}

}


// jdbc:mysql://admin.cwidctdjagpz.us-east-1.rds.amazonaws.com:3306/?user=admin