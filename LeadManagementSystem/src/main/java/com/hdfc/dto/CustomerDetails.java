package com.hdfc.dto;

import java.util.List;

public class CustomerDetails {
	
private Long customerId;
private Long customerMobileNo;
private String customerName;
private String customerEmailId;
private List<Account> customerAccountNo;

public CustomerDetails(Long customerId, Long customerMobileNo, String customerName, String customerEmailId,
		List<Account> customerAccountNo) {
	super();
	this.customerId = customerId;
	this.customerMobileNo = customerMobileNo;
	this.customerName = customerName;
	this.customerEmailId = customerEmailId;
	this.customerAccountNo = customerAccountNo;
}
public CustomerDetails() {

}
public Long getCustomerId() {
	return customerId;
}
public void setCustomerId(Long customerId) {
	this.customerId = customerId;
}
public Long getCustomerMobileNo() {
	return customerMobileNo;
}
public void setCustomerMobileNo(Long customerMobileNo) {
	this.customerMobileNo = customerMobileNo;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getCustomerEmailId() {
	return customerEmailId;
}
public void setCustomerEmailId(String customerEmailId) {
	this.customerEmailId = customerEmailId;
}


public List<Account> getCustomerAccountNo() {
	return customerAccountNo;
}
public void setCustomerAccountNo(List<Account> customerAccountNo) {
	this.customerAccountNo = customerAccountNo;
}
@Override
public String toString() {
	return "CustomerDetails [customerId=" + customerId + ", customerMobileNo=" + customerMobileNo + ", customerName="
			+ customerName + ", customerEmailId=" + customerEmailId + ", customerAccountNo=" + customerAccountNo + "]";
}

}
