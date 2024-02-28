package basic.lesson.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GisaDAO {
	public ArrayList<Student> select(String sql){
		ArrayList<Student> list=null;
		try {
			Connection con= ConnectManager.getConnection();
			list=new ArrayList<Student>();
			
			PreparedStatement pstm=con.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public String selectQuiz1(String sql)throws SQLException {
		return null;
	}
	public String selectQuiz2(String sql)throws SQLException  {
		return null;
	}
	public String selectQuiz3(String sql)throws SQLException  {
		return null;
	}
	public String selectQuiz4(String sql)throws SQLException  {
		return null;
	}
}
