package com.hdfc.service;

import java.text.ParseException;
import java.util.List;

import com.hdfc.entities.CustomerTable;

public interface CustomerService {

	public CustomerTable isCustIdExist(Long customerId) throws ParseException;

	public List<?> getAccountNumbersbyCustId(Long custId);
	
	String getBalanceByAccountNo(Long accountNo);

}
