package com.hdfc.service;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.hdfc.dto.CustIdMobile;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Component
public class CustIdSmsService {

	private final String ACCOUNT_SID = "ACa485982145ebad4388def40ebe8d1196";
	private final String AUTH_TOKEN = "de048d395cac56682f8a7cd1cdac5093";
	private final String FROM_NUMBER = "+14344784236";
	
	public Long sendCustomerId(CustIdMobile sms) {
	
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	
	Long customerID = sms.getCustId();
	
	System.out.println("customer id: "+customerID);
	String msg = "Your forgot Customer Id is: "+customerID;
	System.out.println("sent message: "+msg);
	Message message = Message.creator(new PhoneNumber(sms.getCustMobileNO()), new PhoneNumber(FROM_NUMBER), msg)
            .create();
	System.out.println("OTP is: "+msg);
	System.out.println("here is my id:"+message.getSid());
	//StoreOTP.setOtp(customerID);
	return customerID;
}
	public void receive(MultiValueMap<String, String> smscallback) {
		
	}
	
}