package com.hdfc.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.dto.StoreOTP;
import com.hdfc.dto.TempOTP;
import com.hdfc.service.SendOTP;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ResendOtpController {

	@Autowired
	SendOTP sendOTP;

	@GetMapping("/resendOtp")
	public ResponseEntity<String> reSendOTP() throws ParseException {
		sendOTP.send("+919984133833");
		return new ResponseEntity<String>("OTP sent successfully...", HttpStatus.OK);
	}
	
	@PostMapping("/validateOtp")
	public String verifyOTP(@RequestBody TempOTP otp) {
		if (otp.getOtp() == StoreOTP.getOtp())
			return "Correct OTP";
		else 
			return "Invalid OTP";
		}
	}

