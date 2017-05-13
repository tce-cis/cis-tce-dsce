package org.dsce.tce.cis.bean;

public class Subject {

	private String subjectName;
	private String code;
	private String iaMarks;
	private String examHrs;
	private String hrsPerWeek;
	private String totalHrs;
	private String examMarks;

	public Subject() {

	}

	public Subject(String subjectName, String code, String iaMarks, String examHrs,
			String hrsPerWeek, String totalHrs, String examMarks) {
		this.subjectName = subjectName;
		this.code = code;
		this.iaMarks = iaMarks;
		this.examHrs = examHrs;
		this.hrsPerWeek = hrsPerWeek;
		this.totalHrs = totalHrs;
		this.examMarks = examMarks;
	}

	public String getsubjectName() {
		return subjectName;
	}

	public void setsubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getcode() {
		return code;
	}

	public void setcode(String code) {
		this.code = code;
	}

	public String getiaMarks() {
		return iaMarks;
	}

	public void setiaMarks(String iaMarks) {
		this.iaMarks = iaMarks;
	}

	public String gethrsPerWeek() {
		return hrsPerWeek;
	}

	public void sethrsPerWeek(String hrsPerWeek) {
		this.hrsPerWeek = hrsPerWeek;
	}

	public String gettotalHrs() {
		return totalHrs;
	}

	public void settotalHrs(String totalHrs) {
		this.totalHrs = totalHrs;
	}

	public String getexamHrs() {
		return examHrs;
	}

	public void setexamHrs(String examHrs) {
		this.examHrs = examHrs;
	}

	public String getexamMarks() {
		return examMarks;
	}

	public void setexamMarks(String examMarks) {
		this.examMarks = examMarks;
	}

}



