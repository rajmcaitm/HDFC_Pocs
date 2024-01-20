package com.hdfc.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.hdfc.dto.CustomerResponse;
import com.hdfc.entities.Customer;

@Service
public interface CustomerService {
	
	public CustomerResponse findCustomerDetailsByCustId(Long custId);
	
	Customer createCustomer(Customer customer);

}