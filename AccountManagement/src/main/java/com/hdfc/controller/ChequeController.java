package com.hdfc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.entities.Cheque;
import com.hdfc.service.ChequeService;
import com.hdfc.service.CustomerService;

@RestController
@RequestMapping("/v1/api")
public class ChequeController {
	
	@Autowired
	ChequeService chequeService;
	
	@Autowired
	private CustomerService accountService;
	
	@GetMapping("getChequeBookAccountNumbers/{customerId}")
	public List<?> getAccountNumbersByCustId(@PathVariable Long customerId) {
		return accountService.getAccountNumbersbyCustId(customerId);
	}
	
	@GetMapping("address/{accountNo}/{quantity}")
	public ResponseEntity<String> getCustomerAddressByAccountNumber(@PathVariable Long accountNo, @PathVariable Integer quantity) {
		return new ResponseEntity<> (chequeService.getCustomerAddress(accountNo, quantity), HttpStatus.OK);
	}
	
	@PostMapping("otp/{accountNo}")
	public ResponseEntity<String> sendOTPForChqqueBookRequest(@PathVariable Long accountNo) {
		chequeService.sendOTPForChqqueBookRequest(accountNo);
		return new ResponseEntity<> ("~ your cheque book request has been placed successfully ~", HttpStatus.OK);
	}
	
	@PutMapping("stopCheque/{accountNo}/{chequeNo}")
	public ResponseEntity<?> stopChequePayment(@PathVariable Long accountNo, @PathVariable Long chequeNo) {
		
		String chqStatus =chequeService.getChequeStatus(chequeNo);
		
		String chequePaid="PAID\n ** Invalid Request. Cheque already passed **";
		String chequeNotUsed="UNUSED";
		if("paid".equalsIgnoreCase(chqStatus))
		{
			return new ResponseEntity<> (chequePaid,HttpStatus.OK);
		}
		else
		{   
			chequeService.getMobileNoForOTP(accountNo);
			return new ResponseEntity<> (chequeNotUsed,HttpStatus.OK);
		}
		
	} 
	
	@GetMapping("stopCheque/{accountNo}/{chequeNo}/{chequeStatus}")
	public ResponseEntity<?> stopChequePaymentAPI(@PathVariable Long accountNo, @PathVariable Long chequeNo, @PathVariable String chequeStatus) {
		
		String detailsMsg =chequeService.stopChequePaymentAPI(accountNo, chequeNo, chequeStatus);
		
		return new ResponseEntity<>(detailsMsg, HttpStatus.OK);
		
	} 
	
	
	
}
