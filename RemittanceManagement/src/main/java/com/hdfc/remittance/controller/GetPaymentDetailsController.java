package com.hdfc.remittance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.remittance.dto.PaymentDetailsResponse;
import com.hdfc.remittance.service.GetPaymentDetailsService;

@RestController
public class GetPaymentDetailsController {
	@Autowired
	GetPaymentDetailsService getPaymentDetailsService;

	@GetMapping("paymentdetails/{custId}/{currency}")
	public ResponseEntity<?> getPaymentDetails(@PathVariable Long custId, @PathVariable String currency) {
		List<String> listacc = getPaymentDetailsService.getListAccPaymentDetailsService(custId, currency);
		return new ResponseEntity<>(listacc, HttpStatus.OK);
	}

	@GetMapping("getBalance/{accNum}/{currency}")
	public ResponseEntity<?> getPaymentDetails(@PathVariable String accNum, @PathVariable String currency) {
		PaymentDetailsResponse pdr = getPaymentDetailsService.getPaymentDetailsService(accNum, currency);
		return new ResponseEntity<>(pdr, HttpStatus.OK);
	}

}
