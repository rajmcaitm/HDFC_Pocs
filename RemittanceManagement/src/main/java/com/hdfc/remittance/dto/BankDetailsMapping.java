package com.hdfc.remittance.dto;

public class BankDetailsMapping {
	private Double no;
	private String institution;
	private String cityHeading;
	private String country;
	private String branchName;
	private String swiftCode;

	public BankDetailsMapping() {
	}

	public BankDetailsMapping(Double no, String institution, String cityHeading, String country, String branchName,
			String swiftCode) {
		super();
		this.no = no;
		this.institution = institution;
		this.cityHeading = cityHeading;
		this.country = country;
		this.branchName = branchName;
		this.swiftCode = swiftCode;
	}

	public Double getNo() {
		return no;
	}

	public void setNo(Double no) {
		this.no = no;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getCityHeading() {
		return cityHeading;
	}

	public void setCityHeading(String cityHeading) {
		this.cityHeading = cityHeading;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

}