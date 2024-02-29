package sku.lesson.practice.copy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import basic.lesson.db.Student;

public class JDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBCMain main = new JDBCMain();
		//main.testCRUD();
		main.makeDataFromFile();
	}
	
	public void testCRUD() {
		//String sql = "insert into gisa values (990002,'addx',17,29,16,49,43,154,'C','A','C')";
		GisaDAO dao = new GisaDAO();
		try {
			//boolean flag = dao.insert(sql);
			//sql = "delete from gisa where std_no = ?";
			//boolean flag = dao.delete(sql);
			//Student student = new Student(990003,"addx",17,29,16,49,43,154,"C","A","C");
			//boolean flag = dao.insert(student);
//			boolean flag = dao.insert(this.makeData());
//			if(flag) {
//				System.out.println("insert success");
//			} else {
//				System.out.println("insert fail");
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Student>makeData(){
		ArrayList<Student> list=null;
		GisaDAO dao=new GisaDAO();
		String sql="select * from  gisa";
		list=dao.select(sql);
		
		return list;
	}
	
	public ArrayList<Student> makeDataFromFile(){
		ArrayList<Student> list = null;
		//file에 접속하여 생성
		File file = new File("Abc1115.csv");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			
			list = new ArrayList<Student>();
			while((line=br.readLine())!=null) {
				String[] temp = line.split(",");
				int stdNo = Integer.parseInt(temp[0]);
				String email = temp[1];
				int kor = Integer.parseInt(temp[2].trim());
				int eng = Integer.parseInt(temp[3].trim());
				int math = Integer.parseInt(temp[4].trim());
				int sci = Integer.parseInt(temp[5].trim());
				int hist = Integer.parseInt(temp[6].trim());
				int total = Integer.parseInt(temp[7].trim());
				String mgrCode = temp[8];
				String accCode = temp[9];
				String locCode = temp[10];
				Student student = new Student(stdNo, email, kor, eng, math, sci, hist, total, mgrCode, accCode, locCode);
				list.add(student);
			}
			
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		
		return list;
	}

}
