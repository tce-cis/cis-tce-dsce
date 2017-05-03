package org.dsce.tce.cis.bean;

import java.util.Map;

public class MarksCard {

	private byte semesterNumber;
	private Map<String, Byte> subjectScores;

	public byte getSemesterNumber() {
		return semesterNumber;
	}

	public void setSemesterNumber(byte semesterNumber) {
		this.semesterNumber = semesterNumber;
	}

	public Map<String, Byte> getSubjectScores() {
		return subjectScores;
	}

	public void setSubjectScores(Map<String, Byte> subjectScores) {
		this.subjectScores = subjectScores;
	}

}
