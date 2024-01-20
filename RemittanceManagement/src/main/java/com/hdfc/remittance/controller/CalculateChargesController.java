package com.hdfc.remittance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.remittance.dto.GetPayeeDetails;
import com.hdfc.remittance.entity.ChargesDetails;
import com.hdfc.remittance.entity.ChargesDetailsReq;
import com.hdfc.remittance.service.ChargesService;

@RestController
public class CalculateChargesController {

	@Autowired
	ChargesService chargesService;

	@PostMapping("/charges/{payeeAccNo}")
	public ResponseEntity<ChargesDetails> calculateCharges(@RequestBody ChargesDetailsReq ChargesDetailsReq, @PathVariable Long payeeAccNo) {
		ChargesDetails charges = chargesService.calculateCharges(ChargesDetailsReq, payeeAccNo);
		return new ResponseEntity<ChargesDetails>(charges, HttpStatus.OK);
	}
	
	@GetMapping("/payeeConfirmation/{payeeAccNo}/{custId}")
	public ResponseEntity<GetPayeeDetails> payeeConfirmation(@PathVariable Long payeeAccNo, @PathVariable Long custId) {
		GetPayeeDetails payeeDetails = chargesService.payeeConfirmation(payeeAccNo, custId);
		return new ResponseEntity<GetPayeeDetails>(payeeDetails, HttpStatus.OK);
	}

}
