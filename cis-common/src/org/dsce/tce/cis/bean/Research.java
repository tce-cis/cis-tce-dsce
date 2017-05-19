package org.dsce.tce.cis.bean;

public class Research {

	private String title;
	private String description;
	private String piNameDesignation;
	private String coPiNameDesignation;
	private String fundingAgencyAndAmount;
	private String startYearEndYear;

	public Research() {
		super();
	}

	public Research(String title, String description, String piNameDesignation, String coPiNameDesignation,
			String fundingAgencyAndAmount, String startYearEndYear) {
		super();
		this.title = title;
		this.description = description;
		this.piNameDesignation = piNameDesignation;
		this.coPiNameDesignation = coPiNameDesignation;
		this.fundingAgencyAndAmount = fundingAgencyAndAmount;
		this.startYearEndYear = startYearEndYear;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPiNameDesignation() {
		return piNameDesignation;
	}

	public void setPiNameDesignation(String piNameDesignation) {
		this.piNameDesignation = piNameDesignation;
	}

	public String getCoPiNameDesignation() {
		return coPiNameDesignation;
	}

	public void setCoPiNameDesignation(String coPiNameDesignation) {
		this.coPiNameDesignation = coPiNameDesignation;
	}

	public String getFundingAgencyAndAmount() {
		return fundingAgencyAndAmount;
	}

	public void setFundingAgencyAndAmount(String fundingAgencyAndAmount) {
		this.fundingAgencyAndAmount = fundingAgencyAndAmount;
	}

	public String getStartYearEndYear() {
		return startYearEndYear;
	}

	public void setStartYearEndYear(String startYearEndYear) {
		this.startYearEndYear = startYearEndYear;
	}

}
