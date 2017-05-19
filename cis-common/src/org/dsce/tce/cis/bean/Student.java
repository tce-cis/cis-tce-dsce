package org.dsce.tce.cis.bean;

import java.util.List;

public class Student {

	private String usn;
	private List<SubjectScore> marksCard;

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	public List<SubjectScore> getMarksCard() {
		return marksCard;
	}

	public void setMarksCard(List<SubjectScore> marksCard) {
		this.marksCard = marksCard;
	}

}
