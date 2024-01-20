package com.hdfc.remittance.dto;

public class PayeeDetailsResponse {

	String accountname;
	Long accountnumber;
	String nickname;
	String addressline1;
	String addressline2;
	String swiftcode;
	String city;
	
	public PayeeDetailsResponse() {
		
	}

	public PayeeDetailsResponse(String accountname, Long accountnumber, String nickname, String addressline1,
			String addressline2, String swiftcode, String city) {
		super();
		this.accountname = accountname;
		this.accountnumber = accountnumber;
		this.nickname = nickname;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.swiftcode = swiftcode;
		this.city = city;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public Long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(Long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	@Override
	public String toString() {
		return "PayeeDetailsResponse [accountname=" + accountname + ", accountnumber=" + accountnumber + ", nickname="
				+ nickname + ", addressline1=" + addressline1 + ", addressline2=" + addressline2 + ", swiftcode="
				+ swiftcode + ", city=" + city + "]";
	}
	
	
}