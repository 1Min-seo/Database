package sku.lesson.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	public static Connection getConnection() throws SQLException, ClassNotFoundException { //예외처리 구문 2 : 나중으로 미룰게
		String id = "root";
		String pwd = "1q2w3e4r";
		String driver = "com.mysql.cj.jdbc.Driver";
		String jdbcURL = "jdbc:mysql://localhost:3306/sku"; // 프로토콜(주 + 보조)/ 포트번호 / 이름
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(jdbcURL, id, pwd);// 예외 발생 구문

		return con;
		
	}
	
	//데이터베이스와의 연결을 종료하는 메소드
	//ResultSet: SQL쿼리의 결과를 담는 개체. 이 객체는 체이블 형태의 데이터를 담는다.
	//Statement: SQL문장을 데이터베이스에 보내기 위한 객체
	//Connection: 데이터베이스와의 연결을 나타냄. 이를 통해 쿼리를 실행하고 결과를 바당올 수 있음
	public static void closeConnection(ResultSet rs, Statement stmt, Connection con) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
