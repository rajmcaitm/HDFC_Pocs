package com.hdfc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.dto.CustomerResponse;
import com.hdfc.entities.AccountDetails;
import com.hdfc.entities.Customer;
import com.hdfc.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/api/{custId}")
	public ResponseEntity<CustomerResponse> findCustomerDetailsByCustId(@PathVariable Long custId) {

		CustomerResponse cust = customerService.findCustomerDetailsByCustId(custId);
		System.out.println("cust response"+cust);
		return new ResponseEntity<CustomerResponse>(cust, HttpStatus.OK);
	}
	@PostMapping("/custDetails")
	public ResponseEntity<Customer> createUser(@RequestBody Customer customer) {
		Customer savedCust = customerService.createCustomer(customer);
		return new ResponseEntity<>(savedCust, HttpStatus.CREATED);
	}
	
	

}
