package sku.lesson.practice.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionP {
	public static void main(String[] args) throws ClassNotFoundException, Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String id = "root";
		String pwd = "1q2w3e4r";
		String driver = "com.mysql.cj.jdbc.Driver";
		String jdbcURL = "jdbc:mysql://localhost:3306/sku"; // 프로토콜(주 + 보조)/ 포트번호 / 이름
		Class.forName(driver);
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(jdbcURL, id, pwd);
			stmt = con.createStatement();

			while (true) {
				System.out.print("SQL> ");
				String sql = br.readLine();

				if (sql.equals("exit")) {
					break;
				}
				try {
					ResultSetMetaData rsmd=rs.getMetaData();
					int cols=rsmd.getColumnCount();
					if (sql.contains("select")){
						rs=stmt.executeQuery(sql);
						rs = stmt.executeQuery(sql); //resultset객체에 결과값 담기
						for(int i=1; i<=cols; i++) {
							System.out.println(rs.getString(i)+" ");
						}
						System.out.println();
					}else if(sql.contains("delete")){
						
						int cnt=stmt.executeUpdate(sql);
						if(cnt>0) {
							System.out.println(cnt+ " row deleted");
						}else {
							System.out.println("no rows deleted");
						}
					}
					rs.close();
				} catch (SQLException e) {
					System.out.println("write the query");
				}
			}		
			stmt.close();
			con.close();
			bw.flush();
			bw.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
