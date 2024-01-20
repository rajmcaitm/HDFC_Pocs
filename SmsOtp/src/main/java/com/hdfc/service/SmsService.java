package com.hdfc.service;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.hdfc.dto.SmsPojo;
import com.hdfc.dto.StoreOTP;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Component
public class SmsService {

	private final String ACCOUNT_SID = "ACa485982145ebad4388def40ebe8d1196";
	private final String AUTH_TOKEN = "de048d395cac56682f8a7cd1cdac5093";
	private final String FROM_NUMBER = "+14344784236";
	
	public int send(SmsPojo sms) {
	
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	
	int min = 100000;
	int max = 999999;		
			
	int num = (int)(Math.random()*(max-min+1)+min);
	
	String msg = "Your reset password verification code is: "+num;
	Message message = Message.creator(new PhoneNumber(sms.getPhoneNo()), new PhoneNumber(FROM_NUMBER), msg)
            .create();
	System.out.println("OTP is: "+msg);
	System.out.println("here is my id:"+message.getSid());
	StoreOTP.setOtp(num);
	return num;
}
	public void receive(MultiValueMap<String, String> smscallback) {
		
	}
	
}