package com.hdfc.serviceImpl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.dto.CustomerDto;
import com.hdfc.entities.Customer;
import com.hdfc.repository.CustomerRepositoty;
import com.hdfc.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepositoty customerRepositoty;

	@Override
		public Customer registerCustomer(Customer customer) {
		Long accountNo = generateRandom(12);
		customer.setAccountNo(accountNo);
		return customerRepositoty.save(customer);
	}
	
	public static long generateRandom(int length) {
		Random random = new Random();
		char[] digits = new char[length];
		digits[0] = (char) (random.nextInt(9) + '1');
		for (int i = 1; i < length; i++) {
			digits[i] = (char) (random.nextInt(10) + '0');
		}
		return Long.parseLong(new String(digits));
	}
	
	
	@Override
    public Double checkBalance(Long accountNo, String username, String password) {
        return this.customerRepositoty.checkBalance(accountNo, username, password);
    }

	@Override
	public Double depositMoney(Long accountNo, Double amount) {
		Double dbAmount = customerRepositoty.getAmountByAccountNo(accountNo);
		Double totalAmount = dbAmount + amount;
		customerRepositoty.updateDepositAmount(totalAmount, accountNo);
		return totalAmount;

	}
	
	@Override
	public Double withdrawMoney(Long accountNo, Double amount) {
		Double dbAmount = customerRepositoty.getAmountByAccountNo(accountNo);
		Double remainingAmount = dbAmount - amount;
		customerRepositoty.updateRemainingAmount(remainingAmount, accountNo);
		return remainingAmount;

	}

	@Override
	public Customer toCloseAccount(Long accountNo) {
		return customerRepositoty.toCloseAccount(accountNo);
	}
}
