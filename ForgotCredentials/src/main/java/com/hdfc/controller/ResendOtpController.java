package com.hdfc.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hdfc.dto.SmsPojo;
import com.hdfc.service.MobileService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ResendOtpController {
	
	
	@Autowired
	private MobileService mobileService;

	@Autowired
	RestTemplate restTemplate; 
	
	@GetMapping("/resendOtp")
	public ResponseEntity<String> getCustMobileNo() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		SmsPojo custMobileNo = new SmsPojo();
		custMobileNo.setPhoneNo("+919984133833");
		
		System.err.println("test :" +custMobileNo);
		HttpEntity<SmsPojo> entity = new HttpEntity<SmsPojo>(custMobileNo, headers);

		ResponseEntity<String> res = restTemplate.exchange("http://localhost:9999/createOtp", HttpMethod.POST, entity, String.class);
		return  res;
	}
	
	@PostMapping("/reSendOtp")
	public String resendOtp() {
	    return "redirect:/forgotLoginIdOtp";
	}
	
}