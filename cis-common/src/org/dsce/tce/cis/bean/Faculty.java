package org.dsce.tce.cis.bean;

public class Faculty {

	private String name;
	private String designation;
	private String educationalQualification;
	private String experienceYears;
	private String specialization;
	private String emailId;
	private String phoneNumber;
	private String salutation;

	public Faculty() {

	}

	public Faculty(String name, String designation, String educationalQualification, String experienceYears,
			String specialization, String emailId, String phone, String salutation) {
		this.name = name;
		this.designation = designation;
		this.educationalQualification = educationalQualification;
		this.experienceYears = experienceYears;
		this.specialization = specialization;
		this.emailId = emailId;
		this.phoneNumber = phone;
		this.salutation = salutation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEducationalQualification() {
		return educationalQualification;
	}

	public void setEducationalQualification(String educationalQualification) {
		this.educationalQualification = educationalQualification;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(String experienceYears) {
		this.experienceYears = experienceYears;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

}
