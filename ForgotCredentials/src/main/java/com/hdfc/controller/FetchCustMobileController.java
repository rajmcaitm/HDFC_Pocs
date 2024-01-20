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

import com.hdfc.dto.CustIdMobile;
import com.hdfc.dto.Customer;
import com.hdfc.dto.CustomerDetails;
import com.hdfc.dto.DebitCard;
import com.hdfc.dto.MobileCardNoPin;
import com.hdfc.dto.SmsPojo;
import com.hdfc.exception.CradNoMobileNoNotMatch;
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

		ResponseEntity<String> res = restTemplate.exchange("http://localhost:9999/createOtp", HttpMethod.POST, entity, String.class);
		return  res;
	}
	
	@PostMapping("/forgotLoginIdOtp")
	public ResponseEntity<String> sendOtp(@RequestBody DebitCard card) throws CradNoMobileNoNotMatch {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		MobileCardNoPin custMobileNo = mobileService.sendOtp(card);
		
		System.err.println("test :" +custMobileNo);
		SmsPojo mobileNo = new SmsPojo();
		mobileNo.setPhoneNo(custMobileNo.getMobileNo());
		
		if (card.getDebitCardNo().equals(custMobileNo.getDebitCardNo()) && card.getDebitCardPin().equals(custMobileNo.getDebitCardPin())) {
			
			HttpEntity<SmsPojo> entity = new HttpEntity<SmsPojo>(mobileNo, headers);
			ResponseEntity<String> res = restTemplate.exchange("http://localhost:9999/createOtp", HttpMethod.POST, entity, String.class);
			
			return res;
		}else {
			throw new CradNoMobileNoNotMatch("Debit Card Number or PIN did not correct");
		}
	}
	
	@PostMapping("/customerId")
	public ResponseEntity<String> returnCustId(@RequestBody CustomerDetails customerDetails)
			throws CradNoMobileNoNotMatch {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		CustIdMobile custIdMobile = mobileService.getCustomerId(customerDetails);
		System.out.println("hi: " + custIdMobile.getCustId() + "  :  " + custIdMobile.getCustMobileNO());
		CustIdMobile custIdMobileNo = new CustIdMobile();
		custIdMobileNo.setCustMobileNO(custIdMobile.getCustMobileNO());
		custIdMobileNo.setCustId(custIdMobile.getCustId());

		if (customerDetails.getDebitCardNo().equals(custIdMobile.getCardNo())
				&& customerDetails.getDebitCardPin().equals(custIdMobile.getCardPin())) {

			HttpEntity<CustIdMobile> entity = new HttpEntity<CustIdMobile>(custIdMobileNo, headers);
			ResponseEntity<String> result = restTemplate.exchange("http://localhost:9999/custIdOtp", HttpMethod.POST,
					entity, String.class);
			return result;
		} else {
			throw new CradNoMobileNoNotMatch("Debit Card Number or PIN did not correct");
		}
	}
}
