package com.hdfc.dto;

public class MobileCardNoPin {
	
	private String debitCardNo;
	private Integer debitCardPin;
	private String mobileNo;
	public MobileCardNoPin(String debitCardNo, Integer debitCardPin, String mobileNo) {
		super();
		this.debitCardNo = debitCardNo;
		this.debitCardPin = debitCardPin;
		this.mobileNo = mobileNo;
	}
	
	public MobileCardNoPin() {
		
	}
	public String getDebitCardNo() {
		return debitCardNo;
	}
	public void setDebitCardNo(String debitCardNo) {
		this.debitCardNo = debitCardNo;
	}
	public Integer getDebitCardPin() {
		return debitCardPin;
	}
	public void setDebitCardPin(Integer debitCardPin) {
		this.debitCardPin = debitCardPin;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "MobileCardNoPin [debitCardNo=" + debitCardNo + ", debitCardPin=" + debitCardPin + ", mobileNo="
				+ mobileNo + "]";
	}
	

	
}
