package com.hdfc.service;

import com.hdfc.entities.Customer;

public interface CustomerService {

	Customer registerCustomer(Customer customer);

	Double checkBalance(Long accountNo, String username, String password);

	Double depositMoney(Long accountNo, Double amount);

	Double withdrawMoney(Long accountNo, Double amount);

	public Customer toCloseAccount(Long accountNo);

}