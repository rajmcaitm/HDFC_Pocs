package com.hdfc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.entities.SBAccount;
import com.hdfc.service.SBAccountService;

@RestController
@RequestMapping("/v1/api")
public class SBAccountController {

	@Autowired
	SBAccountService sbAccountService;

	@PostMapping("/openSBAccount")
	public ResponseEntity<SBAccount> createSBAccount(@RequestBody SBAccount sbAccount) {
		SBAccount sbAccounts = this.sbAccountService.createSBAccount(sbAccount);
		return new ResponseEntity("Ref No #"+sbAccounts.getRefNo()+"\n"+"** Hi " + sbAccounts.getCustomerName() + ",\n"
				+ "   Thank you for choosing HDFC Bank. You will receive a call within 24 hrs for further\n"
				+ "   Account opening process", HttpStatus.CREATED);
	}

}
