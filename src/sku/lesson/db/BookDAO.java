package sku.lesson.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//테이블 담당 클래스 (DataBase Access Object)
//java와 db는 네트워크 관계. 즉 외부에 데이터가 있음
//외부에 있는 데이터와 연결하기 위해선 stream이 필요
public class BookDAO {
	public void select(String sql) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//행처리
				String attr1=rs.getString(1);
				String attr2=rs.getString(2);
				String attr3=rs.getString(3);
				String attr4=rs.getString(4);
				System.out.println(attr1+","+attr2+","+attr3+","+attr4);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectionManager.closeConnection(rs, stmt, con);
		
	}
}
