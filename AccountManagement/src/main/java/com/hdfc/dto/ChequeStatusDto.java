package com.hdfc.dto;

import java.time.LocalDate;

public class ChequeStatusDto {
	private Long chequeNo;
	private String chequeStatus;
	private String paidTo;
	private Double chequeAmount; 
	private LocalDate clearingDate;
	
	public ChequeStatusDto() {
		super();
	}

	public ChequeStatusDto(String paidTo, Double chequeAmount) {
		super();
		this.paidTo = paidTo;
		this.chequeAmount = chequeAmount;
	}

	public ChequeStatusDto(Long chequeNo, String chequeStatus, String paidTo, Double chequeAmount,
			LocalDate clearingDate) {
		super();
		this.chequeNo = chequeNo;
		this.chequeStatus = chequeStatus;
		this.paidTo = paidTo;
		this.chequeAmount = chequeAmount;
		this.clearingDate = clearingDate;
	}

	public Long getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(Long chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getChequeStatus() {
		return chequeStatus;
	}

	public void setChequeStatus(String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}

	public String getPaidTo() {
		return paidTo;
	}

	public void setPaidTo(String paidTo) {
		this.paidTo = paidTo;
	}

	public Double getChequeAmount() {
		return chequeAmount;
	}

	public void setChequeAmount(Double chequeAmount) {
		this.chequeAmount = chequeAmount;
	}

	public LocalDate getClearingDate() {
		return clearingDate;
	}

	public void setClearingDate(LocalDate clearingDate) {
		this.clearingDate = clearingDate;
	}

	@Override
	public String toString() {
		return "ChequeStatusDto [chequeNo=" + chequeNo + ", chequeStatus=" + chequeStatus + ", paidTo=" + paidTo
				+ ", chequeAmount=" + chequeAmount + ", clearingDate=" + clearingDate + "]";
	}
}
