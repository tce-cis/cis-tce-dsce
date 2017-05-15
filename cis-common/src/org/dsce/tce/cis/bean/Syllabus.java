package org.dsce.tce.cis.bean;

public class Syllabus {

	private String subjectCode;
	private String part;
	private String unit;
	private String unitTitle;
	private String UnitDescription;
	private String unitHours;
	

	public Syllabus() {

	}

	public Syllabus(String subjectCode , String part , String unit, String unitTitle,
			String unitDescription, String unitHours) {
		this.subjectCode = subjectCode;
		this.part = part;
		this.unit = unit;
		this.unitTitle = unitTitle;
		this.UnitDescription = unitDescription;
		this.unitHours = unitHours;
	
	}

	public String getName() {
		return subjectCode;
	}

	public void setName(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getpart() {
		return part;
	}

	public void setpart(String part) {
		this.part = part;
	}

	public String getunit() {
		return unit;
	}

	public void setunit(String unit) {
		this.unit= unit;
	}
	
	public String getunitTitle() {
		return unitTitle;
	}

	public void setunitTitle(String unitTitle) {
		this.unitTitle= unitTitle;
		
	}

	public String getUnitDescription() {
		return UnitDescription;
	}

	public void setUnitDescription(String UnitDescription) {
		this.UnitDescription = UnitDescription;
	}

	

	public String getunitHours(){
		return unitHours;
	}

	public void setunitHours(String unitHours) {
		this.unitTitle= unitHours;
	}

	public static void setsubjectCode(String trim) {
		// TODO Auto-generated method stub
		
	}


	
		// TODO Auto-generated method stub
		
	}

	




