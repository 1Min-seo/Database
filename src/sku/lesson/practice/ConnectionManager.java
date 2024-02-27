package sku.lesson.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

	public static Connection getconnection() {
		Connection con=null;
		String id = "root";
		String pw = "1q2w3e4r";
		String driver = "com.mysql.cj.jdbc.Driver";
		String jdbcURL = "jdbc:mysql://localhost:3306/gisa"; // 프로토콜(주 + 보조)/ 포트번호 / 이름
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(jdbcURL,id,pw);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
		return con;
	}
	
	public static void closeConnection(ResultSet rs, Statement stmt, Connection con) {
		
	}
}
