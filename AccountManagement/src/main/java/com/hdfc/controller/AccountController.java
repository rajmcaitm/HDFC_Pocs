package com.hdfc.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.entities.CustomerTable;
import com.hdfc.exception.ResourceNotFoundException;
import com.hdfc.exception.ResponseMessage;
import com.hdfc.service.CustomerService;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {

	@Autowired
	private CustomerService accountService;

	@GetMapping("checkCustomerExist/{custId}")
	public ResponseEntity<?> isCustIdExist(@PathVariable Long custId) throws ParseException {
		String message = "";
		try {

			CustomerTable customer = accountService.isCustIdExist(custId);
			if (customer.getCustId() == null || (customer.getCustId().toString().isEmpty())) {
				throw new ResourceNotFoundException("Invalid Customer Id");
			}
			String last3Digit = Long.toString(customer.getPhoneNumber()).substring(Long.toString(customer.getPhoneNumber()).length() - 3); 
			return new ResponseEntity<>("OTP sent to registered Mobile No *******"+last3Digit, HttpStatus.OK);
		} catch (Exception e) {
			message = "INVALID CUSTOMER ID... " + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message)); 
		}

	}
	
	@GetMapping("getAccountNumbers/{customerId}")
	public List<?> getAccountNumbersByCustId(@PathVariable Long customerId) {
		return accountService.getAccountNumbersbyCustId(customerId);
	}
	
	@GetMapping("getBalance/{accountNo}") 
	public ResponseEntity<String> getBalanceByAccountNo(@PathVariable Long accountNo) {
		String mobileNo = accountService.getBalanceByAccountNo(accountNo);
		String message = "~ Balance details sent to registered mobile number "+"*******"+mobileNo.substring(mobileNo.length()-3)+" ~";
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
}
