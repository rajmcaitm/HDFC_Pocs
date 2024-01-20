package com.hdfc.serviceImpl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.entities.SBAccount;
import com.hdfc.repository.SBAccountRepository;
import com.hdfc.service.SBAccountService;

@Service
public class SBAccountServiceImpl implements SBAccountService {

	@Autowired
	SBAccountRepository sbAccountRepository;

	@Override
	public SBAccount createSBAccount(SBAccount sbAccount) {

		sbAccount.setRefNo(generateRefNo());
		
		return sbAccountRepository.save(sbAccount);
	}

	public long generateRefNo() {

		int min = 100000;
		int max = 999999;
		long num = (long) (Math.random() * (max - min + 1) + min);
		return num;
	}

}
