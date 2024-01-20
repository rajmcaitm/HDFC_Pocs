package com.hdfc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.entities.AccountDetails;
import com.hdfc.repository.AccountDetailsRepository;
import com.hdfc.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	
	@Autowired
	private AccountDetailsRepository accountDetailsRepository;

	@Override
	public AccountDetails createAccount(AccountDetails account) {
		// TODO Auto-generated method stub
		AccountDetails acctDetailsSaved = accountDetailsRepository.save(account);
		
		return acctDetailsSaved;
	}

	
	
}