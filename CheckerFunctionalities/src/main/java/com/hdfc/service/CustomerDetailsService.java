package com.hdfc.service;

import com.hdfc.dto.CheckerCustomerDetails;
import com.hdfc.dto.CustomerDetails;

public interface CustomerDetailsService {

	CustomerDetails getCustomerDetails(Long refNo);

	CheckerCustomerDetails getCheckerCustomerDetails(Long refNo);

}
