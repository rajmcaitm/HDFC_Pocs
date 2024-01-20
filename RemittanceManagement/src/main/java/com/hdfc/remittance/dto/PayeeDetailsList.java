package com.hdfc.remittance.dto;

public class PayeeDetailsList {
	String nickName;
	Long accountNumber;
	String swiftCode;
	String city;
	String country;
	public PayeeDetailsList() {
		super();
		
	}
	public PayeeDetailsList(String nickName, Long accountNumber, String swiftCode, String city, String country) {
		super();
		this.nickName = nickName;
		this.accountNumber = accountNumber;
		this.swiftCode = swiftCode;
		this.city = city;
		this.country = country;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getSwiftCode() {
		return swiftCode;
	}
	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "PayeeDetailsResponse [nickName=" + nickName + ", accountNumber=" + accountNumber + ", swiftCode="
				+ swiftCode + ", city=" + city + ", country=" + country + "]";
	}
	
}
