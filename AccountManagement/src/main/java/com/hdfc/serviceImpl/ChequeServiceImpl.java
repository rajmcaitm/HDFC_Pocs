package com.hdfc.serviceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.entities.Cheque;
import com.hdfc.repository.AccountNumberRepository;
import com.hdfc.repository.ChequeRepository;
import com.hdfc.repository.CustomerRepository;
import com.hdfc.service.ChequeService;
import com.hdfc.service.SendOTP;

@Service
public class ChequeServiceImpl implements ChequeService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountNumberRepository accountNumberRepository;

	@Autowired
	SendOTP sendOTP;

	@Autowired
	ChequeRepository chequeRepository;

	public List<?> getAccountNumbersbyCustId(Long custId) {
		return accountNumberRepository.findListOfAccountNoByCustId(custId);
	}

	@Override
	public String getCustomerAddress(Long accountNo, Integer quantity) {
		customerRepository.saveChequeQuantity(quantity, accountNo);
		return customerRepository.getCustomerAddressByAccountNo(accountNo);
	}

	@Override
	public void sendOTPForChqqueBookRequest(Long accountNo) {
		String toMobileNo = "+91" + Long.toString(customerRepository.getCustomerPhoneNo(accountNo));
		sendOTP.send(toMobileNo);
	}

	@Override
	public String getChequeStatus(Long chequeNo) {

		return chequeRepository.getChequeStatus(chequeNo);
	}

	@Override
	public void getMobileNoForOTP(Long accountNo) {
		Long mobileNo = customerRepository.getCustomerPhoneNo(accountNo);
		sendOTP.send(String.valueOf("+91" + mobileNo));
	}

	@Override
	public String stopChequePaymentAPI(Long accountNo, Long chequeNo, String chequeStatus) {
		String name = chequeRepository.getChequeDetails(accountNo);
		String msg = "** "+name+" bearing Acc Number - "+accountNo+".\n" +"Cheque Number #"+chequeNo+" has been stopped on "+LocalDate.now()+" "+"@"+LocalTime.now()+".**";  
		return msg;
	}

}
