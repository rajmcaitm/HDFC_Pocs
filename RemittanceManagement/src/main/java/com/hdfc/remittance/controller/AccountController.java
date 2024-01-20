package com.hdfc.remittance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.remittance.entity.AccountDetails;
import com.hdfc.remittance.entity.ChargesDetails;
import com.hdfc.remittance.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("account/{custId}")
	public ResponseEntity<?> getCustId(@PathVariable Long custId) {

		List<AccountDetails> cust = accountService.findAllById(custId);
		System.out.println(cust);
		return new ResponseEntity<>(cust, HttpStatus.OK);
	}
	
	@PostMapping("/updateBalance/{accountNo}/{fcyAmount}")
	public ResponseEntity<String> updateRemainingBalance(@PathVariable String accountNo, @PathVariable Float fcyAmount) {
		accountService.updateRemainingBalance(accountNo, fcyAmount);
		return new ResponseEntity<String>("Balance Updated", HttpStatus.OK);
	}
	

	@GetMapping("getListAccount/{custId}")
	public ResponseEntity<?> getListOfAccountNo(@PathVariable Long custId) {

		List<String> accountList = accountService.getListOfAccountNo(custId);
		return new ResponseEntity<>(accountList, HttpStatus.OK);
	}

}
