package sku.lesson.practice.copy;

public class Student {
	private int stuNo;
	private String email;
	private int kor;
	private int eng;
	private int math;
	private int sci;
	private int his;
	private int total;
	private String mgrCode;
	private String achCode;
	private String locCode;
	
	Student(int stuNo, String email, int kor, int eng, int math, int sci, int his, int total, String mgrCode, String achCode, String locCode){
		super();
		this.stuNo = stuNo;
		this.email = email;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sci = sci;
		this.his = his;
		this.total = total;
		this.mgrCode = mgrCode;
		this.achCode = achCode;
		this.locCode = locCode;
	}

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSci() {
		return sci;
	}

	public void setSci(int sci) {
		this.sci = sci;
	}

	public int getHis() {
		return his;
	}

	public void setHis(int his) {
		this.his = his;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getMgrCode() {
		return mgrCode;
	}

	public void setMgrCode(String mgrCode) {
		this.mgrCode = mgrCode;
	}

	public String getAchCode() {
		return achCode;
	}

	public void setAchCode(String achCode) {
		this.achCode = achCode;
	}

	public String getLocCode() {
		return locCode;
	}

	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}
	
	@Override
	public String toString() {
		return "Student [stuNo="+stuNo+", email="+email+", kor="+kor+",eng "+eng+", math"+math+", sci"+sci+", his"+his+
				", total"+total+", mgrCode"+mgrCode+", achCode"+achCode+", locCode"+locCode +"]";
	}
}
