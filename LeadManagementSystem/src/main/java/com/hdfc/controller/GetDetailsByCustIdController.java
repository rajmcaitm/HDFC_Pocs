package com.hdfc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.dto.CustomerDetails;
import com.hdfc.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GetDetailsByCustIdController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customerId/{customerId}")
	public CustomerDetails getCustMobileNo(@PathVariable("customerId") Long customerId) {

		CustomerDetails custDetails = customerService.getCustomerDetailsByCustId(customerId);

		return custDetails;
	}

}
