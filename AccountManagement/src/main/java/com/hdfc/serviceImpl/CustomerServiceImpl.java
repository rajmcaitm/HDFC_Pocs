package com.hdfc.serviceImpl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.entities.CustomerTable;
import com.hdfc.repository.AccountNumberRepository;
import com.hdfc.repository.CustomerRepository;
import com.hdfc.service.CustomerService;
import com.hdfc.service.SendOTP;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	AccountNumberRepository accountNumberRepository;

	@Autowired
	SendOTP sendOTP;

	@Override
	public CustomerTable isCustIdExist(Long customerId) throws ParseException {

		CustomerTable custTable = customerRepository.validateCustomerId(customerId);
		String to = "+91" + Long.toString(customerRepository.getCustomerMoboleNo(customerId));
		if (custTable.getCustId() != null && customerId.equals(custTable.getCustId())) {
			sendOTP.send(to);
		}
		return custTable;
	}

	public List<?> getAccountNumbersbyCustId(Long custId) {
		return accountNumberRepository.findListOfAccountNoByCustId(custId);
	}

	@Override
	public String getBalanceByAccountNo(Long accountNo) {
		String toMobileNo = "+91" + Long.toString(customerRepository.getCustomerPhoneNo(accountNo));
		sendOTP.sendBalanceAsOTP(toMobileNo, accountNumberRepository.getAccBalanceByAccountNo(accountNo));
		return toMobileNo;
	}

}
