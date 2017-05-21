package org.dsce.tce.cis.bean;

public class SubjectUnit {

	private String subjectCode;
	private String part;
	private String unit;
	private String unitTitle;
	private String unitDescription;
	private String unitHours;

	public SubjectUnit() {
		super();
	}

	public SubjectUnit(String subjectCode, String part, String unit, String unitTitle, String unitDescription,
			String unitHours) {
		super();
		this.subjectCode = subjectCode;
		this.part = part;
		this.unit = unit;
		this.unitTitle = unitTitle;
		this.unitDescription = unitDescription;
		this.unitHours = unitHours;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnitTitle() {
		return unitTitle;
	}

	public void setUnitTitle(String unitTitle) {
		this.unitTitle = unitTitle;
	}

	public String getUnitDescription() {
		return unitDescription;
	}

	public void setUnitDescription(String unitDescription) {
		this.unitDescription = unitDescription;
	}

	public String getUnitHours() {
		return unitHours;
	}

	public void setUnitHours(String unitHours) {
		this.unitHours = unitHours;
	}

}
