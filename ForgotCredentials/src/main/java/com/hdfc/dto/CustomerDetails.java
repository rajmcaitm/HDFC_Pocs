package com.hdfc.dto;

public class CustomerDetails {

	private String debitCardNo;
	private Integer debitCardPin;
	private Integer debitCardOtp;
	public CustomerDetails(String debitCardNo, Integer debitCardPin, Integer debitCardOtp) {
		super();
		this.debitCardNo = debitCardNo;
		this.debitCardPin = debitCardPin;
		this.debitCardOtp = debitCardOtp;
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
	public Integer getDebitCardOtp() {
		return debitCardOtp;
	}
	public void setDebitCardOtp(Integer debitCardOtp) {
		this.debitCardOtp = debitCardOtp;
	}
	@Override
	public String toString() {
		return "CustomerDetails [debitCardNo=" + debitCardNo + ", debitCardPin=" + debitCardPin + ", debitCardOtp="
				+ debitCardOtp + "]";
	}
	
	
}
