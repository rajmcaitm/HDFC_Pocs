package com.hdfc.service;

import com.hdfc.dto.Customer;
import com.hdfc.dto.SmsPojo;

public interface MobileService {
	
	SmsPojo getCustomerMobileNo(Customer customer);

}
