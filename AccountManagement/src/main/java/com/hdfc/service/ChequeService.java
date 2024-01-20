package com.hdfc.service;

public interface ChequeService {

	String getCustomerAddress(Long accountNo, Integer quantity);
	
	void sendOTPForChqqueBookRequest(Long accountNo);
	
	String getChequeStatus(Long chequeNo);
	
	void getMobileNoForOTP(Long accountNo);

	String stopChequePaymentAPI(Long accountNo, Long chequeNo, String chequeStatus);

}
