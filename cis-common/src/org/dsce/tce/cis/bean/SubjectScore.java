package org.dsce.tce.cis.bean;

public class SubjectScore {

	private String subjectCode;
	private String semesterNumber;
	private String internalMarks;
	private String externalMarks;

	public SubjectScore() {
		super();
	}

	public SubjectScore(String subjectCode, String semesterNumber, String internalMarks, String externalMarks) {
		super();
		this.subjectCode = subjectCode;
		this.semesterNumber = semesterNumber;
		this.internalMarks = internalMarks;
		this.externalMarks = externalMarks;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSemesterNumber() {
		return semesterNumber;
	}

	public void setSemesterNumber(String semesterNumber) {
		this.semesterNumber = semesterNumber;
	}

	public String getInternalMarks() {
		return internalMarks;
	}

	public void setInternalMarks(String internalMarks) {
		this.internalMarks = internalMarks;
	}

	public String getExternalMarks() {
		return externalMarks;
	}

	public void setExternalMarks(String externalMarks) {
		this.externalMarks = externalMarks;
	}

}
