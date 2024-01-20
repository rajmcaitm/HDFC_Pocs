package com.hdfc.remittance.dto;

public class GetPayeeDetails {

	Long accountnumber;
	String accountname;
	String addressline1;
	String addressline2;
	String swiftcode;
	String city;
	Float totalamountininr;
	Float fcyamount;

	public GetPayeeDetails() {

	}

	public GetPayeeDetails(Long accountnumber, String accountname, String addressline1, String addressline2,
			String swiftcode, String city, Float totalamountininr, Float fcyamount) {
		super();
		this.accountnumber = accountnumber;
		this.accountname = accountname;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.swiftcode = swiftcode;
		this.city = city;
		this.totalamountininr = totalamountininr;
		this.fcyamount = fcyamount;
	}

	public Long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(Long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getSwiftcode() {
		return swiftcode;
	}

	public void setSwiftcode(String swiftcode) {
		this.swiftcode = swiftcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Float getTotalamountininr() {
		return totalamountininr;
	}

	public void setTotalamountininr(Float totalamountininr) {
		this.totalamountininr = totalamountininr;
	}

	public Float getFcyamount() {
		return fcyamount;
	}

	public void setFcyamount(Float fcyamount) {
		this.fcyamount = fcyamount;
	}

	@Override
	public String toString() {
		return "GetPayeeDetails [accountnumber=" + accountnumber + ", accountname=" + accountname + ", addressline1="
				+ addressline1 + ", addressline2=" + addressline2 + ", swiftcode=" + swiftcode + ", city=" + city
				+ ", totalamountininr=" + totalamountininr + ", fcyamount=" + fcyamount + "]";
	}

}
