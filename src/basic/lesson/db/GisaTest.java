package basic.lesson.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class GisaTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		GisaTest main=new GisaTest();
		main.testStart();
		
	}
	
	public void testStart() {
		GisaDAO gisa=new GisaDAO();
		String queryAnwer1="";
		String queryAnwer2="select max(kor+eng) maxscore from gisa where locCode='B'";
		String queryAnwer3="";
		String queryAnwer4="";
		try {
			String answer=gisa.selectQuiz1(queryAnwer1);
			this.pirntAnswer(1, answer);
			answer=gisa.selectQuiz2(queryAnwer2);
			this.pirntAnswer(2, answer);
			answer=gisa.selectQuiz3(queryAnwer3);
			this.pirntAnswer(3, answer);
			answer=gisa.selectQuiz4(queryAnwer4);
			this.pirntAnswer(4, answer);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void pirntAnswer(int quizNumber, String answer) {
		
	}
	
}

