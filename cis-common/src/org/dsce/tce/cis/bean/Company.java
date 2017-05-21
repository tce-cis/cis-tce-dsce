package org.dsce.tce.cis.bean;

public class Company {

	private String name;
	private int noOffers;
	private float ctc;
	private String companyType;

	public Company() {

	}

	public Company(String name, int noOffers, float ctc, String companyType) {
		this.name = name;
		this.noOffers = noOffers;
		this.ctc = ctc;
		this.companyType = companyType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOffers() {
		return noOffers;
	}

	public void setNoOffers(int noOfStudentsPlaced) {
		this.noOffers = noOfStudentsPlaced;
	}

	public float getCtc() {
		return ctc;
	}

	public void setCtc(float ctc) {
		this.ctc = ctc;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

}
