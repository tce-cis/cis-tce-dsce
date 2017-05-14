package org.dsce.tce.cis.bean;

public class Subject {

	private String name;
	private String code;
	private String iaMarks;
	private String examHours;
	private String hoursPerWeek;
	private String totalHours;
	private String examMarks;

	public Subject() {

	}

	public Subject(String subjectName, String code, String iaMarks, String examHrs, String hrsPerWeek, String totalHrs,
			String examMarks) {
		this.name = subjectName;
		this.code = code;
		this.iaMarks = iaMarks;
		this.examHours = examHrs;
		this.hoursPerWeek = hrsPerWeek;
		this.totalHours = totalHrs;
		this.examMarks = examMarks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIaMarks() {
		return iaMarks;
	}

	public void setIaMarks(String iaMarks) {
		this.iaMarks = iaMarks;
	}

	public String getExamHours() {
		return examHours;
	}

	public void setExamHours(String examHours) {
		this.examHours = examHours;
	}

	public String getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(String hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	public String getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(String totalHours) {
		this.totalHours = totalHours;
	}

	public String getExamMarks() {
		return examMarks;
	}

	public void setExamMarks(String examMarks) {
		this.examMarks = examMarks;
	}

}
