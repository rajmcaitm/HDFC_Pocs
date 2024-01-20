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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.dto.CustIdMobile;
import com.hdfc.service.CustIdSmsService;
import com.twilio.exception.ApiException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SmsCustomerIdController {

	    @Autowired
	    CustIdSmsService custIdSmsService;

	    @Autowired
	    private SimpMessagingTemplate webSocket;

	    private final String  TOPIC_DESTINATION = "/lession/sms";

		@RequestMapping(value = "/custIdOtp", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> createOtp(@RequestBody CustIdMobile sms) throws ParseException {
			
			String message = null;
			try {
			System.err.println("testing : " + sms);
			message = "Customer Id sent successfully and sent Customer Id is-" + custIdSmsService.sendCustomerId(sms);
			} catch (ApiException e) {

				webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": Error sending the SMS: " + e.getMessage());
				throw e;
			}
			//service.sendCustomerId(sms);
			webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": SMS has been sent!: " + sms.getCustMobileNO());
			return new ResponseEntity<String>(message, HttpStatus.CREATED);

		}
		
		private String getTimeStamp() {
			return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
		}
   }


