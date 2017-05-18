package org.dsce.tce.cis.bean;

public class Research {
	public String Title;
	public String Description;
	public String Name1;
	public String Name2;
	public String Funding;
	public String Year;
	

	public Research() {

	}

	public Research(String Title, String Description, String Name1, String Name2,
			String Funding, String Year) {
		this.Title = Title;
		this.Description = Description;
		this.Name1 = Name1;
		this.Name2 = Name2;
		this.Funding = Funding;
		this.Year = Year;
		
	}
	public void setYear(String Year) {
		this.Year=Year;
		
	}

	public void setFunding(String Funding) {
		this.Funding=Funding;
		
	}

	public void setName2(String Name2) {
		this.Name2=Name2;
		
	}

	public void setName1(String Name1) {
		this.Name1=Name1;
		
	}

	public void setDescription(String Description) {
	this.Description=Description;
		
	}

	public void setTitle(String Title) {
		this.Title =Title;
		
	}

	public String getTitle() {
		
		return Title;
	}

	public String getDescription() {
		
		return Description;
	}

	public String getName1() {
	
		return Name1;
	}

	public String getFunding() {
		
		return Name2;
	}

	public String getYear() {
		
		return Year;
	}

}
