package com.hdfc.dto;

public class Account {

	private Long customerAccountNo;

	public Account() {

	}
	public Account(Long customerAccountNo) {
		super();
		this.customerAccountNo = customerAccountNo;
	}

	public Long getCustomerAccountNo() {
		return customerAccountNo;
	}

	public void setCustomerAccountNo(Long customerAccountNo) {
		this.customerAccountNo = customerAccountNo;
	}

	@Override
	public String toString() {
		return "Account [customerAccountNo=" + customerAccountNo + "]";
	}

	
	
}
