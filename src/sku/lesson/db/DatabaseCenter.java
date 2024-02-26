package sku.lesson.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseCenter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//connectDatabase 호출
		DatabaseCenter dc=new DatabaseCenter();
		try {
			dc.connectDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void connectDatabase() throws SQLException, ClassNotFoundException {
		String id="root";
		String pwd="1q2w3e4r";
		
		//driver : 자바프로그램과 db 서버를 연결시켜주는(인식시켜주는) 의미
		String driver="com.mysql.cj.jdbc.Driver";
		String jdbcURL="jdbc:mysql://localhost:3306/gisa";
		Class.forName(driver);
		
		//db에 직접 연결하는 것이 아닌 관리하는 시스템에 연결
		Connection con= DriverManager.getConnection(jdbcURL,id,pwd);
		if(con!=null) {
			System.out.println("connecting database");
			con.close();
		}else {
			System.out.println("connecting database");
		}
		
	}

}
