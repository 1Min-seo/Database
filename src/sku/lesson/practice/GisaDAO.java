package sku.lesson.practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GisaDAO {
	
	public boolean insert(ArrayList<Student> list) {
		boolean flag=false;
		
		return flag;
	}
	public boolean insert(Student student)throws SQLException{
		boolean flag=false;
		Connection con=ConnectionManager.getconnection();
		String sql="insert into gisa values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setInt(1, student.getStuNo());
		psmt.setString(2, student.getEmail());
		psmt.setInt(3, student.getKor());
		psmt.setInt(4, student.getEng());
		psmt.setInt(5, student.getMath());
		psmt.setInt(6, student.getSci());
		psmt.setInt(7, student.getHis());
		psmt.setInt(8, student.getTotal());
		psmt.setString(9, student.getMgrCode());
		psmt.setString(10, student.getAchCode());
		psmt.setString(11, student.getLocCode());
		int affectedCount=psmt.executeUpdate();
		if(affectedCount>0) {
			flag=true;
		}
		ConnectionManager.closeConnection(null, psmt, con);
		return flag;
	}
	
	public boolean insert(String sql) throws SQLException {
		boolean flag=false;
		Connection con=ConnectionManager.getconnection();
		Statement stmt=con.createStatement();
		int affectedCount=stmt.executeUpdate(sql);
		ConnectionManager.closeConnection(null, stmt, con);
		
		if(affectedCount>0) {
			flag=true;
		}
		return flag;
	}
	
	public boolean delete(String sql) throws SQLException {
		boolean flag=false;
		Connection con=ConnectionManager.getconnection();
		Statement stmt=con.createStatement();
		int affectedCount=stmt.executeUpdate(sql);
		ConnectionManager.closeConnection(null, stmt, con);
		
		if(affectedCount>0) {
			flag=true;
		}
		return flag;
	}
	
	
}
