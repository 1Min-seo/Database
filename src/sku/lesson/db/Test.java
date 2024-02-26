package sku.lesson.db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
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
					rs = stmt.executeQuery(sql); //resultset객체에 결과값 담기
					
					//정보 조회/출력하는 용도
					ResultSetMetaData rsmd = rs.getMetaData();
					int cols = rsmd.getColumnCount(); // 총 필드 수 반환

					while (rs.next()) {
						for (int i = 1; i <= cols; i++) {
							System.out.print(rs.getString(i)+" ");
						}
						System.out.println();
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
