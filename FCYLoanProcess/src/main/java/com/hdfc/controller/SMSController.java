package com.hdfc.controller;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.dto.SmsPojo;
import com.hdfc.dto.StoreOTP;
import com.hdfc.dto.TempOTP;
import com.hdfc.service.SmsService;
import com.twilio.exception.ApiException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SMSController {

    @Autowired
    SmsService service;

    @Autowired
    private SimpMessagingTemplate webSocket;

    private final String  TOPIC_DESTINATION = "/lession/sms";

	@RequestMapping(value = "/createOtp", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createOtp(@RequestBody SmsPojo sms) throws ParseException {
		
		String message = null;
		try {
		System.err.println("testing : " + sms);
		message = "OTP sent successfully and sent OTP is-" + service.send(sms);
		} catch (ApiException e) {

			webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": Error sending the SMS: " + e.getMessage());
			throw e;
		}
		//service.send(sms);
		webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": SMS has been sent!: " + sms.getPhoneNo());
		return new ResponseEntity<String>(message, HttpStatus.CREATED);

	}
/*
    @RequestMapping(value = "/smscallback", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void smsCallback(@RequestBody MultiValueMap<String, String> map) {
       service.receive(map);
       webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": Twilio has made a callback request! Here are the contents: "+map.toString());
    }
*/
    private String getTimeStamp() {
       return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }
    
	@PostMapping("/validateOtp")
	public String verifyOTP(@RequestBody TempOTP otp) {
		if (otp.getOtp() == StoreOTP.getOtp())
			return "Correct OTP";
		else
			return "Invalid OTP";

	}
	
}