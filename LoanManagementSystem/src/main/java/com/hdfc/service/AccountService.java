package com.hdfc.service;

import org.springframework.stereotype.Service;

import com.hdfc.entities.AccountDetails;

@Service
public interface AccountService {

	
	AccountDetails createAccount(AccountDetails account);

}