package com.hdfc.whatsapp;

import java.net.URI;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.repository.AccountNumberRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SendWhatsAppMessage {
	
	@Autowired
	AccountNumberRepository accountNumberRepository;

	private final String ACCOUNT_SID = "AC33bbeb716cbcc335b2ba9e046929d242";
	private final String AUTH_TOKEN = "054cf2d53a267788deff81c0e01b32d1";
	private final String FROM_NUMBER = "whatsapp:+14155238886";

	public void sendWhatsAppMessage(Long accountNo) {

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		
		Message message = Message
				.creator(new com.twilio.type.PhoneNumber(getMobileNumber(accountNo)),
						new com.twilio.type.PhoneNumber(FROM_NUMBER), "Here is your Mini Statement...")
				.setMediaUrl(Arrays.asList(URI.create("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf")))
								
				.create();

		System.out.println("SID :"+message.getSid());
	}
	
	public String getMobileNumber(Long accNo) {
		return "whatsapp:+91" + String.valueOf(accountNumberRepository.getMobileNumberBasedOnAccountNo(accNo));

	}
}
