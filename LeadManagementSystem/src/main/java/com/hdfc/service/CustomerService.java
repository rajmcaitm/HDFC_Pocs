package com.hdfc.service;

import com.hdfc.dto.CustomerDetails;

public interface CustomerService {

	CustomerDetails getCustomerDetailsByCustId(Long customerId);

}
