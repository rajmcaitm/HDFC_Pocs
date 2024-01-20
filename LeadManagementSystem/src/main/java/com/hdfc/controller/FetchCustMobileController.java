package com.hdfc.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hdfc.dto.Customer;
import com.hdfc.dto.SmsPojo;
import com.hdfc.service.MobileService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FetchCustMobileController {
	
	@Autowired
	private MobileService mobileService;

	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/sendOtp")
	public ResponseEntity<String> getCustMobileNo(@RequestBody Customer customer) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		SmsPojo custMobileNo = mobileService.getCustomerMobileNo(customer);
		
		System.err.println("test :" +custMobileNo);
		HttpEntity<SmsPojo> entity = new HttpEntity<SmsPojo>(custMobileNo, headers);

		ResponseEntity<String> res = restTemplate.exchange("http://localhost:3333/createOtp", HttpMethod.POST, entity, String.class);
		return  res;
	}

}
