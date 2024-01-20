package com.hdfc.service;

import com.hdfc.entities.DebitCard;

public interface DebitCardService {
	
	DebitCard saveDebitCradHotListDetails(DebitCard debitCard);
	
	void sendOTP(String detbitCardNo);

}
