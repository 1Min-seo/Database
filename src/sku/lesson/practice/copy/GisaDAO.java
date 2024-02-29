package sku.lesson.practice.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import basic.lesson.db.Student;

public class GisaDAO {
	public ArrayList<Student> select(String sql){
		ArrayList<Student> list=null;
		Connection con=ConnectionManager.getConnection();
		try {
			PreparedStatement psmt=con.prepareStatement(sql);
			ResultSet rs= psmt.executeQuery();
			Student student=null;
			list=new ArrayList<Student>();
			while(rs.next()) {
				//하나의 레코드를 Student 객체 1개에 맵핑하고 리스트에 저장
				int stdNo=rs.getInt(1);
				String email=rs.getString(2);
				int kor=rs.getInt(3);
				int eng=rs.getInt(4);
				int math=rs.getInt(5);
				int sci=rs.getInt(6);
				int his=rs.getInt(7);
				int total=rs.getInt(8);
				String mgrCode=rs.getString(9);
				String accCode=rs.getString(10);
				String locCode=rs.getString(11);
				student=new Student(stdNo, email, kor, eng, math,
						sci, his,total,mgrCode, accCode,
						locCode);
				
				list.add(student);
			}
			ConnectionManager.closeConnection(rs, psmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}