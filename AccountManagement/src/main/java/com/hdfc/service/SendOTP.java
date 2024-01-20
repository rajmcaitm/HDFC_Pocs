package com.hdfc.service;

import org.springframework.stereotype.Service;

import com.hdfc.dto.StoreOTP;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SendOTP {

	private static final String ACCOUNT_SID = "AC676d58bf80cf7de080c9e158b88e033b";
	private static final String AUTH_TOKEN = "77f441ffb2b555015f965fb84202455e";
	private static final String FROM_NUMBER = "+13613154980";
	

	  public void send(String to) {
	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	    String msg = "Dear Customer, " + generateOTP()+ " is your SECRET OTP(One Time Password). Do not share it with anyone.";
	    Message message = Message.creator(new com.twilio.type.PhoneNumber(to), new com.twilio.type.PhoneNumber(FROM_NUMBER), msg).create();
	    StoreOTP.setOtp(Integer.parseInt(msg.replaceAll("[^0-9]", "")));
	    System.out.println(message.getSid());
	  }
	  
	  public void sendBalanceAsOTP(String to, Float balance) {
		    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		    Message message = Message.creator(new com.twilio.type.PhoneNumber(to), new com.twilio.type.PhoneNumber(FROM_NUMBER), "Dear Customer, Your current balance is INR. "+balance).create();
		    System.out.println(message.getSid());
		  }
	  
		public int generateOTP() {
			
			int min = 100000;
			int max = 999999;
			int num = (int) (Math.random() * (max - min + 1) + min);
			return num;
		}
	  
	}


