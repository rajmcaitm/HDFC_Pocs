package com.hdfc.remittance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.remittance.dto.PayeeDetailsList;
import com.hdfc.remittance.service.GetPayeeService;
@RestController
public class GetPayeeController {
	@Autowired
	GetPayeeService getPayeeService;
	
	@GetMapping("payeedetails/{custId}")
	public ResponseEntity<?> getAllPayeeDetails(@PathVariable Long custId) {

		@SuppressWarnings("unchecked")
		List<PayeeDetailsList> cust = getPayeeService.findAllPayeeByCustomer(custId);
	    System.out.println(cust);
		return new ResponseEntity<>( cust, HttpStatus.OK);
	}
}
