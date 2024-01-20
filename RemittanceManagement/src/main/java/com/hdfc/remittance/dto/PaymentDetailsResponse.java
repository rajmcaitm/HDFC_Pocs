package com.hdfc.remittance.dto;

public class PaymentDetailsResponse {
	private String accountNum;
	private String balance;
	private String remittanceCurrency;

	public PaymentDetailsResponse() {
		super();

	}

	public PaymentDetailsResponse(String accountNum, String balance, String remittanceCurrency) {
		super();
		this.accountNum = accountNum;
		this.balance = balance;
		this.remittanceCurrency = remittanceCurrency;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getRemittanceCurrency() {
		return remittanceCurrency;
	}

	public void setRemittanceCurrency(String remittanceCurrency) {
		this.remittanceCurrency = remittanceCurrency;
	}

	@Override
	public String toString() {
		return "PaymentDetailsResponse [accountNum=" + accountNum + ", balance=" + balance + ", remittanceCurrency="
				+ remittanceCurrency + "]";
	}

}
