package com.hdfc.dto;

public class DebitCard {
	
	private String debitCardNo;
	private Integer debitCardPin;
	
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
	public DebitCard(String debitCardNo, Integer debitCardPin) {
		super();
		this.debitCardNo = debitCardNo;
		this.debitCardPin = debitCardPin;
	}
	@Override
	public String toString() {
		return "DebitCard [debitCardNo=" + debitCardNo + ", debitCardPin=" + debitCardPin + "]";
	}
	
}
