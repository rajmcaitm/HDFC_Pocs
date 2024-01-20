package com.hdfc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.entities.AccountDetails;
import com.hdfc.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/accountDetails")
	public ResponseEntity<AccountDetails> createUser(@RequestBody AccountDetails account) {
		AccountDetails savedAcc = accountService.createAccount(account);
		return new ResponseEntity<>(savedAcc, HttpStatus.CREATED);
	}

	
}