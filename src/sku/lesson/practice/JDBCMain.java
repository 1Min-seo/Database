package sku.lesson.practice;

import java.sql.SQLException;

public class JDBCMain {

	public static void main(String[] args) {
		JDBCMain main=new JDBCMain();
		main.testCRUD();

	}
	
	public void testCRUD() {
		String sql="insert into gisa values (990002,'addx',17,29,16,49,43,154,'C','A','C');";
		GisaDAO dao=new GisaDAO();
		try {
			//boolean flag = dao.insert(sql);
			//sql="delete from gisa where std_no=990002";
			//boolean flag = dao.delete(sql);
			Student student=new Student(990004,"addx",17,29,16,49,43,154,"C","A","C");
			boolean flag=dao.insert(student);
			if(flag) {
				System.out.println("insert success");
			}else {
				System.out.println("insert failed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
