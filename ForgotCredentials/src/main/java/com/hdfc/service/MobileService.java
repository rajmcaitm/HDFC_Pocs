package com.hdfc.service;

import com.hdfc.dto.CustIdMobile;
import com.hdfc.dto.Customer;
import com.hdfc.dto.CustomerDetails;
import com.hdfc.dto.DebitCard;
import com.hdfc.dto.MobileCardNoPin;
import com.hdfc.dto.SmsPojo;

public interface MobileService {
	
	SmsPojo getCustomerMobileNo(Customer customer);
	MobileCardNoPin sendOtp(DebitCard debitCard);
	CustIdMobile getCustomerId(CustomerDetails customerDetails);
	
}
