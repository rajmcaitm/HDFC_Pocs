package com.hdfc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.entities.DebitCard;
import com.hdfc.repository.DebitCardServiceRepository;
import com.hdfc.service.DebitCardService;
import com.hdfc.service.SendOTP;

@Service
public class DebitCardServiceImpl implements DebitCardService {
	
	@Autowired
	private DebitCardServiceRepository debitCardServiceRepository;
	
	@Autowired
	SendOTP sendOtp;

	@Override
	public DebitCard saveDebitCradHotListDetails(DebitCard debitCard) {
		return debitCardServiceRepository.save(debitCard);
	}

	@Override
	public void sendOTP(String detbitCardNo) {
		String mobileNo = "+91" + String.valueOf(debitCardServiceRepository.getMobileNo(detbitCardNo));
		sendOtp.send(mobileNo);
}

}
