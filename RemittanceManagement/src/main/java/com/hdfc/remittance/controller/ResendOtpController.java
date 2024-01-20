package com.hdfc.remittance.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.remittance.dto.SmsPojo;
import com.hdfc.remittance.service.PayeeService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ResendOtpController {

	@Autowired
	private PayeeService payeeService;

	@GetMapping("/resendOtp")
	public ResponseEntity<String> reSendOTP() throws ParseException {

		SmsPojo mobileNo = new SmsPojo();
		mobileNo.setPhoneNo("+919984133833");
		System.err.println("mobile No :" + mobileNo);
		payeeService.createOtp(mobileNo);
		return new ResponseEntity<String>("OTP sent successfully...", HttpStatus.OK);
	}
}
