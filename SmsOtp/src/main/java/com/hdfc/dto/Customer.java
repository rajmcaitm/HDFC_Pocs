package com.hdfc.dto;

public class Customer {

	private Long customerId;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + "]";
	}

	
	
}
